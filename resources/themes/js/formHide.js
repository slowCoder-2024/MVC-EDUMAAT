function showDiv(){
	
	  $(".form-horizontal").trigger('reset'); 
		if(document.getElementById('ListDiv').style.display=="block"){
	  
		document.getElementById('FormDiv').style.display="block";
		document.getElementById('ListDiv').style.display="none";
	}
	else{
		document.getElementById('FormDiv').style.display="none";
		document.getElementById('ListDiv').style.display="block";
		
		 
	    // let the browser natively reset defaults
	
	}	
}
function showConfigurationDiv(){
	if(document.getElementById('examconfigurationdiv').style.display="none"){
		document.getElementById('examconfigurationdiv').style.display="block";
	document.getElementById('ListDiv').style.display="none";
}

}


function showeditDiv(){
	if(document.getElementById('EditFormDiv').style.display=="none")
	{
	document.getElementById('EditFormDiv').style.display="block";
	document.getElementById('ListDiv').style.display="none";
}
else{
	document.getElementById('EditFormDiv').style.display="none";
	document.getElementById('ListDiv').style.display="block";
}
}
function showmultieditDiv(){
	if(document.getElementById('multiEditFormDiv').style.display=="none")
	{
	
	document.getElementById('ListDiv').style.display="none";
}
else{
	document.getElementById('multiEditFormDiv').style.display="none";
	document.getElementById('ListDiv').style.display="block";
}
}
function showopenDiv(){
	if(document.getElementById('OpenFormDiv').style.display=="none"){
	document.getElementById('OpenFormDiv').style.display="block";
	document.getElementById('ListDiv').style.display="none";
}
else{
	document.getElementById('OpenFormDiv').style.display="none";
	document.getElementById('ListDiv').style.display="block";
}
}

function cmDiv(){
	if(document.getElementById('candmDiv').style.display=="none"){
	document.getElementById('candmDiv').style.display="block";
	document.getElementById('ListDiv').style.display="none";
}
else{
	document.getElementById('candmDiv').style.display="none";
	document.getElementById('ListDiv').style.display="block";
}

}
function labsDiv(){
	if(document.getElementById('labsDiv').style.display=="none"){
	document.getElementById('labsDiv').style.display="block";
	document.getElementById('ListDiv').style.display="none";
}
else{
	document.getElementById('labsDiv').style.display="block";
	document.getElementById('ListDiv').style.display="none";
}

}
function lessonsDiv(){
	if(document.getElementById('lessonsDiv').style.display=="none"){
	document.getElementById('lessonsDiv').style.display="block";
	document.getElementById('ListDiv').style.display="none";
}
else{
	document.getElementById('lessonsDiv').style.display="none";
	document.getElementById('ListDiv').style.display="block";
}

}
function assignmentsDiv(){
	if(document.getElementById('assignmentDiv').style.display=="none"){
	document.getElementById('assignmentDiv').style.display="block";
	document.getElementById('ListDiv').style.display="none";
}
else{
	document.getElementById('assignmentDiv').style.display="none";
	document.getElementById('ListDiv').style.display="block";
}

}
function outstandingDiv(){
	if(document.getElementById('outstandingDiv').style.display=="none"){
	document.getElementById('outstandingDiv').style.display="block";
	document.getElementById('ListDiv').style.display="none";
}
else{
	document.getElementById('outstandingDiv').style.display="none";
	document.getElementById('ListDiv').style.display="block";
}

}
function notificationsDiv(){
	if(document.getElementById('notificationsDiv').style.display=="none"){
	document.getElementById('notificationsDiv').style.display="block";
	document.getElementById('ListDiv').style.display="none";
}
else{
	document.getElementById('notificationsDiv').style.display="none";
	document.getElementById('ListDiv').style.display="block";
}

}
function showsetupDiv(){
	if(document.getElementById('SetupDiv').style.display=="none"){
	document.getElementById('SetupDiv').style.display="block";
	document.getElementById('ListDiv').style.display="none";
}
else{
	document.getElementById('SetupDiv').style.display="none";
	document.getElementById('ListDiv').style.display="block";
}
}
function showsemestersystemDiv(){
	if(document.getElementById('semestersystemDiv').style.display=="none"){
	document.getElementById('semestersystemDiv').style.display="block";
	document.getElementById('ListDiv').style.display="none";
}
else{
	document.getElementById('semestersystemDiv').style.display="none";
	document.getElementById('ListDiv').style.display="block";
}
}

function showSignUpForm(){
	if(document.getElementById('FormDiv').style.display=="none"){
	document.getElementById('FormDiv').style.display="block";
	document.getElementById('ListDiv').style.display="none";
	}
else{
	document.getElementById('FormDiv').style.display="none";
	document.getElementById('ListDiv').style.display="block";
}
}


//signup and forgot password

function showSignUpForm(){
	if(document.getElementById('FormDiv').style.display=="none"){
	document.getElementById('FormDiv').style.display="block";
	document.getElementById('ListDiv').style.display="none";
	}
else{
	document.getElementById('FormDiv').style.display="none";
	document.getElementById('ListDiv').style.display="block";
}
}

function showForgotForm(){
	if(document.getElementById('ForgotFormDiv').style.display=="none"){
		document.getElementById('FormDiv').style.display="none";
		document.getElementById('ListDiv').style.display="none";
		document.getElementById('ForgotFormDiv').style.display="block";
		}
	else{
		document.getElementById('FormDiv').style.display="none";
		document.getElementById('ListDiv').style.display="block";
		document.getElementById('ForgotFormDiv').style.display="none";
	}
}


/////class and section script

function showClassAndSectionDiv(){
	if(document.getElementById('classAndSectionDiv').style.display=="none"){
	document.getElementById('classAndSectionDiv').style.display="block";
	document.getElementById('ListDiv').style.display="none";
}
else{
	document.getElementById('classAndSectionDiv').style.display="none";
	document.getElementById('ListDiv').style.display="block";
}
}
function showeditsectionDiv(){
	if(document.getElementById('EditSectionFormDiv').style.display=="none")
	{
	document.getElementById('EditSectionFormDiv').style.display="block";
	document.getElementById('ListDiv').style.display="none";
	
	document.getElementById('classAndSectionDiv').style.display="none";
	
	
}

}
function showeditclassandsectionDiv(){
	if(document.getElementById('EditClassFormDiv').style.display=="none")
	{
	document.getElementById('EditClassFormDiv').style.display="block";
	document.getElementById('ListDiv').style.display="none";
	
	document.getElementById('classAndSectionDiv').style.display="none";

	
}

}


//Exam Management
function showExamTemplateDiv()
{
	if(document.getElementById('ExamTemplateDiv').style.display=="none")
	{
		document.getElementById('ExamTemplateDiv').style.display="block";
		document.getElementById('EditExamTemplateDiv').style.display="none";
		document.getElementById('ListDiv').style.display="none";
	}
}

function editExamTemplateDiv()
{
	if(document.getElementById('EditExamTemplateDiv').style.display=="none")
	{
		document.getElementById('EditExamTemplateDiv').style.display="block";
		document.getElementById('ExamTemplateDiv').style.display="none";
		document.getElementById('ListDiv').style.display="none";
	}
}

//Grade System
function showGradeSystemDiv()
{
	if(document.getElementById('GradeSystemDiv').style.display=="none")
	{
		document.getElementById('GradeSystemDiv').style.display="block";
		document.getElementById('EditGradeSystemDiv').style.display="none";
		document.getElementById('ListDiv').style.display="none";
	}
}

function editGradeSystemDiv()
{
	if(document.getElementById('EditGradeSystemDiv').style.display=="none")
	{
		document.getElementById('EditGradeSystemDiv').style.display="block";
		document.getElementById('GradeSystemDiv').style.display="none";
		document.getElementById('ListDiv').style.display="none";
	}
}

//TimeTableTemplate

function showTimeTableTemplateDiv()
{
	if(document.getElementById('TimeTableTemplateDiv').style.display=="none")
	{
		document.getElementById('TimeTableTemplateDiv').style.display="block";
		document.getElementById('EditTimeTableTemplateDiv').style.display="none";
		document.getElementById('ListDiv').style.display="none";
	}
}

function editTimeTableTemplateDiv()
{
	if(document.getElementById('EditTimeTableTemplateDiv').style.display=="none")
	{
		document.getElementById('EditTimeTableTemplateDiv').style.display="block";
		document.getElementById('TimeTableTemplateDiv').style.display="none";
		document.getElementById('ListDiv').style.display="none";
	}
}
//TimeTableGenerator
function showTimeTableGeneratorDiv()
{
	if(document.getElementById('TimeTableGeneratorDiv').style.display=="none")
	{
		document.getElementById('TimeTableGeneratorDiv').style.display="block";
		document.getElementById('EditTimeTableGeneratorDiv').style.display="none";
		document.getElementById('ListDiv').style.display="none";
	}
}

function editTimeTableGeneratorDiv()
{
	if(document.getElementById('EditTimeTableGeneratorDiv').style.display=="none")
	{
		document.getElementById('EditTimeTableGeneratorDiv').style.display="block";
		document.getElementById('TimeTableGeneratorDiv').style.display="none";
		document.getElementById('ListDiv').style.display="none";
	}
}
///FCR
function showpaymentDiv(){
	if(document.getElementById('PaymentFormDiv').style.display=="none"){
	document.getElementById('PaymentFormDiv').style.display="block";
	document.getElementById('ListDiv').style.display="none";
	document.getElementById('feesItemFormDiv').style.display="none";
	document.getElementById('FormDiv').style.display="none";
	
	}

}
///result system
function showemarkuploadDiv(){
	if(document.getElementById('Markupload').style.display=="none")
	{
	document.getElementById('Markupload').style.display="block";
	document.getElementById('ListDiv').style.display="none";
}

}

function showresultreportDiv(){
	if(document.getElementById('Resultreport').style.display=="none")
	{
	document.getElementById('Resultreport').style.display="block";
	document.getElementById('ListDiv').style.display="none";
}

}
function showGeneratorRepotCardDiv(){
	if(document.getElementById('generatereportcard').style.display=="none")
	{
	document.getElementById('generatereportcard').style.display="block";
	document.getElementById('ListDiv').style.display="none";
}

}

function showDisplayReportCardDiv(){
	if(document.getElementById('displayreportcard').style.display=="none")
	{
	document.getElementById('displayreportcard').style.display="block";
	document.getElementById('ListDiv').style.display="none";
}

}
function showreportDiv(){
	if(document.getElementById('displayreportcard').style.display=="block")
	{
	document.getElementById('displayreportcard').style.display="none";
	document.getElementById('viewreportcard').style.display="block";
}

}
function showbackreportcarddiv(){
	if(document.getElementById('generatereportcard').style.display=="block")
	{
	document.getElementById('generatereportcard').style.display="none";
	document.getElementById('ListDiv').style.display="block";
}

}
function showBackDisReportCardDiv(){
	if(document.getElementById('viewreportcard').style.display=="block")
	{
	document.getElementById('viewreportcard').style.display="none";
	document.getElementById('displayreportcard').style.display="block";
}

}




function showBackMarkAndGradeCardDiv(){
	if(document.getElementById('Markupload').style.display=="block")
	{
		
	
		document.getElementById('Markupload').style.display="none";
	document.getElementById('ListDiv').style.display="block";
}

}

//FeesTemplateItem
function showFeesTemplateItemDiv()
{
	if(document.getElementById('listFeesTemplateItem').style.display=="none")
	{
		document.getElementById('listFeesTemplateItem').style.display="block";
		document.getElementById('ListDiv').style.display="none";
		
	}
}

function backtodiv()
{
	if(document.getElementById('secondstep').style.display=="block")
	{
		document.getElementById('firststep').style.display="block";
		document.getElementById('secondstep').style.display="none";
		
	}
}
function showeditFeesTemplateItemDiv()
{
	if(document.getElementById('ListDiv').style.display=="none")
	{
		document.getElementById('ListDiv').style.display="block";
		document.getElementById('listFeesTemplateItem').style.display="none";
		document.getElementById('listFineDetails').style.display="none";
	}
}