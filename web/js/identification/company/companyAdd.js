(function($) {
	  var availableTags = [
	      "ActionScript",
	      "AppleScript",
	      "Asp",
	      "BASIC",
	      "C",
	      "C++",
	      "Clojure",
	      "COBOL",
	      "ColdFusion",
	      "Erlang",
	      "Fortran",
	      "Groovy",
	      "Haskell",
	      "Java",
	      "JavaScript",
	      "Lisp",
	      "Perl",
	      "PHP",
	      "Python",
	      "Ruby",
	      "Scala",
	      "Scheme"
	    ];	
	
	Class('Identification.company.Add',{
		init:function() {
			this.no = 0;
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
			//保存
	        $("#saveCompanyBtn").click(function() {
	        	var saveData = that.getSaveData();
	        	identification.ajax("/company/add", JSON.stringify(saveData), "html", function(res) {
    				$("#alertDiv").empty();
    				$("#alertDiv").html(res);
				});	        	
	        });		  
		},
		
       getSaveData : function() {
    	   var data = {	
   				"companyName": $("#companyName").val(),
   				"companyCode": $("#companyCode").val(),
   				"companyType": $("#companyType").val(),
   				"remark": $("#remark").val(),
   			};
   			return data;
       } 
		
	});
 
})(jQuery);	