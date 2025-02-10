package ifmt.cba.vo;

import jakarta.persistence.*;

@Entity
@Table(name = "cliente")
public class Cliente extends PessoaFisica{

    private float limiteCredito;

    // getters setters

    public float getLimiteCredito(){
        return this.limiteCredito;
    }
    public void setlimiteCredito(float limiteCredito){
        this.limiteCredito = limiteCredito;
    }

    
}