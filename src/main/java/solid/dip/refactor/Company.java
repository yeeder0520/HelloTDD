package solid.dip.refactor;


import solid.dip.refactor.persistence.Persistence;

import java.util.List;

public class Company {

    Persistence persistence;

    public Company(Persistence persistence) {
        this.persistence = persistence;
    }

    public List<?> getEmployees() {
        return persistence.findAll();
    }

    public void addEmployee(Employee e) {
        persistence.save(e);
    }
}
