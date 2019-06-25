/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.io.Serializable;

/**
 * Classe responsável por armazenar data e hora de um período
 * @author joao
 */
public class Periodo implements Serializable {
    private Data dataInicio;
    private Data dataFim;
    private Horario horaInicio;
    private Horario horaFim;

    /**
     * Contrutor padrão, inicializa todas variáveis
     */
    public Periodo() {
        this.dataInicio = new Data();
        this.dataFim = new Data();
        this.horaInicio = new Horario();
        this.horaFim = new Horario();
    }
    
    /**
     * Construtor para intervalo de datas
     * @param dataInicio
     * @param dataFim 
     */
    public Periodo(Data dataInicio, Data dataFim) {
        this.dataInicio = dataInicio;
        this.dataFim = dataFim;
        this.horaInicio = new Horario();
        this.horaFim = new Horario();
    }

    /**
     * Construtor completo
     * @param dataInicio
     * @param dataFim
     * @param horaInicio
     * @param horaFim 
     */
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
    
    /**
     * Gera String formatada com data e hora de Inicio
     * @return 
     */
    public String getInicio(){
        StringBuilder string = new StringBuilder();
        string.append(this.getDataInicio().toString());
        string.append(" ");
        string.append(this.getHoraInicio().toString());
        return string.toString();
    }
    
    /**
     * Gera String formatada com data e hora de Fim
     * @return 
     */
    public String getFim(){
        StringBuilder string = new StringBuilder();
        string.append(this.getDataFim().toString());
        string.append(" ");
        string.append(this.getHoraFim().toString());
        return string.toString();    
    }
}
