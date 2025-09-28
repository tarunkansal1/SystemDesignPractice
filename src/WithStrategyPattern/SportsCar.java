package WithStrategyPattern;

import WithStrategyPattern.Strategy.SportsDrive;

public class SportsCar extends Vehicle{
    SportsCar(){super(new SportsDrive());}
}
