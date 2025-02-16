package ifmt.cba.vo;

import jakarta.persistence.*;

import java.sql.Date;
import java.util.List;

@Entity
@Table(name = "venda")
public class Venda {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private Date dataVenda;

    @OneToMany(mappedBy = "venda", cascade = CascadeType.ALL)
    private List<ItemVenda> itensVenda;

    @ManyToOne
    @JoinColumn(name = "vendedor_id")
    private Vendedor vendedor;

    @ManyToOne
    @JoinColumn(name = "cliente_id")
    private Cliente cliente;

    //getters setters

    public Date getDataVenda(){
        return this.dataVenda;
    }
    public void setDataVenda(Date datavenda){
        this.dataVenda = datavenda;
    }

    public List<ItemVenda> getItemVendas() {
        return this.itensVenda;
    }
    public void setVendas(List<ItemVenda> itemVendas) {
        this.itensVenda = itemVendas;
    }

    public Vendedor getVendedor(){
        return this.vendedor;
    }
    public void setVendedor(Vendedor vendedor){
        this.vendedor = vendedor;
    }

    public Cliente getCliente(){
        return this.cliente;
    }
    public void setCliente(Cliente cliente){
        this.cliente = cliente;
    }

}