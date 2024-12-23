var ctx= window.location.pathname.substring(0, window.location.pathname.indexOf("/",2));

$("#specialCategorySave").click(function(event) {
	if($("#specialCategoryform").valid())
		{
			$("#specialCategorySaveConfirmation").modal('show');
			$("#specialCategorySaveConfirm").click(function(event) {
				$("#specialCategoryform").submit();
			});
		}
});

$('#specialCategorylist').on( 'click', 'tr td a#delete', function () {
	 var specialCategoryid = $(this).attr('data-id');
	 $("#deleteSpecialCategoryId").val(specialCategoryid);
	 $('#deleteSpecialCategoryConfirmation').on('show.bs.modal', function (e) {
		 $("#confirmDeleteSpecialCategory").click(function(event) {
			$("#deleteSpecialCategoryForm").submit();
		});
		});
	   
});

$('#specialCategorylist').on( 'click', 'tr td a#edit', function () {
	var specialCategoryid = $(this).attr('data-id');
	$("#updateSpecialCategoryId").val(specialCategoryid);
	$('.loader').show();
	$.ajax({
		   url:ctx+'/specialCategory/'+specialCategoryid,
		   type:'GET',
		   success: function(response){
			   $('.loader').hide();
			   if(response.specialCategoryName!=null)
			   {
				   $("[name=editSpecialCategoryName]").val(response.specialCategoryName);
			   }
			   if(response.specialCategoryId!=null)
			   {
				   $("#updateSpecialCategory").attr('data-id',response.specialCategoryId);
			   }
			   
		   },
		   error: function(){
		     alert('ERROR OCCURED');
		     window.location.href=ctx+"/specialCategory";
		   }
		 });
});

$("#updateSpecialCategory").click(function(event){
	 if($("#updateSpecialCategoryForm").valid())
		{
			$("#specialCategoryUpdateConfirmation").modal('show');
			$("#specialCategoryUpdateConfirm").click(function(event) {
				$('#updateSpecialCategoryForm').submit();
				
			});
		}
		
  });
function testAnim(x) {
    $('#table').removeClass().addClass(x + ' animated').one('webkitAnimationEnd mozAnimationEnd MSAnimationEnd oanimationend animationend', function(){
      $(this).removeClass();
    });
  };
