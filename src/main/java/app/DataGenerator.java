package app;

import app.database.entity.*;
import app.database.session.HibernateSession;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.Set;

public class DataGenerator {

    public static void generateData(){
        Product product2 = new Product("Lodowka", 100);
        Product product1 = new Product("Pralka", 120);
        Product product3 = new Product("Telewizor", 50);
        Product product4 = new Product("Komputer", 20);
        Supplier supplier1 = new Supplier("Agd_shop", new Address("a", "b", "c"), "ala123");
        Supplier supplier2 = new Supplier("Rtv_shop", new Address("d", "e", "f"), "ala123");
        Customer customer1 = new Customer("Company_1", new Address("d", "e", "f"), 0.2, "ala123");
        Customer customer2 = new Customer("Company_2", new Address("d", "e", "f"), 0.3, "ala123");
        Category category1 = new Category("AGD");
        Category category2 = new Category("RTV");
        TransactionBuy transactionBuy1 = new TransactionBuy(10);
        TransactionBuy transactionBuy2 = new TransactionBuy(20);
        Session session = HibernateSession.getSession();
        Transaction tx = session.beginTransaction();

        session.save(product1);
        session.save(product2);
        session.save(product3);
        session.save(product4);
        session.save(supplier1);
        session.save(supplier2);
        session.save(customer1);
        session.save(customer2);
        session.save(category1);
        session.save(category2);
        session.save(transactionBuy1);
        session.save(transactionBuy2);

        supplier1.addProductToSupplyGroup(product1);
        supplier1.addProductToSupplyGroup(product2);
        product3.setSupplier(supplier2);
        product4.setSupplier(supplier2);
        product1.setCategory(category1);
        product2.setCategory(category1);
        product3.setCategory(category2);
        product4.setCategory(category2);

        product1.addTransactionBuyToSet(transactionBuy1);
        product2.addTransactionBuyToSet(transactionBuy1);
        product3.addTransactionBuyToSet(transactionBuy2);
        product2.addTransactionBuyToSet(transactionBuy2);

        Supplier sup = session.get(Supplier.class, 5);
        Set<Product> products = sup.getProducts();
        for(Product p: products){
            System.out.println(p.getProductName());
        }

        tx.commit();
        session.close();
    }
}
