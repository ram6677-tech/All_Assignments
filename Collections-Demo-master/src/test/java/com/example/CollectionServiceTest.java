package com.example;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CollectionServiceTest {

    private CollectionService service;

    @BeforeEach
    void setUp() {
        service = new CollectionService();
    }

    // -------- LIST TESTS --------
    @Test
    void testAddAndSearchInList() {
        service.addToList("Apple");
        assertTrue(service.searchInList("Apple"));
    }

    @Test
    void testRemoveFromList() {
        service.addToList("Banana");
        assertTrue(service.removeFromList("Banana"));
    }

    // -------- SET TESTS --------
    @Test
    void testNoDuplicatesInSet() {
        service.addToSet("Email");
        service.addToSet("Email");
        assertEquals(1, service.getSet().size());
    }

    @Test
    void testSearchInSet() {
        service.addToSet("Test");
        assertTrue(service.searchInSet("Test"));
    }

    // -------- MAP TESTS --------
    @Test
    void testAddAndSearchInMap() {
        service.addToMap(1, "Ram");
        assertTrue(service.searchInMap(1));
    }

    @Test
    void testRemoveFromMap() {
        service.addToMap(2, "Krishna");
        assertEquals("Krishna", service.removeFromMap(2));
    }
}