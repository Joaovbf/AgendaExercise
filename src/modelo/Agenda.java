/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;

/**
 *
 * @author joao
 */
public class Agenda implements Serializable {
    public static final int META_ITEM = 1;
    public static final int EVENTO_ITEM = 2;
    public static final int LEMBRETE_ITEM = 3;
    
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
    
    public void setColecaoTarefas(ItemAgenda[] colecaoTarefas){
        this.colecaoTarefas = new ArrayList<>();
        for (ItemAgenda colecaoTarefa : colecaoTarefas) {
            this.colecaoTarefas.add(colecaoTarefa);
        }
    }
    
    public ItemAgenda[] getItens(){
        return this.getColecaoTarefas().toArray(new ItemAgenda[0]);
    }
    
    public void inserir(ItemAgenda item){
        if (this.getColecaoTarefas().size() > 0){
            int novoId = this.getItens()[this.getItens().length-1].getId() + 1;
            item.setId(novoId);
        }
        else
            item.setId(1);
        this.colecaoTarefas.add(item);
    }
    
    public boolean remover(int id){
        return this.colecaoTarefas.remove(id) != null;
    }
    
    public boolean remover(ItemAgenda item){
        return this.colecaoTarefas.remove(item);
    }
    
    public boolean gravar(){
        try {
            FileOutputStream arquivo = new FileOutputStream(System.getProperty("user.dir") + "/agenda.joao");
            ObjectOutputStream objGravar = new ObjectOutputStream(arquivo);
            //Grava o objeto cliente no arquivo
            objGravar.writeObject(this.getColecaoTarefas());
            objGravar.flush();
            objGravar.close();
            arquivo.flush();
            arquivo.close();
            return true;
        }
        catch(Exception e) {
            e.printStackTrace();
            return false;
        }
    }
    
    public boolean ler(){
        try {
            //Carrega o arquivo
            FileInputStream arquivo = new FileInputStream("agenda.joao");
            ObjectInputStream objLeitura = new ObjectInputStream(arquivo);
            this.setColecaoTarefas((ArrayList<ItemAgenda>)objLeitura.readObject());
            objLeitura.close();
            arquivo.close();
            return true;
        }
        catch(Exception e) {
            e.printStackTrace();
            return false;
        }
    }
}
