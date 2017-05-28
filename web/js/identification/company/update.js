(function($) {
	
	Class('Identification.company.Update',{
		init:function() {
			this.bindEvent();
		},
		
		bindEvent:function() {
			var that = this;
			$("#alertDiv").empty();
			$("#updateCompanyBtn").click(function(){
				that.setUpdateParam();
				that.goUpdate();
			});	
		},
		
		goDetail:function(companyNo) {
			var that = this;
			identification.ajaxNoasync("/company/getDetail", companyNo, "json", function(res) {
				that.createModalBody(res);
			});			
		},
		
		createModalBody:function(data) {
			$("#detailCompanyName").val(data.companyName);
			$("#detailCompanyCode").val(data.companyCode);
			$("#detailRemark").val(data.remark);
			$("#detailCompanyNameHide").val(data.companyName);
			$("#detailCompanyCodeHide").val(data.companyCode);
			$("#detailRemarkHide").val(data.remark);
			$("#detailCompanyNoHide").val(data.companyNo);
		},
		
		// 设置参数隐藏域
		setUpdateParam: function() {
			$("#detailCompanyNameHide").val($("#detailCompanyName").val().trim());
			$("#detailCompanyCodeHide").val($("#detailCompanyCode").val().trim());
			$("#detailRemarkHide").val($("#detailRemark").val().trim());
		},
		
		// 取得隐藏域参数
		getUpdateConditions: function() {
			var data = {	
				"companyNo":$("#detailCompanyNoHide").val(),
				"companyName": $("#detailCompanyNameHide").val(),
				"companyCode": $("#detailCompanyCodeHide").val(),
				"remark": $("#detailRemarkHide").val(),
			};
			return data;
	    },
	    goUpdate : function() {
			var that = this;
			var data = this.getUpdateConditions();
			identification.ajax("/company/update", JSON.stringify(data), "html", function(res) {
				$("#alertDiv").empty();
				$("#alertDiv").html(res);
			});	
		},
		
		trimNull:function(string){
			if(string == null){
				return '';
			}else{
				return string;
			}
		}
		
	});
 
})(jQuery);	