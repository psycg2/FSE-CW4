import org.jboss.arquillian.test.spi.annotation.TestScoped;
import org.junit.*;
import static org.junit.Assert.*;

// Authors:
//  Alexandros Araouzos
//  Antontis Kourris
//  Christiana Efstratiou

public class CompanyProjectTest {

    private CompanyProject newProject;

    @Before
    public void setup(){
        newProject = new CompanyProject("First Project");
    }

    @Test
    public void projectIdTest(){
        int PhaseID = newProject.getPID();
        assertEquals(PhaseID, 1);
    }

    @Test
    public void nextPhaseIDTest(){
        boolean nextPhaseTrue = newProject.nextPhase();
        assertTrue(nextPhaseTrue);
    }

    @Test
    public void projectTitleTest(){
        String ProjectTitle = newProject.getPTitle();
        assertEquals(ProjectTitle, "First Project");
    }

    @Test
    public void contactExistsFalseTest(){
        Boolean addressExists = newProject.isContact("psyaa12@nottingham.ac.uk");
        assertFalse(addressExists);
    }


}

