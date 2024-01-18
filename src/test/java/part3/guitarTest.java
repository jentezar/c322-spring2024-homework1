package part3;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import part3.Guitar;
import part3.Inventory;

import static org.junit.jupiter.api.Assertions.*;

public class guitarTest {

    private Inventory inventory;

    @BeforeEach
    public void setUp() {
        inventory = new Inventory();
    }

    @Test
    public void testAddGuitar() {
        inventory.addGuitar("SN1", 100.26, "Builder1", "Model1", "Type1", "BackWood1", "TopWood1");
        Guitar addedGuitar = inventory.getGuitar("SN1");

        assertNotNull(addedGuitar);
        assertEquals("Builder1", addedGuitar.getBuilder());
        assertEquals("Model1", addedGuitar.getModel());
        assertEquals(100.26, addedGuitar.getPrice());
        // Add more assertions as needed
    }

    @Test
    public void testGetGuitar() {
        inventory.addGuitar("SN2", 400.99, "Builder2", "Model2", "Type2", "BackWood2", "TopWood2");
        Guitar foundGuitar = inventory.getGuitar("SN2");

        assertNotNull(foundGuitar);
        assertEquals("Builder2", foundGuitar.getBuilder());
        assertEquals("Model2", foundGuitar.getModel());
        assertEquals(400.99, foundGuitar.getPrice());
        // Add more assertions as needed
    }

    @Test
    public void testSearch() {
        inventory.addGuitar("SN3", 3100.82, "Builder3", "Model3", "Type3", "BackWood3", "TopWood3");
        Guitar searchGuitar = new Guitar("SN3", 3100.82, "Builder3", "Model3", "Type3", "BackWood3", "TopWood3");
        Guitar foundGuitar = inventory.search(searchGuitar);

        assertNotNull(foundGuitar); // Ensure that the guitar was found
        assertEquals("Builder3", foundGuitar.getBuilder());
        assertEquals("Model3", foundGuitar.getModel());
        assertEquals(3100.82, foundGuitar.getPrice());
    }
}