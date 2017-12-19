package app.database.entity;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
public class Supplier extends Company {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @OneToMany
    private Set<Product> products;

    public Supplier(){
    }

    public Supplier(String companyName, Address address, String password){
        super(companyName, address, password);
        this.products = new HashSet<>();
    }

    public Set<Product> getProducts() {
        return products;
    }

    public void addProductToSupplyGroup(Product product) {
        this.products.add(product);
        product.setSupplier(this);
    }
}
