package tech.com.employeemanager.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tech.com.employeemanager.exception.UserNotFoundException;
import tech.com.employeemanager.model.Employee;
import tech.com.employeemanager.repo.EmployeeRepository;
import tech.com.employeemanager.EmployeeCrudService.CrudService;


import java.util.List;
import java.util.UUID;

@Service
public class EmployeeService {

    private final EmployeeRepository employeeRepository;
    private final CrudService employeeCrudService;

    @Autowired
    public EmployeeService(EmployeeRepository employeeRepository, CrudService employeeCrudService) {
        this.employeeRepository = employeeRepository;
        this.employeeCrudService = employeeCrudService;
    }


    public Employee addEmployee(Employee employee){
        employee.setEmployeeCode(UUID.randomUUID().toString());
        return employeeRepository.save(employee);
    }

    public List<Employee> findAllEmployee(){
        return employeeRepository.findAll();
    }

    public List<String> findOnlyNames(){
        return employeeCrudService.employeeOnlyName();
    }

    public Employee updateEmployee(Employee employee){
        return employeeRepository.save(employee);
    }

    public Employee findEmployeeById(Long id){
        return employeeRepository.findEmployeeById(id)
                .orElseThrow(() -> new UserNotFoundException("User by id " + id + " was not found"));
    }

    public void deleteEmployee(Long id){
        employeeRepository.deleteEmployeeById(id);
    }
}
