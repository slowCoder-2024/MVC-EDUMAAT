           $(document).ready(function() {
        		var ctx= window.location.pathname.substring(0, window.location.pathname.indexOf("/",2));

        	      	   
        	   var i=1;
        	   var j=1;
        	   var x=1;
        	   var y=1;
             	
             	$("#addTermExam").click(function()
                    	{
             		j=j+1;
             		$("#termExam1").append('<div class="dismiss">'
             				        +'<h3 class="title"><button style="float:right" type="button" class="btn btn-info remove" data-dismiss="dismiss" aria-hidden="true"><i class="fa fa-remove" aria-hidden="true"></i></button></h3>'
             						+'<div class="form-group">'	
             						+'<label for="" class="col-sm-3 control-label">Term Exam / Assessment Name <span class="at-required-highlight">*</span></label> '
                                    +'<div class="col-sm-6"> '
                                    +' <input type="text" name="termExam1termExamName'+j+'" class="form-control " id="termExam1termExamName'+j+'" required="required" maxlength="50">'
                                    +'</div>'
                                    +'</div>'
                                    +'<div class="form-group">'	
             						+'<label for="" class="col-sm-3 control-label">Term Exam / Assessment Weightage (Percentage) <span class="at-required-highlight">*</span></label> '
                                    +'<div class="col-sm-6"> '
                                    +' <input type="text" name="termExam1termExamPercentage'+j+'" class="form-control " id="termExam1termExamPercentage'+j+'" required="required" maxlength="50" onkeypress="return isFloatNumber(this,event)">'
                                    +'</div>'
                                    +'</div>'
                                    +'</div>'); 
             		          	});

               	$("#addTerm").click(function()
                    	{
               		
                    		i=i+1;
                    		j=j+1;
                    		var term="term"+i;
                    		var termexam="termExam"+i;
                    		var widget="widget"+i;
                    		 $(".terms").append('<div class="dismiss">'
                    		+'<div id='+widget+'  class="card-box" style="box-shadow: 0 0px 8px 0 rgba(94, 194, 179, 0.67), 0 1px 0px 0 rgba(12, 236, 133, 0)">'
                    		+'<h4 class="m-t-0 header-title" style="color:purple;"><b>Exam / Assessment Template Details</b></h4>'
                    		 +'<div class="row" >'
                            +'<div class="col-lg-12">'
                    		+'<div id='+term+'><h3 class="title"><button style="float:right" type="button" class="btn btn-info remove addTermRemove" data-dismiss="dismiss" aria-hidden="true"><i class="fa fa-remove" aria-hidden="true"></i></button></h3>'
                    		+'<div class="dismiss"><div class="form-group">'
                   			+' <label for="" class="col-sm-3 control-label">Term Name<span class="at-required-highlight">*</span></label> '
                   			+' <div class="col-sm-6"> '
                   			+' <input type="text" name="'+term+'termName'+i+'" class="form-control" id="'+term+'termName'+i+'" required="required" maxlength="50">'
                   			+' </div></div>'
                   			+' </div>'	
                   			+'</div>'
                   			+'<div id='+termexam+'><h3 class="title"><button style="float:right"  type="button" id='+termexam+' class="btn btn-success btn-custom waves-effect waves-light addTermExam" ><i class="fa fa-plus-circle" aria-hidden="true"></i>&nbsp;Add Term Exam</button></h3>'
                   			+'<div class="dismiss">'
                   			+'<div class="form-group " >'
                            +'<label for="" class="col-sm-3 control-label">Term Exam / Assessment Name <span class="at-required-highlight">*</span></label> '
                            +'<div class="col-sm-6"> '
                            +' <input type="text" name="'+termexam+'termExamName'+j+'" class="form-control" id="'+termexam+'termExamName'+j+'" required="required" maxlength="50">'
                            +'</div>'
                   			+' </div>'  
                   			+'<div class="form-group " >'
                            +'<label for="" class="col-sm-3 control-label">Term Exam / Assessment Weight (Percentage) <span class="at-required-highlight">*</span></label> '
                            +'<div class="col-sm-6"> '
                            +' <input type="text" name="'+termexam+'termExamPercentage'+j+'" class="form-control" id="'+termexam+'termExamPercentage'+j+'" required="required" maxlength="50" onkeypress="return isFloatNumber(this,event)">'
                            +'</div>'
                   			+' </div>'
                   			+' </div>'
                   			+' </div>'	
                   			+'</div>'
                   			+'</div>'
                   			+'</div>'
                   			+'</div>'
                			); 
                    		
                    		
                  	});
                    	
               	$(document).on("click",".addTermExam",function(event){
       	    	 var termExamId=this.id;
       	    	 j=j+1;
    			 $("#"+termExamId).append(' <div class="dismiss">'
  				        +'<h3 class="title"><button style="float:right" type="button" class="btn btn-info remove" data-dismiss="dismiss" aria-hidden="true"><i class="fa fa-remove" aria-hidden="true"></i></button></h3>'
    					 +'<div class="form-group">'
    					 +'<label for="" class="col-sm-3 control-label">Term Exam  / Assessment Name <span class="at-required-highlight">*</span></label> '
    					 +'<div class="col-sm-6"> '
    					 +' <input type="text" name="'+termExamId+'termExamName'+j+'" class="form-control" id="'+termExamId+'termExamName'+j+'" required="required" maxlength="50">'
    					 +'</div>'
    					 +'</div>'
    					   +'<div class="form-group">'	
    						+'<label for="" class="col-sm-3 control-label">Term Exam / Assessment Weight Percentage <span class="at-required-highlight">*</span></label> '
                           +'<div class="col-sm-6"> '
      					 +' <input type="text" name="'+termExamId+'termExamPercentage'+j+'" class="form-control" id="'+termExamId+'termExamPercentage'+j+'" required="required" maxlength="50" onkeypress="return isFloatNumber(this,event)">'
                           +'</div>'
                           +'</div>'
    					 +'</div>');	
       	    	 });
               	
           
           
               	
               	
               	
               	
               	$(document).on("click",".addTermRemove",function(event)
          			   {
          		   			i=i-1;
          			   });
               	
               	$("#examTemplateSave").click(function(event) {
        			
               		if($("#examTemplateForm").valid())
        			{
        			   
        				var termExamarr=[];
        				var termarr=[];
        				
        				
               			for(k=1;k<=i;k++)
               			{
               				
               				var term="term"+k;	
               				var termname=term+"termName"+k;
               				var termexam="termExam"+k;
               				//var inputCount = document.getElementById(termexam).getElementsByTagName('input').toString();
               				if(document.getElementById(termexam))
               					{
               				var container = document.getElementById(termexam);
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
                   			    termExamarr.push(names+"-"); 
               					}
                   			    if($("#"+termname).val()!="")
                   			    {
                   			    	termarr.push(termname);
                   			    }
            			     
               		    
               			}
               			
               			//alert(termarr);
               			//alert(termExamarr);
               		 $("#termIds").val(termarr);
               		 $("#termExamIds").val(termExamarr);
               		 
               		// alert(arr);
        				 $("#examTemplateSaveConfirmation").modal('show');
       	        			$("#examTemplateSaveConfirm").click(function(){
       	        				$(".loader").show();
       	        			$("#examTemplateForm").submit();
       	        		});
       	        		
        			}
        			
        		});
               	
               	
       	$("#examTemplateUpdate").click(function(event) {
        			
               		if($("#examTemplateForm").valid())
        			{
        			   
        				var termExamarr=[];
        				var termarr=[];
        				for(k=1;k<=y;k++)
               			{
               				var term="editterm"+k;	
               				var termname=term+"edittermName"+k;
               				var termexam="edittermExam"+k;
               				//var inputCount = document.getElementById(termexam).getElementsByTagName('input').toString();
               				if(document.getElementById(termexam))
               					{
               				var container = document.getElementById(termexam);
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
                   			    termExamarr.push(names+"/"); 
               					}
               				if(document.getElementById(term))
           					{
               					var container = document.getElementById(term);
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
               			  
               			   termarr.push(names); 
           					}
               					/*if($("#"+termname).val()!="")
                   			    {
                   			    	termarr.push(termname);
                   			    }*/
           					
               		    
               			}
               		
        				/*alert(termarr);
               			alert(termExamarr);*/
               		 $("#edittermIds").val(termarr);
               		 $("#edittermExamIds").val(termExamarr);
               		 
               		// alert(arr);
        				 $("#examTemplateSaveConfirmation").modal('show');
       	        			$("#examTemplateSaveConfirm").click(function(){
       	        				$(".loader").show();
       	        			$("#updateExamTemplateForm").submit();
       	        		});
       	        		
        			}
        			
        		});
               	
               	$('#examTemplateList').on( 'click', 'tr td a#delete', function () {
               	 var deleteExamTemplateId = $(this).attr('data-id');
               	 $('#confirm_delete_examTemplate').on('show.bs.modal', function (e) {
               		 $("#confirmDeleteExamTemplate").click(function(event) {
               			 $("#deleteExamTemplateId").val(deleteExamTemplateId);
               			$(".loader").show();
               			 $("#deleteExamTemplateForm").submit();  
               		});
               		});
               	   
               });
               	
               	
               	$('#examTemplateList').on( 'click', 'tr td a#edit', function () {
               	 var examTemplateId = $(this).attr('data-id');
               	$('.loader').show();
               			   $.ajax({
               				   url:ctx+'/exam/template/editRetrieve',
               				   data:{examTemplateId:examTemplateId},
               				   type:'GET',
               				   success: function(response)
               				   {
               					$('.loader').hide();
               					if(response.examTemplateName!=null)
         					    {
         						   $("[name=editExamTemplateName]").val(response.examTemplateName);
         		     	        	   $("#editExamTemplateId").val(examTemplateId);
         					    }	
               					
               					$.each(response.terms, function(key,value) 
    	         	        	 { 
    	        				      if(key==0)
    	        				       {
    	        					  
      	                        		var term="editterm"+y;
      	                        		var termexam="edittermExam"+y;
      	                        		var termsname=term+'edittermName'+y;
      	                        		var widget="widget"+i;
      	                        		 $(".editterms").append('<div class="dismiss">'
      	                        		+'<div id='+widget+' class="card-box" style="box-shadow: 0 0px 8px 0 rgba(94, 194, 179, 0.67), 0 1px 0px 0 rgba(12, 236, 133, 0)">'
      	                        		+'<div id='+term+'><h3 class="title"></h3>'
      	                        		+'<div class="dismiss"><div class="form-group">'
      	                       			+' <label for="" class="col-sm-3 control-label">Term Name<span class="at-required-highlight">*</span></label> '
      	                       			+' <div class="col-sm-6"> '
      	                       			+' <input type="text" name="'+termsname+'-'+value.termId+'" class="form-control" id="'+termsname+'-'+value.termId+'" required="required" maxlength="50">'
      	                       			+' </div></div>'
      	                       			+' </div>'	
      	                       			+'</div>'
      	                       			+'<div id='+termexam+'><h3 class="title"><button style="float:right"  type="button" id='+termexam+' class="btn btn-success btn-custom waves-effect waves-light editaddTermExam" ><i class="fa fa-plus-circle" aria-hidden="true"></i>&nbsp;Add Term Exam</button></h3>'
      	                       			+' </div>'
      	                       		 	+'</div>'
      	                       			+'</div>'
      	                    			); 
      	                        		   if(value.termName!=null)
                    					       {
                    						      $("#"+termsname+"-"+value.termId).val(value.termName);
                    		     	           }	
                                  	
      	                        		 
      	                        		   $.each(value.termExams, function(key1,value1) 
      	    	           	         	   { 
      	                        			   if(key1==0)
      	    	        				       {
      	    	        					    			var termexamname=termexam+"edittermExamName"+y;
      	    	        					    		 	var termexamnamepercentage=termexam+"edittermExamPercentage"+y;
      	    	        				             		$("#"+termexam).append('<div class="dismiss">'
      	    	    	        	                       			+'<div class="form-group " >'
      	    	    	        	                                +'<label for="" class="col-sm-3 control-label">Term Exam / Assessment Name <span class="at-required-highlight">*</span></label> '
      	    	    	        	                                +'<div class="col-sm-6"> '
      	    	    	        	                                +' <input type="text" name="'+termexamname+'-'+value1.termExamId+'" class="form-control" id="'+termexamname+'-'+value1.termExamId+'" required="required" maxlength="50">'
      	    	    	        	                                +'</div>'
      	    	    	        	                                +' </div>' 
      	    	    	        	                                +'<div class="form-group">'	
      	    	    	            	      						+'<label for="" class="col-sm-3 control-label">Term Exam / Assessment Weight (Percentage) <span class="at-required-highlight">*</span></label> '
      	    	    	            	                             +'<div class="col-sm-6"> '
      	    	    	            	        					 +' <input type="text" name="'+termexamnamepercentage+'-'+value1.termExamId+'" class="form-control" id="'+termexamnamepercentage+'-'+value1.termExamId+'" required="required" maxlength="50" onkeypress="return isFloatNumber(this,event)">'
      	    	    	            	                             +'</div>'
      	    	    	            	                             +'</div>'
      	    	    	        	                       			+' </div>'); 
      	    	        				             		
      	    	        	                       		
      	    	        				             		if(value1.termExamName!=null)
      	                               					    {
      	                               						   $("#"+termexamname+"-"+value1.termExamId).val(value1.termExamName);
      	                               		     	        }	
      	    	        				             		if(value1.termPercentege!=null)
      	                               					    {
      	                               						   $("#"+termexamnamepercentage+"-"+value1.termExamId).val(value1.termPercentege);
      	                               		     	        }	
      	    	        				       }else
      	    	        				       {
      	    	        				    	  
     	        					    		 	var termexamname=termexam+"edittermExamName"+y;
     	        					    			var termexamnamepercentage=termexam+"edittermExamPercentage"+y;
     	        				             		$("#"+termexam).append('<div class="dismiss">'
     	    	        	                       			+'<div class="form-group " >'
     	    	        	                                +'<label for="" class="col-sm-3 control-label">Term Exam Name <span class="at-required-highlight">*</span></label> '
     	    	        	                                +'<div class="col-sm-6"> '
     	    	        	                                +' <input type="text" name="'+termexamname+'-'+value1.termExamId+'" class="form-control" id="'+termexamname+'-'+value1.termExamId+'" required="required" maxlength="50">'
     	    	        	                                +'</div>'
     	    	        	                                +'<button style="float:left" type="button" class="btn btn-info" data-dismiss="dismiss" aria-hidden="true"><i class="fa fa-remove" aria-hidden="true"></i></button>'
     	    	        	                                +' </div>' 
     	    	        	                             +'<div class="form-group">'	
   				             						+'<label for="" class="col-sm-3 control-label">Term Exam Percentage <span class="at-required-highlight">*</span></label> '
   				                                    +'<div class="col-sm-6"> '
   				                                    +' <input type="text" name="'+termexamnamepercentage+'-'+value1.termExamId+'" class="form-control " id="'+termexamnamepercentage+'-'+value1.termExamId+'" required="required" maxlength="50" onkeypress="return isFloatNumber(this,event)">'
   				                                    +'</div>'
   				                                    +'</div>'
     	    	        	                       			+' </div>'); 
     	        				             		
     	        	                       		
     	        				             		if(value1.termExamName!=null)
                                					    {
                                						   $("#"+termexamname+"-"+value1.termExamId).val(value1.termExamName);
                                		     	        }	
     	        				             		if(value1.termPercentege!=null)
     	        				             		{
     	        				             			$("#"+termexamnamepercentage+"-"+value1.termExamId).val(value1.termPercentege);
     	        				             		}	
      	    	        				       }  
      	    	           	         	    });
    	        					    
    	        				      }else
    	        				      {
    	        					    y=y+1;
    	        					    var term="editterm"+y;
    	                        		var termexam="edittermExam"+y;
    	                        		var termsname=term+'edittermName'+y;
    	                        		var widget="widget"+i;
    	                        		 $(".editterms").append('<div class="dismiss">'
    	                        		+'<div id='+widget+' class="card-box" style="box-shadow: 0 0px 8px 0 rgba(94, 194, 179, 0.67), 0 1px 0px 0 rgba(12, 236, 133, 0)">'
    	                        		+'<div id='+term+'><h3 class="title"><button style="float:right" type="button" class="btn btn-info remove" data-dismiss="dismiss" aria-hidden="true"><i class="fa fa-remove" aria-hidden="true"></i></button></h3>'
    	                        		+'<div class="dismiss"><div class="form-group">'
    	                       			+' <label for="" class="col-sm-3 control-label">Term Name<span class="at-required-highlight">*</span></label> '
    	                       			+' <div class="col-sm-6"> '
    	                       			+' <input type="text" name="'+termsname+'-'+value.termId+'" class="form-control" id="'+termsname+'-'+value.termId+'" required="required" maxlength="50">'
    	                       			+' </div></div>'
    	                       			+' </div>'	
    	                       			+'</div>'
    	                       			+'<div id='+termexam+'><h3 class="title"><button style="float:right"  type="button" id='+termexam+' class="btn btn-success btn-custom waves-effect waves-light editaddTermExam" ><i class="fa fa-plus-circle" aria-hidden="true"></i>&nbsp;Add Term Exam</button></h3>'
    	                       			+' </div>'
    	                       		 	+'</div>'
    	                       			+'</div>'
    	                    			); 
    	                        		   if(value.termName!=null)
                  					       {
                  						      $("#"+termsname+'-'+value.termId).val(value.termName);
                  		     	           }	
                                	
    	                        		 
    	                        		   $.each(value.termExams, function(key1,value1) 
    	    	           	         	   { 
    	                        			   if(key1==0)
    	    	        				       {
    	    	        					    		
    	    	        					    		 	var termexamname=termexam+"edittermExamName"+y;
    	    	        					    		 	var termexamnamepercentage=termexam+"edittermExamPercentage"+y;
    	    	        				             		$("#"+termexam).append('<div class="dismiss">'
    	    	    	        	                       			+'<div class="form-group " >'
    	    	    	        	                                +'<label for="" class="col-sm-3 control-label">Term Exam / Assessment Name <span class="at-required-highlight">*</span></label> '
    	    	    	        	                                +'<div class="col-sm-6"> '
    	    	    	        	                                +' <input type="text" name="'+termexamname+'-'+value1.termExamId+'" class="form-control" id="'+termexamname+'-'+value1.termExamId+'" required="required" maxlength="50">'
    	    	    	        	                                +'</div>'
    	    	    	        	                                +' </div>' 
    	    	    	        	                                +'<div class="form-group">'	
    	    	    	            	      						+'<label for="" class="col-sm-3 control-label">Term Exam / Assessment Weight (Percentage) <span class="at-required-highlight">*</span></label> '
    	    	    	            	                             +'<div class="col-sm-6"> '
    	    	    	            	        					 +' <input type="text" name="'+termexamnamepercentage+'-'+value1.termExamId+'" class="form-control" id="'+termexamnamepercentage+'-'+value1.termExamId+'" required="required" maxlength="50" onkeypress="return isFloatNumber(this,event)">'
    	    	    	            	                             +'</div>'
    	    	    	            	                             +'</div>'
    	    	    	        	                       			+' </div>'); 
    	    	        				             		
    	    	        	                       		
    	    	        				             		if(value1.termExamName!=null)
    	                               					    {
    	                               						   $("#"+termexamname+'-'+value1.termExamId).val(value1.termExamName);
    	                               		     	        }	
    	    	        				             		if(value1.termPercentege!=null)
    	                               					    {
    	                               						   $("#"+termexamnamepercentage+'-'+value1.termExamId).val(value1.termPercentege);
    	                               		     	        }	
    	    	        				       }else
    	    	        				       {
    	    	        				    	 
   	        					    		 	var termexamname=termexam+"edittermExamName"+y;
   	        					    			var termexamnamepercentage=termexam+"edittermExamPercentage"+y;
   	        				             		$("#"+termexam).append('<div class="dismiss">'
   	    	        	                       			+'<div class="form-group " >'
   	    	        	                                +'<label for="" class="col-sm-3 control-label">Term Exam / Assessment Name <span class="at-required-highlight">*</span></label> '
   	    	        	                                +'<div class="col-sm-6"> '
   	    	        	                                +' <input type="text" name="'+termexamname+'-'+value1.termExamId+'" class="form-control" id="'+termexamname+'-'+value1.termExamId+'" required="required" maxlength="50">'
   	    	        	                                +'</div>'
   	    	        	                                +'<button style="float:left" type="button" class="btn btn-info" data-dismiss="dismiss" aria-hidden="true"><i class="fa fa-remove" aria-hidden="true"></i></button>'
   	    	        	                                +' </div>' 
   	    	        	                             +'<div class="form-group">'	
 				             						+'<label for="" class="col-sm-3 control-label">Term Exam Percentage <span class="at-required-highlight">*</span></label> '
 				                                    +'<div class="col-sm-6"> '
 				                                    +' <input type="text" name="'+termexamnamepercentage+'-'+value1.termExamId+'" class="form-control " id="'+termexamnamepercentage+'-'+value1.termExamId+'" required="required" maxlength="50" onkeypress="return isFloatNumber(this,event)">'
 				                                    +'</div>'
 				                                    +'</div>'
   	    	        	                       			+' </div>'); 
   	        				             		
   	        	                       		
   	        				             		if(value1.termExamName!=null)
                              					    {
                              						   $("#"+termexamname+'-'+value1.termExamId).val(value1.termExamName);
                              		     	        }	
   	        				             		if(value1.termPercentege!=null)
   	        				             		{
   	        				             			$("#"+termexamnamepercentage+'-'+value1.termExamId).val(value1.termPercentege);
   	        				             		}	
    	    	        				       }  
    	    	           	         	    });
    	                        		   
    	        				   }	
    	         				});
               					  
               				   }
               				 });
               	   
               });
               	
               	
             	$("#editaddTermExam").click(function()
                    	{
             		x=x+1;
             		$("#edittermExam1").append('<div class="dismiss">'	
             						+'<div class="form-group">'	
             						+'<label for="" class="col-sm-3 control-label">Term Exam Name <span class="at-required-highlight">*</span></label> '
                                    +'<div class="col-sm-6"> '
                                    +' <input type="text" name="edittermExam1termExamName'+x+'" class="form-control " id="edittermExam1termExamName'+x+'" required="required" maxlength="50">'
                                    +'</div>'
                                    +'<button style="float:left" type="button" class="btn btn-info" data-dismiss="dismiss" aria-hidden="true"><i class="fa fa-remove" aria-hidden="true"></i></button>'
                                    +'</div>'
                                    +'<div class="form-group">'	
             						+'<label for="" class="col-sm-3 control-label">Term Exam Percentage <span class="at-required-highlight">*</span></label> '
                                    +'<div class="col-sm-6"> '
                                    +' <input type="text" name="edittermExam1termExamPercentage'+x+'" class="form-control " id="edittermExam1termExamPercentage'+x+'" required="required" maxlength="50" onkeypress="return isFloatNumber(this,event)">'
                                    +'</div>'
                                    +'</div>'
                                    +'</div>'); 
             		          	});

               	$("#editaddTerm").click(function()
                    	{
               		
                    		y=y+1;
                    		x=x+1;
                    		var term="editterm"+y;
                    		var termexam="edittermExam"+y;
                    		var widget="editwidget"+y;
                    		 $(".editterms").append('<div class="dismiss">'
                    		+'<div id='+widget+ ' class="card-box" style="box-shadow: 0 0px 8px 0 rgba(94, 194, 179, 0.67), 0 1px 0px 0 rgba(12, 236, 133, 0)">'
                    		+'<h4 class="m-t-0 header-title" style="color:purple;"><b>Exam Template Details</b></h4>'
                   		 
                    		+'<div id='+term+'><h3 class="title"><button style="float:right" type="button" class="btn btn-info editremove" data-dismiss="dismiss" aria-hidden="true"><i class="fa fa-remove" aria-hidden="true"></i></button></h3>'
                    		+'<div class="dismiss"><div class="form-group">'
                   			+' <label for="" class="col-sm-3 control-label">Term Name<span class="at-required-highlight">*</span></label> '
                   			+' <div class="col-sm-6"> '
                   			+' <input type="text" name="'+term+'termName'+y+'" class="form-control" id="'+term+'termName'+y+'" required="required" maxlength="50">'
                   			+' </div></div>'
                   			+' </div>'	
                   			+'</div>'
                   			+'<div id='+termexam+'><h3 class="title"><button style="float:right"  type="button" id='+termexam+' class="btn btn-success btn-custom waves-effect waves-light editaddTermExam" ><i class="fa fa-plus-circle" aria-hidden="true"></i>&nbsp;Add Term Exam</button></h3>'
                   			+'<div class="dismiss">'
                   			+'<div class="form-group " >'
                            +'<label for="" class="col-sm-3 control-label">Term Exam Name <span class="at-required-highlight">*</span></label> '
                            +'<div class="col-sm-6"> '
                            +' <input type="text" name="'+termexam+'termExamName'+x+'" class="form-control" id="'+termexam+'termExamName'+x+'" required="required" maxlength="50">'
                            +'</div>'
                   			+' </div>'  
                   			+'<div class="form-group " >'
                            +'<label for="" class="col-sm-3 control-label">Term Exam Percentage <span class="at-required-highlight">*</span></label> '
                            +'<div class="col-sm-6"> '
                            +' <input type="text" name="'+termexam+'termExamPercentage'+x+'" class="form-control" id="'+termexam+'termExamPercentage'+x+'" required="required" maxlength="50" onkeypress="return isFloatNumber(this,event)">'
                            +'</div>'
                   			+' </div>'
                   			+' </div>'
                   			+' </div>'	
                   			+'</div>'
                   			+'</div>'
                   			
                			); 
                    		
                    		
                  	});
                    	
               	$(document).on("click",".editaddTermExam",function(event){
       	    	 var termExamId=this.id;
       	    	 x=x+1;
    			 $("#"+termExamId).append(' <div class="dismiss">'
    					 +'<div class="form-group">'
    					 +'<label for="" class="col-sm-3 control-label">Term Exam Name <span class="at-required-highlight">*</span></label> '
    					 +'<div class="col-sm-6"> '
    					 +' <input type="text" name="'+termExamId+'termExamName'+x+'" class="form-control" id="'+termExamId+'termExamName'+x+'" required="required" maxlength="50">'
    					 +'</div>'
    					 +'<button style="float:left" type="button" class="btn btn-info" data-dismiss="dismiss" aria-hidden="true"><i class="fa fa-remove" aria-hidden="true"></i></button>'
    					 +'</div>'
    					  +'<div class="form-group">'	
   						+'<label for="" class="col-sm-3 control-label">Term Exam Percentage <span class="at-required-highlight">*</span></label> '
                          +'<div class="col-sm-6"> '
                          +' <input type="text" name="'+termExamId+'termExamPercentage'+x+'" class="form-control " id="'+termExamId+'termExamPercentage'+x+'" required="required" maxlength="50" onkeypress="return isFloatNumber(this,event)">'
                          +'</div>'
                          +'</div>'
    					 +'</div>');	
       	    	 });
               	
               /*	$(document).on("click",".editremove",function(event)
          			   {
          		   			y=y-1;
          			   });*/
               	
               	
        	      });
      
           /** Numbers Only**/
           function isNumber(evt) {
          	    evt = (evt) ? evt : window.event;
          	    var charCode = (evt.which) ? evt.which : evt.keyCode;
          	    if (charCode > 31 && (charCode < 48 || charCode > 57)) {
          	    	$("#examTemplateForm").before(
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
           
         