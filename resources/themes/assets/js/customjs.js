$(document).ready(function(){
	
	var $accordionIO = $('.multi');
	$accordionIO.prev('ul').hide();
	$accordionIO.click(function() {
	  $(this).prev('ul').slideToggle();
	});
	$(".multi").click(function(event) {
		
		if($("#menuidvalue").val() == null)
		{
			$("#menuidvalue").val(this.id);
			alert($("#menuidvalue").val());
		}
	
		if($("#menuidvalue").val()==this.id)
		{
			 var icon1 = $(this).find('.pm').html();
			 if(icon1=="-")
			 {
				 var jqInner = $(this).prev();
				  jqInner.slideToggle();
				 $(this).find('.pm').html('+');
			 }
		}
		else
		{
			 $('.ul').slideUp();
			  $('.pm').html('+');
			  var jqInner = $(this).prev();
			  jqInner.slideToggle();
			  var icon1 = $(this).find('.pm').html();
			   icon1 == "+" ? $(this).find('.pm').html('-') : $(this).find('.pm').html('+');
			  	
		}
	});
        	 /* $('a.multi').click(function(){
        		 var spantext=$(this).children("span.pm").text();

        	  if(spantext=="+")
{
        			 
        		  $(this).children("span.pm").text("-");
        			 
        			 }else{
        				 
        				  $(this).children("span.pm").text("+");
        				 
        				 
        			 }    		 
        		
        	  var spantext1=$('.active').children("span.pm").text();

        	  if(spantext1=="+")
        	  {
        	          			 
        	          		  $(this).children("span.pm").text("-");
        	          			 
        	          			 }else{
        	          				 
        	          				  $(this).children("span.pm").text("+");
        	          				 
        	          				 
        	          			 } 
         		
        	  });
        	 */
        	  
  		 }); 