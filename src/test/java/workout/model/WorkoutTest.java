package workout.model;
import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;

public class WorkoutTest {
    
@Test
public void testWrongEndTime() {
    assertThrows(IllegalArgumentException.class, () -> {
        // Attack the constructor!
        Workout workout = new Workout("Back");
        LocalDateTime start = LocalDateTime.now();
        workout.setStartTime(start);
        workout.setEndTime(start.minusHours(1));
    });
}

@Test 
public void testHappyPath(){
    Workout workout = new Workout("Back");
        LocalDateTime start = LocalDateTime.now();
        workout.setStartTime(start);
        workout.setEndTime(start.plusHours(1));
        assertEquals(60, workout.getTotalTime().toMinutes());
}

}
