package solid.dip.refactor.persistence;

import com.tv.training.solid.dip.refactor.Employee;

import java.util.ArrayList;
import java.util.List;

public class EmployeeMemoryPersistence implements EmployeePersistence {

    private List<Employee> employees;

    public EmployeeMemoryPersistence() {
        employees = new ArrayList<>();
    }

    public List<Employee> findAll() {
        return employees;
    }

    @Override
    public void save(Employee employee) {
        employees.add(employee);
    }

    @Override
    public void findABC() {

    }
}
