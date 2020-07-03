package com.icandothisallday2020.ex56recyclerview;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    ArrayList<String> items=new ArrayList<>();/*1*/
    RecyclerView recyclerView;
    MyAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        items.add(new String("aaa"));/*2*/
        items.add(new String("aaa"));
        items.add(new String("aaa"));    items.add(new String("aaa"));   items.add(new String("aaa"));   items.add(new String("aaa"));   items.add(new String("aaa"));   items.add(new String("aaa"));   items.add(new String("aaa"));   items.add(new String("aaa"));   items.add(new String("aaa"));   items.add(new String("aaa"));
        /*3. Project Structure- dependence -Library 추가
        res/layout/recycler_item.xml 생성*/
        /*4. MyAdapter.java */
        adapter=new MyAdapter(this,items);/*5*/
        recyclerView=findViewById(R.id.recycler);/*6*/
        recyclerView.setAdapter(adapter);/*7*/

        /*8 리스너를 아이템에 붙이기 :Adapter 에서*/
    }
}
