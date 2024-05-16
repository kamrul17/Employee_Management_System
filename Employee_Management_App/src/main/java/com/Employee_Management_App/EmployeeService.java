package com.Employee_Management_App;

import java.util.List;

public interface EmployeeService {
	List<Employee> getAllEmployee();
Boolean addEmployee(Employee employee);
Boolean deleteEmployee(Long id);
Boolean updateEmployee(Long id, Employee employee);
Employee getEmployeeById(Long id);

}
