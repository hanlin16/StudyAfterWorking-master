package com.journaldev.spring.jpa;

import com.journaldev.spring.jpa.dao.EmployeeDAO;
import com.journaldev.spring.jpa.model.Employee;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.Random;

/**
 * Created by zhaoguoyu on 2016/6/22.
 */
public class Main {
    public static void main(String[] args) {
        ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("spring.xml");
        EmployeeDAO employeeDAO = ctx.getBean(EmployeeDAO.class);
        Employee emp = new Employee();
        int rand = new Random().nextInt(1000);
        emp.setId(rand);
        emp.setName("Pankaj");
        emp.setRole("Java Developer");
        employeeDAO.save(emp);
    }
}
