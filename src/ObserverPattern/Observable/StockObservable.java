package ObserverPattern.Observable;

import ObserverPattern.Observer.NotificationAlertObserver;

public interface StockObservable {
    public void add(NotificationAlertObserver obj);
    public void remove(NotificationAlertObserver obj);
    public void notifySubscribers();
    public void setStock(int newStockCount);
    public int getStock();
}
