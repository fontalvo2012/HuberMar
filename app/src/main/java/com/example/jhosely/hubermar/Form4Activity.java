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
import android.widget.TextView;
import android.widget.Toast;

import java.util.Calendar;

public class Form4Activity extends AppCompatActivity {
    private Button basicos,espesifica,filtro,generar,listo3;
    private EditText Aperturaini,Aperturafin,levanteIni,LevanteFin;
    private TextView nombreUser,perfil;
    private Spinner regimen,estado;

    private  DatePickerDialog.OnDateSetListener mDateSetListener;
    private  DatePickerDialog.OnDateSetListener mDateSetListener2;
    private  DatePickerDialog.OnDateSetListener mDateSetListener3;
    private  DatePickerDialog.OnDateSetListener mDateSetListener4;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_form4);

        basicos=findViewById(R.id.basicos);
        espesifica=findViewById(R.id.espesifica);
        filtro=findViewById(R.id.filtro);
        generar=findViewById(R.id.generar);

        Aperturaini=findViewById(R.id.Aperturaini);
        Aperturafin=findViewById(R.id.Aperturafin);
        levanteIni=findViewById(R.id.levanteIni);
        LevanteFin=findViewById(R.id.levanteFin);
        listo3=findViewById(R.id.listo3);
        regimen=findViewById(R.id.regimen);
        estado=findViewById(R.id.estado);


        Aperturaini.setText(Global.aperturaIni);
        Aperturafin.setText(Global.aperturaFin);
        levanteIni.setText(Global.levanteIni);
        LevanteFin.setText(Global.levanteFin);
        regimen.setSelection(Global.posRegimen);
        estado.setSelection(Global.posEstado);

        listo3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(Form4Activity.this,"Parametros Fijados",Toast.LENGTH_SHORT).show();
                Global.aperturaIni=Aperturaini.getText()+"";
                Global.aperturaFin=Aperturafin.getText()+"";
                Global.levanteFin=LevanteFin.getText()+"";
                Global.levanteIni=levanteIni.getText()+"";
                Global.regimen=regimen.getSelectedItem()+"";
                Global.posRegimen=regimen.getSelectedItemPosition();
                Global.estado=estado.getSelectedItem()+"";
                Global.posEstado=estado.getSelectedItemPosition();
                Intent Form5=new Intent(getApplicationContext(),Form5Activity.class);
                startActivity(Form5);

            }
        });

        nombreUser=findViewById(R.id.nombreUser);
        perfil=findViewById(R.id.perfil);
        nombreUser.setText(Global.nombre);
        perfil.setText(Global.perfil);

        //============================================================================
        LevanteFin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Calendar cal= Calendar.getInstance();
                int year=cal.get(Calendar.YEAR);
                int mes=cal.get(Calendar.MONTH);
                int dia=cal.get(Calendar.DAY_OF_MONTH);

                DatePickerDialog dialog= new DatePickerDialog(
                        Form4Activity.this,
                        android.R.style.Theme_Holo_Light_Dialog_MinWidth,
                        mDateSetListener4,
                        year,mes,dia);
                dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
                dialog.show();

            }
        });

        mDateSetListener4= new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker datePicker, int year, int mes, int dia) {
                mes=mes+1;
                String date=year+"-"+mes+"-"+dia;
                LevanteFin.setText(date);
            }
        };
        //============================================================================
        levanteIni.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Calendar cal= Calendar.getInstance();
                int year=cal.get(Calendar.YEAR);
                int mes=cal.get(Calendar.MONTH);
                int dia=cal.get(Calendar.DAY_OF_MONTH);

                DatePickerDialog dialog= new DatePickerDialog(
                        Form4Activity.this,
                        android.R.style.Theme_Holo_Light_Dialog_MinWidth,
                        mDateSetListener3,
                        year,mes,dia);
                dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
                dialog.show();


            }
        });

        mDateSetListener3= new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker datePicker, int year, int mes, int dia) {
                mes=mes+1;
                String date=year+"-"+mes+"-"+dia;
                levanteIni.setText(date);
            }
        };
        //============================================================================
        Aperturaini.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Calendar cal= Calendar.getInstance();
                int year=cal.get(Calendar.YEAR);
                int mes=cal.get(Calendar.MONTH);
                int dia=cal.get(Calendar.DAY_OF_MONTH);

                DatePickerDialog dialog= new DatePickerDialog(
                    Form4Activity.this,
                        android.R.style.Theme_Holo_Light_Dialog_MinWidth,
                        mDateSetListener,
                        year,mes,dia);
                dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
                dialog.show();

            }
        });

        mDateSetListener= new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker datePicker, int year, int mes, int dia) {
                mes=mes+1;
                String date=year+"-"+mes+"-"+dia;
                Aperturaini.setText(date);
            }
        };
        //============================================================================
        Aperturafin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Calendar cal= Calendar.getInstance();
                int year=cal.get(Calendar.YEAR);
                int mes=cal.get(Calendar.MONTH);
                int dia=cal.get(Calendar.DAY_OF_MONTH);

                DatePickerDialog dialog= new DatePickerDialog(
                        Form4Activity.this,
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
                Aperturafin.setText(date);
            }
        };
        //============================================================================
        //MENU PRINCIPAL
        basicos.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent Form2=new Intent(getApplicationContext(),Form2Activity.class);
                startActivity(Form2);
            }
        });

        espesifica.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent Form3=new Intent(getApplicationContext(),Form3Activity.class);
                startActivity(Form3);
            }
        });

        filtro.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent Form1=new Intent(getApplicationContext(),Form1Activity.class);
                startActivity(Form1);
            }
        });
        generar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent Form5=new Intent(getApplicationContext(),Form5Activity.class);
                startActivity(Form5);
            }
        });
        //FIN MENU PRINCIPAL
    }
}
