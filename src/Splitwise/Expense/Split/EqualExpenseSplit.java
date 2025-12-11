package Splitwise.Expense.Split;

import java.util.List;

public class EqualExpenseSplit implements ExpenseSplit{

    @Override
    public void validateSplitRequest(List<Split> splitList, double totalAmount) {
        double amountPerPerson = totalAmount/splitList.size();
        for(Split split : splitList){
            if(amountPerPerson != split.getAmountOwe()){
                //Throw some Exception
                System.out.println("Amount does not match");
            }
        }
    }
}
