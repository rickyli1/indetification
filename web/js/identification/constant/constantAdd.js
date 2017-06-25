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
	
	Class('Identification.constant.Add',{
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
	        $("#saveconstantBtn").click(function() {
	        	var saveData = that.getSaveData();
	        	identification.ajax("/constant/add", JSON.stringify(saveData), "html", function(res) {
    				$("#alertDiv").empty();
    				$("#alertDiv").html(res);
				});	        	
	        });
	        $("#constantType").change(function() {
	        	if($("#constantType").val() == "C_TYPE"){
	        		$("#parentNo").removeAttr("disabled");
	        	}else{
	        		$("#parentNo").val("");
	        		$("#parentNo").attr("disabled", true);
	        	}
	        });
		},
		
       getSaveData : function() {
    	   var data = {
   				"constantType": $("#constantType").val(),
   				"constantName": $("#constantName").val(),
   				"parentNo": $("#parentNo").val(),
   				"sort": $("#sort").val(),
   				"attribute1": $("#attribute1").val(),
   				"attribute2": $("#attribute2").val(),
   				"attribute3": $("#attribute3").val(),
   			};
   			return data;
       } 
		
	});
 
})(jQuery);	