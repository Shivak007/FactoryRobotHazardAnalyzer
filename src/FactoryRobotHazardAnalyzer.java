import java.util.Scanner;

/**
 * Factory Robot Hazard Analyzer
 * UC8: Modular Hazard Risk Evaluation System
 *
 * Reads user inputs and displays the calculated robot hazard risk score.
 *
 * @author Shiva Kumar
 * @version 1.0
 */

public class FactoryRobotHazardAnalyzer {
    public static void main(String[] args) {

        try {
            Scanner sc = new Scanner(System.in);

            System.out.print("Enter Arm Precision (0.0 - 1.0): ");
            double armPrecision = sc.nextDouble();

            System.out.print("Enter Worker Density (1 - 20): ");
            int workerDensity = sc.nextInt();
            sc.nextLine();

            System.out.print("Enter Machinery State (Worn/Faulty/Critical): ");
            String machineryState = sc.nextLine();

            double risk = RobotHazardAuditor.calculateHazardRisk(
                    armPrecision, workerDensity, machineryState
            );

            System.out.println("Robot Hazard Risk Score: " + risk);

        } catch (RobotSafetyException e) {
            System.out.println(e.getMessage());
        }
    }
}
