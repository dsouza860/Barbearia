package com.example.barbearia;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.provider.CalendarContract;
import android.widget.Button;
import android.widget.EditText;

public class Agendamento extends AppCompatActivity {
    Button btn_Corte;
    Button btn_Barbeiro;


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

        Intent intent = new Intent(Intent.ACTION_INSERT);
        intent.setData(CalendarContract.Events.CONTENT_URI);
        startActivity(intent);
    }
}