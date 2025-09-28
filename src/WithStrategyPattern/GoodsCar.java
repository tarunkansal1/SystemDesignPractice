package WithStrategyPattern;

import WithStrategyPattern.Strategy.NormalDrive;

public class GoodsCar extends Vehicle{
    GoodsCar(){
        super(new NormalDrive());
    }
}
