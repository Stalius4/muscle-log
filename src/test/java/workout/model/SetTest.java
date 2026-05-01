package workout.model;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class SetTest {
    
    @Test
    public void testNegativeRepsThrowsException() {
        // We tell JUnit: Expect an IllegalArgumentException if we pass -5 reps!
        assertThrows(IllegalArgumentException.class, () -> {
            new Set(-5, 100, 3);
        });
    }
    @Test
    public void testSetterThrowsException() {
        // 1. Create a perfectly valid Set
        Set mySet = new Set(10, 100, 3); 
        
        // 2. Attack the setter!
        assertThrows(IllegalArgumentException.class, () -> {
            mySet.setReps(-5); 
        });
    }

    @Test
    public void testHappyPath() {
        // 1. Create a valid Set
        Set mySet = new Set(10, 100, 3);
        
        // 2. We EXPECT that getReps() will return exactly 10.
        // The syntax is: assertEquals(ExpectedValue, ActualValue);
        assertEquals(10, mySet.getReps());
        assertEquals(100, mySet.getWeight());
        assertEquals(3, mySet.getDifficulty());
    }
}
