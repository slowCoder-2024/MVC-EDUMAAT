
<!DOCTYPE html>
<html>
<head>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
		<meta charset="utf-8">
		<meta name="viewport" content="width=device-width, initial-scale=1.0">
		<meta name="description" content="">
		<meta name="author" content="Coderthemes">
		<title>Setup Page</title>
		<!--Form Wizard-->
		<link rel="icon" href="${pageContext.request.contextPath}/resources/themes/images/favicon.ico" type="image/x-icon" />
        <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resources/themes/install/css/jquery.steps.css" />
		<link href="${pageContext.request.contextPath}/resources/themes/install/css/bootstrap.min.css" rel="stylesheet" type="text/css" />
        <link href="${pageContext.request.contextPath}/resources/themes/install/css/core.css" rel="stylesheet" type="text/css" />
        <link href="${pageContext.request.contextPath}/resources/themes/install/css/components.css" rel="stylesheet" type="text/css" />
        <link href="${pageContext.request.contextPath}/resources/themes/install/css/icons.css" rel="stylesheet" type="text/css" />
        <link href="${pageContext.request.contextPath}/resources/themes/install/css/pages.css" rel="stylesheet" type="text/css" />
        <link href="${pageContext.request.contextPath}/resources/themes/install/css/responsive.css" rel="stylesheet" type="text/css" />
        <link href="${pageContext.request.contextPath}/resources/themes/install/css/bootstrap-tagsinput.css" rel="stylesheet" />
        <link href="${pageContext.request.contextPath}/resources/themes/install/css/switchery.min.css" rel="stylesheet" />
        <link href="${pageContext.request.contextPath}/resources/themes/install/picker/timepicker/bootstrap-timepicker.min.css" rel="stylesheet">
		<link href="${pageContext.request.contextPath}/resources/themes/install/picker/mjolnic-bootstrap-colorpicker/dist/css/bootstrap-colorpicker.min.css" rel="stylesheet">
		<link href="${pageContext.request.contextPath}/resources/themes/install/picker/bootstrap-datepicker/dist/css/bootstrap-datepicker.min.css" rel="stylesheet">
		<link href="${pageContext.request.contextPath}/resources/themes/install/picker/clockpicker/dist/jquery-clockpicker.min.css" rel="stylesheet">
		<link href="${pageContext.request.contextPath}/resources/themes/install/picker/bootstrap-daterangepicker/daterangepicker.css" rel="stylesheet">
        <script src="${pageContext.request.contextPath}/resources/cdntolocal/js/jquery_1.11.2.min.js"></script>
        <script src="${pageContext.request.contextPath}/resources/cdntolocal/js/jquery_1.7.1.min.js"></script>	
        <script src="${pageContext.request.contextPath}/resources/themes/install/js/jquery.min.js"></script>
        <link href="${pageContext.request.contextPath}/resources/themes/install/css/jquery.bootstrap-touchspin.min.css" rel="stylesheet" />
        <script src="${pageContext.request.contextPath}/resources/themes/install/js/modernizr.min.js"></script>
        <script src="${pageContext.request.contextPath}/resources/themes/validator/js/customvalidator.js"></script>
          <link href="${pageContext.request.contextPath}/resources/themes/assets/plugins/multiselect/css/multi-select.css"  rel="stylesheet" type="text/css" />
      <link href="${pageContext.request.contextPath}/resources/themes/assets/plugins/select2/css/select2.min.css" rel="stylesheet" type="text/css" />
      <link href="${pageContext.request.contextPath}/resources/themes/assets/plugins/bootstrap-select/css/bootstrap-select.min.css" rel="stylesheet" />
    
<style>


</style>

	</head>

	<body class="fixed-left">

		<!-- Begin page -->
		<div id="wrapper">

          <div class="login-logo">
                 <img style="max-width:300px;max-height:200px;"src="${pageContext.request.contextPath}/resources/themes/images/edumaatlogo1.png" alt="">                                                                         
         </div>
          
            
			<div class="content-page">
				<!-- Start content -->
				<div class="content">
					<div class="container">
                       <div class="row">
							<div class="col-sm-11">
								<div class="card-box">
									<h4 class="m-t-0 header-title"><b>Configuration Details</b></h4>
									<p class="text-muted m-b-30 font-13">
										
									</p>
									
									<form id="wizard-validation-form" action="${pageContext.request.contextPath}/install" method="post" enctype='multipart/form-data'>
                                        <div>
										  <h3>Product Details</h3>
										   <section>
										   
										   
										   <div class="form-group">
	                                                <label>JDSoft Agreement with the Licensee</label>
	                                              
	                                                    <textarea class="form-control" rows="20" readonly>

1.GRANT OF LICENSE 

Subject to the terms and conditions of the Agreement, JDSOFT (JD Software Pvt. Ltd., 157/4, Vandaloor-Kelambakkam Main Road, Chennai-600127, India hereinafter referred to as Licensor) grants to the user of Edumaat and/or Edulearn Software, referred to as Licensee a non-exclusive, non-transferable license to use the software identified in Exhibit A (the "Licensed Programs") for the purpose of its own use. Licensee may use the Licensed Programs in executable format or in the installed format for its own use. Licensee may not, however, copy, duplicate, clone, transfer, reverse engineer, or sub-license the Licensed Programs for any purpose without prior permission from JD Software Pvt. Ltd. (JDSOFT), in whole or in part, in any form, whether modified or unmodified.



2.CONSIDERATION TO JDSOFT 

a.Licensee shall pay, upon delivery of the Licensed Programs, the license fees set forth in Exhibit A attached hereto or as per the referred documents. 

b.License fees do not include any shipping, duties, bank fees, sales, use, excise or similar taxes due or applicable unless expressly stated in the referred document(s). If Licensor is required to pay any such amounts, Licensee shall reimburse Licensor in full. 

3.COPIES 

Licensee may make copies of the Licensed Program in executable code form as per the agreement and corresponding purchase and work orders and as necessary for use by Licensee and for backup or archive purposes. Licensee agrees to maintain necessary security of the software and to maintain records of the location and use of each copy, in whole or in part, of the Licensed Programs. Each Licensed Program is copyrighted but unpublished by JDSOFT and is solely JDSOFT property. Licensee agrees to reproduce and apply the copyright notice and proprietary notice of JDSOFT to all copies made here under, in whole or in part and in any form, of Licensed Programs.

4.OWNERSHIP 

The original and any copies of the Licensed Programs, made by Licensee, including translations, compilations, partial copies, modifications, and updates, are the property of JDSOFT.

5.PROPRIETARY RIGHTS 

Licensee recognizes that JDSOFT regards the Licensed Programs as its proprietary information and as confidential trade secrets of great value, commercially and otherwise. Licensee agrees not to provide or to otherwise make available in any form the Licensed Programs, or any portion thereof, to any person other than employees of Licensee without the prior written consent of JDSOFT. Licensee further agrees to treat the Licensed Programs with at least the same degree of care with which Licensee treats its own confidential information and in no event with less care than is reasonably required to protect the confidentiality of the Licensed Programs.

6.TERM 

The license granted here under shall continue unless and until terminated pursuant to Section 7 hereof and subject to Licensee's proper performance of its obligations here under.

7.TERMINATION 

JDSOFT may terminate this License Agreement if Licensee is in default of any of the terms and conditions of this Agreement and fails to correct such default within ten (10) days after written notice thereof from JDSOFT.

8.TERMINATION CERTIFICATE 

In the event of termination, Licensee will immediately discontinue use of the Licensed Programs. Within one (1) month after termination of this Agreement, Licensee will furnish to JDSOFT a certificate which certifies with respect to each of the Licensed Programs that, through its best effort and to the best of its knowledge, the original and all copies, in whole or in part and in any form, of each of the Licensed Programs have been destroyed. The provisions of Sections 4, 5, 8, 11, and 13 hereof shall survive any termination of this Agreement.


9.DELIVERY OF LICENSED PROGRAMS 

JDSOFT shall use its best efforts to deliver the Licensed Programs promptly after receipt of the purchase order and software license (if required).


10.PATENT AND COPYRIGHT INDEMNITY 

JDSOFT shall have no liability for any claim of patent, copyright or trade secret infringement based on the use of a Licensed Program in any form other than the original, unmodified form provided to Licensee or the use of a combination of the Licensed Programs

with hardware, software or data not supplied by JDSOFT where the used Licensed Programs alone in their original, unmodified form would not constitute an infringement. The foregoing states Licensee's entire liability for infringement or claims of infringement of patents, copyrights or other intellectual property right.

11.LIMITATION OF LIABILITY 

JDSOFT'S LIABILITY TO LICENSEE UNDER ANY PROVISIONS OF THIS AGREEMENT FOR DAMAGES FINALLY AWARDED SHALL BE LIMITED TO THE AMOUNTS ACTUALLY  PAID HEREUNDER BY LICENSEE TO JDSOFT. IN NO EVENT SHALL JDSOFT BE LIABLE FOR INDIRECT, INCIDENTAL, SPECIAL, OR CONSEQUENTIAL DAMAGES, INCLUDING LOSS OF USE, LOSS OF PROFITS OR INTERRUPTION OF BUSINESS, HOWEVER CAUSED OR ON ANY THEORY OF LIABILITY.

12.NOTICES 

All notices in connection with this Agreement shall be in writing or in agreed electronic form and may be given by certified, registered, or first class mail or personally delivered at the address set forth on the front page. For purposes of this Agreement, a notice shall be deemed effective upon personal delivery to the party or if by mail five days after proper deposit in a mail box.


13.SUCCESSORS 

This Agreement will be binding upon and will inure to the benefit of the parties hereto and their respective representatives, successors and assigns except as otherwise provided herein.

14.SEVERABILITY 

In the event any provision of this Agreement is determined to be invalid or unenforceable, the remainder of this Agreement shall remain in force as if such provision were not a part.

15.GOVERNING LAW/FORUM 

This Agreement shall be governed and interpreted by the laws of the Republic of India, which shall determine the appropriate venue and jurisdiction for the resolution of any disputes here under. Both parties hereby consent to such personal and exclusive jurisdiction.


16.NON-ASSIGNMENT 


This Agreement and the licenses granted by JDSOFT may not be assigned, sub-licensed, or otherwise transferred by Licensee without the prior written consent of  JDSOFT.                                       


17.    ENTIRE AGREEMENT 

This Agreement sets forth the entire understanding between the parties with respect to the subject matter hereof, and merges and supersedes all prior agreements, discussions and understandings, express or implied, concerning such matters. This Agreement shall take precedence over any additional or conflicting terms which may be contained in Licensee's purchase order or JDSOFT's order acknowledgment forms.


</textarea>
	                                              
	                                            </div>
	                                                
	                                                 <div class="form-group clearfix " >
                                                    <div class="col-md-offset-9 col-xs-offset-3">
                                                        <input id="acceptTerms-1" name="acceptTerms1" type="checkbox" class="required">
                                                        <label for="acceptTerms-1">I agree with the Terms and Conditions.</label>
                                                    </div>
                                                </div>
	
									                 <div class="form-group">
														<label>Customer Code</label>
														<input type="text" placeholder="" data-mask="aa/****/*******" id="customerCode" name="customerCode" class="form-control required">
													
													</div>
												
													<div class="form-group">
														<label>License Code</label>
														<input type="text" placeholder="" data-mask="aa-****-****-****-****-****-****" id="licenseCode" name="licenseCode" class="form-control required">
													
													</div>
													
													<div class="form-group">
														<label>Installation Key</label>
														<input type="text" placeholder=""id="installationKey" name="installationKey" class="form-control required">
													
													</div>
		
										   </section>
							 	 		<h3>Institute Details</h3>
											 <section>
                <div class="form-group clearfix">
                                 <label for="" class="col-lg-3 control-label">Is MultiInstitutions?<span class="at-required-highlight">*</span></label> 
                                 <div class="col-lg-9">
                                    <select name="isMultiInstitutions" id="isMultiInstitutions" class="selectpicker" data-live-search="true"  data-style="btn-white" required="required">
                                       <option value="" disabled selected>Please Select</option>
                                       <option value="1">Yes</option>
                                       <option value="0">No</option>
                                      </select>
                                 </div>
                              </div>
                                                 <div class="form-group clearfix">
                                                    <label class="col-lg-3 control-label" for="institutionName"> Institution Code <span>*</span></label>
                                                    <div class="col-lg-9">
                                                        <input id="institutionCode" name="institutionCode" type="text" class="required form-control" maxlength="100">
                                                    </div>
                                                </div>
                                                <div class="form-group clearfix">
                                                    <label class="col-lg-3 control-label" for="institutionName"> Institution Name <span>*</span></label>
                                                    <div class="col-lg-9">
                                                        <input id="institutionName" name="institutionName" type="text" class="required form-control" maxlength="255">
                                                    </div>
                                                </div>
                                                
                                                
                                                    <div class="form-group clearfix">
                                 <label for="institutionProfilePic" class="col-lg-3 control-label">Institution Logo<span class="at-required-highlight">*</span></label> 
                                 <div class="col-lg-9">
                                    <input name="institutionProfilePic" id="institutionProfilePic" type="file" required="required"/>
                                   <br>
                                    <div id="image-holder2">
                                    </div>
                                 </div>
                              </div>

						 <div class="form-group clearfix">
                                 <label for="institutionAuthorizedSignaturePic" class="col-lg-3 control-label">Institution Authorized Signature<span class="at-required-highlight">*</span></label> 
                                 <div class="col-lg-9">
                                    <input name="institutionAuthorizedSignaturePic" id="institutionAuthorizedSignaturePic" type="file" required="required"/>
                                   <br>
                                    <div id="image-holder13">
                                    </div>
                                 </div>
                              </div>

                                                <div class="form-group clearfix">
                                                    <label class="col-lg-3 control-label " for="institutionEmail">Institution Email <span>*</span></label>
                                                    <div class="col-lg-9">
                                                        <input id="institutionEmail" name="institutionEmail" type="text" class="required email form-control" maxlength="100">
                                                    </div>
                                                </div>
										<div class="form-group clearfix">
                                                    <label class="col-lg-3 control-label " for="institutionContact"> Institution Contact <span>*</span></label>
                                                    <div class="col-lg-9">
                                                        <input id="institutionContact" name="institutionContact" type="text" class=" required form-control" onkeypress="return isNumber(event)" maxlength="20">

                                                    </div>
                                                </div>
                                                <div class="form-group clearfix">
                                                    <label class="col-lg-3 control-label " for="institutionAddressLine1">Address Line 1 <span>*</span></label>
                                                    <div class="col-lg-9">
                                                        <input id="institutionAddressLine1" name="institutionAddressLine1" type="text" class="required form-control" maxlength="255">
                                                    </div>
                                                </div>
												
												<div class="form-group clearfix">
                                                    <label class="col-lg-3 control-label " for="institutionAddressLine2">Address Line 2 <span>*</span></label>
                                                    <div class="col-lg-9">
                                                        <input id="institutionAddressLine2" name="institutionAddressLine2" type="text" class="required form-control" maxlength="255">
                                                    </div>
                                                </div>
												<div class="form-group clearfix">
                                                    <label class="col-lg-3 control-label " for="institutionCountry">Country <span>*</span></label>
                                                    <div class="col-lg-9">
                                                        <select name="institutionCountry" id="geographicallocation" required="required" class="selectpicker" data-live-search="true"  data-style="btn-white">
					                                       <c:if test="${!empty geographicallocationList}">
					                                          <option value="" disabled selected>Select Country </option>
					                                          <c:forEach items="${geographicallocationList}" var="geographicallocation">
					                                             <option id="${geographicallocation.getName()}" value="${geographicallocation.getName()}">${geographicallocation.getName()}</option>
					                                          </c:forEach>
					                                       </c:if>
                                    					</select>
                                                    </div>
                                                </div>
												<div class="form-group clearfix">
                                                    <label class="col-lg-3 control-label " for="institutionState">State <span>*</span></label>
                                                    <div class="col-lg-9">
                                                        <select name="institutionState" id="geographicallocationstate" required="required" class="selectpicker" data-live-search="true"  data-style="btn-white">
                                    	 						<option value="" disabled selected>Select Country First</option>
                                    					</select>
                                                    </div>
                                                </div>
												<div class="form-group clearfix">
                                                    <label class="col-lg-3 control-label " for="institutionCity">City <span>*</span> </label>
                                                    <div class="col-lg-9">
                                                        <select name="institutionCity" id="geographicallocationcity" required="required" class="selectpicker" data-live-search="true"  data-style="btn-white">
                                     						<option value="" disabled selected>Select State First </option>
                                     					</select>
                                                    </div>
                                                </div>
                                                    <div class="form-group clearfix">
                                                    <label class="col-lg-3 control-label " for="institutionPostCode"> Post Code <span>*</span></label>
                                                    <div class="col-lg-9">
                                                        <input id="institutionPostCode" name="institutionPostCode" type="text" class="required form-control" onkeypress="return isNumber(event)" maxlength="6">

                                                    </div>
                                                </div>
                                                <div class="form-group clearfix">
                                                    <label class="col-lg-3 control-label " for="institutionCurrencyCode">Currency Code <span>*</span></label>
                                                    <div class="col-lg-9">
                                                        <select name="institutionCurrencyCode" id="institutionCurrency" class="selectpicker" data-live-search="true"  data-style="btn-white" required="required">
					                                       <c:if test="${!empty currencies}">
					                                          <option value="" disabled selected>Select Currency </option>
					                                          <c:forEach items="${currencies}" var="currency">
					                                             <option  value="${currency.getIsoCode()}">${currency.getIsoCode()}</option>
					                                          </c:forEach>
					                                       </c:if>
                                    					</select>
                                                    </div>
                                                </div>
                                                <div class="form-group clearfix criteria" style="display: none;">
                                 <label for="" class="col-lg-3 control-label">Fee Collection Admin Type <span class="at-required-highlight">*</span></label> 
                                 <div class="col-lg-9">
                                    <select name="feeCollectionAdminType" id="feeCollectionAdminType" class="selectpicker" data-live-search="true"  data-style="btn-white" required="required">
                                       <option value="" disabled selected>Please Select</option>
                                       <option value="1">Common</option>
                                       <option value="0">Separate</option>
                                       <option value="2">No</option>
                                      </select>
                                 </div>
                              </div>
                              <div class="form-group clearfix criteria" style="display: none;">
                                 <label for="" class="col-lg-3 control-label">Inventory And Asset Admin Type <span class="at-required-highlight">*</span></label> 
                                 <div class="col-lg-9">
                                    <select name="inventoryAndAssetAdminType" id="inventoryAndAssetAdminType" class="selectpicker" data-live-search="true"  data-style="btn-white" required="required">
                                       <option value="" disabled selected>Please Select</option>
                                       <option value="1">Common</option>
                                       <option value="0">Separate</option>
                                       <option value="2">No</option>
                                      </select>
                                 </div>
                              </div>
                              <div class="form-group clearfix criteria"style="display: none;">
                                 <label for="" class="col-lg-3 control-label">Visitor Admin Type <span class="at-required-highlight">*</span></label> 
                                 <div class="col-lg-9">
                                    <select name="visitorAdminType" id="visitorAdminType" class="selectpicker" data-live-search="true"  data-style="btn-white" required="required">
                                       <option value="" disabled selected>Please Select</option>
                                       <option value="1">Common</option>
                                       <option value="0">Separate</option>
                                       <option value="2">No</option>
                                      </select>
                                 </div>
                              </div>
                                  <div class="form-group clearfix criteria"style="display: none;">
                                 <label for="" class="col-lg-3 control-label">Library Admin Type <span class="at-required-highlight">*</span></label> 
                                 <div class="col-lg-9">
                                    <select name="libraryAdminType" id="libraryAdminType" class="selectpicker" data-live-search="true"  data-style="btn-white" required="required">
                                       <option value="" disabled selected>Please Select</option>
                                       <option value="1">Common</option>
                                       <option value="0">Separate</option>
                                       <option value="2">No</option>
                                      </select>
                                 </div>
                              </div>
                              
                              
                              
                              
                              
                                                          <div class="form-group clearfix criteriaforsingle" style="display: none;">
                                 <label for="" class="col-lg-3 control-label">Fee Collection Admin Type <span class="at-required-highlight">*</span></label> 
                                 <div class="col-lg-9">
                                    <select name="feeCollectionAdminType" id="feeCollectionAdminType" class="selectpicker" data-live-search="true"  data-style="btn-white" required="required">
                                      
                                    <option value="3">Yes</option>
                                       <option value="2">No</option>
                                        
                                      </select>
                                 </div>
                              </div>
                              <div class="form-group clearfix criteriaforsingle" style="display: none;">
                                 <label for="" class="col-lg-3 control-label">Inventory And Asset Admin Type <span class="at-required-highlight">*</span></label> 
                                 <div class="col-lg-9">
                                    <select name="inventoryAndAssetAdminType" id="inventoryAndAssetAdminType" class="selectpicker" data-live-search="true"  data-style="btn-white" required="required">
                                        <option value="3">Yes</option>
                                       <option value="2">No</option>
                                      </select>
                                 </div>
                              </div>
                              <div class="form-group clearfix criteriaforsingle"style="display: none;">
                                 <label for="" class="col-lg-3 control-label">Visitor Admin Type <span class="at-required-highlight">*</span></label> 
                                 <div class="col-lg-9">
                                    <select name="visitorAdminType" id="visitorAdminType" class="selectpicker" data-live-search="true"  data-style="btn-white" required="required">
                                        <option value="3">Yes</option>
                                       <option value="2">No</option>
                                      </select>
                                 </div>
                              </div>
                                  <div class="form-group clearfix criteriaforsingle"style="display: none;">
                                 <label for="" class="col-lg-3 control-label">Library Admin Type <span class="at-required-highlight">*</span></label> 
                                 <div class="col-lg-9">
                                    <select name="libraryAdminType" id="libraryAdminType" class="selectpicker" data-live-search="true"  data-style="btn-white" required="required">
                                        <option value="3">Yes</option>
                                       <option value="2">No</option>
                                      </select>
                                 </div>
                              </div>
                              
                              
                              
                              
                              
                              
                              
                              
                              
                              
                                                 <div class="form-group clearfix">
                                 <label for="" class="col-lg-3 control-label">Collect Receipts InOrder<span class="at-required-highlight">*</span></label> 
                                 <div class="col-lg-9">
                                    <select name="collectReceiptsInOrder" id="collectReceiptsInOrder" class="selectpicker" data-live-search="true"  data-style="btn-white" required="required">
                                       <option value="" disabled selected>Select Collect Receipts InOrder</option>
                                       <option value="1">Yes</option>
                                       <option value="0">No</option>
                                      </select>
                                 </div>
                              </div>
                                                <div class="form-group clearfix">
                                                    <label  style="color:red"class="col-lg-12 control-label ">(*) Mandatory</label>
                                                </div>

                                            </section>
                                            <h3>Staff Administrator Details</h3>
                                           
                                             <section>
                                             <div>
                                           
                                              <h3 style="color: #ea8c13"> Personal Information:</h3>
                                          <br>
                                           <section>
                                              
                                            
                                                 
                                                <div class="form-group clearfix">
                                                    <label class="col-lg-3 control-label" for="staffFirstName"> First Name <span>*</span></label>
                                                    <div class="col-lg-9">
                                                        <input id="staffFirstName" required="required" name="staffFirstName" type="text" class="required form-control" maxlength="100">
                                                    </div>
                                                </div>
                                                <div class="form-group clearfix">
                                                    <label class="col-lg-3 control-label" for="staffLastName"> Last Name</label>
                                                    <div class="col-lg-9">
                                                        <input id="staffLastName" name="staffLastName" type="text" class="form-control" maxlength="100">
                                                    </div>
                                                </div>
                                                <div class="form-group clearfix">
                                                    <label class="col-lg-3 control-label" for="staffParentOrGuardianFirstName"> Parent or Guardian First Name <span>*</span></label>
                                                    <div class="col-lg-9">
                                                        <input id="staffParentOrGuardianFirstName" name="staffParentOrGuardianFirstName" required="required" type="text" class="required form-control" maxlength="100">
                                                    </div>
                                                </div>
                                                <div class="form-group clearfix">
                                                    <label class="col-lg-3 control-label" for="staffParentOrGuardianLastName">Parent or Guardian Last Name</label>
                                                    <div class="col-lg-9">
                                                        <input id="staffParentOrGuardianLastName" name="staffParentOrGuardianLastName" type="text" class="form-control" maxlength="100">
                                                    </div>
                                                </div>
                                                <div class="form-group clearfix">
                                                    <label class="col-lg-3 control-label " for="staffGender">Gender<span>*</span></label>
                                                    <div class="col-lg-9">
                                                        <select name="staffGender" id="staffGender" required="required" class="selectpicker" data-live-search="true"  data-style="btn-white">
					                                         <option value="" disabled selected>Select Gender</option>
				                                             <option value="Male">Male</option>
				                                             <option value="Female">Female</option>
				                                             <option value="Others">Others</option>
                                    					</select>
                                                    </div>
                                                </div>
                                                  <div class="form-group clearfix">
                                                    <label class="col-lg-3 control-label" for="staffDOB">Date of Birth<span>*</span></label>
                                                    <div class="col-lg-9">
                                                        <input id="datepicker-autoclose" name="staffDOB" required="required" type="text" class="required form-control form-control-datepicker">
                                                    </div>
                                                </div>
                                                
                                                 <div class="form-group clearfix">
                                                    <label class="col-lg-3 control-label" for="staffEmail">Email<span>*</span></label>
                                                    <div class="col-lg-9">
                                                        <input id="staffEmail" name="staffEmail" required="required" type="text" class="required email form-control" maxlength="100" autocomplete="off">
                                                    </div>
                                                </div>
                                                
                                                <div class="form-group clearfix">
                                                    <label class="col-lg-3 control-label" for="staffContact"> Mobile No<span>*</span></label>
                                                    <div class="col-lg-9">
                                                        <input id="staffContact" name="staffContact" type="text" class="required form-control" maxlength="20" onkeypress="return isNumber(event)">
                                                    </div>
                                                </div>
                                                
                                                 <div class="form-group clearfix">
                                                    <label class="col-lg-3 control-label " for="categoryId">Category<span>*</span></label>
                                                    <div class="col-lg-9">
                                                        <select name="categoryId" id="categoryId" required="required" class="selectpicker" data-live-search="true"  data-style="btn-white">
					                                         <option value="" disabled selected>Select Category</option>
				                                             <c:if test="${!empty categories}">
		                                       		         <c:forEach items="${categories}" var="category">
		                                       			       <option value="${category.getCategoryId()}">${category.getCategoryName()}</option>
		                                        	          </c:forEach>
	                                       		</c:if>
                                    					</select>
                                                    </div>
                                                </div>
                                                                    <div class="form-group clearfix">
                                 <label for="institutionProfilePic" class="col-lg-3 control-label">Photo<span class="at-required-highlight">*</span></label> 
                                 <div class="col-lg-9">
                                    <input name="staffProfilePic" id="staffProfilePic" type="file" required="required" maxlength="225"/>
                                   <br>
                                    <div id="image-holder3">
                                    </div>
                                 </div>
                              </div>
                              
                               <div class="form-group clearfix">
                                                    <label class="col-lg-3 control-label " for="staffBloodGroupId">Blood Group</label>
                                                    <div class="col-lg-9">
                                                        <select name="staffBloodGroupId" id="staffBloodGroupId" class="selectpicker" data-live-search="true"  data-style="btn-white">
					                                        <option value="" disabled selected>Select Blood Group</option>
                                             <c:if test="${!empty bloodGroups}">
		                                       		<c:forEach items="${bloodGroups}" var="bloodGroup">
		                                       			<option value="${bloodGroup.getBloodGroupId()}">${bloodGroup.getBloodGroupName()}</option>
		                                        	</c:forEach>
	                                       		</c:if>
                                    					</select>
                                                    </div>
                                                </div> 
                             
                             </section>
											  <h3 style="color: #ea8c13">Contact Information:</h3>
											  <br>
											  <section>
											  
											  
											    <div class="form-group clearfix">
                                                    <label class="col-lg-3 control-label " for="staffAddressLine1">Address Line 1 <span>*</span></label>
                                                    <div class="col-lg-9">
                                                        <input id="staffAddressLine1" name="staffAddressLine1" required="required" type="text" class="required form-control" maxlength="255">
                                                    </div>
                                                </div>
												
												<div class="form-group clearfix">
                                                    <label class="col-lg-3 control-label " for="staffAddressLine2">Address Line 2 <span>*</span></label>
                                                    <div class="col-lg-9">
                                                        <input id="staffAddressLine2" required="required" name="staffAddressLine2" type="text" class="required form-control" maxlength="255">
                                                    </div>
                                                </div>
												<div class="form-group clearfix">
                                                    <label class="col-lg-3 control-label " for="staffCountry">Country <span>*</span></label>
                                                    <div class="col-lg-9">
                                                        <select name="staffCountry" id="geographicallocationstaff" required="required" class="selectpicker" data-live-search="true"  data-style="btn-white">
					                                       <c:if test="${!empty geographicallocationList}">
					                                          <option value="" disabled selected>Select Country </option>
					                                          <c:forEach items="${geographicallocationList}" var="geographicallocation">
					                                             <option id="${geographicallocation.getName()}" value="${geographicallocation.getName()}">${geographicallocation.getName()}</option>
					                                          </c:forEach>
					                                       </c:if>
                                    					</select>
                                                    </div>
                                                </div>
												<div class="form-group clearfix">
                                                    <label class="col-lg-3 control-label " for="staffState">State <span>*</span></label>
                                                    <div class="col-lg-9">
                                                        <select name="staffState" id="geographicallocationstatestaff" required="required" class="selectpicker" data-live-search="true"  data-style="btn-white">
                                    	 						<option value="" disabled selected>Select Country First</option>
                                    					</select>
                                                    </div>
                                                </div>
												<div class="form-group clearfix">
                                                    <label class="col-lg-3 control-label " for="staffCity">City <span>*</span> </label>
                                                    <div class="col-lg-9">
                                                        <select name="staffCity" id="geographicallocationcitystaff" required="required" class="selectpicker" data-live-search="true"  data-style="btn-white">
                                     						<option value="" disabled selected>Select State First </option>
                                     					</select>
                                                    </div>
                                                </div>
                                                    <div class="form-group clearfix">
                                                    <label class="col-lg-3 control-label " for="staffPostCode"> Post Code <span>*</span></label>
                                                    <div class="col-lg-9">
                                                        <input id="staffPostCode" name="staffPostCode" type="text" class="required form-control" onkeypress="return isNumber(event)" maxlength="6">

                                                    </div>
                                                </div>
											  
											  
											  
											  
											  
											  
											  
											  
											  
											  </section>
                                           <h3 style="color: #ea8c13">Account Information:</h3>
                                           <br>
                                           <section>
                                           <div class="form-group clearfix">
                                                    <label class="col-lg-3 control-label" for="staffBankName">Bank Name</label>
                                                    <div class="col-lg-9">
                                                        <input id="staffBankName" name="staffBankName" type="text" class="form-control" maxlength="100">
                                                    </div>
                                                </div>
                                                <div class="form-group clearfix">
                                                    <label class="col-lg-3 control-label" for="staffBankAccountNo">Bank Account No</label>
                                                    <div class="col-lg-9">
                                                        <input id="staffBankAccountNo" name="staffBankAccountNo" type="text" class="form-control" maxlength="100">
                                                    </div>
                                                </div>
                                                <div class="form-group clearfix">
                                                    <label class="col-lg-3 control-label" for="staffBankIFSC">Bank IFSC Code</label>
                                                    <div class="col-lg-9">
                                                        <input id="staffBankIFSC" name="staffBankIFSC" type="text" class="form-control" maxlength="100">
                                                    </div>
                                                </div>
                                                
                                                 <div class="form-group clearfix">
                                                    <label class="col-lg-3 control-label" for="staffPANNo">PAN No</label>
                                                    <div class="col-lg-9">
                                                        <input id="staffPANNo" name="staffPANNo" type="text" class="form-control" maxlength="50">
                                                    </div>
                                                </div>
                                                <div class="form-group clearfix">
                                                    <label class="col-lg-3 control-label" for="staffPFAccountNo">PF Account No</label>
                                                    <div class="col-lg-9">
                                                        <input id="staffPFAccountNo" name="staffPFAccountNo" type="text" class="form-control" maxlength="50">
                                                    </div>
                                                </div>
                                            
                                          
                                           
                                           </section> 
                                           
                                          <h3 style="color: #ea8c13">Academic Information:</h3>
                                          <br>
                                           <section>
                                           
                                                                                           <div class="form-group clearfix">
                                                    <label class="col-lg-3 control-label" for="staffCode">Staff Code<span>*</span></label>
                                                    <div class="col-lg-9">
                                                        <input id="staffCode" name="staffCode" required="required" type="text" class="required form-control" maxlength="50">
                                                    </div>
                                                </div>                                             
                                           
                                             
                                                  <div class="form-group clearfix">
                                                    <label class="col-lg-3 control-label" for="staffAccessId">Access No <span>*</span></label>
                                                    <div class="col-lg-9">
                                                        <input id="staffAccessId" name="staffAccessId" required="required" type="text" class=" required form-control" maxlength="50">
                                                    </div>
                                                </div>
                                               <div class="form-group clearfix">
                                                    <label class="col-lg-3 control-label" for="staffJoinedDate">Joined date</label>
                                                    <div class="col-lg-9">
                                                        <input id="staffJoinedDate" name="staffJoinedDate" type="text" class="form-control form-control-datepicker">
                                                    </div>
                                                </div>
                                           
                                           
                                           
                                           
                                           
                                           
                                           
                                           
                                           
                                           
                                           
                                           
                                           
                                           </section>
                                            
                                           
                                           
                                           
                                           
                                           
                                           
                                           
                                          <h3 style="color: #ea8c13">Experience Information:</h3>
                                          <br>
                                          <section>
                                          
                                          <div class="form-group text-right m-b-0" id="expdelete">
                                          <button type="button" class="btn btn-default waves-effect waves-light m-l-5 btnDel">
												Delete Experience
											</button>
											<button class="btn btn-primary waves-effect waves-light btnAdd" type="button">
												Add Experience
											</button>
											
										</div>
                                      <br>    
   									<br>
                          
      <div class="experiencedetails" id="experiencedetails">
      
      </div>
      
                         
                                       
                                          
                                          </section>
                                            <div class="form-group clearfix">
                                                    <label  style="color:red"class="col-lg-12 control-label ">(*) Mandatory</label>
                                                </div>
                                            
                                            </div></section>
                                         
                                            
                                        </div>
                                    </form>
								</div>
							</div>
						</div>



                        
                       
                    </div> <!-- container -->
                               
                </div> <!-- content -->

                <footer class="footer">
                    <a style="color:white" href="http://edumaat.com/">2017 © Edumaat.com</a>
                </footer>

            </div>
          




        </div>
        <!-- jQuery  -->
        <script src="${pageContext.request.contextPath}/resources/themes/install/js/bootstrap.min.js"></script>
        <script src="${pageContext.request.contextPath}/resources/themes/install/js/install.js"></script>
        <script src="${pageContext.request.contextPath}/resources/themes/script/geographicallocation.js"></script>
        <script src="${pageContext.request.contextPath}/resources/themes/install/js/detect.js"></script>
        <script src="${pageContext.request.contextPath}/resources/themes/install/js/fastclick.js"></script>
        <script src="${pageContext.request.contextPath}/resources/themes/install/js/jquery.slimscroll.js"></script>
        <script src="${pageContext.request.contextPath}/resources/themes/install/js/jquery.blockUI.js"></script>
        <script src="${pageContext.request.contextPath}/resources/themes/install/js/waves.js"></script>
        <script src="${pageContext.request.contextPath}/resources/themes/install/js/wow.min.js"></script>
        <script src="${pageContext.request.contextPath}/resources/themes/install/js/jquery.nicescroll.js"></script>
        <script src="${pageContext.request.contextPath}/resources/themes/install/js/jquery.scrollTo.min.js"></script>
  		<script src="${pageContext.request.contextPath}/resources/themes/js/image.js"></script>
          
        <script src="${pageContext.request.contextPath}/resources/themes/install/js/jquery.core.js"></script>
        <script src="${pageContext.request.contextPath}/resources/themes/install/js/jquery.app.js"></script>
         <script src="${pageContext.request.contextPath}/resources/themes/install/picker/moment.js"></script>
     	<script src="${pageContext.request.contextPath}/resources/themes/install/picker/timepicker/bootstrap-timepicker.min.js"></script>
     	<script src="${pageContext.request.contextPath}/resources/themes/install/picker/mjolnic-bootstrap-colorpicker/dist/js/bootstrap-colorpicker.min.js"></script>
     	<script src="${pageContext.request.contextPath}/resources/themes/install/picker/bootstrap-datepicker/dist/js/bootstrap-datepicker.min.js"></script>
     	<script src="${pageContext.request.contextPath}/resources/themes/install/picker/clockpicker/dist/jquery-clockpicker.min.js"></script>
     	<script src="${pageContext.request.contextPath}/resources/themes/install/picker/bootstrap-daterangepicker/daterangepicker.js"></script>
        <!--Form Validation-->
        <script src="${pageContext.request.contextPath}/resources/themes/install/js/bootstrapValidator.js" type="text/javascript"></script>
        <!--Form Wizard-->
        <script src="${pageContext.request.contextPath}/resources/themes/install/js/jquery.steps.min.js" type="text/javascript"></script>
        <script type="text/javascript" src="${pageContext.request.contextPath}/resources/themes/install/js/jquery.validate.min.js"></script>
        <!--wizard initialization-->
        <script src="${pageContext.request.contextPath}/resources/themes/install/js/jquery.wizard-init.js" type="text/javascript"></script>
        <script src="${pageContext.request.contextPath}/resources/themes/install/js/bootstrap-filestyle.min.js" type="text/javascript"></script>
	  <script type="text/javascript" src="${pageContext.request.contextPath}/resources/themes/assets/plugins/multiselect/js/jquery.multi-select.js"></script>
   <script src="${pageContext.request.contextPath}/resources/themes/assets/plugins/bootstrap-select/js/bootstrap-select.min.js" type="text/javascript"></script>
     <script src="${pageContext.request.contextPath}/resources/themes/assets/plugins/bootstrap-filestyle/js/bootstrap-filestyle.min.js" type="text/javascript"></script>
     <script src="${pageContext.request.contextPath}/resources/themes/assets/plugins/bootstrap-inputmask/bootstrap-inputmask.min.js" type="text/javascript"></script>
        <script src="${pageContext.request.contextPath}/resources/themes/assets/plugins/autoNumeric/autoNumeric.js" type="text/javascript"></script>
    <script>
    $(document).ready(function() {	
    $('.form-control-datepicker').removeClass('hasDatepicker').datepicker({
  	  format: "dd/mm/yyyy",
    	autoclose: true,
    	todayHighlight: true
    });
	});
    </script>
    
    <script type="text/javascript">
        	  
		  jQuery(function($) {
		      $('.autonumber').autoNumeric('init');    
		  });
        </script>
	</body>


</html>