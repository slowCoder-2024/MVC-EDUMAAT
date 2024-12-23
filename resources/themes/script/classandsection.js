
$(document).ready(function() {
	var ctx= window.location.pathname.substring(0, window.location.pathname.indexOf("/",2));
	
$("#addsection").click(function(event) {
	$("#addSectionPopup").modal('show');	
	 $("#createnewsection").click(function(){
		 $("#classandsectionsettingform").valid();
		
});
});
$('#sectionList').on( 'click', 'tr td a#edit', function () {
	var sectionid = $(this).attr('data-id');
	$('.loader').show();
	$.ajax({
		   url:ctx+'/section/'+sectionid,
		   type:'GET',
		   success: function(response){
			   $('.loader').hide();
			   if(response.sectionName && response.sectionName!=null)
			   {
				   $("[name=editSectionName]").val(response.sectionName);
			   }
			   $("#updateSection").attr('data-id',response.sectionId);
			 
			 
			   
		   },
		   error: function(){
		     alert('ERROR OCCURED');
		     window.location.href=ctx+"/class/classnandsection";
		   }
		 });
});


$('#sectionList').on( 'click', 'tr td a#delete', function () {
	 var sectionid = $(this).attr('data-id');
	 $('#confirm_delete_class_section').on('show.bs.modal', function (e) {
		 $("#deleteSectionConfirm").click(function(event) {
			 $("#deleteSectionId").val(sectionid);
			 $("#deleteSectionForm").submit();
		});
		});
});

$("#updateSection").click(function(event){
	 var sectionId = $(this).attr('data-id');
	 $("#updateSectionId").val(sectionId);
	
	 if( $("#updateSectionForm").valid())
		{
	 $('#update_Section_Confirmation').modal('show');
	 $('#updateSectionConfirm').click(function(){
		
		 $("#updateSectionForm").submit();
	  });
		}
});





//class logic

$("#classandsectionsavebutton").click(function(event) {
	if($("#createclassform").valid())
		{
			$("#classAndSectionAddingConfirmation").modal('show');
			$("#confirmAddClass").click(function(event) {
				$("#createclassform").submit();
			});
		
		}
});

$('#classList').on( 'click', 'tr td a#delete', function () {
	 var classid = $(this).attr('data-id');
	 $('#confirm_delete_class').on('show.bs.modal', function (e) {
		 $("#confirmDeleteClass").click(function(event) {
			 $("#deleteClassId").val(classid);
			 $("#deleteClassForm").submit();  
		});
		});
	   
});


$('#classList').on( 'click', 'tr td a#edit', function () {
	 var classid = $(this).attr('data-id');
	 $('.loader').show();
			   $.ajax({
				   url:ctx+'/class/classeager/'+classid,
				   type:'GET',
				   success: function(response)
				   {
					  $(".loader").hide();
       		 		if(response.className && response.className!=null)
       		 		{
       		 			$("[name=editClassName]").val(response.className); 
       		 		}
       		 		if(response.classId && response.classId!=null)
       		 		{
       		 			$('#updateClassId').val(response.classId);
       		 		}
       		 		if(response.classSections)
       		 		{
       		 			var selectedValues=[];
       		 			var staffId="";
           				$.each(response.classSections, function(key,value) 
         	        			{
           					
         	        				selectedValues[key]=value.sectionClass.sectionId;
         	        				staffId=value.classStaff.staffId;
         	        			});
           				$('#editSections').selectpicker('destroy');
           				$("#editSections").val(selectedValues);
           				$('#editSections').selectpicker('show');
           				
           				$('#editSelectedClassStaff').selectpicker('destroy');
           				$("#editSelectedClassStaff").val(staffId);
           				$('#editSelectedClassStaff').selectpicker('show');
           				
           				/*$.each(response.classSections, function(key,value) 
         	        			{
           					
         	        				selectedValues[key]=value.classStaff.staffId;
         	        			});
           				$('#editSelectedClassStaff').selectpicker('destroy');
           				$("#editSelectedClassStaff").val(selectedValues);
           				$('#editSelectedClassStaff').selectpicker('show');*/
       		 		}
       				
       				
				   }
				 });
	   
});


$("#updateClassAndSection").click(function(event){
	
	 if($("#updateClassAndSectionForm").valid())
		{
	 
		  var classsections= [];
		 $("#editSections > option:selected").each(function() {
			
			 
			 classsections.push($(this).attr("data")+"-"+$(this).val());
			    
			});
		 
		 $("#classSectionIdUpdate").val(classsections);
		 
		 
	 $('#update_Class_Section_Confirmation').modal('show');
	 $('#saveConfirm').click(function(){
		 $("#updateClassAndSectionForm").submit();
		
    });
		}
});
/*$('#specialCategorylist').on( 'click', 'tr td a#edit', function () {
	var specialCategoryid = $(this).attr('data-id');
	
	$.ajax({
		   url:ctx+'/specialCategory/editReterive',
		   data:{specialCategoryId:specialCategoryid},
		   type:'GET',
		   success: function(response){
			   $("[name=editSpecialCategoryName]").val(response.specialCategoryName);
			   $("#updateSpecialCategory").attr('data-id',response.specialCategoryId);
			   
		   },
		   error: function(){
		     alert('ERROR OCCURED');
		     window.location.href=ctx+"/class";
		   }
		 });
});

$("#updateSpecialCategory").click(function(event){
	var specialCategoryId = $(this).attr('data-id');
	$(this).validate();
	if($("#updateSpecialCategoryForm").valid())
		{
			$("#specialCategoryUpdateConfirmation").modal('show');
			$("#specialCategoryUpdateConfirm").click(function(event) {
				var data=$('#updateSpecialCategoryForm').serialize()+'&specialCategoryId='+specialCategoryId;
				 $.ajax({
					   url:ctx+'/specialCategory/editUpdate',
					   data:data,
					   type:'POST',
					   success: function(){
						   window.location.href=ctx+"/specialCategory";
					   },
					   error: function(){
					     alert('Special Category Was Not Updated');
					     window.location.href=ctx+"/specialCategory";
					   }
					 });
			});
			return false;
		}
		
  });*/

});
