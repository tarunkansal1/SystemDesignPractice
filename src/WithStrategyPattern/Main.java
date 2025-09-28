package WithStrategyPattern;

public class Main {
    public static void main(String [] args){
        Vehicle vh = new SportsCar();
        vh.drive();
        Vehicle vh2 = new OffRoadCar();
        vh2.drive();
        Vehicle vh3 = new GoodsCar();
        vh3.drive();
    }
}
