(function($) {
	Class('Identification.constant.List',{
		init:function() {
			this.bindEvent();
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
		
		goDelete:function(constantNo, constantType) {
			var that = this;
			var data = {	
					"constantNo": constantNo,
					"constantType": constantType,
				};
			identification.ajax("/constant/delete", JSON.stringify(data), "html", function(res) {
				$("#alertDiv").empty();
				$("#alertDiv").html(res);
			});
			that.searchList();
		},
		
		// 设置参数隐藏域
		setSearchParam: function() {
			$("#constantTypeHide").val($("#constantType").val().trim());
			$("#constantNameHide").val($("#constantName").val().trim());
			$("#parentNoHide").val($("#parentNo").val().trim());
		},
		// 取得隐藏域参数
		getSearchConditions: function() {
			var data = {	
				"page":$("#page").val(),
				"constantType": $("#constantTypeHide").val(),
				"constantName": $("#constantNameHide").val(),
				"parentNo": $("#parentNoHide").val(),
			};
			return data;
	    },
		searchList : function() {
			var that = this;
			$("#constantResultList").empty();
			var data = this.getSearchConditions();
			identification.ajax("/constant/searchList", JSON.stringify(data), "html", function(res) {
				$("#constantResultList").html(res);
			});
		}
	});
})(jQuery);	