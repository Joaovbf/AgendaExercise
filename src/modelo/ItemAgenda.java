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
public abstract class ItemAgenda {
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
        string.append("titulo: ");
        string.append(titulo);
        string.append(", descricao: ");
        string.append(descricao);
        string.append(", periodo: ");
        string.append(periodo);
        return string.toString();
    }
}
