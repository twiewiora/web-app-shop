package app.database.entity;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
public class TransactionBuy {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    private Integer quantity;

    @ManyToMany(mappedBy = "transactionBuySet", cascade = CascadeType.PERSIST)
    private Set<Product> productsSet;

    public TransactionBuy(){
    }

    public TransactionBuy(Integer quantity) {
        this.quantity = quantity;
        this.productsSet = new HashSet<>();
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public Set<Product> getProductsSet() {
        return productsSet;
    }

    public void addProductToSet(Product product) {
        this.productsSet.add(product);
    }
}
