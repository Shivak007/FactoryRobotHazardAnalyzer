import java.util.Scanner;
/**
 * Factory Robot Hazard Analyzer
 * UC4: Validate Inputs and Calculate Hazard Risk
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

        if (armPrecision < 0.0 || armPrecision > 1.0) {
            System.out.println("Error: Arm precision must be between 0.0 and 1.0");
            return;
        }

        if (workerDensity < 1 || workerDensity > 20) {
            System.out.println("Error: Worker density must be between 1 and 20");
            return;
        }
        double risk = ((1.0 - armPrecision) * 15.0) + (workerDensity * 3.0);

        System.out.println("Robot Hazard Risk Score: " + risk);
    }
}
