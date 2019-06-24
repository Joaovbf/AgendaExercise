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
public class Data implements Serializable {
    private int dia;
    private int mes;
    private int ano;
    
    public Data(int dia,int mes, int ano) throws Exception{
        this.setData(dia, mes, ano);
    }
    
    public Data(int mes, int ano) throws Exception{
        this.setData(1, mes, ano);
    }
     
    public Data(String data) throws Exception{
        this.setData(data);
    }
    
    public Data(){
        this.dia = 1;
        this.mes = 1;
        this.ano = 1900;
    }
    
    public void setData(int dia,int mes, int ano) throws Exception{
        if(!Data.isDataValida(dia,mes,ano)){
            throw new Exception("Data inválida");
        }
        this.dia = dia;
        this.mes = mes;
        this.ano = ano;
    }
    
    public void setData(String data) throws Exception{
        String[] valores = data.split("/");
        //conversão dos dados
        int dia = Integer.parseInt(valores[0]);
        int mes = Integer.parseInt(valores[1]);
        int ano = Integer.parseInt(valores[2]);
        
        //caso de data escrita com somente dois dígitos
        ano = ano < 100 ? ano+2000 : ano;
        
        //validação
        if(!Data.isDataValida(dia,mes,ano)){
            throw new Exception("Data inválida");
        }
        //atribuição
        this.dia = dia;
        this.mes = mes;
        this.ano = ano;
    }

    public Data incrementa(){
        Data data = new Data();
        int dia = this.dia;
        int mes = this.mes;
        int ano = this.ano;
        try{
            if(Data.isDataValida(dia+1, mes, ano)){
                data.setData(dia+1,mes,ano);
                return data;
            }
            
            if(Data.isDataValida(1, mes+1, ano)){
                data.setData(1,mes+1,ano);
                return data;
            }
            
            data.setData(1,1,ano+1);
            return data;
        }
        catch(Exception e){
            
        }
        return data;
    }
    
    public Data incrementa(int quantidade){
        Data data = this.clone();

        for(int i = 0;i<quantidade; i++){
            data = data.incrementa();
        }
        
        return data;
    }
    
    @Override
    public String toString(){
        StringBuilder dataString = new StringBuilder();
        dataString.append(this.dia);
        dataString.append("/");
        dataString.append(this.mes);
        dataString.append("/");
        dataString.append(this.ano);
        return dataString.toString();
    }
    
    /**
     * isDataValida deve ser estático porque não é possível ter uma data inválida instanciada
     * @param dia
     * @param mes
     * @param ano
     * @return 
     */
    public static boolean isDataValida(int dia, int mes, int ano){
        
        if (ano < 1582 || mes>12)
            return false;
        
        if (mes==2){
            if (!Data.isBissexto(ano)){
                if(dia>28)
                    return false;
            }
            else if (dia>29)
                return false;
        }
        
        if ((mes==4 || mes==6 || mes==9 || mes==11) && dia>30)
            return false;
        
        if (dia>31 || (dia<0))
            return false;
        
        return true;
    }
    
    public boolean isTrintaUmDias(){
        return (this.mes==4 || this.mes==6 || this.mes==9 || this.mes==11);
    }
    
    /**
     * isBissexto é um tipo de caso que podemos ter tanto estático quanto dinâmico, por demanda de cada implementação
     * @return 
     */
    public boolean isBissexto(){
        return (ano%4 == 0 && ano%100 != 0) || ano%400 == 0;
    }
    
    public static boolean isBissexto(int ano){
        return (ano%4 == 0 && ano%100 != 0) || ano%400 == 0;
    }
    
    public boolean equals(Data data){
        return this.dia == data.dia && this.mes == data.mes && this.ano == data.ano;
    }
    
    @Override
    public Data clone(){
        Data nova = new Data();
        nova.ano = this.ano;
        nova.dia = this.dia;
        nova.mes = this.mes;
        return nova;
    }
    
    public int compareTo(Data data){
        if(this.ano > data.ano || (this.ano == data.ano && this.mes > data.mes) || (this.ano == data.ano && this.mes == data.mes && this.dia > data.dia) )
            return 1;
        
        if(this.ano < data.ano || (this.ano == data.ano && this.mes < data.mes) || (this.ano == data.ano && this.mes == data.mes && this.dia < data.dia) )
            return 1;
        
        return 0;
    }
}
