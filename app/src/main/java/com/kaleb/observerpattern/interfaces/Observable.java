package com.kaleb.observerpattern.interfaces;

/**
 * @author Billy Kaleb Hananto (billy.hananto@dana.id)
 * @version Observable, v 0.1 04/04/19 14.38 by Billy Kaleb Hananto
 */
public interface Observable {

    void registerObserver(Observer observer);

    void removeObserver(Observer observer);

    void notifyObserver();
}

