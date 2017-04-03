(function($) {
	Class('Identification.application.Add',{
		init:function() {
			this.no = 0;
			this.bindEvent();
			this.initCalendar();
		},
		
	
		
		initCalendar : function() {
		    $('.form_datetime').datetimepicker({
		        language:  'zh-CN',
		        weekStart: 1,
		        todayBtn:  1,
				autoclose: 1,
				todayHighlight: 1,
				startView: 2,
				forceParse: 0,
		        showMeridian: 1
		    });
			$('.form_date').datetimepicker({
		        language:  'zh-CN',
		        weekStart: 1,
		        todayBtn:  1,
				autoclose: 1,
				todayHighlight: 1,
				startView: 2,
				minView: 2,
				forceParse: 0
		    });
			$('.form_time').datetimepicker({
		        language:  'zh-CN',
		        weekStart: 1,
		        todayBtn:  1,
				autoclose: 1,
				todayHighlight: 1,
				startView: 1,
				minView: 0,
				maxView: 1,
				forceParse: 0
		    });
						
		},
		
		bindEvent: function() {
			var that = this;			
			$("#addApplicationDetailBtn").click(function() {
	            that.no = that.no +1;
	            var data = {  no : that.no};
	            var datas = {};
	        	identification.ajaxNoasync("/application/getApplicationData", null, "json", function(res) {
	        		datas = $.extend(data, res);
				});	         	

				$("#detailTemplate").tmpl(datas).appendTo( "#applicationDetailBody" );
				
				that.initCalendar();
				
				$(".deleteClass").each(function(index,elemet){
					var removeNo = $(this).attr("data-no");
					$(this).click(function() {
						that.no = that.no -1;
						$("#tr" + removeNo).remove();
					});
				});
				
			});	
			
			//申请保存
	        $("#saveApplicationBtn").click(function() {
	        	var saveData = that.getSaveData();
	        	identification.ajax("/application/add", JSON.stringify(saveData), "html", function(res) {
    				$("#alertDiv").empty();
    				$("#alertDiv").html(res);
				});	        	
	        });		
	        
	       
		},
		
       getSaveData : function() {
    	   var app ={};
    	   app.application = {};
    	   var rep = {};
    	   rep = {};
    	   rep.reports = [];
    	   
    	   //application
    	   app.application.applicationDate = $("#applicationDate").val();
    	   app.application.companyNo = $("#company").val(); 
    	   app.application.department = $("#department").val();
    	   
    	   //reports
    	   $(".addTr").each(function(i,element) {
    		   var i = $(this).attr("data-no");
    		   console.log(i);
    		   var report = {};
    		   report.equipmentNo = $("#equipment" + i).val();
    		   report.repairLevel = $("#repairLevel" + i).val();
    		   report.expertsNo = $("#expert" + i).val();
    		   report.result = $("input[name='" + "result" + i +"']:checked").val(); 
    		   report.isReform =  $("input[name='" + "isReform" + i +"']:checked").val(); 
    		   report.timeLimit = $("#timeLimit" + i).val();
    		   report.remark = $("#remark" + i).val();
    		   rep.reports.push(report);   		   
    		   
    	   }); 
    	   
    	  return $.extend(app, rep);
  
       } 
		
	});
 
})(jQuery);	