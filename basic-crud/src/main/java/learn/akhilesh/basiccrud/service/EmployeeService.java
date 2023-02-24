package learn.akhilesh.basiccrud.service;

import learn.akhilesh.basiccrud.entity.Employee;
import learn.akhilesh.basiccrud.entity.repo.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;

    public List<Employee> getAllEmployee() {
        return employeeRepository.findAll();
    }
}
