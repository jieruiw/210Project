package model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class WardrobeTest {
    private Wardrobe testWardrobe;

    @BeforeEach
    void setup() {
        testWardrobe = new Wardrobe();
    }

    @Test
    void testConstructor() {
        assertEquals(0, testWardrobe.getSize());
    }

    @Test
    void testGetOutfits() {
        assertEquals("The wardrobe is empty!", testWardrobe.getOutfits());
        testWardrobe.createOutfit("formal");
        testWardrobe.createOutfit("school");
        assertEquals("[formal, school]", testWardrobe.getOutfits());
    }

    @Test
    void testFindOutfit() {
        assertEquals(null, testWardrobe.findOutfit("anything"));
        Outfit formal = testWardrobe.createOutfit("formal");
        assertEquals(formal, testWardrobe.findOutfit("formal"));
        assertEquals(null, testWardrobe.findOutfit("casual"));
    }

    @Test
    void testRemoveOutfit() {
        Outfit formal = testWardrobe.createOutfit("formal");
        testWardrobe.createOutfit("school");
        assertEquals(2, testWardrobe.getSize());
        assertEquals("[formal, school]", testWardrobe.getOutfits());
        testWardrobe.removeOutfit(formal);
        assertEquals(1, testWardrobe.getSize());
        assertEquals("[school]", testWardrobe.getOutfits());
    }

    @Test
    void testContains() {
        testWardrobe.createOutfit("formal");
        testWardrobe.createOutfit("school");
        assertTrue(testWardrobe.contains("formal"));
        assertFalse(testWardrobe.contains("booze"));
    }
}
