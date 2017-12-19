package app.controllers;

import app.database.entity.Supplier;
import app.utils.Path;
import app.utils.ViewUtil;
import spark.Request;
import spark.Response;
import spark.Route;

import java.util.HashMap;

import static app.Application.supplierDataProvider;
import static app.utils.JsonUtil.dataToJson;
import static app.utils.RequestUtil.*;

public class SupplierController {

    public static Route fetchAllSuppliers = (Request request, Response response) -> {
        LoginController.ensureUserIsLoggedIn(request, response);
        if (clientAcceptsHtml(request)) {
            HashMap<String, Object> model = new HashMap<>();
            model.put("suppliers", supplierDataProvider.getAllSuppliers());
            return ViewUtil.render(request, model, Path.Template.SUPPLIERS);
        }
        if (clientAcceptsJson(request)) {
            return dataToJson(supplierDataProvider.getAllSuppliers());
        }
        return ViewUtil.notAcceptable.handle(request, response);
    };

    public static Route fetchOneSupplier = (Request request, Response response) -> {
        LoginController.ensureUserIsLoggedIn(request, response);
        if (clientAcceptsHtml(request)) {
            HashMap<String, Object> model = new HashMap<>();
            Supplier supplier = supplierDataProvider.getSupplierByName(getParamSupplierName(request));
            model.put("supplier", supplier);
            return ViewUtil.render(request, model, Path.Template.SUPPLIER);
        }
        if (clientAcceptsJson(request)) {
            return dataToJson(supplierDataProvider.getSupplierByName(getParamSupplierName(request)));
        }
        return ViewUtil.notAcceptable.handle(request, response);
    };
}
