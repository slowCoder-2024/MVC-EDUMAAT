	var ctx= window.location.pathname.substring(0, window.location.pathname.indexOf("/",2));

$(document).ready(function(){
	
});


function checkSMSCount()
{
 		 $.ajax({ type: "GET",
				        url:ctx+'/staff/checksmsbalance',
				        contentType: "application/json; charset=utf-8",
				        dataType: "json",
				        async: false,
				        cache: false,
				        success: function (data)
				        {
				        	var obj = jQuery.parseJSON(data);
				        	/* 
				        	$.each(obj, function (i, item) {
				        		if(i=="Balance")
				        		{
				        			 edumaatAlert({
				        	             title: "Info !",
				        	             text:"Balance SMS - "+item,
				        	             type: "info",
				        	             confirmButtonText: "Cool"
				        	            }).then(function(){
					  			    		window.location.href=ctx+"/staff/transactiondetails";
					  			    	});
				        		}
				        	});
*/				     
				        	if(!$.trim(data))
				        	{
				        			window.location.href=ctx+"/staff/transactiondetails";
				  			}
				        	else{
				        	 edumaatAlert({
		        	             title: "Info !",
		        	             text:"Balance SMS Count - "+obj,
		        	             type: "info",
		        	             confirmButtonText: "Cool"
		        	            }).then(function(){
			  			    		window.location.href=ctx+"/staff/transactiondetails";
			  			    	});
				        	}
				        	}
				    });
}