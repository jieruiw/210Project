package persistence;

import model.Outfit;
import model.Wardrobe;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class JsonTest {
    protected void checkOutfit(String name, Outfit outfit) {
        assertEquals(name, outfit.getName());

    }
}
