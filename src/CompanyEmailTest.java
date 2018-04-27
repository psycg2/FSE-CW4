import org.junit.*;

// Authors:
//      - Callum Gooding
//      - Omar Aziz
class CompanyEmailTest {
    private CompanyEmail blankEmail;
    private CompanyEmail populatedEmail;
    @Before
    public void setup(){
        blankEmail = new CompanyEmail();
        populatedEmail = new CompanyEmail("psyoba@nottingham.ac.uk", "psycg2@nottingham.ac.uk","Test email", "Test msg");
    }
}