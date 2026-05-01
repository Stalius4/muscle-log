package workout.model;

import java.util.List;
import java.util.ArrayList;

public class Exercise {
        
        private String name;
        private List<Set> sets;

    /**
    * Creates exercise, add all sets to it. 
    *@param name exercise name.
     */
    public Exercise(String name ){
        if(name == null ||name.isBlank() ){
            throw new IllegalArgumentException("Name cannot be empty.");
        }
        
        this.name = name;
        sets = new ArrayList<Set>();
    }

    public String getName(){
        return this.name;
    }

    public void setName(String name ){
        if(name == null ||name.isBlank() ){
            throw new IllegalArgumentException("Name cannot be empty.");
        }

        this.name = name;
    }

    public void addSet( Set set){
        if(set == null){
            throw new IllegalArgumentException("Set cannot be null");
        }

        sets.add(set);
    }
    /**
    * Calculates total weight for sets reps and weights.
     */
    public int calculateTotalVolume(){
        if(this.sets == null){
            return 0;
        }
        int result= 0;
        for(Set set : sets){
           result = result + set.getReps() * set.getWeight();
        }
        return result;
    }
}