package ObserverPattern.Observer;

import ObserverPattern.Observable.StockObservable;

public class MobileAlertObserverImpl implements NotificationAlertObserver{
    StockObservable observable;
    String uname;

    public MobileAlertObserverImpl(StockObservable observable, String uname){
        this.observable = observable;
        this.uname = uname;
    }

    @Override
    public void update(){
        sendMsg(uname, "Notification");
    }

    public void sendMsg(String uname, String msg){
        System.out.println("Msg sent to " + uname + msg);
    }
}
