(function($) {
	
	Class('Identification.constant.Update',{
		init:function() {
			this.bindEvent();
		},
		
		bindEvent:function() {
			var that = this;
			$("#alertDiv").empty();
			$("#updateConstantBtn").click(function(){
				that.goUpdate();
			});	
		},
		
		// 取得隐藏域参数
		getUpdateConditions: function() {
			var data = {	
				"constantName":$("#detailConstantName").val(),
				"parentNo": $("#detailParentNo").val(),
				"sort": $("#detailSort").val(),
				"attribute1": $("#detailAttribute1").val(),
				"attribute2": $("#detailAttribute2").val(),
				"attribute3": $("#detailAttribute3").val(),
				"constantType": $("#detailConstantTypeHide").val(),
				"constantNo": $("#detailConstantNoHide").val(),
			};
			return data;
	    },
	    
	    goUpdate : function() {
			var that = this;
			var data = this.getUpdateConditions();
			identification.ajax("/constant/update", JSON.stringify(data), "html", function(res) {
				$("#alertDiv").empty();
				$("#alertDiv").html(res);
			});	
		},
		
		goDetail:function(constantNo, constantType) {
			var that = this;
			var data = {	
					"constantType": constantType,
					"constantNo": constantNo,
				};
			identification.ajaxNoasync("/constant/getDetail", JSON.stringify(data), "json", function(res) {
				that.createModalBody(res); 
			});			
		},
		
		createModalBody:function(data) {
			$("#detailConstantName").val(data.constantName);
			$("#detailParentNo").val(data.parentNo);
			$("#detailSort").val(data.sort);
			$("#detailAttribute1").val(data.attribute1);
			$("#detailAttribute2").val(data.attribute2);
			$("#detailAttribute3").val(data.attribute3);
			$("#detailConstantTypeHide").val(data.constantType);
			$("#detailConstantNoHide").val(data.constantNo);
			if(data.constantType=='C_TYPE'){
				$("#detailParentNo").removeAttr("disabled");
			}else{
				$("#detailParentNo").attr("disabled", true);
			}
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