package app.controllers;

import app.database.entity.Product;
import app.utils.Path;
import app.utils.ViewUtil;
import spark.Request;
import spark.Response;
import spark.Route;

import java.util.HashMap;

import static app.Application.productDataProvider;
import static app.utils.JsonUtil.dataToJson;
import static app.utils.RequestUtil.*;

public class ProductController {

    public static Route fetchAllProducts = (Request request, Response response) -> {
        LoginController.ensureUserIsLoggedIn(request, response);
        if (clientAcceptsHtml(request)) {
            HashMap<String, Object> model = new HashMap<>();
            model.put("products", productDataProvider.getAllProducts());
            return ViewUtil.render(request, model, Path.Template.PRODUCTS);
        }
        if (clientAcceptsJson(request)) {
            return dataToJson(productDataProvider.getAllProducts());
        }
        return ViewUtil.notAcceptable.handle(request, response);
    };

    public static Route fetchOneProduct = (Request request, Response response) -> {
        LoginController.ensureUserIsLoggedIn(request, response);
        if (clientAcceptsHtml(request)) {
            HashMap<String, Object> model = new HashMap<>();
            Product product = productDataProvider.getProductByName(getParamProductName(request));
            model.put("product", product);
            return ViewUtil.render(request, model, Path.Template.PRODUCT);
        }
        if (clientAcceptsJson(request)) {
            return dataToJson(productDataProvider.getProductByName(getParamProductName(request)));
        }
        return ViewUtil.notAcceptable.handle(request, response);
    };
}
