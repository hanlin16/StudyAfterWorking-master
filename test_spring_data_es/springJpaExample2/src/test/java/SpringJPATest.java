import com.journaldev.spring.jpa.dao.EmployeeDAO;
import com.journaldev.spring.jpa.model.Employee;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractTransactionalJUnit4SpringContextTests;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import javax.annotation.Resource;
import java.util.Iterator;
import java.util.Random;

/**
 * Created by zhaoguoyu on 2016/6/22.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:spring.xml")
public class SpringJPATest /*extends AbstractTransactionalJUnit4SpringContextTests */{
    @Autowired
    private EmployeeDAO employeeDAO;

    @Test
    public void testSave(){
        Employee emp = new Employee();
        int rand = new Random().nextInt(1000);
        emp.setId(rand);
        emp.setName("Pankaj");
        emp.setRole("Java Developer");
        employeeDAO.save(emp);
        emp.setName(emp.getName() + "_update");
        employeeDAO.save(emp);

        Iterable<Employee> employees = employeeDAO.findAll();
        Iterator<Employee> iterator = employees.iterator();
        while(iterator.hasNext()){
            System.out.println(iterator.next());
        }

        System.out.println("--------------");
        Iterable<Employee> employees1 = employeeDAO.findByRole("Java Developer");
        Iterator<Employee> iterator2 = employees1.iterator();
        while(iterator2.hasNext()){
            System.out.println(iterator2.next());
        }

    }
}
