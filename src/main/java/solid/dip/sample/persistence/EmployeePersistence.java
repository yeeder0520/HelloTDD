package solid.dip.sample.persistence;

import com.tv.training.solid.dip.sample.Employee;

import java.util.List;

public interface EmployeePersistence {

    public List<Employee> findAll();

    public void save(Employee employee);
}
