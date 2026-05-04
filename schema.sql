-- Workouts: The main container for a training session
CREATE TABLE workouts (
    id SERIAL PRIMARY KEY,
    name VARCHAR(255) NOT NULL,
    start_time TIMESTAMP,
    end_time TIMESTAMP
);

-- Exercises: Linked to a specific workout
CREATE TABLE exercises (
    id SERIAL PRIMARY KEY,
    name VARCHAR(255) NOT NULL,
    workout_id INTEGER REFERENCES workouts(id) ON DELETE CASCADE
);

-- Sets: Linked to a specific exercise
CREATE TABLE sets (
    id SERIAL PRIMARY KEY,
    reps INTEGER NOT NULL,
    weight INTEGER NOT NULL,
    difficulty INTEGER NOT NULL,
    exercise_id INTEGER REFERENCES exercises(id) ON DELETE CASCADE
);
