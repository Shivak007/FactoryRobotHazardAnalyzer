import java.util.Scanner;
/**
 * Factory Robot Hazard Analyzer
 * UC5: Refactor Risk Calculation into Method
 *
 * @author Shiva Kumar
 * @version 1.0
 */
public class FactoryRobotHazardAnalyzer {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter Arm Precision (0.0 - 1.0): ");
        double armPrecision = sc.nextDouble();

        System.out.print("Enter Worker Density (1 - 20): ");
        int workerDensity = sc.nextInt();
        sc.nextLine();

        System.out.print("Enter Machinery State (Worn/Faulty/Critical): ");
        String machineryState = sc.nextLine();

        double risk = calculateHazardRisk(armPrecision, workerDensity, machineryState);

        System.out.println("Robot Hazard Risk Score: " + risk);
    }

    public static double calculateHazardRisk(double ap, int wd, String ms) {

        if (ap < 0.0 || ap > 1.0) {
            System.out.println("Error: Arm precision must be between 0.0 and 1.0");
            return -1;
        }

        if (wd < 1 || wd > 20) {
            System.out.println("Error: Worker density must be between 1 and 20");
            return -1;

        }

        return ((1.0 - ap) * 15.0) + (wd * 3.0);
    }
}
