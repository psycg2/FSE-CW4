
public class CompanyEmail {
    private String fromAddress;
    private String toAddress;
    private String subjectLine;
    private String emailMessage;
    
    public CompanyEmail() {
        fromAddress = "";
        toAddress = "";
        subjectLine = "";
        emailMessage = "";
    }
    
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
        if (fromAddr.contains("@")) {
            fromAddress = fromAddr;
        }
    }
    
    public void setTo(String toAddr) {
        if (toAddr.contains("@")) {
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
        if (fromAddress == "") isComplete = false;
        if (toAddress == "") isComplete = false;
        if (subjectLine == "") isComplete = false;
        if (emailMessage == "") isComplete = false;
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
