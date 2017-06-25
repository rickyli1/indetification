package com.main.identification.controller;

import java.security.Principal;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.main.identification.model.ConstantModel;
import com.main.identification.service.CommonService;
import com.main.identification.service.ConstantService;
import com.main.identification.utils.Constant;
import com.main.identification.utils.PageUtil;

@Controller
@RequestMapping("/constant")
public class ConstantController {
	
	@Autowired
	public CommonService commonService;
	
	@Autowired
	public ConstantService constantService;
	
	@RequestMapping("/init")
	public String init(Model model, Principal principal) {
		
		ConstantModel constantModel = new ConstantModel();
        constantModel.setConstantType(Constant.PARENT_TYPE);
        model.addAttribute("constants", constantService.findConstantList(constantModel));
        model.addAttribute("page",  "1");
		model.addAttribute("totalPage",  "1");
        return "/constant/search";
	}

	@RequestMapping(value ="/searchList")
	public String getConstantList(Model model,@RequestBody ConstantModel constant) {
		
		constant.setStartNo(PageUtil.getStartNo(constant.getPage(), 30));
		constant.setPageSize(30);
		int totalCount = constantService.searchConstantCount(constant);
		model.addAttribute("totalPage", PageUtil.getTotalPage(totalCount, 30));
		model.addAttribute("pageSize", "30");
		model.addAttribute("page", constant.getPage());
		model.addAttribute("totalCount", totalCount);
		model.addAttribute("constantResultList", constantService.searchConstantList(constant));
		
		return "constant/list";
	}
	
	@RequestMapping("/addInit")
	public String addInit(Model model) {
		
		ConstantModel constantModel = new ConstantModel();
        constantModel.setConstantType(Constant.PARENT_TYPE);
        model.addAttribute("constants", constantService.findConstantList(constantModel));
		return "/constant/add";
	}
	
	@RequestMapping("/add")
	public String init(Model model, @RequestBody ConstantModel constant) {
		ConstantModel constantModel = new ConstantModel();
		model.addAttribute("url", "constant/init");
		if(constant.getConstantType() != "" && constant.getConstantName() != ""){
			constantModel.setConstantType(constant.getConstantType());
			constantModel.setConstantName(constant.getConstantName());
		}else{
			model.addAttribute("msg", "请输入常量类型和常量名!");
			model.addAttribute("url", "constant/addInit");
			return "common/alert";
		}
		
		if(Constant.CHILDREN_TYPE.equals(constant.getConstantType()) && constant.getParentNo() == ""){
			model.addAttribute("msg", "请选择父节点!");
			model.addAttribute("url", "constant/addInit");
			return "common/alert";
		}
	
		int count = constantService.searchConstantCountForAdd(constantModel);
		if (count > 0) {
			model.addAttribute("msg", "信息已经存在!");
			model.addAttribute("url", "constant/addInit");
			return "common/alert";
		} 
		constantModel = constant;
		String constantNo;
		if(Constant.CHILDREN_TYPE.equals(constant.getConstantType())){
			constantNo = String.valueOf(commonService.createSequenceId(Constant.CHILDREN_SEQ));
		}else{
			constantNo = String.valueOf(commonService.createSequenceId(Constant.PARENT_SEQ));
		}
		constantModel.setConstantNo(constantModel.getConstantType() + constantNo);
		constantModel.setCreateBy("-1");
		constantModel.setLastModifyBy("-1");
		int result = constantService.addConstantModel(constantModel);

		if (result > 0) {
			model.addAttribute("msg", "新增成功!");
		} else {
			model.addAttribute("msg", "新增失败!");
			model.addAttribute("url", "constant/addInit");
		}

		return "common/alert";
	}
	
	@RequestMapping("/delete")
	public String delete(Model model, @RequestBody ConstantModel constant) {
		ConstantModel constantModel = new ConstantModel();
		constantModel = constant;
		if("专业".equals(constant.getConstantType())){
			constantModel.setConstantType("P_TYPE");
		}else if ("子专业".equals(constant.getConstantType())){
			constantModel.setConstantType("C_TYPE");
		}else if("检修级别".equals(constant.getConstantType())){
			constantModel.setConstantType("REPAIR_LEVEL");
		}
		constantModel.setLastModifyBy("-1");
		List<ConstantModel> constantModelList =new ArrayList<ConstantModel>();
		constantModelList.add(constantModel);
		// 执行删除
		int result = -1;
		result = constantService.deleteConstantList(constantModelList);

		if (result > 0) {
			model.addAttribute("msg", "删除单位成功!");
		} else {
			model.addAttribute("msg", "删除单位失败!");
		}

		model.addAttribute("url", "constant/init");

		return "common/alert";
	}
	
	@ResponseBody
	@RequestMapping("/getDetail")
	public ConstantModel getDetail(Model model,@RequestBody ConstantModel constantModel) {
		if("专业".equals(constantModel.getConstantType())){
			constantModel.setConstantType("P_TYPE");
		}else if ("子专业".equals(constantModel.getConstantType())){
			constantModel.setConstantType("C_TYPE");
		}else if("检修级别".equals(constantModel.getConstantType())){
			constantModel.setConstantType("REPAIR_LEVEL");
		}
		List<ConstantModel> list = constantService.searchConstant(constantModel);
		ConstantModel constantModel1 = new ConstantModel();
		constantModel1.setConstantType(Constant.PARENT_TYPE);
        model.addAttribute("constants", constantService.findConstantList(constantModel1));
		return list.get(0);
	}
	
	@RequestMapping("/update")
	public String update(Model model, @RequestBody ConstantModel constantModel) {

		int result = constantService.updateConstant(constantModel);
		if (result > 0) {
			model.addAttribute("msg", "常量单位成功!");
		} else {
			model.addAttribute("msg", "常量单位失败!");
		}

		model.addAttribute("url", "constant/init");

		return "common/alert";
	}
	
}
