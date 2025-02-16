package ifmt.cba.vo;

import jakarta.persistence.*;
@Entity
public class ItemVenda {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private int quantidade;
    private float precoVenda;
    private float perDesconto;

    @ManyToOne
    @JoinColumn(name = "venda_id")
    private Venda venda;

    @ManyToOne
    @JoinColumn(name = "produto_id")
    private Produto produtos;


    public int getQuantidade(){
        return this.quantidade;
    }
    public float getPrecoVenda(){
        return this.precoVenda;
    }
    public float getPerDesconto(){
        return this.perDesconto;
    }

    public void setQuantidade(int quantidade){
        this.quantidade = quantidade;
    }
    public void setPrecoVenda(int precoVenda){
        this.precoVenda = precoVenda;
    }
    public void setPerDesconto(int perDesconto){
        this.perDesconto = perDesconto;
    }

}