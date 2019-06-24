/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bll;

import java.util.ArrayList;
import java.util.Collections;
import javax.swing.*;
import modelo.*;

/**
 *
 * @author joao
 */
public abstract class AgendaBL {
    
    public static Agenda carregarAgenda(){
        Agenda agenda = new Agenda();
        agenda.ler();
        return agenda;
    }
    
    public static void cadastrarEvento(Agenda agenda){
        Evento evento = new Evento();
        
        AgendaBL.cadastrarItem(evento, agenda,"Cadastrar Evento");
    }
    
    public static void cadastrarMeta(Agenda agenda){
        Meta meta = new Meta();
        
        AgendaBL.cadastrarItem(meta, agenda,"Cadastrar Meta");
    }
    
    public static void cadastrarLembrete(Agenda agenda){
        Lembrete lembrete = new Lembrete();
        
        AgendaBL.cadastrarItem(lembrete, agenda,"Cadastrar Lembrete");
    }
    
    public static void cadastrarItem(ItemAgenda item, Agenda agenda, String titulo){
        int resposta = AgendaBL.formItem(item, titulo);
        if (resposta == JOptionPane.OK_OPTION) {
            agenda.inserir(item);
            agenda.gravar();
        }
    }
    
    public static void alterarItem(ItemAgenda item, Agenda agenda, String titulo){
        //garantia para caso não seja possível alterar
        ItemAgenda backup = item.clone();
        System.out.print(backup);
        agenda.remover(item);
        
        int resposta = AgendaBL.formItem(item, titulo);
        if (resposta == JOptionPane.OK_OPTION) 
            agenda.inserir(item);
        else
            agenda.inserir(backup);
        
        agenda.gravar();
    }
    
    public static ItemAgenda[] filtrarPeriodo(Agenda agenda){
        ItemAgenda[] itensRetorno = new ItemAgenda[0];
        
        JFormattedTextField dataInicio = new JFormattedTextField();
        dataInicio.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.DateFormatter(java.text.DateFormat.getDateInstance(java.text.DateFormat.SHORT))));
        
        JFormattedTextField dataFim = new JFormattedTextField();
        dataFim.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.DateFormatter(java.text.DateFormat.getDateInstance(java.text.DateFormat.SHORT))));
        
        JComponent[] inputs = new JComponent[] {
            new JLabel("Para retirar o filtro envie vazio"),
            new JLabel("Data de Inicio"),
            dataInicio,
            new JLabel("Data de Fim"),
            dataFim
        };
        int resposta = JOptionPane.showConfirmDialog(null, inputs, "Escolher Intervalo", JOptionPane.DEFAULT_OPTION);        
        if (resposta == JOptionPane.OK_OPTION) {
            Periodo periodo = new Periodo();
            try{
                periodo.getDataInicio().setData(dataInicio.getText());
                periodo.getDataFim().setData(dataFim.getText());

                itensRetorno = agenda.getItens(periodo);
            }
            catch(Exception e){
                e.printStackTrace();
                if (dataInicio.getText().equals("") && dataFim.getText().equals("")) {
                    itensRetorno = agenda.getItens();
                }
                else{
                    JOptionPane.showMessageDialog(null, "Data ou Hora inválida");
                }
            }
        }
        
        return itensRetorno;
    }
    
    public static ItemAgenda[] ordenarMetas(Agenda agenda){
        ArrayList<Meta> itens = new ArrayList<>();
        
        for (ItemAgenda item : agenda.getColecaoTarefas()) {
            if (item.getClass() == Meta.class) {
                itens.add((Meta)item);
            }
        }
        
        Collections.sort(itens,(a, b) -> {
            return a.getPrioridade() == b.getPrioridade() ? 0 : 
                    (a.getPrioridade() > b.getPrioridade() ? 1 : -1 );
        });
        
        return itens.toArray(new ItemAgenda[0]);
    }
    
    public static ItemAgenda[] ordenarLembretes(Agenda agenda){
        ArrayList<Lembrete> itens = new ArrayList<>();
        
        for (ItemAgenda item : agenda.getColecaoTarefas()) {
            if (item.getClass() == Lembrete.class) {
                itens.add((Lembrete)item);
            }
        }
        
        Collections.sort(itens,(a, b) -> {
            return a.getTempoAlerta() == b.getTempoAlerta() ? 0 : 
                    (a.getTempoAlerta() > b.getTempoAlerta() ? 1 : -1 );
        });
        
        return itens.toArray(new ItemAgenda[0]);
    }
    
    public static ItemAgenda[] ordenarEventos(Agenda agenda){
        ArrayList<Evento> itens = new ArrayList<>();
        
        for (ItemAgenda item : agenda.getColecaoTarefas()) {
            if (item.getClass() == Evento.class) {
                itens.add((Evento)item);
            }
        }
        
        Collections.sort(itens,(a, b) -> {
            return a.getLocalizacao().compareTo(b.getLocalizacao());
        });
        
        return itens.toArray(new ItemAgenda[0]);
    }
    
    private static int formItem(ItemAgenda item, String tituloForm){
        JTextField titulo = new JTextField(item.getTitulo());
        titulo.setText(item.getTitulo());
        
        JTextField descricao = new JTextField(item.getDescricao());
        descricao.setText(item.getDescricao());
        
        JFormattedTextField horaInicio = new JFormattedTextField();
        horaInicio.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.DateFormatter(java.text.DateFormat.getTimeInstance())));
        horaInicio.setText(item.getPeriodo().getHoraInicio().toString());
        
        JFormattedTextField horaFim = new JFormattedTextField();
        horaFim.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.DateFormatter(java.text.DateFormat.getTimeInstance())));
        horaFim.setText(item.getPeriodo().getHoraFim().toString());
        
        JFormattedTextField dataInicio = new JFormattedTextField();
        dataInicio.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.DateFormatter(java.text.DateFormat.getDateInstance(java.text.DateFormat.SHORT))));
        dataInicio.setText(item.getPeriodo().getDataInicio().toString());
        
        JFormattedTextField dataFim = new JFormattedTextField();
        dataFim.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.DateFormatter(java.text.DateFormat.getDateInstance(java.text.DateFormat.SHORT))));
        dataFim.setText(item.getPeriodo().getDataFim().toString());
        
        JTextField localizacao = new JTextField();
        JTextField prioridade = new JTextField();
        JTextField alerta = new JTextField();
        JComponent[] inputs = null;
        if (item.getClass() == Evento.class) {
            localizacao.setText(((Evento)item).getLocalizacao());
            inputs = new JComponent[] {
                new JLabel("Título"),
                titulo,
                new JLabel("Descrição"),
                descricao,
                new JLabel("Data de Inicio"),
                dataInicio,
                new JLabel("Data de Fim"),
                dataFim,
                new JLabel("Horario de Inicio"),
                horaInicio,
                new JLabel("Horario de Fim"),
                horaFim,
                new JLabel("Localização"),
                localizacao
            };
        }
        else if (item.getClass() == Lembrete.class) {
            alerta.setText(((Lembrete)item).getTempoAlerta()+"");
            inputs = new JComponent[] {
                new JLabel("Título"),
                titulo,
                new JLabel("Descrição"),
                descricao,
                new JLabel("Data de Inicio"),
                dataInicio,
                new JLabel("Data de Fim"),
                dataFim,
                new JLabel("Horario de Inicio"),
                horaInicio,
                new JLabel("Horario de Fim"),
                horaFim,
                new JLabel("Alerta"),
                alerta
            };
        }
        else if (item.getClass() == Meta.class){
            prioridade.setText(((Meta)item).getPrioridade()+"");
            inputs = new JComponent[] {
                new JLabel("Título"),
                titulo,
                new JLabel("Descrição"),
                descricao,
                new JLabel("Data de Inicio"),
                dataInicio,
                new JLabel("Data de Fim"),
                dataFim,
                new JLabel("Horario de Inicio"),
                horaInicio,
                new JLabel("Horario de Fim"),
                horaFim,
                new JLabel("Prioridade"),
                prioridade
            };
        }
        
        int retorno = JOptionPane.showConfirmDialog(null, inputs, tituloForm, JOptionPane.OK_CANCEL_OPTION ,JOptionPane.INFORMATION_MESSAGE);        
        
        //atribui todos dados recebidos no item enviado no parâmetro
        if (retorno == JOptionPane.OK_OPTION) {
            item.setTitulo(titulo.getText());
            item.setDescricao(descricao.getText());
            Periodo periodo = new Periodo();
            try{
                periodo.getDataInicio().setData(dataInicio.getText());
                periodo.getDataFim().setData(dataFim.getText());
                periodo.getHoraInicio().setHorario(horaInicio.getText());
                periodo.getHoraFim().setHorario(horaFim.getText());
            }
            catch(Exception e){
                JOptionPane.showMessageDialog(null, "Data ou Hora inválida");
                retorno = JOptionPane.CANCEL_OPTION;
            }
            item.setPeriodo(periodo);
            if (item.getClass() == Evento.class) {
                ((Evento)item).setLocalizacao(localizacao.getText());
            }
            else if (item.getClass() == Lembrete.class) {
                ((Lembrete)item).setTempoAlerta(Integer.parseInt(alerta.getText()));
            }
            else if (item.getClass() == Meta.class) {
                ((Meta)item).setPrioridade(Integer.parseInt(prioridade.getText()));
            }
        }
        return retorno;
    }
}
