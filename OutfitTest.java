package model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class OutfitTest {
    private Outfit testOutfit;

    @BeforeEach
    void runBefore() {
        testOutfit = new Outfit("beach");
    }

    @Test
    void testConstructor() {
        assertEquals("beach", testOutfit.getName());
        assertEquals(0, testOutfit.getSize());
    }

    @Test
    void testAdd() {
        testOutfit.addClothing("sandals");
        testOutfit.addClothing("sunglasses");
        testOutfit.addClothing("shorts");
        testOutfit.addClothing("shirt");
        assertEquals(4, testOutfit.getSize());
    }

    @Test
    void testRemove() {
        testOutfit.addClothing("sandals");
        testOutfit.addClothing("sunglasses");
        testOutfit.addClothing("shorts");
        testOutfit.addClothing("shirt");
        assertEquals(4, testOutfit.getSize());
        testOutfit.removeClothing("shirt");
        assertEquals(3, testOutfit.getSize());
    }

    @Test
    void testGet() {
        assertEquals("This outfit is empty.", testOutfit.getOutfit());
        testOutfit.addClothing("sandals");
        testOutfit.addClothing("sunglasses");
        assertEquals("Outfit beach has [sandals, sunglasses]", testOutfit.getOutfit());
    }

    @Test
    void testContains() {
        testOutfit.addClothing("sandals");
        testOutfit.addClothing("sunglasses");
        testOutfit.addClothing("shorts");
        testOutfit.addClothing("shirt");
        assertTrue(testOutfit.contains("sandals"));
        assertFalse(testOutfit.contains("suit"));
    }

}
