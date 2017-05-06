(function($) {
	Class('Identification.company.List',{
		init:function() {
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
			$("#alertDiv").empty();
			$("#searchBtn").click(function(){
				$("#page").val(1);
				that.setSearchParam();
				that.searchList();
			});			 
		},
		
		goDelete:function(companyName) {
			var that = this;
			identification.ajax("/company/delete", companyName, "json", function(res) {
				$("#alertDiv").empty();
				$("#alertDiv").html(res);
			});
			that.searchList();
		},
		
		// 设置参数隐藏域
		setSearchParam: function() {
			$("#companyNameHide").val($("#companyName").val().trim());
			$("#companyCodeHide").val($("#companyCode").val().trim());
		},
		// 取得隐藏域参数
		getSearchConditions: function() {
			var data = {	
				"page":$("#page").val(),
				"companyName": $("#companyNameHide").val(),
				"companyCode": $("#companyCodeHide").val(),
				"companyType": $("#companyTypeHide").val(),
			};
			return data;
	    },
		searchList : function() {
			var that = this;
			$("#companyResultList").empty();
			var data = this.getSearchConditions();
			identification.ajax("/company/searchList", JSON.stringify(data), "html", function(res) {
				$("#companyResultList").html(res);
			});
		}
		
	});
 
})(jQuery);	