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
public class Lembrete extends ItemAgenda{
    private int tempoAlerta;

    public Lembrete(int tempoAlerta, String titulo, String descricao, Periodo periodo) {
        super(titulo, descricao, periodo);
        this.tempoAlerta = tempoAlerta;
    }

    public Lembrete() {
        super();
        this.tempoAlerta = 0;
    }

    public int getTempoAlerta() {
        return tempoAlerta;
    }

    public void setTempoAlerta(int tempoAlerta) {
        this.tempoAlerta = tempoAlerta;
    }

    @Override
    public String toString() {
        StringBuilder string = new StringBuilder();
        string.append(super.toString());
        string.append(", tempo alerta: ");
        string.append(this.getTempoAlerta());
        return string.toString();
    }
    
    public Lembrete clone(){
        Lembrete novo = new Lembrete(this.getTempoAlerta(),this.getTitulo(),this.getDescricao(),this.getPeriodo());
        return novo;
    }
}
