/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

/**
 * Classe que representa um item de agenda, do tipo evento
 * @author joao
 */
public class Evento extends ItemAgenda{
    private String localizacao;
    
    /**
     * Contrutor completos dos dados
     * @param localizacao
     * @param titulo
     * @param descricao
     * @param periodo 
     */
    public Evento(String localizacao, String titulo, String descricao, Periodo periodo) {
        super(titulo, descricao, periodo);
        this.localizacao = localizacao;
    }
    
    /**
     * Construtor que inicializa todas as variáveis
     */
    public Evento(){
        super();
        this.localizacao = "";
    }

    public String getLocalizacao() {
        return localizacao;
    }

    public void setLocalizacao(String localizacao) {
        this.localizacao = localizacao;
    }
    
    @Override
    public String toString() {
        StringBuilder string = new StringBuilder();
        string.append(super.toString());
        string.append(", localização: ");
        string.append(this.getLocalizacao());
        return string.toString();
    }
    
    public Evento clone(){
        Evento novo = new Evento(this.getLocalizacao(),this.getTitulo(),this.getDescricao(),this.getPeriodo());
        return novo;
    }
}
