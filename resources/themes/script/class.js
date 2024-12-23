     $(document).ready(function(){
    	 $('#classListWithOutExamConfigDataTable,#classListWithExamConfigDataTable').dataTable();
    	 var table = $("#example").dataTable();
    	 var ctx= window.location.pathname.substring(0, window.location.pathname.indexOf("/",2)); 
    	 
    	
    	 
    	 $("#addclass").click(function(){
    		 
    		 $("#addclassform").submit();
    		 
    		 
    		 
    	 });
    	 
     
    	 $("#assessmenttype").change(function(event){
    		 
    		 if($("#modulesBased").is(":checked")){
        			
    			 $( "#modulesBasedGradeMethod" ).addClass( "form-control-firststep" );
    			 $( "#modulesBasedGradeSystem" ).addClass( "form-control-firststep" );
        			
        		}else{
        			 $( "#modulesBasedGradeMethod" ).removeClass( "form-control-firststep" );
        			 $( "#modulesBasedGradeSystem" ).removeClass( "form-control-firststep" );
        		}
    			if($("#co-ScholasticActivity").is(":checked")){
    			
    				 $( "#coScholasticActivitiesGradeMethod" ).addClass( "form-control-firststep" );
        			 $( "#coScholasticActivitiesGradeSystem" ).addClass( "form-control-firststep" );
    			}else{
    				 $( "#coScholasticActivitiesGradeMethod" ).removeClass( "form-control-firststep" );
        			 $( "#coScholasticActivitiesGradeSystem" ).removeClass( "form-control-firststep" );
    		}
    			if($("#co-ScholasticArea").is(":checked")){
    				 $( "#coScholasticAreaGradeMethod" ).addClass( "form-control-firststep" );
        			 $( "#coScholasticAreaGradeSystem" ).addClass( "form-control-firststep" );
    			}else{
    				$( "#coScholasticAreaGradeMethod" ).removeClass( "form-control-firststep" );
       			 $( "#coScholasticAreaGradeSystem" ).removeClass( "form-control-firststep" );
		}
    			if($("#moduleAndSkillBased").is(":checked")){
    				
    				 $( "#moduleAndSkillBasedGradeMethod" ).addClass( "form-control-firststep" );
        			 $( "#moduleAndSkillBasedGradeSystem" ).addClass( "form-control-firststep" );
    				
    			}else{
    				$( "#moduleAndSkillBasedGradeMethod" ).removeClass( "form-control-firststep" );
       			 $( "#moduleAndSkillBasedGradeSystem" ).removeClass( "form-control-firststep" );
   		}
    	 });
    	 
    	/* $('#configureClassWithAssessmentTypeForm').validate({
    		 
    		 ignore: [],
  	 		 errorPlacement: function ($error, $element) {
  	             var name = $element.attr("name");   	             
  	 	             $("#error" + name).append($error);
  	         }     
  	});*/
    	 
    	 
         	$("#nextstep1").click(function(){
         		
         	
         		    	  
         		    	
         		    	  
         		    	  
         		    	 if($('#assessmenttype').find('input[type=checkbox]:checked').length !== 0)
              		    {
         		    		
         		    		current_fs = $('#firststep');
                       		next_fs = $('#secondstep');
                       		next_fs.show(); 
                       		current_fs.hide(); 
                       		
                       		
                       		if($("#modulesBased").is(":checked")){
                       			
                       			$("#modules-based-div").show();
                       			
                       			
                       		     
                       /*	        $('#sections option:selected').each(function(index){
                       	        	
                       	      
                       	         


                          	      
                       	        	if(index == 0){
                       	        			
                       	        		$(this).val();
                           	            
                       	        		$(".sectionname").attr('id',$(this).val());
                       	        		$(".sectionname").html($(this).text());
                       	        		
                       	        		
                       	        		
                       	        	}else{
                       	        		
                       	        	 
                       	        		var c = $('.modulesbasedclonepersection:first').clone().attr('id',"modulesbasedclonepersection"+ $(this).text());
                       	        		var sectionName=$(this).text();
                       	        		c.find('.sectionname').attr('id',$(this).val());
                       	        		c.find('.sectionname').html($(this).text());
                       	        		
                       	        	 c.find('.btnadd-modules-based').attr('id',$(this).text());
                       	        	 c.find('.btndel-modules-based').attr('name',$(this).text());
                       	                c.find('.btnadd-modules-based').addClass('btnadd-modules-based-in-'+$(this).text());
                       	             c.find('.btndel-modules-based').addClass('btndel-modules-based-in-'+$(this).text());
                       	        	
                       	             c.find('table tbody').attr('id',"modulesbasedinfo-"+$(this).text());
                       	          c.find('table tbody tr').attr('id',"clonedinputmodulesbased-"+$(this).text());
                       	       c.find('table tbody tr').attr('class',"clonedinputmodulesbased-"+$(this).text());
                       	        		c.find('td select').each (function () {
                                         this.id =this.id+'-'+sectionName;
                                         this.name=this.id;
                                         
                                         
                                         
                                     });
                       	        		
                       	        		
                       	        	 $('.modulesbasedclonepersection:last').after(c);
                       	        	}
                       	        	
                       	        	
                       	            
                       	            
                       	            
                       	  

                           		
                       	            
                       	            
                       	        });

                       			*/
                       			
                           	 
                           	 
                            	
                           	 
                           	 
                           	 
                           	
                       			
                       		}else{
                       			$("#modules-based-div").hide();
                       		
                       		}
							if($("#co-ScholasticActivity").is(":checked")){
							                       			
							        $("#co-scholastic-activities-div").show();
							                       			
							  }else{
							         $("#co-scholastic-activities-div").hide();
							                       			
							                       			
							          } 
							if($("#co-ScholasticArea").is(":checked")){
									
								$("#co-scholastic-area-div").show();
									
								}else{
									$("#co-scholastic-area-div").hide();
								} 
							if($("#moduleAndSkillBased").is(":checked")){
									
								$("#module-and-skill-based-div").show();
									
								}else{
									$("#module-and-skill-based-div").hide();
									
									
								} 
							
							
							
						
				    		  ////assessmenttype
				    		  var assessmentdetails= [];
				    	    	
							    table.find('.case:checked').each(function () {
							    	  
							    	$tds=$(this).closest("td").siblings("td");
							    	var optional=$tds.eq(3).find('input').val();
							    	
							    	if(optional===''||optional===undefined){
							    		optional=0;
							    	}
							    	
							    	assessmentdetails.push($.trim($tds.eq(0).text())+"-"+$tds.eq(1).find("option:selected").attr('value')+"-"+$tds.eq(2).find("option:selected").attr('value')+"-"+optional);
					        	
							            });
							    
							 
							    $("#assessmentDetails").val(assessmentdetails);
							    
							 
							    
							    
				    	  
              		    }                   			
         		    	 else{
         		    		edumaatAlert({
         		    			  title: "warning !",
         		    			  text: "Please select atleast one assessment type !",
         		    			  type: "warning",
         		    			  confirmButtonText: "Cool"
         		    			});
         		    		
        		    	 
              		    	 
              		    }
         		    	
         		      
         		    });
         	
         	
         	
         	
         	
         	$('#nextstep2').click(function(){
         	
         		if($("#configureClassWithAssessmentTypeForm").valid()){
         			
         			
         		////modulebased
         			if($("#modulesBased").is(":checked")){
  	    		  var modulebaseddetails= [];
  	    	 
  	    		$('#modulesbasedinfo').find('tr').each(function () {
    			        var $tds = $(this).find('td');
    			        modulebaseddetails.push($tds.eq(0).find("option:selected").attr('value')+"-"+$tds.eq(1).find("option:selected").attr('value'));
    			            });

  				    $("#modulesBasedDetails").val(modulebaseddetails);
  				    
  	    		
         			}else{
         				$("#secondstep").find("input[name=modulesBasedDetails]:hidden").remove();
         			}
         			
  				////coScholasticActivityDetails
         			if($("#co-ScholasticActivity").is(":checked")){
    	    		  var coscholasticactivitydetails= [];
    	    		$("#coscholasticactivitiesinfo").find('tr').each(function () {
      			        var $tds = $(this).find('td');
      			      coscholasticactivitydetails.push($tds.eq(0).find("option:selected").attr('value'));
      			            });
    	    		  $("#coScholasticActivityDetails").val(coscholasticactivitydetails);
         			}else{
         				$("#secondstep").find("input[name=coScholasticActivityDetails]:hidden").remove();
         				
         			}
    	    			////coScholasticAreaDetails
         			if($("#co-ScholasticArea").is(":checked")){
    	    		  var coscholasticareadetails= [];
    	    		$("#coscholasticareasinfo").find('tr').each(function () {
      			        var $tds = $(this).find('td');
      			      coscholasticareadetails.push($tds.eq(0).find("option:selected").attr('value'));
      			            });
    	    		  $("#coScholasticAreaDetails").val(coscholasticareadetails);
         			}else{
         				$("#secondstep").find("input[name=coScholasticAreaDetails]:hidden").remove();
         			}
    	    		////moduleAndSkillBasedDetails
         			if($("#moduleAndSkillBased").is(":checked")){
    	    		  var moduleandskillbaseddetails= [];
    	    		$("#moduleandskillbasedinfo").find('tr').each(function () {
    	    			
      			        var $tds = $(this).find('td');
      			       var moduleskill=$tds.eq(1).find('select').val().join("&");
      			       
      			      
      			      moduleandskillbaseddetails.push($tds.eq(0).find("option:selected").attr('value')+"-"+moduleskill+"-"+$tds.eq(2).find("option:selected").attr('value'));
    	    		});
    	    		
    	
    	    		  $("#moduleAndSkillBasedDetails").val(moduleandskillbaseddetails);
         			}else{
         				$("#secondstep").find("input[name=moduleAndSkillBasedDetails]:hidden").remove();
         			}
         			$("#classsaveconfirmation").modal('show');
    				$("#classsaveconfirm").click(function(event) {
    					$("#configureClassWithAssessmentTypeForm").submit();
    				});
         		}      				
             }); 
         	
         	//delete 
         	$('#classlistswithoutexamconfig').on( 'click', 'tr td a#delete', function () {
         		 var classid = $(this).attr('data-id');
         		$("#deleteClassId").val(classid);
         		 $('#deleteclassconfirmation').on('show.bs.modal', function (e) {
         			 $("#confirmdeleteclass").click(function(event) {
         				 
         				 $("#deleteclassform").submit();  
         			});
         			});
         		   
         	});
         	
         	//delete 
         	$('#classlistswithexamconfig').on( 'click', 'tr td a#dedeflete', function () {
         		 var classid = $(this).attr('data-id');
         		$("#dedeleteClassId").val(classid);
         		 $('#dedfsleteclassconfirmation').on('show.bs.modal', function (e) {
         			 $("#confirmdefdeleteclass").click(function(event) {
         				 
         				 $("#deddeleteclassform").submit();  
         			});
         			});
         		   
         	});
         	
         });
     function select_all() {
    		$('input[class=case]:checkbox').each(function(){ 
    			if($('input[class=check_all]:checkbox:checked').length == 0){ 
    				$(this).prop("checked", false); 
    			} else {
    				$(this).prop("checked", true); 
    			} 
    		});
    	}  
     
     
    
    