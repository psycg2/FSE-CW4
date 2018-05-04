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
        newProject.nextPhase();
        int PhaseID2 = newProject.getPhaseByID();
        assertEquals(PhaseID2, 2);
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
    public void shortProjectTitleTest(){
        newProject = new CompanyProject("First");
        String ProjectTitle = newProject.getPTitle();
        assertEquals(ProjectTitle, "");
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
        while(i<3) {
            PhaseTest = Phases[i];
            assertEquals(newProject.getPhaseByID(), PhaseTest);
            newProject.nextPhase();
            i++;
        }
    }

    @Test
    public void isContactFalseTest(){
        Boolean addressExists = newProject.isContact("psyaa12@nottingham.ac.uk");
        assertFalse(addressExists);
    }

    @Test
    public void isContactTrueTest(){
        ArrayList<String> Contacts = new ArrayList<>();
        Contacts.add("psyaa12@nottingham.ac.uk");
        newProject.addContact("psyaa12@nottingham.ac.uk");
        Boolean addressExists = newProject.isContact("psyaa12@nottingham.ac.uk");
        assertTrue(addressExists);
    }

    @Test
    public void getContactTest(){
        ArrayList<String> Contacts = new ArrayList<>();
        Contacts.add("psyaa12@nottingham.ac.uk");
        newProject.addContact("psyaa12@nottingham.ac.uk");
        assertEquals(newProject.getProjectContacts(), Contacts);
    }

    @Test
    public void getPhaseNameTest(){
        String PhaseName = newProject.getPhaseByName();
        assertEquals(PhaseName, "Feasibility");
        newProject.nextPhase();
        String phaseName2 = newProject.getPhaseByName();
        assertEquals(phaseName2, "Design");
    }

    @Test
    public void toStringTest(){
        String phaseAndName =  newProject.toString();
        assertEquals(phaseAndName, "First Project [Design]");
        newProject.nextPhase();
        String phaseAndName2 = newProject.toString();
        assertEquals(phaseAndName2, "First Project [Implementation]");
    }

    @Test
    public void addEmailTestSender() {
        CompanyEmail populatedEmail = new CompanyEmail("psyoba@nottingham.ac.uk", "psycg2@nottingham.ac.uk", "Test email", "Test msg");
        newProject.addEmail(populatedEmail);
        assertTrue(newProject.isContact("psyoba@nottingham.ac.uk"));
    }

    @Test
    public void addEmailTestReceiver(){
        CompanyEmail populatedEmail = new CompanyEmail("psyoba@nottingham.ac.uk", "psycg2@nottingham.ac.uk", "Test email", "Test msg");
        newProject.addEmail(populatedEmail);
        assertTrue(newProject.isContact("psycg2@nottingham.ac.uk"));
    }

    @Test
    public void addInvalidEmail(){
        CompanyEmail populatedEmail = new CompanyEmail("psyoba@nottingham.ac.uk", "", "", "");
        newProject.addEmail(populatedEmail);
        assertFalse(newProject.isContact("psyoba@nottingham.ac.uk"));
    }


}

