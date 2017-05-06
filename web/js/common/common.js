var identification = identification || {};

(function (){
	identification.ajax = function(url, data, dataType, fn ){
		$.ajax({
			type: "POST",
			contentType: "application/json;charset=utf-8",
			url: url,
			data: data,
			dataType:dataType,
			timeout: 30000,
			success: function(res) {
				fn(res);
			},
			error: function(e) {
              console.log(e);
			},
			
			beforeSend: function(xhr) {
				xhr.setRequestHeader('ajax', true);
			}
			
		});
		
	};
	
	
identification.ajaxNoasync = function(url, data, dataType, fn){
		
		
		$.ajax({
			type: "POST",
			contentType: "application/json;charset=utf-8",
			url: url,
			data: data,
			dataType:dataType,
			async:false,
			timeout: 30000,
			success: function(res) {
				fn(res);
			},
			error: function(e) {
              console.log(e);
			},
			
			beforeSend: function(xhr) {
				//xhr.setRequestHeader('ajax', true);
			}
			
		});
		
	};	
	
	
	//file upload
identification.fileUpload = function(url, uploadBtnId, fileName, fileId){
		$('#'+ uploadBtnId).fileupload({
			maxFileSize: 16000000,	// 16M
	        url: url,
	        paramName:"file",
	       
		  add: function (e, data) {
			  $(".progress-bar-success").css("width","0%");
			  if(confirm("是否上传 " + data.files[0].name + "?")) {
				 
				  $('#loading').show();
		            data.submit();
			  }else {
				  return;
			  }
			
		    } ,
	        
	        // 文件上传前回调 返回true 才发送上传
	        submit:function (e, data){
	        	return true;
	        },
	        done: function (e, data) {
	        	console.log(data);
	        	if (data.result) {
	        		
	        		if(data.result.message) {
			        	//提示信息
				        alert(data.result.message);
	        		}else{
	        			$('#'+ fileName).text(data.result.fileName);
	        			$('#'+ fileId).val(data.result.fileId);
	        		}
	        	} else {
		        	//提示信息
	        		 alert("文件导人成功！");
	        	}
	        	
	        	$('#loading').hide();
	        },
	        // throw exception
	        fail: function (e, data) {
	        	$('#files').show().text("文件上传失败！").delay(5000).fadeOut();
	        	$('#loading').hide();
	        },
	        progress: function (e, data) {
	            var progress = parseInt(data.loaded / data.total * 100, 10);
	            $('#progress .progress-bar').css(
	                'width',
	                progress + '%'
	            );
	        }
	    });
		
	};		
	
	//init calendar
identification.initCalendarByClass = function(form_datetime, form_date, form_time){
		
	    $('.'+ form_datetime).datetimepicker({
	        language:  'zh-CN',
	        weekStart: 1,
	        todayBtn:  1,
			autoclose: 1,
			todayHighlight: 1,
			startView: 2,
			forceParse: 0,
	        showMeridian: 1
	    });
		$('.'+form_date).datetimepicker({
	        language:  'zh-CN',
	        weekStart: 1,
	        todayBtn:  1,
			autoclose: 1,
			todayHighlight: 1,
			startView: 2,
			minView: 2,
			forceParse: 0
	    });
		$('.'+form_time).datetimepicker({
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
};		
	
//init calendar yyyy
identification.initCalendarYYYYByClass = function(form_year){	
	$('.'+form_year).datetimepicker({
	    format: 'yyyy',  
	     weekStart: 1,  
	     autoclose: true,  
	     startView: 4,  
	     minView: 4,  
	     forceParse: 0,  
	     language: 'zh-CN'     
	});
	
};	
	
})(jQuery);