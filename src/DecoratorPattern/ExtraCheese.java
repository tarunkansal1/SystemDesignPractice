package DecoratorPattern;

public class ExtraCheese extends PizzaToppingDecorator{
    BasePizza pizza;
    ExtraCheese(BasePizza pizza){
        this.pizza = pizza;
    }

    @Override
    public int cost(){
        return pizza.cost() + 20;
    }
}
