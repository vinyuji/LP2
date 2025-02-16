package ifmt.cba.vo;

import java.util.List;

import jakarta.persistence.*;

@Entity
@Table(name = "cliente")
public class Cliente extends PessoaFisica{

    private float limiteCredito;

    @OneToMany(mappedBy = "cliente", cascade = CascadeType.ALL)
    private List<Venda> vendas;

    // getters setters

    public float getLimiteCredito(){
        return this.limiteCredito;
    }
    public void setlimiteCredito(float limiteCredito){
        this.limiteCredito = limiteCredito;
    }

    public List<Venda> getVendas() {
        return this.vendas;
    }
    public void setVendas(List<Venda> vendas) {
        this.vendas = vendas;
    }

    
}