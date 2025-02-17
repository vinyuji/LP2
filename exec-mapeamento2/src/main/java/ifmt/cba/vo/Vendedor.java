package ifmt.cba.vo;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.*;

@Entity
@Table(name = "vendedor")
public class Vendedor extends PessoaFisica {

    private float perComissao;

    @OneToMany(mappedBy = "vendedor", cascade = CascadeType.ALL)
    private List<Venda> vendas = new ArrayList<>();

    // Getters Setters

    public float getPerComissao () {
        return this.perComissao;
    }
    public void setPerComissao (float perComissao){
        this.perComissao = perComissao;
    }

    public List<Venda> getVenda(){
        if (vendas == null) {
            vendas = new ArrayList<>();
        }
        return vendas;
    }
    public void setVenda( List<Venda> venda){
        this.vendas = venda;
    }
}