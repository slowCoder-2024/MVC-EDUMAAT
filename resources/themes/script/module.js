	var ctx= window.location.pathname.substring(0, window.location.pathname.indexOf("/",2));
$(document).ready(function() {
$("#savemodule").click(function(event) {
		 if($("#addmoduleform").valid())
			{
				$("#modulesaveconfirmation").modal('show');
				$("#modulesaveconfirm").click(function(event) {
					$("#addmoduleform").submit();
				});
				
			}
});
$('#modulelist').on( 'click', 'tr td a#edit', function () {
	 var moduleid = $(this).attr('data-id');
	 $("#updateModuleId").val(moduleid);
	 $('.loader').show();
			   $.ajax({
				   url:ctx+'/module/'+moduleid,
				   type:'GET',
				   success: function(response)
				   {
					   $('.loader').hide();
					   if(response.moduleName && response.moduleName!=null)
					   {
						   $("#editModuleName").val(response.moduleName); 
					   }
					   if(response.moduleCode && response.moduleCode!=null)
						 {
						   $("#editModuleCode").val(response.moduleCode);
						 }
					
					
					   if(response.totalNumberOfHours && response.totalNumberOfHours!=null)
						 {
						   $("#editModuleTotalNumberOfHours").val(response.totalNumberOfHours);
						 }
					
					   
					  
				   },
			   		error: function(){
			   			edumaat
			   			({
			   			  title: "Error!",
			   			  text: "Please Contact Admin...",
			   			  type: "error",
			   			  confirmButtonText: "Cool",
			   			},
			   			function(){
			   				window.location.href=ctx+"/module";
			   			});
			   		}
				 });
});
$("#updatemodule").click(function(event){
	 if($("#updatemoduleform").valid())
		{
	 $('#moduleupdateconfirmation').modal('show');
	 $('#moduleupdateconfirm').click(function(){
		 $("#updatemoduleform").submit();
		
   });
		}
});
$('#modulelist').on( 'click', 'tr td a#delete', function () {
	 var moduleid = $(this).attr('data-id');
	 $('#deletemoduleconfirmation').on('show.bs.modal', function (e) {
		 $("#confirmdeletemodule").click(function(event) {
			 $("#deleteModuleId").val(moduleid);
			 $("#deletemoduleform").submit();  
		});
		});
	   
});
});
