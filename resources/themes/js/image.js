    $(document).ready(function() {
                 $('.image1').on('change', function() {
                   //Get count of selected files
                   var countFiles = $(this)[0].files.length;
                   var imgPath = $(this)[0].value;
                   var extn = imgPath.substring(imgPath.lastIndexOf('.') + 1).toLowerCase();
                   var image_holder = $('.viewimage1');
                   image_holder.empty();
                   if (extn == "gif" || extn == "png" || extn == "jpg" || extn == "jpeg") {
                     if (typeof(FileReader) != "undefined") {
                       //loop for each file selected for uploaded.
                       for (var i = 0; i < countFiles; i++) 
                       {
                         var reader = new FileReader();
                         reader.onload = function(e) {
                           $("<img />", {
                             "src": e.target.result,
                             "class": "thumb-image"
                           }).appendTo(image_holder);
                         }
                         image_holder.show();
                         reader.readAsDataURL($(this)[0].files[i]);
                       }
                     } else {
                    	 $('.image1').val('');
                      // alert("This  browser does not support FileReader.");
                       edumaatAlert({
 		    			  title: "Info !",
 		    			  text: "This  browser does not support FileReader!",
 		    			  type: "info",
 		    			  confirmButtonText: "Cool"
 		    			});
                     }
                   } else {
                	   $('.image1').val('');
                   //  alert("Please select only images");
                	   edumaatAlert({
		    			  title: "Info !",
		    			  text: "Please select only images!",
		    			  type: "info",
		    			  confirmButtonText: "Cool"
		    			});
                   }
                 });
                 
                 
                 
             
               });
    
    $(document).ready(function() {
        $('.image2').on('change', function() {
          //Get count of selected files
          var countFiles = $(this)[0].files.length;
          var imgPath = $(this)[0].value;
          var extn = imgPath.substring(imgPath.lastIndexOf('.') + 1).toLowerCase();
          var image_holder = $('.viewimage2');
          
          image_holder.empty();
          if (extn == "gif" || extn == "png" || extn == "jpg" || extn == "jpeg") {
            if (typeof(FileReader) != "undefined") {
              //loop for each file selected for uploaded.
              for (var i = 0; i < countFiles; i++) 
              {
                var reader = new FileReader();
                reader.onload = function(e) {
                  $("<img />", {
                    "src": e.target.result,
                    "class": "thumb-image"
                  }).appendTo(image_holder);
                }
                image_holder.show();
                reader.readAsDataURL($(this)[0].files[i]);
              }
            } else {
            	 $('.image2').val('');
            	 edumaatAlert({
	    			  title: "Info !",
	    			  text: "This  browser does not support FileReader!",
	    			  type: "info",
	    			  confirmButtonText: "Cool"
	    			});
            }
          } else {
        	  $('.image2').val('');
        	  edumaatAlert({
	    			  title: "Info !",
	    			  text: "Please select only images!",
	    			  type: "info",
	    			  confirmButtonText: "Cool"
	    			});
          }
        });
      });