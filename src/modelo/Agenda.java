/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.io.Serializable;
import java.util.ArrayList;

/**
 *
 * @author joao
 */
public class Agenda implements Serializable {
    private ArrayList<ItemAgenda> colecaoTarefas;

    public Agenda() {
        this.colecaoTarefas = new ArrayList<>();
    }

    public Agenda(ArrayList<ItemAgenda> colecaoTarefas) {
        this.colecaoTarefas = colecaoTarefas;
    }

    public ArrayList<ItemAgenda> getColecaoTarefas() {
        return colecaoTarefas;
    }

    public void setColecaoTarefas(ArrayList<ItemAgenda> colecaoTarefas) {
        this.colecaoTarefas = colecaoTarefas;
    }
    
    public ItemAgenda[] getItens(){
        return (ItemAgenda[])this.getColecaoTarefas().toArray();
    }
    
    public void inserir(ItemAgenda item){
        int novoId = this.getItens()[this.getItens().length-1].getId() + 1;
        item.setId(novoId);
        this.colecaoTarefas.add(item);
    }
    
    public boolean remover(int id){
        ItemAgenda itemRemocao = null;
        for (ItemAgenda colecaoTarefa : this.getColecaoTarefas()) {
            if (colecaoTarefa.getId() == id) {
                itemRemocao = colecaoTarefa;
                break;
            }
        }
        if (itemRemocao == null) 
            return false;
        
        this.colecaoTarefas.remove(itemRemocao);
        return true;
    }
    
    public boolean remover(ItemAgenda item){
        return this.colecaoTarefas.remove(item);
    }
    
    public boolean gravar(){
        return true;
    }
    
    public boolean ler(){
        return true;
    }
}
