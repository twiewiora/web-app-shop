package app.database.dao.impl;

import app.database.dao.IProductDAO;
import app.database.entity.Product;
import org.hibernate.Session;

import javax.persistence.NoResultException;
import javax.persistence.TypedQuery;
import java.util.List;

public class ProductDAO implements IProductDAO {

    Session session;

    public ProductDAO(Session session) {
        this.session = session;
    }

    @Override
    public List<Product> findAll() {
        try{
            TypedQuery<Product> query = session.createQuery("from Product", Product.class);
            return query.getResultList();
        } catch(NoResultException e){
            return null;
        }
    }

    @Override
    public Product findByName(String productName) {
        try{
            TypedQuery<Product> query = session.createQuery("from Product where productName=:productName", Product.class);
            query.setParameter("productName", productName);
            return query.getSingleResult();
        } catch(NoResultException e){
            return null;
        }
    }
}
