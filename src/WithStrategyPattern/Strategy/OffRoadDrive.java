package WithStrategyPattern.Strategy;

public class OffRoadDrive implements DriveStrategy {
    @Override
    public void drive(){
        System.out.println("OffRoad Drive Capabilities");
    }
}
