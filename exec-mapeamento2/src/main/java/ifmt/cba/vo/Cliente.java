package ifmt.cba.vo;

import jakarta.persistence.*;

@Entity
public class Cliente extends Pessoa{

    private float limiteCredito;

    // getters setters

    public float getLimiteCredito(){
        return this.limiteCredito;
    }
    public void setlimiteCredito(float limiteCredito){
        this.limiteCredito = limiteCredito;
    }

    
}