package com.example.barbearia;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class ServicosActivity extends AppCompatActivity {
    TextView btn_corte;
    TextView btn_corte_barba;
    TextView btn_barba;
    TextView btn_corte_maquina;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setTitle("Selecione o Serviço");
        setContentView(R.layout.activity_servicos);
        btn_corte = findViewById(R.id.btn_corte);
        btn_corte_barba = findViewById(R.id.btn_corte_barba);
        btn_barba = findViewById(R.id.btn_barba);
        btn_corte_maquina = findViewById(R.id.btn_corte_maquina);

        btn_corte.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ServicosActivity.this, ProfissionalActivity.class);
                intent.putExtra("chave" ,btn_corte.getText().toString());
                startActivity(intent);
            }
        });
        btn_corte_barba.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ServicosActivity.this, ProfissionalActivity.class);
                intent.putExtra("chave" ,btn_corte_barba.getText().toString());
                startActivity(intent);
            }
        });
        btn_barba.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ServicosActivity.this, ProfissionalActivity.class);
                intent.putExtra("chave" ,btn_barba.getText().toString());
                startActivity(intent);

            }
        });
        btn_corte_maquina.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ServicosActivity.this, ProfissionalActivity.class);
                intent.putExtra("chave" ,btn_corte_maquina.getText().toString());
                startActivity(intent);
            }
        });
    }
}