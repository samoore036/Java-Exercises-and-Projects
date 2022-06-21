/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author mooshahe
 */
import java.util.ArrayList;
import java.util.Random;
public class Ship {
    private ArrayList<String> locations;
    private int numberOfHits = 0;
    private String name;
    
    public void setLocations(ArrayList<String> locs) {
        locations = locs;
    }
    
    public String checkYourself(String userInput) {
        String result = "miss";
        int index = locations.indexOf(userInput);
        if (index >= 0) {
            locations.remove(index);
            if (locations.isEmpty()) {
                result = "kill";
            } else {
                result = "hit";
            }
        }
        return result;
    }
    
    public void setName(String name) {
        this.name = name;
    }
    
    public String getName() {
        return this.name;
    }    
   
    
   
}
