import java.util.Scanner;

public class COCOMO {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.println("====================================");
        System.out.println("       COCOMO COST ESTIMATION");
        System.out.println("====================================");

        System.out.print("Enter project size (KLOC): ");
        double kloc = sc.nextDouble();

        System.out.println("\nSelect Project Type:");
        System.out.println("1. Organic");
        System.out.println("2. Semi-Detached");
        System.out.println("3. Embedded");

        System.out.print("Enter your choice: ");
        int choice = sc.nextInt();

        double a = 0, b = 0, c = 0, d = 0;
        String projectType = "";

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

            case 3:
                a = 3.6;
                b = 1.20;
                c = 2.5;
                d = 0.32;
                projectType = "Embedded";
                break;

            default:
                System.out.println("Invalid choice!");
                sc.close();
                return;
        }

        double effort = a * Math.pow(kloc, b);
        double developmentTime = c * Math.pow(effort, d);
        double staff = effort / developmentTime;

        System.out.println("\n====================================");
        System.out.println("          ESTIMATION RESULT");
        System.out.println("====================================");

        System.out.println("Project Type      : " + projectType);
        System.out.println("Project Size      : " + kloc + " KLOC");
        System.out.printf("Effort            : %.2f Person-Months%n", effort);
        System.out.printf("Development Time  : %.2f Months%n", developmentTime);
        System.out.printf("Average Staff     : %.2f Persons%n", staff);

        System.out.println("====================================");

        sc.close();
    }
}
