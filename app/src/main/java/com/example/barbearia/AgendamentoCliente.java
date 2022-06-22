package com.example.barbearia;

public class AgendamentoCliente extends AgendamentoClienteActivity {

    String id, nome, telefone, data, barbeiro,  agendaHora,servico;

    AgendamentoCliente(){

    }
    AgendamentoCliente(String id, String nome, String Telefone, String data, String agendaHora, String barbeiro, String servico){
        this.id = id;
        this.nome = nome;
        this.telefone = telefone;
        this.data = data;
        this.agendaHora = agendaHora;
        this.barbeiro = barbeiro;
        this.servico = servico;
    }

    @Override
    public String toString() {
        return barbeiro +"\n"+"Servico: "+servico +"\n"+"Nome: " + nome + "\n"+"Telefone: " + telefone + "\n"+ "Data: "+ data + "\n" +  agendaHora;
    }

    public String getServico() {
        return servico;
    }

    public void setServico(String servico) {
        this.servico = servico;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public String getAgendaHora() {
        return agendaHora;
    }

    public void setAgendaHora(String agendaHora) {
        this.agendaHora = agendaHora;
    }

    public String getBarbeiro() {
        return barbeiro;
    }

    public void setBarbeiro(String barbeiro) {
        this.barbeiro = barbeiro;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }


}
