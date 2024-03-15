import domain.Student;
import org.junit.Test;
import repository.StudentRepository;
import validation.StudentValidator;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

public class AppTest {
    public Student student;
    public StudentRepository studentRepo;
    @Test
    public void shouldAndwerWithTrue()
    {
        studentRepo = new StudentRepository(new StudentValidator());
        assertTrue(true);
    }

    @Test
    public void tc_valid_student()
    {
        student = new Student("1", "Ana Pop", 333);
        try {
            studentRepo.save(student);
            assertTrue(true);
        }
        catch(Exception ex){
            fail();
        }
    }

    public void tc_invalid_student()
    {
        student = new Student("", "Ana Pop", 333);
        try {
            studentRepo.save(student);
            fail();
        }
        catch(Exception ex){
            assertTrue(true);
        }
    }
}
