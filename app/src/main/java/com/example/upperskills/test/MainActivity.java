package com.example.upperskills.test;

import android.app.AlertDialog;
import android.app.DatePickerDialog;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;


import java.util.Calendar;
import android.util.Log;
import android.view.View;
import android.view.WindowManager;
import android.widget.DatePicker;
import android.widget.ImageButton;
import android.widget.TextView;





public class MainActivity extends AppCompatActivity  {
    private static final String Tag = "MainActivity";
    private TextView dateDeNaissance;
    private DatePickerDialog.OnDateSetListener mDateSetListener;
    private  TextView nom ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_main);

        //region button_suivant

        ImageButton suivantButton = (ImageButton) findViewById(R.id.suivant);

        suivantButton.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                startActivity(new Intent(MainActivity.this, Main2Activity.class));

                Log.d("MainActivity","button appuyer");
            }
        });

        //endregion

        //region date_de_naissance

        dateDeNaissance = (TextView) findViewById(R.id.date);
        nom = (TextView) findViewById(R.id.nom);
        dateDeNaissance.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Calendar cal=Calendar.getInstance();
                int year = cal.get(Calendar.YEAR);
                int month = cal.get(Calendar.MONTH);
                int day=cal.get(Calendar.DAY_OF_MONTH);

                DatePickerDialog dialog = new DatePickerDialog(
                        MainActivity.this,

                       mDateSetListener,
                        year,month,day);

                dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.CYAN));
                dialog.show();


            }
        });
        mDateSetListener = new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker datePicker, int year, int month, int day) {
                //Log.d(Tag, "onDateSet: date " + i + "/" + i1 + "/" + i2);
                month=month+1;
                String date = day + "/" + month + "/" + year;
                dateDeNaissance.setText(date);
                //Log.d(Tag, "a="+nom.getText());
             }
            };

//endregion

        }



}

