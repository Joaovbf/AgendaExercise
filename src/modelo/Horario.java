/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.io.Serializable;

/**
 *
 * @author joao
 */
public class Horario implements Serializable {
    public static final int HORAS_MAXIMO = 23;
    public static final int MINUTOS_MAXIMO = 59;
    
    private int horas;
    private int minutos;
    
    public Horario(){
        this.horas = 0;
        this.minutos = 0;
    }
    
    public Horario(Horario horario){
        this.horas = horario.horas;
        this.minutos = horario.minutos;
    }
    
    public Horario(int horas) throws Exception{
        this.setHoras(horas);
        this.minutos = 0;
    }
    
    public Horario(int horas, int minutos) throws Exception{
        this.setHoras(horas);
        this.setMinutos(minutos);
    }
    
    public void setHorario(String horario) throws Exception{
        String[] dados = horario.split(":");
        int hora = Integer.parseInt(dados[0]);
        int minuto = Integer.parseInt(dados[1]);
        this.setHoras(hora);
        this.setMinutos(minuto);
    }
    
    //métodos de acesso para horas
    public void setHoras(int horas) throws Exception{
        if(Horario.isHorarioValido(horas,0))
            this.horas = horas;
        else
            throw new Exception("Valor da Hora é Inválida");
    }
    
    public int getHoras(){
        return this.horas;
    }
    
    //métodos de acesso para minutos
    public void setMinutos(int minutos) throws Exception{
        if(Horario.isHorarioValido(0,minutos))
            this.minutos = minutos;
        else
            throw new Exception("Valor dos minutos é Inválido");
    }
    
    public int getMinutos(){
        return this.minutos;
    }
    
    private static boolean isHorarioValido(int hora, int minuto){
        return (hora >= 0 && hora <= Horario.HORAS_MAXIMO) && (minuto >= 0 && minuto <= Horario.MINUTOS_MAXIMO);
    }
    
    /**
     * 
     * @param horario Objeto da classe horario a ser comparada
     * @return compara se a hora que invoca o método é maior ou menor que a hora dada
     */ 
    public int compareTo(Horario horario){
        if(this.horas > horario.horas || (this.horas == horario.horas && this.minutos > horario.minutos))
            return 1;
        
        if(this.horas < horario.horas || (this.horas == horario.horas && this.minutos < horario.minutos))
            return -1;
        
        return 0;
    }
    
    public boolean equals(Horario horario){
        return this.horas == horario.horas && this.minutos == horario.minutos;
    }
    
    @Override
    public String toString(){
        StringBuilder hora = new StringBuilder();
        hora.append(this.horas);
        hora.append(this.minutos);
        return hora.toString();
    }
}
