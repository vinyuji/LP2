package ifmt.cba.vo;

import jakarta.persistence.*;

@Entity
public class PessoaJuridica extends Pessoa{

    private String razaoSocial;

    // Getter Setter 

    public String getRazaoSocial(){
        return this.razaoSocial;
    }
    public String getNameFantasia(){
        return this.getName();
    }

    public void setRazaoSocial(String razaoSocial){
        this.razaoSocial = razaoSocial;
    }
    public void setNameFantasia(String nameFantasia){
        setName(nameFantasia);
    }
    
}