package com.crud.controllers;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.crud.exceptions.ResourceNotFoundException;
import com.crud.models.Employee;
import com.crud.repository.EmployeeRepository;


@RestController
@RequestMapping("/api")
public class EmployeeController {
	@Autowired
private EmployeeRepository employeeRepository;
	
@GetMapping("/employees")
public List<Employee>getAllemployees(){
	return employeeRepository.findAll();
}

@PostMapping("/employees")
public Employee addEmployee(@RequestBody Employee emp) {
	return employeeRepository.save(emp); 
}
@PutMapping("/employees/{id}")  
public ResponseEntity<Employee> update( @PathVariable long id,@RequestBody Employee employee) {
	Employee emp= employeeRepository.findById(id)
			.orElseThrow(() -> new ResourceNotFoundException("Employee not Exist With id ;" +id));
	
	emp.setFirstName(employee.getFirstName());
	emp.setLastName(employee.getLastName());
	emp.setEmail(employee.getEmail());
	Employee update=employeeRepository.save(emp);
	return ResponseEntity.ok(update); 
}

@GetMapping("/employees/{id}")
  public ResponseEntity<Employee> getemployeById(@PathVariable long id)
{   Employee emp= employeeRepository.findById(id)
		.orElseThrow(() -> new ResourceNotFoundException("Employee not Exist With id ;" +id));
	  return  ResponseEntity.ok(emp);
}
@DeleteMapping("employees/{id}")
public ResponseEntity <Map<String, Boolean>> deleteEmploye(@PathVariable long id) {
	Employee emp= employeeRepository.findById(id)
			.orElseThrow(() -> new ResourceNotFoundException("Employee not Exist With id ;" +id));
	employeeRepository.delete(emp);
	Map<String ,Boolean> response = new HashMap<>();
	response.put("deleted", Boolean.TRUE);

   return ResponseEntity.ok(response);
}


}
