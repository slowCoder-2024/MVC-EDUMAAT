 var ctx= window.location.pathname.substring(0, window.location.pathname.indexOf("/",2));
$(document).ready(function() {
		
	
	var currentdate = new Date(); 
    var datetime = currentdate.getDate() + "-"
                + (currentdate.getMonth()+1)  + "-" 
                + currentdate.getFullYear() + "_"  
                + currentdate.getHours() + "-"  
                + currentdate.getMinutes() + "-" 
                + currentdate.getSeconds();
var exportfilename='Student_Wise_Fees_Report_'+datetime;
	$('input[type=radio][name=option]').change(function() {
		if (this.value == 'byFeesCategory') {
			$("#feesItemListDiv").hide();
        	$("#feesCategoryListDiv").show();
        }
        else if (this.value == 'byFeesItem') {
        	$("#feesItemListDiv").show();
        	$("#feesCategoryListDiv").hide();
        }
    });
	var currecyCode="";
	if($("#currecyCodeData").text()!=null)
		{
		currecyCode=$("#currecyCodeData").val();
		}
	//fees term and fee category are the same thing
	//fees template item and fees item are same thing
	
	$("#criteria").change(function(event){
	var criteria=$("#criteria").val();
	if(criteria=='academicYear')
	{
		$("#academicYearFormGroup").show();
		$("#dateRange").hide();
	}
	else if(criteria=='dateRange')
	{
		$("#academicYearFormGroup").hide();
		$("#dateRange").show();
	}
	else
	{
		$("#academicYearFormGroup").hide();
		$("#dateRange").hide();
	}
	});
	     $("#getStudentReport").click(function(event){
	    	 
                 if($("#studentReportForm").valid()){
                	 $('.loader').show();
                	var reportType=$("#reportType").val();
                	var academicYearId=$("#academicYearId").val();
                	$("#academicYearFormGroup").hide();
            		$("#dateRange").hide();
            		$("#ListDiv").hide();
            		$("#backButton").show();
                	 if($('input[name=option]:checked').val()=='byFeesCategory'){
                		 var data=$("#studentReportForm").serialize();
                		 var feesCategoryId=$("#feesCategoryList").val();
                		    $.ajax(	
						    {
						        type: "GET",
						        url:ctx+"/report/studentWise/feesCategoryReport",
						        data:data,
						        contentType: "application/json; charset=utf-8",
						        dataType: "json",
						        cache: false,
						        success: function (response) {
						        	 $('.loader').hide();
						        	if(reportType=='pending'){
						        		$("#pendingFeesByFeesCategory").show();
						        		$("#paidFeesByFeesCategory").hide();
						        		$("#pendingFeesByFeesItem").hide();
						        		$("#paidFeesByFeesItem").hide();
						        		var datatable = $('#pendingFeesByFeesCategoryTable').DataTable();
							        	 $(".form-horizontal").trigger('reset'); 
							        	 
											      datatable.clear().draw();
											  $.each(response, function (i, studentInvoice) {
												  var pendingFeesAmount=0.0;
												  $.each(studentInvoice.studentInvoiceDetails, function (indexForInvoiceDetail, valueForInvoiceDetail) {
													  if(valueForInvoiceDetail.studentInvoiceElementPaymentStatus==1){
														  pendingFeesAmount+=valueForInvoiceDetail.studentInvoiceElementTotalAmount
													  }
												  });
												  if(studentInvoice!=null){
													  var name;
											        	if(studentInvoice.student.lastName!=null){
											        		name=studentInvoice.student.firstName+' '+studentInvoice.student.lastName;
											        	}else{
											        		name=studentInvoice.student.firstName;
											        	}
											          datatable.row.add([name,studentInvoice.student.admissionNo,studentInvoice.student.studentClass.className+"/"+studentInvoice.student.section.sectionName,studentInvoice.feesTerm.feesTermName,pendingFeesAmount]).draw( false );
												  }
										   });
						        	}
						        	else if(reportType=='paid'){
						        		$("#paidFeesByFeesCategory").show();
						        		$("#pendingFeesByFeesCategory").hide();
						        		$("#pendingFeesByFeesItem").hide();
						        		$("#paidFeesByFeesItem").hide();
						        		var datatable = $('#paidFeesByFeesCategoryTable').DataTable();
							        	 $(".form-horizontal").trigger('reset'); 
											      datatable.clear().draw();
											  $.each(response, function (i, studentInvoice) {
												  if(studentInvoice!=null){
													  var paidFeesAmount=0.0;
													  $.each(studentInvoice.studentInvoiceDetails, function (indexForInvoiceDetail, valueForInvoiceDetail) {
														  if(valueForInvoiceDetail.studentInvoiceElementPaymentStatus==0){
															  paidFeesAmount+=valueForInvoiceDetail.studentInvoiceElementTotalAmount
														  }
													  });
													  var name;
											        	if(studentInvoice.student.lastName!=null){
											        		name=studentInvoice.student.firstName+' '+studentInvoice.student.lastName;
											        	}else{
											        		name=studentInvoice.student.firstName;
											        	}
											          datatable.row.add([name,studentInvoice.student.admissionNo,studentInvoice.student.studentClass.className+"/"+studentInvoice.student.section.sectionName,studentInvoice.feesTerm.feesTermName,paidFeesAmount]).draw( false );
												  }
										   });
						        	}
						        	$('.loader').hide();
						        },
						        error:function(){
						        	$('.loader').hide();
						        	edumaatAlert({
				  			    		 title:"Error!",
				  			    		 text:"No Reports Available",
				  			    		 type:"error",
				  			    	}).then(function(){
				  			    		window.location.href=ctx+"/report/studentWise";
				  			    	});
						        }
						    });
                		 
                	 }else if($('input[name=option]:checked').val()=='byFeesItem'){
                		 var fld = document.getElementById('feesItemList');
                		 var values = [];
                		 for (var i = 0; i < fld.options.length; i++) {
                		   if (fld.options[i].selected) {
                		     values.push(fld.options[i].value);
                		   }
                		 }
                		 var data=$("#studentReportForm").serialize();
                		 $.ajax(	
      						    {
      						        type: "GET",
      						        url:ctx+"/report/studentWise/feesItemReport",
      						        data: data,
      						        contentType: "application/json; charset=utf-8",
      						        dataType: "json",
      						        cache: false,
      						        success: function (response) {
      						        	 $('.loader').hide();
      						        	if(reportType=='pending'){
    						        		$("#pendingFeesByFeesItem").show();
    						        		$("#paidFeesByFeesCategory").hide();
    						        		$("#pendingFeesByFeesCategory").hide();
    						        		$("#paidFeesByFeesItem").hide();
    						        		var datatable = $('#pendingFeesByFeesItemTable').DataTable();
    							        	 $(".form-horizontal").trigger('reset'); 
    							        	       datatable.clear().draw();
    											  $.each(response, function (i, studentInvoiceDetail) {
    												  if(studentInvoiceDetail!=null){
    													  var name;
    											        	if(studentInvoiceDetail.studentInvoice.student.lastName!=null){
    											        		name=studentInvoiceDetail.studentInvoice.student.firstName+' '+studentInvoiceDetail.studentInvoice.student.lastName;
    											        	}else{
    											        		name=studentInvoiceDetail.studentInvoice.student.firstName;
    											        	}
    											          datatable.row.add([name,studentInvoiceDetail.studentInvoice.student.admissionNo,studentInvoiceDetail.studentInvoice.student.studentClass.className+"/"+studentInvoiceDetail.studentInvoice.student.section.sectionName,studentInvoiceDetail.studentInvoice.feesTerm.feesTermName,studentInvoiceDetail.feesItem.feesItemName,studentInvoiceDetail.studentInvoiceElementTotalAmount]).draw( false );
    												  }
    										   });
    						        	}
    						        	else if(reportType=='paid'){
    						        		$("#paidFeesByFeesItem").show();
    						        		$("#pendingFeesByFeesItem").hide();
    						        		$("#paidFeesByFeesCategory").hide();
    						        		$("#pendingFeesByFeesCategory").hide();
    						        		var datatable = $('#paidFeesByFeesItemTable').DataTable();
    							        	 $(".form-horizontal").trigger('reset'); 
    											      datatable.clear().draw();
    											      $.each(response, function (i, studentInvoiceDetail) {
        												  if(studentInvoiceDetail!=null){
        													  var name;
        											        	if(studentInvoiceDetail.studentInvoice.student.lastName!=null){
        											        		name=studentInvoiceDetail.studentInvoice.student.firstName+' '+studentInvoiceDetail.studentInvoice.student.lastName;
        											        	}else{
        											        		name=studentInvoiceDetail.studentInvoice.student.firstName;
        											        	}
        											          datatable.row.add([name,studentInvoiceDetail.studentInvoice.student.admissionNo,studentInvoiceDetail.studentInvoice.student.studentClass.className+"/"+studentInvoiceDetail.studentInvoice.student.section.sectionName,studentInvoiceDetail.studentInvoice.feesTerm.feesTermName,studentInvoiceDetail.feesItem.feesItemName,studentInvoiceDetail.studentInvoiceElementTotalAmount]).draw( false );
        												  }
        										   });
    						        	}
      						        	$('.loader').hide();
      						        },
      						        error:function(){
      						        	$('.loader').hide();
      						        	edumaatAlert({
      				  			    		 title:"Error!",
      				  			    		 text:"No Reports Available",
      				  			    		 type:"error",
      				  			    	}).then(function(){
      				  			    		window.location.href=ctx+"/report/studentWise";
      				  			    	});
      						        }
      						    });
                	 }
                	    
							
							
								
				  }
              });	 
	
	     $('#pendingFeesByFeesCategoryTable').DataTable({
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
	      	     .column( 4 , {'search': 'applied'})
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
	      	 /*$( api.column( 4 ).footer() ).html(
	      	     ''+pageTotalAmount +' ('+ totalAmount +' total)'
	      	 );*/
	      	$("#feescategorypendinggrandtotal").html(totalAmount);
	         $("#feescategorypendingpagetotal").html(pageTotalAmount);
	      	}

		 });	
		 $('#paidFeesByFeesCategoryTable').DataTable({
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
	      	     .column( 4 , {'search': 'applied'})
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
	      /*	 $( api.column( 4 ).footer() ).html(
	      	     ''+pageTotalAmount +' ('+ totalAmount +' total)'
	      	 );*/
	      	 
	      	$("#feescategorypaidgrandtotal").html(totalAmount);
	         $("#feescategorypaidpagetotal").html(pageTotalAmount);
	      	}


		 });
		 $('#pendingFeesByFeesItemTable').DataTable({
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
	  	     .column( 5, {'search': 'applied'} )
	  	     .data()
	  	     .reduce( function (a, b) {
	  	         return intVal(a) + intVal(b);
	  	     }, 0 );

	  	 // TotalAmount over this page
	  	 pageTotalAmount = api
	  	     .column( 5, { page: 'current'} )
	  	     .data()
	  	     .reduce( function (a, b) {
	  	         return intVal(a) + intVal(b);
	  	     }, 0 );

	  	 // Update footer
	  	/* $( api.column( 5 ).footer() ).html(
	  	     ''+pageTotalAmount +' ('+ totalAmount +' total)'
	  	 );*/
	 	$("#feesitempendinggrandtotal").html(totalAmount);
        $("#feesitempendingpagetotal").html(pageTotalAmount);
	  	}


		 });
		 $('#paidFeesByFeesItemTable').DataTable({
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
	  	     .column( 5, {'search': 'applied'} )
	  	     .data()
	  	     .reduce( function (a, b) {
	  	         return intVal(a) + intVal(b);
	  	     }, 0 );

	  	 // TotalAmount over this page
	  	 pageTotalAmount = api
	  	     .column( 5, { page: 'current'} )
	  	     .data()
	  	     .reduce( function (a, b) {
	  	         return intVal(a) + intVal(b);
	  	     }, 0 );

	  	 // Update footer
	  	/* $( api.column( 5 ).footer() ).html(
	  	     ''+pageTotalAmount +' ('+ totalAmount +' total)'
	  	 );*/
	  	 
	 	$("#feesitempaidgrandtotal").html(totalAmount);
        $("#feesitempaidpagetotal").html(pageTotalAmount);
	  	}


		 });
		

});
		


    