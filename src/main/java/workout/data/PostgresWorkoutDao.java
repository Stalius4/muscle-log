package workout.data;
import workout.model.Workout;
import java.util.List;
import java.sql.Statement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;


public class PostgresWorkoutDao implements WorkoutDao {
    private final String url;
    private final String user;
    private final String password;

    public PostgresWorkoutDao(String url, String user, String password) {
        this.url = url;
        this.user = user;
        this.password = password;
        
    }


    /**
     * Opens a JDBC connection to the PostgreSQL database.
     *
     * @return a live Connection
     * @throws SQLException if the connection cannot be established
     */
    private Connection getConnection() throws SQLException {
        return DriverManager.getConnection(url, user, password);
    }
    /**
     * Saves a new workout to the database.
     * 
     * @param workout The workout session to be saved.
     * @return true if the save was successful, false otherwise.
     */

    @Override
    public boolean save(Workout workout) {
        String sql = "INSERT INTO workouts (name, start_time, end_time) VALUES (?, ?, ?)";
            // Create and open connection
        try (Connection con = getConnection();
            //Create the messenger and give command , RETURN_GENERATED_KEYS is a flag so ps.generatedKeys() can return the receipt
            var ps = con.prepareStatement(sql,Statement.RETURN_GENERATED_KEYS)) {
            // Add data to ? ? ? above    
            ps.setString(1, workout.getName());
            ps.setObject(2, workout.getStartTime());   // uses JDBC's mapping for LocalDateTime
            ps.setObject(3, workout.getEndTime());

            //For Writing (INSERT, UPDATE, DELETE), we use executeUpdate.
            //  It returns a number telling you how many rows were affected.
            int rows = ps.executeUpdate();



            // 2. Ask the messenger for the "Receipt" (The generated ID)
            try (ResultSet rs = ps.getGeneratedKeys()) {
                if (rs.next()) {
                    int id = rs.getInt(1); // Get the ID from the 1st column of the receipt
                    workout.setId(id);     // 3. Put it back into your Java object!
                }
            }
            return rows > 0;
        } catch (SQLException e) {
            System.err.println("Database Error: " + e.getMessage()); // This helps you debug
            return false; // This keeps the app alive
        }
    }


    /**
     * Finds a workout in the database.
     * 
     * @param id The workout session id.
     * @return Workout object.
     */
    @Override
    public Workout find(int id){
        String sql = "SELECT * FROM workouts WHERE id = ?";
    }
    

    /**
     * Finds all workouts in the database.
     * 
     * 
     * @return List of Workout objects.
     */
    @Override
    public List<Workout> findAll(){
        return null;
    }


    /**
     * Finds a workout in the database and deletes it.
     * 
     * @param id The workout session id.
     * @return true if the workout was successfully deleted, false otherwise.
     */
    @Override
    public boolean delete(int id){
        return false;
    }


        /**
     * Finds and updates a workout in the database.
     * 
     * @param workout The workout object.
     * @return true if the workout was successfully edited, false otherwise.
     */
    public boolean update(Workout workout){
        return true;
    }
}