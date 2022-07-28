/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author mooshahe
 */
public class Package {
    private int weight;
    
    public Package(int weight) {
        this.weight = weight;
    }
    
    public int getWeight() {
        return this.weight;
    }
    
    @Override
    public String toString() {
        return String.valueOf(this.weight);
    }
}
