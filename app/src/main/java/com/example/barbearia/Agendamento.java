package com.example.barbearia;

import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CalendarView;
import android.widget.DatePicker;
import android.widget.TextView;
import android.widget.TimePicker;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Locale;

public class Agendamento extends AppCompatActivity {
    Button btn_Corte;
    Button btn_Barbeiro;
    TextView etData;
    TextView etHora;
    Button btn_Confirmar;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_agendamento);
        btn_Corte = findViewById(R.id.btn_Servico_Agendado);
        btn_Barbeiro = findViewById(R.id.btn_Barbeiro_Agendado);
        String valor1 = getIntent().getStringExtra("chave1");
        String valor2 = getIntent().getStringExtra("chave2");
        btn_Corte.setText(valor1);
        btn_Barbeiro.setText(valor2);
        etData = findViewById(R.id.etData);
        etHora = findViewById(R.id.etHora);
        btn_Confirmar = findViewById(R.id.btn_Confirmar);
        btn_Confirmar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               confirmar();
            }
        });

    }
    public void abrirCalendario(View view) {
        Calendar calendar = Calendar.getInstance();
        int ano = calendar.get(Calendar.YEAR);
        int mes = calendar.get(Calendar.MONTH);
        int dia = calendar.get(Calendar.DAY_OF_MONTH);

        DatePickerDialog datePickerDialog = new DatePickerDialog(Agendamento.this, new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                String fecha = dayOfMonth + "/" + month + "/" + year;
                etData.setText(fecha);
            }
        }, 2022, mes, dia);
        datePickerDialog.show();
    }
    public void abrirHora(View view){
        Calendar calendar = Calendar.getInstance();
        int hora = calendar.get(Calendar.HOUR_OF_DAY);
        int minuto = calendar.get(Calendar.MINUTE);

        TimePickerDialog timePickerDialoge = new TimePickerDialog(Agendamento.this, new TimePickerDialog.OnTimeSetListener() {
            @Override
            public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
              etHora.setText(hourOfDay + ":" + minute);
            }
        }, hora, minuto, true);
        timePickerDialoge.show();
    }

    public void confirmar(){
         FirebaseDatabase database = FirebaseDatabase.getInstance();
         DatabaseReference reference = database.getReference();
         btn_Corte.setText(btn_Corte.getText());
         btn_Barbeiro.setText(btn_Barbeiro.getText());
         etData.setText(etData.getText());
         etHora.setText(etHora.getText());
    }
}