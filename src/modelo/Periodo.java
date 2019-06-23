/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

/**
 *
 * @author joao
 */
public class Periodo {
    private Data dataInicio;
    private Data dataFim;
    private Horario horaInicio;
    private Horario horaFim;

    public Periodo(Data dataInicio, Data dataFim) {
        this.dataInicio = dataInicio;
        this.dataFim = dataFim;
        this.horaInicio = new Horario();
        this.horaFim = new Horario();
    }

    public Periodo(Data dataInicio, Data dataFim, Horario horaInicio, Horario horaFim) {
        this.dataInicio = dataInicio;
        this.dataFim = dataFim;
        this.horaInicio = horaInicio;
        this.horaFim = horaFim;
    }

    public Data getDataInicio() {
        return dataInicio;
    }

    public void setDataInicio(Data dataInicio) {
        this.dataInicio = dataInicio;
    }

    public Data getDataFim() {
        return dataFim;
    }

    public void setDataFim(Data dataFim) {
        this.dataFim = dataFim;
    }

    public Horario getHoraInicio() {
        return horaInicio;
    }

    public void setHoraInicio(Horario horaInicio) {
        this.horaInicio = horaInicio;
    }

    public Horario getHoraFim() {
        return horaFim;
    }

    public void setHoraFim(Horario horaFim) {
        this.horaFim = horaFim;
    }
    
    public String getInicio(){
        StringBuilder string = new StringBuilder();
        string.append(this.getDataInicio().toString());
        string.append(this.getHoraInicio().toString());
        return string.toString();
    }
    
    public String getFim(){
        StringBuilder string = new StringBuilder();
        string.append(this.getDataFim().toString());
        string.append(this.getHoraFim().toString());
        return string.toString();    
    }
}
