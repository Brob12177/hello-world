CSC151Project_Brevin_Robinson
import java.util.Scanner;

public class Project_Brevin_Robinson {

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        System.out.print("Please enter the Policy Number: ");
        int policyNumber = input.nextInt();
        input.nextLine();

        System.out.print("\nPlease enter the Provider Name: ");
        String providerName = input.nextLine();

        System.out.print("\nPlease enter the Policyholder’s First Name: ");
        String firstName = input.nextLine();

        System.out.print("\nPlease enter the Policyholder’s Last Name: ");
        String lastName = input.nextLine();

        System.out.print("\nPlease enter the Policyholder’s Age: ");
        int age = input.nextInt();
        input.nextLine();

        System.out.print("\nPlease enter the Policyholder’s Smoking Status (smoker/non-smoker): ");
        String smokingStatus = input.nextLine();

        System.out.print("\nPlease enter the Policyholder’s Height (in inches): ");
        double height = input.nextDouble();

        System.out.print("\nPlease enter the Policyholder’s Weight (in pounds): ");
        double weight = input.nextDouble();

        Policy policy = new Policy(policyNumber, providerName, firstName,
                                   lastName, age, smokingStatus,
                                   height, weight);

        System.out.println("\nPolicy Number: " + policy.getPolicyNumber());
        System.out.println("\nProvider Name: " + policy.getProviderName());
        System.out.println("\nPolicyholder’s First Name: " + policy.getFirstName());
        System.out.println("\nPolicyholder’s Last Name: " + policy.getLastName());
        System.out.println("\nPolicyholder’s Age: " + policy.getAge());
        System.out.println("\nPolicyholder’s Smoking Status: " + policy.getSmokingStatus());
        System.out.println("\nPolicyholder’s Height: " + policy.getHeight() + " inches");
        System.out.println("\nPolicyholder’s Weight: " + policy.getWeight() + " pounds");
        System.out.printf("\nPolicyholder’s BMI: %.2f\n", policy.calculateBMI());
        System.out.printf("\nPolicy Price: $%.2f\n", policy.calculatePrice());

        input.close();
    }
}
