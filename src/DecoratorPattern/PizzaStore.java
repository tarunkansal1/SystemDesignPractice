package DecoratorPattern;

public class PizzaStore {
    public static void main(String[] args){
        BasePizza pizza1 = new OtcPizza();
        System.out.println("Cost of ypur Otc pizza is " + pizza1.cost());

        BasePizza pizza2 = new Mushroom(new ExtraCheese(new MargheritaPizza()));
        System.out.println("Cost of your Margherita pizza with extra cheese and mushroom is " + pizza2.cost());

        BasePizza pizza3 = new FarmPizza();
        pizza3 = new ExtraCheese(pizza3);
        System.out.println("Cost of your Farm pizza with extra cheese is " + pizza3.cost());
    }
}
