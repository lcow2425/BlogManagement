package models;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class PersonTest {
    @Test
    void testValidPersonCreation() {
        Person person = new Person("1", "John", "Doe", 25, "Male");
        assertEquals("John", person.getFirstName());
    }

    @Test
    void testInvalidPersonCreation() {
        assertThrows(IllegalArgumentException.class, () -> new Person(null, "John", "Doe", 25, "Male"));
        assertThrows(IllegalArgumentException.class, () -> new Person("1", "", "Doe", 25, "Male"));
        assertThrows(IllegalArgumentException.class, () -> new Person("1", "John", null, 25, "Male"));
        assertThrows(IllegalArgumentException.class, () -> new Person("1", "John", "Doe", -5, "Male"));
    }
}