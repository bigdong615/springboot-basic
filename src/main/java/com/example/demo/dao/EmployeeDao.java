package com.example.demo.dao;

import com.example.demo.pojo.Department;

import com.example.demo.pojo.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

@Repository
public class EmployeeDao {

    private static Map<Integer, Employee> employees = null;
    @Autowired
    DepartmentDao departmentDao;


    static {
        employees = new HashMap<Integer, Employee>();
        employees.put(101, new Employee(111, "rock1", "111.test@111", 1, new Department(111, "test2")));
        employees.put(102, new Employee(112, "rock2", "112.test@111", 2, new Department(111, "test2")));
        employees.put(103, new Employee(113, "rock3", "113.test@111", 2, new Department(111, "test2")));
        employees.put(104, new Employee(114, "rock4", "114.test@111", 2, new Department(111, "test2")));
        employees.put(105, new Employee(115, "rock5", "115.test@111", 2, new Department(111, "test2")));

    }

    private Integer init_id = 106;

    public void save(Employee employee) {
        if (employee.getId() == null) {
            employee.setId(init_id++);

        }
        employee.setDepartment(departmentDao.getDepartment(employee.getDepartment().getId()));
        employees.put(employee.getId(), employee);

    }

    public Collection<Employee> getAll() {
        return employees.values();
    }

    public Employee getEmployeeByid(Integer id) {
        return employees.get(id);
    }

    public Employee delete(Integer id) {
        return employees.remove(id);
    }
}
