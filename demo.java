import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * Demo class reads policy data from a file and displays results.
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

            PolicyHolder holder = new PolicyHolder(
                    firstName, lastName, age, smokingStatus, height, weight);

            Policy policy = new Policy(policyNumber, providerName, holder);

            policies.add(policy);

            if (smokingStatus.equalsIgnoreCase("smoker"))
                smokerCount++;
            else
                nonSmokerCount++;
        }

        inputFile.close();

        for (Policy p : policies) {

            /* implicitly calls toString() */
            System.out.println(p);
            System.out.println();
        }

        System.out.println("There were " + Policy.getPolicyCount() + " Policy objects created.\n");

        System.out.println("The number of policies with a smoker is: " + smokerCount);
        System.out.println();

        System.out.println("The number of policies with a non-smoker is: " + nonSmokerCount);
    }
}