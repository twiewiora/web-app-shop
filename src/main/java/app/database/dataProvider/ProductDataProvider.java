package app.database.dataProvider;

import app.database.dao.IProductDAO;
import app.database.dao.impl.ProductDAO;
import app.database.entity.Product;
import app.database.session.HibernateSession;

import java.util.List;

public class ProductDataProvider {

    IProductDAO productDAO = new ProductDAO(HibernateSession.getSession());

    public List<Product> getAllProducts() {
        return productDAO.findAll();
    }

    public Product getProductByName(String productName) {
        return productDAO.findByName(productName);
    }
}
