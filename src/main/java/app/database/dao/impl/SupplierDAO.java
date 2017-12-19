package app.database.dao.impl;

import app.database.dao.ISupplierDAO;
import app.database.entity.Supplier;
import org.hibernate.Session;

import javax.persistence.NoResultException;
import javax.persistence.TypedQuery;
import java.util.List;

public class SupplierDAO implements ISupplierDAO {

    Session session;

    public SupplierDAO(Session session) {
        this.session = session;
    }

    @Override
    public List<Supplier> findAll() {
        try{
            TypedQuery<Supplier> query = session.createQuery("from Supplier ", Supplier.class);
            return query.getResultList();
        } catch(NoResultException e){
            return null;
        }
    }

    @Override
    public Supplier findByName(String supplierName) {
        try{
            TypedQuery<Supplier> query = session.createQuery("from Supplier where companyName=:supplierName", Supplier.class);
            query.setParameter("supplierName", supplierName);
            return query.getSingleResult();
        } catch(NoResultException e){
            return null;
        }
    }
}
