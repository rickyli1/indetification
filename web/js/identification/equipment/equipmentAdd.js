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
				identification.ajaxNoasync("/equipment/getApplicationData", JSON.stringify(data), "json", function(res) {
					 var selOpt = $("#subGroupNo option");  
					 selOpt.remove();  
					 $("#subGroupNo").append($("<option/>").text("").attr("value",""));
					 var jsobject='';
					 jsobject =  res.childrenConstants;
					 $(jsobject).each(function () {
		                 $("#subGroupNo").append($("<option/>").text(this.constantName).attr("value",this.constantNo));
//		                 $("#subGroupNo").val(this.constantNo); 
		             }); 
				});	
			});	
			
			
			$("#dgroupNo").change(function(){
				var data = {	
					"groupNo":$("#dgroupNo").val()
				};
				identification.ajaxNoasync("/equipment/getApplicationData", JSON.stringify(data), "json", function(res) {
					 var selOpt = $("#dsubGroupNo option");  
					 selOpt.remove();  
					 $("#dsubGroupNo").append($("<option/>").text("").attr("value",""));
					 var jsobject='';
					 jsobject =  res.childrenConstants;
					 $(jsobject).each(function () {
		                 $("#dsubGroupNo").append($("<option/>").text(this.constantName).attr("value",this.constantNo));
//		                 $("#subGroupNo").val(this.constantNo); 
		             }); 
				});	
			});
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
			
			$("#updateEquipmentBtn").click(function() {
	        	var saveData = that.getUpdateData();
	        	identification.ajax("/equipment/updateEquipment", JSON.stringify(saveData), "html", function(res) {
					$("#alertDiv").empty();
					$("#alertDiv").html(res);
				});	     
	        	
	        });		
	       
	       
		},
		
       getSaveData : function() {
    	   var equipment = {};
//    	   var rep = {};
//    	   rep.equipments = [];
    	   equipment.equipmentNo = $("#equipmentNo").val();
    	   equipment.equipmentName = $("#equipmentName").val();
		   equipment.sort = $("#sort").val();
		   equipment.groupNo = $("#groupNo").val();
		   equipment.subGroupNo = $("#subGroupNo").val();
		   equipment.remark = $("#remark").val();
    	   return equipment;
       } ,
       getUpdateData : function() {
    	   var equipment = {};
//    	   var rep = {};
//    	   rep.equipments = [];
    	   equipment.equipmentNo = $("#dequipmentNo").val();
    	   equipment.equipmentName = $("#dequipmentName").val();
		   equipment.sort = $("#dsort").val();
		   equipment.groupNo = $("#dgroupNo").val();
		   equipment.subGroupNo = $("#dsubGroupNo").val();
		   equipment.remark = $("#dremark").val();
    	   return equipment;
       } ,
       goDetail:function(equipmentNo) {
			var that = this;
			var data = {	
					"equipmentNo": equipmentNo
				};
			identification.ajaxNoasync("/equipment/updateInit", JSON.stringify(data), "json", function(res) {
				that.createModalBody(res); 
			});			
		},
		createModalBody:function(data) {
			$("#dequipmentName").val(data.equipmentName);
			$("#dequipmentNo").val(data.equipmentNo);
			$("#dsort").val(data.sort);
			$("#dremark").val(data.remark);
			$("#dgroupNo").val(data.groupNo);
			
			var selOpt = $("#dsubGroupNo option");  
			selOpt.remove();  
			$("#dsubGroupNo").append($("<option/>").text("").attr("value",""));
			var jsobject='';
			jsobject =  data.cList;
			$(jsobject).each(function () {
				$("#dsubGroupNo").append($("<option/>").text(this.constantName).attr("value",this.constantNo));
//                 $("#subGroupNo").val(this.constantNo); 
            }); 
			$("#dsubGroupNo").val(data.subGroupNo);
		}
		
	});
 
})(jQuery);	