package ifmt.cba.vo;

import java.util.List;

import jakarta.persistence.*;

public class ItemVenda {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private int quantidade;
    private float precoVenda;
    private float perDesconto;

    @OneToMany(mappedBy = "itemVenda", cascade = CascadeType.ALL)
    private List<Produto> produtos;
}