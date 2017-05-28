(function($) {
	
	Class('Identification.expert.Add',{
		init:function() {
			this.no = 0;
			this.companyNameAry = [];
			this.companyIdAry = [];

			this.initData();
			this.bindEvent();
		},
		
		initData: function() {
			this.companyNameAry = $("#companySelect option").map(function(){return $(this).text();}).get();
			this.companyIdAry = $("#companySelect option").map(function(){return $(this).val();}).get();
		},
		
		bindEvent: function() {
			var that = this;			

			//申请保存
	        $("#saveExpertBtn").click(function() {
	        	var saveData = that.getSaveData();
	        	
	           //check save data
	     	   if(saveData.companyNo == "") {
	     		   alert($("#companyLable").text() + ": " + $("#company").val() + "不存在！请核实或添加新的"+$("#companyLable").text());
	     		   return false;
	     	   }
	     	   
	           identification.ajax("/expert/add", JSON.stringify(saveData), "html", function(res) {
	        	   $("#alertDiv").empty();
	        	   $("#alertDiv").html(res);
	        	   identification.expert.searchList();
	           });
	           
//	           identification.expert.searchList();
	        });		
	        
	        //申请单位
	        $("#company").autocomplete({
	              source: that.companyNameAry,
	              messages: {
	            	  noResults: '', 
	            	  results: function(){ 
	            	  }
	               }	              
	         });
		},
		
       getSaveData : function() {
    	   var that = this;
    	   var expert ={};

    	   //expert
    	   expert.expertName = $("#expertName").val();
    	   expert.companyNo = this.getSelectId($.trim($("#company").val()), this.companyNameAry, this.companyIdAry);
    	   expert.profession = $("#profession").val();
    	   expert.professionalTitle = $("#professionalTitle").val();
    	   expert.remark = $("#remark").val();

    	  return expert;
       },
       
       getSelectId : function(name,  arrayName, arrayId) {
    	   var result = "";
    	   
    	   for(var i = 0; i < arrayName.length; i++) {
    		   if(arrayName[i] == name) {
    			   return arrayId[i];
    		   }
    	   }
    	   return result;
       }
		
	});
 
})(jQuery);	