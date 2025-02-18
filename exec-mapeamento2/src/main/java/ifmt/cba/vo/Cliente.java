package ifmt.cba.vo;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.*;

@Entity
@Table(name = "cliente")
public class Cliente extends PessoaFisica{

    private float limiteCredito;

    @OneToMany(mappedBy = "cliente", cascade = CascadeType.ALL)
    private List<Venda> vendas = new ArrayList<>();

    // getters setters

    public float getLimiteCredito(){
        return this.limiteCredito;
    }
    public void setlimiteCredito(float limiteCredito){
        this.limiteCredito = limiteCredito;
    }

    public Cliente() {
        this.vendas = new ArrayList<>();
    }

    public List<Venda> getVendas() {
        return vendas;
    }

    
}