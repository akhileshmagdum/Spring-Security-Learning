package learn.akhilesh.basiccrud;

import jakarta.annotation.PostConstruct;
import learn.akhilesh.basiccrud.entity.Employee;
import learn.akhilesh.basiccrud.entity.repo.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.List;

@SpringBootApplication
public class BasicCrudApplication {

    @Autowired
    private EmployeeRepository employeeRepository;

    public static void main(String[] args) {
        SpringApplication.run(BasicCrudApplication.class, args);
    }

    @PostConstruct
    private void loadDummyData() {
        List<Employee> dummyEmployeeList = List
                .of(Employee.builder()
                                .name("Akhilesh")
                                .mobNo("912345678")
                                .password("Test@123")
                                .build(),
                        Employee.builder()
                                .name("Amit")
                                .mobNo("9876872345")
                                .password("Test@123")
                                .build(),
                        Employee.builder()
                                .name("Vijay")
                                .mobNo("9034456765")
                                .password("Test@123")
                                .build());

        employeeRepository.saveAll(dummyEmployeeList);
    }

}
