package com.example.upperskills.test;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.ArrayAdapter;
import android.widget.DatePicker;
import android.widget.ImageButton;
import android.widget.Spinner;
import android.widget.TextView;

import java.util.Calendar;

public class Main2Activity extends AppCompatActivity {
    private TextView dateDeVoiture;
    private TextView nom;
    private DatePickerDialog.OnDateSetListener mDateSetListener;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_main3);

        //region button_suivant

        ImageButton suivantButton = (ImageButton) findViewById(R.id.precedent);

        suivantButton.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                startActivity(new Intent(Main2Activity.this, MainActivity.class));
            }
        });

        //endregion

        //region date_de_naissance

        dateDeVoiture = (TextView) findViewById(R.id.dateVoiture);
        //nom = (TextView) findViewById(R.id.nom);
        dateDeVoiture.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Calendar cal=Calendar.getInstance();
                int year = cal.get(Calendar.YEAR);
                int month = cal.get(Calendar.MONTH);
                int day=cal.get(Calendar.DAY_OF_MONTH);

                DatePickerDialog dialog = new DatePickerDialog(
                        Main2Activity.this,

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
                dateDeVoiture.setText(date);
                //Log.d(Tag, "a="+nom.getText());
            }
        };

/////////spinner

        String[] country = { "Shell ", "OilLibya", "Agil", "StartOil", "Total",  };
        Spinner spin = (Spinner) findViewById(R.id.spinner1);
        ArrayAdapter aa = new ArrayAdapter(this,android.R.layout.simple_spinner_item,country);
        aa.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spin.setAdapter(aa);


//endregion
    }
}
