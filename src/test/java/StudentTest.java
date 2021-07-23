import org.junit.Assert;
import org.junit.Test;
import static org.junit.Assert.*;

public class StudentTest {

    @Test
    public void testIfStudentCanBeCreated(){
        Student fer = new Student(1L, "fer");
        Student nullStudent = null;
        assertNotNull(fer);
        assertNull(nullStudent);
    }

    @Test
    public void testIfFieldsAreSet(){
        Student fer = new Student(1L, "fer");
        assertEquals(1L, fer.getId());
        assertEquals("fer", fer.getName());

        Student rosie = new Student(40L, "Rosie");
        assertEquals(40L, rosie.getId());
        assertEquals("Rosie", rosie.getName());
    }

    @Test
    public void testIfAddGradeWorks(){
        Student fer = new Student(1L, "fer");
        assertEquals(0, fer.getGrades().size());
        fer.addGrade(90);
        assertEquals(1, fer.getGrades().size());
        fer.addGrade(70);
        assertEquals(2, fer.getGrades().size());
    }

    @Test
    public void testIfGetGradesWorks(){
        Student fer = new Student(1L, "fer");
        fer.addGrade(90);
        fer.addGrade(70);
        assertSame(90, fer.getGrades().get(0));
        assertSame(70, fer.getGrades().get(1));
    }

    @Test
    public void testIfGetAVGWorks(){
        Student fer = new Student(1L, "fer");
        fer.addGrade(90);
        fer.addGrade(70); // 160 / 2 = 80
        assertEquals(80, fer.getGradeAverage(), 0);
        fer.addGrade(50); // 210 / 3 = 70
        assertEquals(70, fer.getGradeAverage(), 0);
    }

   // TODO: test to make sure that updateGrade works -> use getGradeAverage() to do so.
    //  getGradeAverage() should be what you would expect from updating the lowest grade
    @Test
    public void updateGrade_TakesInNewGrade_ExpectsNewGradeAverage(){
        //Arrange
        Student testStudent = new Student(1, "raul");
        testStudent.addGrade(100);
        testStudent.addGrade(100);
        testStudent.addGrade(100);
        testStudent.addGrade(100);
        testStudent.addGrade(69);

        //Act
        testStudent.updateGrade(100);
        double testAverage = testStudent.getGradeAverage();


        //Assert
        Assert.assertEquals(100, testAverage, 0);
    }

    // TODO: do the same for deleteGrade() -> make sure it is deleted by testing the size of the grades list and checking the new average

    @Test
    public void deleteGrade_TakesNoArguments_RemovesLowestGradeForHigherAverage () {
        //Arrange
        Student testStudent = new Student(1, "raul");
        testStudent.addGrade(100);
        testStudent.addGrade(100);
        testStudent.addGrade(100);
        testStudent.addGrade(100);
        testStudent.addGrade(69);

        //Act
        testStudent.deleteGrade();
        double testAverage = testStudent.getGradeAverage();

        //Assert
        Assert.assertEquals(100, testAverage, 0);
    }
}
