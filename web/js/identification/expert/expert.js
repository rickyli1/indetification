(function($) {
	Class('Identification.expert.List',{
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
			$("#expertNameHide").val($("#expertName").val().trim());
			$("#professionHide").val($("#profession").val().trim());
			$("#companyNameHide").val($("#companyName").val().trim());
		},
		// 取得隐藏域参数
		getSearchConditions: function() {
			var data = {	
				"page":$("#page").val(),
				"expertName": $("#expertNameHide").val(),
				"profession":$("#professionHide").val(),
				"companyName":$("#companyNameHide").val(),
			};
			return data;
	    },
		searchList : function() {
			var that = this;
			$("#expertResultList").empty();

			var data = this.getSearchConditions();
			identification.ajax("/expert/searchList", JSON.stringify(data), "html", function(res) {
				$("#expertResultList").html(res);
			});
		},
		goDelete:function(expertNo) {
			var that = this;
			identification.ajax("/expert/delete", expertNo, "html", function(res) {
				$("#alertDiv").empty();
				$("#alertDiv").html(res);
			});
		},
		
	});
 
})(jQuery);	