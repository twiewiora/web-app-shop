package app;

import app.controllers.ProductController;
import app.controllers.SupplierController;
import app.database.dataProvider.CompanyDataProvider;
import app.database.dataProvider.ProductDataProvider;
import app.controllers.IndexController;
import app.controllers.LoginController;
import app.database.dataProvider.SupplierDataProvider;
import app.utils.Filters;
import app.utils.Path;
import app.utils.ViewUtil;

import static spark.Spark.*;

public class Application {

    // Declare dependencies
    public static CompanyDataProvider companyDataProvider;
    public static ProductDataProvider productDataProvider;
    public static SupplierDataProvider supplierDataProvider;

    public static void main(String[] args) {

        // Instantiate your dependencies
        companyDataProvider = new CompanyDataProvider();
        productDataProvider = new ProductDataProvider();
        supplierDataProvider = new SupplierDataProvider();

        DataGenerator.generateData();

        // Configure Spark
        port(8080);
        staticFiles.location("/public");
        staticFiles.expireTime(600L);

        // Set up before-filters (called before each get/post)
        before("*", Filters.addTrailingSlashes);
        before("*", Filters.handleLocaleChange);

        // Set up routes
        get(Path.Web.INDEX, IndexController.serveIndexPage);
        get(Path.Web.PRODUCTS, ProductController.fetchAllProducts);
        get(Path.Web.PRODUCT, ProductController.fetchOneProduct);
        get(Path.Web.SUPPLIERS, SupplierController.fetchAllSuppliers);
        get(Path.Web.SUPPLIERS, SupplierController.fetchOneSupplier);
        get(Path.Web.LOGIN, LoginController.serveLoginPage);
        post(Path.Web.LOGIN, LoginController.handleLoginPost);
        post(Path.Web.LOGOUT, LoginController.handleLogoutPost);
        get("*", ViewUtil.notFound);

        //Set up after-filters (called after each get/post)
        after("*", Filters.addGzipHeader);

    }

}
