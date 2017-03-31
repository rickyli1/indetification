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
	            console.log(that.no);
				var datas = {  no : that.no,
						       repairLevels:[
				                      {constantNo:"1",constantName:"专家1"},
				                      {constantNo:"2",constantName:"专家11"},
				                      {constantNo:"3",constantName:"专家111"}
				                      ],
		                      experts:[
				                      {expertNo:"1",expertName:"大修"},
				                      {expertNo:"2",expertName:"中修"},
				                      {expertNo:"3",expertName:"小修"}
				                   ],
				              equipments:[
					                      {equipmentNo:"1",equipmentName:"设备111111111111111"},
					                      {equipmentNo:"2",equipmentName:"设备1111111111uuu11111设备111111111111111"},
					                      {equipmentNo:"3",equipmentName:"设备lll1111111111"}
					                   ]						                   
				            };

				$("#detailTemplate").tmpl(datas).appendTo( "#applicationDetailBody" );
				
				that.initCalendar();
				
				$(".deleteClass").each(function(index,elemet){
					var removeNo = $(this).attr("data-no");
					$(this).click(function() {
						$("#tr" + removeNo).remove();
					});
				});
				
			});	
			
			//申请保存
	        $("#saveApplicationBtn").click(function() {
	        	var saveData = that.getSaveData();
	        	identification.ajax("/application/add", JSON.stringify(saveData), "html", function(res) {
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
    	   for(var i = 1; i <= this.no; i++) {
    		   var report = {};
    		   report.equipmentNo = $("#equipment" + i).val();
    		   report.repairLevel = $("#repairLevel" + i).val();
    		   report.expert = $("#expert" + i).val();
    		   report.result = $("input[name='" + "result" + i +"']:checked").val(); 
    		   report.isReform =  $("input[name='" + "isReform" + i +"']:checked").val(); 
    		   report.timeLimit = $("#timeLimit" + i).val();
    		   report.remark = $("#remark" + i).val();
    		   rep.reports.push(report);
    	   }
    	   
    	  return $.extend(app, rep);
  
       } 
		
	});
 
})(jQuery);	