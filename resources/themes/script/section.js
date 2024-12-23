	var ctx= window.location.pathname.substring(0, window.location.pathname.indexOf("/",2));
$(document).ready(function() {	
$("#savesection").click(function(event) {
		 if($("#addsectionform").valid())
			{
				$("#sectionsaveconfirmation").modal('show');
				$("#sectionsaveconfirm").click(function(event) {
					$("#addsectionform").submit();
				});
				
			}
});

$('#sectionlist').on( 'click', 'tr td a#edit', function () {
	   var sectionid = $(this).attr('data-id');
	   $("#updateSectionId").val(sectionid);
	   $('.loader').show();
			   $.ajax({
				   url:ctx+'/section/'+sectionid,
				   type:'GET',
				   success: function(response){
					   $('.loader').hide();
					   if(response.sectionName && response.sectionName!=null)
					   {
						   $("#editSectionName").val(response.sectionName);
					   }
					  
				   },
				   error: function(){
					   alert('ERROR OCCURED');
					   window.location.href=ctx+"/section";
			       }
				});
});

$("#updatesection").click(function(event){
	 if($("#updatesectionform").valid())
		{
	 $('#sectionupdateconfirmation').modal('show');
	 $('#sectionUpdateConfirm').click(function(){
		 $("#updatesectionform").submit();
		
   });
		}
});

$('#sectionlist').on( 'click', 'tr td a#delete', function () {
	 var sectionid = $(this).attr('data-id');
	 $('#deletesectionconfirmation').on('show.bs.modal', function (e) {
		$("#confirmdeletesection").click(function(event) {
			 $("#deleteSectionId").val(sectionid);
			$("#deletesectionform").submit();  
		});
		});
	   
});

});
