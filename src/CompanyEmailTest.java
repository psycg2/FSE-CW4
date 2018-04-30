import org.junit.*;
import static org.junit.Assert.*;

// Authors:
//      - Callum Gooding
//      - Omar Aziz

public class CompanyEmailTest{
    private CompanyEmail blankEmail;
    private CompanyEmail populatedEmail;
    private CompanyEmail invalidEmail;
    @Before
    public void setup(){
        blankEmail = new CompanyEmail();
        populatedEmail = new CompanyEmail("psyoba@nottingham.ac.uk", "psycg2@nottingham.ac.uk","Test email", "Test msg");
        invalidEmail = new CompanyEmail( "psyoba.nottingham.ac.uk","psycg2.nottingham.ac.uk", "Test email", "Test msg" );
    }

    @Test
    public void fullTest(){
        String fromAddress = populatedEmail.fromAddress();
        String toAddress = populatedEmail.toAddress();
        String subLine = populatedEmail.subjectLine();
        String eMessage = populatedEmail.emailMessage();
        assertEquals(fromAddress, "psyoba@nottingham.ac.uk");
        assertEquals(toAddress, "psycg2@nottingham.ac.uk");
        assertEquals(subLine, "Test email");
        assertEquals(eMessage, "Test msg");
        assertTrue(populatedEmail.isValid());
    }

    @Test
    public void nullTest(){
        String fromAddress = blankEmail.fromAddress();
        String toAddress = blankEmail.toAddress();
        String subLine = blankEmail.subjectLine();
        String eMessage = blankEmail.emailMessage();
        assertEquals(fromAddress, "");
        assertEquals(toAddress, "");
        assertEquals(subLine, "");
        assertEquals(eMessage, "");
        assertFalse(blankEmail.isValid());
    }

    @Test
    public void setterTest(){
        blankEmail.setFrom("psyoba@nottingham.ac.uk");
        blankEmail.setTo("psycg2@nottingham.ac.uk");
        blankEmail.setSubject("Test email");
        blankEmail.setMessage("Test msg");
        String fromAddress = blankEmail.fromAddress();
        String toAddress = blankEmail.toAddress();
        String subLine = blankEmail.subjectLine();
        String eMessage = blankEmail.emailMessage();
        assertEquals(fromAddress, "psyoba@nottingham.ac.uk");
        assertEquals(toAddress, "psycg2@nottingham.ac.uk");
        assertEquals(subLine, "Test email");
        assertEquals(eMessage, "Test msg");
        assertTrue(blankEmail.isValid());
    }

    @Test
    public void eMessageAsEmpty(){
        blankEmail.setMessage("");
        String eMessage = blankEmail.emailMessage();
        assertEquals(eMessage, "");
    }

    @Test
    public void senderAsInvalid(){
        blankEmail.setFrom("psyoba.nottingham.ac.uk");
        String fromAddress = blankEmail.fromAddress();
        assertEquals(fromAddress, "");

    }

    @Test
    public void receiverAsInvalid(){
        blankEmail.setTo("psycg2.nottingham.ac.uk");
        String toAddress = blankEmail.toAddress();
        assertEquals(toAddress, "");
    }

    @Test
    public void subjectAsEmpty(){
        blankEmail.setSubject((""));
        String subLine = blankEmail.subjectLine();
        assertEquals(subLine, "");

    }

    @Test
    public void invalidConstructor(){
        String fromAddress = invalidEmail.fromAddress();
        String toAddress = invalidEmail.toAddress();
        assertEquals(fromAddress, null);
        assertEquals(toAddress, null);

    }
     @Test
    public void stringTest(){
        assertEquals(blankEmail.toString(), "[no subject]");
        assertEquals(populatedEmail.toString(),"Test email" );
     }

}