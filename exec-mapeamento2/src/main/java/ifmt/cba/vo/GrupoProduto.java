package ifmt.cba.vo;

import jakarta.persistence.*;
import java.util.*;

@Entity
@Table(name = "grupo_produto")
public class GrupoProduto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String nome;

    @OneToMany(mappedBy = "grupoProduto", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Produto> produtos = new ArrayList<>(); // Inicializa a lista para evitar NullPointerException

    // Getters e Setters

    public int getId() {
        return this.id;
    }

    public void setId(int id) { // Setter adicionado caso precise atribuir manualmente
        this.id = id;
    }

    public String getNome() {
        return this.nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public List<Produto> getProdutos() {
        return produtos;
    }

    public void setProdutos(List<Produto> produtos) {
        this.produtos = produtos;
    }
}
