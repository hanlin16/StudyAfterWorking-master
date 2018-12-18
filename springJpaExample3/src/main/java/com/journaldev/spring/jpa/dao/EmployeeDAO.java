package com.journaldev.spring.jpa.dao;

import com.journaldev.spring.jpa.model.Employee;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by zhaoguoyu on 2016/6/22.
 */
public interface EmployeeDAO extends CrudRepository<Employee,Integer> {
//    //Create
//    public void save(Employee employee);
//    //Read
//    public Employee getById(int id);
//    //Update
//    public void update(Employee employee);
//    //Delete
//    public void deleteById(int id);
//    //Get All
//    public List<Employee> getAll();

    Iterable<Employee> findByRole(String role);

    Iterable<Employee> findByName(String name);
}
