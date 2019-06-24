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
public abstract class ItemAgenda implements Serializable {
    private int id = 0;
    private String titulo;
    private String descricao;
    private Periodo periodo;

    public ItemAgenda(String titulo, String descricao, Periodo periodo) {
        this.titulo = titulo;
        this.descricao = descricao;
        this.periodo = periodo;
    }
    
    public ItemAgenda() {
        this.titulo = "";
        this.descricao = "";
        this.periodo = new Periodo();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Periodo getPeriodo() {
        return periodo;
    }

    public void setPeriodo(Periodo periodo) {
        this.periodo = periodo;
    }    
    
    public boolean hasConflito(ItemAgenda item){
        //variaveis apenas para evitar linha longa
        Periodo perThis = this.getPeriodo();
        Periodo perItem = item.getPeriodo();
        
        //verifica intersecção entre datas
        boolean conflitoDias = !(perThis.getDataInicio().compareTo(perItem.getDataFim()) == 1 || perThis.getDataFim().compareTo(perItem.getDataInicio()) == -1);
        
        if (conflitoDias) {
            /*se os dois eventos um começa e outro termina no mesmo dia
            verificamos se não há intersecção de horários*/
            if (perThis.getDataFim().compareTo(perItem.getDataInicio()) == 0)
                return perThis.getHoraFim().compareTo(perItem.getHoraInicio()) != -1;
            
            if (perThis.getDataInicio().compareTo(perItem.getDataFim()) == 0)
                return perItem.getHoraFim().compareTo(perThis.getHoraInicio()) != -1;
        }
        
        return conflitoDias;
    }

    @Override
    public String toString() {
        StringBuilder string = new StringBuilder();
        string.append("\n Título: ");
        string.append(this.getTitulo());
        string.append("\n Início: ");
        string.append(this.getPeriodo().getInicio());
        string.append("\n Fim: ");
        string.append(this.getPeriodo().getFim());
        return string.toString();
    }
    
    @Override
    public abstract ItemAgenda clone();
}
