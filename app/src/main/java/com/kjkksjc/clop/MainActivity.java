package com.kjkksjc.clop;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Button;


import com.kjkksjc.clop.adapters.AdapterForGameItems;

import java.util.ArrayList;
import java.util.Random;

public class MainActivity extends AppCompatActivity {

    private WheelView wheelView1;
    private WheelView wheelView2;
    private WheelView wheelView3;
    private WheelView wheelView4;
    private WheelView wheelView5;

    private Button playBtn;
    private ArrayList<Integer> listForItemsPlay;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        wheelView1 = findViewById(R.id.wheel1);
        wheelView2 = findViewById(R.id.wheel2);
        wheelView3 = findViewById(R.id.wheel3);
        wheelView4 = findViewById(R.id.wheel4);
        wheelView5 = findViewById(R.id.wheel5);

        initSlots();
        playBtn = findViewById(R.id.btn_play);
        playBtn.setOnClickListener(__ -> pushPlay());

    }

    private void initSlots() {
        initPlayerData(wheelView1, getListForItemsPlay());
        initPlayerData(wheelView2, getListForItemsPlay());
        initPlayerData(wheelView3, getListForItemsPlay());
        initPlayerData(wheelView4, getListForItemsPlay());
        initPlayerData(wheelView5, getListForItemsPlay());

    }

    private ArrayList<Integer> getListForItemsPlay() {
        if (listForItemsPlay == null) {
            final ArrayList<Integer> list = new ArrayList<>();
            list.add(R.drawable.item_1);
            list.add(R.drawable.item_2);
            list.add(R.drawable.item_3);
            list.add(R.drawable.item_4);
            list.add(R.drawable.item_5);
            list.add(R.drawable.item_6);
            list.add(R.drawable.item_7);
            list.add(R.drawable.item_8);
            list.add(R.drawable.item_9);


            this.listForItemsPlay = list;
        }

        return listForItemsPlay;
    }

    private void initPlayerData(WheelView wheelView, ArrayList<Integer> list) {
        wheelView.setViewAdapter(new AdapterForGameItems(this, list));
        wheelView.setCurrentItem((int) (Math.random() * 10.0d));
        wheelView.setVisibleItems(4);
        wheelView.setCyclic(true);
        wheelView.setEnabled(false);
    }


    private void pushPlay() {
        Random random = new Random();
        wheelView1.scroll(((int) ((Math.random() * ((double) random.nextInt(30))) + 20.0d)) - 350, random.nextInt(3000) + 2000);
        wheelView2.scroll(((int) ((Math.random() * ((double) random.nextInt(30))) + 20.0d)) - 350, random.nextInt(3000) + 2000);
        wheelView3.scroll(((int) ((Math.random() * ((double) random.nextInt(30))) + 20.0d)) - 350, random.nextInt(3000) + 2000);
        wheelView4.scroll(((int) ((Math.random() * ((double) random.nextInt(30))) + 20.0d)) - 350, random.nextInt(3000) + 2000);
        wheelView5.scroll(((int) ((Math.random() * ((double) random.nextInt(30))) + 20.0d)) - 350, random.nextInt(3000) + 2000);
      }

}