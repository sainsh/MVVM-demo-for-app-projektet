package dk.acsandras.mvvmdemo;

import java.io.Serializable;
import java.util.ArrayList;

public class Observable<T> implements Serializable {

    T value;
    boolean changed;

    ArrayList<Observer> observers;

    public  Observable(){
        observers = new ArrayList();
    }

    public Observable(T value) {
        this.value = value;
        observers = new ArrayList();
    }

    public void setValue(T value) {
        this.value = value;
        setChanged(true);
        notifyObservers();
    }

    public T getValue() {
        return value;
    }

    public boolean isChanged() {
        return changed;
    }

    private void setChanged(boolean changed) {
        this.changed = changed;
    }

    private void notifyObservers() {

        for (Observer observer : observers) {

            observer.update(getValue());

        }

        setChanged(false);

    }

    public void observe(Observer o) {

        observers.add(o);
    }

    public void stopObserving(Observer o) {

        observers.remove(o);
    }

    public ArrayList<Observer> getObservers() {
        return observers;
    }

    public void setObservers(ArrayList<Observer> observers) {
        this.observers = observers;
    }

    public int getObserverCount(){

        return observers.size();
    }
}
