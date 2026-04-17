interface Observer {
    void notify(String itemName);
}

class Customer implements Observer {
    private String name;
    private int notifications;

    public Customer(String name) {
        this.name = name;
        this.notifications = 0;
    }

    public void notify(String itemName) {
        this.notifications += 1;
    }

    public int countNotifications() {
        return this.notifications;
    }
}

class OnlineStoreItem {
    private String itemName;
    private int stock;
    private List<Observer> subscribers;

    public OnlineStoreItem(String itemName, int stock) {
        this.itemName = itemName;
        this.stock = stock;
        this.subscribers = new LinkedList<>();
    }

    public void subscribe(Observer observer) {
        this.subscribers.add(observer);
    }

    public void unsubscribe(Observer observer) {
        this.subscribers.remove(observer);
    }

    public void updateStock(int newStock) {
        if(this.stock == 0 && newStock > 0) {
            notifySubscribers();
        }
        this.stock = newStock;
    }

    private void notifySubscribers() {
        for(Observer o: subscribers) {
            o.notify(this.itemName);
        }
    }
}
