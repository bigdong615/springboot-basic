package com.example.demo.dao;

import com.example.demo.pojo.Department;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

@Repository
public class DepartmentDao {

    private static Map<Integer, Department> departments = null;

    static {
        departments = new HashMap<Integer, Department>();
        departments.put(101, new Department(101, "eductation"));
        departments.put(102, new Department(102, "market"));
        departments.put(103, new Department(103, "principal"));
    }

    public Collection<Department> getAllDepartment() {
        return departments.values();
    }

    public Department getDepartment(int id) {

        return departments.get(id);
    }


}
