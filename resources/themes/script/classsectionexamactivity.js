

$(document).ready(function() {	
	 var ctx= window.location.pathname.substring(0, window.location.pathname.indexOf("/",2));
	 
	 $('#savetermandassessmenttypeexamactivityform').validate({
		 
		 ignore: [],
	 		 errorPlacement: function ($error, $element) {
	             var name = $element.attr("name");   	             
	 	             $("#error" + name).append($error);
	         },    
	 
	 
	});
	
	 
	 
	 
	 
	$('#classlistswithoutexamconfig').on( 'click', 'tr td a#examconfiguration', function () {
		 var classId = $(this).attr('data-id');
		 $("#classId").val(classId);
				   $.ajax({
					   url:ctx+'/classSection/'+classId,
					   type:'GET',
					   success: function(response)
					   {
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
						  		$('<option>').val(value.sectionClass.sectionId).text(value.sectionClass.sectionName).appendTo(select);
						  	 });
						   $('#sectionId').selectpicker('show');
						   var assSelect = $('#assessmentSectionId');
						   assSelect.find('option').remove();
						   if(response.length>0)
				        	  {
							   assSelect.find('option').remove(); 
				        		  $('#assessmentSectionId').selectpicker('destroy');
				        	  }
				        	  else
				        	  {
				        		  assSelect.find('option').remove();
				        		  $('#assessmentSectionId').selectpicker('destroy');
				        		  assSelect.append('<option value="" disabled selected>Select Section</option>');
				        	  }
						   $.each(response, function(key,value) {
							
						  		 if(key==0){
						  			assSelect.append('<option value="" disabled selected>Select Section</option>');
						     	    	}
						  		$('<option>').val(value.sectionClass.sectionId).text(value.sectionClass.sectionName).appendTo(assSelect);
						  	 });
						   $('#assessmentSectionId').selectpicker('show');
					   },
				   		error: function(){
				   			alert('ERROR OCCURED');
				   			window.location.href=ctx+"/class";
				   		}
					  });
				   
		$("#sectionId").change(function() {
			 var classId = $("#classId").val();
			 var sectionId = $("#sectionId").val();
			 
			 
			 //term exam activity
			 
		    $.get(ctx+'/classSection/termAndExam', {
				 classId   : classId,
				 sectionId : sectionId
	        },function(response){
	        	$("#term-exam-activity-dynamic-div").empty();
	        	var i=0;
	        	$.each(response,function(key,index){
	        		i=++i;
        			$("#modules-based-evaluation-period,#module-and-skill-based-evaluation-period,#co-scholastic-area-evalution-period,#co-scholastic-activities-evaluation-period").append('<option value='+index.classSectionTermExamId+'>'+index.classSectionTermExamName+'</option>')

	        	$('#term-exam-activity-dynamic-div').append('<h3 class="m-t-0 header-title" style="color:#dd8433;">'+index.classSectionTermExamName+'</h3>'
	        			+'<div class="tables tableRow'+i+'">'
                        /*+' <button  style="float:right" type="button" id="Row'+i+'"class="btn btn-success btnadd-exam-activity"><i class="fa fa-plus-circle" aria-hidden="true"></i></button>'
                        +'<button style="float:right" id="Row'+i+'" type="button" class="btn btn-danger  btndel-exam-activity" disabled="disabled"><i class="fa fa-times-circle" aria-hidden="true"></i></button>'
                       */
	                     +'<table class="table table-striped table-bordered">'
	                     +'<thead><tr><th>Exam Activity Name</th><th>Maximum Marks</th></tr></thead>'
	                     +'<tbody class="exactada">'
	                     +'<tr class="clonedinput-exam-activityRowforfirst'+i+'"><td style="display:none">'+index.classSectionTermExamId+'</td><td><div class="col-sm-12"> <input type="text" name="activityNameRowforfirst'+i+'" class="form-control form-control-termexamactivity" id="activityNameRowforfirst'+i+'" required="required" maxlength="50"></div></td><td><div class="col-sm-12"> <input type="text" name="maximumMarksRowforfirst'+i+'" class="form-control form-control-termexamactivity" id="maximumMarksRowforfirst'+i+'" required="required" maxlength="50" onkeypress="return isNumber(event)"></div></td></tr>'  
	                     +'</tbody>'
	                     +'</table>'
	                     
	                     +'</div> '   
          );
	        	
	        
	        	  });
	        });
			
			///assessmenttypeexamactivity
		    $("#modulesbaseddata,#moduleandskillbaseddata,#coscholasticareadata,#coscholasticactivitydata").empty();
		    $.get(ctx+'/classSection/classSectionAssessmentTypeWithExamActivity', {
				 classId   : classId,
				 sectionId : sectionId
	        },function(response){
	        
	        	 var i=0,j=0,k=0,l=0;
	        	
	        	 if(response.ModulesBased!==undefined){

  	        		$("#assessmenttype-moduleandskillbased-exam-activity-dynamic-div").hide();
	        			$("#assessmenttype-coscholasticactivity-exam-activity-dynamic-div").hide();
	        			$("#assessmenttype-coscholasticarea-exam-activity-dynamic-div").hide();
	        		 //ModulesBased
	        		 $("#assessmenttype-modulesbased-exam-activity-dynamic-div").append('<input type="hidden" id="assessmentTypeModulesBasedExamActivityDetails" name="assessmentTypeModulesBasedExamActivityDetails">');
	     	        $.each(response.ModulesBased,function(key,index){
	     	        	i=++i;
	     	       	     $("#assessmenttype-modulesbased-exam-activity-dynamic-div").show();
	     	        	$('#modulesbaseddata').append('<tr class=""><td style="display:none">'+index.classSectionModuleId+'</td><td>'+index.module.moduleName+'</td><td><div class="col-sm-12"><select name="modules-based-evaluation-period'+i+'" id="modules-based-evaluation-period'+i+'" multiple class="form-control modules-based-evaluation-period form-control-assessmenttypeexaxty" data-live-search="true"  data-style="btn-white" required="required"></div></td></tr>');  	
	     	        });
	        	 }
	       
	        	 
	        	 if(response.ModuleAndSkillBased!==undefined){
	        		 $("#assessmenttype-modulesbased-exam-activity-dynamic-div").hide();
	        			$("#assessmenttype-coscholasticactivity-exam-activity-dynamic-div").hide();
	        			$("#assessmenttype-coscholasticarea-exam-activity-dynamic-div").hide();
	        	
	        		 //ModuleAndSkillBased
	        		 $("#assessmenttype-moduleandskillbased-exam-activity-dynamic-div").append('<input type="hidden" id="assessmentTypeModuleAndSkillBasedExamActivityDetails" name="assessmentTypeModuleAndSkillBasedExamActivityDetails">');
	     	        $.each(response.ModuleAndSkillBased,function(key,index){
	     	        	j=++j;
	     	        	$.each(index.classSectionModuleSkills,function(key,index1){
	     	        	
	     	        		$("#assessmenttype-moduleandskillbased-exam-activity-dynamic-div").show();
		     	        	$('#moduleandskillbaseddata').append('<tr class=""><td style="display:none">'+index1.classSectionModuleSkillId+'</td><td>'+index.module.moduleName+'<span class="text-info">('+index1.moduleSkill.moduleSkillName+')</span></td><td><div class="col-sm-12"> <select name="module-and-skill-based-evaluation-period'+j+'" multiple id="module-and-skill-based-evaluation-period'+j+'" class="form-control module-and-skill-based-evaluation-period form-control-assessmenttypeexaxty" data-live-search="true"  data-style="btn-white" required="required"></div></td></tr>');  	

	     	        	});
	     	        	
	     	        	
	     	        });
	        		 
	        	 }
	        	 
	        	 if(response.CoScholasticArea!==undefined){
	        		 $("#assessmenttype-modulesbased-exam-activity-dynamic-div").hide();
	        			$("#assessmenttype-coscholasticactivity-exam-activity-dynamic-div").hide();
	        		 $("#assessmenttype-moduleandskillbased-exam-activity-dynamic-div").hide();
	        	     
	        		//CoScholasticArea
	        		 $("#assessmenttype-coscholasticarea-exam-activity-dynamic-div").append('<input type="hidden" id="assessmentTypeCoScholasticAreaExamActivityDetails" name="assessmentTypeCoScholasticAreaExamActivityDetails">');
	     	        $.each(response.CoScholasticArea,function(key,index){
	     	           k=++k;
	     	        	$("#assessmenttype-coscholasticarea-exam-activity-dynamic-div").show();
	     	        	$('#coscholasticareadata').append('<tr class=""><td style="display:none">'+index.classSectionCosScholasticAreaId+'</td><td>'+index.coScholasticArea.coScholasticAreaName+'</td><td><div class="col-sm-12"><select name="co-scholastic-area-evalution-period'+k+'" multiple id="co-scholastic-area-evalution-period'+k+'" class="form-control co-scholastic-area-evalution-period form-control-assessmenttypeexaxty" data-live-search="true"  data-style="btn-white" required="required"></div></td></tr>');  	
                       
	     	        });
	     	        
	     	      
	        	 }
	        	 if(response.CoScholasticActivity!==undefined){
	        		 $("#assessmenttype-modulesbased-exam-activity-dynamic-div").hide();
	        		 $("#assessmenttype-coscholasticarea-exam-activity-dynamic-div").hide();
	        		 $("#assessmenttype-moduleandskillbased-exam-activity-dynamic-div").hide();
	        		  //CoScholasticActivity
	        		 $("#assessmenttype-coscholasticactivity-exam-activity-dynamic-div").append('<input type="hidden" id="assessmentTypeCoScholasticActivityExamActivityDetails" name="assessmentTypeCoScholasticActivityExamActivityDetails">');
	     	        $.each(response.CoScholasticActivity,function(key,index){
	     	        	  l=++l;
	     	        	$("#assessmenttype-coscholasticactivity-exam-activity-dynamic-div").show();
	     	        	$('#coscholasticactivitydata').append('<tr class=""><td style="display:none">'+index.classSectionCosScholasticActivityId+'</td><td>'+index.coScholasticActivity.coScholasticActivityName+'</td><td><div class="col-sm-12"><select multiple name="co-scholastic-activities-evaluation-period'+l+'" id="co-scholastic-activities-evaluation-period'+l+'" class="form-control co-scholastic-activities-evaluation-period form-control-assessmenttypeexaxty" data-live-search="true"  data-style="btn-white" required="required"></div></td></tr>');  	

	     	        });
	     	         
	        	
	        	 }
	       
	        	  $.get(ctx+'/classSection/termAndExam', {
		 				 classId   : classId,
		 				 sectionId : sectionId
		 	        },function(response1){
		 	        	$.each(response1,function(key,index){
		 	        		
		        			$(".modules-based-evaluation-period,.module-and-skill-based-evaluation-period,.co-scholastic-area-evalution-period,.co-scholastic-activities-evaluation-period").append('<option value='+index.classSectionTermExamId+'>'+index.classSectionTermExamName+'</option>');

		 	        	
		 	        	
		 	        
		 	        	  });
		 	        	$('.modules-based-evaluation-period,.module-and-skill-based-evaluation-period,.co-scholastic-area-evalution-period,.co-scholastic-activities-evaluation-period').selectpicker('refresh');
		 	        	 
		 	        });
	        
	      
	        });
		});		
		

	
		////dynamic row in each term exam activity
		 
   	 $(document).on("click",".btnadd-exam-activity",function(event){
   		 var examActivityAddRowId=this.id;
   		
   		 var cloneIndex = $(".clonedinput-exam-activity"+examActivityAddRowId).length;
   		
   		 var newNum =cloneIndex+1;
   		$(".table"+examActivityAddRowId).find('.btndel-exam-activity:disabled').removeAttr('disabled');
   		
              var c = $('.clonedinput-exam-activity'+examActivityAddRowId+':first').clone(true);
              c.find('td input').each (function () {
           	   this.id =this.id+"-"+newNum;
                  this.name=this.id;
            });
              $('.clonedinput-exam-activity'+examActivityAddRowId+':last').after(c);
             
         });   
   	 $(document).on("click",".btndel-exam-activity",function(event){
   	  var examActivityDelRowId=this.id;
             $('.clonedinput-exam-activity'+examActivityDelRowId+':last').remove();
             $(".table"+examActivityDelRowId).find('.btndel-exam-activity').attr('disabled', ($('.clonedinput-exam-activity'+examActivityDelRowId+'').length < 2)); 
     });
	});
	

	
	
	
	$("#savetermexamandassessmenttypeexamactivity").click(function() {
	
	
	
		if($("#savetermandassessmenttypeexamactivityform").valid()){
			
			
			
			var termexamactivitydetails= [];
			$('tbody.exactada tr').each(function () {
				var $tds = $(this).find('td');
				var data1=$tds.eq(0).text()
				var data2=$tds.eq(1).find('input').val();
				var data3=$tds.eq(2).find('input').val();
				termexamactivitydetails.push(data1+"-"+data2+"-"+data3);
		            });
			$("#termExamActivityDetails").val(termexamactivitydetails);
			
			
				
			
		  		
		
		
		
		
		
			
			
			
		//assessmenttypemodulesbasedexamactivity
		var assessmenttypemodulesbasedexamactivitydetails= [];
		$('tbody.assmbexactada tr').each(function () {
			var $tds = $(this).find('td');
			var data1=$tds.eq(0).text()
			var data2=$tds.eq(2).find("select").val().join('&');
			assessmenttypemodulesbasedexamactivitydetails.push(data1+"-"+data2);
	            });
		
		
		
		$("#assessmentTypeModulesBasedExamActivityDetails").val(assessmenttypemodulesbasedexamactivitydetails);
		//assessmenttypemoduleandskillbasedexamactivity
		var assessmenttypemoduleandskillbasedexamactivitydetails= [];
		$('tbody.assmsbexactada tr').each(function () {
			var $tds = $(this).find('td');
			var data1=$tds.eq(0).text()
			var data2=$tds.eq(2).find('select').val().join('&');
			assessmenttypemoduleandskillbasedexamactivitydetails.push(data1+"-"+data2);
	            });
		$("#assessmentTypeModuleAndSkillBasedExamActivityDetails").val(assessmenttypemoduleandskillbasedexamactivitydetails);
	
		//assessmenttypeco-scholasticareaexamactivity
		var assessmenttypecoscholasticareaexamactivitydetails= [];
		$('tbody.asscosareaexactada tr').each(function () {
			var $tds = $(this).find('td');
			var data1=$tds.eq(0).text()
			var data2=$tds.eq(2).find('select').val().join('&');
			assessmenttypecoscholasticareaexamactivitydetails.push(data1+"-"+data2);
	            });
		$("#assessmentTypeCoScholasticAreaExamActivityDetails").val(assessmenttypecoscholasticareaexamactivitydetails);
		//assessmenttypeco-scholasticactivityexamactivity
		var assessmenttypecoscholasticactivityexamactivitydetails= [];
		$('tbody.asscosactivityexactada tr').each(function () {
			var $tds = $(this).find('td');
			var data1=$tds.eq(0).text()
			var data2=$tds.eq(2).find('select').val().join('&');
			assessmenttypecoscholasticactivityexamactivitydetails.push(data1+"-"+data2);
	            });

		$("#assessmentTypeCoScholasticActivityExamActivityDetails").val(assessmenttypecoscholasticactivityexamactivitydetails);
		$("#classsectiontermexamandassessmenttypeexamactivitysaveconfirmation").modal('show');
		$("#classsectiontermexamandassessmenttypeexamactivitysaveconfirm").click(function(event){
			$("#savetermandassessmenttypeexamactivityform").submit();
	});
			
			
			
			
			
			
			
			
			
			
			
			
			
	
		
		}
	
	
	
	
	
	
	
	
	
	
	
	});	
	
	
	
	
	
	
	
	
});