var ctx= window.location.pathname.substring(0, window.location.pathname.indexOf("/",2));

$(document).ready(function() {
	
	
	

	
$('#studentReceiptListTable').DataTable({
	/* dom: 'Bfrtip',*/
		"paging":   false,
		"searching": false,
	
"footerCallback": function ( row, data, start, end, display ) {
    
	var api = this.api(), data;
	   
    // Remove the formatting to get integer data for summation
    var intVal = function ( i ) {
        return typeof i === 'string' ?
            i.replace(/[\$,]/g, '')*1 :
            typeof i === 'number' ?
                i : 0;
    };
  
 /*   // TotalAmount over all pages
    totalAmount = api
        .column( 2 , {'search': 'applied'})
        .data()
        .reduce( function (a, b) {
            return intVal(a) + intVal(b);
        }, 0 );

    // TotalAmount over this page
    pageTotalAmount = api
        .column( 2, { page: 'current'} )
        .data()
        .reduce( function (a, b) {
            return intVal(a) + intVal(b);
        }, 0 );

    // Update footer
    $( api.column( 2 ).footer() ).html(
        ''+pageTotalAmount +' ('+ totalAmount +' total)'
    );
  
    // TotalPendingAmount over all pages
    totalPendingAmount = api
        .column( 3 , {'search': 'applied'})
        .data()
        .reduce( function (a, b) {
            return intVal(a) + intVal(b);
        }, 0 );

    // TotalPendingAmount over this page
    pageTotalPendingAmount = api
        .column( 3, { page: 'current'} )
        .data()
        .reduce( function (a, b) {
            return intVal(a) + intVal(b);
        }, 0 );

 // TotalPaidAmount over all pages
    totalPaidAmount = api
        .column( 4 , {'search': 'applied'})
        .data()
        .reduce( function (a, b) {
            return intVal(a) + intVal(b);
        }, 0 );

    // TotalPaidAmount over this page
    pageTotalPaidAmount = api
        .column( 4, { page: 'current'} )
        .data()
        .reduce( function (a, b) {
            return intVal(a) + intVal(b);
        }, 0 );
*/
    
  /*  $("#invoicesamountgrandtotal").html(totalAmount);
    $("#invoicespendingamountgrandtotal").html(totalPendingAmount);
    $("#invoicespaidamountgrandtotal").html(totalPaidAmount);
    $("#invoicesamountpagetotal").html(pageTotalAmount);
    $("#invoicespendingamountpagetotal").html(pageTotalPendingAmount);
    $("#invoicespaidamountpagetotal").html(pageTotalPaidAmount);*/
  
}
});
	

$('#studentInvoiceFeesItems').DataTable({
	/* dom: 'Bfrtip',*/
	"paging":   false,
	"searching": false,
"footerCallback": function ( row, data, start, end, display ) {
   
	var api = this.api(), data;
	   
   // Remove the formatting to get integer data for summation
   var intVal = function ( i ) {
       return typeof i === 'string' ?
           i.replace(/[\$,]/g, '')*1 :
           typeof i === 'number' ?
               i : 0;
   };
 
   // TotalAmount over all pages
   totalAmount = api
       .column( 2 , {'search': 'applied'})
       .data()
       .reduce( function (a, b) {
           return intVal(a) + intVal(b);
       }, 0 );

   // TotalAmount over this page
   pageTotalAmount = api
       .column( 2, { page: 'current'} )
       .data()
       .reduce( function (a, b) {
           return intVal(a) + intVal(b);
       }, 0 );

   // Update footer
   $( api.column( 2 ).footer() ).html(
       ''+pageTotalAmount +' ('+ totalAmount +' total)'
   );
 
 
   
   // TotalAmount over all pages
   totalPaidAmount = api
       .column( 3 , {'search': 'applied'})
       .data()
       .reduce( function (a, b) {
           return intVal(a) + intVal(b);
       }, 0 );

   // TotalAmount over this page
   pageTotalPaidAmount = api
       .column( 3, { page: 'current'} )
       .data()
       .reduce( function (a, b) {
           return intVal(a) + intVal(b);
       }, 0 );

   $("#feesitemgrandtotal").html(totalAmount);
  $("#feesitempagetotal").html(pageTotalAmount);
  $("#feesitempaidgrandtotal").html(totalPaidAmount);
  $("#feesitempaidpagetotal").html(pageTotalPaidAmount);
 
}
});
var datatable;
	
	 $(".form-control-datepicker").datepicker('update',new Date());
	 
	
	$("#admissionNo").click(function() {
        $(".form-group-groupcriteria").hide();  
    	$("#termFeesSetup").hide();
    });
	
	
	$('#class').change(function(event) {
		$('#admissionNoBlock').hide();  
		var classId = $("#class").val();
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
	        		  select.append('<option value="" disabled selected>Select Section</option>');
	        	  }
	        	   select.find('option').remove();
	        	   $.each(response, function(key,value) {
	            		 if(key==0){
	   	        	    		select.append('<option value="" disabled selected>Select Section</option>');
	   	        	    	}
	            		 $('<option>').val(value.sectionClass.sectionId).text(value.sectionClass.sectionName).appendTo(select);
	            	  
	            	 }); 
	        	   $('#section').selectpicker('show');
	        });
  	    	/* $.ajax({
				   url:ctx+'/classSection/'+classId,
				   type:'GET',
				   success: function(response){
					   $('#sectionList').attr('disabled', false);
			    	   var select = $('#sectionList');
			    	   if(response.length>0)
			        	  {
			        		  select.find('option').remove(); 
			        		  $('#sectionList').selectpicker('destroy');
			        	  }
			        	  else
			        	  {
			        		  select.find('option').remove();
			        		  $('#sectionList').selectpicker('destroy');
			        		  select.append('<option value="" disabled selected>Select Section</option>');
			        	  }
					   $.each(response, function(key,value) {
					  		 if(key==0){
					     	    		select.append('<option value="" disabled selected>Select Section</option>');
					     	    	}
					  		$('<option>').val(value.sectionClass.sectionId).text(value.sectionClass.sectionName).appendTo(select);
					  	 }); 
					   $('#sectionList').selectpicker('show');
				   },
				   error: function(){
					   alert('ERROR OCCURED');
					   window.location.href=ctx+"/student/managestudent";
			       }
				});*/
  });
	
	
	/*$('input[type=radio][name=fineautomaticcalculation]').change(function() {
		if (this.value == "automaticcalculation") {
			$("#fineAmount").attr('readonly', 'readonly');
			$("#fineAmount").val(fineAmountAutomaticCalculation($("#currentstudentinvoiceid").val()));
	    }
        else if (this.value == "custom") {
        	$("#fineAmount").removeAttr('readonly');
        }
    });*/
	$('#section').change(function(event) {
		var classId=$("#class").val();
		var sectionId = $(this).val();
			 $(".form-group-student").show();
  	    	  $.get(ctx+'/student/classAndSection', {
	                classId : classId,sectionId:sectionId
	        }, function(response) {
	        	var select = $('#students');

	        	 if(response.length>0)
	        	  {
	        		  select.find('option').remove(); 
	        		  $('#students').selectpicker('destroy');
	        	  }
	        	  else
	        	  { 
	        		  select.find('option').remove();
	        		  $('#students').selectpicker('destroy');
	        		  select.append('<option value="" disabled selected>Select Student</option>');
	        	  }
	        	   $.each(response, function(key,student) {
	            		 if(key==0){
	   	        	    		select.append('<option value="" disabled selected>Select Student</option>');
	   	        	    	}
	            		 var studentFirstName="";
	            		 var studentLastName="";
	            		 if(student.firstName)
	            		 {
	            			 studentFirstName=student.firstName;
	            		 }
	            		 if(student.lastName)
	            		 {
	            			 studentLastName=student.lastName;
	            		 }
	            		 $('<option>').val(student.studentId).text(studentFirstName+" "+studentLastName).appendTo(select);
	            	  
	            	 });
	        	   $('#students').selectpicker('show');
	        });
  	   
  });
	
	
	$("#getdetails").click(function(event){
		
		if($('#getDetailsForm').valid()){
			$('.loader').show();
			var studentId=$('#students').val(); 
			var admissionNo= " ";
			if($("#admissionNo").val()!=null)
				{
					admissionNo= $("#admissionNo").val();
				}
			  $.ajax(	
			    {
			        type: "GET",
			        url:ctx+'/invoice/pendinginvoices',
			        data:{admissionNo:admissionNo,studentId:studentId},
			        contentType: "application/json; charset=utf-8",
			        dataType: "json",
			        cache: false,
			        success: function (data) {
			        	$('.loader').hide();
			        	if(data.length>0){
			        		datatable= $('#studentReceiptListTable').DataTable();
			        		
				        	 $("#getDetailsForm").trigger('reset'); 
				        	  datatable.clear().draw();
								$.each(data, function (i, item) {
									if(i==0){
										var studentClassName=item.student.studentClass.className;
										var studentSection=item.student.section.sectionName;
										var studentName=null;
										if(item.student.lastName!=null){
											studentName=item.student.firstName+' '+item.student.lastName;
										}
										else{
											studentName=item.student.firstName;
										}
										var dob;
										if(item.student.birthDate!=null){
											dob==item.student.birthDate;
										}
										var gender=item.student.sex;
										var admissionNo=item.student.admissionNo;
										
										$("#displayStudentName").text(studentName);
										$("#displayClassName").text(studentClassName);
										$("#displaySectionName").text(studentSection);
										$("#displayAdmissionNo").text(admissionNo);
										$("#displayGender").text(gender);
										$("#displayDOB").text(dob);
										
										$("#firstname").val(studentName);
										$("#email").val(item.student.email);
										$("#phone").val(item.student.contact);
									}
									var totalInvoiceAmount=0.0;
									var pendingInvoiceAmount=0.0;
									var paidInvoiceAmount=0.0;
									$.each(item.studentInvoiceDetails, function (j, studentInvoiceDetail) {
										
										totalInvoiceAmount+=studentInvoiceDetail.studentInvoiceElementTotalAmount;
										
										if(studentInvoiceDetail.studentInvoiceElementPaymentStatus==1)
										{
											pendingInvoiceAmount+=studentInvoiceDetail.studentInvoiceElementTotalAmount;
										}
										
										if(studentInvoiceDetail.studentPartialPaymentReceiptDetail)
										{
											paidInvoiceAmount+=studentInvoiceDetail.studentPartialPaymentReceiptDetail.paidReceiptAmount;
										}
										else
										{
											if(studentInvoiceDetail.studentInvoiceElementPaymentStatus==0)
											{
												paidInvoiceAmount+=studentInvoiceDetail.studentInvoiceElementTotalAmount;
											}
										}
										
									});
									/*datatable.row.add([item.academicYear.academicYearTitle,item.feesTerm.feesTermName,totalInvoiceAmount,(totalInvoiceAmount-paidInvoiceAmount),paidInvoiceAmount,'<a href="#" id="feesitem"  type="button" data-href="#" data-id='+item.studentInvoiceId+' data-toggle="modal" onclick="showFeesItemDiv('+item.studentInvoiceId+')" >'
			                                           +'<span class="glyphicon glyphicon-level-up"></span>'
		                                                +'</a>','<div class="radio radio-warning" ><input type="radio" name="group'+item.studentInvoiceId+'" value="Partial"><label>Partial</label>&nbsp;&nbsp;<input type="radio" checked="checked" name="group'+item.studentInvoiceId+'" value="Full"> <label>Full</label></div>','<a href="#" id="payforinvoice"  type="button" data-href="#" data-id='+item.studentInvoiceId+' data-toggle="modal" onclick="payForInvoice('+item.studentInvoiceId+')" >'
                                    +'<span class="glyphicon glyphicon-credit-card"></span>'
                                    +'</a>']).draw( false );*/
									
									datatable.row.add([item.academicYear.academicYearTitle,item.feesTerm.feesTermName,'<a href="#" id="feesitem"  type="button" data-href="#" data-id='+item.studentInvoiceId+' data-toggle="modal" onclick="showFeesItemDiv('+item.studentInvoiceId+')" >'
			                                           +'<span class="glyphicon glyphicon-level-up"></span>'
		                                                +'</a>','<div class="radio radio-warning" ><input type="radio" name="group'+item.studentInvoiceId+'" value="Partial"><label>Custom</label>&nbsp;&nbsp;<input type="radio" checked="checked" name="group'+item.studentInvoiceId+'" value="Full"> <label>Full</label></div>','<a href="#" id="payforinvoice"  type="button" data-href="#" data-id='+item.studentInvoiceId+' data-toggle="modal" onclick="payForInvoice('+item.studentInvoiceId+')" >'
                                    +'<span class="glyphicon glyphicon-credit-card"></span>'
                                    +'</a>']).draw( false );
								/*	datatable.row.add([item.academicYear.academicYearTitle,item.feesTerm.feesTermName,'<a href="#" id="feesitem"  type="button" data-href="#" data-id='+item.studentInvoiceId+' data-toggle="modal" onclick="showFeesItemDiv('+item.studentInvoiceId+')" >'
			                                           +'<span class="glyphicon glyphicon-level-up"></span>'
		                                                +'</a>','<a href="#" id="payforinvoice"  type="button" data-href="#" data-id='+item.studentInvoiceId+' data-toggle="modal" onclick="payForInvoice('+item.studentInvoiceId+')" >'
                                    +'<span class="glyphicon glyphicon-credit-card"></span>'
                                    +'</a>']).draw( false );*/
							});
								document.getElementById('invoicedetailsdiv').style.display="block";
								document.getElementById('FormDiv').style.display="none";
			        	}
			        	else{
			        		edumaatAlert({
				        		type:'error',
				        		text:'No Invoices Available For this Student'
				        	}).then(function(){
				        		window.location.href=ctx+'/receipt/generate';
				        		
				        	});
			        	}
			         },
			        error:function(){
			        	edumaatAlert({
			        		type:'error',
			        		text:'Invalid Student Admission No'
			        	}).then(function(){
			        		window.location.href=ctx+'/receipt/generate';
			        		
			        	});
			        }
			      
			    });
		}
	});
	
	
	 
	
	 $('#example-select-all').on('click', function(){
	      // Check/uncheck all checkboxes in the table
	   var datatable = $('#finalPaymentDetailTable').DataTable();
	      var rows = datatable.rows({ 'search': 'applied' }).nodes();
	      $('input[type="checkbox"]', rows).prop('checked', this.checked);
	   });
	 $('#finalPaymentDetailTable').on('change', 'input[type="checkbox"]', function(){
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
	 
	 $("#savepaymentdetails").click(function(event){
		 
		if($("#feesDetails").valid())
			{
			
			alert("valid");
			}
			 
		 });
	 
	
	
	        
	
	 $("#paymentMode").change(function() {
		 
		    var val = $(this).val();
		    if(val ==="1") {
		       $(".form-group-dd").hide();
		        $(".form-group-cheque").hide();
		        $(".form-group-dd-input").prop('required',false);
		        $(".form-group-cheque-input").prop('required',false);
		       }
		    else if(val ==="2") {
		    	    $(".form-group-dd").hide();
		    	    $(".form-group-dd-input").prop('required',false);
			        $(".form-group-cheque").show();
			        $(".form-group-cheque-input").prop('required',true);
		       }
		   
		    
		    else if(val ==="3") {
		    	 //$(".form-group-cheque-dd").show();
		    	// Common for DD or Other instrument
		    	 $(".form-group-dd-input").prop('required',true);
		    	 $(".form-group-dd").show();
			     $(".form-group-cheque").hide();
			     $(".form-group-cheque-input").prop('required',false);
		     }
		    
		  });

});


function payForInvoice(studentInvoiceId){
	$("#currentstudentinvoiceid").val(studentInvoiceId);
	
	var  invoiceForPayment=[];
	invoiceForPayment.push(studentInvoiceId);
	var checkBoxValue=$('input[type=radio][name=group'+studentInvoiceId+']:checked').val();
	$("#checkPaymentType").val(checkBoxValue);
	$.get(ctx+'/invoice/invoiceValidation',{invoiceForPayment:invoiceForPayment},function(response){
		/* if(response==false){
			 edumaatAlert({
       			type:'warning',
       			text:'Please Pay Lower Term Fees First'
       		});
		 }
		 else if(response==true){*/
			 //setting datatables properties
				 var datatable = $('#finalPaymentDetailTable').DataTable({
					/* "columnDefs": [
					                {
					                    "targets": [ 0 ],
					                    "visible": false,
					                },
					                {
					                    "targets": [ 1 ],
					                    "visible": false,
					                }
					            ],*/
					 "paging":   false,
					 "searching": false
					
				 });
				//code to select multiple fees item for payment 
				/* $('#finalPaymentDetailTable tbody').on( 'click', 'tr', function () {
				        $(this).toggleClass('selected');
				  });*/
				 
				 
		         /*  $(".form-horizontal").trigger('reset'); */
		        	
		           $(".loader").show();
						if(invoiceForPayment.length>0){
							$.get(ctx+'/invoice/invoicedetailsforpayment',{invoiceForPayment:invoiceForPayment},function(response){
								
								
								
								$.each(response, function (i, finalStudentInvoices) {
								/*	if(i==0){
										if(finalStudentInvoices.discountApplicable==false){
											$('#discountType').hide();
										}
									}*/
										$.get(ctx+'/invoice/studentInvoice/itemdetailsandstatus/refund',{studentInvoiceId:finalStudentInvoices.studentInvoiceId},function(invoicedetails){
										 datatable.column( 0).visible(false);
										 datatable.column( 3 ).visible(false);
								    	 datatable.column( 4 ).visible(false);
								    	 if(checkBoxValue=="Full")
											{
												 datatable.column( 5 ).visible(false);
											}
								    	 $.each(invoicedetails, function (k,invoicedetail) {
											/*if(invoicedetail.studentInvoiceElementPaymentStatus==1){*/
													if(checkBoxValue=="Partial")
													{
														var paidInvoiceAmount=0.0;
														var paidInvoiceAmountWithoutDiscount=0.0;
														if(invoicedetail.studentPartialPaymentReceiptDetail)
														{
															paidInvoiceAmount+=invoicedetail.studentPartialPaymentReceiptDetail.paidReceiptAmount;
															paidInvoiceAmountWithoutDiscount+=invoicedetail.studentPartialPaymentReceiptDetail.paidReceiptAmount;
															paidInvoiceAmount+=invoicedetail.studentPartialPaymentReceiptDetail.discountAmount;
															paidInvoiceAmount=invoicedetail.studentInvoiceElementTotalAmount-paidInvoiceAmount;
															paidInvoiceAmountWithoutDiscount=invoicedetail.studentInvoiceElementTotalAmount-paidInvoiceAmountWithoutDiscount;
														}
														else
														{
															paidInvoiceAmount+=invoicedetail.studentInvoiceElementTotalAmount;
															paidInvoiceAmountWithoutDiscount+=invoicedetail.studentInvoiceElementTotalAmount;
														}
														
														datatable.row.add([invoicedetail.studentInvoiceDetailId,'<div class="checkbox checkbox-primary"><input type="checkbox" value='+invoicedetail.studentInvoiceDetailId+' name="studentInvoiceDetailId" class="case" id='+invoicedetail.studentInvoiceDetailId+'></input><label for='+invoicedetail.studentInvoiceDetailId+'></label></div>',invoicedetail.feesItem.feesItemName,paidInvoiceAmount,'<div class="form-group" id="flatBox"><div class="col-sm-12"><input type="text" class="form-control flat" id="discountFlat'+invoicedetail.studentInvoiceDetailId+'"  onkeypress="return decimalAmount(this, event, 2)" name="discountFlat'+invoicedetail.studentInvoiceDetailId+'" placeholder=""><input type="hidden" class="form-control flat" id="discountFlat'+invoicedetail.studentInvoiceDetailId+'discountFlat'+invoicedetail.studentInvoiceDetailId+'"  name="discountFlat'+invoicedetail.studentInvoiceDetailId+'discountFlat'+invoicedetail.studentInvoiceDetailId+'" placeholder="" value="'+paidInvoiceAmount+'"></div></div>','<div class="form-group" id="PaymentBox"><div class="col-sm-12"><input type="text" class="form-control payment" id="payment'+invoicedetail.studentInvoiceDetailId+'"  onkeypress="return decimalAmount(this, event, 2)" name="payment'+invoicedetail.studentInvoiceDetailId+'" placeholder=""><input type="hidden" class="form-control" id="payment'+invoicedetail.studentInvoiceDetailId+'payment'+invoicedetail.studentInvoiceDetailId+'"  name="payment'+invoicedetail.studentInvoiceDetailId+'payment'+invoicedetail.studentInvoiceDetailId+'" placeholder="" value="'+ paidInvoiceAmount +'"></div></div>']).draw( false );
													}
													else
													{
														var paidInvoiceAmount=0.0;
														var paidInvoiceAmountWithoutDiscount=0.0;
														if(invoicedetail.studentPartialPaymentReceiptDetail)
														{
															paidInvoiceAmount+=invoicedetail.studentPartialPaymentReceiptDetail.paidReceiptAmount;
															paidInvoiceAmountWithoutDiscount+=invoicedetail.studentPartialPaymentReceiptDetail.paidReceiptAmount;
															paidInvoiceAmount+=invoicedetail.studentPartialPaymentReceiptDetail.discountAmount;
															paidInvoiceAmount=invoicedetail.studentInvoiceElementTotalAmount-paidInvoiceAmount;
															paidInvoiceAmountWithoutDiscount=invoicedetail.studentInvoiceElementTotalAmount-paidInvoiceAmountWithoutDiscount;
														}
														else
														{
															paidInvoiceAmount+=invoicedetail.studentInvoiceElementTotalAmount;
															paidInvoiceAmountWithoutDiscount+=invoicedetail.studentInvoiceElementTotalAmount;
														}
														datatable.row.add([invoicedetail.studentInvoiceDetailId,'<div class="checkbox checkbox-primary"><input type="checkbox" value='+invoicedetail.studentInvoiceDetailId+' name="studentInvoiceDetailId" class="case" id='+invoicedetail.studentInvoiceDetailId+'></input><label for='+invoicedetail.studentInvoiceDetailId+'></label></div>',invoicedetail.feesItem.feesItemName,paidInvoiceAmount,'<div class="form-group" id="flatBox"><div class="col-sm-12"><input type="text" class="form-control flat" id="discountFlat'+invoicedetail.studentInvoiceDetailId+'"  onkeypress="return decimalAmount(this, event, 2)" name="discountFlat'+invoicedetail.studentInvoiceDetailId+'" placeholder=""><input type="hidden" class="form-control flat" id="discountFlat'+invoicedetail.studentInvoiceDetailId+'discountFlat'+invoicedetail.studentInvoiceDetailId+'"  name="discountFlat'+invoicedetail.studentInvoiceDetailId+'discountFlat'+invoicedetail.studentInvoiceDetailId+'" placeholder="" value="'+paidInvoiceAmount+'"></div></div>','']).draw( false );
													}
												/*}*/
										});
									});
					        	});
							});
				    	 }
						$(".loader").hide();
					
						
						//Apply discount button
						$('#discountType').click(function(){
							$("#discount_type").modal('show');
							$('#selectedDiscount').change(function(){
								if($(this).val()=='percentage'){
									$('#percentageBox').show();
								}
								else if($(this).val()=='flat'){
									$('#percentageBox').hide();
								}
							});
						});
						
						
						//apply button in modal
						$('#applyDiscount').click(function(event){
							
							if($("#discountForm").valid())
								{
								
								$('#isDiscountAppliedHF').val(1);
							
								
								$('#cancelDiscount').show();
								$('#discountType').hide();
							 
							if($('#selectedDiscount').val()=='flat'){
								datatable.column( 4 ).visible(true);
								$('#disTypeHF').val("flat");
							}else if($('#selectedDiscount').val()=='percentage'){
								if(datatable.column( 0 ).visible()===true){
									datatable.column( 0 ).visible(false);
									datatable.column( 4 ).visible(false);
								}
								$('#disTypeHF').val("percentage");
								var discountPecentage=$('#discountPercentage').val();
								var checkActualAmount=100.0;
								 if(parseFloat(discountPecentage) > parseFloat(checkActualAmount))
									{
										 edumaatAlert({
								        		type:'warning',
								        		text:'Please Enter Valid Percentage'
								        	});
										$("#discountPercentage").val('');
									}else
									{
										$('#disPerHF').val(discountPecentage);
										$('#cancelDiscount').show();
										$('#discountType').hide();
									}
								
							}
							 $('#discount_type').modal('hide');
								
								}
						});
						
						
						//cancel discount
						$('#cancelDiscount').click(function(){
							$('#cancelDiscount').hide();
							$('#discountType').show();
							$('#isDiscountAppliedHF').val(0);
							$('#disTypeHF').val('');
							$('#disPerHF').val('');
							datatable.column( 0 ).visible(false);
							datatable.column( 4 ).visible(false);
						})
						
					
						//validation for flat discount; flat discount is given separately for each fees item as selected and discount amount
						// should not be greater than invoiced amount for the fees item
						$(document).on('change',".flat",function (event){ 
							
							var tdId=this.id;
						var partialPaymentId= tdId.replace(/[^\d]/g, '');
						var checkPartialPaymentAmount=0.0;
						if(document.getElementById("payment"+partialPaymentId))
						{
							checkPartialPaymentAmount=$("#payment"+partialPaymentId).val();
						}
								var checkFlatDiscountAmount;
								checkFlatDiscountAmount=$("#"+tdId).val();
								var checkActualAmount;
									  checkActualAmount=$("#"+tdId+tdId).val();
									   if((parseFloat(checkFlatDiscountAmount) + parseFloat(checkPartialPaymentAmount)  ) > parseFloat(checkActualAmount))
										{
											 edumaatAlert({
									        		type:'warning',
									        		text:'Please Enter Correct Amount'
									        	});
											$("#"+tdId).val('');
										}
									 });
						
						$(document).on('change',".payment",function (event){   
							var tdId=this.id;
							var flatPaymentId= tdId.replace(/[^\d]/g, '');
							var checkFlatPaymentAmount=0.0;
							if(document.getElementById("discountFlat"+flatPaymentId))
							{
								checkFlatPaymentAmount=$("#discountFlat"+flatPaymentId).val();	
							}
							
							var checkFlatDiscountAmount;
								checkFlatDiscountAmount=$("#"+tdId).val();
								var checkActualAmount;
									  checkActualAmount=$("#"+tdId+tdId).val();
										if((parseFloat(checkFlatDiscountAmount) + parseFloat(checkFlatPaymentAmount))> parseFloat(checkActualAmount))
										{
											 edumaatAlert({
									        		type:'warning',
									        		text:'Please Enter Correct Amount'
									        	});
											$("#"+tdId).val('');
										}
									 });

						$('#paymentgatewaytesting').click(function(){
							 var selectedFeesItemIDs = [];
							 var rowcollection =  datatable.$(".case:checked", {"page": "all"});
							 rowcollection.each(function(index,elem1){
								 selectedFeesItemIDs.push($(elem1).val());
							 });
							if((selectedFeesItemIDs.length)>0){
								$('#confirmedInvoiceFormDiv').hide();
								$('#paymentDetailsPanel').show();
								if($('#isDiscountAppliedHF').val()==1){
									if($('#disTypeHF').val()=='flat'){
										//flat discount logic
										var  allSelectedFeesItemFlatDiscountAmounts=[];
											datatable.column(0).visible(true);
										var  allSelectedFeesItemIds=[];
										$.each(selectedFeesItemIDs,function(index,elem1){	
											allSelectedFeesItemIds.push(elem1);
											$("#dataTobeSubmitted").append(
									    		    $('<input>', {
									    		        type: 'hidden',
									    		        val:elem1,
									    		        name: 'flatDiscountItem'
									    		    })
								    		    );
											
											var flatDiscountId=elem1;
											var flatDisountAmount=0.0;
											if($("#discountFlat"+flatDiscountId).val()!=null)
											{
												flatDisountAmount+=$("#discountFlat"+flatDiscountId).val();
												allSelectedFeesItemFlatDiscountAmounts.push(flatDisountAmount);
												$("#dataTobeSubmitted").append(
										    		    $('<input>', {
										    		        type: 'hidden',
										    		        val:flatDisountAmount,
										    		        name: 'flatDiscountItemAmount'
										    		    })
									    		    );
											}
											else
											{
												flatDisountAmount=0.0;
												$("#dataTobeSubmitted").append(
										    		    $('<input>', {
										    		        type: 'hidden',
										    		        val:flatDisountAmount,
										    		        name: 'flatDiscountItemAmount'
										    		    })
									    		    );
												allSelectedFeesItemFlatDiscountAmounts.push(flatDisountAmount);
											}
												
										  });
										$('#amount').val(amountTobeCollectedWithFlatDiscount(allSelectedFeesItemIds,allSelectedFeesItemFlatDiscountAmounts));
										
										
									}
									else if($('#disTypeHF').val()=='percentage'){
										//percentage discount logic
										datatable.column(0).visible(true);
										var  finalNormalFeesItemIds=[];
										var percentage=$('#disPerHF').val();
										$.each(selectedFeesItemIDs,function(index,elem1){			 
									    	finalNormalFeesItemIds.push(elem1);
           								    	$("#dataTobeSubmitted").append(
									    		    $('<input>', {
									    		        type: 'hidden',
									    		        val: elem1,
									    		        name: 'normalItem'
									    		    })
									    		);
									    });
									    $('#amount').val(amountTobeCollectedWithPercentgeDiscount(finalNormalFeesItemIds,percentage));
									}
								}else{
									//without discount logic
									var  finalNormalFeesItemIds=[];
									datatable.column(0).visible(true);
									$.each(selectedFeesItemIDs,function(index,elem1){	
									    	finalNormalFeesItemIds.push(elem1);
           								    	$("#dataTobeSubmitted").append(
									    		    $('<input>', {
									    		        type: 'hidden',
									    		        val: elem1,
									    		        name: 'normalItem'
									    		    })
									    		);
									    });
									    $('#amount').val(amountTobeCollectedWithoutDiscount(finalNormalFeesItemIds));
								}
							}
							else{
								edumaatAlert({
					        		type:'warning',
					        		text:'Select Atleast One Fees Item'
					        	})
							}
						});
						//proceed for payment details
						$('#proceed').click(function()
						{
							
							
							if($("#checkPaymentType").val()=="Full")
							{
								var selectedFeesItemIDs = [];
								 var rowcollection =  datatable.$(".case:checked", {"page": "all"});
								 rowcollection.each(function(index,elem1){
									 selectedFeesItemIDs.push($(elem1).val());
								 });
								if((selectedFeesItemIDs.length)>0){
									$('#confirmedInvoiceFormDiv').hide();
									$('#paymentDetailsPanel').show();
									if($('#isDiscountAppliedHF').val()==1){
										if($('#disTypeHF').val()=='flat'){
											//flat discount logic
											var  allSelectedFeesItemFlatDiscountAmounts=[];
												datatable.column(0).visible(true);
											var  allSelectedFeesItemIds=[];
											$.each(selectedFeesItemIDs,function(index,elem1){
												allSelectedFeesItemIds.push(elem1);
												$("#dataTobeSubmitted").append(
										    		    $('<input>', {
										    		        type: 'hidden',
										    		        val:elem1,
										    		        name: 'flatDiscountItem'
										    		    })
									    		    );
												
												var flatDiscountId=elem1;
												var flatDisountAmount=0.0;
												var partialAmount=0.0;
												var partialId=elem1;
												if($("#discountFlat"+flatDiscountId).val()!=null)
												{
													flatDisountAmount+=$("#discountFlat"+flatDiscountId).val();
													allSelectedFeesItemFlatDiscountAmounts.push(flatDisountAmount);
													$("#dataTobeSubmitted").append(
											    		    $('<input>', {
											    		        type: 'hidden',
											    		        val:flatDisountAmount,
											    		        name: 'flatDiscountItemAmount'
											    		    })
										    		    );
												}
												else
												{
													flatDisountAmount=0.0;
													$("#dataTobeSubmitted").append(
											    		    $('<input>', {
											    		        type: 'hidden',
											    		        val:flatDisountAmount,
											    		        name: 'flatDiscountItemAmount'
											    		    })
										    		    );
													allSelectedFeesItemFlatDiscountAmounts.push(flatDisountAmount);
												}
												
												
											  });
											$('#amount').val(amountTobeCollectedRefund(allSelectedFeesItemIds));
											
											
										}
										else if($('#disTypeHF').val()=='percentage'){
											//percentage discount logic
											datatable.column(0).visible(true);
											var  finalNormalFeesItemIds=[];
											var percentage=$('#disPerHF').val();
											$.each(selectedFeesItemIDs,function(index,elem1){			 
										    	finalNormalFeesItemIds.push(elem1);
	           								    	$("#dataTobeSubmitted").append(
										    		    $('<input>', {
										    		        type: 'hidden',
										    		        val: elem1,
										    		        name: 'normalItem'
										    		    })
										    		);
	           								    	
	    									
	    										
										    });
										    $('#amount').val(amountTobeCollectedRefund(finalNormalFeesItemIds));
										}
										
									}else{
										//without discount logic
										var  finalNormalFeesItemIds=[];
										datatable.column(0).visible(true);
										$.each(selectedFeesItemIDs,function(index,elem1){	
										    				   finalNormalFeesItemIds.push(elem1);
	        	           								    	$("#dataTobeSubmitted").append(
	        										    		    $('<input>', {
	        										    		        type: 'hidden',
	        										    		        val: elem1,
	        										    		        name: 'normalItem'
	        										    		    })
	        										    		);
	        	           								    	
	        	           								    	
												});
										    $('#amount').val(amountTobeCollectedRefund(finalNormalFeesItemIds));
									}
									
									/*$("#fineAmount").val(fineAmountAutomaticCalculation($("#currentstudentinvoiceid").val()));*/
									
								}
								else{
									edumaatAlert({
						        		type:'warning',
						        		text:'Select Atleast One Fees Item'
						        	})
								}
							}
							else if($("#checkPaymentType").val()=="Partial")
							{
							 var selectedFeesItemIDs = [];
							 var rowcollection =  datatable.$(".case:checked", {"page": "all"});
							 rowcollection.each(function(index,elem1){
								 selectedFeesItemIDs.push($(elem1).val());
							 });
							if((selectedFeesItemIDs.length)>0){
								$('#confirmedInvoiceFormDiv').hide();
								$('#paymentDetailsPanel').show();
								if($('#isDiscountAppliedHF').val()==1){
									if($('#disTypeHF').val()=='flat'){
										//flat discount logic
										var  allSelectedFeesItemFlatDiscountAmounts=[];
										var  allSelectedFeesItemPartialAmounts=[];
											datatable.column(0).visible(true);
										var  allSelectedFeesItemIds=[];
										$.each(selectedFeesItemIDs,function(index,elem1){
											allSelectedFeesItemIds.push(elem1);
											$("#dataTobeSubmitted").append(
									    		    $('<input>', {
									    		        type: 'hidden',
									    		        val:elem1,
									    		        name: 'flatDiscountItem'
									    		    })
								    		    );
											
											var flatDiscountId=elem1;
											var flatDisountAmount=0.0;
											var partialAmount=0.0;
											var partialId=elem1;
											if($("#discountFlat"+flatDiscountId).val()!=null)
											{
												flatDisountAmount+=$("#discountFlat"+flatDiscountId).val();
												allSelectedFeesItemFlatDiscountAmounts.push(flatDisountAmount);
												$("#dataTobeSubmitted").append(
										    		    $('<input>', {
										    		        type: 'hidden',
										    		        val:flatDisountAmount,
										    		        name: 'flatDiscountItemAmount'
										    		    })
									    		    );
											}
											else
											{
												flatDisountAmount=0.0;
												$("#dataTobeSubmitted").append(
										    		    $('<input>', {
										    		        type: 'hidden',
										    		        val:flatDisountAmount,
										    		        name: 'flatDiscountItemAmount'
										    		    })
									    		    );
												allSelectedFeesItemFlatDiscountAmounts.push(flatDisountAmount);
											}
											
											if($("#payment"+partialId).val()!=null)
											{
												
												partialAmount+=$("#payment"+partialId).val();
												allSelectedFeesItemPartialAmounts.push(partialAmount);
												$("#dataTobeSubmitted").append(
										    		    $('<input>', {
										    		        type: 'hidden',
										    		        val:partialAmount,
										    		        name: 'partialItemAmount'
										    		    })
									    		    );
											}
											else
											{
												partialAmount=0.0;
												$("#dataTobeSubmitted").append(
										    		    $('<input>', {
										    		        type: 'hidden',
										    		        val:partialAmount,
										    		        name: 'partialItemAmount'
										    		    })
									    		    );
												allSelectedFeesItemPartialAmounts.push(partialAmount);
											}
												
										  });
										$('#amount').val(amountTobeCollectedWithFlatDiscountAndPartialAmount(allSelectedFeesItemIds,allSelectedFeesItemFlatDiscountAmounts,allSelectedFeesItemPartialAmounts));
										
										
									}
									else if($('#disTypeHF').val()=='percentage'){
										//percentage discount logic
										datatable.column(0).visible(true);
										var  finalNormalFeesItemIds=[];
										var  allSelectedFeesItemPartialAmounts=[];
										var percentage=$('#disPerHF').val();
										$.each(selectedFeesItemIDs,function(index,elem1){			 
									    	finalNormalFeesItemIds.push(elem1);
           								    	$("#dataTobeSubmitted").append(
									    		    $('<input>', {
									    		        type: 'hidden',
									    		        val: elem1,
									    		        name: 'normalItem'
									    		    })
									    		);
           								    	var partialAmount=0.0;
    											var partialId=elem1;
    									
    											
    											if($("#payment"+partialId).val()!=null)
    											{
    												
    												partialAmount+=$("#payment"+partialId).val();
    												allSelectedFeesItemPartialAmounts.push(partialAmount);
    												$("#dataTobeSubmitted").append(
    										    		    $('<input>', {
    										    		        type: 'hidden',
    										    		        val:partialAmount,
    										    		        name: 'partialItemAmount'
    										    		    })
    									    		    );
    											}
    											else
    											{
    												partialAmount=0.0;
    												$("#dataTobeSubmitted").append(
    										    		    $('<input>', {
    										    		        type: 'hidden',
    										    		        val:partialAmount,
    										    		        name: 'partialItemAmount'
    										    		    })
    									    		    );
    												allSelectedFeesItemPartialAmounts.push(partialAmount);
    											}
									    });
									    $('#amount').val(amountTobeCollectedWithPercentgeDiscountAndPartialAmount(finalNormalFeesItemIds,percentage,allSelectedFeesItemPartialAmounts));
									}
									
								}else{
									//without discount logic
									var  finalNormalFeesItemIds=[];
									var  allSelectedFeesItemPartialAmounts=[];
									datatable.column(0).visible(true);
									$.each(selectedFeesItemIDs,function(index,elem1){	
									    				   finalNormalFeesItemIds.push(elem1);
        	           								    	$("#dataTobeSubmitted").append(
        										    		    $('<input>', {
        										    		        type: 'hidden',
        										    		        val: elem1,
        										    		        name: 'normalItem'
        										    		    })
        										    		);
        	           								    	
        	           								    	var partialAmount=0.0;
        	    											var partialId=elem1;
        	           										if($("#payment"+partialId).val()!=null)
        	    											{
        	    												
        	    												partialAmount+=$("#payment"+partialId).val();
        	    												allSelectedFeesItemPartialAmounts.push(partialAmount);
        	    												$("#dataTobeSubmitted").append(
        	    										    		    $('<input>', {
        	    										    		        type: 'hidden',
        	    										    		        val:partialAmount,
        	    										    		        name: 'partialItemAmount'
        	    										    		    })
        	    									    		    );
        	    											}
        	    											else
        	    											{
        	    												partialAmount=0.0;
        	    												$("#dataTobeSubmitted").append(
        	    										    		    $('<input>', {
        	    										    		        type: 'hidden',
        	    										    		        val:partialAmount,
        	    										    		        name: 'partialItemAmount'
        	    										    		    })
        	    									    		    );
        	    												allSelectedFeesItemPartialAmounts.push(partialAmount);
        	    											}
											});
									    $('#amount').val(amountTobeCollectedWithoutDiscountAndPartialAmount(finalNormalFeesItemIds,allSelectedFeesItemPartialAmounts));
								}
								
								$("#fineAmount").val(fineAmountAutomaticCalculation($("#currentstudentinvoiceid").val()));
								
							}
							else{
								edumaatAlert({
					        		type:'warning',
					        		text:'Select Atleast One Fees Item'
					        	})
							}
						}
						});
						
						
		    			$('#invoicedetailsdiv').hide();
		    			$('#confirmedInvoiceFormDiv').show();
		    			$("#generateFCR").click(function(){
		    				
		    				/*if($('#amount').val()<=0 && ($('#disTypeHF').val()!='percentage' && $('#disTypeHF').val()!='flat'))
		    				{
		    					 edumaatAlert({
					    			  title: "Info !",
					    			  text:"Cannot Do This Transaction.Transaction Fees Amount Is "+0,
					    			  type: "info",
					    			  confirmButtonText: "Cool"
					    			}).then(function(){
					    				window.location.href=ctx+'/receipt/generate';
						        		
						        	});
		    				}
		    				else
		    				{*/
		    					if($("#paymentDetailsPanelForm").valid()){
		    						if($('#checkemail').is(':checked'))
			    					{
			    						$("#selectedCheckBoxEmailId").val("1");
				    					 
			    					}
			    					else
			    					{
			    						$("#selectedCheckBoxEmailId").val("0");
			    					}
			    					if($('#checksms').is(':checked'))
			    					{
			    						 $("#selectedCheckBoxSmsId").val("1");
					    			}
			    					else
			    					{
			    						 $("#selectedCheckBoxSmsId").val("0");
			    					}
		    						$(".loader").show();
		    						$('#paymentDetailsPanelForm').submit();
		    					}
		    				/*}*/
		    				
		    			});
			    
				 
			/* }*/
			 
		 })
	
}


function showFeesItemDiv(invoiceId)
{
	if(document.getElementById('feesItemFormDiv').style.display=="none")
	{
	document.getElementById('feesItemFormDiv').style.display="block";
	document.getElementById('FormDiv').style.display="none";
	document.getElementById('invoicedetailsdiv').style.display="none";

	}
	var studentInvoiceId=invoiceId;
		$.ajax(	
			    {
			        type: "GET",
			        url:ctx+'/invoice/studentInvoice/itemdetails' ,
			        data:{studentInvoiceId:studentInvoiceId},
			        cache: false,
			        success: function (data) {
			        	
			        	var datatable = $('#studentInvoiceFeesItems').DataTable();
			        	/* $(".form-horizontal").trigger('reset'); */
			        	 datatable.clear().draw();
						
							$.each(data, function (i, item) {
								i=i+1;
								var partialPaymentReceiptAmount=0.0;
								if(item.studentPartialPaymentReceiptDetail)
								{
									partialPaymentReceiptAmount=partialPaymentReceiptAmount+item.studentPartialPaymentReceiptDetail.paidReceiptAmount;
								}
								else
								{
									if(item.studentInvoiceElementPaymentStatus==0)
									{
										partialPaymentReceiptAmount+=item.studentInvoiceElementTotalAmount;
									}
								}

							   datatable.row.add([i,item.feesItem.feesItemName,item.studentInvoiceElementTotalAmount,partialPaymentReceiptAmount]).draw( false );
						   });
			        }
			      
			    });
}

function showStudentFeesDiv(){
	
	
	if(document.getElementById('feesItemFormDiv').style.display=="block"){
	document.getElementById('feesItemFormDiv').style.display="none";
	document.getElementById('invoicedetailsdiv').style.display="block";
	

	}
}  
      
 function amountTobeCollectedWithoutDiscount(finalNormalFeesItemIds){
	 var amount=0.0;
	 if(finalNormalFeesItemIds.length>0){
	 $.ajax(	
			    {
			        type: "GET",
			        url:ctx+'/receipt/amounttobeCollected' ,
			        data:{finalNormalFeesItemIds:finalNormalFeesItemIds,discountMethod:"none"},
			        contentType: "application/json; charset=utf-8",
			        dataType: "json",
			        async: false,
			        cache: false,
			        success: function (data) {
			        	amount=data;
			        }
			      
			    });
	 }
	 return amount;
 }
 
 function amountTobeCollectedWithoutDiscountAndPartialAmount(finalNormalFeesItemIds,allSelectedFeesItemPartialAmounts){
	 var amount=0.0;
	 if(finalNormalFeesItemIds.length>0){
	 $.ajax(	
			    {
			        type: "GET",
			        url:ctx+'/receipt/amounttobeCollectedWithPartialAmount' ,
			        data:{finalNormalFeesItemIds:finalNormalFeesItemIds,discountMethod:"none",allSelectedFeesItemPartialAmounts:allSelectedFeesItemPartialAmounts},
			        contentType: "application/json; charset=utf-8",
			        dataType: "json",
			        async: false,
			        cache: false,
			        success: function (data) {
			        	amount=data;
			        }
			      
			    });
	 }
	 return amount;
 }
 
 function amountTobeCollectedWithPercentgeDiscount(finalNormalFeesItemIds,percentage){
	 var amount=0.0;
	 if(finalNormalFeesItemIds.length>0){
	 $.ajax(	
			    {
			        type: "GET",
			        url:ctx+'/receipt/amounttobeCollected' ,
			        data:{finalNormalFeesItemIds:finalNormalFeesItemIds,discountMethod:"percentage",percentage:percentage},
			        contentType: "application/json; charset=utf-8",
			        dataType: "json",
			        async: false,
			        cache: false,
			        success: function (data) {
			        	amount=data;
			        }
			      
			    });
	 }
		return amount;
		
}
 
 function amountTobeCollectedWithPercentgeDiscountAndPartialAmount(finalNormalFeesItemIds,percentage,allSelectedFeesItemPartialAmounts){
	 var amount=0.0;
	 if(finalNormalFeesItemIds.length>0){
	 $.ajax(	
			    {
			        type: "GET",
			        url:ctx+'/receipt/amounttobeCollectedWithPartialAmount' ,
			        data:{finalNormalFeesItemIds:finalNormalFeesItemIds,discountMethod:"percentage",percentage:percentage,allSelectedFeesItemPartialAmounts:allSelectedFeesItemPartialAmounts},
			        contentType: "application/json; charset=utf-8",
			        dataType: "json",
			        async: false,
			        cache: false,
			        success: function (data) {
			        	amount=data;
			        }
			      
			    });
	 }
		return amount;
		
}
 
 function amountTobeCollectedWithFlatDiscount(finalNormalFeesItemIds,allSelectedFeesItemFlatDiscountAmounts){
	 var amount=0.0;
	 if(finalNormalFeesItemIds.length>0){
		 $.ajax(	
				    {
				        type: "GET",
				        url:ctx+'/receipt/amounttobeCollected',
				        data:{finalNormalFeesItemIds:finalNormalFeesItemIds,discountMethod:"flat",finalSelectedFeesItemFlatDiscountAmounts:allSelectedFeesItemFlatDiscountAmounts},
				        contentType: "application/json; charset=utf-8",
				        dataType: "json",
				        async: false,
				        cache: false,
				        success: function (data) {
				        	amount=data;
				        }
				      
				    });
	 }
	 return amount;
}
 
 
 function amountTobeCollectedRefund(finalNormalFeesItemIds,allSelectedFeesItemFlatDiscountAmounts){
	 var amount=0.0;
	 if(finalNormalFeesItemIds.length>0){
		 $.ajax(	
				    {
				        type: "GET",
				        url:ctx+'/receipt/amounttobeCollected',
				        data:{finalNormalFeesItemIds:finalNormalFeesItemIds,discountMethod:"refund",finalSelectedFeesItemFlatDiscountAmounts:allSelectedFeesItemFlatDiscountAmounts},
				        contentType: "application/json; charset=utf-8",
				        dataType: "json",
				        async: false,
				        cache: false,
				        success: function (data) {
				        	amount=data;
				        }
				      
				    });
	 }
	 return amount;
}
 
 function amountTobeCollectedWithFlatDiscountAndPartialAmount(finalNormalFeesItemIds,allSelectedFeesItemFlatDiscountAmounts,allSelectedFeesItemPartialAmounts){
	 var amount=0.0;
	 if(finalNormalFeesItemIds.length>0){
		 $.ajax(	
				    {
				        type: "GET",
				        url:ctx+'/receipt/amounttobeCollectedWithPartialAmount',
				        data:{finalNormalFeesItemIds:finalNormalFeesItemIds,discountMethod:"flat",finalSelectedFeesItemFlatDiscountAmounts:allSelectedFeesItemFlatDiscountAmounts,allSelectedFeesItemPartialAmounts:allSelectedFeesItemPartialAmounts},
				        contentType: "application/json; charset=utf-8",
				        dataType: "json",
				        async: false,
				        cache: false,
				        success: function (data) {
				        	amount=data;
				        }
				      
				    });
	 }
	 return amount;
}
 
 function fineAmountAutomaticCalculation(invoiceid){
	 var amount=0.0;
	 	 $.ajax({
	 		 			type: "GET",
				        url:ctx+'/receipt/fineamounttobeCollected',
				        data:{invoiceId:invoiceid},
				        contentType: "application/json; charset=utf-8",
				        dataType: "json",
				        async: false,
				        cache: false,
				        success: function (data) 
				        {
				        	amount=data;
				        }
				      
				    });
	 return amount;
}
 
 function handleChange(input) {
	    if (input.value < 0) input.value = 0;
	    if (input.value > 100) input.value = 100;
	  }