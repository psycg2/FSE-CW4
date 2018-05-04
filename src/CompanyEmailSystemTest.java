import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.PrintStream;

import static org.junit.Assert.*;

public class CompanyEmailSystemTest {

    private final ByteArrayOutputStream output = new ByteArrayOutputStream();
    private CompanyEmailSystem ces;

    @Before
    public void setup(){
        System.setOut(new PrintStream(output));
        ces = new CompanyEmailSystem();

    }

    @After
    public void cleanup(){
        System.setOut(null);
    }

    @Test
    public void listProjectTest(){
        input("p\nx");
        ces.main(null);
        String out = output.toString();
        assertTrue(out.contains("Proj1"));
        assertTrue(out.contains("Proj2"));
        assertTrue(out.contains("Proj3"));
    }

    @Test
    public void addProjectTest(){
        input("a\nTestProject\np\nx");
        ces.main(null);
        String out = output.toString();
        assertTrue(out.contains("TestProject"));
    }

    @Test
    public void exitTest(){
        input("x");
        ces.main(null);
        String out = output.toString();
        assertTrue(out.contains("Goodbye!"));
    }

    @Test
    public void addEmailTest(){
        input("1\na\nme@me.com\nyou@you.com\ntest\nhi\nl\nx");
        ces.main(null);
        String out = output.toString();
        assertTrue(out.contains("test"));
    }

    @Test
    public void listPhasesTest(){
        input("1\nf\nx\nx");
        ces.main(null);
        String out = output.toString();
        assertTrue(out.contains("Design"));
    }

    @Test
    public void listPhaseEmailsTest(){
        input("1\n0\nx\nx");
        ces.main(null);
        String out = output.toString();
        assertTrue(out.contains("this is a test subject"));
    }

    @Test
    public void nextPhaseTest(){
        input("1\nn\nx\nx");
        ces.main(null);
        String out = output.toString();
        assertTrue(out.contains("Implementation"));
    }

    @Test
    public void listContactsTest(){
        input("1\nc\nx\nx");
        ces.main(null);
        String out = output.toString();
        assertTrue(out.contains("me0@me.com"));
    }

    @Test
    public void exitProjectTest(){
        input("1\nx\nx");
        ces.main(null);
        String out = output.toString();
        assertTrue(out.contains("Goodbye!"));
    }

    @Test
    public void blankProjectTest(){
        input("a\n\np\nx");
        ces.main(null);
        String out = output.toString();
        assertTrue(out.contains("[Design] - 0 emails"));
    }

    @Test
    public void badEmailTest(){
        input("1\na\ntest\ntest\ntest\ntest\nx\nx");
        ces.main(null);
        String out = output.toString();
        assertTrue(out.contains("[Email is invalid, not added to project]"));

    }



    public void input(String cmd){
        InputStream in = new ByteArrayInputStream(cmd.getBytes());
        System.setIn(in);
    }


}