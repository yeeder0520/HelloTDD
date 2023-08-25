package solid.ocp.refactor.employee;

import com.tv.training.solid.ocp.refactor.employee.EmployeeV2;

public class ProgrammerV2 extends EmployeeV2 {

    private String fullName;
    private Integer salary;

    public ProgrammerV2(String fullName, Integer salary) {
        super(fullName, salary);
    }

}
