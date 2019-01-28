package com.example.chich.gpa_calculator;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.SpinnerAdapter;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class RowAdapter extends ArrayAdapter<Row> {


    private Activity mainActivity;
    public RowAdapter(Activity activity, ArrayList<Row> rItems) {
        super(activity, 0 ,rItems);
        mainActivity = activity;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        // Check if the existing view is being reused, otherwise inflate the view
        View listItemView = convertView;
        if(listItemView == null) {
            listItemView = LayoutInflater.from(getContext()).inflate(
                    R.layout.row_item, parent, false);
        }

        // Get the {@link row} object located at this position in the list
        final Row currentRow = getItem(position);

        // Find the TextView in the list_item.xml layout with the ID version_name
        EditText courseNameEditView = (EditText) listItemView.findViewById(R.id.course_name_view);
        // Get the version name from the current AndroidFlavor object and
        // set this text on the name TextView
        courseNameEditView.setText(Row.COURSE_NAME);

        // Find the TextView in the list_item.xml layout with the ID version_name
        TextView gradeTextView = (TextView) listItemView.findViewById(R.id.grade_text_view);
        // Get the version name from the current AndroidFlavor object and
        // set this text on the name TextView
        gradeTextView.setText(Row.GRADE);

        // Find the TextView in the list_item.xml layout with the ID version_number
        TextView creditTextView = (TextView) listItemView.findViewById(R.id.credit_text_view);
        // Get the version number from the current AndroidFlavor object and
        // set this text on the number TextView
        creditTextView.setText(Row.CREDIT);

        Spinner gradeSpinner = listItemView.findViewById(R.id.grade_spinner);
        String[] SpinnerGradeData = {"A+","A","A-","B+","B","B-","C+", "C", "C-","D+", "D","D-","F"};
        ArrayAdapter<String> gAdapter = new ArrayAdapter<String>(mainActivity, android.R.layout.simple_spinner_dropdown_item, SpinnerGradeData);
        gradeSpinner.setAdapter(gAdapter);
        /*
        gradeSpinner.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String grade = parent.getItemAtPosition(position).toString();

                Toast.makeText(mainActivity, "selected :"+ grade, Toast.LENGTH_SHORT);
                currentRow.setGradeValue(Row.GRADE_MAP.get(grade));

            }
        });
        */

        Spinner creditSpinner = listItemView.findViewById(R.id.credit_spinner);
        String[] SpinnerCreditData = {"0","1","2","3","4","5","6"};
        ArrayAdapter<String> cAdapter = new ArrayAdapter<String>(mainActivity, android.R.layout.simple_spinner_dropdown_item, SpinnerCreditData);
        creditSpinner.setAdapter(cAdapter);
        /*
        creditSpinner.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String credits = parent.getItemAtPosition(position).toString();

                Toast.makeText(mainActivity, "selected :"+ grade, Toast.LENGTH_SHORT);
                currentRow.setCreditValue(credits);
            }
        });
        */

        // Return the whole list item layout (containing 2 TextViews and an ImageView)
        // so that it can be shown in the ListView
        return listItemView;
    }

}

