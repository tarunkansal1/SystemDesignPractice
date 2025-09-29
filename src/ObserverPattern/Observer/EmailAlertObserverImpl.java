package ObserverPattern.Observer;

import ObserverPattern.Observable.StockObservable;

public class EmailAlertObserverImpl implements NotificationAlertObserver{
    StockObservable observable;
    String email;

    public EmailAlertObserverImpl(StockObservable observable, String email){
        this.email = email;
        this.observable = observable;
    }

    @Override
    public void update(){
        sendEmail(email,"Notifying");
    }

    public void sendEmail(String email, String msg){
        System.out.println("mail sent to " + email + msg);
    }
}
