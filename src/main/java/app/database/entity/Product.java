package app.database.entity;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    private String productName;

    private Integer unitsOnStock;

    @ManyToOne
    private Supplier supplier;

    @ManyToOne
    private Category category;

    @ManyToMany(cascade = CascadeType.PERSIST)
    private Set<TransactionBuy> transactionBuySet;

    public Product(){
    }

    public Product(String productName, Integer unitsOnStock){
        this.productName = productName;
        this.unitsOnStock = unitsOnStock;
        this.transactionBuySet = new HashSet<>();
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public Integer getUnitsOnStock() {
        return unitsOnStock;
    }

    public void setUnitsOnStock(Integer unitsOnStock) {
        this.unitsOnStock = unitsOnStock;
    }

    public Supplier getSupplier() {
        return supplier;
    }

    public void setSupplier(Supplier supplier) {
        this.supplier = supplier;
        this.supplier.getProducts().add(this);
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
        this.category.getProducts().add(this);
    }

    public Set<TransactionBuy> getTransactionBuySet() {
        return transactionBuySet;
    }

    public void addTransactionBuyToSet(TransactionBuy transactionBuy){
        this.transactionBuySet.add(transactionBuy);
    }
}
