/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import java.util.*;
/**
 *
 * @author mooshahe
 */
public class Package {
    private int weight;
    private String serialNumber;
    
    public Package(int weight) {
        this.weight = weight;
        this.serialNumber = generateSerialNumber();
    }
    
    
    
    private String generateSerialNumber() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 9; i++) {
            if (new Random().nextBoolean() == true) {
                sb.append((char) new Random().nextInt(26) + 'a');
            } else {
                sb.append(String.valueOf(new Random().nextInt(10)));
            }
        }
        return sb.toString().toUpperCase();
    }
    
    public String getSerialNumber() {
        return this.serialNumber;
    }
    
    @Override public String toString() {
        return this.serialNumber;
    }
    
    @Override 
    public boolean equals(Object compare) {
        Package compared = (Package) compare;
        
        return this.getSerialNumber().equals(compared.getSerialNumber());
    }
}
