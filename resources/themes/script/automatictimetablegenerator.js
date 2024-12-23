$(document).ready(function() {
	
		 var tdId="";	
	 var ctx= window.location.pathname.substring(0, window.location.pathname.indexOf("/",2));
	 /*$('table').on('click', 'td', function(e) {  
		 alert();
		    var time = e.delegateTarget.tHead.rows[0].cells[this.cellIndex],
		        day  = this.parentNode.cells[0];
		    
		    alert([$(day).text(), $(time).text()]);
		});*/
	
			
	 $(document).on('click',".tdd",function (event){   
		 tdId=this.id;
			  var $cell = $("#"+tdId);
			var day =  $cell.parent().children(':first').text();
			var hourtime =  $cell.closest('table').children(':first').find('th').eq( $cell.index()).text();
				var subject=[];
		   $.ajax({
				   url:ctx+'/timetable/generator/checkTimeTableConstraint',
				   data:{day:day,hourtime:hourtime},
				   type:'GET',
				   success: function(response)
				   {
					   subject=[];
					   $.each(response, function(key2,value2) 
        	        			{ 
					   $.each(value2.timeTableGeneratorDays, function(key,value) 
	         	        			{ 
						   $.each(value.timeTableGeneratorHours, function(key1,value1) 
    	      	        			{
							 	 var day1=value.timeTableGeneratorDayName;
	        					 var hour1=value1.hourTitle;
	        					 	if((day.trim() == day1.trim()) &&( hourtime.trim() == hour1.trim()))
	        						 {
	        					 		var subjectnames=value1.subjectName;
	        					 		subject.push(subjectnames.trim());
	        					 	 }
	        					 	
    	      	        			});
	         	        			});
        	        			});
				   }
				 });
		$('#addModulePopup').modal('show');
		  $('#confirm').click(function(){
			  if($('#selectmoduleform').valid())
				   {
				  var module=$('#moduleId').val();
				  if(module=="Break" || module=="Lunch")
					  {
					  subject=[];
					  var str = tdId;
					    var res = str.replace(/td/g, "label");
					    tdId=res;
					   $("label[id="+tdId+"]").html($('#moduleId').val());
					  }
				  else{
				  if(subject.includes(module.trim()))
				  {
					   subject=[];
					  edumaatAlert({
						  title: 'You Want To Allow?',
						  text: "Already this staff allocated for another class and section this timing",
						  type: 'warning',
						  showCancelButton: true,
						  confirmButtonColor: '#3085d6',
						  cancelButtonColor: '#d33',
						  confirmButtonText: 'Yes, Allow it!',
						  cancelButtonText: 'No, cancel!',
						  confirmButtonClass: 'btn btn-success',
						  cancelButtonClass: 'btn btn-danger',
						  buttonsStyling: false
						}).then(function () {
							 var str = tdId;
							    var res = str.replace(/td/g, "label");
							    tdId=res;
							   $("label[id="+tdId+"]").html($('#moduleId').val());
						  edumaatAlert(
						     'Allowed Successfully...!'
						  )
						}, function (dismiss) {
						   var str = tdId;
						    var res = str.replace(/td/g, "label");
						    tdId=res;
						   $("label[id="+tdId+"]").html("");
						  if (dismiss === 'cancel') {
						    edumaatAlert(
						      'Cancelled Successfully...!'
						    )
						  }
						})
				  }
				  else
				  {
					  subject=[];
					  var str = tdId;
					    var res = str.replace(/td/g, "label");
					    tdId=res;
					   $("label[id="+tdId+"]").html($('#moduleId').val());
				  }
				  }	
			   $('#addModulePopup').modal('hide');
			   
			 
			  
			 	  }
			 });
		   
	 });
	
	 $(document).on('click',".edittdd",function (event){   
		 tdId=this.id;
		  var $cell = $("#"+tdId);
			var day =  $cell.parent().children(':first').text();
			var hourtime =  $cell.closest('table').children(':first').find('th').eq( $cell.index()).text();
				var subject=[];
		   $.ajax({
				   url:ctx+'/timetable/generator/checkTimeTableConstraint',
				   data:{day:day,hourtime:hourtime},
				   type:'GET',
				   success: function(response)
				   {
					   subject=[];
					   $.each(response, function(key2,value2) 
      	        			{ 
					   $.each(value2.timeTableGeneratorDays, function(key,value) 
	         	        			{ 
						   $.each(value.timeTableGeneratorHours, function(key1,value1) 
  	      	        			{
							 	 var day1=value.timeTableGeneratorDayName;
	        					 var hour1=value1.hourTitle;
	        					 	if((day.trim() == day1.trim()) &&( hourtime.trim() == hour1.trim()))
	        						 {
	        					 		var subjectnames=value1.subjectName;
	        					 		subject.push(subjectnames.trim());
	        					 	 }
	        					 	
  	      	        			});
	         	        			});
      	        			});
				   }
				 });
		 $('#editModulePopup').modal('show');
		  $('#editconfirm').click(function(){
			  if($('#editselectmoduleform').valid())
				  {
			  var module=$('#editModuleId').val();
				  if(module=="Break" || module=="Lunch")
					  {
					  subject=[];
					  var str = tdId;
					    var res = str.replace(/td/g, "label");
					    tdId=res;
					    $("label[id="+tdId+"]").html($('#editModuleId').val());
					  }
				  else{
				  if(subject.includes(module.trim()))
				  {
					   subject=[];
					  edumaatAlert({
						  title: 'You Want To Allow?',
						  text: "Already This Staff Allocated For Another Class And Section This Timing",
						  type: 'warning',
						  showCancelButton: true,
						  confirmButtonColor: '#3085d6',
						  cancelButtonColor: '#d33',
						  confirmButtonText: 'Yes, Allow it!',
						  cancelButtonText: 'No, cancel!',
						  confirmButtonClass: 'btn btn-success',
						  cancelButtonClass: 'btn btn-danger',
						  buttonsStyling: false
						}).then(function () {
							 var str = tdId;
							    var res = str.replace(/td/g, "label");
							    tdId=res;
							    $("label[id="+tdId+"]").html($('#editModuleId').val());
						  edumaatAlert(
						     'Allowed Successfully...!'
						  )
						}, function (dismiss) {
						   var str = tdId;
						    var res = str.replace(/td/g, "label");
						    tdId=res;
						   $("label[id="+tdId+"]").html("");
						  if (dismiss === 'cancel') {
						    edumaatAlert(
						      'Cancelled Successfully...!'
						    )
						  }
						})
				  }
				  else
				  {
					  subject=[];
					  var str = tdId;
					    var res = str.replace(/td/g, "label");
					    tdId=res;
					    $("label[id="+tdId+"]").html($('#editModuleId').val());
				  }
				  }	
			   $('#editModulePopup').modal('hide');
				  }
			 });
		   
	 });
	   var column=0;
	   var table;
	   var timetabletemplatedays = new Array();
	   var timetabletemplatehours = new Array();
	   var timetabletemplatedaystitle = new Array();
	   var timetabletemplatehourstitle = new Array();
	   var timetablegeneratorhourstitle = new Array();
	   var timetabletemplatesubject = new Array();
			   
	    
	   $('#timeTableGeneratorList').on( 'click', 'tr td a#delete', function () {
         	 var deleteTimeTableGeneratorId = $(this).attr('data-id');
         	 $('#confirm_delete_timeTableGenerator').on('show.bs.modal', function (e) {
         		 $("#confirmDeleteTimeTableGenerator").click(function(event) {
         			 $("#deleteTimeTableGeneratorId").val(deleteTimeTableGeneratorId);
         			 $(".loader").show();
         			 $("#deleteTimeTableGeneratorForm").submit();  
         		});
         		});
         	   
         });
	   var dayIds= new Array();
 	   var hourIds= new Array();
     
	   $('#timeTableGeneratorList').on( 'click', 'tr td a#edit', function () {
		   $(".loader").show();
       	 var timeTableGeneratorId = $(this).attr('data-id');
       	$("#edittimetableview").empty();  
      	$("#edittimetableview").append(' <h4 class="title1">Class Name : <label for="defaultClassName"  id="defaultClassName"></label> &nbsp;&nbsp;&nbsp;&&&nbsp;&nbsp;&nbsp; Section Name : <label for="defaultSectionName"  id="defaultSectionName"></label></h4><br>');  
      
       		$.ajax({
       				   url:ctx+'/timetable/generator/editRetrieve',
       				   data:{timeTableGeneratorId:timeTableGeneratorId},
       				   type:'GET',
       				   success: function(response)
       				   {
       					 $(".loader").hide();
       					 var  timeTableGeneratorDays=[];
       					 var  timeTableGeneratorHours=[];
       					  var columncount=0; 
       					  var rowcount=0;
       					 dayIds=[];
       			  	  hourIds=[];
       			      
       					  if(response.timeTableGeneratorId!=null)
       					  {
       						  $("#updateTimeTableGenerator").attr('data-id',response.timeTableGeneratorId);
       					  }
       					  //<thead><tr id="th"><th></th></tr></thead>
       					  table = $('<table id="editTimeTableGenerator" class="table table-bordered table-responsive" style="display:block;overflow-x: auto;"><thead><tr id="th"><th>DAY/HOUR</th></tr></thead><tbody>');
       					timetabletemplatehours=[];
      					timetabletemplatedaystitle=[];
      					timetabletemplatedays=[];
      					timetablegeneratorhourstitle=[];
      					var rowspancount=0;
      					   $.each(response.timeTableGeneratorDays, function(key,value) 
       	         	        			{ 
       	        				   rowcount=rowcount+1;
       	        				timetabletemplatedays[key]=key;
       	      					timetabletemplatedaystitle[key]=value.timeTableGeneratorDayName;
       	      					dayIds[key]=value.timeTableGeneratorDayId;
       	        				var tr = $('<tr>');
          						$('<td >'+value.timeTableGeneratorDayName+'</td>').appendTo(tr); 
          						   			$.each(value.timeTableGeneratorHours, function(key1,value1) 
	         	      	        			{
          						   			 timetabletemplatehours[key1]=key1;
          						   			 	columncount=columncount+1;
          		       	        				var dynamicid=key+""+key1;
       	        				   				var labelvalue=key+""+key1+"label";
       	        				   					$('<td class="edittdd" id='+dynamicid+"td"+' ><label for="'+dynamicid+"label"+'" id="'+dynamicid+"label"+'" required="required" ></label><div class="error'+dynamicid+'" style="color:red"></div></td>').appendTo(tr); 
       	   	           	        				
       	        				   		  	
	         	      	        			});
       	        				   	   tr.appendTo(table);
       	      						
       	         						});
       	        			
      	        			  	
       	        			
       	        			$("#edittimetableview").append(table);
       	        		   $.each(response.timeTableGeneratorDays, function(key,value) 
 	         	        			{ 
       	        			  var names = "";
       	        			   	$.each(value.timeTableGeneratorHours, function(key1,value1) 
    	      	        			{
       	        			   	timetablegeneratorhourstitle[key1]=value1.hourTitle;
       	        			   			names += value1.timTableGeneratorHourId + ",";
       	        			   			var labelvalue=key+""+key1+"label";
	        				   			$("label[for="+labelvalue+"]").html(value1.subjectName);
		     	        			});
       	        				names = names.substring(0, names.length - 1);
       	        				hourIds.push(names+"-");
   							
 	         	        			});
       	        		var uniqueHourNames = [];
       	        		$.each(timetablegeneratorhourstitle, function(i, el){
       	        		    if($.inArray(el, uniqueHourNames) === -1) uniqueHourNames.push(el);
       	        		});
       	        		
       	        		 /*  $("#timeTableTemplateDayIds").val(timeTableTemplateDays);
       	        		   $("#timeTableTemplateHourIds").val(timeTableTemplateHours);
       					 */ //alert(timeTableTemplateHours);
       					 //alert(timeTableTemplateDays);
       	        		   
       	        		   var classId=response.classSection.classSection.classId;
       	        		   var sectionId=response.classSection.sectionClass.sectionId;
       	        		   
       	        		 $("#defaultClassName").html(response.classSection.classSection.className);
							$("#defaultSectionName").html(response.classSection.sectionClass.sectionName);
       	        		  $.ajax({
             				   url:ctx+'/classSection/classSectionModule',
             				   data:{classId:classId,sectionId:sectionId},
             				   type:'GET',
             				   success: function(response1)
             				   {
             					   if($.trim(response1)&&response1!=null){
             		 					var select = $('#editModuleId');
             						   select.find('option').remove();
             						  $('#editModuleId').selectpicker('destroy');
             						   $.each(response1, function(key,value) {
             							   if(key==0)
             						  		 {
             						     	    select.append('<option value="" disabled selected>Select Module And Staff</option>');
             						     	  select.append('<option value="Break">Break</option>');
             						     	  select.append('<option value="Lunch">Lunch</option>');
             						     	   }
             						  		$('<option id="'+ value.module.moduleId +'">').val(value.module.moduleName+"-"+value.classSectionModuleStaff.staff.firstName).text(value.module.moduleName+"-"+value.classSectionModuleStaff.staff.firstName).appendTo(select);
             						  	 }); 
             						   
             						  $('#editModuleId').selectpicker('show');
             						   
             		 				}
             		 				else
             		 				{
             		 					var select = $('#editModuleId');
             							   select.find('option').remove();
             							  $('#editModuleId').selectpicker('destroy');
             							   select.append('<option value="" disabled selected>Select Module And Staff</option>');
             							  select.append('<option value="Break">Break</option>');
            					     	  select.append('<option value="Lunch">Lunch</option>');
            					     	  
            					     	 $('#editModuleId').selectpicker('show');
             		 				}
             					   
             				   }
             				   });
       	        		 columncount=columncount/rowcount;
       	        		 $("#th").empty();
       	   		   $('#th').append( $('<th />', {text : 'DAY/HOUR'}));
       	   		   for(l=0;l<uniqueHourNames.length;l++)
       	   			 {
       	   		   		$('#th').append( $('<th />', {text :uniqueHourNames[l]}));
       	   			 }
       	        	   }
       				   
       				 });
       		
       });     
       
		$("#updateTimeTableGenerator").click(function(event) {
 			
    		   
			   var count=0;
	    	   timetabletemplatesubject=[];
	    	   $.each(timetabletemplatedays, function( index, value ) {
				   var names = "";
				   $.each(timetabletemplatehours, function( index1, value1 ) {
					   var labelvalue=index+""+index1+"label";
					   var response = $('label[for="' + labelvalue + '"]').html();
					   names += response + ",";
					   var errorMessage="error"+index+""+index1;
					   if(response.length == 0)
					   {
						  
					         count=1;
						  // $("#"+dynamicid).addClass("redBackground");  
						   // alert('You Must Fill Required Fields');
						   $("."+errorMessage).show();
					         $("."+errorMessage).html("Please Enter Valid Input!");
					       
					   }
					   else
					   {	 //$("#"+dynamicid).removeClass("redBackground");  
						   $("."+errorMessage).hide();
						 
					   }
				   });
				   	names = names.substring(0, names.length - 1);
				   	timetabletemplatesubject.push(names+"/"); 
				 });
		//	  alert(timetabletemplatedaystitle);
			  // alert(timetablegeneratorhourstitle);
			//  alert(timetabletemplatesubject);
			   if(count == 0)
			   {
			
				   	$("#editTimeTableDays").val(timetabletemplatedaystitle);
				   	$("#editTimeTableHourSubjects").val(timetabletemplatesubject);
   			   		$("#updateTimeTableGeneratorId").val($(this).attr('data-id'));
   			   		$("#timeTableDayIds").val(dayIds);
   			   		$("#timeTableHourIds").val(hourIds);
			   	//	alert(timetabletemplatedaystitle);
			  // 	alert(hourIds);
   			   		$("#timeTableGeneratorUpdateConfirmation").modal('show');
        			$("#timeTableGeneratorUpdateConfirm").click(function(){
        				 $(".loader").show();
        			$("#updateTimeTableGeneratorForm").submit();
        		});
			   }
			   else
			   {
				 
			   }
		});
    	
       $('#savetimetable').click(function(event){
		  
	
    	   var count=0;
    	   timetabletemplatesubject=[];
		   $.each(timetabletemplatedays, function( index, value ) {
			   var names = "";
			   $.each(timetabletemplatehours, function( index1, value1 ) {
				   var dynamicid=index+""+index1+"td";
				   var labelvalue=index+""+index1+"label";
				   var response = $('label[for="' + labelvalue + '"]').html();
				   names += response + ",";
				   var errorMessage="error"+index+""+index1;
				   if(response.length == 0)
				   {
					  
				         count=1;
					  // $("#"+dynamicid).addClass("redBackground");  
					   // alert('You Must Fill Required Fields');
					   $("."+errorMessage).show();
				         $("."+errorMessage).html("Please Enter Valid Input!");
				       
				   }
				   else
				   {	 //$("#"+dynamicid).removeClass("redBackground");  
					   $("."+errorMessage).hide();
					 
				   }
			   });
			   	names = names.substring(0, names.length - 1);
			   	timetabletemplatesubject.push(names+"/"); 
			 });
		  // alert(timetabletemplatedaystitle);
		  // alert(timetabletemplatehourstitle);
		  // alert(timetabletemplatesubject);
		   if(count == 0)
		   {
			   $("#timeTableDays").val(timetabletemplatedaystitle);
			   $("#timeTableHourSubjects").val(timetabletemplatesubject);
			   $("#timeTableHourTitles").val(timetabletemplatehourstitle);
			 			var data=$("#timeTableGeneratorForm").serialize();
						$.get(ctx+"/timetable/generator/classAndSection",data,function(response){
			 				if($.trim(response)&&response!=null)
			 				{
			 					//alert("Already TimeTable Exist for this Class And Section");
			 					 edumaatAlert({
					    			  title: "Info !",
					    			  text: "Already TimeTable Exist for this Class And Section",
					    			  type: "info",
					    			  confirmButtonText: "Cool"
					    			});
			 				}else
			 				{  
			 					$('#timeTableSaveConfirmation').modal('show');
			 					$('#timeTableSaveConfirm').click(function()
			 						{
			 						 $(".loader").show();
			 						$("#timeTableGeneratorForm").submit();
			 						  });
			 				}
			 			   
			 			   });
				  
				//  window.location.href=ctx+"/timetable/template/generator";
			
		   }
		   else{}
			 
		   
		  
	   });

	  
	   
	 	$('#sectionId').change(function(event) {
	 		
	 		
	 		var data=$("#timeTableGeneratorForm").serialize();
	 		var sectionId = $("#sectionId").val();
	 		if(sectionId!=null){
				
	 			$.get(ctx+"/classSection/classSectionModule",data,function(response){
	 				if($.trim(response)&&response!=null){
	 					var select = $('#moduleId');
	 					var staffselect = $('#staffId');
					   select.find('option').remove();
					   staffselect.find('option').remove();
					   
		        		  $('#moduleId').selectpicker('destroy');
		        		/*  $('#staffId').selectpicker('destroy');*/
					   $.each(response, function(key,value) {
						   
						   
					  		 if(key==0)
					  		 {
					     	    select.append('<option value="" disabled >Select Module And Staff</option>');
					     	  /*  select.append('<option value="Break">Break</option>');
						     	  select.append('<option value="Lunch">Lunch</option>');*/
						     	/* staffselect.append('<option value="" disabled >Select Staff</option>');*/
					     	   }
					  		$('<option id="'+ value.module.moduleId +'">').val(value.module.moduleName+"-"+value.classSectionModuleStaff.staff.firstName).text(value.module.moduleName+"-"+value.classSectionModuleStaff.staff.firstName).appendTo(select);
					  		/*$('<option id="'+ value.classSectionModuleStaff.staff.staffId +'">').val(value.classSectionModuleStaff.staff.firstName+'['+value.classSectionModuleStaff.staff.email+']').text(value.classSectionModuleStaff.staff.firstName+'['+value.classSectionModuleStaff.staff.email+']').appendTo(staffselect);*/
					  	 }); 
					   
					   
					   $('#moduleId').selectpicker('show');
					 /*  $('#staffId').selectpicker('show');*/
	 				}
	 				else
	 				{
	 					var select = $('#moduleId');
						   select.find('option').remove();
						   $('#moduleId').selectpicker('destroy');
						   select.append('<option value="" disabled >Select Module And Staff</option>');
						 /*  select.append('<option value="Break">Break</option>');
					     	  select.append('<option value="Lunch">Lunch</option>');*/
					     	  
					     	  
					     	 $('#moduleId').selectpicker('show');
	 				}
				   });
	 			
	 			}
	 			});
	 	
		$('#generatetimetable').click(function(event) 
		{
			if($("#timeTableGeneratorForm").valid())
			{
			var data=$("#timeTableGeneratorForm").serialize();
			$.get(ctx+"/timetable/generator/class",data,function(response){
 				if($.trim(response)&&response!=null)
 				{
 					//alert("Already TimeTable Exist for this Class And Section");
 					 edumaatAlert({
		    			  title: "Info !",
		    			  text: "Already TimeTable Exist for this Class",
		    			  type: "info",
		    			  confirmButtonText: "Cool"
		    			}).then(function(){
		    				window.location.href=ctx+'/timetable/generator/automatic';
			        		
			        	});
 				}else
 				{  
				$('#timeTableSaveConfirmation').modal('show');
				$('#timeTableSaveConfirm').click(function()
					{
				
					$("#timeTableGeneratorForm").submit();
					  });
 					}
			});
 				}
			
		});
	  
	      $('#printtimetable').click(function () {
	    	    var doc = new jsPDF();
	    	  	  var specialElementHandlers = {
	    	  	      '#editor': function (element, renderer) {
	    	  	          return true;
	    	  	      }
	    	  	  };
			    doc.fromHTML($('#timetableview').html(), 30, 30, {
			        'width': 170,
			            'elementHandlers': specialElementHandlers
			    });
			    doc.save('sample-file1.pdf');
	    	  	});
	      
	      

	     		
});
