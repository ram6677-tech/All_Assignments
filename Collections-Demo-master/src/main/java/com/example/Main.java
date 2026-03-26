package com.example;

public class Main {

    public static void main(String[] args) {

        CollectionService service = new CollectionService();

        // =========================================================
        // LIST - Advantage & Use Case Example
        // Advantage: Maintains insertion order & allows duplicates
        // Use Case: Shopping Cart (Same item can be added multiple times)
        // =========================================================

        service.addToList("Apple");
        service.addToList("Banana");
        service.addToList("Apple"); // duplicate allowed

        System.out.println("Shopping Cart (List): " + service.getList());

        // =========================================================
        // SET - Advantage & Use Case Example
        // Advantage: Does not allow duplicates
        // Use Case: Unique Email Registration
        // =========================================================

        service.addToSet("user1@gmail.com");
        service.addToSet("user2@gmail.com");
        service.addToSet("user1@gmail.com"); // duplicate ignored

        System.out.println("Registered Emails (Set): " + service.getSet());

        // =========================================================
        // MAP - Advantage & Use Case Example
        // Advantage: Fast key-based lookup using unique keys
        // Use Case: Student ID → Student Name mapping
        // =========================================================

        service.addToMap(101, "Ram");
        service.addToMap(102, "Krishna");

        System.out.println("Student with ID 101 (Map): " 
                + service.getMap().get(101));
    }
}
