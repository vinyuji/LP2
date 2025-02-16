package ifmt.cba.vo;

import jakarta.persistence.*;

@Entity
public class PessoaFisica extends Pessoa {

    private String cpf;
    private String rg;

    // Getters Setters

    public String getCpf(){
        return this.cpf;
    }
    public String getRg(){
        return this.rg;
    }

    public void setCpf(String cpf){
        this.cpf = cpf;
    }
    public void setrg(String rg){
        this.rg = rg;
    }

    
}