package com.example.barbearia;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class Profissional extends AppCompatActivity {
    Button btn_corte;
    TextView btn_Leonardo;
    TextView btn_Rodrigo;
    TextView btn_Lucas;
    TextView btn_David;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setTitle("Selecione o Barbeiro");
        setContentView(R.layout.activity_profissional);
        btn_corte = findViewById(R.id.btn_servico);
        String valor = getIntent().getStringExtra("chave");
        btn_corte.setText(valor);
        btn_Leonardo = findViewById(R.id.btn_Leonardo);
        btn_Rodrigo = findViewById(R.id.btn_Rodrigo);
        btn_Lucas = findViewById(R.id.btn_Lucas);
        btn_David = findViewById(R.id.btn_David);
        btn_Leonardo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Profissional.this, Agendamento.class);
                intent.putExtra("chave1", btn_corte.getText().toString());
                intent.putExtra("chave2", btn_Leonardo.getText().toString());
                startActivity(intent);
            }
        });
        btn_Rodrigo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Profissional.this, Agendamento.class);
                intent.putExtra("chave1", btn_corte.getText().toString());
                intent.putExtra("chave2", btn_Rodrigo.getText().toString());
                startActivity(intent);
            }
        });
        btn_Lucas.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Profissional.this, Agendamento.class);
                intent.putExtra("chave1", btn_corte.getText().toString());
                intent.putExtra("chave2", btn_Lucas.getText().toString());
                startActivity(intent);
            }
        });
        btn_David.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Profissional.this, Agendamento.class);
                intent.putExtra("chave1", btn_corte.getText().toString());
                intent.putExtra("chave2", btn_David.getText().toString());
                startActivity(intent);
            }
        });
    }
}