package solid.ocp.refactor.employee;

/**
 * @author YeeDer
 * @since 2023/8/23 PM 02:06
 **/
public class EmployeeV2 {

    private String fullName;
    private Integer salary;

    public EmployeeV2(String fullName, Integer salary) {
        this.fullName = fullName;
        this.salary = salary;
    }

    public String getFullName() {
        return fullName;
    }
    public Integer getSalary() {
        return salary;
    }

}
