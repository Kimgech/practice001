package com.example.practice001.repository;

import com.example.practice001.model.Employee;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;
import java.util.List;

@Repository
public class EmployeeRepository {
    @PersistenceContext
    private EntityManager entityManager;

    public List<Employee> findAll(){
        TypedQuery<Employee> query = entityManager.createQuery("SELECT e FROM Employee e", Employee.class);
        return query.getResultList();
    }
    public Employee findById(long id) {
        Employee employee = (Employee) entityManager.find(Employee.class, id);
        return employee;
    }

    @Transactional
     public Employee save(Employee employee) {
        System.out.println(employee);
        entityManager.merge(employee);
    return employee;

    }

    @Transactional
    public Employee update(Employee employee) {
        entityManager.merge(employee);
        return employee;
    }

    @Transactional
    public Employee deleteById(long id) {
    Employee employee = findById(id);
    if (employee != null) {
      entityManager.remove(employee);
    }
    return employee;
    }
}
