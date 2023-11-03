import static org.junit.jupiter.api.Assertions.*;

class MealTest {

    @org.junit.jupiter.api.Test
    void suma() {
        Meal objt =new Meal();
        assertEquals(2, objt.suma(1,1));
    }
}