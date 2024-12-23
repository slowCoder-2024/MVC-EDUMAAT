var ctx= window.location.pathname.substring(0, window.location.pathname.indexOf("/",2));

$(document).ready(function() {
	   $('#example-select-all').on('click', function(){
		      // Check/uncheck all checkboxes in the table
		   var datatable = $('#invoiceList').DataTable();
		      var rows = datatable.rows({ 'search': 'applied' }).nodes();
		      $('input[type="checkbox"]', rows).prop('checked', this.checked);
		   });
	   
	 
	   
	   $('#invoiceList').on('change', 'input[type="checkbox"]', function(){
		      // If checkbox is not checked
		      if(!this.checked){
		         var el = $('#example-select-all').get(0);
		         // If "Select all" control is checked and has 'indeterminate' property
		         if(el && el.checked && ('indeterminate' in el)){
		            // Set visual state of "Select all" control 
		            // as 'indeterminate'
		            el.indeterminate = true;
		         }
		      }
		    
		   
		   });
	
	   //get all section of class
				$('#class').change(function(event) {
			  	    var classId = $("#class").val();
			  	  $(".form-group-section").hide();
			  	 $(".form-group-studentid").hide();
			  	$("#termFeesSetup").hide();
			  	    if(classId!=="all"){
			  	    	 $(".form-group-section").show();
			  	    	 /* $.get(ctx+'/class/sections', {
				                classId : classId
				        }, function(response) {
				        	  var select = $('#section');
				        	  if(response.length>0)
				        	  {
				        		  select.find('option').remove(); 
				        		  $('#section').selectpicker('destroy');
				        	  }
				        	  else
				        	  { 
				        		  select.find('option').remove();
				        		  $('#section').selectpicker('destroy');
				        		  select.append('<option value="" disabled selected>Select Section</option>');
				        	  }
				        	   $.each(response, function(key,value) {
				            		 if(key==0){
				   	        	    		select.append('<option value="" disabled selected>Select Section</option>');
				   	        	    	}
				            		 $('<option>').val(value.sectionId).text(value.sectionName).appendTo(select);
				            	  
				            	 }); 
				        	   $('#section').selectpicker('show');
				        });*/
			  	    	$.ajax({
							   url:ctx+'/classSection/'+classId,
							   type:'GET',
							   success: function(response){
								   var select = $('#section');
						    	   if(response.length>0)
						        	  {
						        		  select.find('option').remove(); 
						        		  $('#section').selectpicker('destroy');
						        	  }
						        	  else
						        	  {
						        		  select.find('option').remove();
						        		  $('#section').selectpicker('destroy');
						        		  select.append('<option value="" disabled >Select Section</option>');
						        	  }
								   $.each(response, function(key,value) {
								  		 if(key==0){
								     	    		select.append('<option value="" disabled >Select Section</option>');
								     	    	}
								  		$('<option>').val(value.sectionClass.sectionId).text(value.sectionClass.sectionName).appendTo(select);
								  	 }); 
								   $('#section').selectpicker('show');
							   },
							   error: function(){
								   alert('ERROR OCCURED');
								  
						       }
							});
			  	    }
			  	  
			       
			 });
				
				
				//criteria logic
				$("#admissionNo").click(function(event) {
					        $(".form-group-groupcriteria").hide();  
					    	$("#termFeesSetup").hide();
				});
			$("#criteria").change(function(event) {
				var value = $(this).val();
				 if(value==="specialcategory"){
					       $(".form-group-special-category").show();  
				 }
				 else
					 {
					     $(".form-group-special-category").hide();  
					 }
			});
			
			//reteriving student list
			 $("#getdetailsfromselectedcriteria").click(function(event){
				 $('#studentDetailsForm').validate({
					submitHandler: function(form) {
						$(".form-group-groupcriteria").show();
						 $(".form-group-studentid").show();
						  $(".form-group-section").hide();
						 $('.loader').show();
						    var data=$("#studentDetailsForm").serialize();
						    $.ajax(	
							    {
							        type: "GET",
							        url:ctx+"/invoice/students" ,
							        data: data,
							        cache: false,
							        success:function (data) {
							        	
							        	if(!$.trim(data))
							        	 {
							        		 $('.loader').hide();
							        			$(".form-horizontal").trigger('reset'); 
									         edumaatAlert({
									    			  title: "Info !",
									    			  text:"Data Not Found",
									    			  type: "info",
									    			  confirmButtonText: "Cool"
									    			}).then(function(){
									    				window.location.href=ctx+'/invoice';
										        		
										        	});
							        	 }
							        	 else
							        	 {	
							        	
							        	 $('.loader').hide();
							        	  document.getElementById('invoicedetailsdiv').style.display="block";
							        	var datatable = $('#invoiceList').DataTable();
							        	 $(".form-horizontal").trigger('reset'); 
							        	 $('.selectpicker').val('');
							             $('.selectpicker').selectpicker('refresh');
											      datatable.clear().draw();
											  $.each(data, function (i, item) {
												  if(item!=null){
													  var name;
											        	if(item.lastName!=null){
											        		name=item.firstName+' '+item.lastName;
											        	}else{
											        		name=item.firstName;
											        	}
											        	datatable.row.add(['  <div class="checkbox checkbox-pink"><input type="checkbox" value='+item.studentId+' name="studentId" class="case" id='+item.studentId+'></input> <label for='+item.studentId+'></label></div>',item.admissionNo,name,item.studentClass.className+"/"+item.section.sectionName]).draw( false );
												  }
												 });
											  
							        	 }
							         },
							        error:function(){
							        	 $('.loader').hide();
							        	$(".form-horizontal").trigger('reset'); 
							        	 $('.selectpicker').val('');
							             $('.selectpicker').selectpicker('refresh');
							        	document.getElementById('invoicedetailsdiv').style.display="none";
							        	// alert("Data  Not Found")
							        	 edumaatAlert({
							    			  title: "Info !",
							    			  text:"Data Not Found",
							    			  type: "info",
							    			  confirmButtonText: "Cool"
							    			}).then(function(){
							    				window.location.href=ctx+'/invoice';
								        		
								        	});
								 	    }
							    });
						
				         }
				  });	
				  });	 	  
				$('#createTermFees').click(function() {
				
				
					 var selectedstudentid = [];
					
					 var oTable = $('#invoiceList').dataTable();
					 var rowcollection =  oTable.$(".case:checked", {"page": "all"});
					 rowcollection.each(function(index,elem){
					     selectedstudentid.push($(elem).val());
					 });
					
					
					
				 $("#selectedStudentIds").val(selectedstudentid);	  
					
						if((selectedstudentid.length)>0)
						 {
							
							document.getElementById('invoicedetailsdiv').style.display="none";
							document.getElementById('termFeesSetup').style.display="block";
							document.getElementById('criteriaForm').style.display="none";
							
							$('#feesTerms').change(function() {
								document.getElementById('terms').style.display="block";
								var feesTerms = []; 
								var datatable = $('#termsList').DataTable();
					        		      datatable.clear().draw();
					        		      datatable.column( 0).visible(false);
					        		     
					        		      $('#feesTerms :selected').each(function(i, selected){ 
					        	//	alert($(selected).val());
					        		    	
					        		    			feesTerms[i] = $(selected).text(); 
											  	datatable.row.add([$(selected).val(),$(selected).text(),'<div class="form-group col-sm-12"><select name="feesstructure1'+$(selected).val()+'"  id="feesstructure1'+$(selected).val()+'" multiple data-style="btn-white" class="selectpicker"></select></div>','<div class="form-group col-sm-12"><select name="feesitem1'+$(selected).val()+'"  id="feesitem1'+$(selected).val()+'" multiple data-style="btn-white" class="selectpicker" ></select></div>']).draw( false );
											  	/* feesstructure($(selected).val());*/
											  	feesTemplate($(selected).val());
												feesItem($(selected).val());

					        		     //multiselect();
								});
					       					
							});
							
							$('#generatecharges').click(function() {
								
								/*$('#applyTermFeesform').validate({
									ignore:null,
								 		 errorPlacement: function ($error, $element) {
								             var name = $element.attr("name");   	             
								 	             $("#error" + name).append($error);
								         }     
								});*/
								if($('#applyTermFeesform').valid())
								{
									var datatable = $('#termsList').DataTable();
				        		      datatable.column( 0).visible(true);
									  var generatefeesstructuredetails= [];
									  var check="1";
					    	    		$("#termsValues").find('tr').each(function () {
					    	    		    var $tds = $(this).find('td');
					    	    		    if($("#"+$tds.eq(2).find("select").attr('id')).val()!=null || $("#"+$tds.eq(3).find("select").attr('id')).val()!=null)
					    	    		    {
					    	    		    	 generatefeesstructuredetails.push($tds.eq(0).text()+"-"+$tds.eq(2).find("select").attr('id')+"-"+$tds.eq(3).find("select").attr('id'));
								    	    }
					    	    		    else
					    	    		    {
					    	    		    	check="0";
					    	    		    	edumaatAlert({
									    			  title: "Info !",
									    			  text:"You have to select atleast one fees structure or fees item",
									    			  type: "info",
									    			  confirmButtonText: "Cool"
									    			}).then(function(){
									    				window.location.href=ctx+"/invoice";
										        	});
					    	    		    }
					    	    		});
					    	    		datatable.column( 0).visible(false);
								     	$("#selectedFeesStructureDetails").val(generatefeesstructuredetails);
						    	     		
					    	    		if(check=="1")
					    	    		{
					    	    			$("#applyTermFeesform").submit();
					    	    			$('.loader').show();
					    	    		}
							     }
									});
							
							
							/*$('#generateinvoice').click(function() {
								
						  var termfeeslists= [];
			        			   
						  	if($("#applyTermFeesform").valid()){
						  		 $('.loader').show();
									var table = $("table tbody#test");

			        			    table.find('tr').each(function () {
			        			    	
			        			        var $tds = $(this).find('td');
			        			        termfeeslists.push($tds.eq(0).attr('id')+"-"+$tds.eq(1).find("option:selected").attr('value'));
			        			            });
			        			    
			        			    if(termfeeslists!=null && selectedstudentid!=null){
								  		  $.post(ctx+'/invoice/generate',{studentIds:selectedstudentid,
								  			  academicTermIds:termfeeslists},function(){
								  				 $('.loader').hide();
								  				 alert("Invoice Generated")
								  				location.reload();
								  			  })
								  	
								  	 }
			        			   
							}
								
						  	 });*/
						
						 }
						 else{
							 //alert(" You have to select atleast one student from invoice details table")
							 edumaatAlert({
				    			  title: "Info !",
				    			  text:"You have to select atleast one student from invoice details table",
				    			  type: "info",
				    			  confirmButtonText: "Cool"
				    			});
						 }
				
					     
						
						
				 });
			   
		
			
			});
			
			
			
			
			
			
			
			
	
		
		function select_all() {
		
			$('input[class=case]:checkbox').each(function(){ 
				
				if($('input[class=check_all]:checkbox:checked').length == 0)
				{ 
					$(this).prop("checked", false); 
					
				} else 
				{ 
					$(this).prop("checked", true); 
				} 
				
				
				
			});
		}
		  function feesTemplate(id)
		  {
			    $.get(ctx+'/feesStructure/viewFeesStructureList', function(response)
			    		{
			    	var selectid="feesstructure1"+id;
			      var select = $('#'+selectid);
	        	  if(response.length>0)
	        	  {
	        		  select.find('option').remove(); 
	        		  $('#'+selectid).selectpicker('destroy');
	        	  }
	        	  else
	        	  { 
	        		  select.find('option').remove();
	        		  $('#'+selectid).selectpicker('destroy');
	        		  select.append('<option value="" disabled>Select Fees Structure</option>');
	        	  }
	        	 
	        	   $.each(response, function(key,value) {
	            		 if(key==0){
	   	        	    	select.append('<option value="" disabled>Select Fees Structure</option>');
	   	        	    	}
	            		 $('<option>').val(value.feesStructureId).text(value.feesStructureName).appendTo(select);
	            	  }); 
	        	   $('#'+selectid).selectpicker('show');
	        });
		  }

		  function feesItem(id)
		  {
			    $.get(ctx+'/feesItem/viewFeesItemList', function(response)
			    		{
			    	var selectid="feesitem1"+id;
			      var select = $('#'+selectid);
	        	  if(response.length>0)
	        	  {
	        		  select.find('option').remove(); 
	        		  $('#'+selectid).selectpicker('destroy');
	        	  }
	        	  else
	        	  { 
	        		  select.find('option').remove();
	        		  $('#'+selectid).selectpicker('destroy');
	        		  select.append('<option value="" disabled >Select Fees Item</option>');
	        	  }
	        	 
	        	   $.each(response, function(key,value) {
	            		 if(key==0){
	   	        	    	select.append('<option value="" disabled >Select Fees Item</option>');
	   	        	    	}
	            		 $('<option>').val(value.feesItemId).text(value.feesItemName).appendTo(select);
	            	  }); 
	        	   $('#'+selectid).selectpicker('show');
	        });
		  }
