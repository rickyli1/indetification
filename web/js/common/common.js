var identification = identification || {};

(function (){
	identification.ajax = function(url, data, dataType, fn ){
		$.ajax({
			type: "POST",
			contentType: "application/json;charset=utf-8",
			url: url,
			data: data,
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
	
})(jQuery);