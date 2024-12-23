var ctx= window.location.pathname.substring(0, window.location.pathname.indexOf("/",2));

$(document).ready(function() {
	var currentdate = new Date(); 
    var datetime = currentdate.getDate() + "-"
                + (currentdate.getMonth()+1)  + "-" 
                + currentdate.getFullYear() + "_"  
                + currentdate.getHours() + "-"  
                + currentdate.getMinutes() + "-" 
                + currentdate.getSeconds();
var exportfilename='PaymentModeWise_Fees_Report_'+datetime;

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
 /*  $( api.column( 3 ).footer() ).html(
       ''+pageTotalPaidAmount +' ('+ totalPaidAmount +' total)'
   );*/
   
   // TotalDiscountAount over all pages
   totalDiscountAmount = api
       .column( 4 , {'search': 'applied'})
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
       .column( 5, {'search': 'applied'} )
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
 /*  $( api.column( 5 ).footer() ).html(
       ''+pageTotalOutStandingAmount +' ('+ totalOutStandingAmount +' total)'
   );*/
   
   $("#feesgrandtotal").html(totalAmount);
   $("#feesgrandpaidamount").html(totalPaidAmount);
   $("#feesgranddiscount").html(totalDiscountAmount);
   $("#feesgrandoutstanding").html(totalOutStandingAmount);
   $("#feespagetotal").html(pageTotalAmount);
   $("#feespagepaidamount").html(pageTotalPaidAmount);
   $("#feespagediscount").html(pageTotalDiscountAmount);
   $("#feespageoutstanding").html(pageTotalOutStandingAmount);

}
});

	/*$.ajax({
		   url:ctx+'/report/allaccountingfeesreportlist',
		   type:'GET',
		   success: function(response){
			   var datatable = $('#ledgerAccountHeadList').DataTable();
			     datatable.clear().draw();
					
				$.each(response, function(key,data)
                        {   
					
			     	datatable.row.add([data.f1,data.f2,data.f3,data.f4,data.f5,data.f6,'<a href="#" id="edit"  type="button"data-href="#" data-id="'+data.f2+'" data-toggle="modal"onclick="showFeesTemplateItemDiv()"><span class="glyphicon glyphicon-credit-card"></span></a>']).draw( false );
					
                        });
		   },
		   error: function(){
		     //alert('ERROR OCCURED');
		     //window.location.href=ctx+"/report/accountingfeesreport";
		   }
		 });*/
	var category="";
	
	
	$("#getList").click(function(event) 
	{
		
		if($("#dateDetailForm").valid())
		{
			$('.loader').show();
			var fromdate=$("#fromDate").val();
			var todate=$("#toDate").val();
			paymentMode=$("#paymentModeId").val();
			$.ajax({
		   url:ctx+'/report/paymentModeWiseStudentReceiptsList',
		   data:{fromDate:fromdate,toDate:todate,paymentMode:paymentMode},
		   type:'GET',
		   success: function(response){
			 // alert(response);
			   $('.loader').hide();
			   var datatable = $('#ledgerAccountHeadList').DataTable();
			     datatable.clear().draw();
			     datatable.column( 0).visible(false);
					
			     datatable.column( 2).visible(false);
		    	 datatable.column( 5 ).visible(false);
			     $.each(response, function(key,data)
	                     {   
						
				     	datatable.row.add([data.f1,data.f2,data.f3,data.f4,data.f5,data.f6]).draw( false );
						
	                     });
			    /* if(category=="specificinvoice")
		    	 {
			    	 datatable.column( 3).visible(false);
			    	 datatable.column( 4 ).visible(false);
			    	 datatable.column( 5 ).visible(false);
			    	 datatable.column( 2 ).visible(true);
			    	 $.each(response, function(key,data)
		                     {   
							
					     	datatable.row.add([data.f1,data.f2,data.f3,data.f4,data.f5,data.f6,'<a href="#" id="edit"  type="button"data-href="#" data-id="'+data.f2+'" data-toggle="modal" onclick="showFeesTemplateItemDiv()"><span class="glyphicon glyphicon-credit-card"></span></a>']).draw( false );
							
		                     });
		    	 
		    	 }else if(category=="specificreceipt")
		    		 {
		    		 datatable.column( 2 ).visible(false);
		    		 datatable.column( 5 ).visible(false);
			    	 datatable.column( 3).visible(true);
			    	 datatable.column( 4 ).visible(true);
			    	 $.each(response, function(key,data)
		                     {   
							
					     	datatable.row.add([data.f1,data.f2,data.f3,data.f4,data.f5,data.f6,'<a href="#" id="edit"  type="button"data-href="#" data-id="'+data.f2+'" data-toggle="modal"onclick="showFeesTemplateItemDiv()"><span class="glyphicon glyphicon-credit-card"></span></a>']).draw( false );
							
		                     });
		    		 }*/
				
		   },
		   error: function(){
			   $('.loader').hide();
		     //alert('ERROR OCCURED');
		     //window.location.href=ctx+"/report/accountingfeesreport";
		   }
		 });
		}
	});
	
	$('#ledgerAccountHeadList').on( 'click', 'tr td a#edit', function () {
		var ledgername = $(this).attr('data-id');
		var fromdate=$("#fromDate").val();
		var todate=$("#toDate").val();
		$('.loader').show();
			$.ajax({
			   url:ctx+'/institution/ledgerAccount/ledgerAccountName',
			   data:{ledgerAccountName:ledgername,category:category,fromDate:fromdate,toDate:todate},
			   type:'GET',
			   success: function(response){
				   $('.loader').hide();
				   var datatable = $('#feesTemplateItemList').DataTable();
				     datatable.clear().draw();
				    
				     if(category=="specificinvoice")
				    	 {
					     datatable.column( 0).visible(false);
							
				    	 datatable.column( 3).visible(false);
				    	 datatable.column( 4 ).visible(false);
				    	 datatable.column( 2 ).visible(true);
				    	 datatable.column( 5 ).visible(false);
				    		 $.each(response, function(key,data)
	                        {   
			   			
			   			datatable.row.add([data.f1,data.f2,data.f3,data.f4,data.f5,data.f6]).draw( false );
	                       
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
				    	 }
				     else if(category=="specificreceipt")
				    	 {  
					     datatable.column( 0).visible(false);
							
				    	 datatable.column( 2 ).visible(false);
				    	 datatable.column( 3).visible(true);
				    	 datatable.column( 4 ).visible(true);
				    	 datatable.column( 5 ).visible(false);
				    	 $.each(response, function(key,data)
			                        {   
					   			
					   			datatable.row.add([data.f1,data.f2,data.f3,data.f4,data.f5,data.f6]).draw( false );
			                       
			                        });
				    	/* $.each(response.feesTemplateItems, function(key,data)
			                        {   
					   			var totalAmount=0;
					   			var totalDiscount=0;
					   			var totalPaidAmount=0;
					   			var totalOutStandingAmount=0;
					   			$.each(data.studentReceiptsItems, function(key2,value2)
				                 {  
					   				totalDiscount=totalDiscount+value2.discountAmount;
					   				totalPaidAmount=totalPaidAmount+value2.paidReceiptAmount;
					   			 });
					   			datatable.row.add([data.templateItemId,data.templateItemName,totalAmount,totalPaidAmount,totalDiscount,totalOutStandingAmount]).draw( false );
			                       
	                        });*/
				    	 }
				     else{
					     datatable.column( 0).visible(false);
							
				    	 datatable.column( 3).visible(true);
				    	 datatable.column( 4 ).visible(true);
				    	 datatable.column( 2 ).visible(true);
				    	 datatable.column( 5 ).visible(true);
				    	
				    	 $.each(response, function(key,data)
			                        {   
					   			
					   			datatable.row.add([data.f1,data.f2,data.f3,data.f4,data.f5,data.f6]).draw( false );
			                       
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
					   			$.each(data.studentReceiptsItems, function(key2,value2)
						                 {  
							   				totalDiscount=totalDiscount+value2.discountAmount;
							   				totalPaidAmount=totalPaidAmount+value2.paidReceiptAmount;
							   			 });
					   			var	temp=totalDiscount+totalPaidAmount;
					   			totalOutStandingAmount=totalAmount-temp;
					   			datatable.row.add([data.templateItemId,data.templateItemName,totalAmount,totalPaidAmount,totalDiscount,totalOutStandingAmount]).draw( false );
			                       
	                        });*/
				     }
				 
			   },
			   error: function(){
				   $('.loader').hide();
			    // alert('ERROR OCCURED');
			     window.location.href=ctx+"/report/paymentmodewisefeesreport";
			   }
			 });
	});


	
});   
