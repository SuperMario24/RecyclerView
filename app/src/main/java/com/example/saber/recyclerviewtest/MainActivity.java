package com.example.saber.recyclerviewtest;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class MainActivity extends AppCompatActivity {

    private List<Fruit> fruits = new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.rv);
        initFruits();

//        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
//        layoutManager.setOrientation(LinearLayoutManager.HORIZONTAL);

        StaggeredGridLayoutManager layoutManager = new StaggeredGridLayoutManager(3,StaggeredGridLayoutManager.VERTICAL);

        recyclerView.setLayoutManager(layoutManager);

        FruitAdapter adapter = new FruitAdapter(fruits);
        recyclerView.setAdapter(adapter);


    }

    private void initFruits() {
        for (int i=0;i<4;i++){
            Fruit fruit = new Fruit();
            fruit.setImgId(R.mipmap.ic_launcher);
            fruit.setName(getRandomLengthName("Apple"));
            fruits.add(fruit);

            Fruit fruit1 = new Fruit();
            fruit1.setImgId(R.mipmap.ic_launcher);
            fruit1.setName(getRandomLengthName("Banana"));
            fruits.add(fruit1);

            Fruit fruit2 = new Fruit();
            fruit2.setImgId(R.mipmap.ic_launcher);
            fruit2.setName(getRandomLengthName("Pear"));
            fruits.add(fruit2);

            Fruit fruit3 = new Fruit();
            fruit3.setImgId(R.mipmap.ic_launcher);
            fruit3.setName(getRandomLengthName("Cherry"));
            fruits.add(fruit3);
        }
    }

    public String getRandomLengthName(String fruit){
        String name=fruit;
        int length = new Random().nextInt(20)+1;
        StringBuilder builder = new StringBuilder(name);
        for (int i =0;i<length;i++){
            builder.append(name);
        }
        name = builder.toString();
        return name;
    }
}
