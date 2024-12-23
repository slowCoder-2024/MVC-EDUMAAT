<%-- <%@ page import="java.util.*" %>
<%@ page import="java.security.*" %>

<%!
	public String hashCal(String type,String str){
		byte[] hashseq=str.getBytes();
		StringBuffer hexString = new StringBuffer();
		try{
		MessageDigest algorithm = MessageDigest.getInstance(type);
		algorithm.reset();
		algorithm.update(hashseq);
		byte messageDigest[] = algorithm.digest();
            
		

		for (int i=0;i<messageDigest.length;i++) {
			String hex=Integer.toHexString(0xFF & messageDigest[i]);
			if(hex.length()==1) hexString.append("0");
			hexString.append(hex);
		}
			
		}catch(NoSuchAlgorithmException nsae){ }
		
		return hexString.toString();


	}
%>
<%!
 public boolean verifyChecksum(params, checksumReceived_from_Payu)
 {
 
			String hashSequence = "udf10|udf9|udf8|udf7|udf6|udf5|udf4|udf3|udf2|udf1|email|firstname|productinfo|amount|txnid";
			String[] hashVarSeq=hashSequence.split("\\|");
			String hashString="";
			String hash="";
			String merchant_key="";
	        String salt="";
						
			hashString=hashString.concat(salt);
			hashString=hashString.concat("|");
			hashString=hashString.concat(params.get(status));
			hashString=hashString.concat("|");
			
			for(String part : hashVarSeq)
			{
				hashString= (empty(params.get(part)))?hashString.concat(""):hashString.concat(params.get(part));
				hashString=hashString.concat("|");
			}
			hashString=hashString.concat(merchant_key);
			
			 hash=hashCal("SHA-512",hashString);
			 
			  if(hash.equals(checksumReceived_from_Payu))
					return true;
              else
					return false;       
	}		 
%>
			  --%>