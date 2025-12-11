package Splitwise.Expense;

import Splitwise.Expense.Split.Split;
import Splitwise.User.User;

import java.util.List;

public class Expense {
    String expenseId;
    String description;
    double expenseAmount;
    User paidByUser;
    ExpenseSplitType splitType;
    List<Split> splitDetails;

    public Expense(String expenseId,String description,double expenseAmount, User paidByUser,
                   ExpenseSplitType splitType,List<Split> splitDetails){
        this.expenseAmount = expenseAmount;
        this.expenseId = expenseId;
        this.description = description;
        this.paidByUser = paidByUser;
        this.splitType = splitType;
        this.splitDetails = splitDetails;
    }
}
