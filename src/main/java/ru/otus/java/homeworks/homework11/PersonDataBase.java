package ru.otus.java.homeworks.homework11;

import java.util.HashMap;
import java.util.Map;

public class PersonDataBase {
    Map<Long, Person> map = new HashMap<>();

    public void add(Person person) {
        map.put(person.getId(), person);
    }

    public Person findById(long id) {
        return map.get(id);
    }

    public boolean isEmployee(long id) {
        Person person = findById(id);
        return person != null && !isManager(person);
    }

    public boolean isManager(Person person) {
        Position position = person.getPosition();
        return position == Position.MANAGER || position == Position.DIRECTOR || position == Position.BRANCH_DIRECTOR || position == Position.SENIOR_MANAGER;
    }
}