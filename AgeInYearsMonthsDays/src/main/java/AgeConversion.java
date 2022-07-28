/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
//convert age into years, months, and days 
import java.time.*;
import java.time.temporal.ChronoUnit;
import java.util.*;
/**
 *
 * @author mooshahe
 */
public class AgeConversion {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter your birthdate (mm/dd/yyyy)");
        String userBirthdate = scanner.nextLine();
        String[] bdBreakdown = userBirthdate.split("/");
        
        LocalDate birthDate = LocalDate.of(Integer.parseInt(bdBreakdown[2]), Integer.parseInt(bdBreakdown[0]), Integer.parseInt(bdBreakdown[1]));
        LocalDate currentDate = LocalDate.now();
        
        System.out.println("Age in years: " + ChronoUnit.YEARS.between(birthDate, currentDate));
        System.out.println("Age in months: " + ChronoUnit.MONTHS.between(birthDate, currentDate));
        System.out.println("Age in days: " + ChronoUnit.DAYS.between(birthDate, currentDate));
    }
}
