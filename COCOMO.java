import java.util.Scanner;

public class COCOMO {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.println("======================================================");
        System.out.println("       VACCINE TEMPERATURE LOGISTIC MONITOR");
        System.out.println("              COCOMO COST ESTIMATION");
        System.out.println("======================================================");

        // Project Size
        double kloc;

        do {
            System.out.print("\nEnter estimated project size (KLOC): ");
            kloc = sc.nextDouble();

            if (kloc <= 0) {
                System.out.println("KLOC must be greater than 0.");
            }

        } while (kloc <= 0);

        // Project Type
        System.out.println("\nSelect COCOMO Project Type:");
        System.out.println("--------------------------------");
        System.out.println("1. Organic");
        System.out.println("2. Semi-Detached");
        System.out.println("3. Embedded");
        System.out.println("--------------------------------");

        int choice;

        do {
            System.out.print("Enter choice (1-3): ");
            choice = sc.nextInt();

            if (choice < 1 || choice > 3) {
                System.out.println("Please enter a valid choice.");
            }

        } while (choice < 1 || choice > 3);

        // COCOMO Coefficients
        double a;
        double b;
        double c;
        double d;
        String projectType;

        switch (choice) {

            case 1:
                a = 2.4;
                b = 1.05;
                c = 2.5;
                d = 0.38;
                projectType = "Organic";
                break;

            case 2:
                a = 3.0;
                b = 1.12;
                c = 2.5;
                d = 0.35;
                projectType = "Semi-Detached";
                break;

            default:
                a = 3.6;
                b = 1.20;
                c = 2.5;
                d = 0.32;
                projectType = "Embedded";
                break;
        }

        // Cost Input
        double costPerMonth;

        do {
            System.out.print("\nEnter cost per person-month (Rs.): ");
            costPerMonth = sc.nextDouble();

            if (costPerMonth <= 0) {
                System.out.println("Cost must be greater than 0.");
            }

        } while (costPerMonth <= 0);

        // COCOMO Calculations
        double effort = a * Math.pow(kloc, b);

        double developmentTime =
                c * Math.pow(effort, d);

        double averageStaff =
                effort / developmentTime;

        double totalCost =
                effort * costPerMonth;

        // Display Results
        System.out.println("\n\n======================================================");
        System.out.println("                 ESTIMATION REPORT");
        System.out.println("======================================================");

        System.out.println(
                "Project Name      : Vaccine Temperature Logistic Monitor"
        );

        System.out.println(
                "Project Type      : " + projectType
        );

        System.out.printf(
                "Project Size      : %.2f KLOC%n", kloc
        );

        System.out.printf(
                "Effort            : %.2f Person-Months%n", effort
        );

        System.out.printf(
                "Development Time  : %.2f Months%n", developmentTime
        );

        System.out.printf(
                "Average Team Size : %.2f Persons%n", averageStaff
        );

        System.out.printf(
                "Cost per Month    : Rs. %.2f%n", costPerMonth
        );

        System.out.printf(
                "Estimated Cost    : Rs. %.2f%n", totalCost
        );

        System.out.println("======================================================");

        System.out.println(
                "       COCOMO ESTIMATION COMPLETED"
        );

        System.out.println("======================================================");

        sc.close();
    }
}
