(function($) {
	
	Class('Identification.application.Update',{
		init:function() {
			this.no = 0;
			this.companyNameAry = [];
			this.companyIdAry = [];
			this.equipmentAry = [];
			this.equipmentIdAry = [];
			this.initData();
			this.bindEvent();
			this.initCalendar();
		},
		
		initData: function() {
			var that = this;
			this.companyNameAry = $("#companySelect option").map(function(){return $(this).text();}).get();
			this.companyIdAry = $("#companySelect option").map(function(){return $(this).val();}).get();
			
			this.equipmentAry =  $("#equipmentInfoSelect option").map(function(){return $(this).text();}).get();
			this.equipmentIdAry = $("#equipmentInfoSelect option").map(function(){return $(this).val();}).get();
			
			
			identification.initCalendarYYYYByClass('form_year');	
			
	        $( ".equipment" ).autocomplete({
	              source: that.equipmentAry,
	              messages: {
	            	  noResults: '', 
	            	  results: function(){ 		            		  
	            	  }
	               }	              
	         });
			
			$(".deleteClass").each(function(index,elemet){
				var removeNo = $(this).attr("data-no");
				$(this).click(function() {
					//that.no = that.no -1;
					$("#tr" + removeNo).remove();
				});
			});			
		},
		
		initCalendar : function() {
			identification.initCalendarByClass('form_datetime','form_date','form_time');			
		},
		
		bindEvent: function() {
			var that = this;			
			$("#addApplicationDetailBtn").click(function() {
				that.equipmentAry = [];
				that.equipmentIdAry = [];
	            that.no = that.no +1 + $("#reportCountId").val();
	            var data = {  no : that.no};
	            var datas = {};
	        	identification.ajaxNoasync("/application/getApplicationData", null, "json", function(res) {
	        		datas = $.extend(data, res);
				});	
	        	
	        	for(var i = 0; i < (datas.equipments).length; i++) {
	        		that.equipmentAry.push((datas.equipments)[i].equipmentName);
	        		that.equipmentIdAry.push((datas.equipments)[i].equipmentNo);
	        	}


				$("#detailTemplate").tmpl(datas).appendTo( "#applicationDetailBody" );
				
				identification.initCalendarYYYYByClass('form_year');	
				
		        $( ".equipment" ).autocomplete({
		              source: that.equipmentAry,
		              messages: {
		            	  noResults: '', 
		            	  results: function(){ 		            		  
		            	  }
		               }	              
		         });
				
				$(".deleteClass").each(function(index,elemet){
					var removeNo = $(this).attr("data-no");
					$(this).click(function() {
						//that.no = that.no -1;
						$("#tr" + removeNo).remove();
					});
				});
				
			});	
			
			//申请保存
	        $("#saveApplicationBtn").click(function() {
	        	var saveData = that.getSaveData();
	        	
	        	//check save data
	        	
	     	   
	     	   if(saveData.application.companyNo == "") {
	     		   alert($("#companyLable").text() + ": " + $("#company").val() + "不存在！请核实或添加新的"+$("#companyLable").text());
	     		   return false;
	     	   }
	     	   
	     	   if(saveData.reports.length == 0) {
	     		   alert("请添加"+$("#equipmentTh").text() + "!");
	     		   return false;
	     	   }
	     	   
	     	   var reportCheckResult = "";
	     	   
	     	   for(var n = 0; n < saveData.reports.length; n++) {
	     		  if(saveData.reports[n].equipmentNo == "") {
		     		   if(reportCheckResult == "") {
		     			  reportCheckResult = saveData.reports[n].equipmentName;
		     		   }else {
		     			  reportCheckResult = reportCheckResult + ", " +  saveData.reports[n].equipmentName;
		     		   }
		     	   } 
	     	   }
	     	   
	     	   if(reportCheckResult != "") {
	     		   alert($("#equipmentTh").text() + ": " + reportCheckResult + "不存在！请核实或添加新的"+$("#equipmentTh").text());
                   return false;
	     	   }
	     	   
	     	   
	     	   
	     	   var checkExperts = "";
				identification.ajaxNoasync("/expert/checkExpertExistCompany", JSON.stringify(saveData), "json", function(res) {
					if(res && res.length > 0) {
						for(var i = 0; i < res.length; i++) {
							if(res[i].expertName != undefined) {
								checkExperts = checkExperts + res[i].expertName+",";
							}
							
						}
					}
				});		
				
				if(checkExperts != "") {
					if(confirm("专家"+checkExperts+"在"+$("#companyLable").text()+$("#company").val()+"工作是否要保存申请！")){
			        	
			        	identification.ajax("/application/update", JSON.stringify(saveData), "html", function(res) {
		    				$("#alertDiv").empty();
		    				$("#alertDiv").html(res);
						});	 
					}
				}else {
		        	identification.ajax("/application/update", JSON.stringify(saveData), "html", function(res) {
	    				$("#alertDiv").empty();
	    				$("#alertDiv").html(res);
					});	 
				}
      	
	        	
       	
	        });		
	        
        	
	        //申请文件上传
        	identification.fileUpload("/application/requestFileUpload","requestFileupload", "requsetFileNameSpan", "requsetFileIdHid");	  
	        
	        //结论文件
        	identification.fileUpload("/application/requestFileUpload","resultFileupload", "resultFileNameSpan", "resultFileIdHid");	  
	        
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
    	   var app ={};
    	   app.application = {};
    	   var rep = {};
    	   rep = {};
    	   rep.reports = [];
    	   

    	   //application
    	   app.application.applicationDate = $("#applicationDate").val();
    	   app.application.companyNo = this.getSelectId($.trim($("#company").val()), this.companyNameAry, this.companyIdAry); 
    	   app.application.department = $("#department").val();
    	   app.application.appFileName = $("#requsetFileNameSpan").text(); 
    	   app.application.appFileNo = $("#requsetFileIdHid").val(); 
    	   app.application.resultFileName = $("#resultFileNameSpan").text(); 
    	   app.application.resultFileNo = $("#resultFileIdHid").val(); 
    	   app.application.resultFileNo = $("#resultFileIdHid").val();
    	   
    	   app.application.leaderNo = $("#leaderNo").val(); 
    	   app.application.expertsNo = $("#expertsNo").val(); 
    	   
    	   app.application.applicationNo = $("#applicationId").val(); 
    	   
    	   //reports
    	   $(".addTr").each(function(i,element) {
    		   var i = $(this).attr("data-no");
    		   
    		   var report = {};
    		   report.equipmentNo = that.getSelectId($.trim($("#equipment" + i).val()), that.equipmentAry, that.equipmentIdAry);
    		   report.equipmentName = $("#equipment" + i).val();
    		   report.repairLevel = $("#repairLevel" + i).val();
    		   report.expertsNo = app.application.expertsNo;
    		   report.leaderNo = app.application.leaderNo;
    		   report.result = $("input[name='" + "result" + i +"']:checked").val(); 
    		   report.isReform =  $("input[name='" + "isReform" + i +"']:checked").val(); 
    		   report.timeLimit = $("#timeLimit" + i).val();
    		   report.remark = $("#remark" + i).val();
    		   rep.reports.push(report);   		   
    		   
    	   }); 
    	 
    	  return $.extend(app, rep);
  
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