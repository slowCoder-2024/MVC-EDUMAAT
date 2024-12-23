$(document).ready(function() {
			
	var ctx= window.location.pathname.substring(0, window.location.pathname.indexOf("/",2));
	
	var currentdate = new Date(); 
    var datetime = currentdate.getDate() + "-"
                + (currentdate.getMonth()+1)  + "-" 
                + currentdate.getFullYear() + "_"  
                + currentdate.getHours() + "-"  
                + currentdate.getMinutes() + "-" 
                + currentdate.getSeconds();
var exportfilename='Academic_Fees_Report_'+datetime;

var currecyCode="";
if($("#currecyCodeData").text()!=null)
	{
	currecyCode=$("#currecyCodeData").val();
	}

$('#ledgerAccountHeadList').DataTable({
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
   /* $( api.column( 2 ).footer() ).html(
        ''+pageTotalAmount +' ('+ totalAmount +' total)'
    );*/
  
    // TotalPaindAmount over all pages
    totalPaidAmount = api
        .column( 3 , {'search': 'applied'})
        .data()
        .reduce( function (a, b) {
            return intVal(a) + intVal(b);
        }, 0 );

    // TotalPaidAmount over this page
    pageTotalPaidAmount = api
        .column( 3, { page: 'current'} )
        .data()
        .reduce( function (a, b) {
            return intVal(a) + intVal(b);
        }, 0 );

    // Update footer
   /* $( api.column( 3 ).footer() ).html(
        ''+pageTotalPaidAmount +' ('+ totalPaidAmount +' total)'
    );*/
    // TotalDiscountAount over all pages
    totalDiscountAmount = api
        .column( 4, {'search': 'applied'} )
        .data()
        .reduce( function (a, b) {
            return intVal(a) + intVal(b);
        }, 0 );

    // TotalDiscountAmount over this page
    pageTotalDiscountAmount = api
        .column( 4, { page: 'current'} )
        .data()
        .reduce( function (a, b) {
            return intVal(a) + intVal(b);
        }, 0 );

    // Update footer
  /*  $( api.column( 4 ).footer() ).html(
        ''+pageTotalDiscountAmount +' ('+ totalDiscountAmount +' total)'
    );*/
 // TotalOutStanding over all pages
    totalOutStandingAmount = api
        .column( 5 , {'search': 'applied'})
        .data()
        .reduce( function (a, b) {
            return intVal(a) + intVal(b);
        }, 0 );

    // TotalOutStanding over this page
    pageTotalOutStandingAmount = api
        .column( 5, { page: 'current'} )
        .data()
        .reduce( function (a, b) {
            return intVal(a) + intVal(b);
        }, 0 );

    // Update footer
   /* $( api.column( 5 ).footer() ).html(
        ''+pageTotalOutStandingAmount +' ('+ totalOutStandingAmount +' total)'
    );*/
    
 
    
    
    // TotalOutStanding over all pages
    totalAmountWithoutTax = api
        .column( 6 , {'search': 'applied'})
        .data()
        .reduce( function (a, b) {
            return intVal(a) + intVal(b);
        }, 0 );

    // TotalOutStanding over this page
    pageTotalAmountWithoutTax = api
        .column( 6, { page: 'current'} )
        .data()
        .reduce( function (a, b) {
            return intVal(a) + intVal(b);
        }, 0 );

    // Update footer
   /* $( api.column( 5 ).footer() ).html(
        ''+pageTotalOutStandingAmount +' ('+ totalOutStandingAmount +' total)'
    );*/
    
    
    
    // TotalOutStanding over all pages
    totalTaxAmount = api
        .column( 7 , {'search': 'applied'})
        .data()
        .reduce( function (a, b) {
            return intVal(a) + intVal(b);
        }, 0 );

    // TotalOutStanding over this page
    pageTotalTaxAmount = api
        .column( 7, { page: 'current'} )
        .data()
        .reduce( function (a, b) {
            return intVal(a) + intVal(b);
        }, 0 );

    // Update footer
   /* $( api.column( 5 ).footer() ).html(
        ''+pageTotalOutStandingAmount +' ('+ totalOutStandingAmount +' total)'
    );*/
    
    // TotalOutStanding over all pages
    totalTaxPercentage = api
        .column( 8 , {'search': 'applied'})
        .data()
        .reduce( function (a, b) {
            return intVal(a) + intVal(b);
        }, 0 );

    // TotalOutStanding over this page
    pageTaxPercentage = api
        .column( 8, { page: 'current'} )
        .data()
        .reduce( function (a, b) {
            return intVal(a) + intVal(b);
        }, 0 );

    // Update footer
   /* $( api.column( 5 ).footer() ).html(
        ''+pageTotalOutStandingAmount +' ('+ totalOutStandingAmount +' total)'
    );*/
    $("#academicgrandtotal").html(totalAmount);
    $("#academicgrandpaidamount").html(totalPaidAmount);
    $("#academicgranddiscount").html(totalDiscountAmount);
    $("#academicgrandoutstanding").html(totalOutStandingAmount);
    $("#academicgrandtotalwithouttax").html(totalAmountWithoutTax);
    $("#academicgrandtotaltaxamount").html(totalTaxAmount);
    $("#academicgrandtotaltaxpercentage").html(totalTaxPercentage);
    $("#academicpagetotal").html(pageTotalAmount);
    $("#academicpagepaidamount").html(pageTotalPaidAmount);
    $("#academicpagediscount").html(pageTotalDiscountAmount);
    $("#academicpageoutstanding").html(pageTotalOutStandingAmount);
    $("#academicpagetotalwithouttax").html(pageTotalAmountWithoutTax);
    $("#academicpagetotaltaxamount").html(pageTotalTaxAmount);
    $("#academicpagetotaltaxpercentage").html(pageTaxPercentage);
}
});
	
$('#feesTemplateItemList').DataTable({
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
       .column( 2 , {'search': 'applied'} )
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
  /* $( api.column( 2 ).footer() ).html(
       ''+pageTotalAmount +' ('+ totalAmount +' total)'
   );*/
   
   // TotalPaindAmount over all pages
   totalPaidAmount = api
       .column( 3  , {'search': 'applied'})
       .data()
       .reduce( function (a, b) {
           return intVal(a) + intVal(b);
       }, 0 );

   // TotalPaidAmount over this page
   pageTotalPaidAmount = api
       .column( 3, { page: 'current'} )
       .data()
       .reduce( function (a, b) {
           return intVal(a) + intVal(b);
       }, 0 );

   // Update footer
 /*  $( api.column( 3 ).footer() ).html(
       ''+pageTotalPaidAmount +' ('+ totalPaidAmount +' total)'
   );*/
   
   // TotalDiscountAount over all pages
   totalDiscountAmount = api
       .column( 4  , {'search': 'applied'})
       .data()
       .reduce( function (a, b) {
           return intVal(a) + intVal(b);
       }, 0 );

   // TotalDiscountAmount over this page
   pageTotalDiscountAmount = api
       .column( 4, { page: 'current'} )
       .data()
       .reduce( function (a, b) {
           return intVal(a) + intVal(b);
       }, 0 );

   // Update footer
  /* $( api.column( 4 ).footer() ).html(
       ''+pageTotalDiscountAmount +' ('+ totalDiscountAmount +' total)'
   );*/
   
   // TotalOutStanding over all pages
   totalOutStandingAmount = api
       .column( 5  , {'search': 'applied'})
       .data()
       .reduce( function (a, b) {
           return intVal(a) + intVal(b);
       }, 0 );

   // TotalOutStanding over this page
   pageTotalOutStandingAmount = api
       .column( 5, { page: 'current'} )
       .data()
       .reduce( function (a, b) {
           return intVal(a) + intVal(b);
       }, 0 );

   // Update footer
   /*$( api.column( 5 ).footer() ).html(
       ''+pageTotalOutStandingAmount +' ('+ totalOutStandingAmount +' total)'
   );*/
   
   
   // TotalOutStanding over all pages
   totalAmountWithoutTax = api
       .column( 6 , {'search': 'applied'})
       .data()
       .reduce( function (a, b) {
           return intVal(a) + intVal(b);
       }, 0 );

   // TotalOutStanding over this page
   pageTotalAmountWithoutTax = api
       .column( 6, { page: 'current'} )
       .data()
       .reduce( function (a, b) {
           return intVal(a) + intVal(b);
       }, 0 );

   // Update footer
  /* $( api.column( 5 ).footer() ).html(
       ''+pageTotalOutStandingAmount +' ('+ totalOutStandingAmount +' total)'
   );*/
   
   
   
   // TotalOutStanding over all pages
   totalTaxAmount = api
       .column( 7 , {'search': 'applied'})
       .data()
       .reduce( function (a, b) {
           return intVal(a) + intVal(b);
       }, 0 );

   // TotalOutStanding over this page
   pageTotalTaxAmount = api
       .column( 7, { page: 'current'} )
       .data()
       .reduce( function (a, b) {
           return intVal(a) + intVal(b);
       }, 0 );

   // Update footer
  /* $( api.column( 5 ).footer() ).html(
       ''+pageTotalOutStandingAmount +' ('+ totalOutStandingAmount +' total)'
   );*/
   
   // TotalOutStanding over all pages
   totalTaxPercentage = api
       .column( 8 , {'search': 'applied'})
       .data()
       .reduce( function (a, b) {
           return intVal(a) + intVal(b);
       }, 0 );

   // TotalOutStanding over this page
   pageTaxPercentage = api
       .column( 8, { page: 'current'} )
       .data()
       .reduce( function (a, b) {
           return intVal(a) + intVal(b);
       }, 0 );

   // Update footer
  /* $( api.column( 5 ).footer() ).html(
       ''+pageTotalOutStandingAmount +' ('+ totalOutStandingAmount +' total)'
   );*/
   
   $("#feesgrandtotal").html(totalAmount);
   $("#feesgrandpaidamount").html(totalPaidAmount);
   $("#feesgranddiscount").html(totalDiscountAmount);
   $("#feesgrandoutstanding").html(totalOutStandingAmount);
   $("#feesgrandtotalwithouttax").html(totalAmountWithoutTax);
   $("#feesgrandtotaltaxamount").html(totalTaxAmount);
   $("#feesgrandtotaltaxpercentage").html(totalTaxPercentage);
   $("#feespagetotal").html(pageTotalAmount);
   $("#feespagepaidamount").html(pageTotalPaidAmount);
   $("#feespagediscount").html(pageTotalDiscountAmount);
   $("#feespageoutstanding").html(pageTotalOutStandingAmount);
   $("#feespagetotalwithouttax").html(pageTotalAmountWithoutTax);
   $("#feespagetotaltaxamount").html(pageTotalTaxAmount);
   $("#feespagetotaltaxpercentage").html(pageTaxPercentage);
   
}
});
$('#fineDetails').DataTable({
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
     .column( 4  , {'search': 'applied'})
     .data()
     .reduce( function (a, b) {
         return intVal(a) + intVal(b);
     }, 0 );

 // TotalAmount over this page
 pageTotalAmount = api
     .column( 4, { page: 'current'} )
     .data()
     .reduce( function (a, b) {
         return intVal(a) + intVal(b);
     }, 0 );

 // Update footer
/* $( api.column( 4 ).footer() ).html(
     ''+pageTotalAmount +' ('+ totalAmount +' total)'
 );*/
 $("#academicfineamountgrandtotal").html(totalAmount);
 $("#academicfineamountpagetotal").html(pageTotalAmount);
}
});

$('#fineList').DataTable({
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
 /* $( api.column( 2 ).footer() ).html(
      ''+pageTotalAmount +' ('+ totalAmount +' total)'
  );*/
  $("#academicfinegrandtotal").html(totalAmount);
  $("#academicfinepagetotal").html(pageTotalAmount);
}
});

	$("#default").html("(Default) Current Academic Year Fees Report");
	$("#defaultFineDetails").html("(Default) Current Academic Year Fine Details");
	var category="";
	var category1="";
	if(category==="")
		{
	$('.loader').show();
		}
	$.ajax({
		   url:ctx+'/report/currentacademicyearacademicfeesreportlistwithouttax',
		   type:'GET',
		   success: function(response){
			   $('.loader').hide();
			    var datatable = $('#ledgerAccountHeadList').DataTable();
			     datatable.clear().draw();
				$.each(response, function(key,data)
                        {   
					
			     	datatable.row.add([data.f1,data.f2,data.f3,data.f4,data.f5,data.f6,data.f7,data.f8,data.f9,'<a href="#" id="edit"  type="button"data-href="#" data-id="'+data.f2+'" data-toggle="modal"onclick="showFeesTemplateItemDiv()"><span class="glyphicon glyphicon-credit-card"></span></a>']).draw( false );
					
                        });
		   },
		   error: function(){
		    // alert('ERROR OCCURED');
		    // window.location.href=ctx+"/report/academicfeesreport";
		   }
		 });

	
	$.ajax({
		   url:ctx+'/report/currentactiveacademicyearfinelist',
		   type:'GET',
		   success: function(response){
			    var datatable = $('#fineList').DataTable();
			     datatable.clear().draw();
			     var totalAmount=0.0;
			  	$.each(response.studentReceiptFines, function(key,data)
                     {   
						totalAmount=totalAmount+data.fineAmount;
						
                     });
				datatable.row.add([response.academicYearId,response.academicYearTitle, totalAmount,'<a href="#" id="edit"  type="button"data-href="#" data-id="'+response.academicYearId+'" data-toggle="modal"onclick="showFineList()"><span class="glyphicon glyphicon-credit-card"></span></a>']).draw( false );
				
		   },
		   error: function(){
		    // alert('ERROR OCCURED');
		    // window.location.href=ctx+"/report/academicfeesreport";
		   }
		 });
	$("#getLedgerList").click(function(event) 
	{
		
		if($("#dateDetailForm").valid())
		{
			$('.loader').show();
			category=$("#category").val();
			category1=category;
			$("#default").html("Academic Year Fees Report");
			$("#defaultFineDetails").html("Academic Year Fine Details");
			$.ajax({
		   url:ctx+'/report/academicfeesreportlistwithouttax',
		   data:{category:category},
		   type:'GET',
		   success: function(response){
			   $('.loader').hide();
			   var datatable = $('#ledgerAccountHeadList').DataTable();
			     datatable.clear().draw();
			     	 datatable.column( 3).visible(true);
			    	 datatable.column( 4 ).visible(true);
			    	 datatable.column( 5 ).visible(true);
			    	 datatable.column( 2 ).visible(true);
			    	 $.each(response, function(key,data)
		                     {   
							
					     	datatable.row.add([data.f1,data.f2,data.f3,data.f4,data.f5,data.f6,data.f7,data.f8,data.f9,'<a href="#" id="edit"  type="button"data-href="#" data-id="'+data.f2+'" data-toggle="modal" onclick="showFeesTemplateItemDiv()"><span class="glyphicon glyphicon-credit-card"></span></a>']).draw( false );
							
		                     });
			       },
		   error: function(){
		     //alert('ERROR OCCURED');
		     //window.location.href=ctx+"/report/academicfeesreport";
		   }
		 });
			$.ajax({
				   url:ctx+'/report/currentacademicyearfinelist',
				   data:{category:category},
				   type:'GET',
				   success: function(response){
					   var datatable = $('#fineList').DataTable();
					     datatable.clear().draw();
					    
					     var academicYearId;
					     var academicYearName;
					    	$.each(response, function(key,data)
			                     {   
								academicYearId=data.academicYearId;
								academicYearName=data.academicYearTitle
								 var totalAmount=0.0;
								$.each(data.studentReceiptFines, function(key1,data1)
					                     { 
									totalAmount=totalAmount+data1.fineAmount;
					                     });
								datatable.row.add([academicYearId,academicYearName, totalAmount,'<a href="#" id="edit"  type="button"data-href="#" data-id="'+academicYearId+'" data-toggle="modal"onclick="showFineList()"><span class="glyphicon glyphicon-credit-card"></span></a>']).draw( false );
								
			                     });
							
				   },
				   error: function(){
				     //alert('ERROR OCCURED');
				    // window.location.href=ctx+"/report/academicfeesreport";
				   }
				 });
		}
	});
	
	
	$('#ledgerAccountHeadList').on( 'click', 'tr td a#edit', function () {
		var ledgername = $(this).attr('data-id');
		$('.loader').show();
			$.ajax({
			   url:ctx+'/institution/ledgerAccount/ledgerAccountNameAndAcademicYearWithoutTax',
			   data:{ledgerAccountName:ledgername,category:category},
			   type:'GET',
			   success: function(response){
				   $('.loader').hide();
				   var datatable = $('#feesTemplateItemList').DataTable();
				     datatable.clear().draw();
				    	 datatable.column( 3).visible(true);
				    	 datatable.column( 4 ).visible(true);
				    	 datatable.column( 2 ).visible(true);
				    	 datatable.column( 5 ).visible(true);
				    		 $.each(response, function(key,data)
	                        {   
			   			
			   			datatable.row.add([data.f1,data.f2,data.f3,data.f4,data.f5,data.f6,data.f7,data.f8,data.f9]).draw( false );
	                       
	                        });
				    	/* $.each(response.feesTemplateItems, function(key,data)
			                        {   
					   			var totalAmount=0;
					   			var totalDiscount=0;
					   			var totalPaidAmount=0;
					   			var totalOutStandingAmount=0;
					   			$.each(data.studentInvoiceItems, function(key1,value1)
		                        {  
					   				totalAmount=totalAmount+value1.studentInvoiceElementTotalAmount;
						   		 });
					   			
					   			datatable.row.add([data.templateItemId,data.templateItemName,totalAmount,totalPaidAmount,totalDiscount,totalOutStandingAmount]).draw( false );
			                       
	                        });*/
					   },
			   error: function(){
			     //alert('ERROR OCCURED');
			     window.location.href=ctx+"/report/academicfeesreport";
			   }
			 });
	});

	
	$('#fineList').on( 'click', 'tr td a#edit', function () {
		var academicYearId = $(this).attr('data-id');
	   	
		category="";
		$('.loader').show();
			$.ajax({
				 url:ctx+'/report/currentacademicyearfinelist',
				 data:{academicYearId:academicYearId,category:category},
				   type:'GET',
				   success: function(response){
					   $('.loader').hide();
					    var datatable = $('#fineDetails').DataTable();
					     datatable.clear().draw();
					   		
					     $.each(response, function(key,data)
			                     { 
					    	 var studentFirstName="";
					    	 var studentLastName="";
								var admissionNo="";
								var termName="";
							
									$.each(data.studentReceiptFines, function(key1,data1)
					                     { 
											
											if(data1.studentReceipt.student.lastName)
												{
												studentLastName=data1.studentReceipt.student.lastName;
												}
											if(data1.studentReceipt.student.firstName)
												{
												studentFirstName=data1.studentReceipt.student.firstName;
												}
											if(data1.studentReceipt.student.admissionNo)
											{
												admissionNo=data1.studentReceipt.student.admissionNo;
											}
											if(data1.studentReceipt.studentInvoice.feesTerm.feesTermName)
												{
											 termName=data1.studentReceipt.studentInvoice.feesTerm.feesTermName;
												}
						                  
						          datatable.row.add([data1.studentReceiptFineId,admissionNo,studentFirstName+' '+studentLastName,termName, data1.fineAmount]).draw( false );
									      });
								  });
				   },
				   error: function(){
				    // alert('ERROR OCCURED');
				    // window.location.href=ctx+"/report/academicfeesreport";
				   }
			 });
	});
	
	/*$("#btndownloadxml").click(function(event) 
	{
		$("#downloadxml").modal('show');
	});
	
	$("#applyOk").click(function(event) 
	{
					if($("#downloadxmlForm").valid())
					{
						$("#currentAcademicYearValue").val(category1);
						$("#downloadxmlForm").submit();
						
					}
	});*/
});   

function showFineList()
{
	if(document.getElementById('listFineDetails').style.display=="none"){
		document.getElementById('listFineDetails').style.display="block";
		document.getElementById('ListDiv').style.display="none";
		}
}
function showEditFineList()
{
	if(document.getElementById('ListDiv').style.display=="none"){
		document.getElementById('ListDiv').style.display="block";
		document.getElementById('listFineDetails').style.display="none";
		}
}