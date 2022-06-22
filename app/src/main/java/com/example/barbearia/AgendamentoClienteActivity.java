package com.example.barbearia;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.Paint;
import android.os.Build;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.Gravity;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TableLayout;
import android.widget.TableRow;
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
    Button et_Data;
    EditText etNome;
    EditText etTelefone;
    ListView lvClientesAgendados;
    Button btn_Confirmar;
    TableLayout tabelaHorarios;
    TextView et_Result;
    TextView et_01;
    TextView et_02;
    TextView et_03;
    TextView et_04;
    TextView et_05;
    TextView et_06;
    TextView et_07;
    TextView et_08;
    TextView et_09;
    TextView et_10;
    TextView et_11;
    TextView et_12;
    TextView et_13;
    TextView et_14;
    TextView et_15;
    TextView et_16;
    TextView et_17;
    TextView et_18;
    TextView et_19;
    TextView et_20;
    TextView et_21;
    TextView et_22;
    TextView et_23;
    TextView et_MudaHora;
    private List<String> lista = new ArrayList<>();
    private ArrayAdapter<String> adapter;
    String ultimoCaracter = "";

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
        et_Data = findViewById(R.id.et_Data);
        btn_Confirmar = findViewById(R.id.btn_Confirmar);
        etNome = findViewById(R.id.edNome);
        etTelefone = findViewById(R.id.edTelefone);
        tabelaHorarios = findViewById(R.id.tabelaHorarios);
        lvClientesAgendados = findViewById(R.id.lvClientesAgendados);
        et_01 = findViewById(R.id.et_01);
        et_02 = findViewById(R.id.et_02);
        et_03 = findViewById(R.id.et_03);
        et_04 = findViewById(R.id.et_04);
        et_05 = findViewById(R.id.et_05);
        et_06 = findViewById(R.id.et_06);
        et_07 = findViewById(R.id.et_07);
        et_08 = findViewById(R.id.et_08);
        et_09 = findViewById(R.id.et_09);
        et_10 = findViewById(R.id.et_10);
        et_11 = findViewById(R.id.et_11);
        et_12 = findViewById(R.id.et_12);
        et_13 = findViewById(R.id.et_13);
        et_14 = findViewById(R.id.et_14);
        et_15 = findViewById(R.id.et_15);
        et_16 = findViewById(R.id.et_16);
        et_17 = findViewById(R.id.et_17);
        et_18 = findViewById(R.id.et_18);
        et_19 = findViewById(R.id.et_19);
        et_20 = findViewById(R.id.et_20);
        et_21 = findViewById(R.id.et_21);
        et_22 = findViewById(R.id.et_22);
        et_23 = findViewById(R.id.et_23);
        et_Result = findViewById(R.id.et_Result);
        et_MudaHora = findViewById(R.id.et_MudaHora);

        etTelefone.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
                Integer digitos = etTelefone.getText().toString().length();
                if(digitos > 1){
                    ultimoCaracter = etTelefone.getText().toString().substring(digitos - 1);
                }
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                Integer digitos = etTelefone.getText().toString().length();
                if(digitos == 2){
                    if(!ultimoCaracter.equals(" ")){
                        etTelefone.append(" ");
                    }else{
                        etTelefone.getText().delete(digitos - 1, digitos);
                    }
                }else if(digitos == 8){
                    if(!ultimoCaracter.equals("-")){
                        etTelefone.append("-");
                    }else{
                        etTelefone.getText().delete(digitos - 1, digitos);
                    }
                }
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });

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
                tabelaHorarios.setVisibility(View.VISIBLE);
                et_01.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        et_Result.setText("Horário: " + et_01.getText().toString());
                        tabelaHorarios.setVisibility(View.GONE);
                        et_MudaHora.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                tabelaHorarios.setVisibility(View.VISIBLE);
                            }
                        });
                    }
                });
                et_02.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        et_Result.setText("Horário: " + et_02.getText().toString());
                        tabelaHorarios.setVisibility(View.GONE);
                        et_MudaHora.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                tabelaHorarios.setVisibility(View.VISIBLE);
                            }
                        });
                    }
                });
                et_03.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        et_Result.setText("Horário: " + et_03.getText().toString());
                        tabelaHorarios.setVisibility(View.GONE);
                        et_MudaHora.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                tabelaHorarios.setVisibility(View.VISIBLE);
                            }
                        });
                    }
                });
                et_04.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        et_Result.setText("Horário: " + et_04.getText().toString());
                        tabelaHorarios.setVisibility(View.GONE);
                        et_MudaHora.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                tabelaHorarios.setVisibility(View.VISIBLE);
                            }
                        });
                    }
                });
                et_05.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        et_Result.setText("Horário: " + et_05.getText().toString());
                        tabelaHorarios.setVisibility(View.GONE);
                        et_MudaHora.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                tabelaHorarios.setVisibility(View.VISIBLE);
                            }
                        });
                    }
                });
                et_06.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        et_Result.setText("Horário: " + et_06.getText().toString());
                        tabelaHorarios.setVisibility(View.GONE);
                        et_MudaHora.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                tabelaHorarios.setVisibility(View.VISIBLE);
                            }
                        });
                    }
                });
                et_07.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        et_Result.setText("Horário: " + et_07.getText().toString());
                        tabelaHorarios.setVisibility(View.GONE);
                        et_MudaHora.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                tabelaHorarios.setVisibility(View.VISIBLE);
                            }
                        });
                    }
                });
                et_08.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        et_Result.setText("Horário: " + et_08.getText().toString());
                        tabelaHorarios.setVisibility(View.GONE);
                        et_MudaHora.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                tabelaHorarios.setVisibility(View.VISIBLE);
                            }
                        });
                    }
                });
                et_09.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        et_Result.setText("Horário: " + et_09.getText().toString());
                        tabelaHorarios.setVisibility(View.GONE);
                        et_MudaHora.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                tabelaHorarios.setVisibility(View.VISIBLE);
                            }
                        });
                    }
                });
                et_10.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        et_Result.setText("Horário: " + et_10.getText().toString());
                        tabelaHorarios.setVisibility(View.GONE);
                        et_MudaHora.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                tabelaHorarios.setVisibility(View.VISIBLE);
                            }
                        });
                    }
                });
                et_11.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        et_Result.setText("Horário: " + et_11.getText().toString());
                        tabelaHorarios.setVisibility(View.GONE);
                        et_MudaHora.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                tabelaHorarios.setVisibility(View.VISIBLE);
                            }
                        });
                    }
                });
                et_12.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        et_Result.setText("Horário: " + et_12.getText().toString());
                        tabelaHorarios.setVisibility(View.GONE);
                        et_MudaHora.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                tabelaHorarios.setVisibility(View.VISIBLE);
                            }
                        });
                    }
                });
                et_13.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        et_Result.setText("Horário: " + et_13.getText().toString());
                        tabelaHorarios.setVisibility(View.GONE);
                        et_MudaHora.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                tabelaHorarios.setVisibility(View.VISIBLE);
                            }
                        });
                    }
                });
                et_14.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        et_Result.setText("Horário: " + et_14.getText().toString());
                        tabelaHorarios.setVisibility(View.GONE);
                        et_MudaHora.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                tabelaHorarios.setVisibility(View.VISIBLE);
                            }
                        });
                    }
                });
                et_15.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        et_Result.setText("Horário: " + et_15.getText().toString());
                        tabelaHorarios.setVisibility(View.GONE);
                        et_MudaHora.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                tabelaHorarios.setVisibility(View.VISIBLE);
                            }
                        });
                    }
                });
                et_16.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        et_Result.setText("Horário: " + et_16.getText().toString());
                        tabelaHorarios.setVisibility(View.GONE);
                        et_MudaHora.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                tabelaHorarios.setVisibility(View.VISIBLE);
                            }
                        });
                    }
                });
                et_17.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        et_Result.setText("Horário: " + et_17.getText().toString());
                        tabelaHorarios.setVisibility(View.GONE);
                        et_MudaHora.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                tabelaHorarios.setVisibility(View.VISIBLE);
                            }
                        });
                    }
                });
                et_18.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        et_Result.setText("Horário: " + et_18.getText().toString());
                        tabelaHorarios.setVisibility(View.GONE);
                        et_MudaHora.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                tabelaHorarios.setVisibility(View.VISIBLE);
                            }
                        });
                    }
                });
                et_19.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        et_Result.setText("Horário: " + et_19.getText().toString());
                        tabelaHorarios.setVisibility(View.GONE);
                        et_MudaHora.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                tabelaHorarios.setVisibility(View.VISIBLE);
                            }
                        });
                    }
                });
                et_20.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        et_Result.setText("Horário: " + et_20.getText().toString());
                        tabelaHorarios.setVisibility(View.GONE);
                        et_MudaHora.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                tabelaHorarios.setVisibility(View.VISIBLE);
                            }
                        });
                    }
                });
                et_21.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        et_Result.setText("Horáro: " + et_21.getText().toString());
                        tabelaHorarios.setVisibility(View.GONE);
                        et_MudaHora.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                tabelaHorarios.setVisibility(View.VISIBLE);
                            }
                        });
                    }
                });
                et_22.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        et_Result.setText("Horário: " + et_22.getText().toString());
                        tabelaHorarios.setVisibility(View.GONE);
                        et_MudaHora.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                tabelaHorarios.setVisibility(View.VISIBLE);
                            }
                        });
                    }
                });
                et_23.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        et_Result.setText("Horário: " + et_23.getText().toString());
                        tabelaHorarios.setVisibility(View.GONE);
                        et_MudaHora.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                tabelaHorarios.setVisibility(View.VISIBLE);
                            }
                        });
                    }
                });



                AgendamentoClienteActivity.this.et_Data.setText(fecha);
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
                //etHora.setText(hourOfDay + ":" + minute);
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
        cliente.setData(et_Data.getText().toString());
        cliente.setAgendaHora(et_01.getText().toString());
        cliente.setAgendaHora(et_02.getText().toString());
        cliente.setAgendaHora(et_03.getText().toString());
        cliente.setAgendaHora(et_04.getText().toString());
        cliente.setAgendaHora(et_05.getText().toString());
        cliente.setAgendaHora(et_06.getText().toString());
        cliente.setAgendaHora(et_07.getText().toString());
        cliente.setAgendaHora(et_08.getText().toString());
        cliente.setAgendaHora(et_09.getText().toString());
        cliente.setAgendaHora(et_10.getText().toString());
        cliente.setAgendaHora(et_11.getText().toString());
        cliente.setAgendaHora(et_12.getText().toString());
        cliente.setAgendaHora(et_13.getText().toString());
        cliente.setAgendaHora(et_14.getText().toString());
        cliente.setAgendaHora(et_15.getText().toString());
        cliente.setAgendaHora(et_16.getText().toString());
        cliente.setAgendaHora(et_17.getText().toString());
        cliente.setAgendaHora(et_18.getText().toString());
        cliente.setAgendaHora(et_19.getText().toString());
        cliente.setAgendaHora(et_20.getText().toString());
        cliente.setAgendaHora(et_21.getText().toString());
        cliente.setAgendaHora(et_22.getText().toString());
        cliente.setAgendaHora(et_23.getText().toString());

      if(etNome.getText().toString().equals("") || etTelefone.getText().toString().equals("") || et_Data.getText().toString().equals("")){
          Toast toast = Toast.makeText(this, "Campo vazio", Toast.LENGTH_LONG);
          toast.setGravity(Gravity.CENTER, 0,0);
          toast.show();

      }else if(lista.contains("Barbeiro: " + cliente)){
          Toast toast = Toast.makeText(this, "Cliente já cadastrado", Toast.LENGTH_LONG);
          toast.setGravity(Gravity.CENTER, 0, 0);
          toast.show();
      }else{
          lista.add("Barbeiro: " + cliente);
              Toast toast = Toast.makeText(this, "Cliente adicionado com sucesso", Toast.LENGTH_LONG);
              toast.setGravity(Gravity.CENTER,0,0);
              toast.show();
          }

      }
    }








