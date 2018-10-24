package com.eg.sba.dao;

import java.util.*;

import org.springframework.stereotype.Repository;

import com.eg.sba.model.Employee;

@Repository
public class EmployeeDAO {
	
	private static final Map <String , Employee> empMap= new HashMap<String,Employee>();
	
	static {
		initEmps();
	}

	private static void initEmps() {
        Employee emp1 = new Employee("E01", "Geet", "SE");
        Employee emp2 = new Employee("E02", "Yash", "DR");
        Employee emp3 = new Employee("E03", "Manish", "SE");
 
        empMap.put(emp1.getEmpno(), emp1);
        empMap.put(emp2.getEmpno(), emp2);
        empMap.put(emp3.getEmpno(), emp3);
    }
 
    public Employee getEmployee(String empNo) {
        return empMap.get(empNo);
    }
 
    public Employee addEmployee(Employee emp) {
        empMap.put(emp.getEmpno(), emp);
        return emp;
    }
 
    public Employee updateEmployee(Employee emp) {
        empMap.put(emp.getEmpno(), emp);
        return emp;
    }
 
    public void deleteEmployee(String empNo) {
        empMap.remove(empNo);
    }
 
    public List<Employee> getAllEmployees() {
        Collection<Employee> c = empMap.values();
        List<Employee> list = new ArrayList<Employee>();
        list.addAll(c);
        return list;
    }
	

}
