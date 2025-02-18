package ifmt.cba.vo;

import jakarta.persistence.*;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
@Table(name = "pessoa_juridica")
public class PessoaJuridica extends Pessoa{

    private String razaoSocial;
    private String nomeFantasia;
    private String cnpj;

    // Getter Setter 

    public String getRazaoSocial(){
        return this.razaoSocial;
    }
    public String getNomeFantasia(){
        return this.nomeFantasia;
    }
    public String getCnpj(){
        return this.cnpj;
    }

    public void setRazaoSocial(String razaoSocial){
        this.razaoSocial = razaoSocial;
    }
    public void setNomeFantasia(String nomeFantasia){
        setNome(nomeFantasia);
        this.nomeFantasia = nomeFantasia;
    }
    public void setCnpj(String cnpj){
        this.cnpj = cnpj;
    }
}