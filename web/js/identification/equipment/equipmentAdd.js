(function($) {
	Class('Identification.equipment.Add',{
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
			$("#addEquipmentDetailBtn").click(function() {
	            that.no = that.no +1;
	            var data = {  no : that.no};
	            var datas = {};
	        	identification.ajaxNoasync("/equipment/getApplicationData", null, "json", function(res) {
	        		datas = $.extend(data, res);
				});	         	

				$("#detailTemplate").tmpl(datas).appendTo( "#equipmentDetailBody" );
				
//				that.initCalendar();
				
				$(".deleteClass").each(function(index,elemet){
					var removeNo = $(this).attr("data-no");
					$(this).click(function() {
						that.no = that.no -1;
						$("#tr" + removeNo).remove();
					});
				});
				
			});	
			
//			$("#groupNo").click(function(){
//				 var selOpt = $("#subGroupNo option");  
//				 selOpt.remove();  
//			});
			//LIAN DONG
			$("#groupNo").change(function(){
				var data = {	
					"groupNo":$("#groupNo").val()
				};
				var selOpt = $("#subGroupNo option");  
				selOpt.remove();  
				
				identification.ajaxNoasync("/equipment/getApplicationData", JSON.stringify(data), "json", function(res) {
					 $("#subGroupNo").append($("<option/>").text("").attr("value",""));
				     var jsobject='';
					 jsobject =  res.childrenConstants;
					 $(jsobject).each(function () {
		                 $("#subGroupNo").append($("<option/>").text(this.constantName).attr("value",this.constantNo));
//		                 $("#subGroupNo").val(this.constantNo); 
		             }); 
				});	
			});	
			
			/*$("#subGroupNo").click(function(){
				var data = {	
					"groupNo":$("#groupNo").val()
				};
				var selOpt = $("#subGroupNo option");  
				selOpt.remove();  
				
				identification.ajaxNoasync("/equipment/getApplicationData", JSON.stringify(data), "json", function(res) {
					 $("#subGroupNo").append($("<option/>").text("").attr("value",""));
				     var jsobject='';
					 jsobject =  res.childrenConstants;
					 $(jsobject).each(function () {
		                 $("#subGroupNo").append($("<option/>").text(this.constantName).attr("value",this.constantNo));
//		                 $("#subGroupNo").val(this.constantNo); 
		             }); 
				});	
			});	*/
			//申请保存
//	        $("#saveEquipmentBtn").click(function() {
//	        	var saveData = that.getSaveData();
//	        	identification.ajax("/equipment/add", JSON.stringify(saveData), "html", function(res) {
//    				$("#alertDiv").empty();
//    				$("#alertDiv").html(res);
//				});	        	
//	        });		
	        
//	        $("#saveEquipmentBtn").one("click",function(){
			$("#saveEquipmentBtn").click(function() {
        	var saveData = that.getSaveData();
        	identification.ajax("/equipment/add", JSON.stringify(saveData), "html", function(res) {
				$("#alertDiv").empty();
				$("#alertDiv").html(res);
			});	        	
        });		
	       
	       
		},
		
       getSaveData : function() {
    	   var equipment = {};
//    	   var rep = {};
//    	   rep.equipments = [];
    	   
    	   equipment.equipmentName = $("#equipmentName").val();
		   equipment.sort = $("#sort").val();
		   equipment.groupNo = $("#groupNo").val();
		   equipment.subGroupNo = $("#subGroupNo").val();
		   equipment.remark = $("#remark").val();
    	   //reports
//    	   $(".addTr").each(function(i,element) {
//    		   var i = $(this).attr("data-no");
//    		   console.log(i);
////    		   var equipment = {};
//    		   equipment.equipmentName = $("#equipmentName" + i).val();
//    		   equipment.sort = $("#sort" + i).val();
//    		   equipment.groupNo = $("#groupNo" + i).val();
//    		   equipment.subGroupNo = $("#subGroupNo" + i).val();
//    		   equipment.remark = $("#remark" + i).val();
//    		   
//    	   }); 
    	   
//    	  return $.extend(app, rep);
    	   return equipment;
       } 
		
	});
 
})(jQuery);	