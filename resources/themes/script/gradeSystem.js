           $(document).ready(function() {
        	   var ctx= window.location.pathname.substring(0, window.location.pathname.indexOf("/",2));
             var i=1;
             var editi=0;
        	   $("#addGradeDetail").click(function()
                    	{
               		
                    		i=i+1;
                    		var grade="gradeSystem"+i;
                    		var widget="widget"+i;
                    		 $(".gradeSystems").append('<div class="dismiss">'
                    		+'<div id='+widget+' class="card-box" style="box-shadow: 0 0px 8px 0 rgba(94, 194, 179, 0.67), 0 1px 0px 0 rgba(12, 236, 133, 0)">'
                    		
                    		+'<h4 class="m-t-0 header-title" style="color:purple;"><b>Grade Details</b></h4>'
                   		 
                    		+'<div id='+grade+'><h3 class="title"><button style="float:right" type="button" class="btn btn-info remove" data-dismiss="dismiss" aria-hidden="true"><i class="fa fa-remove" aria-hidden="true"></i></button></h3>'
                    		+'<div class="form-group">'
                   			+' <label for="" class="col-sm-3 control-label">Grade Title <span class="at-required-highlight">*</span></label> '
                   			+' <div class="col-sm-6"> '
                   			+' <input type="text" name="gradeSystemTitle'+i+'" class="form-control" id="gradeSystemTitle'+i+'" required="required" maxlength="50">'
                   			+' </div>'
                   			+' </div>'	
                   			+'<div class="form-group">'
                   			+' <label for="" class="col-sm-3 control-label">Marks From <span class="at-required-highlight">*</span></label> '
                   			+' <div class="col-sm-6"> '
                   			+' <input type="text" name="marksFrom'+i+'" onkeypress="return isFloatNumber(this,event)" class="form-control" id="marksFrom'+i+'" required="required" maxlength="50">'
                   			+' </div>'
                   			+' </div>'	
                   			+'<div class="form-group">'
                   			+' <label for="" class="col-sm-3 control-label">Marks To <span class="at-required-highlight">*</span></label> '
                   			+' <div class="col-sm-6"> '
                   			+' <input type="text" name="marksTo'+i+'" onkeypress="return isFloatNumber(this,event)" class="form-control" id="marksTo'+i+'" required="required" maxlength="50">'
                   			+' </div>'
                   			+' </div>'	
                   			+'<div class="form-group">'
                   			+' <label for="" class="col-sm-3 control-label">Grade Point <span class="at-required-highlight">*</span></label> '
                   			+' <div class="col-sm-6"> '
                   			+' <input type="text" name="gradePoint'+i+'" onkeypress="return isFloatNumber(this,event)" class="form-control" id="gradePoint'+i+'" required="required" maxlength="50">'
                   			+' </div>'
                   			+' </div>'	
                   			+'</div>'
                   			+'</div>'
                   			
                   		
                			+' </div>'	); 
                    	
                    	}); 	
        	$(document).on("click",".remove",function(event)
        			   {
        		   			i=i-1;
        		   			editi=editi-1;
        			   });
        	   
         	$('#gradeSystemList').on( 'click', 'tr td a#delete', function () {
              	 var deleteGradeSystemId = $(this).attr('data-id');
              	 $('#confirm_delete_gradeSystem').on('show.bs.modal', function (e) {
              		 $("#confirmDeleteGradeSystem").click(function(event) {
              			 $("#deleteGradeSystemId").val(deleteGradeSystemId);
              			 $(".loader").show();
              			 $("#deleteGradeSystemForm").submit();  
              		});
              		});
              	   
              });
         	
         	$('#gradeSystemList').on( 'click', 'tr td a#edit', function () {
              	 var gradeSystemId = $(this).attr('data-id');
              			   $.ajax({
              				   url:ctx+'/gradesystem/template/editRetrieve',
              				   data:{gradeSystemId:gradeSystemId},
              				   type:'GET',
              				   success: function(response)
              				   {
              					   //alert(response);
              					   if(response.gradeSystemName!=null)
              						{
              						 $("#editGradeSystemName").val(response.gradeSystemName); 
                   					}
              					   var gradeDetails = new Array();
              	        			$.each(response.gradeSystemDetails, function(key,value) 
              	        			{ 
              	        				gradeDetails[key]=value.gradeSystemDetailId;
              						
              	        			if(key==0){
              	        			editi=editi+1;
                            		var grade="editGradeSystem"+editi;
                            		var widget="widget"+editi;
                            		 $(".editGradeSystems").append('<div class="dismiss">'
                            		+'<div id='+widget+' class="card-box" style="box-shadow: 0 0px 8px 0 rgba(94, 194, 179, 0.67), 0 1px 0px 0 rgba(12, 236, 133, 0)">'
                            		+'<div id='+grade+'><h3 class="title"></h3>'
                            		+'<div class="form-group">'
                           			+' <label for="" class="col-sm-3 control-label">Grade Title<span class="at-required-highlight">*</span></label> '
                           			+' <div class="col-sm-6"> '
                           			+' <input type="text" name="editGradeSystemTitle'+editi+'" class="form-control" id="editGradeSystemTitle'+editi+'" required="required" maxlength="50">'
                           			+' </div>'
                           			+' </div>'	
                           			+'<div class="form-group">'
                           			+' <label for="" class="col-sm-3 control-label">Marks From<span class="at-required-highlight">*</span></label> '
                           			+' <div class="col-sm-6"> '
                           			+' <input type="text" name="editMarksFrom'+editi+'" onkeypress="return isFloatNumber(this,event)" class="form-control" id="editMarksFrom'+editi+'" required="required" maxlength="50">'
                           			+' </div>'
                           			+' </div>'	
                           			+'<div class="form-group">'
                           			+' <label for="" class="col-sm-3 control-label">Marks To<span class="at-required-highlight">*</span></label> '
                           			+' <div class="col-sm-6"> '
                           			+' <input type="text" name="editMarksTo'+editi+'" onkeypress="return isFloatNumber(this,event)" class="form-control" id="editMarksTo'+editi+'" required="required" maxlength="50">'
                           			+' </div>'
                           			+' </div>'	
                           			+'<div class="form-group">'
                           			+' <label for="" class="col-sm-3 control-label">Grade Point<span class="at-required-highlight">*</span></label> '
                           			+' <div class="col-sm-6"> '
                           			+' <input type="text" name="editGradePoint'+editi+'" onkeypress="return isFloatNumber(this,event)" class="form-control" id="editGradePoint'+editi+'" required="required" maxlength="50">'
                           			+' </div>'
                           			+' </div>'	
                           			+'</div>'
                           			+'</div>'
                        			+' </div>'); 
                            		 if(value.gradeTitle!=null)
               						 {
                            			 $("#editGradeSystemTitle"+editi).val(value.gradeTitle); 
                         			 }
                            		 if(value.fromMarks!=null)
                					 {
                            			 $("#editMarksFrom"+editi).val(value.fromMarks);
                					 }
                            		 if(value.toMarks!=null)
                					 {
                            			 $("#editMarksTo"+editi).val(value.toMarks);
                					 }
                            		 if(value.gradePoint!=null)
                					 {
                            			 $("#editGradePoint"+editi).val(value.gradePoint);
                					 }
              	        			}else
              	        			{
              	        				editi=editi+1;
                                		var grade="editGradeSystem"+editi;
                                		var widget="widget"+editi;
                                		 $(".editGradeSystems").append('<div class="dismiss">'
                                		+'<div id='+widget+' class="card-box" style="box-shadow: 0 0px 8px 0 rgba(94, 194, 179, 0.67), 0 1px 0px 0 rgba(12, 236, 133, 0)">'
                                		+'<h4 class="m-t-0 header-title" style="color:purple;"><b>Grade Details</b></h4>'
                                		+'<div id='+grade+'><h3 class="title"> <button style="float:right" type="button" class="btn btn-info remove" data-dismiss="dismiss" aria-hidden="true"><i class="fa fa-remove" aria-hidden="true"></i></button></h3>'
                                		+'<div class="form-group">'
                               			+' <label for="" class="col-sm-3 control-label">Grade Title<span class="at-required-highlight">*</span></label> '
                               			+' <div class="col-sm-6"> '
                               			+' <input type="text" name="editGradeSystemTitle'+editi+'" class="form-control" id="editGradeSystemTitle'+editi+'" required="required" maxlength="50">'
                               			+' </div>'
                               			+' </div>'	
                               			+'<div class="form-group">'
                               			+' <label for="" class="col-sm-3 control-label">Marks From<span class="at-required-highlight">*</span></label> '
                               			+' <div class="col-sm-6"> '
                               			+' <input type="text" name="editMarksFrom'+editi+'" onkeypress="return isFloatNumber(this,event)" class="form-control" id="editMarksFrom'+editi+'" required="required" maxlength="50">'
                               			+' </div>'
                               			+' </div>'	
                               			+'<div class="form-group">'
                               			+' <label for="" class="col-sm-3 control-label">Marks To<span class="at-required-highlight">*</span></label> '
                               			+' <div class="col-sm-6"> '
                               			+' <input type="text" name="editMarksTo'+editi+'" onkeypress="return isFloatNumber(this,event)" class="form-control" id="editMarksTo'+editi+'" required="required" maxlength="50">'
                               			+' </div>'
                               			+' </div>'	
                               			+'<div class="form-group">'
                               			+' <label for="" class="col-sm-3 control-label">Grade Point<span class="at-required-highlight">*</span></label> '
                               			+' <div class="col-sm-6"> '
                               			+' <input type="text" name="editGradePoint'+editi+'" onkeypress="return isFloatNumber(this,event)" class="form-control" id="editGradePoint'+editi+'" required="required" maxlength="50">'
                               			+' </div>'
                               			+' </div>'	
                               			+'</div>'
                               			+'</div>'
                            			+' </div>'); 
                                		 if(value.gradeTitle!=null)
                   						 {
                                			 $("#editGradeSystemTitle"+editi).val(value.gradeTitle); 
                             			 }
                                		 if(value.fromMarks!=null)
                    					 {
                                			 $("#editMarksFrom"+editi).val(value.fromMarks);
                    					 }
                                		 if(value.toMarks!=null)
                    					 {
                                			 $("#editMarksTo"+editi).val(value.toMarks);
                    					 }
                                		 if(value.gradePoint!=null)
                    					 {
                                			 $("#editGradePoint"+editi).val(value.gradePoint);
                    					 }
              	        			}
              	        			});
              				   }
              				 });    	   
              });
         	

         	 $("#editAddGradeDetail").click(function()
                 	{
            		
         		 		editi=editi+1;
         		 		var grade="editGradeSystem"+editi;
         		 		var widget="widget"+editi;
                 		 $(".editGradeSystems").append('<div class="dismiss">'
                 		+'<div id='+widget+' class="form-three widget-shadow">'
                 		+'<h4 class="m-t-0 header-title" style="color:purple;"><b>Grade Details</b></h4>'
                 		+'<div id='+grade+'><h3 class="title"><button style="float:right" type="button" class="btn btn-info remove" data-dismiss="dismiss" aria-hidden="true"><i class="fa fa-remove" aria-hidden="true"></i></button></h3>'
                 		+'<div class="form-group">'
                			+' <label for="" class="col-sm-3 control-label">Grade Title<span class="at-required-highlight">*</span></label> '
                			+' <div class="col-sm-6"> '
                			+' <input type="text" name="editGradeSystemTitle'+editi+'" class="form-control" id="editGradeSystemTitle'+editi+'" required="required" maxlength="50">'
                			+' </div>'
                			+' </div>'	
                			+'<div class="form-group">'
                			+' <label for="" class="col-sm-3 control-label">Marks From<span class="at-required-highlight">*</span></label> '
                			+' <div class="col-sm-6"> '
                			+' <input type="text" name="editMarksFrom'+editi+'" onkeypress="return isFloatNumber(this,event)" class="form-control" id="editMarksFrom'+editi+'" required="required" maxlength="50">'
                			+' </div>'
                			+' </div>'	
                			+'<div class="form-group">'
                			+' <label for="" class="col-sm-3 control-label">Marks To<span class="at-required-highlight">*</span></label> '
                			+' <div class="col-sm-6"> '
                			+' <input type="text" name="editMarksTo'+editi+'" onkeypress="return isFloatNumber(this,event)" class="form-control" id="editMarksTo'+editi+'" required="required" maxlength="50">'
                			+' </div>'
                			+' </div>'	
                			+'<div class="form-group">'
                			+' <label for="" class="col-sm-3 control-label">Grade Point<span class="at-required-highlight">*</span></label> '
                			+' <div class="col-sm-6"> '
                			+' <input type="text" name="editGradePoint'+editi+'" onkeypress="return isFloatNumber(this,event)" class="form-control" id="editGradePoint'+editi+'" required="required" maxlength="50">'
                			+' </div>'
                			+' </div>'	
                			+'</div>'
                			+'</div>'
             			+' </div>'	); 
                 	
                 	}); 
         	
         	$("#gradeSystemSave").click(function(event) {
           		
           		if($("#gradeSystemForm").valid())
    			{
           			
    				var gradearr=[];
           			for(k=1;k<=i;k++)
           			{
           				
           				var grade="gradeSystem"+k;
           				
           				var container = document.getElementById(grade);
           			    var collection = container.getElementsByTagName('input');
           			    var names = "";
           			    for (var aj = 0; aj < collection.length; ++aj) 
           			    {
           			    	
           			    	if (collection[aj].getAttribute('id') != null)
           			    		{
           			    			names += collection[aj].getAttribute('id') + ",";
           			    		}
           			        
           			    }
           			    names = names.substring(0, names.length - 1);
           			   	gradearr.push(names+"-");
           			 
           			}
           			$("#gradeSystemIds").val(gradearr);
           			
           		 		$("#gradeSystemSaveConfirmation").modal('show');
   	        			$("#gradeSystemSaveConfirm").click(function(){
   	        			 $(".loader").show();
   	        			$("#gradeSystemForm").submit();
   	        		});
   	        		
    			}
    			
    		});
        	  
         });
           /** Numbers Only**/
           function isNumber(evt) {
          	    evt = (evt) ? evt : window.event;
          	    var charCode = (evt.which) ? evt.which : evt.keyCode;
          	    if (charCode > 31 && (charCode < 48 || charCode > 57)) {
          	    	$("#gradeSystemForm").before(
               		        '<div class="alert alert-warning alert-dismissable">'+
               		            '<button type="button" class="close" ' + 
               		                    'data-dismiss="alert" aria-hidden="true">' + 
               		                '&times;' + 
               		            '</button>' + 
               		            'Numbers Only Allowed.' + 
               		            '</div>'+
               		         '</div>');
               	
               	window.setTimeout(function() {
               	    $(".alert").fadeTo(500, 0).slideUp(500, function(){
               	        $(this).remove(); 
               	    });
               	},800);
          	    	
          	        return false;
          	    }
          	    return true;
          	}
           