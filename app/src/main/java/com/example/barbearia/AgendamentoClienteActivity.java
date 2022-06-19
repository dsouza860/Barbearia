package com.example.barbearia;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.content.Context;
import android.os.Build;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.TimePicker;
import android.widget.Toast;

import com.google.android.material.snackbar.Snackbar;

import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

public class AgendamentoClienteActivity extends AppCompatActivity {
    TextView btn_Corte;
    TextView btn_Barbeiro;
    TextView etData;
    TextView etHora;
    EditText etNome;
    EditText etTelefone;
    ListView lvClientesAgendados;
    Button btn_Confirmar;

    private List<String> lista = new ArrayList<>();
    private ArrayAdapter<String> adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_agendamentocliente);
        btn_Corte = findViewById(R.id.btn_Servico_Agendado);
        btn_Barbeiro = findViewById(R.id.btn_Barbeiro_Agendado);
        String valor1 = getIntent().getStringExtra("chave1");
        String valor2 = getIntent().getStringExtra("chave2");
        btn_Corte.setText(valor1);
        btn_Barbeiro.setText(valor2);
        etData = findViewById(R.id.etData);
        etHora = findViewById(R.id.etHora);
        btn_Confirmar = findViewById(R.id.btn_Confirmar);
        etNome = findViewById(R.id.edNome);
        etTelefone = findViewById(R.id.edTelefone);
        lvClientesAgendados = findViewById(R.id.lvClientesAgendados);
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

        DatePickerDialog datePickerDialog = new DatePickerDialog(AgendamentoClienteActivity.this, new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                String fecha = dayOfMonth + "/" + month + "/" + year;
                etData.setText(fecha);
            }
        }, 2022, mes, dia);
        datePickerDialog.show();
    }

    @RequiresApi(api = Build.VERSION_CODES.O)
    public void abrirHora(View view) {
        Calendar calendar = Calendar.getInstance();

        int hora = calendar.get(Calendar.HOUR_OF_DAY);
        int minuto = calendar.get(Calendar.MINUTE);

        TimePickerDialog timePickerDialoge = new TimePickerDialog(AgendamentoClienteActivity.this, new TimePickerDialog.OnTimeSetListener() {
            @Override
            public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
                etHora.setText(hourOfDay + ":" + minute);
            }
        }, hora, minuto, true);
        timePickerDialoge.show();
    }

    public void confirmar() {
        validaCliente();

        adapter = new ArrayAdapter<String>(AgendamentoClienteActivity.this, android.R.layout.simple_list_item_1, lista);
        lvClientesAgendados.setAdapter(adapter);

    }

    public void validaCliente() {
        AgendamentoCliente cliente = new AgendamentoCliente();
        cliente.setBarbeiro(btn_Barbeiro.getText().toString());
        cliente.setServico(btn_Corte.getText().toString());
        cliente.setNome(etNome.getText().toString());
        cliente.setTelefone(etTelefone.getText().toString());
        cliente.setData(etData.getText().toString());
        cliente.setHora(etHora.getText().toString());
      if(etNome.getText().toString().equals("") || etTelefone.getText().toString().equals("") || etData.getText().toString().equals("") ||
      etHora.getText().toString().equals("")){
          Toast toast = Toast.makeText(this, "Campo vazio", Toast.LENGTH_LONG);
          toast.setGravity(Gravity.CENTER, 0,0);
          toast.show();

      }else if(lista.contains("Barbeiro: " + cliente)){
          Toast toast = Toast.makeText(this, "Cliente já cadastrado", Toast.LENGTH_LONG);
          toast.setGravity(Gravity.CENTER,0,0);
          toast.show();
      }else{
          lista.add("Barbeiro: " + cliente);
          Toast toast = Toast.makeText(this, "Cliente adicionado com sucesso", Toast.LENGTH_LONG);
          toast.setGravity(Gravity.CENTER,0,0);
          toast.show();
      }
    }
}







