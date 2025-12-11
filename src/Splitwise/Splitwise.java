package Splitwise;

import Splitwise.Expense.ExpenseSplitType;
import Splitwise.Expense.Split.Split;
import Splitwise.Group.Group;
import Splitwise.Group.GroupController;
import Splitwise.User.User;
import Splitwise.User.UserController;

import java.util.ArrayList;
import java.util.List;

public class Splitwise {
    UserController userController;
    GroupController groupController;

    BalanceSheetController balanceSheetController;

    public Splitwise(){
        userController = new UserController();
        groupController = new GroupController();
        balanceSheetController = new BalanceSheetController();
    }

    public void Demo(){
        setUpUserAndGroup();

        //Add members to group
        Group group = groupController.getGroup("g01");
        group.addMember(userController.getUser("u02"));
        group.addMember(userController.getUser("u03"));

        //Create Expense Inside  a group
        List<Split> splitList = new ArrayList<>();
        Split split1 = new Split(userController.getUser("u01"), 100);
        Split split2 = new Split(userController.getUser("u02"), 100);
        Split split3 = new Split(userController.getUser("u03"), 100);

        splitList.add(split1);
        splitList.add(split2);
        splitList.add(split3);

        group.createExpense("E01","Testing Expense",300,userController.getUser("u01"), ExpenseSplitType.EQUAL,splitList);

        List<Split> splits2 = new ArrayList<>();
        Split splits2_1 = new Split(userController.getUser("u01"), 400);
        Split splits2_2 = new Split(userController.getUser("u02"), 100);
        splits2.add(splits2_1);
        splits2.add(splits2_2);
        group.createExpense("E02", "Lunch", 500, userController.getUser("u02"), ExpenseSplitType.UNEQUAL, splits2);

        for(User user: userController.getUserList()){
            balanceSheetController.showBalanceSheetOfUser(user);
        }


    }
    public void setUpUserAndGroup(){

        addUsersToSpliwiseApp();

        //Create Group by user1
        User user1 = userController.getUser("u01");
        groupController.createNewGroup("g01","Testing",user1);
    }
    public void addUsersToSpliwiseApp(){
        User user1 = new User("u01","tarun");
        User user2 = new User("u02","Aman");
        User user3 = new User("u03","Tushar");

        userController.addUser(user1);
        userController.addUser(user2);
        userController.addUser(user3);

    }
}
