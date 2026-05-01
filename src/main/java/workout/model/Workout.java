package workout.model;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.time.Duration;

public class Workout {
    
    private LocalDateTime startTime;
    private LocalDateTime endTime;
    private List<Exercise> exercises;

/**
 * Creates a new Workout session with an empty list of exercises.
 */
public Workout(){
    exercises = new ArrayList<Exercise>();
}


/**
 * Sets the start time of the workout.
 * 
 * @param start The time the workout began.
 * @throws IllegalArgumentException if the start time is null.
 */
public void setStartTime(LocalDateTime start){
    if(start == null){
        throw new IllegalArgumentException("null start passed to setStartTime");
    }
    startTime = start;
}


public void setEndTime(LocalDateTime endTime){
    if(endTime == null){
        throw new IllegalArgumentException("null end passed to setEndTime");
    }
    if(getStartTime() == null){
        throw new IllegalArgumentException("null start passed to getStartTime");
    }
    if( endTime.isBefore(getStartTime())){
        throw new IllegalArgumentException("End time can not be before start time.");
    }
    this.endTime = endTime;
}


/**
 * Adds a completed exercise to this workout session.
 * 
 * @param exercise The exercise to add.
 * @throws IllegalArgumentException if the exercise is null.
 */
public void addExercise(Exercise exercise){
    if(exercise == null){
        throw new IllegalArgumentException("Exercise cannot be null");
    }
    this.exercises.add(exercise);
}
public LocalDateTime getStartTime(){
    return startTime;
}



/**
 * Get total durtaion of workout time.
 */
public Duration getTotalTime(){
    if(this.startTime == null){
        throw new IllegalArgumentException("Start time is null");
    }
    if(this.endTime == null){
        throw new IllegalArgumentException("End time is null");
    }

    Duration duration =  Duration.between(this.startTime, this.endTime);  
    return duration.abs();
}
}
