(function($) {
	Class('Identification.equipment.List',{
		init:function() {
			this.bindEvent();
			this.initCalendar();
		},
		
		initCalendar : function() {
						
		},
		
		bindEvent: function() {
			var that = this;
			
			$("#searchBtn").click(function(){
				$("#page").val(1);
				that.setSearchParam();
				that.searchList();
			});	
			
			$("#exportBtn").click(function(){
//				that.setSearchParam();
//				that.exportList();

				location.href="/equipment/exportEquipmentList";    
				
			});	
			
			
		},
	
		// 设置参数隐藏域
		setSearchParam: function() {
			$("#equipmentNameHide").val($("#equipmentName").val());
			$("#groupNoHide").val($("#groupNo").val());
			$("#subGroupNoHide").val($("#subGroupNo").val());
			$("#repairLevelHide").val($("#repairLevel").val());
			
		},
		// 取得隐藏域参数
		getSearchConditions: function() {
			var data = {	
				"page":$("#page").val(),
				"equipmentName": $("#equipmentNameHide").val(),
				"groupNo":$("#groupNoHide").val(),
				"subGroupNo":$("#subGroupNoHide").val(),
				"repairLevel":$("#repairLevelHide").val(),
			};
			return data;
	    },
		searchList : function() {
			var that = this;
			$("#equipmentResultList").empty();
//			$("#total_count_em").text(0);
			var data = this.getSearchConditions();
			identification.ajax("/equipment/searchEquipmentList", JSON.stringify(data), "html", function(res) {
				$("#equipmentResultList").html(res);
//				$("#total_count_em").text($("#listTotalCount").val());
//				that.bindUpdateEvent();
//				that.checkAllEvent();
//				that.listCheckBoxEvent();
			});
		},
		exportList : function() {
//			var that = this;
//			var data = this.getSearchConditions();
//			identification.ajax("/equipment/exportEquipmentList", JSON.stringify(data), "html", function(res) {
//				
//			});
			
		}
		,
		goDelete:function(equipmentNo) {
			var that = this;
			identification.ajax("/equipment/deleteEquipment", equipmentNo, "json", function(res) {
				$("#alertDiv").empty();
				$("#alertDiv").html(res);
			});
			that.searchList();
		}
	});
 
})(jQuery);	