package app.database.dao;

import app.database.entity.Supplier;

import java.util.List;

public interface ISupplierDAO {

    List<Supplier> findAll();

    Supplier findByName(String supplierName);
}
