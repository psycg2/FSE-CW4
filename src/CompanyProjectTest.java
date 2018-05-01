import org.junit.*;
import static org.junit.Assert.*;

// Authors:
//  Alexandros Araouzos
//  Antontis Kourris
//  Christiana Efstratiou

public class CompanyProjectTest {

    private CompanyProject newProject;
    private CompanyProject newID;

    @Before
    public void setup(){
        newProject = new CompanyProject("First Project");
        newID = new CompanyProject("1");
    }

    @Test
    public void ProjectIdTest(){
        int PhaseID = newProject.getPID();
        assertEquals(PhaseID, 1);
        int PhaseID2 = PhaseID+1;
        assertEquals(PhaseID2, 2);
    }

    @Test
    public void ProjectTitleTest(){
        String ProjectTitle = newProject.getPTitle();
        assertEquals(ProjectTitle, "First Project");
    }

}

