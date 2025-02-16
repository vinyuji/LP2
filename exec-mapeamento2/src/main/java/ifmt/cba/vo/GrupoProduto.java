package ifmt.cba.vo;



import jakarta.persistence.*;
import java.util.*;
@Entity
@Table(name = "grupo_produto")
public class GrupoProduto{ 

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String name;

    @OneToMany(mappedBy = "grupoProduto", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Produto> produtos;

    //Getters Setters

    public int getId(){
        return this.id;
    }
    public String getName(){
        return this.name;
    }

    public void setName( String name){
        this.name = name;
    }

    public List<Produto> getProdutos() {
        return produtos;
    }

    public void setProdutos(List<Produto> produtos) {
        this.produtos = produtos;
    }
}