(function($) {
	Class('Tarin.application.List',{
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
		},
		// 取得隐藏域参数
		getSearchConditions: function() {
			var data = {					
				"companyName": $("#companyNameHide").val(),
				"equipmentName":$("#equipmentNameHide").val(),
				"expertNameCon":$("#expertNameConHide").val(),
				"page":$("#page").val()
			};
			return data;
	    },
		searchList : function() {
			var that = this;
			$("#applicationResultList").empty();
//			$("#total_count_em").text(0);
			var data = this.getSearchConditions();
			train.ajax("/application/searchList", JSON.stringify(data), "html", function(res) {
				$("#applicationResultList").html(res);
//				$("#total_count_em").text($("#listTotalCount").val());
//				that.bindUpdateEvent();
//				that.checkAllEvent();
//				that.listCheckBoxEvent();
			});
		}
		
	});
 
})(jQuery);	