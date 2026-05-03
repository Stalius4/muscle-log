package workout.model;

import java.util.Objects;

public class Set {
    private int reps;
    private int weight;
    private int difficulty;


    /**
    * Creates a new physical Set in a workout.
    * 
    * @param reps The number of repetitions (must be >= 0)
    * @param weight ...
    * @param difficulty ...
     */
    public Set(int reps, int weight, int difficulty) {

        if(reps<0){
            throw new IllegalArgumentException("Reps can not be negative");
        }
         this.reps = reps;
        

         if(weight<0){
            throw new IllegalArgumentException("Weight can not be negative");
         }

        this.weight = weight;

        if(difficulty<0 || difficulty>5){
            throw new IllegalArgumentException("Difficulty should be between 0 and 6");
        }
        this.difficulty = difficulty;
    }

    public int getReps() {
        return reps;
    }

    public void setReps(int reps) {
        if(reps<0){
            throw new IllegalArgumentException("Reps can not be negative");
        }
         this.reps = reps;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        if(weight<0){
            throw new IllegalArgumentException("Weight can not be negative");
        }

        this.weight = weight;
    }

    public int getDifficulty(){
        return difficulty;
    }
    public void setDifficulty(int difficulty){
        if(difficulty<0 || difficulty>5){
            throw new IllegalArgumentException("Difficulty shoul be between 0 and 6");
        }
        this.difficulty = difficulty;
    }
    @Override
    public String toString(){

        return "Reps: " + getReps() +(getReps()<10 ? " ":"") + " Weight: " + getWeight() + (getWeight() < 10 ? "  " : (getWeight() < 100 ? " " : ""))+" Difficulty: " + getDifficulty();

     }
    @Override
    public boolean equals(Object obj) {
    if(this == obj){
        return true;
    }
    if(obj == null){
        return false;
    }
    if(getClass() != obj.getClass()){
        return false;
    }
    Set other = (Set) obj;
    if(this.reps == other.reps && this.weight == other.weight && this.difficulty == other.difficulty){
        return true;
    }
    return false;
}
@Override
public int hashCode() {
    return Objects.hash(this.reps, this.weight, this.difficulty);
}
}

