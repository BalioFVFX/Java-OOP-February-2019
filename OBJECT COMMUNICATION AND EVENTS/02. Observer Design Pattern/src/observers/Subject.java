package observers;

public interface Subject {
    void register(Observable observable);
    void unregister(Observable observable);
    void notifyObservers();
}
