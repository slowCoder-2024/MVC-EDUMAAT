$(document).ready(function(){
	var ctx= window.location.pathname.substring(0, window.location.pathname.indexOf("/",2));
	var currentdate = new Date(); 
    var datetime = currentdate.getDate() + "-"
                + (currentdate.getMonth()+1)  + "-" 
                + currentdate.getFullYear() + "_"  
                + currentdate.getHours() + "-"  
                + currentdate.getMinutes() + "-" 
                + currentdate.getSeconds();
var exportfilename='Admission_Rank_Details'+datetime;
	$('#datatable').DataTable({
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
		        ]
	});
	
	
	$("#criteria").change(function(event){
		var criteria=$("#criteria").val();
		if(criteria==="academicyear")
		{
			$('.form-group-academicyear').show();
			$('.form-group-classes').hide();
		}
		else if(criteria==="classes")
		{
			$('.form-group-academicyear').hide();
			$('.form-group-classes').show();
		}
		
		
	});
	$("#shortCandidateList").click(function(event){
		/*var data=$("#shortcandidateForm").serialize();*/
		var criteria=$("#criteria").val();
		var classId="";
		var academicYearId="";
		if(criteria==="academicyear")
		{
			criteria=$("#criteria").val();
			academicYearId=$("#academicYearId").val();
		}
		else if(criteria==="classes")
		{
			criteria=$("#criteria").val();
			classId=$("#classId").val();
		}
	
		if($('#shortcandidateForm').valid())
		{
		$('.loader').show();
			 $.get(ctx+'/admissions/admissioncandidatedetails/getadmissioncandidatedetails', {classId:classId,academicYearId:academicYearId,criteria:criteria}, function(data) {
				 $('.loader').hide();
					var datatable = $('#datatable-buttons').DataTable();
		        		datatable.clear().draw();
					
		       if(data.length>0)
		    	   {
		    	    
		    	   $.each(data, function (i, item) 
		    	    		{
			            var lastName="";
			            if(item.candidateLastName)
			            {
			            	lastName=item.candidateLastName;
			            }
			        	datatable.row.add(  [item.admissionConfig.admissionProcessYear,item.admissionCode,item.candidateFirstName+" "+lastName,item.classz.className,item.category.categoryName,item.specialCategory.specialCategoryName] ).draw( false );
			        });
			        
		    	   }/*else
		    	   {
		    		   edumaatAlert({
			    			  title: "Information !",
			    			  text: "No Seat Availability",
			    			  type: "warning",
			    			  confirmButtonText: "Cool"
			    			});
		    	   }*/
						
		    
					
  	        });
		}
  
	});
	 $('#list').click(function(event) {
		 var selectedAdmissionCandidates = [];
		  $.each($(".case:checked"), function(){            
			  selectedAdmissionCandidates.push($(this).attr('id'));
	         });
		  if(selectedAdmissionCandidates.length>0)
			  {
			 $('.loader').show();
			  $.post(ctx+"/admissions/finalization/intimateSelectCandidate?selectedAdmissionCandidates="+selectedAdmissionCandidates,function(){
				  $('.loader').hide();
				  location.reload();
			  });
			  }
		  	else
			  {
				  edumaatAlert({
		    			  title: "warning !",
		    			  text: "Please select atleast one student...!",
		    			  type: "warning",
		    			  confirmButtonText: "Cool"
		    			});
			  }
		 
		   
			 
		   
		});
	 
	
});
/*function select_all() {
	$('input[class=case]:checkbox').each(function(){ 
		if($('input[class=check_all]:checkbox:checked').length == 0){ 
			$(this).prop("checked", false); 
		} else {
			$(this).prop("checked", true); 
		} 
	});
}
*/