import java.util.Scanner;

public class ZooEntryCalculator {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int totalTakings = 0;
        
        while (true) {
            // Prompts user for group
            System.out.print("Enter a group? (Yes=1/No=0): ");
            int enterGroup = input.nextInt();
            
            if (enterGroup == 0) {
                break;
            }
            
            //Prompts user for number of children (age 6-15)
            System.out.print("Enter the number of children (age 6-15): ");
            int children = input.nextInt();
            
            //Prompts user for number of adults (age 16-59)
            System.out.print("Enter the number of adults (age 16-59): ");
            int adults = input.nextInt();
            
            //Prompts user for number of seniors (age 60+)
            System.out.print("Enter the number of seniors (age 60+): ");
            int seniors = input.nextInt();
            
            // Claculate total charge
            int totalEntryCharge = calculateEntryCharge(children, adults, seniors);
            totalTakings += totalEntryCharge;
            
            // Prints output
            System.out.println("Total entry charge is $" + totalEntryCharge);
        }
        
        // Prints total takings
        System.out.println("Total takings: $" + totalTakings);
        input.close();
    }
    
    // Functions to calculate entry charge
    public static int calculateEntryCharge(int children, int adults, int seniors) {
        final int CHILD_ACCOMPANIED_FEE = 2;
        final int CHILD_UNACCOMPANIED_FEE = 5;
        final int ADULT_FEE = 10;
        final int SENIOR_FEE = 8;
        
        int accompaniedChildren = Math.min(children, adults + seniors);
        int unaccompaniedChildren = children - accompaniedChildren;
        
        int totalCharge = (accompaniedChildren * CHILD_ACCOMPANIED_FEE) 
                        + (unaccompaniedChildren * CHILD_UNACCOMPANIED_FEE)
                        + (adults * ADULT_FEE)
                        + (seniors * SENIOR_FEE);
        
        return totalCharge;
    }
}
