package com.Employee_Management_App;


import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;
@Service
public class EmployeeServiceImpl implements EmployeeService {
	
	private EmployeeRepository employeeRepository;
	
public EmployeeServiceImpl(EmployeeRepository employeeRepository) {
		super();
		this.employeeRepository = employeeRepository;
	}



	@Override
	public List<Employee>  getAllEmployee() {
				return employeeRepository.findAll();
	}


	@Override
	public Employee getEmployeeById(Long id) {
		Optional<Employee> emp=employeeRepository.findById(id);
		System.out.println(emp);
		return emp.orElse(null);
		
	
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
		Optional<Employee> emp=employeeRepository.findById(id);
		if (emp.isPresent()) {
			employeeRepository.deleteById(id);
			return true;
		} else {
return false;
		}
		
	}

	@Override
	public Boolean updateEmployee(Long id, Employee employee) {
		Optional<Employee> emp=employeeRepository.findById(id);
		System.out.println("Upodated========="+emp);
		System.out.println(emp.equals(employee));
		if (emp.isPresent()) {
			Employee employ=emp.get();
			employ.setFirstName(employee.getFirstName());
			employ.setLastName(employee.getLastName());
			employ.setEmail(employee.getEmail());
			employeeRepository.save(employ);
			 return true;
		} else {
			 return false;
		}
		
		
	  
	}
	


}
