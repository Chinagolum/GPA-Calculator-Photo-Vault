package com.example.chich.gpa_calculator;

import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ArrayList<Row> rItems = new ArrayList<Row>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ListView mainList = findViewById(R.id.main_list);


        final RowAdapter rAdapter = new RowAdapter(this, rItems);
        mainList.setAdapter(rAdapter);
        AddRowButtonClickListener mbclickListener = new AddRowButtonClickListener(rItems, rAdapter);



        com.github.clans.fab.FloatingActionButton insertButton = (com.github.clans.fab.FloatingActionButton) findViewById(R.id.insert_fab);
        com.github.clans.fab.FloatingActionButton deleteButton = (com.github.clans.fab.FloatingActionButton) findViewById(R.id.delete_fab);


        insertButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(v.getContext(), "yahhh", Toast.LENGTH_SHORT).show();
                rItems.add(new Row());
                rAdapter.notifyDataSetChanged();
                rItems.get(Row.getCurrRow());
            }
        });

        deleteButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(Row.getNumRows()>0) {
                    rItems.remove(Row.getCurrRow());
                    rAdapter.notifyDataSetChanged();
                }
            }
        });

        rItems.add(new Row());
        rItems.add(new Row());
    }
}
