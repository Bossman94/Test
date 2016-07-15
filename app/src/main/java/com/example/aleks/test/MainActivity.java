package com.example.aleks.test;

import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.content.Context;
import android.view.Display;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.graphics.Canvas;
import android.graphics.Color;
import android.os.Bundle;

import java.util.Collections;
import java.util.Random;
import java.util.Vector;

public class MainActivity extends AppCompatActivity {

    private RecyclerView mRecyclerView;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager mLayoutManager;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

       Vector numbers = new Vector();
        numbers = getDataSet();
        mRecyclerView = (RecyclerView) findViewById(R.id.my_recycler_view);

        // если мы уверены, что изменения в контенте не изменят размер layout-а RecyclerView
        // передаем параметр true - это увеличивает производительность
        mRecyclerView.setHasFixedSize(true);
        TextView Test_Main;
                     Test_Main = (TextView) findViewById(R.id.textViewMAIN);



        RecyclerAdapter.main = Test_Main;
        RecyclerAdapter.maxrand = Double.valueOf(Collections.max(numbers).toString());
        Double koefmax = RecyclerAdapter.maxrand/RecyclerAdapter.uroven;
        //меняем размер линейки!!!!!!!!!!!!!!!!!!!!
        TextView t1;
        t1 = (TextView) findViewById(R.id.t1);
        t1.setText(String.valueOf((int)(koefmax*Double.valueOf(t1.getText().toString()))));
        TextView t2;
        t2 = (TextView) findViewById(R.id.t2);
        t2.setText(String.valueOf((int)(koefmax*Double.valueOf(t2.getText().toString()))));
        TextView t3;
        t3 = (TextView) findViewById(R.id.t3);
        t3.setText(String.valueOf((int)(koefmax*Double.valueOf(t3.getText().toString()))));
        TextView t4;
        t4 = (TextView) findViewById(R.id.t4);
        t4.setText(String.valueOf((int)(koefmax*Double.valueOf(t4.getText().toString()))));
        // используем linear layout manager
        mLayoutManager = new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false);
        mRecyclerView.setLayoutManager(mLayoutManager);
        // создаем адаптер
        mAdapter = new RecyclerAdapter(numbers);
        mRecyclerView.setAdapter(mAdapter);
        //////////

    }


    private Vector getDataSet() {
        Random r = new Random(System.currentTimeMillis());
        Vector mDataSet = new Vector();
        for (int i = 0; i < 20000; i++)
        {//r.nextInt(1700)
            mDataSet.addElement(r.nextInt(100000));
        }
        return mDataSet;
    }

}


