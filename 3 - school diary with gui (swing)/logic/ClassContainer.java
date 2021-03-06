package logic;

import java.util.*;
import java.util.stream.Collectors;

public class ClassContainer {
    private Map<String, Class> classes = new HashMap<String, Class>();

    public Set<String> getKeySet(){
        return classes.keySet();
    }

    public void addClass(final Class className) {
        classes.put(className.getGroupName(), className);
    }

    public void addClass(final String className, final int quantity) {
        Class newClass = new Class(className, quantity);
        classes.put(className, newClass);
    }

    public void editClassname(final String oldClassName, final String newClassName, final int quantity) {
        classes.get(oldClassName).setGroupName(newClassName);
        classes.get(oldClassName).setMaxNumberOfStudents(quantity);
    }

    public void removeClass(final String className) {
        classes.remove(className);
    }

    public List<Class> findEmpty() {
        List<Class> classesToReturn = new ArrayList<Class>();
        classesToReturn = classes.values().stream().filter(aClass -> aClass.numberOfStudents() == 0).collect(Collectors.toList());
        return classesToReturn;
    }

    public Map<String, Class> getClasses() {
        return classes;
    }

    public void summary() {
        for (String key : classes.keySet()) {
            System.out.println("Classname: " + key + "\nPercentage of filling: " + classes.get(key).numberOfStudents() * 100 / classes.get(key).getMaxNumberOfStudents() + "%");
        }
    }

    public void sortByClassname() {
        this.classes = new TreeMap<>(this.classes);
    }

    public Class getClassByKey(String key) {
        return classes.get(key);
    }
}
