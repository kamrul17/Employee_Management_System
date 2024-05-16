package com.Employee_Management_App;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
@RestController
@RequestMapping("/employees")
public class EmployeeController {
	private EmployeeService employeeService;
public EmployeeController(EmployeeService employeeService) {
		super();
		this.employeeService = employeeService;
	}
@GetMapping
	public ResponseEntity< List<Employee>> getAllEmployee(){
		return new ResponseEntity<>(employeeService.getAllEmployee(),HttpStatus.OK);
	}
@GetMapping("/{id}")
public ResponseEntity<Employee>  getEmployeeById(@PathVariable Long id){
	Employee emp=employeeService.getEmployeeById(id);
	if (emp!=null) {
		return new ResponseEntity<>(emp,HttpStatus.OK);
	} else {
		return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	}
}
	@PostMapping
	public ResponseEntity<String> addEmployee(@RequestBody Employee employee){
		Boolean isAdded=employeeService.addEmployee(employee);
		if (isAdded) {
			return new ResponseEntity<>("Employee added Successfully",HttpStatus.OK);
		} else {
			return new ResponseEntity<>( "Employee Not added ",HttpStatus.NOT_FOUND);
		}
	}
	@DeleteMapping("/{id}")
	public ResponseEntity<String> deleteEmployee(@PathVariable Long id) {
		Boolean isDeleted=employeeService.deleteEmployee(id);
		if(isDeleted) {
			return new ResponseEntity<>("Employee deleted Successfully",HttpStatus.OK);
		}else {
			return new ResponseEntity<>("Employee Not Deleted ",HttpStatus.NOT_FOUND);
		}
	}
	@PutMapping("/{id}")
	public ResponseEntity<String> updateEmployee(@PathVariable Long id,@RequestBody Employee employee) {
		Boolean isUpdated=employeeService.updateEmployee(id,employee);
		if (isUpdated) {
			return new ResponseEntity<>("Employee updated Successfully",HttpStatus.OK);
		} else {
			return new ResponseEntity<>("Employee Not Updated ",HttpStatus.NOT_FOUND);
		}
	}
	
	
}
