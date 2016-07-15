package com.example.aleks.test;

import android.support.v7.widget.RecyclerView;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Vector;

/**
 * Created by Aleks on 12.07.2016.
 */
public class RecyclerAdapter extends RecyclerView.Adapter<RecyclerAdapter.ViewHolder> {
    private Vector numbers_random;

   // private String[] mDataset;
    // класс view holder-а с помощью которого мы получаем ссылку на каждый элемент
    // отдельного пункта списка
   static  public TextView main;

    public  Double koefmax, koefmin; //увеличение уменьшение
    public static Double maxrand; //максимальный элемент
    public static Double uroven = 1370.;
    public static class ViewHolder extends RecyclerView.ViewHolder {
        // наш пункт состоит только из одного TextView
        public TextView mTextView;

        public ViewHolder(View v) {
            super(v);
            mTextView = (TextView) v.findViewById(R.id.tv_recycler_item);
        }
    }

    // Конструктор
    public RecyclerAdapter(Vector dataset) {
        numbers_random = dataset;
    }

    // Создает новые views (вызывается layout manager-ом)
    @Override
    public RecyclerAdapter.ViewHolder onCreateViewHolder(ViewGroup parent,
                                                         int viewType) {
        // create a new view
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.recycler_item, parent, false);

        ViewHolder vh = new ViewHolder(v);
        return vh;
    }

    @Override
    public int getItemViewType(int position)
    {
        return super.getItemViewType(position);
    }

    // Заменяет контент отдельного view (вызывается layout manager-ом)
    @Override
    public void onBindViewHolder(ViewHolder holder, int position)
    {
        LinearLayout.LayoutParams lparams;
        LinearLayout.LayoutParams params = (LinearLayout.LayoutParams) holder.mTextView.getLayoutParams(); // получаем параметры

        koefmin = uroven/maxrand;
        koefmax = maxrand/uroven;
        params.height = (int)((int)numbers_random.elementAt(position) * koefmin); //высота столбца

        holder.mTextView.setLayoutParams(params);
        holder.mTextView.setText(String.valueOf(numbers_random.elementAt(position)));
        holder.mTextView.setOnClickListener (new View.OnClickListener() {
            @Override
            public void onClick(View v) {   // action on click
                TextView testtesttest;
                testtesttest = (TextView) v.findViewById(R.id.tv_recycler_item);
                Toast toast = Toast.makeText(v.getContext(),
                        testtesttest.getText(), Toast.LENGTH_SHORT);
                toast.setGravity(Gravity.BOTTOM, 0, 0);
                main.setText(testtesttest.getText());
                Animation animation = AnimationUtils.loadAnimation(v.getContext(), R.anim.alpha);
                testtesttest.startAnimation(animation);
                toast.show();
            }
        });
    }

    // Возвращает размер данных (вызывается layout manager-ом)
    @Override
    public int getItemCount() {
        return numbers_random == null ? 0 : numbers_random.size();
    }
}

