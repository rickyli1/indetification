(function($) {
	
	Class('Identification.application.Detail',{
		init:function() {
			this.bindEvent();
		},
		
		bindEvent:function() {
			var that = this;
////			that.goPage();
//			// TODO 测试代码
//			$("#testSearchBtn").click(function() {
//				that.goPage();
//			});
		},
		
		goPage:function() {
			var that = this;
//			var param = {"page":$("#page").val(), "expertName":$("#chooseExpertName").val()};
//			var applicationNo = $("#applicationNoHidden").val();
			identification.ajaxNoasync("/application/getDetail", $("#applicationNoHidden").val(), "json", function(res) {
				that.createModalBody(res); 
//				that.createPageOver(res);
			});			
		},
		
		createModalBody:function(data) {
			var compDetail = data.companyDetail;
			var expertsList = data.expertsDetailList;
			var equipsList = data.equipsDetailList;
			
			$("#detailCompanyName").text(this.trimNull(compDetail.companyName));
			$("#detailCompanyCode").text(this.trimNull(compDetail.companyCode));
			$("#detailApplicationDate").text(compDetail.applicationDate);
			$("#detailDepartment").text(this.trimNull(compDetail.department));
			
			$("#appFile").text(this.trimNull(compDetail.appFileName));
			$("#appFile").attr("href", "fileDownload/"+compDetail.appFileNo);
			$("#resultFile").text(this.trimNull(compDetail.resultFileName));
			$("#resultFile").attr("href", "fileDownload/"+compDetail.resultFileNo);

			// 专家信息List
			var expertsBody = $("#expertsBody");
			expertsBody.empty();

			for(var i = 0; i < expertsList.length; i++){
				var expertTR = $('<tr>');
				// 专家姓名
				var expertNameDetailTD = $('<td>');
				expertNameDetailTD.attr("id","nameTD"+expertsList[i].expertName);
				expertNameDetailTD.attr("data-expertName", expertsList[i].expertName);
				// 专家单位
				var expertCompanyDetailTD = $('<td>');
				expertCompanyDetailTD.attr("id","companyTD"+expertsList[i].companyName);
				expertCompanyDetailTD.attr("data-companyName", expertsList[i].companyName);
				// 担当角色
				var roleDetailTD = $('<td>');
				roleDetailTD.attr("id","roleTD"+expertsList[i].role);
				roleDetailTD.attr("data-role", expertsList[i].role);

				expertNameDetailTD.text(expertsList[i].expertName);
				expertCompanyDetailTD.text(this.trimNull(expertsList[i].companyName));
				roleDetailTD.text(expertsList[i].role);

				expertTR.append(expertNameDetailTD);
				expertTR.append(expertCompanyDetailTD);
				expertTR.append(roleDetailTD);

				expertsBody.append(expertTR);
			}
			// 设备信息List
			var equipmentsBody = $("#equipmentsBody");
			equipmentsBody.empty();
				
			for(var i = 0; i < equipsList.length; i++){
				var equipTR = $('<tr>');
				// 设备类别
				var groupNameTD = $('<td>');
				groupNameTD.attr("id","groupNameTD"+equipsList[i].groupName);
				groupNameTD.attr("data-groupName", equipsList[i].groupName);
				// 子类别
				var subGroupNameTD = $('<td>');
				subGroupNameTD.attr("id","subGroupNameTD"+equipsList[i].subGroupName);
				subGroupNameTD.attr("data-subGroupName", equipsList[i].subGroupName);
				// 设备名称
				var equipmentNameTD = $('<td>');
				equipmentNameTD.attr("id","equipmentNameTD"+equipsList[i].equipmentName);
				equipmentNameTD.attr("data-equipmentName", equipsList[i].equipmentName);
				// 修理级别
				var repairLevelTD = $('<td>');
				repairLevelTD.attr("id","repairLevelTD"+equipsList[i].repairLevel);
				repairLevelTD.attr("data-repairLevel", equipsList[i].repairLevel);
				// 结果
				var resultTD = $('<td>');
				resultTD.attr("id","resultTD"+equipsList[i].result);
				resultTD.attr("data-result", equipsList[i].result);
				// 是否整改
				var isReformTD = $('<td>');
				isReformTD.attr("id","isReformTD"+equipsList[i].isReform);
				isReformTD.attr("data-isReform", equipsList[i].isReform);
				// 有效期
				var timeLimitTD = $('<td>');
				timeLimitTD.attr("id","timeLimitTD"+equipsList[i].timeLimit);
				timeLimitTD.attr("data-timeLimit", equipsList[i].timeLimit);
				// 备注
				var remarkTD = $('<td>');
				remarkTD.attr("id","remarkTD"+equipsList[i].remark);
				remarkTD.attr("data-remark", equipsList[i].remark);
				
				groupNameTD.text(equipsList[i].groupName);
				subGroupNameTD.text(equipsList[i].subGroupName);
				equipmentNameTD.text(equipsList[i].equipmentName);
				
				if(equipsList[i].repairLevel == '1'){
					repairLevelTD.text('检修');
				} else if(equipsList[i].repairLevel == '2'){
					repairLevelTD.text('小修');
				} else if(equipsList[i].repairLevel == '3'){
					repairLevelTD.text('中修');
				} else if(equipsList[i].repairLevel == '4'){
					repairLevelTD.text('大修');
				}
				
				resultTD.text(equipsList[i].result);
				isReformTD.text(this.trimNull(equipsList[i].isReform));
				timeLimitTD.text(equipsList[i].timeLimit);
				remarkTD.text(equipsList[i].remark);
				
		        equipTR.append(groupNameTD);
		        equipTR.append(subGroupNameTD);
		        equipTR.append(equipmentNameTD);
		        equipTR.append(repairLevelTD);
		        equipTR.append(resultTD);
		        equipTR.append(isReformTD);
		        equipTR.append(timeLimitTD);
		        equipTR.append(remarkTD);
		         
				equipmentsBody.append(equipTR);
			}
		},
		
		trimNull:function(string){
			if(string == null){
				return '';
			}else{
				return string;
			}
		}
		
	});
 
})(jQuery);	