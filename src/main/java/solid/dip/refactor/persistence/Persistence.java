package solid.dip.refactor.persistence;

import com.tv.training.solid.dip.refactor.Employee;

import java.util.List;

public interface Persistence {

    List<?> findAll();

    <T extends Employee> void save(T employee);
}
