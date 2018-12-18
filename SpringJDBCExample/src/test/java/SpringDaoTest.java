import com.journaldev.spring.jdbc.dao.EmployeeDAO;
import com.journaldev.spring.jdbc.model.Employee;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import javax.annotation.Resource;
import java.util.Random;

/**
 * Created by Administrator on 2016/6/21.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:spring.xml")
public class SpringDaoTest {
    @Resource(name="employeeTemplateDAO")
    private EmployeeDAO employeeTemplateDAO;
    @Resource(name = "employeeDAO")
    private EmployeeDAO employeeDAO;

    @Test
    public void testSave(){
        Employee emp = new Employee();
        int rand = new Random().nextInt(1000);
        emp.setId(rand);
        emp.setName("Pankaj_jdbcTeamploate");
        emp.setRole("Java Developer");
        employeeDAO.save(emp);
    }

    @Test
    public void getEmployee(){
        Integer id = 279;
        Employee employee = employeeDAO.getById(id);
        System.out.println(employee.toString());
    }

    @Test
    public void testSave2(){
        Employee emp = new Employee();
        int rand = new Random().nextInt(1000);
        emp.setId(rand);
        emp.setName("Pankaj-2");
        emp.setRole("Java Developer-2");
        employeeTemplateDAO.save(emp);
    }
}
