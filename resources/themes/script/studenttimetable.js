 var ctx= window.location.pathname.substring(0, window.location.pathname.indexOf("/",2));
	
$(document).ready(function() {
	$("#timetableview").empty();  
	   var timetablegeneratorhourstitle = new Array();
	var data=$("#timeTableViewForm").serialize();
	$.get(ctx+"/timetable/generator/classAndSection",data,function(response){
			 var  timeTableGeneratorDays=[];
				 var  timeTableGeneratorHours=[];
				 /*<thead><tr id="th"><th></th></tr></thead>*/
			 	  table = $('<table id="table1" class="table table-bordered" style="display:block;overflow-x: auto;"><thead><tr id="th"><th>DAY/HOUR</th></tr></thead><tbody>');
			 	timetabletemplatehours=[];
				timetabletemplatedaystitle=[];
				timetabletemplatedays=[];
				timetablegeneratorhourstitle=[];
				  var columncount=0; 
					  var rowcount=0;
				if(response.timeTableGeneratorDays)	
					{
       			   $.each(response.timeTableGeneratorDays, function(key,value) 
        	        			{ 
       				timetabletemplatedays[key]=key;
     					timetabletemplatedaystitle[key]=value.timeTableGeneratorDayName;
     					rowcount=rowcount+1;
  	        			
     					var tr = $('<tr>');
						$('<td style="width:200px;font-size:20px;">'+value.timeTableGeneratorDayName+'</td>').appendTo(tr); 
						   			$.each(value.timeTableGeneratorHours, function(key1,value1) 
 	      	        			{
						   				columncount=columncount+1;
  		       	        				
						   				timetabletemplatehours[key1]=key1;
						   				var dynamicid=key+""+key1;
       				   				var labelvalue=key+""+key1+"label";
       				   				
       				   				$('<td class="edittdd" id='+dynamicid+"td"+'><label for="'+dynamicid+"label"+'" id="'+dynamicid+"label"+'" required="required" ></label><div class="error'+dynamicid+' " style="color:red"></div></td>').appendTo(tr); 
       				   			
 	      	        			});
       				   	   tr.appendTo(table);
     						
        						});
       			$("#timetableview").append(table);
       		   $.each(response.timeTableGeneratorDays, function(key,value) 
  	        			{ 
       			   	$.each(value.timeTableGeneratorHours, function(key1,value1) 
  	        			{
       			   	timetablegeneratorhourstitle[key1]=value1.hourTitle;
       			   			var labelvalue=key+""+key1+"label";
				   			$("label[for="+labelvalue+"]").html(value1.subjectName);
 	        			});
       				
  	        			});
       		   
       		var uniqueHourNames = [];
       		$.each(timetablegeneratorhourstitle, function(i, el){
       		    if($.inArray(el, uniqueHourNames) === -1) uniqueHourNames.push(el);
       		});
       	 $("#th").empty();
	   		   $('#th').append( $('<th />', {text : 'DAY/HOUR'}));
	   		   for(l=0;l<uniqueHourNames.length;l++)
	   			 {
	   		   		$('#th').append( $('<th />', {text :uniqueHourNames[l]}));
	   			 }
       		// columncount=columncount/rowcount;
	   		
	   		
       		var table = $("tbody");
       		var rows = table.find($("tr"));
       		var colsLength = $(rows[0]).find($("td")).length;
       		var removeLater = new Array();
       		for(var i=0; i<colsLength; i++){
       		    var startIndex = 0;
       		    var lastIndex = 0;
       		    var startText = $($(rows[0]).find("td")[i]).text();
       		   for(var j=1; j<rows.length; j++){
       		        var cRow =$(rows[j]);
       		        var cCol = $(cRow.find("td")[i]);
       		        var currentText = cCol.text();
       		        if(currentText==startText){
       		            cCol.css("background","gray");
       		           // console.log(cCol);
       		            removeLater.push(cCol);
       		            lastIndex=j;
       		        }else{
       		            var spanLength = lastIndex-startIndex;
       		            if(spanLength>=1){
       		               // console.log(lastIndex+" - "+startIndex)
       		                //console.log($($(rows[startIndex]).find("td")[i]))
       		                $($(rows[startIndex]).find("td")[i]).attr("rowspan",spanLength+1);
       		            }
       		            lastIndex = j;
       		            startIndex = j;
       		            startText = currentText;
       		        }
       		            
       		    }
       		    var spanLength = lastIndex-startIndex;
       		            if(spanLength>=1){
       		              //  console.log(lastIndex+" - "+startIndex)
       		                //console.log($($(rows[startIndex]).find("td")[i]))
       		                $($(rows[startIndex]).find("td")[i]).attr("rowspan",spanLength+1);
       		            }
       			}

       		for(var i in removeLater){
       		    $(removeLater[i]).remove();
       		}
					}else
					{
						$(".alert-info").show();
					}
	        		/* $("#th").empty();
	   		   $('#th').append( $('<th />', {text : ''}));
	   		   for(l=1;l<=columncount;l++)
	   			 {
	   		   		$('#th').append( $('<th />', {text :l}));
	   			 }*/
				var cells = document.getElementsByTagName('td'),
				colors = ['5fbeaa','5d9cec','fb6d9d','34d3eb','ffbd4a','7266ba','4c5667','f05050','61a9dc','ebeff2','fb6d9d'];

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
	    	 
});
