package com.kaleb.observerpattern;

import com.kaleb.observerpattern.interfaces.DisplayValue;
import com.kaleb.observerpattern.interfaces.Observable;
import com.kaleb.observerpattern.interfaces.Observer;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class VendingMachineActivity extends AppCompatActivity implements Observer, DisplayValue {

    private Button buyCocaCola;

    private Button buyFanta;

    private Button buySprite;

    private TextView cocaColaTextView;

    private int cocaColaValue;

    private TextView fantaTextView;

    private int fantaValue;

    private Button refillButton;

    private Button registerButton;

    private boolean registered = false;

    private TextView spriteTextView;

    private int spriteValue;

    private Button unregisterButton;

    private VendingMachineData vendingMachineData = new VendingMachineData();

    private Observable vendingObservable;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        vendingObservable = vendingMachineData;
        refillButton = findViewById(R.id.btn_refill);
        registerButton = findViewById(R.id.btn_register);
        unregisterButton = findViewById(R.id.btn_unregister);
        fantaTextView = findViewById(R.id.tv_fanta_value);
        cocaColaTextView = findViewById(R.id.tv_coca_col_value);
        spriteTextView = findViewById(R.id.tv_sprite_value);
        buyFanta = findViewById(R.id.btn_reduce_fanta);
        buyCocaCola = findViewById(R.id.btn_reduce_cola);
        buySprite = findViewById(R.id.btn_reduce_sprite);

        refillButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                vendingMachineData
                    .setDrinksValue(10, 10, 10);
            }
        });

        registerButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!registered) {
                    registerObservable();
                    registered = true;
                }
            }
        });

        unregisterButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (registered) {
                    unregisterObservable();
                    registered = false;
                }
            }
        });

        buyFanta.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                vendingMachineData.buyFanta();
            }
        });

        buyCocaCola.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                vendingMachineData.buyCocaCola();
            }
        });

        buySprite.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                vendingMachineData.buySprite();
            }
        });
    }

    private void registerObservable() {
        vendingObservable.registerObserver(this);
        Toast.makeText(this, "Observer Registered!", Toast.LENGTH_SHORT).show();
    }

    private void unregisterObservable() {
        vendingObservable.removeObserver(this);
        Toast.makeText(this, "Observer Unregistered!", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void updateValue() {

    }

    @Override
    public void update(int fanta, int cocaCola, int sprite) {
        fantaTextView.setText(Integer.toString(fanta));
        cocaColaTextView.setText(Integer.toString(cocaCola));
        spriteTextView.setText(Integer.toString(sprite));
    }
}
