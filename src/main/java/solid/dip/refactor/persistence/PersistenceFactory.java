package solid.dip.refactor.persistence;


import java.util.HashMap;
import java.util.Map;

/**
 * @author YeeDer
 * @since 2023/8/23 PM 04:50
 **/
public class PersistenceFactory {

    Map<String, Persistence> persistenceMap = new HashMap<>();

    public PersistenceFactory() {
        persistenceMap.put("Employee", new EmployeeMemoryPersistence());
        // more...
    }

    public Persistence getPersistence(String persistenceType) {
        return persistenceMap.get(persistenceType);
    }
}
