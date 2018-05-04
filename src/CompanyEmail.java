
public class CompanyEmail {
    private String fromAddress = "";
    private String toAddress = "";
    private String subjectLine = "";
    private String emailMessage = "";
    // Set to "" to avoid errors from null pointers

    public CompanyEmail() {}
    
    public CompanyEmail(String fAddress, String tAddress, String subLine, String eMessage) {
    	setFrom(fAddress);
    	setSubject(subLine);
    	setTo(tAddress);
    	setMessage(eMessage);
    }
    
    public String fromAddress() {
        return fromAddress;
    }
    
    public String toAddress() {
        return toAddress;
    }
    
    public String subjectLine() {
        return subjectLine;
    }
    
    public String emailMessage() {
        return emailMessage;
    }
    
    public void setFrom(String fromAddr) {
        if (fromAddr.matches("^[a-zA-Z0-9_!#$%&’*+/=?`{|}~^.-]+@[a-zA-Z0-9.-]+$")) { //adapted to a regexp compliant with rfc 5322
            fromAddress = fromAddr;
        }
    }
    
    public void setTo(String toAddr) {
        if (toAddr.matches("^[a-zA-Z0-9_!#$%&’*+/=?`{|}~^.-]+@[a-zA-Z0-9.-]+$")) { //adapted to a regexp compliant with rfc 5322
            toAddress = toAddr;
        }
    }
    
    public void setSubject(String subLine) {
        subjectLine = subLine;
    }
    
    public void setMessage(String eMessage) {
        emailMessage = eMessage;
    }
    
    public boolean isValid() {
        boolean isComplete = true;
        if (fromAddress.equals("")) isComplete = false;
        if (toAddress.equals("")) isComplete = false;
        if (subjectLine.equals("")) isComplete = false;
        if (emailMessage.equals("")) isComplete = false;
        return isComplete;
    }
    
    public String toString() {
    	if (subjectLine.equals("")) {
    		return "[no subject]";
    	} else {
    		return subjectLine;
    	}
    }
}
