package ifmt.cba.vo;

import java.util.List;

import jakarta.persistence.*;

@Entity
@Table(name = "produto")
public class Produto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String name;
    private double precoVenda;

    @ManyToOne
    @JoinColumn(name = "grupo_id", nullable = false)
    private GrupoProduto grupoProduto;

    @OneToMany(mappedBy = "produto")
    private List<Fornecedor> fornecedores;

    @ManyToOne
    @JoinColumn(name = "item_venda_id")
    private ItemVenda itemVenda;


    // Getters e Setters

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String nome) {
        this.name = nome;
    }

    public double getPreco() {
        return precoVenda;
    }

    public void setPreco(double preco) {
        this.precoVenda = preco;
    }

    public GrupoProduto getGrupoProduto() {
        return grupoProduto;
    }

    public void setGrupoProduto(GrupoProduto grupoProduto) {
        this.grupoProduto = grupoProduto;
    }
}

