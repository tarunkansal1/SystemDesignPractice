package Splitwise;

import java.util.Map;
import java.util.HashMap;

public class UserExpenseBalanceSheet {
    Map<String,Balance> userVsBalance;
    double totalYourExpense;
    double totalPayment;
    double totalYouGetBack;
    double totalYouOwe;

    public UserExpenseBalanceSheet(){
        userVsBalance = new HashMap<>();
        totalYouOwe=0;
        totalYourExpense=0;
        totalYouGetBack=0;
    }

    public double getTotalPayment() {
        return totalPayment;
    }

    public Map<String, Balance> getUserVsBalance() {
        return userVsBalance;
    }

    public double getTotalYouGetBack() {
        return totalYouGetBack;
    }

    public double getTotalYouOwe() {
        return totalYouOwe;
    }

    public double getTotalYourExpense() {
        return totalYourExpense;
    }

    public void setUserVsBalance(Map<String, Balance> userVsBalance) {
        this.userVsBalance = userVsBalance;
    }

    public void setTotalPayment(double totalPayment) {
        this.totalPayment = totalPayment;
    }

    public void setTotalYouGetBack(double totalYouGetBack) {
        this.totalYouGetBack = totalYouGetBack;
    }

    public void setTotalYouOwe(double totalYouOwe) {
        this.totalYouOwe = totalYouOwe;
    }

    public void setTotalYourExpense(double totalYourExpense) {
        this.totalYourExpense = totalYourExpense;
    }

}
