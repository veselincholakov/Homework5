package com.example.veski.homework5;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    public final Context ctx = this;
    private DatabaseManager dbManager;
    private RecyclerView recyclerView;
    private ListAdapter adapter;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        dbManager = new DatabaseManager(ctx);
        recyclerView = (RecyclerView) findViewById(R.id.rec_list);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

    }


    public void onClick(View view){
        int count = dbManager.getAllRecords().size();
        ListItem.currentId = count;
        for(int i = 0; i<80;i++){
            ListItem item = new ListItem();
            dbManager.addRecord(item);
        }
    }

    public void onClickPopulate(View view){
//        List<ListItem> items = dbManager.getAllRecords();
//        if(items != null && items.size() >= 1) {
            adapter = new ListAdapter(dbManager.getAllRecords(), ctx);
            recyclerView.setAdapter(adapter);
//        }
    }


}
