
public class Policy {

    private int policyNumber;
    private String providerName;
    private PolicyHolder policyHolder;

    private static int policyCount = 0;

    /**
     * Constructor
     */
    public Policy(int policyNumber, String providerName, PolicyHolder policyHolder) {

        this.policyNumber = policyNumber;
        this.providerName = providerName;

        /* defensive copy to avoid security problems */
        this.policyHolder = new PolicyHolder(
                policyHolder.getFirstName(),
                policyHolder.getLastName(),
                policyHolder.getAge(),
                policyHolder.getSmokingStatus(),
                policyHolder.getHeight(),
                policyHolder.getWeight()
        );

        policyCount++;
    }

    public int getPolicyNumber() {
        return policyNumber;
    }

    public String getProviderName() {
        return providerName;
    }

    public PolicyHolder getPolicyHolder() {

        return new PolicyHolder(
                policyHolder.getFirstName(),
                policyHolder.getLastName(),
                policyHolder.getAge(),
                policyHolder.getSmokingStatus(),
                policyHolder.getHeight(),
                policyHolder.getWeight()
        );
    }

    public static int getPolicyCount() {
        return policyCount;
    }

    /**
     * Calculates policy price.
     */
    public double calculatePolicyPrice() {

        double price = 600;

        if (policyHolder.getSmokingStatus().equalsIgnoreCase("smoker")) {
            price += 100;
        }

        double bmi = policyHolder.calculateBMI();

        if (bmi > 35) {
            price += (bmi - 35) * 20;
        }

        return price;
    }

    /**
     * Returns formatted string for policy information.
     */
    @Override
    public String toString() {

        return "Policy Number: " + policyNumber + "\n\n" +
               "Provider Name: " + providerName + "\n\n" +
               policyHolder.toString() + "\n" +
               String.format("Policy Price: $%.2f\n", calculatePolicyPrice());
    }
}