package workout.data;

import java.util.List;

import workout.model.Workout;

public interface WorkoutDao {
    
    /**
     * Saves a new workout to the database.
     * 
     * @param workout The workout session to be saved.
     * @return true if the save was successful, false otherwise.
     */
    boolean save(Workout workout);


    /**
     * Finds a workout in the database.
     * 
     * @param id The workout session id.
     * @return Workout object.
     */
    Workout find(int id);
    

    /**
     * Finds all workouts in the database.
     * 
     * 
     * @return List of Workout objects.
     */
    List<Workout> findAll();


    /**
     * Finds a workout in the database and deletes it.
     * 
     * @param id The workout session id.
     * @return true if the workout was successfully deleted, false otherwise.
     */
    boolean delete(int id);


        /**
     * Finds and updates a workout in the database.
     * 
     * @param workout The workout object.
     * @return true if the workout was successfully edited, false otherwise.
     */
    boolean update(Workout workout);
    
}
