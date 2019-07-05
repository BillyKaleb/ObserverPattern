package com.kaleb.observerpattern;

import com.kaleb.observerpattern.interfaces.Observable;
import com.kaleb.observerpattern.interfaces.Observer;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Billy Kaleb Hananto (billy.hananto@dana.id)
 * @version VendingMachineData, v 0.1 05/04/19 10.11 by Billy Kaleb Hananto
 */
public class VendingMachineData implements Observable {

    private int cocaCola;

    private int fanta;

    private List observerList;

    private int sprite;

    public VendingMachineData() {
        observerList = new ArrayList();
        cocaCola = 0;
        fanta = 0;
        sprite = 0;
    }

    @Override
    public void registerObserver(Observer observer) {
        observerList.add(observer);
    }

    @Override
    public void removeObserver(Observer observer) {
        int x = observerList.indexOf(observer);
        if (x >= 0) {
            observerList.remove(observer);
        }
    }

    @Override
    public void notifyObserver() {
        for (int x = 0; x < observerList.size(); x++) {
            Observer observer = (Observer) observerList.get(x);
            observer.update(fanta, cocaCola, sprite);
        }
    }

    public void setDrinksValue(int fanta, int cocaCola, int sprite) {
        this.fanta = fanta;
        this.cocaCola = cocaCola;
        this.sprite = sprite;
        updateDrinks();
    }

    private void updateDrinks() {
        notifyObserver();
    }

    public void setCocaCola(int cocaCola) {
        this.cocaCola = cocaCola;
        updateDrinks();
    }

    public void setFanta(int fanta) {
        this.fanta = fanta;
        updateDrinks();
    }

    public void setSprite(int sprite) {
        this.sprite = sprite;
        updateDrinks();
    }

    public void buyCocaCola() {
        if (cocaCola > 0) {
            cocaCola--;
        }
        updateDrinks();
    }

    public void buyFanta() {
        if (fanta > 0) {
            fanta--;
        }
        updateDrinks();
    }

    public void buySprite() {
        if (sprite > 0) {
            sprite--;
        }
        updateDrinks();
    }
}
