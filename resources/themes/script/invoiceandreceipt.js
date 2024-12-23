 var ctx= window.location.pathname.substring(0, window.location.pathname.indexOf("/",2));
$(document).ready(function() {
	var currentdate = new Date(); 
    var datetime = currentdate.getDate() + "-"
                + (currentdate.getMonth()+1)  + "-" 
                + currentdate.getFullYear() + "_"  
                + currentdate.getHours() + "-"  
                + currentdate.getMinutes() + "-" 
                + currentdate.getSeconds();

    var exportfilename='Invoice_Fees_Report_'+datetime;
    var exportfilename1='Receipt_Fees_Report_'+datetime;
	/*$('.dataTables_filter input').unbind().keyup(function(e) {
	    var value = $(this).val();
	    if(value.length>0)
	    	{
	    	 alert();
	    	}else
	    		{}
	     
	});*/
		
		$('#class').change(function(event) {
	  	    var classId = $("#class").val();
	  	    if(classId=='all'){
	  	    	$("#sectionDiv").hide();
	  	    }
	  	    else{
	  	    	
	  	    	$("#sectionDiv").show();
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
				        		  select.append('<option value="" disabled>Select Section</option>');
				        	  }
						   $.each(response, function(key,value) {
						  		 if(key==0){
						     	    		select.append('<option value="" disabled>Select Section</option>');
						     	    	}
						  		$('<option>').val(value.sectionClass.sectionId).text(value.sectionClass.sectionName).appendTo(select);
						  	 }); 
						   $('#section').selectpicker('show');
			        });
	  	    }
	  	    
	  	    
	  	 
	       
	 });
		
		
	$("#criteria").change(function() {
		var value = $(this).val();
		 if(value==="specialcategory"){
			    $(".form-group-special-category").show();  
			 
		 }
		 else
			 {
			 	$(".form-group-special-category").hide();  
			 }
    });
	
	
	$('input[type=radio][name=option]').change(function() {
		if (this.value == 'byadmissionno') {
			$("#classWise").hide();
        	$("#admissionNoWise").show();
        	$("#dateRange").hide();
        	$("#academicYearFormGroup").show();
        	$("#visibilityForReceiptDate").hide();
        	$("#visibilityForInvoiceDate").hide();
        }
        else if (this.value == 'byclass') {
        	$("#admissionNoWise").hide();
        	$("#classWise").show();
        	$("#dateRange").hide();
        	$("#academicYearFormGroup").show();
        	$("#visibilityForReceiptDate").hide();
        	$("#visibilityForInvoiceDate").hide();
        }
        else if(this.value == 'byDateRange'){
        	$("#admissionNoWise").hide();
        	$("#classWise").hide();
        	$("#dateRange").show();
        	$("#academicYearFormGroup").hide();
        	$("#visibilityForReceiptDate").show();
        	$("#visibilityForInvoiceDate").show();
        	
		
        }
    });
	
	
	 $("#getdetailsfromselectedcriteria").click(function(event){
		 
			
			    if($("#getDetailsForm").valid())
								{
			    	
				 	
							var invoiceorfcrvalue = $("#invoiceandfcr").val();
							 var data=$("#getDetailsForm").serialize();
							 
							 $("#defaultInvoiceFromDate").html($("#fromDate").val());
								$("#defaultInvoiceToDate").html($("#toDate").val());
								$("#defaultReceiptFromDate").html($("#fromDate").val());
								$("#defaultReceiptToDate").html($("#toDate").val());
								/*if($("#fromDate").val()!=null)
								{
									  exportfilename='Invoice_Fees_Report_(From_Date : '+$("#fromDate").val()+' To Date : '+$("#toDate").val()+')_'+datetime;
									  exportfilename1='Receipt_Fees_Report_(From_Date : '+$("#fromDate").val()+' To Date : '+$("#toDate").val()+')_'+datetime;
								}*/
								  $('.loader').show();
							
							 if(invoiceorfcrvalue ==="invoice"){
								
								 $.ajax(	
									    {
									        type: "GET",
									        url:ctx+"/invoice/invoiceAndReceipt/invoice" ,
									        data: data,
									        contentType: "application/json; charset=utf-8",
									        dataType: "json",
									        cache: false,
									        success: function (invoicesrep) {
									        	
									        	
									        	$("#reportForm").hide();
									        	$("#backButton").show();
									        	  document.getElementById('invoicedetailsdiv').style.display="block";
												   document.getElementById('receiptdetailsdiv').style.display="none";
												  $('.loader').hide();
									        	var datatable = $('#invoicedatatable').DataTable();
									        	 $(".form-horizontal").trigger('reset'); 
													      datatable.clear().draw();
													  $.each(invoicesrep, function (i,invoices) {
													      var url=ctx+"/invoice/print?invoiceId="+invoices.studentInvoiceId;
												        	var name;
												        	if(invoices.student.lastName!=null){
												        		name=invoices.student.firstName+' '+invoices.student.lastName;
												        	}else{
												        		name=invoices.student.firstName;
												        	}
												        	
												        	 $.date = function(dateObject) {
																    var d = new Date(dateObject);
																    var day = d.getDate();
																    var month = d.getMonth() + 1;
																    var year = d.getFullYear();
																    if (day < 10) {
																        day = "0" + day;
																    }
																    if (month < 10) {
																        month = "0" + month;
																    }
																    var date = day + "/" + month + "/" + year;

																    return date;
																};
												        	var date = $.date(invoices.createdDate);
												        	/*alert($.fn.datepicker("dd/mm/yy",new Date(invoices.createdDate)));*/
												        	datatable.row.add([invoices.studentInvoiceId,invoices.academicYear.academicYearTitle,invoices.feesTerm.feesTermName,invoices.student.admissionNo,name,invoices.student.studentClass.className+"/"+invoices.student.section.sectionName,date,invoices.invoiceAmount,'  <td><a href='+url+' id="viewinvoice" target="__blank" class="invoice" type="button"data-href="#" data-id="" data-toggle="modal" >'
								                               +'<span class="glyphicon glyphicon-eye-open"></span></a>  </td>'
									                              + '  <td><a href="" class="print" id="invoiceprint"  type="button" data-toggle="modal" data-id='+invoices.studentInvoiceId+' data-target="#invprint">'
									                                   +'<span class="glyphicon glyphicon-print"></span></a>  </td> '
									                              ]).draw( false );
												        });
													
									        
									        },
									        error:function(){
									        	$('.loader').hide();
									        	edumaatAlert({
									        		type:'error',
									        		text:'Invalid Student Admission No'
									        	}).then(function(){
									        		window.location.href=ctx+'/invoice/invoiceAndReceipt';
									        		
									        	});
									        }
									      
									    });
									  
									
										
								 
							 }
							 else
								 {
								
								
								$.ajax(	
										    {
										        type: "GET",
										        url:ctx+"/receipt/invoiceAndReceipt/receipt",
										        data: data,
										        contentType: "application/json; charset=utf-8",
										        dataType: "json",
										        cache: false,
										        success: function (receipts) {
										        	$("#reportForm").hide();
										        	$("#backButton").show();
										        	
										        	$('.loader').hide();
										        	 document.getElementById('receiptdetailsdiv').style.display="block";
													 document.getElementById('invoicedetailsdiv').style.display="none";
													

										        	var datatable = $('#receiptdatatable').DataTable();
										        	 $(".form-horizontal").trigger('reset'); 
														      datatable.clear().draw();
														  $.each(receipts, function (i,receipts) {
														 
													        	var name;
													        	var fineAmount=0.0;
													        	var discountamount=0.0;
													        	if(receipts.student.lastName!=null){
													        		name=receipts.student.firstName+' '+receipts.student.lastName;
													        	}else{
													        		name=receipts.student.firstName;
													        	}
													        	
													        	
													        	$.each(receipts.receiptFines, function (i,receiptfines) {
													        		fineAmount=fineAmount+receiptfines.fineAmount;
													        	});
													        	$.each(receipts.receiptDetails, function (i,discounts) {
													        		discountamount+=discounts.discountAmount;
													        	});
													        	 $.date = function(dateObject) {
																	    var d = new Date(dateObject);
																	    var day = d.getDate();
																	    var month = d.getMonth() + 1;
																	    var year = d.getFullYear();
																	    if (day < 10) {
																	        day = "0" + day;
																	    }
																	    if (month < 10) {
																	        month = "0" + month;
																	    }
																	    var date = day + "/" + month + "/" + year;

																	    return date;
																	};
													        	var date = $.date(receipts.paymentReceivedDate);
													        	var url=ctx+"/receipt/print?receiptId="+receipts.receiptId;
													            datatable.row.add([receipts.receiptId,receipts.studentInvoice.feesTerm.feesTermName,receipts.student.admissionNo,name,receipts.student.studentClass.className+'/'+receipts.student.section.sectionName,date,receipts.paymentMode.paymentModeTitle,receipts.paymentStatus.paymentStatusTitle,discountamount,receipts.amount,fineAmount,'  <td><a href='+url+' id="viewreceipt"  class="receipt" target="_blank" type="button"data-href="#" data-id="" data-toggle="modal">'
									                               +'<span class="glyphicon glyphicon-eye-open"></span></a>  </td>'
										                              + '  <td><a href="" class="print" id="receiptprint" data-toggle="modal" type="button"  data-id='+receipts.receiptId+' data-target="#recprint">'
										                                   +'<span class="glyphicon glyphicon-print"></span></a>   </td>'
										                              ]).draw( false );
													        });
										       
										        
										        },
										        error:function(){
										        	$('.loader').hide();
										        	edumaatAlert({
										        		type:'error',
										        		text:'Invalid Student Admission No'
										        	}).then(function(){
										        		window.location.href=ctx+'/invoice/invoiceAndReceipt';
										        		
										        	});
										        }
										      
										    });
								 
								 }
								
							
								}
								
						
									 


							
						   
						   
				  });	 
		
	 $('#invoicedatatable').on( 'click', 'tr td a#invoiceprint', function () {
        		 
        		 var invoiceId = $(this).attr('data-id');
        		
        		 
      		   
      			   $('#printinv').attr("href", ctx+"/invoice/print?invoiceId="+invoiceId);
      			  
      			
      		  $("#printinv").printPage();
      		  
      		  $("#printinv").click(function() {
      			$('#invprint').modal('hide');
				
			});
      		
      		   
      		 
      		   
      		}); 
$('#receiptdatatable').on( 'click', 'tr td a#receiptprint', function () {
        		 
        		 var receiptId = $(this).attr('data-id');
        		
        		 
      		   
      			   $('#printrec').attr("href", ctx+"/receipt/printPage?receiptId="+receiptId);
      			
      		  $("#printrec").printPage();
      		$("#printrec").click(function() {
      			$('#recprint').modal('hide');
				
			});
      		   
      		 
      		   
      		}); 
				 



/*"paging": false,
scrollY: 400,*/
var currecyCode="";


if($("#currecyCodeData").text()!=null)
	{
	currecyCode=$("#currecyCodeData").val();
	}

	$('#invoicedatatable').DataTable({
		dom: 'Bfrtip',
		 buttons: [
		            {
		                extend: 'copy',
		                title: exportfilename,footer:true
		                
		            },
		            {
		                extend: 'excel',
		                title: exportfilename,footer:true
		            },
		            {
		                extend: 'pdf',
		               title: exportfilename,footer:true
		            },
		            {
		            	 extend: 'csv',
		                title: exportfilename,footer:true
		            },
		            {
		            	 extend: 'print',
		                title: exportfilename,footer:true
		            }
		        ],
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
	       .column( 7, {'search': 'applied'} )
	       .data()
	       .reduce( function (a, b) {
	           return intVal(a) + intVal(b);
	       }, 0 );

	   // TotalAmount over this page
	   pageTotalAmount = api
	       .column( 7, { page: 'current'} )
	       .data()
	       .reduce( function (a, b) {
	           return intVal(a) + intVal(b);
	       }, 0 );

	   // Update footer
	  /* $( api.column( 7 ).footer() ).html(
	       ''+pageTotalAmount +' ('+ totalAmount +' total)'
	   );*/
	   
	  /* $( api.column( 7 ).footer() ).html(
			   totalAmount 
		   );*/
		   $("#invoicegrandtotal").html(totalAmount);
		   $("#invoicepagetotal").html(pageTotalAmount);
	 
	  	}
	});


	$('#receiptdatatable').DataTable({
		dom: 'Bfrtip',
		 buttons: [
		            {
		                extend: 'copy',
		                title: exportfilename1,footer:true
		                
		            },
		            {
		                extend: 'excel',
		                title: exportfilename1,footer:true
		            },
		            {
		                extend: 'pdf',
		               title: exportfilename1,footer:true
		            },
		            {
		            	 extend: 'csv',
		                title: exportfilename1,footer:true
		            },
		            {
		            	 extend: 'print',
		                title: exportfilename1,footer:true
		            }
		        ],
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
	   totalDiscountAmount = api
	       .column( 8, {'search': 'applied'}  )
	       .data()
	       .reduce( function (a, b) {
	           return intVal(a) + intVal(b);
	       }, 0 );

	   // TotalAmount over this page
	   pageTotalDiscountAmount = api
	       .column( 8, { page: 'current'} )
	       .data()
	       .reduce( function (a, b) {
	           return intVal(a) + intVal(b);
	       }, 0 );
	   // TotalAmount over all pages
	   totalAmount = api
	       .column( 9, {'search': 'applied'}  )
	       .data()
	       .reduce( function (a, b) {
	           return intVal(a) + intVal(b);
	       }, 0 );

	   // TotalAmount over this page
	   pageTotalAmount = api
	       .column( 9, { page: 'current'} )
	       .data()
	       .reduce( function (a, b) {
	           return intVal(a) + intVal(b);
	       }, 0 );
	   // Update footer
	   /*$( api.column( 8 ).footer() ).html(
	       ''+pageTotalAmount +' ('+ totalAmount +' total)'
	   );*/
	   
	   // TotalPaindAmount over all pages
	   totalFineAmount = api
	       .column( 10 , {'search': 'applied'} )
	       .data()
	       .reduce( function (a, b) {
	           return intVal(a) + intVal(b);
	       }, 0 );

	   // TotalPaidAmount over this page
	   pageTotalFineAmount = api
	       .column( 10, { page: 'current'} )
	       .data()
	       .reduce( function (a, b) {
	           return intVal(a) + intVal(b);
	       }, 0 );

	   // Update footer
	   /*$( api.column( 9 ).footer() ).html(
	       ''+pageTotalFineAmount +' ('+ totalFineAmount +' total)'
	   );*/
	 
	    $("#receiptgrandtotaldiscountamount").html(totalDiscountAmount);
	    $("#receiptgrandtotalamount").html(totalAmount);
	   $("#receiptgrandtotalfineamount").html(totalFineAmount);
	   $("#receiptpagetotaldiscountamount").html(pageTotalDiscountAmount);
	   $("#receiptpagetotalamount").html(pageTotalAmount);
	   $("#receiptpagetotalfineamount").html(pageTotalFineAmount);
	}
	});		 
				   
				
		});
		
	
function showinvoiceDiv(){
	
	if(document.getElementById('viewinvoicediv').style.display=="none"){
	document.getElementById('viewinvoicediv').style.display="block";
	document.getElementById('ListDiv').style.display="none";
	document.getElementById('invoicedetailsdiv').style.display="none";
	document.getElementById('viewreceipt').style.display="none";
	
	}

}
function showreceiptDiv(){
	
	if(document.getElementById('viewreceiptdiv').style.display=="none"){
	document.getElementById('viewreceiptdiv').style.display="block";
	document.getElementById('ListDiv').style.display="none";
	document.getElementById('invoicedetailsdiv').style.display="none";
	
	document.getElementById('viewinvoice').style.display="none";
	}

}

    