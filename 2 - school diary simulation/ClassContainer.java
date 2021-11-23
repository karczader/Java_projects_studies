import java.util.*;

public class ClassContainer {
    public Map<String, Class> groups = new HashMap<>();

    public void addClass(String nameOfGroups, int numberOfStudent) {
        groups.put(nameOfGroups, new Class(nameOfGroups, null, numberOfStudent));
    }

    public void removeClass(String nameOfGroups) {
        for (String key : groups.keySet()) {
            if (groups.get(key).equals(nameOfGroups)) {
                groups.remove(key);
            }
        }
    }

    public List<Class> findEmpty() {
        List<Class> emptyClass = new ArrayList();
        for (Class value : groups.values()) {
            if (value.getListOfStudent() == null) {
                emptyClass.add(value);
            }
        }
        return emptyClass;
    }

    public void summary() {
        System.out.println("\n___PODSUMOWANIE___");
        Set<Map.Entry<String, Class>> entries = groups.entrySet();
        for (Map.Entry<String, Class> entry : entries) {
            System.out.println(entry.getKey());
        }
    }
}
