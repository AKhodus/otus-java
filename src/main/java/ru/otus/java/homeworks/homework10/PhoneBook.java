package ru.otus.java.homeworks.homework10;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PhoneBook {
    private Map<String, List<String>> contacts = new HashMap<>();

    public void add(String name, String phoneNumber) {
        List<String> phoneNumbers = contacts.getOrDefault(name, new ArrayList<>());
        phoneNumbers.add(phoneNumber);
        contacts.put(name, phoneNumbers);
    }

    public List<String> find(String name) {
        return contacts.get(name);
    }

    public boolean containsPhoneNumber(String phoneNumber) {
        for (List<String> phoneNumbers : contacts.values()) {
            if (phoneNumbers.contains(phoneNumber)) {
                return true;
            }
        }
        return false;
    }
}
