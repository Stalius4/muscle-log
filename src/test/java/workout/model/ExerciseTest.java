package workout.model;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ExerciseTest {
    

        @Test
    public void testHappyPath() {
        // 1. Create a valid Set
        Set mySet = new Set(10, 100, 3);
        Set anotherSet = new Set(8,15,4);
        
        Exercise exercise = new Exercise("Bench press");
        exercise.addSet(mySet);
        exercise.addSet(anotherSet);

        assertEquals(1120,exercise.calculateTotalVolume() );

    }
}
