import org.junit.*;
import static org.junit.Assert.*;

// Authors:
// Alexandros Araouzos
// Antontis Kourris
// Christiana Efstratiou

public class CompanyProjectTest {

    private CompanyProject newProject;

    @Before
    public void setup(){
        newProject = new CompanyProject("Alex");
    }

    @Test
    public void projectIDTest(){
        String ProjectTitle = newProject.getPTitle();
        assertEquals(ProjectTitle, "Alex");
    }
}

