package app.database.dataProvider;

import app.database.dao.ISupplierDAO;
import app.database.dao.impl.SupplierDAO;
import app.database.entity.Supplier;
import app.database.session.HibernateSession;

import java.util.List;

public class SupplierDataProvider {

    private ISupplierDAO supplierDAO = new SupplierDAO(HibernateSession.getSession());

    public List<Supplier> getAllSuppliers(){
        return supplierDAO.findAll();
    }

    public Supplier getSupplierByName(String supplierName){
        return supplierDAO.findByName(supplierName);
    }
}
