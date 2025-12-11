package Splitwise.Expense.Split;

import Splitwise.User.User;

public class Split {
    User user;
    double amountOwe;

    public Split(User user,double amountOwe){
        this.amountOwe=amountOwe;
        this.user=user;
    }

    public User getUser() {
        return user;
    }

    public double getAmountOwe() {
        return amountOwe;
    }

    public void setAmountOwe(double amountOwe) {
        this.amountOwe = amountOwe;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
