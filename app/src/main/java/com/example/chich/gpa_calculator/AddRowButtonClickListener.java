package com.example.chich.gpa_calculator;

import android.view.View;
import android.widget.Toast;
import java.util.ArrayList;

public class AddRowButtonClickListener implements View.OnClickListener {

    ArrayList<Row> rItems;
    RowAdapter rAdapter;
    AddRowButtonClickListener(ArrayList<Row> rItems, RowAdapter rowAdapter){
        this.rItems = rItems;
        this.rAdapter = rowAdapter;
    }
    @Override
    public void onClick(View v) {
        Toast.makeText(v.getContext(), "yahhh", Toast.LENGTH_SHORT).show();
        rItems.add(new Row());
        rAdapter.notifyDataSetChanged();
    }
}
