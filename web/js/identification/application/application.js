(function($) {
	Class('Identification.application.List',{
		init:function() {
			this.bindEvent();
			this.initCalendar();
		},
		
		initCalendar : function() {
			
			$('.form_year').datetimepicker({
			    format: 'yyyy',  
			     weekStart: 1,  
			     autoclose: true,  
			     startView: 4,  
			     minView: 4,  
			     forceParse: 0,  
			     language: 'zh-CN' 
			    
			});
			
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
			
			$("#searchBtn").click(function(){
				$("#page").val(1);
				that.setSearchParam();
				that.searchList();
			});			 
		},
		// 设置参数隐藏域
		setSearchParam: function() {
			$("#companyNameHide").val($("#companyName").val().trim());
			$("#equipmentNameHide").val($("#equipmentName").val().trim());
			$("#expertNameConHide").val($("#expertNameCon").val().trim());
			
			$("#resultConHide").val($("#resultCon").val());
			$("#repairLevelConHide").val($("#repairLevelCon").val());
		},
		// 取得隐藏域参数
		getSearchConditions: function() {
			var data = {	
				"page":$("#page").val(),
				"companyName": $("#companyNameHide").val(),
				"equipmentName":$("#equipmentNameHide").val(),
				"expertNameCon":$("#expertNameConHide").val(),

				"resultCon":$("#resultConHide").val(),
				"repairLevelCon":$("#repairLevelConHide").val(),
				"limitDateCon":$("#limitDate").val(),
				
				"applicationDateFrom":$("#applicationDateFrom").val().replace(/-/g,""),
				"applicationDateTo":$("#applicationDateTo").val().replace(/-/g,"")
			};
			return data;
	    },
		searchList : function() {
			var that = this;
			$("#applicationResultList").empty();

			var data = this.getSearchConditions();
			identification.ajax("/application/searchList", JSON.stringify(data), "html", function(res) {
				$("#applicationResultList").html(res);
			});
		},
		goDelete:function(applicationNo,reportNo) {
			var that = this;
			var data = {
					"applicationNo":applicationNo,
					"reportNo":reportNo
			};
			identification.ajax("/application/delete", JSON.stringify(data), "html", function(res) {
				$("#alertDiv").empty();
				$("#alertDiv").html(res);
			});
		},
		
	});
 
})(jQuery);	