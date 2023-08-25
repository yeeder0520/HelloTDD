package solid.ocp.refactor.employee;

import com.tv.training.solid.ocp.sample.Programmer;

import java.util.ArrayList;
import java.util.List;

/**
 * @author YeeDer
 * @since 2023/8/23 PM 02:15
 **/
public class EmployeeMemoryPersistence {

    private List<EmployeeV2> employeeV2s;

    public EmployeeMemoryPersistence() {
        employeeV2s = new ArrayList<EmployeeV2>();
    }

    public <T extends EmployeeV2>List<EmployeeV2> findAll() {
        return employeeV2s;
    }

    public void save(EmployeeV2 employee) {
        employeeV2s.add(employee);
    }

    public <T extends EmployeeV2> List<T> findAll(Class<T> targetType) {
        List<T> result = new ArrayList<>();

        for (EmployeeV2 employee : employeeV2s) {
            if (targetType.isInstance(employee)) {
                result.add(targetType.cast(employee));
            }
        }

        return result;
    }
}
