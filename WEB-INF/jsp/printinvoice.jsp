<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Strict//EN"
	"http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd">
<html lang="en">
  <head>
  <title>Invoice</title>
    <meta http-equiv="Content-type" content="text/html; charset=utf-8" />
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
      <%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
 
    <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/themes/printpage/css/style.css" media="all" />
        <link rel="icon" href="${pageContext.request.contextPath}/resources/themes/images/favicon.ico" type="image/x-icon" />
    
	
  </head>
 <body>

	 <c:if test="${!empty studentInvoice}">
	     <header class="clearfix">
				  <div id="logo">
				  <img src="${pageContext.request.contextPath}${logo}"></img>
			      </div>
      			   <h2 ><label style="margin-left:-120px">${studentInvoice.getStudent().getInstitution().getInstitutionName()}</label></h2>
				   <h3 ><label style="margin-left:-120px">(Affiliated to the Central Board Of College Education)</label></h3>
				  
				  <br></br> <h4 ><label style="margin-left:-120px">${studentInvoice.getStudent().getInstitution().getInstitutionAddressline1()}${", "}<c:if test="${!empty studentInvoice.getInstitution().getInstitutionAddressline2()}">${studentInvoice.getInstitution().getInstitutionAddressline2().concat(", ")}</c:if>${studentInvoice.getInstitution().getInstitutionCity()} - ${studentInvoice.getInstitution().getInstitutionPostcode()}</label></h4>
			       <div id="company1">
			         <div style="margin-top: -30px;margin-bottom: 4px;"> <span style="margin-left:-7px">INVOICE NO&nbsp&nbsp:</span>${studentInvoice.getInvoiceNo()}<br></div>
					 <div style="margin-bottom: 0px;"><span style="margin-right:15px">DATE&nbsp&nbsp:</span><fmt:formatDate pattern="dd/MM/yyyy" value="${studentInvoice.getGeneratedDate()}" /></div>
					
			       </div>
	  				<br>	  
	  				<h1></h1>
				     <div id="project">
				        <div style="margin-bottom: 4px;"><span>NAME<label style="margin-left:100px;">&nbsp;:</label>  </span><label style="margin-left:0px;">${studentInvoice.getStudent().getFirstName()} ${studentInvoice.getStudent().getLastName()}</label></div>
				        <div style="margin-bottom: 4px;"><span>ADMISSION.NO <label style="margin-left:46px;">:</label></span><label style="margin-left:0px;">&nbsp;${studentInvoice.getStudent().getAdmissionNo()}</label></div>
				        <div style="margin-bottom: 4px;" ><span>CLASS & SECTION&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<label>:</label></span><label>&nbsp;${studentInvoice.getStudent().getStudentClass().getClassName()} & ${studentInvoice.getStudent().getSection().getSectionName()}</label></div>
				    </div>
				    <div id="company">
			        <%--  <div ><span style="margin-right: 50px">CATEGORY&nbsp&nbsp <label style="margin-left:5px;">:</label></span><label style="margin-left:0px;">${studentInvoice.getStudent().getSpecialCategory().getSpecialCategoryName()}</label></div> --%>
					 <div style="margin-top: 5px;"><span style="margin-right: 17px">ACADEMIC YEAR&nbsp&nbsp:</span>&nbsp&nbsp${studentInvoice.getAcademicYear().getAcademicYearTitle()}</div>
					 <div style="margin-top: 6px;"><span style="margin-right: 40px">FEES CATEGORY&nbsp&nbsp:</span>${studentInvoice.getFeesTerm().getFeesTermName()}</div>
			       </div>
				    
           </header>
           <br>
     		<main>
  
     		  <table>
        		<thead style="border-top:2px solid black;border-bottom:2px solid black;border-left:2px solid black;border-right:2px solid black; ">
			          <tr>
			            <th class="service" style="color:#000000">SERIAL NO</th>
			            <th class="deschead" style="width:500px;color:#000000">FEE DESCRIPTION</th>
			             <th style="color:#000000">AMOUNT IN RUPEES</th>
			          </tr>
         		</thead>
        		<tbody style="border-top:2px solid black;border-bottom:2px solid black;border-left:2px solid black;border-right:2px solid black;">
        		   <c:set var="grandTotal"  scope="page" value="0.0"/>
        		   <c:set var="serialNumber" scope="page"  value="1"/>
        			 <c:if test="${!empty studentInvoice.getStudentInvoiceDetails()}">
                     		<c:forEach items="${studentInvoice.getStudentInvoiceDetails()}" var="studentInvoiceDetail">
                     			<tr>
						            <td class="service">${serialNumber}</td>
						            <c:set var="serialNumber" value="${serialNumber + 1}" scope="page"/>
						            <td class="desc">${studentInvoiceDetail.getFeesItem().getFeesItemName()}</td>
						            <td class="total">${studentInvoiceDetail.getStudentInvoiceElementTotalAmount()}</td>
						            <c:set var="grandTotal"  value="${grandTotal+studentInvoiceDetail.getStudentInvoiceElementTotalAmount()}"/>
						        </tr>
                            </c:forEach>
                      </c:if>
                      <tr>
			            <td colspan="2" class="grand total" style="color: red"><b>GRAND TOTAL</b></td>
			            <td class="grand total"><b>${grandTotal}</b></td>
			           </tr>
					    <tr>
						<td  colspan="2" style="text-align:left;height:50px">Amount In Words:&nbsp&nbsp<label style="color: red">${numberConverter.doubleConvert(grandTotal).toUpperCase()} RUPEES ONLY</label></td>
			            <td  style=" text-align:center;height:80px">Cashier Signature</td>
			           </tr>
        			</tbody>
				</table>
     		</c:if>
        <br>
		<br>
		
      
    </main>
    
  </body>
</html>