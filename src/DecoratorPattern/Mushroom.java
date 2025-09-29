package DecoratorPattern;

public class Mushroom extends PizzaToppingDecorator{
    BasePizza pizza;
    Mushroom(BasePizza pizza){
        this.pizza = pizza;
    }

    public int cost(){
        return pizza.cost() + 50;
    }
}
