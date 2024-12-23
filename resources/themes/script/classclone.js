/* $('#modulesBasedModule,#modulesBasedStaff').selectpicker('show');
*/$(document).ready(function() {
	
	$('#modulesBasedModule,#modulesBasedStaff').selectpicker('show');
	$(document).on("click",".btnadd-modules-based",function(event){
		
		
		var cloneIndex = $(".clonedinputmodulesbased").length;
     	 var newNum =cloneIndex + 1;
     	$('#modulesBasedModule,#modulesBasedStaff').selectpicker('destroy');
        $('.btndel-modules-based:disabled').removeAttr('disabled');
        var c = $('.clonedinputmodulesbased:first').clone(true).attr('id',"clonedinputmodulesbased"+newNum);
        
        c.find('td select').each (function () {
            this.id =this.id+newNum;
            this.name=this.id;
            $(this).selectpicker('show');
        });
        
        $('.clonedinputmodulesbased:last').after(c);
        $('#modulesBasedModule,#modulesBasedStaff').selectpicker('show');
      
    });
    $('.btndel-modules-based').click(function() {
       
            $('.clonedinputmodulesbased:last').remove();
            $('.btndel-modules-based').attr('disabled', ($('.clonedinputmodulesbased').length < 2));
     

		
		
           
            	 
   /*         	 var sectionName=this.id;
            	
         	
            	 
            	 var cloneIndex = $(".clonedinputmodulesbased-"+sectionName).length;
            	 
            	 
            	
              	 var newNum =cloneIndex + 1;
              	 
             
              	 $('#modulesBasedModule,#modulesBasedStaff').selectpicker('destroy');
             	
              	$("#modulesbasedclonepersection"+sectionName).find('.btndel-modules-based:disabled').removeAttr('disabled');
                 var c = $('.clonedinputmodulesbased-'+sectionName+':first').clone().attr('id',"clonedinputmodulesbased-"+sectionName+newNum);
             
                c.find('td select').each (function () {
                     this.id =this.id+newNum;
                     this.name=this.id;
                     $(this).selectpicker('show');
                     
                     
                 });
                
                 $('.clonedinputmodulesbased-'+sectionName+':last').after(c);
                 $('#modulesBasedModule-'+sectionName+newNum+'','#modulesBasedStaff-'+sectionName+newNum+'').selectpicker('show');
               
    */         });
	
	/*$(document).on("click",".btndel-modules-based",function(event){
		 var sectionName=this.name;
            	 
                
                     $('.clonedinputmodulesbased-'+sectionName+':last').remove();
                     $(this).attr('disabled', ($('.clonedinputmodulesbased-'+sectionName+'').length < 2));
                
             });*/
         });

$('#co-scholastic-area').selectpicker('show');
 $(document).ready(function() {
  	
  
       $('.btnadd-co-scholastic-area').click(function() {
    	   
    	   
      	 var cloneIndex = $(".clonedInputCo-Scholastic-Areas").length;
      	
      	 var newNum =cloneIndex + 1;
      	$('#co-scholastic-area').selectpicker('destroy');
           $('.btndel-co-scholastic-area:disabled').removeAttr('disabled');
           var c = $('.clonedInputCo-Scholastic-Areas:first').clone().attr('id',"clonedInputCo-Scholastic-Areas"+newNum);
           
           c.find('td select').each (function () {
        	   this.id =this.id+newNum;
               this.name=this.id;
               $(this).selectpicker('show');
           });
       
           $('.clonedInputCo-Scholastic-Areas:last').after(c);
           $('#co-scholastic-area').selectpicker('show');
       });
       $('.btndel-co-scholastic-area').click(function() {
           
               $('.clonedInputCo-Scholastic-Areas:last').remove();
               $('.btndel-co-scholastic-area').attr('disabled', ($('.clonedInputCo-Scholastic-Areas').length < 2));
          
       });
   });
 $('#coScholasticActivities').selectpicker('show');
 $(document).ready(function() {
       $('.btnadd-co-scholastic-activities').click(function() {
      	 var cloneIndex = $(".clonedinputco-scholastic-activities").length;
      	
      	 var newNum =cloneIndex + 1;
      	$('#coScholasticActivities').selectpicker('destroy');
           $('.btndel-co-scholastic-activities:disabled').removeAttr('disabled');
           var c = $('.clonedinputco-scholastic-activities:first').clone().attr('id',"clonedinputco-scholastic-activities"+newNum);
           
           c.find('td select').each (function () {
        	   this.id =this.id+newNum;
               this.name=this.id;
               $(this).selectpicker('show');
           });
          
           $('.clonedinputco-scholastic-activities:last').after(c);
           $('#coScholasticActivities').selectpicker('show');
       });
       $('.btndel-co-scholastic-activities').click(function() {
           
            
               $('.clonedinputco-scholastic-activities:last').remove();
               $('.btndel-co-scholastic-activities').attr('disabled', ($('.clonedinputco-scholastic-activities').length < 2));
          
       });
   });
 
 $('#module-and-skill-based-module,#module-and-skill-based-skill,#module-and-skill-based-staff').selectpicker('show');
 $(document).ready(function() {
	 

     
       $('.btnadd-module-and-skill-based').click(function() {
      	 var cloneIndex = $(".clonedinput-module-and-skill-based").length;
      	 
      	 var newNum =cloneIndex + 1;
      	$('#module-and-skill-based-module,#module-and-skill-based-skill,#module-and-skill-based-staff').selectpicker('destroy');
           $('.btndel-module-and-skill-based:disabled').removeAttr('disabled');
           var c = $('.clonedinput-module-and-skill-based:first').clone().attr('id',"clonedinput-module-and-skill-based"+newNum);
           c.find('td select').each (function () {
        	   this.id =this.id+newNum;
               this.name=this.id;
               $(this).selectpicker('show');
         });
           
           $('.clonedinput-module-and-skill-based:last').after(c);
           $('#module-and-skill-based-module,#module-and-skill-based-skill,#module-and-skill-based-staff').selectpicker('show');
       });
       $('.btndel-module-and-skill-based').click(function() {
         
               
               $('.clonedinput-module-and-skill-based:last').remove();
               $('.btndel-module-and-skill-based').attr('disabled', ($('.clonedinput-module-and-skill-based').length < 2));
         
       });
   });
 /*$(document).ready(function() {
     var inputs=1;
       $('.btnadd-exam-activity').click(function() {
      	 var cloneIndex = $(".clonedinput-exam-activity").length;
      	 ++inputs;
      	 var newNum =cloneIndex + 1;
           $('.btndel-exam-activity:disabled').removeAttr('disabled');
           var c = $('.clonedinput-exam-activity:first').clone(true).attr('id',"clonedinput-exam-activity"+"-"+inputs);
           c.find('td input').each (function (i) {
        	   this.id =this.id+"-"+ (newNum*2 + i);
               this.name=this.id;
         });
           
           $('.clonedinput-exam-activity:last').after(c);
       });
       $('.btndel-exam-activity').click(function() {
           if (confirm('Are You Sure?')) {
               --inputs;
               $(this).closest('.clonedinput-exam-activity').remove();
               $('.btndel-exam-activity').attr('disabled', ($('.clonedinput-exam-activity').length < 2));
           }
       });
   });*/