package ObserverPattern.Observable;

import ObserverPattern.Observer.NotificationAlertObserver;

import java.util.ArrayList;
import java.util.List;

public class IphoneObservableImpl implements StockObservable{
    public List<NotificationAlertObserver> ObserverList = new ArrayList<>();
    public int StockCount = 0;

    @Override
    public void add(NotificationAlertObserver obj){
        ObserverList.add(obj);
    }

    @Override
    public void remove(NotificationAlertObserver obj){
        ObserverList.remove(obj);
    }

    @Override
    public void notifySubscribers(){
        for(NotificationAlertObserver observer: ObserverList){
            observer.update();
        }
    }

    @Override
    public void setStock(int newStockCount){
        if (StockCount == 0 && newStockCount != 0){
            notifySubscribers();
        }
        StockCount += newStockCount;
    }

    @Override
    public int getStock(){
        return StockCount;
    }
}
