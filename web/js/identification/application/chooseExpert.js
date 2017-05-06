(function($) {
	
	Class('Identification.application.ChooseExpert',{
		init:function() {
			this.bindEvent();
		},
		
		bindEvent:function() {
			var that = this;
			$("#searchExpertBtn").click(function() {
				that.goPage();
			});
			
			$("#saveExpertBtn").click(function() {
				var experts = "";
				var expertIds = "";
				var expertLeader = $('input:radio[name="selectExpert"]:checked');
				
				if(expertLeader && expertLeader.length != 0) {
					//save data
					$("#leaderNo").val(expertLeader.attr("data-id"));
					
					$(".selsectExpertNameTD").each(function(index, e) {
						var tempExpert = $(this).text();
						if($(this).attr("data-expertNo") == expertLeader.attr("data-id")) {
							tempExpert = tempExpert + "(组长)";
						}
						
						if(experts == "") {
							experts = experts + tempExpert;
							
							if($(this).attr("data-expertNo") != expertLeader.attr("data-id")) {
								expertIds = ";" + expertIds + $(this).attr("data-expertNo");
							}
							
						}else {
							experts =  experts + "," +tempExpert;
							
							if($(this).attr("data-expertNo") != expertLeader.attr("data-id")) {
								expertIds = expertIds + ";" +$(this).attr("data-expertNo");				
							}
						}
					});
					expertIds = expertIds + ";" ;
					//save data
					$("#expert").val(experts);
					$("#expertsNo").val(expertIds);
					$('#expertModal').modal('hide');
				}else{
					alert("请选择专家组长");
					return false;
				}
				
				
				
			});
		},
		
		goPage:function() {
			var that = this;
			var param = {"page":$("#page").val(), "expertName":$("#chooseExpertName").val()};
			
			identification.ajaxNoasync("/expert/getExpertForApplication", JSON.stringify(param), "json", function(res) {
				that.createExpertBody(res); 
				that.createPageOver(res);
			});			
		},
		
		createExpertBody:function(data) {
			var list = data.applicationResultList;
			
			if(list.length > 0) {
				var body = $("#expertBody");
				var setBody = $("#setExpertBody");
				body.empty();
				
				for(var i = 0; i < list.length; i++) {
					var tr = $('<tr>');
		            //专家姓名
					var expertNameTD = $('<td>');
					expertNameTD.attr("id", "nameTD"+list[i].expertNo);
					expertNameTD.attr("data-expertNo", list[i].expertNo );
					
					//专业
					var professionTD = $('<td>');
					//专家职称
					var professionalTitleTD = $('<td>');
					//专家单位
					var companyNameTD = $('<td>');
					//操作
					var selectBtnTD = $('<td>');
					var selectBtn = $('<button>');
					selectBtn.attr("class", "btn btn-primary btn-sm");
					selectBtn.attr("type", "button");
					selectBtn.attr("id", "selectBtn"+list[i].expertNo);
					selectBtn.attr("data-id" , list[i].expertNo);
					selectBtn.text("选中");
					
					var selectExpertTD = $(".selectExpert");
					if(selectExpertTD && selectExpertTD.length > 0) {
						selectExpertTD.each(function(n, item) {
							if($(item).attr("data-id") == list[i].expertNo) {
								selectBtn.attr("disabled", true);
							}
						}); 
					}
					
					
					
					
					//选择专家按钮
					selectBtn.click(function() {
						var id = $(this).attr("data-id");
						//添加专家
						var selectTR = $('<tr>');
						selectTR.attr("id", "selectTR" + id);
						var radioTD = $('<td>');
							
						var radioInput = $('<input>');
						radioInput.attr("type", "radio");
						radioInput.attr("name", "selectExpert");
						radioInput.attr("class", "selectExpert");
						radioInput.attr("data-id", id);						
						radioInput.attr("id", "leaderRadio" + id);						
						radioTD.append(radioInput);
						
						
						var selectExpertNameTD = $("#nameTD" + id).clone();
						selectExpertNameTD.attr("class", "selsectExpertNameTD");
						
						var deleteBtn = $("<button>");
						deleteBtn.attr("class", "btn btn-primary btn-sm");
						deleteBtn.attr("type", "button");
						deleteBtn.attr("id", "selectBtn"+id);
						deleteBtn.attr("data-id" , id);
						deleteBtn.text("删除");	
						
						//删除专家事件
						deleteBtn.click(function() {
                            var deletedId = $(this).attr("data-id");
							
							if($("#selectBtn"+deletedId)) {
								$("#selectBtn"+deletedId).attr("disabled", false);
							}
							
							$("#selectTR"+deletedId).remove();
						});
						
						selectTR.append(selectExpertNameTD);
						selectTR.append(radioTD);
						selectTR.append(deleteBtn);
						
						setBody.append(selectTR);
						$(this).attr("disabled", true);
						
					});
					
	
					expertNameTD.text(list[i].expertName);
					professionTD.text(list[i].profession);
					professionalTitleTD.text(list[i].professionalTitle);
					companyNameTD.text(list[i].companyName);
					
					selectBtnTD.append(selectBtn);
					tr.append(expertNameTD);
					tr.append(professionTD);
					tr.append(professionalTitleTD);
					tr.append(companyNameTD);
					tr.append(selectBtnTD);
					
					body.append(tr);
					
				}
			}

		},
		
		createPageOver:function(res) {
			var that = this;
			$('#pagination-expert').twbsPagination({
			    totalPages: res.totalPage,//'${totalPage}',
			    startPage: res.page==0?1:res.page,//'${page}',
			    visiblePages: 10,
			    onPageClick: function (event, page) {
			    	$("#page").val(page);
				    event.preventDefault();
			    	that.goPage(page);
			    }
			});
		}
       
		
		
	});
 
})(jQuery);	