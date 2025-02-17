package ifmt.cba.vo;

import java.util.List;

import jakarta.persistence.*;


@Entity
@Table(name = "fornecedor")
public class Fornecedor extends PessoaJuridica {


    @OneToMany(mappedBy = "fornecedor", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Produto> produtos;

    public List<Produto> getProdutos() {
        return this.produtos;
    }
    public void setProdutos(List<Produto> produtos) {
        this.produtos = produtos;
    }


}
