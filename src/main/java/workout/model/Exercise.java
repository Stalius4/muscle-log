package workout.model;

import java.util.List;
import java.util.Objects;
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

    @Override
    public String toString(){
    StringBuilder stringResult = new StringBuilder();
    stringResult.append("Exercise: ");
    stringResult.append(getName());
    stringResult.append("\n");
      for(Set set: sets){
        stringResult.append("--").append(set).append("\n");
    
      }
      return stringResult.toString();
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
    Exercise other = (Exercise) obj;
    if(this.name.equals(other.name)){
        return true;
    }
    return false;
    // 1. Same memory reference? → true immediately
    // 2. Is obj null? → false
    // 3. Is obj a different class? → false
    // 4. Cast obj to your type
    // 5. Compare each field that defines "equality"
}
@Override
public int hashCode() {
    return Objects.hash(this.name);
}
}