package Splitwise.Expense;

import Splitwise.BalanceSheetController;
import Splitwise.Expense.Split.ExpenseSplit;
import Splitwise.Expense.Split.Split;
import Splitwise.User.User;

import java.util.List;

public class ExpenseController {

    BalanceSheetController balanceSheetController;

    public ExpenseController(){
        balanceSheetController = new BalanceSheetController();
    }
    public Expense createExpense(String expenseId, String description, double expenseAmount, User paidByUser,
                                 ExpenseSplitType splitType, List<Split> splitDetails){
        ExpenseSplit expenseSplit = SplitFactory.getSplitObject(splitType);
        expenseSplit.validateSplitRequest(splitDetails,expenseAmount);

        Expense expense = new Expense(expenseId,description,expenseAmount,paidByUser,splitType,splitDetails);

        //Update balanceSheet !!!!!!!! Remember
        balanceSheetController.updateUserExpenseBalanceSheet(paidByUser,splitDetails,expenseAmount);
        return expense;
    }
}
