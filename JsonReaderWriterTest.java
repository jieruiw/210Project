package persistence;

import model.Outfit;
import model.Wardrobe;
import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;


public class JsonReaderWriterTest extends JsonTest{

    @Test
    void testWriterInvalidFile() {
        try {
            Wardrobe wardrobe = new Wardrobe();
            JsonWriter writer = new JsonWriter("./data/my\0illegal:fileName.json");
            writer.open();
            fail("IOException was expected");
        } catch (IOException e) {
            // pass
        }
    }

    @Test
    void testWriterEmptyWorkroom() {
        try {
            Wardrobe wardrobe = new Wardrobe();
            JsonWriter writer = new JsonWriter("./data/testWriterEmptyWardrobe.json");
            writer.open();
            writer.write(wardrobe);
            writer.close();

            JsonReader reader = new JsonReader("./data/testWriterEmptyWardrobe.json");
            wardrobe = reader.read();
            assertEquals(0, wardrobe.getSize());
        } catch (IOException e) {
            fail("Exception should not have been thrown");
        }
    }

    @Test
    void testWriterGeneralWorkroom() {
        try {
            Wardrobe wardrobe = new Wardrobe();
            wardrobe.createOutfit( "beach");
            Outfit testOutfit = wardrobe.createOutfit("dinner");
            testOutfit.addClothing("tux");
            JsonWriter writer = new JsonWriter("./data/testWriterGeneralWardrobe.json");
            writer.open();
            writer.write(wardrobe);
            writer.close();

            JsonReader reader = new JsonReader("./data/testWriterGeneralWardrobe.json");
            wardrobe = reader.read();
            assertEquals(2, wardrobe.getSize());
            checkOutfit("beach", wardrobe.findOutfit("beach"));
            checkOutfit("dinner", wardrobe.findOutfit("dinner"));
            assertTrue(testOutfit.contains("tux"));

        } catch (IOException e) {
            fail("Exception should not have been thrown");
        }
    }
}
