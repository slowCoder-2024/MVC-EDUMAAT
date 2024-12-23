 var ctx= window.location.pathname.substring(0, window.location.pathname.indexOf("/",2));
	
$(document).ready(function() {
	var names = $("#classSectionModuleId").val();
	var uniqueNames = [];
	$.each(names, function(i, el){
	    if($.inArray(el, uniqueNames) === -1) uniqueNames.push(el);
	});
	$("#classSectionIds").val(uniqueNames);
	$("#timetableview").empty();  
	   var timetablegeneratorhourstitle = new Array();
	
	var data=$("#timeTableViewForm").serialize();
	$.get(ctx+"/timetable/generator/classSection",data,function(response)
			{
		var tableName="";
			if(response.length>0)
				{
				  $.each(response, function(index,data) 
							  {
					  $("#timetableview").append('<br><h3 class="m-t-0 header-title" style="color:purple;">'+data.classSection.classSection.className+' & '+data.classSection.sectionClass.sectionName+'</h3><br>');
						  var column=0;
						   var table;
						   var timetabletemplatedays = new Array();
						   var timetabletemplatehours = new Array();
						   var timetabletemplatedaystitle = new Array();
						   var timetabletemplatehourstitle = new Array();
						   var timetabletemplatesubject = new Array();
						   //<thead><tr id="th"'+index+'""><th></th></tr></thead>
						   tableName="table1'"+index+"'";
						  table = $('<table id="'+tableName+'" class="table table-bordered" style="display:block;overflow-x: auto;"><thead><tr id="th'+index+'"><th>DAY/HOUR</th></tr></thead><tbody>');
							timetabletemplatehours=[];
							timetabletemplatedaystitle=[];
							timetabletemplatedays=[];
							timetablegeneratorhourstitle=[];
							  var columncount=0; 
								  var rowcount=0;
								  var  timeTableGeneratorDays=[];
									 var  timeTableGeneratorHours=[];
							
       			   $.each(data.timeTableGeneratorDays, function(key,value) 
        	        			{ 
       				timetabletemplatedays[key]=key;
     					timetabletemplatedaystitle[key]=value.timeTableGeneratorDayName;
     					rowcount=rowcount+1;
  	        			
     					var tr = $('<tr>');
						$('<td style="width:200px;font-size:20px;"> '+value.timeTableGeneratorDayName+' </td>').appendTo(tr); 
						   			$.each(value.timeTableGeneratorHours, function(key1,value1) 
						   				{
						   				columncount=columncount+1;
  		       	        				
						   				timetabletemplatehours[key1]=key1;
						   				var dynamicid=key+""+key1;
       				   				var labelvalue=key+""+key1+"label";
       				   			
       				   				$('<td class="edittdd" id='+dynamicid+"td"+index+""+'><label for="'+dynamicid+"label"+index+""+'" id="'+dynamicid+"label"+index+""+'" required="required" ></label><div class="error"'+index+'"'+dynamicid+'" style="color:red"></div></td>').appendTo(tr); 
       				   			
 	      	        			});
       				   	   tr.appendTo(table);
     						
        						});
       			//alert(data.classSection.classSection.className+" "+data.classSection.sectionClass.sectionName);
       			   //<div class="x_title"><div class="clearfix"></div></div>
       			  /* var title=$('<div><h4 class="title1">Class Name : '+data.classSection.classSection.className+' - Section Name : '+data.classSection.sectionClass.sectionName+'</h4></div><br/>');
       			   $("#timetableview").append(title);
       */			$("#timetableview").append(table);
       		    $.each(data.timeTableGeneratorDays, function(key,value) 
  	        			{ 
       			   	$.each(value.timeTableGeneratorHours, function(key1,value1) 
  	        			{
       			   		
       			   	timetablegeneratorhourstitle[key1]=value1.hourTitle;
       			   			var labelvalue=key+""+key1+"label"+index;
       			   			/*var labelv=key+""+key1+"td"+index;
       			   			$("#"+labelv).text(value1.subjectName);*/
				   			$("label[for="+labelvalue+"]").html(value1.subjectName);
 	        			});
       				
  	        			});
       			var uniqueHourNames = [];
       			$.each(timetablegeneratorhourstitle, function(i, el){
           		    if($.inArray(el, uniqueHourNames) === -1) uniqueHourNames.push(el);
           		});
       		 	 $("#th"+index).empty();
    	   		   $('#th'+index).append( $('<th />', {text : 'DAY/HOUR'}));
    	   		   for(l=0;l<uniqueHourNames.length;l++)
    	   			 {
    	   		   		$('#th'+index).append( $('<th />', {text :uniqueHourNames[l]}));
    	   			 }
       		 columncount=columncount/rowcount;
       			
							  });
			    		
				}else
				{
					$(".alert-info").show();
				}
       		 
			var cells = document.getElementsByTagName('td'),
		    colors = ['000000','FF0000','00FF00','0000FF','993399','00FFFF','FF00FF','ff9900','009933'];

		for(var i = 0; i < cells.length; i++) {
		    cells[i].style.color = '#' + colors[Math.floor(Math.random() * colors.length)];
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
		
		//Multiple Selection 
		$(".select2_single").select2({
		    placeholder: "Select a Option",
		    allowClear: true
		});
		$(".select2_group").select2({});
		$(".select2_multiple").select2({
		    maximumSelectionLength:null,
		    placeholder: "click here",
		    allowClear: true
		});

	    	 
});
