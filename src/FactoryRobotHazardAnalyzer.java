import java.util.Scanner;
/**
 * Factory Robot Hazard Analyzer
 * UC3: Calculate Robot Hazard Risk (No Validation)
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

        double risk = ((1.0 - armPrecision) * 15.0) + (workerDensity * 3.0);

        System.out.println("Robot Hazard Risk Score: " + risk);
    }
}
