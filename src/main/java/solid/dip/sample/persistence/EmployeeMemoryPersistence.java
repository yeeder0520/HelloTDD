package solid.dip.sample.persistence;


import solid.dip.sample.Employee;

import java.util.ArrayList;
import java.util.List;

public class EmployeeMemoryPersistence implements EmployeePersistence {

    private List<Employee> employees;

    public EmployeeMemoryPersistence() {
        employees = new ArrayList<Employee>();
    }

    public List<Employee> findAll() {
        return employees;
    }

    @Override
    public void save(Employee employee) {
        employees.add(employee);
    }
}
