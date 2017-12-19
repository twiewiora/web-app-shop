package app.database.dao;

import app.database.entity.Product;

import java.util.List;

public interface IProductDAO {

    List<Product> findAll();

    Product findByName(String productName);
}
