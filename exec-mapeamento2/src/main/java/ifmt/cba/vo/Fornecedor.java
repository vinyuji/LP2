package ifmt.cba.vo;

import jakarta.persistence.*;


@Entity
@Table(name = "fornecedor")
public class Fornecedor extends PessoaJuridica {

    // Getters Setters

    public String getRazaoSocialFornecedor(){
        return getRazaoSocial();
    }
    public String getNameSocialFornecedor(){
        return getNameFantasia();
    }
    public int getId(){
        return super.getId();
    }

    public void setRazaoSocialFornecedor(String razaoSocial){
        setRazaoSocial(razaoSocial);
    } 
    public void setNameFantasiaFornecedor(String nameFantasia){
        setNameFantasia(nameFantasia);
    } 
}
