package solid.dip.refactor.persistence;

import solid.dip.refactor.Employee;

import java.util.List;

public interface Persistence {

    List<Employee> findAll();

    void save(Employee employee);
}
