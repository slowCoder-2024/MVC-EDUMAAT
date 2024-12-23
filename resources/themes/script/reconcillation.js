$(document).ready(function(){
	var ctx= window.location.pathname.substring(0, window.location.pathname.indexOf("/",2));
	
	
	var currentdate = new Date(); 
    var datetime = currentdate.getDate() + "-"
                + (currentdate.getMonth()+1)  + "-" 
                + currentdate.getFullYear() + "_"  
                + currentdate.getHours() + "-"  
                + currentdate.getMinutes() + "-" 
                + currentdate.getSeconds();
var exportfilename='Reconcillation_Report'+datetime;

var currecyCode="";
if($("#currecyCodeData").text()!=null)
	{
	currecyCode=$("#currecyCodeData").val();
	}
	 $('#cashReconPending').DataTable({
		 "searching":true,
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
	   
	     // Fee Amount over all pages
	     totalFeeAmount = api
	         .column( 6 , {'search': 'applied'})
	         .data()
	         .reduce( function (a, b) {
	             return intVal(a) + intVal(b);
	         }, 0 );

	     // Fee Amount over this page
	     pageTotalFeeAmount = api
	         .column( 6, { page: 'current'} )
	         .data()
	         .reduce( function (a, b) {
	             return intVal(a) + intVal(b);
	         }, 0 );

	     // Update footer
	    /* $( api.column( 6 ).footer() ).html(
	         ''+pageTotalFeeAmount +' ('+ totalFeeAmount +' total)'
	     );*/
	    
	     // TotalFineAmount over all pages
	     totalFineAmount = api
	         .column( 7 , {'search': 'applied'})
	         .data()
	         .reduce( function (a, b) {
	             return intVal(a) + intVal(b);
	         }, 0 );

	     // TotalPaidAmount over this page
	     pageTotalFineAmount = api
	         .column( 7, { page: 'current'} )
	         .data()
	         .reduce( function (a, b) {
	             return intVal(a) + intVal(b);
	         }, 0 );

	     // Update footer
	    /* $( api.column( 7 ).footer() ).html(
	         ''+pageTotalFineAmount +' ('+ totalFineAmount +' total)'
	     );*/
	     // TotalAount over all pages
	     totalAmount = api
	         .column( 8 , {'search': 'applied'})
	         .data()
	         .reduce( function (a, b) {
	             return intVal(a) + intVal(b);
	         }, 0 );

	     // TotalAmount over this page
	     pageTotalAmount = api
	         .column( 8, { page: 'current'} )
	         .data()
	         .reduce( function (a, b) {
	             return intVal(a) + intVal(b);
	         }, 0 );

	     // Update footer
	   /*  $( api.column( 8 ).footer() ).html(
	         ''+pageTotalAmount +' ('+ totalAmount +' total)'
	     );*/
	     $("#cashpendinggrandfeestotal").html(totalFeeAmount);
	     $("#cashpendinggrandfineamount").html(totalFineAmount);
	     $("#cashpendinggrandtotal").html(totalAmount);
	     $("#cashpendingpagefeestotal").html(pageTotalFeeAmount);
	     $("#cashpendingpagefineamount").html(pageTotalFineAmount);
	     $("#cashpendingpagetotal").html(pageTotalAmount);
 }
	 });
	 
	 
	 $('#cashReconCleared').DataTable({
		 "searching":true,
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
	   
	     // Fee Amount over all pages
	     totalFeeAmount = api
	         .column( 5 , {'search': 'applied'})
	         .data()
	         .reduce( function (a, b) {
	             return intVal(a) + intVal(b);
	         }, 0 );

	     // Fee Amount over this page
	     pageTotalFeeAmount = api
	         .column( 5, { page: 'current'} )
	         .data()
	         .reduce( function (a, b) {
	             return intVal(a) + intVal(b);
	         }, 0 );

	     // Update footer
	   /*  $( api.column( 5 ).footer() ).html(
	         ''+pageTotalFeeAmount +' ('+ totalFeeAmount +' total)'
	     );*/
	    
	     // TotalFineAmount over all pages
	     totalFineAmount = api
	         .column( 6 , {'search': 'applied'})
	         .data()
	         .reduce( function (a, b) {
	             return intVal(a) + intVal(b);
	         }, 0 );

	     // TotalPaidAmount over this page
	     pageTotalFineAmount = api
	         .column( 6, { page: 'current'} )
	         .data()
	         .reduce( function (a, b) {
	             return intVal(a) + intVal(b);
	         }, 0 );

	     // Update footer
	    /* $( api.column( 6 ).footer() ).html(
	         ''+pageTotalFineAmount +' ('+ totalFineAmount +' total)'
	     );*/
	     // TotalAount over all pages
	     totalAmount = api
	         .column( 7 , {'search': 'applied'})
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
	   /*  $( api.column( 7 ).footer() ).html(
	         ''+pageTotalAmount +' ('+ totalAmount +' total)'
	     );*/
	     $("#cashclearedgrandfeestotal").html(totalFeeAmount);
	     $("#cashclearedgrandfineamount").html(totalFineAmount);
	     $("#cashclearedgrandtotal").html(totalAmount);
	     $("#cashclearedpagefeestotal").html(pageTotalFeeAmount);
	     $("#cashclearedpagefineamount").html(pageTotalFineAmount);
	     $("#cashclearedpagetotal").html(pageTotalAmount);
	 }
	 });
	 
	 $('#chequeReconPending').DataTable({
		 "searching":true,
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
	   
	     // Fee Amount over all pages
	     totalFeeAmount = api
	         .column( 8 , {'search': 'applied'})
	         .data()
	         .reduce( function (a, b) {
	             return intVal(a) + intVal(b);
	         }, 0 );

	     // Fee Amount over this page
	     pageTotalFeeAmount = api
	         .column( 8, { page: 'current'} )
	         .data()
	         .reduce( function (a, b) {
	             return intVal(a) + intVal(b);
	         }, 0 );

	     // Update footer
	   /*  $( api.column( 8 ).footer() ).html(
	         ''+pageTotalFeeAmount +' ('+ totalFeeAmount +' total)'
	     );*/
	    
	     // TotalFineAmount over all pages
	     totalFineAmount = api
	         .column( 9 , {'search': 'applied'})
	         .data()
	         .reduce( function (a, b) {
	             return intVal(a) + intVal(b);
	         }, 0 );

	     // TotalPaidAmount over this page
	     pageTotalFineAmount = api
	         .column( 9, { page: 'current'} )
	         .data()
	         .reduce( function (a, b) {
	             return intVal(a) + intVal(b);
	         }, 0 );

	     // Update footer
	   /*  $( api.column( 9 ).footer() ).html(
	         ''+pageTotalFineAmount +' ('+ totalFineAmount +' total)'
	     );*/
	     // TotalAount over all pages
	     totalAmount = api
	         .column( 10 , {'search': 'applied'})
	         .data()
	         .reduce( function (a, b) {
	             return intVal(a) + intVal(b);
	         }, 0 );

	     // TotalAmount over this page
	     pageTotalAmount = api
	         .column( 10, { page: 'current'} )
	         .data()
	         .reduce( function (a, b) {
	             return intVal(a) + intVal(b);
	         }, 0 );

	     // Update footer
	    /* $( api.column( 10 ).footer() ).html(
	         ''+pageTotalAmount +' ('+ totalAmount +' total)'
	     );*/
	     $("#chequependinggrandfeestotal").html(totalFeeAmount);
	     $("#chequependinggrandfineamount").html(totalFineAmount);
	     $("#chequependinggrandtotal").html(totalAmount);
	     $("#chequependingpagefeestotal").html(pageTotalFeeAmount);
	     $("#chequependingpagefineamount").html(pageTotalFineAmount);
	     $("#chequependingpagetotal").html(pageTotalAmount);
	 }
	 });
	 
	 $('#chequeReconCleared').DataTable({
		 "searching":true,
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
	   
	     // Fee Amount over all pages
	     totalFeeAmount = api
	         .column( 7 , {'search': 'applied'})
	         .data()
	         .reduce( function (a, b) {
	             return intVal(a) + intVal(b);
	         }, 0 );

	     // Fee Amount over this page
	     pageTotalFeeAmount = api
	         .column( 7, { page: 'current'} )
	         .data()
	         .reduce( function (a, b) {
	             return intVal(a) + intVal(b);
	         }, 0 );

	     // Update footer
	    /* $( api.column( 7 ).footer() ).html(
	         ''+pageTotalFeeAmount +' ('+ totalFeeAmount +' total)'
	     );*/
	    
	     // TotalFineAmount over all pages
	     totalFineAmount = api
	         .column( 8 , {'search': 'applied'})
	         .data()
	         .reduce( function (a, b) {
	             return intVal(a) + intVal(b);
	         }, 0 );

	     // TotalPaidAmount over this page
	     pageTotalFineAmount = api
	         .column( 8, { page: 'current'} )
	         .data()
	         .reduce( function (a, b) {
	             return intVal(a) + intVal(b);
	         }, 0 );

	     // Update footer
	    /* $( api.column( 8 ).footer() ).html(
	         ''+pageTotalFineAmount +' ('+ totalFineAmount +' total)'
	     );*/
	     // TotalAount over all pages
	     totalAmount = api
	         .column( 9 , {'search': 'applied'})
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
	    /* $( api.column( 9 ).footer() ).html(
	         ''+pageTotalAmount +' ('+ totalAmount +' total)'
	     );*/
	     $("#chequeclearedgrandfeestotal").html(totalFeeAmount);
	     $("#chequeclearedgrandfineamount").html(totalFineAmount);
	     $("#chequeclearedgrandtotal").html(totalAmount);
	     $("#chequeclearedpagefeestotal").html(pageTotalFeeAmount);
	     $("#chequeclearedpagefineamount").html(pageTotalFineAmount);
	     $("#chequeclearedpagetotal").html(pageTotalAmount);
	 }
	 });
	 
	 $('#chequeReconBounced').DataTable({
		 "searching":true,
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
	   
	     // Fee Amount over all pages
	     totalFeeAmount = api
	         .column( 6, {'search': 'applied'} )
	         .data()
	         .reduce( function (a, b) {
	             return intVal(a) + intVal(b);
	         }, 0 );

	     // Fee Amount over this page
	     pageTotalFeeAmount = api
	         .column( 6, { page: 'current'} )
	         .data()
	         .reduce( function (a, b) {
	             return intVal(a) + intVal(b);
	         }, 0 );

	     // Update footer
	    /* $( api.column( 6 ).footer() ).html(
	         ''+pageTotalFeeAmount +' ('+ totalFeeAmount +' total)'
	     );*/
	    
	     // TotalFineAmount over all pages
	     totalFineAmount = api
	         .column( 7, {'search': 'applied'} )
	         .data()
	         .reduce( function (a, b) {
	             return intVal(a) + intVal(b);
	         }, 0 );

	     // TotalPaidAmount over this page
	     pageTotalFineAmount = api
	         .column( 7, { page: 'current'} )
	         .data()
	         .reduce( function (a, b) {
	             return intVal(a) + intVal(b);
	         }, 0 );

	     // Update footer
	     /*$( api.column( 7 ).footer() ).html(
	         ''+pageTotalFineAmount +' ('+ totalFineAmount +' total)'
	     );*/
	     // TotalAount over all pages
	     totalAmount = api
	         .column( 8 , {'search': 'applied'})
	         .data()
	         .reduce( function (a, b) {
	             return intVal(a) + intVal(b);
	         }, 0 );

	     // TotalAmount over this page
	     pageTotalAmount = api
	         .column( 8, { page: 'current'} )
	         .data()
	         .reduce( function (a, b) {
	             return intVal(a) + intVal(b);
	         }, 0 );

	     // Update footer
	   /*  $( api.column( 8 ).footer() ).html(
	         ''+pageTotalAmount +' ('+ totalAmount +' total)'
	     );*/
	     $("#chequebouncedgrandfeestotal").html(totalFeeAmount);
	     $("#chequebouncedgrandfineamount").html(totalFineAmount);
	     $("#chequebouncedgrandtotal").html(totalAmount);
	     $("#chequebouncedpagefeestotal").html(pageTotalFeeAmount);
	     $("#chequebouncedpagefineamount").html(pageTotalFineAmount);
	     $("#chequebouncedpagetotal").html(pageTotalAmount);

	 }
	 });
	 
	 $('#ddReconPending').DataTable({
		 "searching":true,
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
	   
	     // Fee Amount over all pages
	     totalFeeAmount = api
	         .column( 8 , {'search': 'applied'})
	         .data()
	         .reduce( function (a, b) {
	             return intVal(a) + intVal(b);
	         }, 0 );

	     // Fee Amount over this page
	     pageTotalFeeAmount = api
	         .column( 8, { page: 'current'} )
	         .data()
	         .reduce( function (a, b) {
	             return intVal(a) + intVal(b);
	         }, 0 );

	     // Update footer
	    /* $( api.column( 8 ).footer() ).html(
	         ''+pageTotalFeeAmount +' ('+ totalFeeAmount +' total)'
	     );*/
	    
	     // TotalFineAmount over all pages
	     totalFineAmount = api
	         .column( 9 , {'search': 'applied'})
	         .data()
	         .reduce( function (a, b) {
	             return intVal(a) + intVal(b);
	         }, 0 );

	     // TotalPaidAmount over this page
	     pageTotalFineAmount = api
	         .column( 9, { page: 'current'} )
	         .data()
	         .reduce( function (a, b) {
	             return intVal(a) + intVal(b);
	         }, 0 );

	     // Update footer
	    /* $( api.column( 9 ).footer() ).html(
	         ''+pageTotalFineAmount +' ('+ totalFineAmount +' total)'
	     );*/
	     // TotalAount over all pages
	     totalAmount = api
	         .column( 10 , {'search': 'applied'})
	         .data()
	         .reduce( function (a, b) {
	             return intVal(a) + intVal(b);
	         }, 0 );

	     // TotalAmount over this page
	     pageTotalAmount = api
	         .column( 10, { page: 'current'} )
	         .data()
	         .reduce( function (a, b) {
	             return intVal(a) + intVal(b);
	         }, 0 );

	     // Update footer
	   /*  $( api.column( 10 ).footer() ).html(
	         ''+pageTotalAmount +' ('+ totalAmount +' total)'
	     );*/
	     $("#ddpendinggrandfeestotal").html(totalFeeAmount);
	     $("#ddpendinggrandfineamount").html(totalFineAmount);
	     $("#ddpendinggrandtotal").html(totalAmount);
	     $("#ddpendingpagefeestotal").html(pageTotalFeeAmount);
	     $("#ddpendingpagefineamount").html(pageTotalFineAmount);
	     $("#ddpendingpagetotal").html(pageTotalAmount);
	 }
	 });
	 
	 $('#ddReconCleared').DataTable({
		 "searching":true,
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
	   
	     // Fee Amount over all pages
	     totalFeeAmount = api
	         .column( 8 , {'search': 'applied'})
	         .data()
	         .reduce( function (a, b) {
	             return intVal(a) + intVal(b);
	         }, 0 );

	     // Fee Amount over this page
	     pageTotalFeeAmount = api
	         .column( 8, { page: 'current'} )
	         .data()
	         .reduce( function (a, b) {
	             return intVal(a) + intVal(b);
	         }, 0 );

	     // Update footer
	   /*  $( api.column( 8 ).footer() ).html(
	         ''+pageTotalFeeAmount +' ('+ totalFeeAmount +' total)'
	     );
	    */
	     // TotalFineAmount over all pages
	     totalFineAmount = api
	         .column( 9, {'search': 'applied'} )
	         .data()
	         .reduce( function (a, b) {
	             return intVal(a) + intVal(b);
	         }, 0 );

	     // TotalPaidAmount over this page
	     pageTotalFineAmount = api
	         .column( 9, { page: 'current'} )
	         .data()
	         .reduce( function (a, b) {
	             return intVal(a) + intVal(b);
	         }, 0 );

	     // Update footer
	    /* $( api.column( 9 ).footer() ).html(
	         ''+pageTotalFineAmount +' ('+ totalFineAmount +' total)'
	     );*/
	     // TotalAount over all pages
	     totalAmount = api
	         .column( 10, {'search': 'applied'} )
	         .data()
	         .reduce( function (a, b) {
	             return intVal(a) + intVal(b);
	         }, 0 );

	     // TotalAmount over this page
	     pageTotalAmount = api
	         .column( 10, { page: 'current'} )
	         .data()
	         .reduce( function (a, b) {
	             return intVal(a) + intVal(b);
	         }, 0 );

	     // Update footer
	   /*  $( api.column( 10 ).footer() ).html(
	         ''+pageTotalAmount +' ('+ totalAmount +' total)'
	     );*/
	     $("#ddclearedgrandfeestotal").html(totalFeeAmount);
	     $("#ddclearedgrandfineamount").html(totalFineAmount);
	     $("#ddclearedgrandtotal").html(totalAmount);
	     $("#ddclearedpagefeestotal").html(pageTotalFeeAmount);
	     $("#ddclearedpagefineamount").html(pageTotalFineAmount);
	     $("#ddclearedpagetotal").html(pageTotalAmount);
	 }
	 });
	 
	 $('#ddReconBounced').DataTable({
		 "searching":true,
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
	   
	     // Fee Amount over all pages
	     totalFeeAmount = api
	         .column( 7 )
	         .data()
	         .reduce( function (a, b) {
	             return intVal(a) + intVal(b);
	         }, 0 );

	     // Fee Amount over this page
	     pageTotalFeeAmount = api
	         .column( 7, { page: 'current'} )
	         .data()
	         .reduce( function (a, b) {
	             return intVal(a) + intVal(b);
	         }, 0 );

	     // Update footer
	   /*  $( api.column( 7 ).footer() ).html(
	         ''+pageTotalFeeAmount +' ('+ totalFeeAmount +' total)'
	     );*/
	    
	     // TotalFineAmount over all pages
	     totalFineAmount = api
	         .column( 8 )
	         .data()
	         .reduce( function (a, b) {
	             return intVal(a) + intVal(b);
	         }, 0 );

	     // TotalPaidAmount over this page
	     pageTotalFineAmount = api
	         .column( 8, { page: 'current'} )
	         .data()
	         .reduce( function (a, b) {
	             return intVal(a) + intVal(b);
	         }, 0 );

	     // Update footer
	   /*  $( api.column( 8 ).footer() ).html(
	         ''+pageTotalFineAmount +' ('+ totalFineAmount +' total)'
	     );*/
	     // TotalAount over all pages
	     totalAmount = api
	         .column( 9 )
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
	   /*  $( api.column( 9 ).footer() ).html(
	         ''+pageTotalAmount +' ('+ totalAmount +' total)'
	     );*/
	     $("#ddbouncedgrandfeestotal").html(totalFeeAmount);
	     $("#ddbouncedgrandfineamount").html(totalFineAmount);
	     $("#ddbouncedgrandtotal").html(totalAmount);
	     $("#ddbouncedpagefeestotal").html(pageTotalFeeAmount);
	     $("#ddbouncedpagefineamount").html(pageTotalFineAmount);
	     $("#ddbouncedpagetotal").html(pageTotalAmount);
	 }
	 });
	 
	 
	//paymentStatus Of PaymentMode
	 $("#paymentModeId").change(function() {
		var paymentModeId=$(this).val();
		 $.ajax({
			   url:ctx+'/payment/paymentmode/status',
			   data:{paymentModeId:paymentModeId},
			   type:'GET',
			   success: function(response){
				   var select = $('#paymentStatusId');
				   if(response.length>0)
		        	  {
		        		  select.find('option').remove(); 
		        		  $('#paymentStatusId').selectpicker('destroy');
		        	  }
		        	  else
		        	  { 
		        		  select.find('option').remove();
		        		  $('#paymentStatusId').selectpicker('destroy');
		        		  select.append('<option value="" disabled selected>Select Payment Status</option>');
		        	  }
	        	    $.each(response, function(key,value) {
	            		 if(key==0){
	   	        	    		select.append('<option value="" disabled selected>Select Payment Status</option>');
	   	        	    	}
	            		 $('<option>').val(value.paymentStatusId).text(value.paymentStatusTitle).appendTo(select);
	            	  }); 
	        	    $('#paymentStatusId').selectpicker('show');
			 },
			   error: function(){
			     alert('ERROR OCCURED');
			     window.location.href=ctx+"/receipt/reconcillation";
			   }
			 });
     });
	 
	 var datatable1,datatable2,datatable3,datatable4,datatable5,datatable6,datatable7,datatable8;
	 
	 $("#getReceiptsRecords").click(function(event) {
		$('#reconcillationCriteriaForm').validate({
			 submitHandler: function(form) {
				var paymentModeId= $("#paymentModeId").val();
				var paymentStatusId= $("#paymentStatusId").val();
				 $.ajax(	
				    {
				        type: "GET",
				        url:ctx+'/receipt/byPaymentModeAndStatus' ,
				        data:{paymentModeId:paymentModeId,paymentStatusId:paymentStatusId},
				        contentType: "application/json; charset=utf-8",
				        dataType: "json",
				        cache: false,
				        success: function (response) {
				        	$("#receiptdetailsdiv").hide();
				        	$("#chequeReconPendingTable").hide();
			        		$("#ddReconPendingTable").hide();
			        		$("#paymentGatewayReconPendingTable").hide();
			        		$("#cashReconPendingTable").hide();
				        	if(response.length!=0){
				        		/* $(".form-horizontal").trigger('reset'); */
				        		datatable1 = $('#cashReconPending').DataTable();
				        		datatable2 = $('#cashReconCleared').DataTable();
				        		datatable3 = $('#chequeReconPending').DataTable();
				        		datatable4 = $('#chequeReconCleared').DataTable();
				        		datatable5 = $('#chequeReconBounced').DataTable();
				        		datatable6 = $('#ddReconPending').DataTable();
				        		datatable7 = $('#ddReconCleared').DataTable();
				        		datatable8 = $('#ddReconBounced').DataTable();
				        		
				        		datatable1.clear().draw();
				        		datatable2.clear().draw();
				        		datatable3.clear().draw();
				        		datatable4.clear().draw();
				        		datatable5.clear().draw();
				        		datatable6.clear().draw();
				        		datatable7.clear().draw();
				        		datatable8.clear().draw();
				        		$.each(response, function (i, data) {
				        			var fineAmount=0.0;
				        			var feesAmount=0.0;
				        			var totalAmount=0.0;
				        			 $.each(data.receiptFines, function (m, fineReceipt) {
				        					fineAmount=fineAmount+fineReceipt.fineAmount;
				        			 });
				        			 
				        			 feesAmount=data.amount;
									 totalAmount=feesAmount+fineAmount;
								
				        			if(data.paymentMode.paymentModeId==1){
				        				
					        			$("#receiptdetailsdiv").show();
					        			if(data.paymentStatus.paymentStatusId==1){
					        				$("#cashReconPendingTable").show();
					        				$("#cashReconClearedTable").hide();
					        				$("#chequeReconPendingTable").hide();
					        				$("#chequeReconClearedTable").hide();
					        				$("#chequeReconBouncedTable").hide();
					        				$("#ddReconPendingTable").hide();
					        				$("#ddReconClearedTable").hide();
					        				$("#ddReconBouncedTable").hide();
						        								var name;
																if(data.student.lastName!=null){
																	name=data.student.firstName+' '+data.student.lastName;
																}else{
																	name=data.student.firstName;
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
																	
															 datatable1.row.add(['<div class="checkbox checkbox-pink"><input type="checkbox" unchecked value='+data.receiptId+' name="receiptId" class="case"></input><label for='+data.receiptId+'></label></div>',data.transactionNo,name,data.student.admissionNo,$.date(data.paymentReceivedDate),data.createdBy,feesAmount,fineAmount,totalAmount]).draw( false );
														    
					        			}
					        			if(data.paymentStatus.paymentStatusId==2){
					        				$("#cashReconClearedTable").show();
					        				$("#cashReconPendingTable").hide();
					        				$("#chequeReconPendingTable").hide();
					        				$("#chequeReconClearedTable").hide();
					        				$("#chequeReconBouncedTable").hide();
					        				$("#ddReconPendingTable").hide();
					        				$("#ddReconClearedTable").hide();
					        				$("#ddReconBouncedTable").hide();
						        								var name;
																if(data.student.lastName!=null){
																	name=data.student.firstName+' '+data.student.lastName;
																}else{
																	name=data.student.firstName;
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
															  datatable2.row.add([data.transactionNo,name,data.student.admissionNo,$.date(data.paymentClearedDate),data.receiptClearedBy,feesAmount,fineAmount,totalAmount]).draw( false );
														   
					        			}
						        	}
						        	else if(data.paymentMode.paymentModeId==2){
						        		$("#receiptdetailsdiv").show();
						        		if(data.paymentStatus.paymentStatusId==1){
						        		$("#chequeReconPendingTable").show();
						        			$("#cashReconClearedTable").hide();
					        				$("#cashReconPendingTable").hide();
					        				$("#chequeReconClearedTable").hide();
					        				$("#chequeReconBouncedTable").hide();
					        				$("#ddReconPendingTable").hide();
					        				$("#ddReconClearedTable").hide();
					        				$("#ddReconBouncedTable").hide();
						        							var name="";
															if(data.student.lastName && data.student.lastName!=null){
																name=data.student.firstName+' '+data.student.lastName;
															}else{
																name=data.student.firstName;
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
														  datatable3.row.add(['<div class="checkbox checkbox-pink"><input type="checkbox" unchecked value='+data.receiptId+' name="chequereceiptId" class="case"></input><label for='+data.receiptId+'></label></div>',name,data.student.admissionNo,data.chequeNumber,$.date(data.paymentReceivedDate),data.chequeBankName,data.chequeBranchName,data.createdBy,feesAmount,fineAmount,totalAmount]).draw( false );
													   
					        			}
						        		if(data.paymentStatus.paymentStatusId==2){
					        				$("#chequeReconClearedTable").show();
					        				$("#chequeReconPendingTable").hide();
						        			$("#cashReconClearedTable").hide();
					        				$("#cashReconPendingTable").hide();
					        				$("#chequeReconBouncedTable").hide();
					        				$("#ddReconPendingTable").hide();
					        				$("#ddReconClearedTable").hide();
					        				$("#ddReconBouncedTable").hide();
					        				
						        								var name;
																if(data.student.lastName!=null){
																	name=data.student.firstName+' '+data.student.lastName;
																}else{
																	name=data.student.firstName;
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
															  datatable4.row.add([name,data.student.admissionNo,data.chequeNumber,$.date(data.paymentClearedDate),data.chequeBankName,data.chequeBranchName,data.receiptClearedBy,feesAmount,fineAmount,totalAmount]).draw( false );
														   
					        			}
						        		if(data.paymentStatus.paymentStatusId==3){
					        				$("#chequeReconBouncedTable").show();
					        				$("#chequeReconClearedTable").hide();
					        				$("#chequeReconPendingTable").hide();
						        			$("#cashReconClearedTable").hide();
					        				$("#cashReconPendingTable").hide();
					        				$("#ddReconPendingTable").hide();
					        				$("#ddReconClearedTable").hide();
					        				$("#ddReconBouncedTable").hide();
					        				
						        							var name;
																if(data.student.lastName!=null){
																	name=data.student.firstName+' '+data.student.lastName;
																}else{
																	name=data.student.firstName;
																}
															  datatable5.row.add([name,data.student.admissionNo,data.chequeNumber,data.chequeBankName,data.chequeBranchName,data.receiptClearedBy,feesAmount,fineAmount,totalAmount]).draw( false );
														    
					        			}
						        	}
						        	else if(data.paymentMode.paymentModeId==3){
						        		$("#receiptdetailsdiv").show();
						        		if(data.paymentStatus.paymentStatusId==1){
						        			$("#ddReconPendingTable").show();
						        			$("#chequeReconBouncedTable").hide();
					        				$("#chequeReconClearedTable").hide();
					        				$("#chequeReconPendingTable").hide();
						        			$("#cashReconClearedTable").hide();
					        				$("#cashReconPendingTable").hide();
					        				$("#ddReconClearedTable").hide();
					        				$("#ddReconBouncedTable").hide();
						        						
															var name;
															if(data.student.lastName!=null){
																name=data.student.firstName+' '+data.student.lastName;
															}else{
																name=data.student.firstName;
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
														  datatable6.row.add(['<div class="checkbox checkbox-pink"><input type="checkbox" unchecked value='+data.receiptId+' name="chequereceiptId" class="case"></input><label for='+data.receiptId+'></label></div>',name,data.student.admissionNo,data.ddNumber,$.date(data.paymentReceivedDate),data.ddBankName,data.ddBranchName,data.createdBy,feesAmount,fineAmount,totalAmount]).draw( false );
													   
					        			}
						        		if(data.paymentStatus.paymentStatusId==2){
						        			$("#ddReconClearedTable").show();
						        			$("#ddReconPendingTable").hide();
						        			$("#chequeReconBouncedTable").hide();
					        				$("#chequeReconClearedTable").hide();
					        				$("#chequeReconPendingTable").hide();
						        			$("#cashReconClearedTable").hide();
					        				$("#cashReconPendingTable").hide();
					        				$("#ddReconBouncedTable").hide();
						        							var name;
															if(data.student.lastName!=null){
																name=data.student.firstName+' '+data.student.lastName;
															}else{
																name=data.student.firstName;
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
														  datatable7.row.add([data.receiptId,name,data.student.admissionNo,data.ddNumber,$.date(data.paymentClearedDate),data.ddBankName,data.ddBranchName,data.receiptClearedBy,feesAmount,fineAmount,totalAmount]).draw( false );
													    
					        			}
						        		if(data.paymentStatus.paymentStatusId==3){
						        			$("#ddReconBouncedTable").show();
						        			$("#ddReconClearedTable").hide();
						        			$("#ddReconPendingTable").hide();
						        			$("#chequeReconBouncedTable").hide();
					        				$("#chequeReconClearedTable").hide();
					        				$("#chequeReconPendingTable").hide();
						        			$("#cashReconClearedTable").hide();
					        				$("#cashReconPendingTable").hide();
					        				
					        								var name;
															if(data.student.lastName!=null){
																name=data.student.firstName+' '+data.student.lastName;
															}else{
																name=data.student.firstName;
															}
														  datatable8.row.add([data.receiptId,name,data.student.admissionNo,data.ddNumber,data.ddBankName,data.ddBranchName,data.receiptClearedBy,feesAmount,fineAmount,totalAmount]).draw( false );
													    
					        			}
						        	}
						        	else{
						        		alert("Invalid Mode");
						        	}
					        	});
				        	}
				        	else{
				        		edumaatAlert({
			  			    		 title:"Message !",
			  			    		 text:"No Receipts Found In This Status",
			  			    		 type:"error",
			  			    	}).then(function(){
				    				window.location.href=ctx+"/receipt/reconcillation";
					        	});
				        	}
				        }
				      
				    });
			 return false;   
		   }
			  
	  });
	});
	 
	 //logic to select all receipt in cash recon
	  $('#example-select-all-cash-recon').on('click', function(){
	      // Check/uncheck all checkboxes in the table
	      var rows = datatable1.rows({ 'search': 'applied' }).nodes();
	      $('input[type="checkbox"]', rows).prop('checked', this.checked);
	   });
	
	  $('#example-select-all-cheque-recon').on('click', function(){
	      // Check/uncheck all checkboxes in the table
	      var rows = datatable3.rows({ 'search': 'applied' }).nodes();
	      $('input[type="checkbox"]', rows).prop('checked', this.checked);
	   });
	  
	  $('#example-select-all-dd-recon').on('click', function(){
	      // Check/uncheck all checkboxes in the table
	      var rows = datatable6.rows({ 'search': 'applied' }).nodes();
	      $('input[type="checkbox"]', rows).prop('checked', this.checked);
	   });
	  
	 
	 $('#cashReconReceiptId').on('click', function(){
		 var paymentModeId=1;
		 var rowcollection=datatable1.$(".case:checked", {"page": "all"});
		 
		 if(rowcollection.length>0){
			 rowcollection.each(function(index,elem){
				$("#updateCashReconForm").append(
		    		    $('<input>', {
		    		        type: 'hidden',
		    		        val: $(elem).val(),
		    		        name: 'cashReconReceiptId'
		    		    })
	    		    );
			});
			 
			 $.ajax({
				   url:ctx+'/payment/paymentmode/status',
				   data:{paymentModeId:paymentModeId},
				   type:'GET',
				   async:false,
				   success: function(response){
					   var select = $('#cashReconPaymentStatusId');
					   if(response.length>0)
			        	  {
			        		  select.find('option').remove(); 
			        		  $('#cashReconPaymentStatusId').selectpicker('destroy');
			        	  }
			        	  else
			        	  { 
			        		  select.find('option').remove();
			        		  $('#cashReconPaymentStatusId').selectpicker('destroy');
			        		  select.append('<option value="" disabled selected>Select Payment Status</option>');
			        	  }
		        	   $.each(response, function(key,value) {
		            		 if(key==0){
		   	        	    		select.append('<option value="" disabled selected>Select Payment Status</option>');
		   	        	    	}
		            		 $('<option>').val(value.paymentStatusId).text(value.paymentStatusTitle).appendTo(select);
		            	  }); 
		        	   $('#cashReconPaymentStatusId').selectpicker('show');
				 },
				   error: function(){
				     alert('ERROR OCCURED');
				     window.location.href=ctx+"/home";
				   }
				 });
			 	
			 	$("#cash_recon_update_status").modal('show');
		 }
		 else{
			 edumaatAlert({
		    		 title:"Error !",
		    		 text:"Please Select Atleast One Receipt",
		    		 type:"error",
		    	});
		 }
		
		
			 $("#updateCashRecon").click(function(){
				 if( $("#updateCashReconForm").valid())
					{
					 $("#updateCashReconForm").submit();
					}
			 });
		 
		});
	 
	
	 
	 $('#chequeReconReceipt').on('click', function(){
		 var paymentModeId=2;
		 
		var rowcollection=datatable3.$(".case:checked", {"page": "all"});
		 
		 if(rowcollection.length>0){
			 rowcollection.each(function(index,elem){
				$("#updateChequeReconForm").append(
		    		    $('<input>', {
		    		        type: 'hidden',
		    		        val: $(elem).val(),
		    		        name: 'chequeReconReceiptId'
		    		    })
	    		    );
			});
		 
			 
		 $.ajax({
			   url:ctx+'/payment/paymentmode/status',
			   data:{paymentModeId:paymentModeId},
			   type:'GET',
			   success: function(response){
				   var select = $('#chequeReconPaymentStatusId');
				   if(response.length>0)
		        	  {
		        		  select.find('option').remove(); 
		        		  $('#chequeReconPaymentStatusId').selectpicker('destroy');
		        	  }
		        	  else
		        	  { 
		        		  select.find('option').remove();
		        		  $('#chequeReconPaymentStatusId').selectpicker('destroy');
		        		  select.append('<option value="" disabled selected>Select Payment Status</option>');
		        	  }
	        	   $.each(response, function(key,value) {
	            		 if(key==0){
	   	        	    		select.append('<option value="" disabled selected>Select Payment Status</option>');
	   	        	    	}
	            		 $('<option>').val(value.paymentStatusId).text(value.paymentStatusTitle).appendTo(select);
	            	  }); 
	        	   $('#chequeReconPaymentStatusId').selectpicker('show');
			 },
			   error: function(){
			     alert('ERROR OCCURED');
			     window.location.href=ctx+"/home";
			   }
			 });
		 
		  $("#cheque_recon_update_status").modal('show');
		 }
		 else{
			 edumaatAlert({
		    		 title:"Error !",
		    		 text:"Please Select Atleast One Receipt",
		    		 type:"error",
		    	});
		 }
		  
			 $("#updateChequeRecon").click(function(){
				 if( $("#updateChequeReconForm").valid())
					{
					  $("#updateChequeReconForm").submit();
					}
			 });
		 
		});
	 
	 
	 
	 $('#ddReconReceiptButton').on('click', function(){
		 var paymentModeId=3;
		 var rowcollection=datatable6.$(".case:checked", {"page": "all"});
		 
		 if(rowcollection.length>0){
			 rowcollection.each(function(index,elem){
				$("#updateDdReconForm").append(
		    		    $('<input>', {
		    		        type: 'hidden',
		    		        val: $(elem).val(),
		    		        name: 'ddReconReceiptId'
		    		    })
	    		    );
			});
			 
		 $.ajax({
			   url:ctx+'/payment/paymentmode/status',
			   data:{paymentModeId:paymentModeId},
			   type:'GET',
			   success: function(response){
				   var select = $('#ddReconPaymentStatusId');
				   if(response.length>0)
		        	  {
		        		  select.find('option').remove(); 
		        		  $('#ddReconPaymentStatusId').selectpicker('destroy');
		        	  }
		        	  else
		        	  { 
		        		  select.find('option').remove();
		        		  $('#ddReconPaymentStatusId').selectpicker('destroy');
		        		  select.append('<option value="" disabled selected>Select Payment Status</option>');
		        	  }
	        	   $.each(response, function(key,value) {
	            		 if(key==0){
	   	        	    		select.append('<option value="" disabled selected>Select Payment Status</option>');
	   	        	    	}
	            		 $('<option>').val(value.paymentStatusId).text(value.paymentStatusTitle).appendTo(select);
	            	  }); 
	        	   $('#ddReconPaymentStatusId').selectpicker('show');
			 },
			   error: function(){
			     alert('ERROR OCCURED');
			     window.location.href=ctx+"/home";
			   }
			 });
		 
		  $("#dd_recon_update_status").modal('show');
		 }
		 else{
			 edumaatAlert({
		    		 title:"Error !",
		    		 text:"Please Select Atleast One Receipt",
		    		 type:"error",
		    	});
		 }
			 $("#updateDdRecon").click(function(){
				 if( $("#updateDdReconForm").valid())
					{
					 $("#updateDdReconForm").submit();
					}
			 });
		 
		});
	 
	    $("#closeCashReconModal").click(function() {
			$('input[name="cashReconReceiptId"]').remove();
		});
	    
		
		$("#closeChequeReconModal").click(function() {
			$('input[name="chequeReconReceiptId"]').remove();
		});
		
		$("#closeddReconModal").click(function() {
			$('input[name="ddReconReceiptId"]').remove();
		});
	 
});
	 

	 