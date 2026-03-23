import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * The Demo class reads policy data from a file,
 * creates Policy objects, stores them in an ArrayList,
 * and displays the policy information.
 */
public class Demo {

    public static void main(String[] args) throws IOException {

        File file = new File("PolicyInformation.txt");
        Scanner inputFile = new Scanner(file);

        ArrayList<Policy> policies = new ArrayList<>();

        int smokerCount = 0;
        int nonSmokerCount = 0;

        while (inputFile.hasNext()) {

            int policyNumber = inputFile.nextInt();
            inputFile.nextLine();

            String providerName = inputFile.nextLine();
            String firstName = inputFile.nextLine();
            String lastName = inputFile.nextLine();

            int age = inputFile.nextInt();
            inputFile.nextLine();

            String smokingStatus = inputFile.nextLine();

            double height = inputFile.nextDouble();
            double weight = inputFile.nextDouble();

            if (inputFile.hasNextLine()) {
                inputFile.nextLine();
            }

            Policy policy = new Policy(policyNumber, providerName, firstName,
                    lastName, age, smokingStatus, height, weight);

            policies.add(policy);

            if (smokingStatus.equalsIgnoreCase("smoker")) {
                smokerCount++;
            } else {
                nonSmokerCount++;
            }
        }

        inputFile.close();

        for (Policy p : policies) {

            System.out.println("Policy Number: " + p.getPolicyNumber());
            System.out.println();

            System.out.println("Provider Name: " + p.getProviderName());
            System.out.println();

            System.out.println("Policyholder's First Name: " + p.getFirstName());
            System.out.println();

            System.out.println("Policyholder's Last Name: " + p.getLastName());
            System.out.println();

            System.out.println("Policyholder's Age: " + p.getAge());
            System.out.println();

            System.out.println("Policyholder's Smoking Status (smoker/non-smoker): " + p.getSmokingStatus());
            System.out.println();

            System.out.println("Policyholder's Height: " + p.getHeight() + " inches");
            System.out.println();

            System.out.println("Policyholder's Weight: " + p.getWeight() + " pounds");
            System.out.println();

            System.out.printf("Policyholder's BMI: %.2f\n", p.calculateBMI());
            System.out.println();

            System.out.printf("Policy Price: $%.2f\n", p.calculatePolicyPrice());
            System.out.println();
            System.out.println();
        }

        System.out.println("The number of policies with a smoker is: " + smokerCount);
        System.out.println();
        System.out.println("The number of policies with a non-smoker is: " + nonSmokerCount);
    
