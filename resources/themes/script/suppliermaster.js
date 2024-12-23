	var ctx= window.location.pathname.substring(0, window.location.pathname.indexOf("/",2));
$(document).ready(function() {	
$("#saveSupplier").click(function(event) {
		 if($("#addsupplierform").valid())
			{
				$("#suppliersaveconfirmation").modal('show');
				$("#suppliersaveconfirm").click(function(event) {
					$("#addsupplierform").submit();
				});
				
			}
});

$('#supplierMasterlist').on( 'click', 'tr td a#edit', function () {
	   var sectionid = $(this).attr('data-id');
	   $("#updateSupplierMasterId").val(sectionid);
	   $('.loader').show();
			   $.ajax({
				   url:ctx+'/inventoryandpurchase/suppliermaster/'+sectionid,
				   type:'GET',
				   success: function(response){
					   $('.loader').hide();
					   if(response.supplierName && response.supplierName!=null)
					   {
						   $("#editSupplierName").val(response.supplierName);
					   }
					   if(response.contactPersonName && response.contactPersonName!=null)
					   {
						   $("#editContactPersonName").val(response.contactPersonName);
					   }
					   if(response.description && response.description!=null)
					   {
						   $("#editSupplierDescription").val(response.description);
					   }
					   if(response.gender && response.gender!=null)
					   {
						   $('#editSupplierGender').selectpicker('destroy');
						   $("#editSupplierGender").val(response.gender);
						   $('#editSupplierGender').selectpicker('show');
					   }
					   if(response.contactNumber && response.contactNumber!=null)
					   {
						   $("#editSupplierContactNumber").val(response.contactNumber);
					   }
					   if(response.email && response.email!=null)
					   {
						   $("#editSupplierEmail").val(response.email);
					   }
					   if(response.fax && response.fax!=null)
					   {
						   $("#editSupplierFAX").val(response.fax);
					   }
					   if(response.addressLine1 && response.addressLine1!=null)
					   {
						   $("#editSupplierAddressLine1").val(response.addressLine1);
					   }
					   if(response.addressLine2 && response.addressLine2!=null)
					   {
						   $("#editSupplierAddressLine2").val(response.addressLine2);
					   }
					   if(response.country && response.country!=null)
					   {
						   $('[name=editSupplierCountry]').selectpicker('destroy');
						   $("[name=editSupplierCountry]").val(response.country);
						   $('[name=editSupplierCountry]').selectpicker('show');
					   }
					   if(response.state && response.state!=null)
					   {
						   $('[name=editSupplierState]').selectpicker('destroy');
						   $("[name=editSupplierState]").val(response.state);
						   $('[name=editSupplierState]').selectpicker('show');
		     	           $("[name=editSupplierState]").prop('disabled', true);
					   }
					   else
					   {
						   $("[name=editSupplierState]").prop('disabled', true);	
					   }
					   if(response.city && response.city!=null)
					   {
						   $('[name=editSupplierCity]').selectpicker('destroy');
						   $("[name=editSupplierCity]").val(response.city);
						   $('[name=editSupplierCity]').selectpicker('show');
		     	           $("[name=editSupplierCity]").prop('disabled', true);
					   }
					   else
					   {
						   $("[name=editSupplierCity]").prop('disabled', true);	
					   }
					   if(response.postCode && response.postCode!=null)
					   {
						   $("#editSupplierPostCode").val(response.postCode);
					   }
					   if(response.bankName && response.bankName!=null)
					   {
						   $("#editSupplierBankName").val(response.bankName);
					   }
					   if(response.bankAccountNo && response.bankAccountNo!=null)
					   {
						   $("#editSupplierBankAccountNo").val(response.bankAccountNo);
					   }
					   if(response.bankIFSCCode && response.bankIFSCCode!=null)
					   {
						   $("#editSupplierBankIFSC").val(response.bankIFSCCode);
					   }
					   if(response.panNumber && response.panNumber!=null)
					   {
						   $("#editSupplierPANNo").val(response.panNumber);
					   }
					   if(response.tinNumber && response.tinNumber!=null)
					   {
						   $("#editSupplierTINNo").val(response.tinNumber);
					   }
					   if(response.cstNumber && response.cstNumber!=null)
					   {
						   $("#editSupplierCSTNo").val(response.cstNumber);
					   }
					   if(response.serviceTaxNumber && response.serviceTaxNumber!=null)
					   {
						   $("#editSupplierServiceTaxNo").val(response.serviceTaxNumber);
					   }
					   if(response.status!=null)
					   {
						   $('#editSupplierStatus').selectpicker('destroy');
						   $("#editSupplierStatus").val(response.status);
						   $('#editSupplierStatus').selectpicker('show');
					   }
					  
				   },
				   error: function(){
					   alert('ERROR OCCURED');
					   window.location.href=ctx+"/inventoryandpurchase/suppliermaster";
			       }
				});
});

$("#updateSupplierMaster").click(function(event){
	 if($("#updatesuppliermasterform").valid())
		{
		 $('[name=editSupplierState]').attr('disabled', false);
		  $('[name=editSupplierCity]').attr('disabled', false);
	 $('#suppliermasterupdateconfirmation').modal('show');
	 $('#suppliermasterUpdateConfirm').click(function(){
		 $("#updatesuppliermasterform").submit();
		
   });
		}
});

$('#supplierMasterlist').on( 'click', 'tr td a#delete', function () {
	 var sectionid = $(this).attr('data-id');
	 $('#deletesuppliermasterconfirmation').on('show.bs.modal', function (e) {
		$("#confirmdeletesuppliermaster").click(function(event) {
			 $("#deleteSupplierMasterId").val(sectionid);
			$("#deletesuppliermasterform").submit();  
		});
		});
	   
});
$('#geographicallocation1').change(function(event) {
	    var country = $("#geographicallocation1").val();
	  $('#geographicallocationstate1').attr('disabled', false);
$('#geographicallocationcity1').attr('disabled', false);
	    $.get(ctx+'/geographicallocation/state', {
              country : country
      }, function(response) {
      	  var select = $('#geographicallocationstate1');
      	   select.find('option').remove();
      	   var select1=$('#geographicallocationcity1');
      	   		select1.find('option').remove();
      	   	 $('#geographicallocationstate1').selectpicker('destroy');
      	   $('#geographicallocationcity1').selectpicker('destroy');
          	 $.each(response, function(key,value) {
          		 if(key==0){
 	        	    		select.append('<option value="" disabled selected>Select State</option>');
 	        	    		select1.append('<option value="" disabled selected>Select State First</option>');
 	        	    	}
          		 $('#geographicallocationstate1').append('<option id="'+value.name+'" value="'+value.name+'">'+value.name+'</option>');
          	}); 
         	 $('#geographicallocationstate1').selectpicker('show');
    	   $('#geographicallocationcity1').selectpicker('show');
      });
     
});
      
      
$('#geographicallocationstate1').change(function(event) {
  var state = $("#geographicallocationstate1").val();

  $.get(ctx+'/geographicallocation/city', {
          state : state
  }, function(response) {
  	
  	  var select = $('#geographicallocationcity1');
      	 select.find('option').remove();
        $('#geographicallocationcity1').selectpicker('destroy');
      	 $.each(response, function(key,value) {
      		 if(key==0){
      	    		select.append('<option value="" disabled selected>Select City</option>');
      	    	}
      		 $('#geographicallocationcity1').append('<option id="'+value.name+'" value="'+value.name+'">'+value.name+'</option>');
      	  
      	 }); 
     	   $('#geographicallocationcity1').selectpicker('show');
  });
 
  });	
});
