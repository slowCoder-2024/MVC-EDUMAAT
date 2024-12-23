<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Strict//EN"
	"http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd">
<html lang="en">
  <head>
  <title>Receipt</title>
    <meta http-equiv="Content-type" content="text/html; charset=utf-8" />
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    <%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
    <link rel="icon" href="${pageContext.request.contextPath}/resources/themes/images/favicon.ico" type="image/x-icon" />
    <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/themes/printpage/css/style.css" media="all" />
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
			         <div style="margin-top: -30px;margin-bottom: 4px;"> <span style="margin-left:-7px">RECEIPT NO&nbsp&nbsp:</span>${studentReceipt.getReceiptId()}<br></div>
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
				        	      <%--    <div ><span style="margin-right: 30px">CATEGORY&nbsp&nbsp<label style="margin-left:7px;">:</label></span><label style="margin-left:0px;">${studentReceipt.getStudent().getSpecialCategory().getSpecialCategoryName()}</label></div> --%>
				        	    <div style="margin-bottom: 4px;"><span style="margin-right: 17px">ACADEMIC YEAR&nbsp&nbsp:</span>&nbsp&nbsp${studentReceipt.getAcademicYear().getAcademicYearTitle()}</div>
					 <div ><span style="margin-right: 40px">FEES CATEGORY&nbsp&nbsp:</span>${studentReceipt.getStudentInvoice().getFeesTerm().getFeesTermName()}</div>
 		       </div>
			        
			        
           </header>
     		<main>
     	<br>
     		 <c:if test="${!empty studentReceipt.getPaymentMode()}">
	     		 <table>
				        <thead style="border-top:2px solid black;border-bottom:2px solid black;border-left:2px solid black;border-right:2px solid black;">
				          <tr>
				            <th class="service" style="color:#000000">Payment Mode</th>
				            <th class="deschead" style="width:300px;color:#000000" >DD/Cheque No</th>
							<th class="deschead" style="color:#000000">Bank Name</th>
							<th class="deschead" style="color:#000000">Bank Branch</th>
				          </tr>
				        </thead>
						<tbody style="border-top:2px solid black;border-bottom:2px solid black;border-left:2px solid black;border-right:2px solid black;">
							<c:if test="${studentReceipt.getPaymentMode().getPaymentModeId()==1}">
								<tr>
					            <td class="service">${studentReceipt.getPaymentMode().getPaymentModeTitle()}</td>
					            <td class="service">-</td>
								<td class="service">-</td>
					            <td class="service">-</td>
					          </tr>
							</c:if>
							<c:if test="${studentReceipt.getPaymentMode().getPaymentModeId()==2}">
								<tr>
					            <td class="service">${studentReceipt.getPaymentMode().getPaymentModeTitle()}</td>
					            <td class="service">${studentReceipt.getChequeNumber()}</td>
								<td class="service">${studentReceipt.getChequeBankName()}</td>
					            <td class="service">${studentReceipt.getChequeBranchName()}</td>
					          </tr>
							</c:if>
							<c:if test="${studentReceipt.getPaymentMode().getPaymentModeId()==3}">
								<tr>
					            <td class="service">${studentReceipt.getPaymentMode().getPaymentModeTitle()}</td>
					            <td class="service">${studentReceipt.getDdNumber()}</td>
								<td class="service">${studentReceipt.getDdBankName()}</td>
					            <td class="service">${studentReceipt.getDdBranchName()}</td>
					          </tr>
							</c:if>
							<c:if test="${studentReceipt.getPaymentMode().getPaymentModeId()==4}">
								<tr>
					            <td class="service">${studentReceipt.getPaymentMode().getPaymentModeTitle()}</td>
					            <td class="service">-</td>
								<td class="service">-</td>
					            <td class="service">-</td>
					          </tr>
							</c:if>
				         </tbody>
	     			 </table>
     		 </c:if>
     		 <table>
        		<thead style="border-top:2px solid black;border-bottom:2px solid black;border-left:2px solid black;border-right:2px solid black;">
			          <tr>
			            <th class="service" style="color:#000000">SERIAL NO</th>
			            <th class="deschead" style="width:500px;color:#000000">FEE DESCRIPTION</th>
			             <th style="color:#000000">ACTUAL AMOUNT</th>
			              <th style="color:#000000">DISCOUNT AMOUNT</th>
			             <th style="color:#000000">PAID AMOUNT</th>
			          </tr>
         		</thead>
        		<tbody style="border-top:2px solid black;border-bottom:2px solid black;border-left:2px solid black;border-right:2px solid black;">
        		   <c:set var="grandTotal"  scope="page" value="0.0"/>
        		   <c:set var="subTotal"  scope="page" value="0.0"/>
        		   <c:set var="subTotalForActualAmount"  scope="page" value="0.0"/>
        		   <c:set var="subTotalForDiscountAmount"  scope="page" value="0.0"/>
        		   <c:set var="serialNumber" scope="page"  value="1"/>
        			 <c:if test="${!empty studentReceipt.getReceiptDetails()}">
                     		<c:forEach items="${studentReceipt.getReceiptDetails()}" var="receiptDetail">
                     			<tr>
						            <td class="service">${serialNumber}</td>
						            <c:set var="serialNumber" value="${serialNumber + 1}" scope="page"/>
						            <td class="desc">${receiptDetail.getStudentInvoiceDetail().getFeesItem().getFeesItemName()}</td>
						            <td class="total">${receiptDetail.getActualReceiptAmount()}</td>
						            <td class="total">${receiptDetail.getDiscountAmount()}</td>
 						        <td class="total">${receiptDetail.getPaidReceiptAmount()}</td>
 	<c:set var="subTotalForActualAmount"  value="${subTotalForActualAmount+receiptDetail.getActualReceiptAmount()}"/>
 	<c:set var="subTotalForDiscountAmount"  value="${subTotalForDiscountAmount+receiptDetail.getDiscountAmount()}"/>
 	<c:set var="subTotal"  value="${subTotal+receiptDetail.getPaidReceiptAmount()}"/>
 						       
						        </tr>
                            </c:forEach>
                      </c:if>
                      
			           <tr>
			            <td colspan="2" style="color:red;font-weight: bold;">SUB TOTAL</td>
			            <td class="sub Total For  ActualAmount">${subTotalForActualAmount}</td>
			            <td class="sub Total For Discount Amount">${subTotalForDiscountAmount}</td>
			            <td class="sub Total">${subTotal}</td>
			          </tr>
			          <c:if test="${!empty studentReceipt.getReceiptFines()}">
                     		<c:forEach items="${studentReceipt.getReceiptFines()}" var="receiptFine">
                     			<tr>
						            <td colspan="4" class="" style="color: red">${receiptFine.getFineTitle()}</td>
						            
						            <td class="total">${receiptFine.getFineAmount()}</td>
						            <c:set var="grandTotal"  value="${subTotal+receiptFine.getFineAmount()}"/>
			          			</tr>
                            </c:forEach>
                      </c:if>
                       <c:if test="${empty studentReceipt.getReceiptFines()}">
                        <c:set var="grandTotal"  value="${subTotal}"/>
                        </c:if>
			            <tr>
			            <td colspan="4" style="color:red; font-weight: bold;" class="grand total"><b>TOTAL</b></td>
			            
			            <td class="grand total"><b>${grandTotal}</b></td>
			           </tr>
			           <tr>
			            <td style="color:red; font-weight: bold;" class="Narration"><b>Narration</b></td>
			            <td colspan="5" class="grand total" style="text-align: left">&nbsp;${studentReceipt.getNarration()}</td>
			            
			           
			           </tr>
					    <tr>
						<td  colspan="4" style="text-align:left;height:50px">Amount In Words :&nbsp&nbsp<label style="color: red">${numberConverter.doubleConvert(grandTotal).toUpperCase()} RUPEES ONLY</label></td>
			            <td style=" text-align:center;height:80px">Cashier Signature</td>
			           </tr>
        			</tbody>
				</table>
     		</c:if>
        <br>
		<br>
		
      <div id="notices">
        <div>NOTE:</div>
        <div class="notice">Receipt  is subject to realization of the payment made.</div>
        
      </div>
    </main>
    
  </body>
</html>