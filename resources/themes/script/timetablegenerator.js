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
			   
	   $('#timetabletemplate').change(function(event) {
		   $("#timetableview").empty();  
		   var timeTableTemplateId = $(this).val();
		   
		   var row=0;
		   column=0;
		  if(timeTableTemplateId!=null){
			   
      			   $.ajax({
      				   url:ctx+'/timetable/template/editRetrieve',
      				   data:{timeTableTemplateId:timeTableTemplateId},
      				   type:'GET',
      				   success: function(response)
      				   {
      					 $("#timetablemodule").empty();
      					timetabletemplatedays=[];
      					timetabletemplatehours=[];
      					timetabletemplatehourstitle=[];
      					timetabletemplatedaystitle=[];
      					  table = $('<table id="tbl1" class="table table-bordered table-responsive "style="display:block;overflow-x: auto;"><thead><tr id="th"><th>DAY/HOUR</th></tr></thead><tbody>');
      					
      					   $.each(response.timeTableTemplateDays, function(key,value) 
      	        			{ 
      						 timetabletemplatedays[key]=key;
      						timetabletemplatedaystitle[key]=value.timeTableTemplateDayName;
      						row=row+1;
      						var tr = $('<tr>');
      						$('<td class="text-pink"> '+value.timeTableTemplateDayName+' </td>').appendTo(tr); 
      						   $.each(response.timeTableTemplateHours, function(key1,value1) 
      	      	        			{ 
      							 timetabletemplatehours[key1]=key1;
      							 column=column+1;
      							   		var dynamicid=key+""+key1;
      							  	/*	$("#timetablemodule").append('<div class="form-group">'
      	                  				+'<table class="table table-bordered " style="width:700px;">'
      	                                +'<thead><tr>'
      	                                +'<th>'+value.timeTableTemplateDayName+'</th>'
      	                                +'</tr>'
      	                                +'</thead>'
      	                                +'<tbody>'
      	                                +'<tr id="module">'
      	                                +'<td><div class="form-group" id='+dynamicid+'><label for="" class="col-sm-3 control-label">'+value1.timeTableTemplateHourName+'</label>' 
      	                                +'</div></td>'
      	                                +'</tr>'
      	                                +'</tbody>'
      	                                +'</table>'
    	                                +'</div>'); 
      							 */	   modules(dynamicid);
      							      $('<td class="tdd" id='+dynamicid+"td"+'><label for="'+dynamicid+"label"+'" id="'+dynamicid+"label"+'" required="required" ></label><div class="error'+dynamicid+'" style="color:red"></div></td>').appendTo(tr); 

           					     
           					 });
      						   tr.appendTo(table);
      						
      						
      						});
      						
      					 column=column/row;
      					 $.each(response.timeTableTemplateHours, function(key1,value1) 
 	      	        			{ 
      						 //+"("+value1.timeTableTemplateHourStartTime+"-"+value1.timeTableTemplateHourEndTime+")"
      						 var starttime=value1.timeTableTemplateHourStartTime;
      						starttime=starttime.substring(0,starttime.length - 3);
      						 var endtime=value1.timeTableTemplateHourEndTime;
      						endtime=endtime.substring(0,endtime.length - 3);
      						 		timetabletemplatehourstitle[key1]=starttime+"-"+endtime;
 	      	        			});
    				   
      					 $("#row").show();
      					$("#timetableview").append(table);
      				   $("#th").empty();
      				   $('#th ').append( $('<th />', {text : 'DAY/HOUR'}));
      				for(jk=0;jk<timetabletemplatehourstitle.length;jk++)
      				{
      					$('#th ').append( $('<th />', {text : timetabletemplatehourstitle[jk]}));
      					
      				}
      				   $.each(timetabletemplatedays, function( index, value ) {
      					   
      					   $.each(timetabletemplatehours, function( index1, value1 ) {
      						  
      						   var dynamicid=index+""+index1+"module";
      						   var labelvalue=index+""+index1+"label";
      						   $("label[for="+labelvalue+"]").html($("#"+dynamicid).val());
      						  
      					   });
      					   
      					 });
      				
      				  }
      				 });
		  }
      });    
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
          						$('<td > '+value.timeTableGeneratorDayName+' </td>').appendTo(tr); 
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
             						   $.each(response1, function(key34,value34) {
             						  		 if(key34==0)
             						  		 {
             						     	    select.append('<option value="" disabled selected>Select Module And Staff</option>');
             						     	  select.append('<option value="Break">Break</option>');
             						     	  select.append('<option value="Lunch">Lunch</option>');
             						     	   }
             						  		$('<option id="'+ value34.module.moduleId +'">').val(value34.module.moduleName+"-"+value34.classSectionModuleStaff.staff.firstName).text(value34.module.moduleName+"-"+value34.classSectionModuleStaff.staff.firstName).appendTo(select);
             						  	
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
			  //  $("#timetableview").append(table);
		  /* $("#th").empty();
		   $('#th').append( $('<th />', {text : ''}));
		   for(l=1;l<=column;l++)
			 {
		   		$('#th').append( $('<th />', {text :'Hour '+l}));
			 }*/
		/*   $.each(timetabletemplatedays, function( index, value ) {
			   
			   $.each(timetabletemplatehours, function( index1, value1 ) {
				  
				   var dynamicid=index+""+index1+"module";
				   var labelvalue=index+""+index1+"label";
				   $("label[for="+labelvalue+"]").html($("#"+dynamicid).val());
				  
			   });
			   
			 });
		*/  
		   
		  
	   });
/*	   $('#printtimetable').click(function(event){
		   
		   	
		   var currentclass = $('#class').children(':selected').attr('id');
		   var currentsection = $('#section').children(':selected').attr('id');
		   var currenttimetabletemplate = $('#timetabletemplate').children(':selected').attr('id');
			   	 
		   var divClone = $('<div id="timetableviewclone" class="row" style="display:none;"> '
		 +'<table class="table table-bordered " style="width:700px;">'
          +'<thead><tr>'
          +'<th><h3 class="title1" style="color:blue;">Time Table Generator</h3></th>'
          +'</tr>'
          +'</thead>'
          +'<tbody>'
          +'<tr>'
          +'<td><h4 style="color:red;">Class</h4>' 
          +'</td>'
          +'<td style="color:green;">'
          +''+currentclass
          +'</td>'
          +'</tr>'
          +'<tr>'
          +'<td><h4 style="color:red;">Section</h4>' 
          +'</td>'
          +'<td style="color:green;">'
          +''+currentsection
          +'</td>'
          +'</tr>'
          +'<tr>'
          +'<td><h4 style="color:red;">Time Table Template</h4>' 
          +'</td>'
          +'<td style="color:green;">'
          +''+currenttimetabletemplate
          +'</td>'
          +'</tr>'
          +'</tbody>'
          +'</table>'
          +'  </div>'
          );
		   $("#timetableview").append(divClone);
		   
		   $('#timetableview').clone().appendTo('#timetableviewclone');
		   
		   var divToPrint=document.getElementById('timetableview');

		   var newWin=window.open('','Print-Window');

		   newWin.document.open();

		   newWin.document.write('<html><body onload="window.print()">'+divToPrint.innerHTML+'</body></html>');

		   newWin.document.close();

		   setTimeout(function(){newWin.close();},10);
			
	   });*/
	  
	   
	 	$('#sectionId').change(function(event) {
	 		  $("#timetabletemplate").removeAttr('disabled');
	 		  $('#timetabletemplate').selectpicker('destroy');
	 		  $('#timetabletemplate').selectpicker('show');
	 		
	 		var data=$("#timeTableGeneratorForm").serialize();
	 		var sectionId = $("#sectionId").val();
	 		if(sectionId!=null){
				
	 			$.get(ctx+"/classSection/classSectionModule",data,function(response){
	 				if($.trim(response)&&response!=null){
	 					var select = $('#moduleId');
					   select.find('option').remove();
					   
		        		  $('#moduleId').selectpicker('destroy');
					   $.each(response, function(key,value) {
						   
						   
					  		 if(key==0)
					  		 {
					     	    select.append('<option value="" disabled selected>Select Module And Staff</option>');
					     	   select.append('<option value="Break">Break</option>');
						     	  select.append('<option value="Lunch">Lunch</option>');
					     	   }
					  		$('<option id="'+ value.module.moduleId +'">').val(value.module.moduleName+"-"+value.classSectionModuleStaff.staff.firstName).text(value.module.moduleName+"-"+value.classSectionModuleStaff.staff.firstName).appendTo(select);
					  	 }); 
					   
					   
					   $('#moduleId').selectpicker('show');
	 				}
	 				else
	 				{
	 					var select = $('#moduleId');
						   select.find('option').remove();
						   $('#moduleId').selectpicker('destroy');
						   select.append('<option value="" disabled selected>Select Module And Staff</option>');
						   select.append('<option value="Break">Break</option>');
					     	  select.append('<option value="Lunch">Lunch</option>');
					     	  
					     	  
					     	 $('#moduleId').selectpicker('show');
	 				}
				   });
	 			
	 			}
	 			});
	 	
	   	$('#classId').change(function(event) {
	   	 $("#timetableview").empty();  
	   	
	   	
	  	 	    var classId = $("#classId").val();
		  	    $.ajax({
					   url:ctx+'/classSection/'+classId,
					   type:'GET',
					   success: function(response){
						   var select = $('#sectionId');
						 
						   
						   
						   if(response.length>0)
				        	  {
				        		  select.find('option').remove(); 
				        		  $('#sectionId').selectpicker('destroy');
				        	  }
				        	  else
				        	  {
				        		  select.find('option').remove();
				        		  $('#sectionId').selectpicker('destroy');
				        		  select.append('<option value="" disabled selected>Select Section</option>');
				        	  }
						   
						   
						   
						   $.each(response, function(key,value) {
						  		 if(key==0){
						     	    		select.append('<option value="" disabled selected>Select Section</option>');
						     	    	}
						  		$('<option id="'+ value.sectionClass.sectionId +'">').val(value.sectionClass.sectionId).text(value.sectionClass.sectionName).appendTo(select);
						  	 }); 
						   
						   
						   $('#sectionId').selectpicker('show');
						   
					   },
					   error: function(){
						   alert('ERROR OCCURED');
						   window.location.href=ctx+"/timetable/template/generator";
				       }
					});
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
