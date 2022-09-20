package tech.com.employeemanager.EmployeeCrudService;

import org.springframework.beans.factory.annotation.Autowired;
import tech.com.employeemanager.model.Employee;
import tech.com.employeemanager.repo.EmployeeRepository;

import java.util.ArrayList;
import java.util.List;

public class CrudService {


    @Autowired
    EmployeeRepository employeeRepository;

    public List<String> employeeOnlyName(){
        List<Employee> employeeList = employeeRepository.findAll();
        List<String> names = new ArrayList<>();
        for(Employee empName: employeeList){
            String name = empName.getName();
            names.add(name);
        }
        return names;
    }
}
