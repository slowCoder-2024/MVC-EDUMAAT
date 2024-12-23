           $(document).ready(function() {
        		var ctx= window.location.pathname.substring(0, window.location.pathname.indexOf("/",2));
        		/*  $('body').on('focus',".timedropper", function(){
        				$(this).timeDropper({
        					format:'HH:mm',
        					autoswitch:true
        				});
        			  });*/
        		  $(".timedropper").timeDropper(
        				  {
        					format:'HH:mm',
        					autoswitch:true ,
         				    setCurrentTime: false
        					  });
         	   var i=1;
         	   var j=1;
         	   var x=1;
         	   var y=1;

         	
              
                	$("#addTimeTableDay").click(function()
                     	{
                		
                			i=i+1;
                     		var timeTableDay="timeTableDay"+i;
                     		var widget="widget"+i;
                     		 $(".Days").append('<div class="dismiss">'
                     				
                     		+'<div id='+timeTableDay+'><h3 class="m-t-0 header-title" style="color:green;">Day <button style="float:right" type="button" class="btn btn-info removeDays" data-dismiss="dismiss" aria-hidden="true"><i class="fa fa-remove" aria-hidden="true"></i></button></h3>'
                     			+'<div class="form-group">'
                    			+' <label for="" class="col-sm-3 control-label">Day Name <span class="at-required-highlight">*</span></label> '
                    			+'<div class="col-sm-6"> '
                    			+'<select name="'+timeTableDay+'dayName'+i+'" id="'+timeTableDay+'dayName'+i+'" class="selectpicker" data-live-search="true"  data-style="btn-white" required="required">'
                    			+' <option value="" disabled selected>Select Day</option>'
                    			+' <option value="Sunday">Sunday</option>'
                    			+'<option value="Monday">Monday</option>'
                    			+' <option value="Tuesday">Tuesday</option>'
                    			+'  <option value="Wednesday">Wednesday</option>'
                    			+'<option value="Thursday">Thursday</option>'
                    			+' <option value="Friday">Friday</option>'
                    			+' <option value="Saturday">Saturday</option>'
                    			+'</select>         '                        
                    			+'</div>'
                    		
                    			+'</div>'
                    			+' </div>'
                    			+' </div>'
                 			); 
                     		 
                     		$('.selectpicker').selectpicker('show');
                     		
                   	});
                     	
                	
            
                	$("#addHour").click(function(event)
                         	{
                  		j=j+1;
                  		var timeTableHour="timeTableHour"+j;
                  		$(".Hours").append('<div class="dismiss">'
                  				
                  				+'<div id='+timeTableHour+'><button style="float:right" type="button" class="btn btn-info removeHours" data-dismiss="dismiss" aria-hidden="true"><i class="fa fa-remove" aria-hidden="true"></i></button><h3 class="m-t-0 header-title" style="color:green;">Hour</h3>'
                         		+'<div class="form-group">'	
                  						+'<label for="" class="col-sm-3 control-label">Hour Name <span class="at-required-highlight">*</span></label> '
                                         +'<div class="col-sm-6"> '
                                         +' <input type="text" name="'+timeTableHour+'hourName'+j+'" class="form-control " id="'+timeTableHour+'hourName'+j+'" required="required" maxlength="150">'
                                         +'</div>'
                                         +'</div>'
                                        +' <div class="form-group ">'
                                        +' <label for="" class="col-sm-3 control-label">Hour Start Time <span class="at-required-highlight">*</span></label> '
                                        +' <div class="col-sm-6"> '
                                        +'     <input type="text" name="'+timeTableHour+'startTime'+j+'" class="form-control timedropper" id="'+timeTableHour+'startTime'+j+'" required="required" maxlength="50">'
                                        +'  </div> '
                                        +' </div>'
                                        +'  <div class="form-group ">'
                                        +' <label for="" class="col-sm-3 control-label">Hour End Time <span class="at-required-highlight">*</span></label> '
                                        +' <div class="col-sm-6"> '
                                        +'    <input type="text" name="'+timeTableHour+'endTime'+j+'" class="form-control timedropper"  id="'+timeTableHour+'endTime'+j+'" required="required" maxlength="50">'
                                        +' </div> '
                                       
                                        +' </div>'
                                        +' </div>'
                                         +'</div>'); 
                  		
                  		  $("#"+timeTableHour+"startTime"+j).timeDropper(
      				     {
      					format:'HH:mm',
      					autoswitch:true ,
     				    setCurrentTime: false
      					  });
                  		$("#"+timeTableHour+"endTime"+j).timeDropper(
             				     {
             					format:'HH:mm',
             					autoswitch:true ,
             				    setCurrentTime: false
             					  });
                  		          	});

/*                	$(document).on("click",".removeDays",function(event)
             			   {
             		   			i=i-1;
             			   });
                	
                	$(document).on("click",".removeHours",function(event)
              			   {
              		   			j=j-1;
              			   });*/
                	
                	
                	$("#editaddTimeTableDay").click(function()
                         	{
                    		
                    			x=x+1;
                         		var timeTableDay="edittimeTableDay"+x;
                         		var widget="editwidget"+x;
                         		 $(".editDays").append('<div class="dismiss">'
                         				
                         		+'<div id='+timeTableDay+'><h3 class="m-t-0 header-title" style="color:green;" >Day <button style="float:right" type="button" class="btn btn-info removeDays" data-dismiss="dismiss" aria-hidden="true"><i class="fa fa-remove" aria-hidden="true"></i></button></h3>'
                         			+'<div class="form-group">'
                        			+' <label for="" class="col-sm-3 control-label">Day Name <span class="at-required-highlight">*</span></label> '
                        			+'<div class="col-sm-6"> '
                        			+'<select name="'+timeTableDay+'dayName'+x+'" id="'+timeTableDay+'dayName'+x+'" class="editselectpicker" data-live-search="true"  data-style="btn-white" required="required">'
                        			+' <option value="" disabled selected>Select Day</option>'
                        			+' <option value="Sunday">Sunday</option>'
                        			+'<option value="Monday">Monday</option>'
                        			+' <option value="Tuesday">Tuesday</option>'
                        			+'  <option value="Wednesday">Wednesday</option>'
                        			+'<option value="Thursday">Thursday</option>'
                        			+' <option value="Friday">Friday</option>'
                        			+' <option value="Saturday">Saturday</option>'
                        			+'</select>         '                        
                        			
                        			+' </div>'
                        			+'</div>'
                        			+' </div>'
                        			+' </div>'
                     			); 
                         		$('.editselectpicker').selectpicker('show');
                       	});
                         	
                    	
                
                    	$("#editaddHour").click(function(event)
                             	{
                      		y=y+1;
                      		var timeTableHour="edittimeTableHour"+y;
                      		$(".editHours").append('<div class="dismiss">'
                      			
                      				+'<div id='+timeTableHour+'><button style="float:right" type="button" class="btn btn-info removeHours" data-dismiss="dismiss" aria-hidden="true"><i class="fa fa-remove" aria-hidden="true"></i></button><h3 class="m-t-0 header-title" style="color:green;">Hour</h3>'
                             		+'<div class="form-group">'	
                      						+'<label for="" class="col-sm-3 control-label">Hour Name <span class="at-required-highlight">*</span></label> '
                                             +'<div class="col-sm-6"> '
                                             +' <input type="text" name="'+timeTableHour+'hourName'+y+'" class="form-control " id="'+timeTableHour+'hourName'+y+'" required="required" maxlength="150">'
                                             +'</div>'
                                             +'</div>'
                                            +' <div class="form-group ">'
                                            +' <label for="" class="col-sm-3 control-label">Hour Start Time <span class="at-required-highlight">*</span></label> '
                                            +' <div class="col-sm-6"> '
                                            +'     <input type="text" name="'+timeTableHour+'startTime'+y+'" class="form-control timedropper" id="'+timeTableHour+'startTime'+y+'" required="required" maxlength="50">'
                                            +'  </div> '
                                            +' </div>'
                                            +'  <div class="form-group ">'
                                            +' <label for="" class="col-sm-3 control-label">Hour End Time <span class="at-required-highlight">*</span></label> '
                                            +' <div class="col-sm-6"> '
                                            +'    <input type="text" name="'+timeTableHour+'endTime'+y+'" class="form-control timedropper"  id="'+timeTableHour+'endTime'+y+'" required="required" maxlength="50">'
                                            +' </div> '
                                           
                                            +' </div>'
                                            +' </div>'
                                             +'</div>'); 
                      		
                      	  $("#"+timeTableHour+"startTime"+y).timeDropper(
                				     {
                					format:'HH:mm',
                					autoswitch:true ,
               				    setCurrentTime: false
                					  });
                            		$("#"+timeTableHour+"endTime"+y).timeDropper(
                       				     {
                       					format:'HH:mm',
                       					autoswitch:true ,
                       				    setCurrentTime: false
                       					  });
                      		          	});

                	$('#timeTableTemplateList').on( 'click', 'tr td a#delete', function () {
                   	 var deleteTimeTableTemplateId = $(this).attr('data-id');
                   	 $('#confirm_delete_timeTableTemplate').on('show.bs.modal', function (e) {
                   		 $("#confirmDeleteTimeTableTemplate").click(function(event) {
                   			 $("#deleteTimeTableTemplateId").val(deleteTimeTableTemplateId);
                   			 $(".loader").show();
                   			 $("#deleteTimeTableTemplateForm").submit();  
                   		});
                   		});
                   	   
                   });
                	
                	$("#timeTableTemplateSave").click(function(event) {
         			
                		$('#timeTableTemplateForm').validate({
            		        ignore: [],
            		        // any other options and/or rules
            		    });
                		if($("#timeTableTemplateForm").valid())
                		{
         			   
         				var timeTableHourarr=[];
         				var timeTableDayarr=[];
                			for(k=1;k<=i;k++)
                			{
                				var timeTableDay="timeTableDay"+k;	
                				var timeTableDayname=timeTableDay+"dayName"+k;
                		   
                				if(document.getElementById(timeTableDayname))
                				{
                					if($("#"+timeTableDayname).val()!="")
                					{
                						timeTableDayarr.push(timeTableDayname);
                					}
                				}
                		   
                			}
                			
                			for(m=1;m<=j;m++)
                			{
                				var timeTableHour="timeTableHour"+m;
                				if(document.getElementById(timeTableHour))
                				{
                				var container = document.getElementById(timeTableHour);
                			    var collection = container.getElementsByTagName('input');
                			    var names = "";
                			   for (var aj = 0; aj < collection.length; ++aj) 
                			    {
                			    	
                			    	if (collection[aj].getAttribute('id') != null)
                			    		{
                			    		  if($("#"+collection[aj].getAttribute('id')).val()!="")
                                			  {
                			    			  	names += collection[aj].getAttribute('id') + ",";
                                			  }
                			    		}
                			    }
                			 
                			    
                			    names = names.substring(0, names.length - 1);
                			    timeTableHourarr.push(names+"-"); 
                				}
                			}
                			//alert(timeTableDayarr);
                		//	alert(timeTableHourarr);
                		
                		 $("#timeTableDayIds").val(timeTableDayarr);
                		 $("#timeTableHourIds").val(timeTableHourarr);
                		 
                		// alert(arr);
         				 $("#timeTableTemplateSaveConfirmation").modal('show');
        	        			$("#timeTableTemplateSaveConfirm").click(function(){
        	        				 $(".loader").show();
        	        			$("#timeTableTemplateForm").submit();
        	        		});
        	        		
         			}
         			
         		});
                	
                	
                	
               
                	
                	$("#updateTimeTableTemplate").click(function(event) {
             			
                		$('#updateTimeTableTemplateForm').validate({
            		        ignore: [],
            		        // any other options and/or rules
            		    });
                		if($("#updateTimeTableTemplateForm").valid())
                		{
         			   
         				var timeTableHourarr=[];
         				var timeTableDayarr=[];
                			/*for(k=1;k<=x;k++)
                			{
                				var timeTableDay="edittimeTableDay"+k;	
                				var timeTableDayname=timeTableDay+"dayName"+k;
                		   
                				if(document.getElementById(timeTableDayname))
                				{
                					if($("#"+timeTableDayname).val()!="")
                					{
                						timeTableDayarr.push(timeTableDayname);
                					}
                				}
                		   
                			}*/
         					for(k=1;k<=x;k++)
                			{
                				
                				var timeTableDay="edittimeTableDay"+k;	
                				if(document.getElementById(timeTableDay))
                				{
                				var container = document.getElementById(timeTableDay);
                			    var collection = container.getElementsByTagName('input');
                			    var names = "";
                			   for (var aj = 0; aj < collection.length; ++aj) 
                			    {
                			    	
                			    	if (collection[aj].getAttribute('id') != null)
                			    		{
                			    		  if($("#"+collection[aj].getAttribute('id')).val()!="")
                                			  {
                			    			  	names += collection[aj].getAttribute('id') + ",";
                                			  }
                			    		}
                			    }
                			 
                			    
                			    names = names.substring(0, names.length - 1);
                			    timeTableDayarr.push(names); 
                				}
                			}
                			
                			for(m=1;m<=y;m++)
                			{
                				var timeTableHour="edittimeTableHour"+m;
                				if(document.getElementById(timeTableHour))
                				{
                				var container = document.getElementById(timeTableHour);
                			    var collection = container.getElementsByTagName('input');
                			    var names = "";
                			   for (var aj = 0; aj < collection.length; ++aj) 
                			    {
                			    	
                			    	if (collection[aj].getAttribute('id') != null)
                			    		{
                			    		  if($("#"+collection[aj].getAttribute('id')).val()!="")
                                			  {
                			    			  	names += collection[aj].getAttribute('id') + ",";
                                			  }
                			    		}
                			    }
                			 
                			    
                			    names = names.substring(0, names.length - 1);
                			    timeTableHourarr.push(names+"/"); 
                				}
                			}
                			//alert(timeTableDayarr);
                			//alert(timeTableHourarr);
                		
                		 $("#edittimeTableDayIds").val(timeTableDayarr);
                		 $("#edittimeTableHourIds").val(timeTableHourarr);
                		 
                		// alert(arr);
                		 $("#updatetimeTableTemplateId").val($(this).attr('data-id'));
                		
         				 $("#timeTableTemplateUpdateConfirmation").modal('show');
        	        			$("#timeTableTemplateUpdateConfirm").click(function(){
        	        			$("#updateTimeTableTemplateForm").submit();
        	        		});
        	        		
         			}
         			
         		});
                	
                	
                	var timeTableTemplateDays=new Array();
                	var timeTableTemplateHours=new Array();
                	
                	$('#timeTableTemplateList').on( 'click', 'tr td a#edit', function () {
                	 var timeTableTemplateId = $(this).attr('data-id');
                	 $('.loader').show();
                			   $.ajax({
                				   url:ctx+'/timetable/template/editRetrieve',
                				   data:{timeTableTemplateId:timeTableTemplateId},
                				   type:'GET',
                				   success: function(response)
                				   {
                				
                					   $('.loader').hide();
                					   $('.editselectpicker').selectpicker('destroy');
                					   if(response.timeTableName!=null)
                					   {
                						   $("[name=edittimeTableTemplateName]").val(response.timeTableName);
                		     	        	   
                					   }	
                					   timeTableTemplateDays=[];
                					   timeTableTemplateHours=[];
                	        			   $.each(response.timeTableTemplateDays, function(key,value) 
                	         	        	{ 
                	        				
                	        				   timeTableTemplateDays[key]=value.timeTableTemplateDayId;
                	        				   if(key==0)
                	        				   {
                	        					   var timeTableDay="edittimeTableDay"+x;
                                           		var widget="editwidget"+x;
                                           		 $(".editDays").append('<div class="dismiss">'
                                           				
                                           		+'<div id='+timeTableDay+'><h3 class="m-t-0 header-title" style="color:green;">Day </h3>'
                                           			+'<div class="form-group">'
                                        			+' <label for="" class="col-sm-3 control-label">Day Name <span class="at-required-highlight">*</span></label> '
                                        			+'<div class="col-sm-6"> '
                                        			+'<select name="'+timeTableDay+'dayName'+x+'-'+value.timeTableTemplateDayId+'" id="'+timeTableDay+'dayName'+x+'-'+value.timeTableTemplateDayId+'" class="editselectpicker" data-live-search="true"  data-style="btn-white" required="required">'
                                        			+' <option value="" disabled selected>Select Day</option>'
                                        			+' <option value="Sunday">Sunday</option>'
                                        			+'<option value="Monday">Monday</option>'
                                        			+' <option value="Tuesday">Tuesday</option>'
                                        			+'  <option value="Wednesday">Wednesday</option>'
                                        			+'<option value="Thursday">Thursday</option>'
                                        			+' <option value="Friday">Friday</option>'
                                        			+' <option value="Saturday">Saturday</option>'
                                        			+'</select>         '                        
                                        			+'</div>'
                                        			
                                          			+'</div>'
                                          			+' </div>'
                                          			+' </div>'
                                       			);
                                           		
                	        					   if(value.timeTableTemplateDayName!=null)
                            					   {
                	        						   $("#"+timeTableDay+"dayName"+x+"-"+value.timeTableTemplateDayId).val(value.timeTableTemplateDayName);
                            						      
                            					   }	
                	        				   }else{
                	        					   x=x+1;
                                            		var timeTableDay="edittimeTableDay"+x;
                                            		var widget="editwidget"+x;
                                            		 $(".editDays").append('<div class="dismiss">'
                                            				
                                            		+'<div id='+timeTableDay+'><h3 class="m-t-0 header-title" style="color:green;">Day <button style="float:right" type="button" class="btn btn-info removeDays" data-dismiss="dismiss" aria-hidden="true"><i class="fa fa-remove" aria-hidden="true"></i></button></h3>'
                                            		+'<div class="form-group">'
                                        			+' <label for="" class="col-sm-3 control-label">Day Name <span class="at-required-highlight">*</span></label> '
                                        			+'<div class="col-sm-6"> '
                                        			+'<select name="'+timeTableDay+'dayName'+x+'-'+value.timeTableTemplateDayId+'" id="'+timeTableDay+'dayName'+x+'-'+value.timeTableTemplateDayId+'" class="editselectpicker" data-live-search="true"  data-style="btn-white" required="required">'
                                        			+' <option value="" disabled selected>Select Day</option>'
                                        			+' <option value="Sunday">Sunday</option>'
                                        			+'<option value="Monday">Monday</option>'
                                        			+' <option value="Tuesday">Tuesday</option>'
                                        			+'  <option value="Wednesday">Wednesday</option>'
                                        			+'<option value="Thursday">Thursday</option>'
                                        			+' <option value="Friday">Friday</option>'
                                        			+' <option value="Saturday">Saturday</option>'
                                        			+'</select>         '                        
                                        			+'</div>'
                                        			
                                           			+'</div>'
                                           			+' </div>'
                                           			+' </div>'
                                        			);
                                            		 
                                            		
                                            	 if(value.timeTableTemplateDayName!=null)
                              					   {
                              						   $("#"+timeTableDay+"dayName"+x+"-"+value.timeTableTemplateDayId).val(value.timeTableTemplateDayName);
                              		     	        	   
                              					   }	
                                            	
                	        				   }	
                	         						});
                	        			   
                	        			   $('.editselectpicker').selectpicker('show');
                	        			   $.each(response.timeTableTemplateHours, function(key1,value1) 
       	         	      	        			{
                	        				   
                	        				   timeTableTemplateHours[key1]=value1.timeTableTemplateHourId;
                	        				   if(key1==0){
                	        					   var timeTableHour="edittimeTableHour"+y;
                   	                      		$(".editHours").append('<div class="dismiss">'
                   	                      				
                   	                      				+'<div id='+timeTableHour+'><h3 class="m-t-0 header-title" style="color:green;">Hour</h3>'
                   	                             		+'<div class="form-group">'	
                   	                      						+'<label for="" class="col-sm-3 control-label">Hour Name <span class="at-required-highlight">*</span></label> '
                   	                                             +'<div class="col-sm-6"> '
                   	                                             +' <input type="text" name="'+timeTableHour+'hourName'+y+'-'+value1.timeTableTemplateHourId+'" class="form-control " id="'+timeTableHour+'hourName'+y+'-'+value1.timeTableTemplateHourId+'" required="required" maxlength="150">'
                   	                                             +'</div>'
                   	                                             +'</div>'
                   	                                            +' <div class="form-group ">'
                   	                                            +' <label for="" class="col-sm-3 control-label">Hour Start Time <span class="at-required-highlight">*</span></label> '
                   	                                            +' <div class="col-sm-6"> '
                   	                                            +'     <input type="text" name="'+timeTableHour+'startTime'+y+'-'+value1.timeTableTemplateHourId+'" class="form-control timedropper" id="'+timeTableHour+'startTime'+y+'-'+value1.timeTableTemplateHourId+'" required="required" maxlength="50">'
                   	                                            +'  </div> '
                   	                                            +' </div>'
                   	                                            +'  <div class="form-group ">'
                   	                                            +' <label for="" class="col-sm-3 control-label">Hour End Time <span class="at-required-highlight">*</span></label> '
                   	                                            +' <div class="col-sm-6"> '
                   	                                            +'    <input type="text" name="'+timeTableHour+'endTime'+y+'-'+value1.timeTableTemplateHourId+'" class="form-control timedropper"  id="'+timeTableHour+'endTime'+y+'-'+value1.timeTableTemplateHourId+'" required="required" maxlength="50">'
                   	                                            +' </div> '
                   	                                           
                   	                                            +' </div>'
                   	                                            +' </div>'
                   	                                             +'</div>');
                   	                      		
                   	                      	if(value1.timeTableTemplateHourName!=null)
                             					   {
                             						   $("#"+timeTableHour+"hourName"+y+"-"+value1.timeTableTemplateHourId).val(value1.timeTableTemplateHourName);
                             		     	        	   
                             					   }	
                 	        					   if(value1.timeTableTemplateHourStartTime!=null)
                             					   {
                             						   $("#"+timeTableHour+"startTime"+y+"-"+value1.timeTableTemplateHourId).val(value1.timeTableTemplateHourStartTime);
                             		     	        	   
                             					   }	
                 	        					   if(value1.timeTableTemplateHourEndTime!=null)
                             					   {
                             						   $("#"+timeTableHour+"endTime"+y+"-"+value1.timeTableTemplateHourId).val(value1.timeTableTemplateHourEndTime);
                             		     	        	   
                             					   }
                	        					  	
                	        				   }else{
                	        		      		y=y+1;
                	                      		var timeTableHour="edittimeTableHour"+y;
                	                      		$(".editHours").append('<div class="dismiss">'
                	                      				
                	                      				+'<div id='+timeTableHour+'><button style="float:right" type="button" class="btn btn-info removeHours" data-dismiss="dismiss" aria-hidden="true"><i class="fa fa-remove" aria-hidden="true"></i></button><h3 class="m-t-0 header-title" style="color:green;">Hour</h3>'
                	                             		+'<div class="form-group">'	
                	                      						+'<label for="" class="col-sm-3 control-label">Hour Name <span class="at-required-highlight">*</span></label> '
                	                                             +'<div class="col-sm-6"> '
                	                                             +' <input type="text" name="'+timeTableHour+'hourName'+y+'-'+value1.timeTableTemplateHourId+'" class="form-control " id="'+timeTableHour+'hourName'+y+'-'+value1.timeTableTemplateHourId+'" required="required" maxlength="150">'
                	                                             +'</div>'
                	                                             +'</div>'
                	                                            +' <div class="form-group ">'
                	                                            +' <label for="" class="col-sm-3 control-label">Hour Start Time <span class="at-required-highlight">*</span></label> '
                	                                            +' <div class="col-sm-6"> '
                	                                            +'     <input type="text" name="'+timeTableHour+'startTime'+y+'-'+value1.timeTableTemplateHourId+'" class="form-control timedropper" id="'+timeTableHour+'startTime'+y+'-'+value1.timeTableTemplateHourId+'" required="required" maxlength="50">'
                	                                            +'  </div> '
                	                                            +' </div>'
                	                                            +'  <div class="form-group ">'
                	                                            +' <label for="" class="col-sm-3 control-label">Hour End Time <span class="at-required-highlight">*</span></label> '
                	                                            +' <div class="col-sm-6"> '
                	                                            +'    <input type="text" name="'+timeTableHour+'endTime'+y+'-'+value1.timeTableTemplateHourId+'" class="form-control timedropper"  id="'+timeTableHour+'endTime'+y+'-'+value1.timeTableTemplateHourId+'" required="required" maxlength="50">'
                	                                            +' </div> '
                	                                           
                	                                            +' </div>'
                	                                            +' </div>'
                	                                             +'</div>');
                	                      		
                	                      	if(value1.timeTableTemplateHourName!=null)
                          					   {
                          						   $("#"+timeTableHour+"hourName"+y+"-"+value1.timeTableTemplateHourId).val(value1.timeTableTemplateHourName);
                          		     	        	   
                          					   }	
              	        					   if(value1.timeTableTemplateHourStartTime!=null)
                          					   {
                          						   $("#"+timeTableHour+"startTime"+y+"-"+value1.timeTableTemplateHourId).val(value1.timeTableTemplateHourStartTime);
                          		     	        	   
                          					   }	
              	        					   if(value1.timeTableTemplateHourEndTime!=null)
                          					   {
                          						   $("#"+timeTableHour+"endTime"+y+"-"+value1.timeTableTemplateHourId).val(value1.timeTableTemplateHourEndTime);
                          		     	        	   
                          					   }
              	        						
                	        				   }
                	        				   
                	        				   $("#"+timeTableHour+"startTime"+y+"-"+value1.timeTableTemplateHourId).timeDropper(
                	        	      				     {
                	        	      					format:'HH:mm',
                	        	      					autoswitch:true ,
                	        	      				    setCurrentTime: false
                	        	      					  });
                	        	                  		$("#"+timeTableHour+"endTime"+y+"-"+value1.timeTableTemplateHourId).timeDropper(
                	        	             				     {
                	        	             					format:'HH:mm',
                	        	             					autoswitch:true ,
                	        	             				    setCurrentTime: false
                	        	             					  });
       	         	      	        			});
       	         	        			
                	        		   $("#updateTimeTableTemplate").attr('data-id',response.timeTableTemplateId);
                					
                	        		 /*  $("#timeTableTemplateDayIds").val(timeTableTemplateDays);
                	        		   $("#timeTableTemplateHourIds").val(timeTableTemplateHours);
                					 */ //alert(timeTableTemplateHours);
                					 //alert(timeTableTemplateDays);
                	        	   }
                				 });
                	   
                });     
                	 
                	
           });
         
           
     //****Numbers Only***//
      
      function isNumber(evt) {
    	    evt = (evt) ? evt : window.event;
    	    var charCode = (evt.which) ? evt.which : evt.keyCode;
    	    if (charCode > 31 && (charCode < 48 || charCode > 57)) {
    	        return false;
    	    }
    	    return true;
    	}
    
    