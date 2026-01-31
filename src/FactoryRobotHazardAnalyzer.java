import java.util.Scanner;
/**
 * Factory Robot Hazard Analyzer
 * UC7: Machinery State Risk Mapping
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

            double risk = calculateHazardRisk(armPrecision, workerDensity, machineryState);
            System.out.println("Robot Hazard Risk Score: " + risk);

        } catch (RobotSafetyException e) {
            System.out.println(e.getMessage());
        }
    }

    public static double calculateHazardRisk(double ap, int wd, String ms)
            throws RobotSafetyException {

        if (ap < 0.0 || ap > 1.0)
            throw new RobotSafetyException("Error: Arm precision must be between 0.0 and 1.0");

        if (wd < 1 || wd > 20)
            throw new RobotSafetyException("Error: Worker density must be between 1 and 20");

        double factor;
        switch (ms) {
            case "Worn":
                factor = 1.3;
                break;
            case "Faulty":
                factor = 2.0;
                break;
            case "Critical":
                factor = 3.0;
                break;
            default:
                throw new RobotSafetyException("Error: Unsupported machinery state");
        }

        return ((1.0 - ap) * 15.0) + (wd * factor);
    }
}

class RobotSafetyException extends Exception {
    public RobotSafetyException(String message) {
        super(message);
    }
}
