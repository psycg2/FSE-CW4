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
    }

    @Test
    public void projectIdTest(){
        int PhaseID = newProject.getPID();
        assertEquals(PhaseID, 1);
    }

    @Test
    public void projectTitleTest(){
        String ProjectTitle = newProject.getPTitle();
        assertEquals(ProjectTitle, "First Project");
    }

}

