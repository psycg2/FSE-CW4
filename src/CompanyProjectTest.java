import org.jboss.arquillian.test.spi.annotation.TestScoped;
import org.junit.*;

import java.util.ArrayList;

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
    public void firstProjectIdTest(){
        int PhaseID = newProject.getPID();
        assertEquals(PhaseID, 1);
    }

    @Test
    public void nextPhaseTest(){
        boolean nextPhaseTrue = newProject.nextPhase();
        assertTrue(nextPhaseTrue);
    }

    @Test
    public void projectTitleTest(){
        String ProjectTitle = newProject.getPTitle();
        assertEquals(ProjectTitle, "First Project");
    }

    @Test
    public void projectPhasesTitleTest(){
        String PhaseTest;
        String [] Phases = new String [3];
        Phases[0] = "Design";
        Phases[1] = "Implementation";
        Phases[2] = "Testing";
        int i = 0;
        while(i<3){
            PhaseTest = Phases[i];
            assertEquals(newProject.getPhaseByName(), PhaseTest);
            newProject.nextPhase();
            i++;
        }
    }

    @Test
    public void projectPhasesIDTest(){
        int PhaseTest;
        int [] Phases = new int[3];
        Phases[0] = 1;
        Phases[1] = 2;
        Phases[2] = 3;
        int i = 0;
        while(i>3) {
            PhaseTest = Phases[i];
            assertEquals(newProject.getPhaseByID(), PhaseTest);
            newProject.nextPhase();
            i++;
        }
    }

    @Test
    public void contactExistsFalseTest(){
        Boolean addressExists = newProject.isContact("psyaa12@nottingham.ac.uk");
        assertFalse(addressExists);
    }

    @Test
    public void contactExistsTrueTest(){
        ArrayList<String> Contacts = new ArrayList<String>();
        Contacts.add("psyaa12@nottingham.ac.uk");
        newProject.addContact("psyaa12@nottingham.ac.uk");
        Boolean addressExists = newProject.isContact("psyaa12@nottingham.ac.uk");
        assertTrue(addressExists);
    }

    @Test
    public void getContactTest(){
        ArrayList<String> Contacts = new ArrayList<String>();
        Contacts.add("psyaa12@nottingham.ac.uk");
        newProject.addContact("psyaa12@nottingham.ac.uk");
        assertEquals(newProject.getProjectContacts(), Contacts);
    }

}

