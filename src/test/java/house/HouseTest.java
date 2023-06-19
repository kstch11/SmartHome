package house;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class HouseTest {

    @Test
    void test_createHouse_simple() {
        // Given

        // When
        var house = House.builder()
                .setHouseName("HOUSE_123")
                .build();

        assertEquals("HOUSE_123", house.getHouseName());
        assertEquals(0, house.getAllHouseParts().size());
    }
}