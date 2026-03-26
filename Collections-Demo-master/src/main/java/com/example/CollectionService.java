package com.example;

import java.util.*;

public class CollectionService {

    // LIST - Maintains order, allows duplicates
    private List<String> list = new ArrayList<>();

    // SET - No duplicates allowed
    private Set<String> set = new HashSet<>();

    // MAP - Key-Value pairs
    private Map<Integer, String> map = new HashMap<>();

    // -------- LIST METHODS --------
    public void addToList(String value) {
        list.add(value);
    }

    public boolean removeFromList(String value) {
        return list.remove(value);
    }

    public boolean searchInList(String value) {
        return list.contains(value);
    }

    public List<String> getList() {
        return list;
    }

    // -------- SET METHODS --------
    public void addToSet(String value) {
        set.add(value);
    }

    public boolean removeFromSet(String value) {
        return set.remove(value);
    }

    public boolean searchInSet(String value) {
        return set.contains(value);
    }

    public Set<String> getSet() {
        return set;
    }

    // -------- MAP METHODS --------
    public void addToMap(Integer key, String value) {
        map.put(key, value);
    }

    public String removeFromMap(Integer key) {
        return map.remove(key);
    }

    public boolean searchInMap(Integer key) {
        return map.containsKey(key);
    }

    public Map<Integer, String> getMap() {
        return map;
    }
}
