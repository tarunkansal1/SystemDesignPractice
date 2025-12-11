package Splitwise;

import Splitwise.Expense.Split.Split;
import Splitwise.User.User;

import java.util.List;
import java.util.Map;

public class BalanceSheetController {
    public void updateUserExpenseBalanceSheet(User paidByUser, List<Split> splitList,double totalExpenseAmount){
        //Update payment made by user..
        UserExpenseBalanceSheet paidByUserExpenseBalanceSheet = paidByUser.getUserExpenseBalanceSheet();
        paidByUserExpenseBalanceSheet.setTotalPayment(paidByUserExpenseBalanceSheet.getTotalPayment() + totalExpenseAmount);

        for(Split split: splitList){
            User userOwe = split.getUser();
            UserExpenseBalanceSheet oweUserExpenseBalanceSheet = userOwe.getUserExpenseBalanceSheet();
            double oweAmount = split.getAmountOwe();

            if(userOwe.getUserId().equals(paidByUser.getUserId())){
                paidByUserExpenseBalanceSheet.setTotalYourExpense(paidByUserExpenseBalanceSheet.getTotalYourExpense() + oweAmount);
            }else{
                //Update balance of paid user
                paidByUserExpenseBalanceSheet.setTotalYouGetBack(paidByUserExpenseBalanceSheet.getTotalYouGetBack() + oweAmount);
                Balance userOweBalance;
                if(paidByUserExpenseBalanceSheet.getUserVsBalance().containsKey(userOwe.getUserId())){
                    userOweBalance = paidByUserExpenseBalanceSheet.getUserVsBalance().get(userOwe.getUserId());
                }else{
                    userOweBalance = new Balance();
                    paidByUserExpenseBalanceSheet.getUserVsBalance().put(userOwe.getUserId(), userOweBalance);
                }
                userOweBalance.setAmountGetBack(userOweBalance.getAmountGetBack() + oweAmount);

                //Update balance of owe user
                oweUserExpenseBalanceSheet.setTotalYouOwe(oweUserExpenseBalanceSheet.getTotalYouOwe() + oweAmount);
                oweUserExpenseBalanceSheet.setTotalYourExpense(oweUserExpenseBalanceSheet.getTotalYourExpense() + oweAmount);

                Balance paidUserBalance;
                if(oweUserExpenseBalanceSheet.getUserVsBalance().containsKey(paidByUser.getUserId())){
                    paidUserBalance = oweUserExpenseBalanceSheet.getUserVsBalance().get(paidByUser.getUserId());
                }else{
                    paidUserBalance = new Balance();
                    oweUserExpenseBalanceSheet.getUserVsBalance().put(paidByUser.getUserId(), paidUserBalance);
                }
                paidUserBalance.setAmountOwe(paidUserBalance.getAmountOwe() + oweAmount);
            }

        }
    }

    public void showBalanceSheetOfUser(User user){
        System.out.println("-----------------------------------------------");
        UserExpenseBalanceSheet userExpenseBalanceSheet = user.getUserExpenseBalanceSheet();

        System.out.println("TotalYourExpense: " + userExpenseBalanceSheet.getTotalYourExpense());
        System.out.println("TotalGetBack: " + userExpenseBalanceSheet.getTotalYouGetBack());
        System.out.println("TotalYourOwe: " + userExpenseBalanceSheet.getTotalYouOwe());
        System.out.println("TotalPaymentMade: " + userExpenseBalanceSheet.getTotalPayment());

        for(Map.Entry<String,Balance> entry : userExpenseBalanceSheet.getUserVsBalance().entrySet()){
            String userId = entry.getKey();
            Balance balance = entry.getValue();

            System.out.println("userID:" + userId + " YouGetBack:" + balance.getAmountGetBack() + " YouOwe:" + balance.getAmountOwe());
        }

        System.out.println("-----------------------------------------------");
    }
}
