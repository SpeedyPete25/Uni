import java.util.Scanner;

public class IncomeTaxCalculator {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        
        // Tax brackets
        double[][] brackets = {
            {8350, 33950, 82250, 171550, 372950}, // Single
            {16700, 67900, 137050, 208850, 372950}, // Married Filing Jointly or Qualified Widow(er)
            {8350, 33950, 68525, 104425, 186475}, // Married Filing Separately
            {11950, 45500, 117450, 190200, 372950} // Head of Household
        };
        
        // Rates
        double[] rates = {0.10, 0.15, 0.25, 0.28, 0.33, 0.35};
        
        // Prompt the user to enter the filing status
        System.out.println("Enter the filing status:");
        System.out.println("(0-single filer, 1-married jointly, 2-married separately, 3-head of household): ");
        int status = input.nextInt();
        
        // Prompt the user to enter taxable income
        System.out.print("Enter the taxable income: ");
        double income = input.nextDouble();
        
        // Compute the tax
        double tax = computeTax(status, income, brackets, rates);
        
        // Display the result
        System.out.printf("Tax is %.2f\n", tax);

        input.close();
    }
    
    public static double computeTax(int status, double income, double[][] brackets, double[] rates) {
        double tax = 0;
        double[] bracket = brackets[status];
        
        if (income <= bracket[0]) {
            tax = income * rates[0];
        } else {
            tax = bracket[0] * rates[0];
            
            for (int i = 1; i < bracket.length; i++) {
                if (income > bracket[i]) {
                    tax += (bracket[i] - bracket[i - 1]) * rates[i];
                } else {
                    tax += (income - bracket[i - 1]) * rates[i];
                    return tax;
                }
            }
            
            tax += (income - bracket[bracket.length - 1]) * rates[rates.length - 1];
        }
        
        return tax;
    }
}
