package venturelabstechassignment;

import java.util.Scanner;

/**
 *Runs the functions for the different parts of the assignment
 * @author dkabii
 */
public class VentureLabsTechAssignment {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        System.out.println("Enter a sentence to extract Kenyan number plate from: ");
        String str=scanner.nextLine();
        NumberPlateHelper.searchRegistrationNumber(str);
        NumberPlateHelper.getCarsBetweenPlates("kaa 001a", "kab 001a");
    }
    
}
