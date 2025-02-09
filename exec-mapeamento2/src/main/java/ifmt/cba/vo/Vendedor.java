package ifmt.cba.vo;

import jakarta.persistence.*;

@Entity
@Table(name = "vendedor")
public class Vendedor extends Pessoa {

    private float perComissao;

    // Getters Setters

    public float getPerComissao () {
        return this.perComissao;
    }
    public void setPerComissao (float perComissao){
        this.perComissao = perComissao;
    }
}