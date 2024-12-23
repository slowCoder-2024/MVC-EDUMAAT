var ctx= window.location.pathname.substring(0, window.location.pathname.indexOf("/",2));
$(document).ready(function(){
	
	
	 $('#datatable').DataTable();
		$("#shortCandidateList").click(function(event){
		
			if($('#shortcandidateForm').valid())
			{
				$('.loader').show();
			var classId=$("#classId").val();
			var admissionCodeFormat=$("#admissionCodeFormat").val();
			var ruleId=$("#ruleId").val();
			
			$.ajax({
				   url:ctx+'/admissions/finalization/applyAdmissionRule',
				   type:'GET',
				   data:{classId:classId,admissionCodeFormat:admissionCodeFormat,ruleId:ruleId},
				   success: function(data){
		
						 $('.loader').hide();
							var datatable = $('#datatable').DataTable();
				        	 $(".form-horizontal").trigger('reset'); 
				        	/* $('.selectpicker').selectpicker('refresh');*/
				        	/* $('.selectpicker').selectpicker('deselectAll');*/
				        		datatable.clear().draw();
							
				       if(data.length>0)
				    	   {
				    	    
				    	   $.each(data, function (i, item) 
				    	    		{
					            
					        	datatable.row.add(  [item.admissionCode,item.candidateFirstName+" "+item.candidateLastName,item.dateOfBirth,item.candidateGender,item.admissionRank,'<div class="checkbox checkbox-primary"><input type="checkbox" name="admissionId" class="case" id='+item.admissionId+'></input><label for='+item.admissionId+'></label></div>'] ).draw( false );
					        });
					        
				    	   }/*else
				    	   {
				    		   edumaatAlert({
					    			  title: "Information !",
					    			  text: "No Seat Availability",
					    			  type: "warning",
					    			  confirmButtonText: "Cool"
					    			});
				    	   }*/
								
				   },
				   error: function(){
					   alert('ERROR OCCURED');
					   window.location.href=ctx+"/admissions/finalization";
			       }
				});
				
			}
	  
		});
	 $('#classId').change(function(event) {
		   var classId = $("#classId").val();
		   if(classId!="" && classId!=null)
		   {
				$.ajax({
					   url:ctx+'/admissions/getAdmissionByClass',
					   type:'GET',
					   data:{
			                classId : classId
				        },
					   success: function(response){ 
	        	  var select = $('#admissionCodeFormat');
	        	  if(response.length>0)
	        	  {
	        		  select.find('option').remove(); 
	        		  $('#admissionCodeFormat').selectpicker('destroy');
	        	  }
	        	  else
	        	  {
	        		  select.find('option').remove();
	        		  $('#admissionCodeFormat').selectpicker('destroy');
	        		  select.append('<option value="" disabled selected>Select Admission Code Format</option>');
	        	  }
	        	   $.each(response, function(key,value) {
	            		 if(key==0)
	            		 {
	            			select.append('<option value="" disabled selected>Select Admission Code Format</option>');
	   	        	     }
	            		 $('<option>').val(value.admissionConfigId).text(value.applicationCodeFormat).appendTo(select);
	            	  }); 
	        	   $('#admissionCodeFormat').selectpicker('show');
	        }
		   });
		   }
	       
	 });	
		/*	var currentdate = new Date(); 
		    var datetime = currentdate.getDate() + "-"
		                + (currentdate.getMonth()+1)  + "-" 
		                + currentdate.getFullYear() + "_"  
		                + currentdate.getHours() + "-"  
		                + currentdate.getMinutes() + "-" 
		                + currentdate.getSeconds();
		var exportfilename='Admission_Rank_Details'+datetime;
			$('#datatable').DataTable({
				 dom: 'Bfrtip',
				 buttons: [
				            {
				                extend: 'copyHtml5',
				                exportOptions: {
				                	 columns:':visible'
				                },
				                title: exportfilename,footer:true
				                
				            },
				            {
				                extend: 'excelHtml5',
				                exportOptions: {
				                	 columns:':visible'
				                },
				                title: exportfilename,footer:true
				            },
				            {
				                extend: 'pdfHtml5',
				                exportOptions: {
				                	 columns:':visible'
				                		 
				                },
				                title: exportfilename,footer:true
				            },
				            {
				                extend: 'csvHtml5',
				                exportOptions: {
				                	 columns: [0,1,2,3,4,5,':visible']
				                	 columns:':visible'
				                },
				                title: exportfilename,footer:true
				            },
				            'colvis'
				        ]
			});*/
	
			 $('#list').click(function(event) {
				 var selectedAdmissionCandidates = [];
				  $.each($(".case:checked"), function(){            
					  selectedAdmissionCandidates.push($(this).attr('id'));
			         });
				  if(selectedAdmissionCandidates.length>0)
					  {
					 $('.loader').show();
					  $.post(ctx+"/admissions/finalization/intimateSelectCandidate?selectedAdmissionCandidates="+selectedAdmissionCandidates,function(){
						  $('.loader').hide();
						  location.reload();
					  });
					  }
				  	else
					  {
						  edumaatAlert({
				    			  title: "warning !",
				    			  text: "Please select atleast one student...!",
				    			  type: "warning",
				    			  confirmButtonText: "Cool"
				    			});
					  }
				 
				   
					 
				   
				});
			 
			 
			 /*$('#list').click(function() {
		         var generatelist = [];

		         $.each($(".case:checked"), function(){            

		        	 generatelist.push($(this).attr('id'));

		         });

		         alert(generatelist);
			 
			 });*/
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
