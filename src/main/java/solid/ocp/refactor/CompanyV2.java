package solid.ocp.refactor;

import solid.ocp.refactor.employee.EmployeeMemoryPersistence;
import solid.ocp.refactor.employee.EmployeeV2;

import java.util.List;

public class CompanyV2 {

    private final EmployeeMemoryPersistence employeeMemoryPersistence;

    public CompanyV2() {
        employeeMemoryPersistence = new EmployeeMemoryPersistence();
    }

    public List<EmployeeV2> getAllEmployee() {
        return employeeMemoryPersistence.findAll();
    }

    public void addEmployee(EmployeeV2 employee) {
        employeeMemoryPersistence.save(employee);
    }
}
