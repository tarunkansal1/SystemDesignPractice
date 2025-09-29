package ObserverPattern;

import ObserverPattern.Observable.IphoneObservableImpl;
import ObserverPattern.Observable.StockObservable;
import ObserverPattern.Observer.EmailAlertObserverImpl;
import ObserverPattern.Observer.MobileAlertObserverImpl;
import ObserverPattern.Observer.NotificationAlertObserver;

public class Store {

    public static void main (String[] args) {
        StockObservable iphoneStockObservable = new IphoneObservableImpl();

        NotificationAlertObserver obs1 = new EmailAlertObserverImpl(iphoneStockObservable, "xyz@emial.com");
        NotificationAlertObserver obs2 = new MobileAlertObserverImpl(iphoneStockObservable, "Tarun");
        NotificationAlertObserver obs3 = new EmailAlertObserverImpl(iphoneStockObservable, "abc@email.com");

        iphoneStockObservable.add(obs1);
        iphoneStockObservable.add(obs2);
        iphoneStockObservable.add(obs3);

        iphoneStockObservable.setStock(10);
        iphoneStockObservable.setStock(0);
        iphoneStockObservable.setStock(100);
    }
}
