<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Strict//EN"
	"http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd">
<html lang="en">
  <head>
  <title>Receipt</title>
    <meta http-equiv="Content-type" content="text/html; charset=utf-8" />
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
      <%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
  <link rel="icon" href="${pageContext.request.contextPath}/resources/themes/images/favicon.ico" type="image/x-icon" />
    <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/themes/printpage/css/style.css" />
 </head>
 <body>

	 <c:if test="${!empty studentReceipt}">
	     <header class="clearfix">
				  <div id="logo">
			         <img src="${pageContext.request.contextPath}${logo}"></img>
			      </div>
      			   <h2 ><label style="margin-left:-120px">${studentReceipt.getStudent().getInstitution().getInstitutionName()}</label></h2>
				   <h3 ><label style="margin-left:-120px">(Affiliated to the Central Board Of College Education)</label></h3>
				   <h4 ><label style="margin-left:-120px">${studentReceipt.getStudent().getInstitution().getInstitutionAddressline1()}${", "}<c:if test="${!empty studentReceipt.getInstitution().getInstitutionAddressline2()}">${studentReceipt.getInstitution().getInstitutionAddressline2().concat(", ")}</c:if>${studentReceipt.getInstitution().getInstitutionCity()} - ${studentReceipt.getInstitution().getInstitutionPostcode()}</label></h4>
			        <div id="company1">
			         <div style="margin-top: -30px;margin-bottom: 4px;"> <span style="margin-left:-7px">REFUND RECEIPT NO&nbsp&nbsp:</span>${studentReceipt.getStudentFeeRefundReceiptId()}<br></div>
  					 <div style="margin-bottom: 0px;"><span style="margin-right:10px">DATE&nbsp&nbsp:</span><fmt:formatDate pattern="dd/MM/yyyy" value="${studentReceipt.getPaymentReceivedDate()}" /></div>					
 			       </div>
	  				<br>	  
	  				<h1></h1>
				     <div id="project">
				        <div style="margin-bottom: 4px;"><span>NAME<label style="margin-left:100px;">:</label>  </span><label style="margin-left:0px;">${studentReceipt.getStudent().getFirstName()} ${studentReceipt.getStudent().getLastName()}</label></div>
				        <div style="margin-bottom: 4px;"><span>ADMISSION.NO <label style="margin-left:44px;">:</label></span><label style="margin-left:0px;">${studentReceipt.getStudent().getAdmissionNo()}</label></div>
				        <div style="margin-bottom: 4px;" ><span>CLASS & SECTION&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<label>:</label></span><label>${studentReceipt.getStudent().getStudentClass().getClassName()} &  ${studentReceipt.getStudent().getSection().getSectionName()}</label></div>
				        </div>
				        <div id="company">
				        	       <%--   <div ><span style="margin-right: 30px">CATEGORY&nbsp&nbsp<label style="margin-left:7px;">:</label></span><label style="margin-left:0px;">${studentReceipt.getStudent().getFirstName()}</label></div> --%>
				        	    <div style="margin-bottom: 4px;"><span style="margin-right: 17px">ACADEMIC YEAR&nbsp&nbsp:</span>&nbsp&nbsp${studentReceipt.getAcademicYear().getAcademicYearTitle()}</div>
					 <div ><span style="margin-right: 40px">FEES CATEGORY&nbsp&nbsp:</span>${studentReceipt.getStudentInvoice().getFeesTerm().getFeesTermName()}</div>
 		       </div>
			        
			        
           </header>
     		<main>
     		<br>
    
     		 <table>
        		
        		   <c:set var="grandTotal"  scope="page" value="0.0"/>
        		   <c:set var="subTotal"  scope="page" value="0.0"/>
        		   <c:set var="subTotalForActualAmount"  scope="page" value="0.0"/>
        		   <c:set var="subTotalForDiscountAmount"  scope="page" value="0.0"/>
        		   <c:set var="serialNumber" scope="page"  value="1"/>
        			 <c:if test="${!empty studentReceipt.getStudentFeeRefundReceiptDetails()}">
                     		<c:forEach items="${studentReceipt.getStudentFeeRefundReceiptDetails()}" var="receiptDetail">
                     			
						           
 						        
 	<c:set var="subTotal"  value="${subTotal+receiptDetail.getPaidReceiptAmount()}"/>
 						        
						        
                            </c:forEach>
                      </c:if>
                      
			          
			       <%--    <c:if test="${!empty studentReceipt.getReceiptFines()}">
                     		<c:forEach items="${studentReceipt.getReceiptFines()}" var="receiptFine">
                     			
						            <c:set var="grandTotal"  value="${subTotal+receiptFine.getFineAmount()}"/>
			          			
                            </c:forEach>
                      </c:if>
                       <c:if test="${empty studentReceipt.getReceiptFines()}">
                      
                        </c:if> --%>
                          <c:set var="grandTotal"  value="${subTotal}"/>
			          <thead style="border-top:2px solid black;border-bottom:2px solid black;border-left:2px solid black;border-right:2px solid black; ">
			          <tr style="border-bottom: 2px solid black">
			            <!-- <th class="service">SERIAL NO</th>
			            <th class="deschead" style="width:500px">FEE DESCRIPTION</th>
			             <th>ACTUAL AMOUNT</th>
			              <th>DISCOUNT AMOUNT</th> -->
			             <th colspan="3" style="font-weight: bold;color:red;"><b>TOTAL </b><td class="grand total" style="text-align: center; font-size:large;"><b>${grandTotal}</b></td></th>
			          </tr>
			          
			              <tr>
			            <td style="color:red; font-weight: bold; text-align: left" class="Narration"><b style="border-right: 1px solid black;">Narration&nbsp;</b><b style="color: black;font-weight: normal;">&nbsp;${studentReceipt.getNarration()}</b></td>
			            
			            
			           
			           </tr>
         		</thead>
			                  		<tbody style="border-top:2px solid black;border-bottom:2px solid black;border-left:2px solid black;border-right:2px solid black;">
			          
			            
			           
			           
					    <tr>
						<td  colspan="3" style="text-align:left;height:50px">Amount In Words:&nbsp&nbsp<label style="color: red">${numberConverter.doubleConvert(grandTotal).toUpperCase()} RUPEES ONLY</label></td>
			            <td  style=" text-align:center;height:80px">Cashier Signature</td>
			           </tr>
        			</tbody>
				</table>
     		</c:if>
      <div id="notices">
        <div>NOTE:</div>
        <div class="notice">Receipt  is subject to realization of the payment made.</div>
        
      </div>
    </main>
    
  </body>
</html>