package com.main.identification.controller;

import java.security.Principal;
import java.util.List;

import org.apache.poi.util.StringUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.main.identification.model.ApplicationAddModel;
import com.main.identification.model.ApplicationResult;
import com.main.identification.model.Expert;
import com.main.identification.service.ApplicationService;
import com.main.identification.service.ExpertService;
import com.main.identification.utils.PageUtil;
import com.main.identification.utils.Constant;

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
	
	@RequestMapping("/init")
	public String init(Model model, Principal principal) {
		return "/application/search";
	}

	@RequestMapping(value ="/searchList")
	public String getApplicationList(Model model,@RequestBody ApplicationResult application) {
		// 设定专家姓名检索条件
		this.setExpertNameCon(application);
		
//		application.setPageSize(2);
//		application.setStartNo(PageUtil.getStartNo(application.getPage(), application.getPageSize()));
		
		model.addAttribute("totalCount", applicationBo.selectApplicationResultCount(application));
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
		
		return "/application/add";
	}
	
	@RequestMapping("/add")
	public String init(Model model, @RequestBody ApplicationAddModel applicationAddModel) {
		int result = applicationBo.addApplicationInfo(applicationAddModel);
		
		 if(result > 0) {
			 model.addAttribute("msg", "插入成功!");
		 }else {
			 model.addAttribute("msg", "插入失败!"); 
		 }
		 
		 model.addAttribute("url", "adminUser/init"); 
		 
		return "common/alert";
	}

}
