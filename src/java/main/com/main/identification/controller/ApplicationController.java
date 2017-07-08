package com.main.identification.controller;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.security.Principal;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;

import org.apache.commons.io.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.main.identification.model.Application;
import com.main.identification.model.ApplicationAddModel;
import com.main.identification.model.ApplicationDetailModel;
import com.main.identification.model.ApplicationRequstModel;
import com.main.identification.model.ApplicationResult;
import com.main.identification.model.Company;
import com.main.identification.model.ConstantModel;
import com.main.identification.model.EquipmentModel;
import com.main.identification.model.Expert;
import com.main.identification.model.Report;
import com.main.identification.model.UploadFileBaseModel;
import com.main.identification.service.ApplicationService;
import com.main.identification.service.CompanyService;
import com.main.identification.service.ConstantService;
import com.main.identification.service.EquipmentService;
import com.main.identification.service.ExpertService;
import com.main.identification.service.ReportService;
import com.main.identification.service.UploadFileService;
import com.main.identification.utils.Constant;
import com.main.identification.utils.PageUtil;
import com.mongodb.gridfs.GridFSDBFile;

/**
 * 申请信息管理controller
 * 
 * @author yangqi
 * @createtime 2017-03-19
 */
@Controller
@RequestMapping("/application")
public class ApplicationController {
	@Autowired
	public ApplicationService applicationBo;
	
	@Autowired
	public ExpertService expertBo;
	
	@Autowired
	public EquipmentService equipmentService;
	
	@Autowired
	public ConstantService constantService;
	
	@Autowired
	public CompanyService companyService;
	
	@Autowired
	public UploadFileService uploadFileService;
	
	@Autowired
	public ReportService reportService;
	
	@RequestMapping("/init")
	public String init(Model model, Principal principal) {
		
		//取得修理级别
		ConstantModel constant = new ConstantModel();
		constant.setConstantType(Constant.REPAIR_LEVEL);
		List<ConstantModel> repairLevelList = constantService.findConstantList(constant);
		model.addAttribute("repairLevels", repairLevelList);
		model.addAttribute("page",  "1");
		model.addAttribute("totalPage",  "1");
		
		return "/application/search";
	}

	@RequestMapping(value ="/searchList")
	public String getApplicationList(Model model,@RequestBody ApplicationResult application) {
		
		application.setStartNo(PageUtil.getStartNo(application.getPage(), Constant.PAGE_SIZE));
		application.setPageSize(Constant.PAGE_SIZE);
		// 设定专家姓名检索条件
		this.setExpertNameCon(application);
		int totalCount = applicationBo.selectApplicationResultCount(application);
		model.addAttribute("totalPage", PageUtil.getTotalPage(totalCount, Constant.PAGE_SIZE));
		model.addAttribute("pageSize", Constant.PAGE_SIZE);
		model.addAttribute("page", application.getPage());
		model.addAttribute("totalCount", totalCount);
		model.addAttribute("applicationResultList", applicationBo.searchList(application));
		
		return "application/list";
	}
	
	/**
	 * 设定专家姓名检索条件
	 * @param applyCondition
	 * @return 设定后的检索条件
	 */
	private ApplicationResult setExpertNameCon(ApplicationResult applyCondition){
		if(applyCondition.getExpertNameCon().isEmpty()){
			return applyCondition;
		}
		
		String expertNameConSql = "";
		
		Expert expertCon = new Expert();
		expertCon.setExpertName("%"+applyCondition.getExpertNameCon()+"%");
		// 根据专家姓名取得专家List
		List<Expert> expertList = expertBo.selectExpert(expertCon);
		
		for(Expert expert:expertList){
			expertNameConSql = expertNameConSql.concat(" or report.LEADER_NO = '"+expert.getExpertNo()+"'");
			expertNameConSql = expertNameConSql.concat(" or report.EXPERTS_NO like '%;"+expert.getExpertNo()+";%'");
		}
		
		if(!expertNameConSql.isEmpty()){
			// 去掉第一个[ or ]
			applyCondition.setExpertNameCon(expertNameConSql.substring(4, expertNameConSql.length()));
		} else {
			applyCondition.setExpertNameCon(" 1=2 ");
		}
		return applyCondition;
	}
	
	@RequestMapping("/addInit")
	public String addInit(Model model) {
		initApplicationModifyInfo(model);

		return "/application/add";
	}
	
	@ResponseBody
	@RequestMapping("/getApplicationData")
	public ApplicationRequstModel getApplicationData(Model model) {
		ApplicationRequstModel  result = new ApplicationRequstModel();
		
		//取得设备List
		List<EquipmentModel> equipmentList = equipmentService.findEquipmentList(new EquipmentModel());
		
		//取得修理级别
		ConstantModel constant = new ConstantModel();
		constant.setConstantType(Constant.REPAIR_LEVEL);
		List<ConstantModel> repairLevelList = constantService.findConstantList(constant);
		
		result.setEquipments(equipmentList);
		result.setRepairLevels(repairLevelList);
		
		return result;
	}
	
	@RequestMapping("/add")
	public String init(Model model, @RequestBody ApplicationAddModel applicationAddModel) {
		int result = applicationBo.addApplicationInfo(applicationAddModel);
		
		 if(result > 0) {
			 model.addAttribute("msg", "插入成功!");
		 }else {
			 model.addAttribute("msg", "插入失败!"); 
		 }
		 
		 model.addAttribute("url", "application/init"); 
		 
		return "common/alert";
	}
	
	@ResponseBody
	@RequestMapping("/requestFileUpload")
	public Map<String, String> requestFileUpload(Model model, UploadFileBaseModel uploadFile, HttpServletResponse httpResponse) throws IOException {
		MultipartFile file = uploadFile.getFile();
		Map<String, String> response =  new HashMap<String, String>();
		
		if(file.isEmpty()) {
			response.put("message", "文件为空！");
			return response;
		}	
		
		try(InputStream fileStream = file.getInputStream();){
			String fileId = uploadFileService.save(fileStream, file.getContentType(), file.getOriginalFilename());
			
			GridFSDBFile document = uploadFileService.get(fileId);
			
			response.put("fileName", file.getOriginalFilename());
			response.put("fileId", document.getId().toString());
			
			//document.writeTo(new File("/Users/dev/"+file.getOriginalFilename()));	
			//System.out.println("qqqq");
			
			return response;
			
		 }catch(IOException e){
			 throw e;
		}
	}
	
	@RequestMapping("/fileDownload/{id}")
	public void init(@PathVariable String id, HttpServletResponse response) throws IOException {
		GridFSDBFile document = uploadFileService.get(id);
		 
		try(OutputStream os = response.getOutputStream()) {
		    response.reset();  
		    response.setHeader("Content-Disposition", "attachment; filename=\"" + new String(document.getFilename().getBytes("utf-8"), "ISO8859-1") + "\"");  
		    response.addHeader("Content-Length", "" + document.getLength());  
		    response.setContentType("application/octet-stream;charset=UTF-8"); 

			 byte[] fileByte =	IOUtils.toByteArray(document.getInputStream());
			 os.write(fileByte);
			 os.flush();  
			 os.close();  
		}catch(IOException e){
			 throw e;
		}
	}
	
	@RequestMapping("/updateInit/{id}")
	public String updateInit(Model model,@PathVariable String id) {
		ApplicationAddModel app = applicationBo.selectApplicationInfoByNo(id);
		model.addAttribute("app", app.getApplication());
		model.addAttribute("reports", app.getReports());
		
		initApplicationModifyInfo(model);
		return "/application/update";
	}	
	
	@RequestMapping("/update")
	public String updateApplication(Model model, @RequestBody ApplicationAddModel applicationAddModel) {
		int result = applicationBo.updateApplicationInfo(applicationAddModel);
		
		 if(result > 0) {
			 model.addAttribute("msg", "修改成功!");
		 }else {
			 model.addAttribute("msg", "修改失败!"); 
		 }
		 
		 model.addAttribute("url", "application/init"); 
		 
		return "common/alert";
	}
	
	@RequestMapping("/detailInit")
	public String detailInit(Model model) {
//		Company company = new Company();
//		company.setCompanyType(Constant.COMPANY_FACTORY_TYPE);
//        model.addAttribute("companys", companyService.findCompanyList(company));
		
		return "/application/detail";
	}

	// 根据申请编号，取得申请详情
	@ResponseBody
	@RequestMapping("/getDetail")
	public Map<String,Object> getDetail(Model model,@RequestBody String applicationNo) {
		Map<String,Object> result = new HashMap<>();
		
		ApplicationDetailModel appDetail = applicationBo.selectAppDetail(applicationNo);
		
		result.put("companyDetail", appDetail.getCompany());
		result.put("expertsDetailList", appDetail.getExperts());
		result.put("equipsDetailList", appDetail.getEquipments());
		return result;
	}
	
	@RequestMapping("/delete")
	public String delete(Model model, @RequestBody Report report) {
		report.setReportNo(report.getReportNo());
		report.setApplicationNo(report.getApplicationNo());
		report.setLastModifyBy("-1");// TODO
		
		// 执行删除
		int reportResult = -1;
		reportResult = reportService.deleteUpdateReport(report);
		
		Application apply = new Application();
		apply.setApplicationNo(report.getApplicationNo());
		apply.setLastModifyBy("-1");// TODO
		int applyDelResult = -1;
		applyDelResult = applicationBo.deleteUpdateApply(apply);

		if (reportResult > 0 && applyDelResult > 0) {
//		if (reportResult > 0) {
			model.addAttribute("msg", "【申请信息】以及【结果信息】删除成功!");
		} else {
			model.addAttribute("msg", "【申请信息】以及【结果信息】删除失败!");
		}

		model.addAttribute("url", "application/init");
		
		return "common/alert";
	}
	
	private void initApplicationModifyInfo(Model model) {
		Company company = new Company();
		company.setCompanyType(Constant.COMPANY_FACTORY_TYPE);
        model.addAttribute("companys", companyService.findCompanyList(company));
        
		//取得设备List
		List<EquipmentModel> equipmentList = equipmentService.findEquipmentList(new EquipmentModel());
		
		//取得修理级别
		ConstantModel constant = new ConstantModel();
		constant.setConstantType(Constant.REPAIR_LEVEL);
		List<ConstantModel> repairLevelList = constantService.findConstantList(constant);
		
		model.addAttribute("equipments", equipmentList);
		model.addAttribute("repairLevels", repairLevelList);
        
		//取得专家List
		Expert expertCon = new Expert();
		List<Expert> expertList = expertBo.selectExpert(expertCon);
		model.addAttribute("experts", expertList);
	}
}
