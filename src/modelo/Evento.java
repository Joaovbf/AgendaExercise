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
public class Evento extends ItemAgenda{
    private String localizacao;

    public Evento(String localizacao, String titulo, String descricao, Periodo periodo) {
        super(titulo, descricao, periodo);
        this.localizacao = localizacao;
    }
    
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
}
