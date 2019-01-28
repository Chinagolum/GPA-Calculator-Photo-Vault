package com.example.chich.gpa_calculator;

import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Spinner;

import java.util.HashMap;

public class Row {
    public static final HashMap<String, Double> GRADE_MAP;
    static {
        GRADE_MAP = new HashMap<String, Double>() {{
            put("A+",4.0);
            put("A",4.0);
            put("A-",3.7);
            put("B+",3.3);
            put("B",3.0);
            put("B-",2.7);
            put("C+",2.3);
            put("C",2.0);
            put("C-",1.7);
            put("D+",1.3);
            put("D",1.0);
            put("D-",0.7);
            put("F",0.0);
        }};
    }

    public static final String GRADE = "Grade";
    public static final String CREDIT = "Credit";
    public static final String COURSE_NAME = "Course Name";
    private static int numRows = 0;
    private static int currRow = 0;
    private int rowID;
    private Spinner gradeSpinner;
    private Spinner creditSpinner;
    private double gradeValue;
    private int creditValue;

    public Row(){
        rowID = numRows;
        numRows++;
        gradeValue=GRADE_MAP.get("A+");
        creditValue=0;
    }

    public int getRowID() {
        return rowID;
    }

    public static int getNumRows() {
        return numRows;
    }

    public void changeCurrRow(){
        currRow = rowID;
    }

    public static int getCurrRow() {
        return currRow;
    }

    public void setGradeValue(double gradeValue) {
        this.gradeValue = gradeValue;
    }
}

