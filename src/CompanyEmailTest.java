import org.junit.*;
import static org.junit.Assert.*;

// Authors:
//      - Callum Gooding
//      - Omar Aziz
public class CompanyEmailTest{
    private CompanyEmail blankEmail;
    private CompanyEmail populatedEmail;
    @Before
    public void setup(){
        blankEmail = new CompanyEmail();
        populatedEmail = new CompanyEmail("psyoba@nottingham.ac.uk", "psycg2@nottingham.ac.uk","Test email", "Test msg");
    }

    @Test
    public void fromTest(){
        String fromAddress = populatedEmail.fromAddress();
        assertEquals(fromAddress, "psyoba@nottingham.ac.uk");
    }
}