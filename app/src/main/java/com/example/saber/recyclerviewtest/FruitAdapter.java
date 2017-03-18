package com.example.saber.recyclerviewtest;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

/**
 * Created by saber on 2017/3/2.
 */

public class FruitAdapter extends RecyclerView.Adapter<FruitAdapter.ViewHolder>{

    private List<Fruit> fruits;

    public FruitAdapter(List<Fruit> fruits) {
        this.fruits = fruits;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.fruit_item,null);
        final ViewHolder holder = new ViewHolder(view);
        holder.fruitView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int position = holder.getAdapterPosition();
                Fruit fruit = fruits.get(position);
                Toast.makeText(view.getContext(),"position:"+position,Toast.LENGTH_SHORT).show();
            }
        });
        holder.iv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int position = holder.getAdapterPosition();
                Fruit fruit = fruits.get(position);
                Toast.makeText(view.getContext(),"You click Image:"+position,Toast.LENGTH_SHORT).show();
            }
        });
        return holder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        Fruit fruit = fruits.get(position);
        holder.iv.setImageResource(fruit.getImgId());
        holder.tv.setText(fruit.getName());
    }

    @Override
    public int getItemCount() {
        return fruits.size();
    }

   static class ViewHolder extends RecyclerView.ViewHolder{

       View fruitView;
       ImageView iv;
       TextView tv;

       public ViewHolder(View view) {
           super(view);
           fruitView = view;
           iv = (ImageView)view.findViewById(R.id.iv);
           tv = (TextView) view.findViewById(R.id.tv);
       }
   }


}
