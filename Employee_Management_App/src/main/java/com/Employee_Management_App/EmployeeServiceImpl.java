package com.Employee_Management_App;


import java.util.List;

import org.springframework.stereotype.Service;
@Service
public class EmployeeServiceImpl implements EmployeeService {
	
	private EmployeeRepository employeeRepository;
	
public EmployeeServiceImpl(EmployeeRepository employeeRepository) {
		super();
		this.employeeRepository = employeeRepository;
	}

//List<Employee>emp=new ArrayList<>();

	@Override
	public List<Employee>  getAllEmployee() {
				return employeeRepository.findAll();
	}


	@Override
	public Employee getEmployeeById(Long id) {
		Employee emp=employeeRepository.findById(id).get();
		if (emp!=null) {
			return emp;
		} else {
			return null;
		}
	
	}
	@Override
	public Boolean addEmployee(Employee employee) {
		Employee emp=employeeRepository.save(employee);
		if(emp!=null) {
		return true;
		}else {
			return false;
		}
		
	}
	@Override
	public Boolean deleteEmployee(Long id) {
		Employee emp=employeeRepository.findById(id).get();	
	employeeRepository.delete(emp);
		return true;
	
		
	}

	@Override
	public Boolean updateEmployee(Long id, Employee employee) {
		Employee emp=employeeRepository.findById(id).get();
		emp.setFirstName(employee.getFirstName());
		emp.setLastName(employee.getLastName());
		emp.setEmail(employee.getEmail());
		employeeRepository.save(emp);
	   return true;
	}
	


}
