(function($) {
	
	Class('Identification.expert.Modify',{
		
		init:function() {
			this.companyNameAry = [];
			this.companyIdAry = [];
//			this.initData();
			this.bindEvent();
		},
		
//		initData: function() {
//			this.companyNameAry = $("#modifyCompanySelect option").map(function(){return $(this).text();}).get();
//			this.companyIdAry = $("#modifyCompanySelect option").map(function(){return $(this).val();}).get();
//		},
		
		bindEvent:function() {
			var that = this;
////			that.goPage();
			// 点击保存事件
			$("#modifyExpertBtn").click(function() {
	        	var saveData = that.getSaveData();
	        	
	        	//check save data
//	     	   if(saveData.companyNo == "") {
//	     		   alert($("#companyLable").text() + ": " + $("#company").val() + "不存在！请核实或添加新的"+$("#companyLable").text());
//	     		   return false;
//	     	   }
	     	   
	        	identification.ajax("/expert/modify", JSON.stringify(saveData), "html", function(res) {
    				$("#alertDiv").empty();
    				$("#alertDiv").html(res);
				});
			});
			
	        //申请单位
	        $("#modifyCompany").autocomplete({
	              source: that.companyNameAry,
	              messages: {
	            	  noResults: function(){ 
	            		  console.log(that.companyNameAry)
	            	  }, 
	            	  results: function(){ 
	            		  console.log(that.companyNameAry)
	            	  }
	               }	              
	         });
		},
		
		goPage:function(expertNo) {
			var that = this;
//			var param = {"page":$("#page").val(), "expertName":$("#chooseExpertName").val()};
//			var applicationNo = $("#applicationNoHidden").val();
			
			this.companyNameAry = $("#modifyCompanySelect option").map(function(){return $(this).text();}).get();
			this.companyIdAry = $("#modifyCompanySelect option").map(function(){return $(this).val();}).get();
			
			identification.ajaxNoasync("/expert/getDetail", expertNo, "json", function(res) {
				that.createModalBody(res); 
//				that.createPageOver(res);
			});			
		},
		
	    getSaveData : function() {
	    	var that = this;
	    	var expert ={};

	    	//expert
	    	expert.expertName = $("#modifyExpertName").val();
//	    	expert.companyNo = this.getSelectId($.trim($("#modifyCompany").val()),
//	    			$("#modifyCompanySelect option").map(function(){return $(this).text();}).get(), 
//	    			$("#modifyCompanySelect option").map(function(){return $(this).val();}).get());
	    	expert.companyNo = $("#modifyCompany").val(),
//	    	expert.companyNo = $("companyNoHide").val();//TODO
	    	expert.profession = $("#modifyProfession").val();
	    	expert.professionalTitle = $("#modifyProfessionalTitle").val();
	    	expert.remark = $("#modifyRemark").val();
	    	expert.expertNo = $("#expertNoHide").val();
	    	
	    	return expert;
	    },
		
		createModalBody:function(data) {
			
			$("#modifyExpertName").val(this.trimNull(data.expertName));
			$("#modifyProfession").val(this.trimNull(data.profession));
			$("#modifyCompany").val(this.trimNull(data.companyNo));
			$("#modifyProfessionalTitle").val(this.trimNull(data.professionalTitle));
			$("#modifyRemark").val(this.trimNull(data.remark));
			$("#expertNoHide").val(data.expertNo);
//			$("#companyNoHide").val(data.companyNo);//TODO
		},
		
	    getSelectId : function(name,  arrayName, arrayId) {
	    	var result = "";
	    	for(var i = 0; i < arrayName.length; i++) {
	    		if(arrayName[i] == name) {
	    			return arrayId[i];
	    		}
	    	}
	    	return result;
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