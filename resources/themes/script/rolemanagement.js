var ctx= window.location.pathname.substring(0, window.location.pathname.indexOf("/",2));
$(document).ready(function() {	
	
	   $('#example-select-all').on('click', function(){
		        
		   $('.case').prop('checked', this.checked);
		     });
	   
	   $('#editexample-select-all').on('click', function(){
	        
		   $('.case1').prop('checked', this.checked);
		     });
	
	
$("#saveuserrole").click(function(event) {

		 if($("#adduserroleform").valid())
			{
			 var selectedRoleIds=[];
			 $('input[class=case]:checkbox:checked').each(function(){ 
				 selectedRoleIds.push(this.id);
				});
			 if(selectedRoleIds.length>0)
			 {
				 $("#selectedPrivilegeId").val(selectedRoleIds);
					$("#userrolesaveconfirmation").modal('show');
					$("#userrolesaveconfirm").click(function(event) {
						$("#adduserroleform").submit();
					});
			}else
			{
				 edumaatAlert({
	    			  title: "Info !",
	    			  text: "Select Atleast one privilege...!",
	    			  type: "info",
	    			  confirmButtonText: "Cool"
	    			});
			}
			
				
			}
});

$('#userrolelist').on( 'click', 'tr td a#edit', function () {
	
	 var userroleid = $(this).attr('data-id');
	 $("#updateUserRoleId").val(userroleid);
	 	$('.loader').show();
	 	$('.case1').prop('checked', false);
			   $.ajax({
				   url:ctx+"/rolemanagement/"+userroleid,
				   type:'GET',
				   success: function(response)
				   {
					 $('#multiEditFormDiv').show();   
					 $('.loader').hide();
					 $("#editRoleName").val(response.roleName);
					 $.each(response.privileges,function(key,index){
						 
						 
										 $(".editmultiselect option[value="+index.privilegeId+"]").attr('selected','selected').trigger('change');
										
										 $('#edit'+index.privilegeId).prop('checked', 'checked');
					 });
					
					},
			   	   error: function(){
				     alert('ERROR OCCURED');
				     window.location.href=ctx+"/rolemanagement";
				   }
				 });
});


$("#updateuserrole").click(function(event){

	 if($("#updateuserroleform").valid())
		{
		 var selectedRoleIds=[];
		 $('input[class=case1]:checkbox:checked').each(function()
				{ 
			 selectedRoleIds.push($("#"+this.id).val());
			});
		 
	
		 if(selectedRoleIds.length>0)
		 {
			 $("#selectedEditPrivilegeId").val(selectedRoleIds);
			 $('#userroleupdateconfirmation').modal('show');
			 $('#userroleupdateconfirm').click(function(){
				 $("#updateuserroleform").submit();
				
		      });
		}
		else
		{
			 edumaatAlert({
    			  title: "Info !",
    			  text: "Select Atleast one privilege...!",
    			  type: "info",
    			  confirmButtonText: "Cool"
    			});
		}
	}
});

$('#userrolelist').on( 'click', 'tr td a#delete', function () {
	 var userroleid = $(this).attr('data-id');
	 $("#deleteUserRoleId").val(userroleid);
	 $('#deleteuserroleconfirmation').on('show.bs.modal', function (e) {
		 $("#confirmdeleteuserrole").click(function(event) {
			$("#deleteUserRoleForm").submit();  
		});
		});
	   
});

});

function editmultiselect() {
	$('.editmultiselect').multiselect({
	    placeholder: 'Select Privilege',
	    columns:2,
	    search: true,
	    selectAll: true
	});
}
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
