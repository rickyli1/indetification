(function($) {
	Class('Identification.expert.expertStatisticsList',{
		init:function() {
			this.bindEvent();
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
			$("#expertNameHide").val($("#expertName").val());
//			$("#equipmentNameHide").val($("#equipmentName").val());
//			$("#repairLevelHide").val($("#repairLevel").val());
		},
		// 取得隐藏域参数
		getSearchConditions: function() {
			var data = {	
				"page":$("#page").val(),
				"expertName": $("#expertNameHide").val(),
//				"equipmentName":$("#equipmentNameHide").val(),
//				"repairLevel":$("#repairLevelHide").val()
			};
			return data;
	    },
		searchList : function() {
			var that = this;
			$("#expertStatisticsList").empty();
			var data = this.getSearchConditions();
			identification.ajax("/statistics/getExpertStatistics", JSON.stringify(data), "html", function(res) {
				$("#expertStatisticsList").html(res);
			});
		}
	});
 
})(jQuery);	