$(document).ready(function() {
			
	var ctx= window.location.pathname.substring(0, window.location.pathname.indexOf("/",2));
	 $('#example-select-all').on('click', function(){
	      // Check/uncheck all checkboxes in the table
	   var datatable = $('#studentReceipts').DataTable();
	      var rows = datatable.rows({ 'search': 'applied' }).nodes();
	      $('input[type="checkbox"]', rows).prop('checked', this.checked);
	   });


  
$('#studentReceipts').on('change', 'input[type="checkbox"]', function(){
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
	$('#class').change(function(event) {
  	    var classId = $("#class").val();
  	  $(".form-group-section").hide();
  	 $(".form-group-studentid").hide();
  
  	    if(classId!=="all"){
  	    	 $(".form-group-section").show();
  	    	  $.get(ctx+'/classSection/'+classId, function(response) {
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
	        });
  	    	
  	    }
  	  
       
 });
	$("#admissionNo").click(function() {
		        $(".form-group-groupcriteria").hide();  
		    	
	});
$("#criteria").change(function() {
	var value = $(this).val();
 if(value==="specialcategory")
	 {
		   $(".form-group-special-category").show();  
	 }
	 else
		 {
		   $(".form-group-special-category").hide();  
		 }
		});
	  $("#getdetailsfromselectedcriteria").click(function(event){
				 $('#studentDetailsForm').validate({
					submitHandler: function(form) {
						  var data=$("#studentDetailsForm").serialize();
						$('.loader').show();
						    $.ajax(	
							    {
							        type: "GET",
							        url:ctx+"/receipt/allStudent",
							        data: data,
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
									    				window.location.href=ctx+'/receipt/manage/refund';
										        		
										        	});
							        	 }
							        	 else
							        	 {	
							        	
							        	 $('.loader').hide();
							        	  document.getElementById('receiptDetailDiv').style.display="block";
							        	var datatable = $('#studentReceipts').DataTable();
							        		      datatable.clear().draw();
											  $.each(data, function (i, item) {
												  if(item!=null){
													  var name;
													  if(item.lastName!=null){
											        		name=item.firstName+' '+item.lastName;
											        	}else{
											        		name=item.firstName;
											        	}
											           	datatable.row.add(['<div class="checkbox checkbox-pink"><input type="checkbox" value='+item.studentId+' name='+item.studentId+' class="case" id='+item.studentId+'></input><label for='+item.studentId+'></label></div>',item.admissionNo,name,item.studentClass.className,item.section.sectionName]).draw( false );
														
												  }
												 });
							        	 }
											  
											  
							        },
							        error:function(){
							        	 $('.loader').hide();
							        	 $(".form-horizontal").trigger('reset'); 
							        	 document.getElementById('receiptDetailDiv').style.display="none";
							        	 edumaatAlert({
							    			  title: "Info !",
							    			  text:"Data  Not Found",
							    			  type: "info",
							    			  confirmButtonText: "Cool"
							    			});
								 	    }
							      
							    });
						    
				       }
						  
				  });	
				 
				 
				
				  });	
	  
	  
	  $('#studentReceipts').on( 'click', 'tr td a#delete', function () {
		
			 var receiptid = $(this).attr('data-id');
			 $("#deleteReceipitId").val(receiptid);
			  $('#confirm_delete_receipt').on('show.bs.modal', function (e) {
					 $("#confirmDeleteReceipt").click(function(event) {
							$('.loader').show();
						 $("#deleteReceiptForm").submit();
					  });
			  });
		});

		 $('#deletegeneratereceipt').click(function() {
				
			 
			 var selectedstudentids = [];
			
			 var oTable = $('#studentReceipts').dataTable();
			 var rowcollection =  oTable.$(".case:checked", {"page": "all"});
			 rowcollection.each(function(index,elem){
				 selectedstudentids.push($(elem).val());
			 });
			 
			 $("#selectedStudentIds").val(selectedstudentids);
			 if((selectedstudentids.length)>0)
			 {
				
				if($("#generatereceiptform").valid())
				{
					 $('.loader').show();
					$("#generatereceiptform").submit();
				}
				 
			 }
			 else{
				 
				 edumaatAlert({
	    			  title: "Info !",
	    			  text:"You have to select atleast one student",
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

   