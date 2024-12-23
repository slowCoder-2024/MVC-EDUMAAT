$(document).ready(function() {
	var ctx= window.location.pathname.substring(0, window.location.pathname.indexOf("/",2));
				
        		 $('#admissionConfiglist').on( 'click', 'tr td a#delete', function () {
        		   var admissionConfigId = $(this).attr('data-id');
        		   $("#confirm-delete").on('show.bs.modal', function (e) {
        			   $("#confirmcAdmissionConfigDelete").attr("href", "admissionconfig/delete?admissionConfigId="+admissionConfigId);
        			});
        		   
        		});
        	 
        		 
        		 $('#admissionConfiglist').on( 'click', 'tr td a#edit', function () {
          		   var admissionConfigId = $(this).attr('data-id');
          		 $.ajax({
         			        type: "GET",
         			        url:ctx+"/admissions/admissionconfig/view" ,
         			        data: {admissionConfigId:admissionConfigId},
         			       success: function (response) 
         			        {
         			    	  if(response.applicationCodeFormat && response.applicationCodeFormat!=null)
  							{
  								$("[name=editadmissionCodeFormat]").val(response.applicationCodeFormat);
  							}
  							if(response.applicationFees && response.applicationFees!=null)
  							{
  								$("[name=editadmissionApplicationFees]").val(response.applicationFees);
  							}
  							if(response.admissionStartDate && response.admissionStartDate!=null)
  							{
  								/*$("[name=editadmissionstartdate]").val($.fn.datepicker.formatDate("dd/mm/yy", new Date(response.admissionStartDate)));*/	
  								$("#editadmissionstartdate").datepicker('update',new Date(response.admissionStartDate));
  							}
  							if(response.admissionEndDate && response.admissionEndDate!=null)
  							{
  								/*$("[name=editadmissionenddate]").val($.datepicker.formatDate("dd/mm/yy", new Date(response.admissionEndDate)));*/
  								$("#editadmissionenddate").datepicker('update',new Date(response.admissionEndDate));
  							}
  							if(response.applicationTotalSeats && response.applicationTotalSeats!=null)
  							{
  								$("[name=editAdmissionTotalSeats]").val(response.applicationTotalSeats);
  							}
  							if(response.admissionProcessStatus && response.admissionProcessStatus!=null)
  							{
  								/*$("#editadmissionProcessStatusId").val(response.admissionProcessStatus.admissionProcessStatusId);*/
  								$('#editadmissionProcessStatusId').selectpicker('destroy');
  								$("[name=editadmissionProcessStatusId]").find('option[value='+response.admissionProcessStatus.admissionProcessStatusId+']').attr('selected','selected');
  								$('#editadmissionProcessStatusId').selectpicker('show');
  							}
  							if(response.classes && response.classes!=null)
  							{
  								$('#editClassId').selectpicker('destroy');
  								var selectedval=[];
  								 $.each(response.classes, function(key,value) 
  								 {
  									selectedval.push(value.classId);
  									 
  				            	 }); 
  								$('#editClassId').val(selectedval);
  								$('#editClassId').selectpicker('show');
  								}
  							$("#updateAdmissionConfigId").val(response.admissionConfigId);
         			        },
        			 	 	error:function()
        			 	 	{
        			 	 		alert("ERROR OCCURED");
        			 	    }
         			 	});
          	  
          		 /*  $.get(ctx+'/admissions/admissionconfig/view', {
          				admissionConfigId:admissionConfigId
    						}, function(response) 
    						{
    							if(response.applicationCodeFormat && response.applicationCodeFormat!=null)
    							{
    								$("[name=editadmissionCodeFormat]").val(response.applicationCodeFormat);
    							}
    							if(response.applicationFees && response.applicationFees!=null)
    							{
    								$("[name=editadmissionApplicationFees]").val(response.applicationFees);
    							}
    							if(response.admissionStartDate && response.admissionStartDate!=null)
    							{
    								$("[name=editadmissionstartdate]").val($.datepicker.formatDate("dd/mm/yy", new Date(response.admissionStartDate)));
    							}
    							if(response.admissionEndDate && response.admissionEndDate!=null)
    							{
    								$("[name=editadmissionenddate]").val($.datepicker.formatDate("dd/mm/yy", new Date(response.admissionEndDate)));
    							}
    							if(response.admissionProcessStatus && response.admissionProcessStatus!=null)
    							{
    								$("[name=editadmissionProcessStatusId]").find('option[value='+response.admissionProcessStatus.admissionProcessStatusId+']').attr('selected','selected');
    							}
    							
    							$("#updateAdmissionConfigId").val(response.admissionConfigId);
    						}
          		   );*/
          		});
        	//adding admission config
        	 $("#admissionConfigSave").click(function(event){
        		/* $('#newadmissionConfigForm').validate();*/
        		 if($('#newadmissionConfigForm').valid())
        			 {
        			 
        			 $("#admissionConfigSaveConfirmation").modal('show');
         			$("#admissionConfigSaveConfirm").click(function(){
         			    $("#newadmissionConfigForm").submit();
        			
  	        	});
        			 }
        	});
        	 
        	 
 $("#admissionConfigUpdate").click(function(event){
        		 
        		 $('#updateadmissionConfigForm').validate();
        		 if($('#updateadmissionConfigForm').valid())
        			 {
        			 
        			 $("#admissionConfigUpdateConfirmation").modal('show');
         			$("#admissionConfigUpdateConfirm").click(function(){
         			    $("#updateadmissionConfigForm").submit();
        			
  	        	});
        			 }
        	});
        	
});
