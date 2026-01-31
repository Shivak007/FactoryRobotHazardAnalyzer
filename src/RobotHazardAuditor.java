public class RobotHazardAuditor {

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
