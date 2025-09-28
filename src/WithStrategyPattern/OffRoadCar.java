package WithStrategyPattern;

import WithStrategyPattern.Strategy.OffRoadDrive;

public class OffRoadCar extends Vehicle{
    OffRoadCar(){
        super(new OffRoadDrive());
    }
}
