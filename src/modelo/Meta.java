/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

/**
 * Classe que representa um item de agenda, do tipo Meta
 * @author joao
 */
public class Meta extends ItemAgenda{
    private int prioridade;

    /**
     * Contrutor completo
     * @param prioridade
     * @param titulo
     * @param descricao
     * @param periodo 
     */
    public Meta(int prioridade, String titulo, String descricao, Periodo periodo) {
        super(titulo, descricao, periodo);
        this.setPrioridade(prioridade);
    }
    
    public Meta(){
        super();
        this.prioridade = 0;
    }

    public int getPrioridade() {
        return prioridade;
    }

    public void setPrioridade(int prioridade) {
        this.prioridade = prioridade;
    }   
    
    @Override
    public String toString() {
        StringBuilder string = new StringBuilder();
        string.append(super.toString());
        string.append(", prioridade: ");
        string.append(this.getPrioridade());
        return string.toString();
    }
    
    public Meta clone(){
        Meta novo = new Meta(this.getPrioridade(),this.getTitulo(),this.getDescricao(),this.getPeriodo());
        return novo;
    }
}
