package learn.akhilesh.basiccrud.entity.repo;

import learn.akhilesh.basiccrud.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {
}
