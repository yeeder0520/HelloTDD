package solid.dip.sample.persistence;


import solid.dip.sample.Employee;

import java.util.List;

public interface EmployeePersistence {

    public List<Employee> findAll();

    public void save(Employee employee);
}
