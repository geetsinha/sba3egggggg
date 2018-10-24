package com.eg.sba.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.eg.sba.dao.EmployeeDAO;
import com.eg.sba.model.Employee;

@RestController
public class EmployeeController {
	
	@Autowired
	private EmployeeDAO edao;
	
	@RequestMapping("/")
	@ResponseBody
	public String welcome() {
		return "WELCOME";
	}
	
	// URL:
    // http://localhost:8080/SomeContextPath/employees
    // http://localhost:8080/SomeContextPath/employees.xml
    // http://localhost:8080/SomeContextPath/employees.json
    @RequestMapping(value = "/employees",method = RequestMethod.GET,produces = { MediaType.APPLICATION_JSON_VALUE,
                    MediaType.APPLICATION_XML_VALUE })
    @ResponseBody
    public List<Employee> getEmployees() {
        List<Employee> list = edao.getAllEmployees();
        return list;
    }
 
    // URL:
    // http://localhost:8080/SomeContextPath/employee/{empno}
    // http://localhost:8080/SomeContextPath/employee/{empno}.xml
    // http://localhost:8080/SomeContextPath/employee/{empno}.json
    @RequestMapping(value = "/employee/{empno}", //
            method = RequestMethod.GET, //
            produces = { MediaType.APPLICATION_JSON_VALUE, //
                    MediaType.APPLICATION_XML_VALUE })
    @ResponseBody
    public Employee getEmployee(@PathVariable("empno") String empno) {
        return edao.getEmployee(empno);
    }
    
    
    
 // URL:
    // http://localhost:8080/SomeContextPath/employee
    // http://localhost:8080/SomeContextPath/employee.xml
    // http://localhost:8080/SomeContextPath/employee.json
 
    @RequestMapping(value = "/employee", 
            method = RequestMethod.POST, 
            produces = { MediaType.APPLICATION_JSON_VALUE,
                    MediaType.APPLICATION_XML_VALUE })
    @ResponseBody
    public Employee addEmployee(@RequestBody Employee emp) {
 
        System.out.println("(Service Side) Creating employee: " + emp.getEmpno());
 
        return edao.addEmployee(emp);
    }
 
    // URL:
    // http://localhost:8080/SomeContextPath/employee
    // http://localhost:8080/SomeContextPath/employee.xml
    // http://localhost:8080/SomeContextPath/employee.json
    @RequestMapping(value = "/employee",
            method = RequestMethod.PUT,
            produces = { MediaType.APPLICATION_JSON_VALUE,
                    MediaType.APPLICATION_XML_VALUE })
    @ResponseBody
    public Employee updateEmployee(@RequestBody Employee emp) {
 
        System.out.println("(Service Side) Editing employee: " + emp.getEmpno());
 
        return edao.updateEmployee(emp);
    }
 
    // URL:
    // http://localhost:8080/SomeContextPath/employee/{empno}
    @RequestMapping(value = "/employee/{empno}", //
            method = RequestMethod.DELETE, //
            produces = { MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE })
    @ResponseBody
    public void deleteEmployee(@PathVariable("empno") String empno) {
 
        System.out.println("(Service Side) Deleting employee: " + empno);
 
        edao.deleteEmployee(empno);
    }
 
 
	
	
	
	

}
