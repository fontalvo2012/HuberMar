package com.example.jhosely.hubermar;
import android.app.DatePickerDialog;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Spinner;

import java.util.Calendar;

public class ParametrosActivity extends AppCompatActivity {
    private EditText desde,hasta,nrodo,pedido;
    private Spinner regimen;
    private Button generar;
    private  DatePickerDialog.OnDateSetListener mDateSetListener1;
    private  DatePickerDialog.OnDateSetListener mDateSetListener2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_parametros);
        desde=findViewById(R.id.desde);
        hasta=findViewById(R.id.hasta);
        generar=findViewById(R.id.gen);

        generar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent tabla=new Intent(getApplicationContext(),informacionGeneralActivity.class);
                startActivity(tabla);
            }
        });
        //DATA PICKER DESDE
        desde.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Calendar cal= Calendar.getInstance();
                int year=cal.get(Calendar.YEAR);
                int mes=cal.get(Calendar.MONTH);
                int dia=cal.get(Calendar.DAY_OF_MONTH);

                DatePickerDialog dialog= new DatePickerDialog(
                        ParametrosActivity.this,
                        android.R.style.Theme_Holo_Light_Dialog_MinWidth,
                        mDateSetListener1,
                        year,mes,dia);
                dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
                dialog.show();

            }
        });

        mDateSetListener1= new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker datePicker, int year, int mes, int dia) {
                mes=mes+1;
                String date=year+"-"+mes+"-"+dia;
                desde.setText(date);
            }
        };

        //DATAPICKER HASTA
        hasta.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Calendar cal= Calendar.getInstance();
                int year=cal.get(Calendar.YEAR);
                int mes=cal.get(Calendar.MONTH);
                int dia=cal.get(Calendar.DAY_OF_MONTH);

                DatePickerDialog dialog= new DatePickerDialog(
                        ParametrosActivity.this,
                        android.R.style.Theme_Holo_Light_Dialog_MinWidth,
                        mDateSetListener2,
                        year,mes,dia);
                dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
                dialog.show();

            }
        });

        mDateSetListener2= new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker datePicker, int year, int mes, int dia) {
                mes=mes+1;
                String date=year+"-"+mes+"-"+dia;
                hasta.setText(date);
            }
        };

    }
}
