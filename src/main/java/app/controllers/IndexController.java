package app.controllers;

import app.utils.Path;
import app.utils.ViewUtil;
import spark.Request;
import spark.Response;
import spark.Route;

import java.util.HashMap;
import java.util.Map;

import static app.Application.companyDataProvider;

public class IndexController {
    public static Route serveIndexPage = (Request request, Response response) -> {
        Map<String, Object> model = new HashMap<>();
        model.put("companies", companyDataProvider.getAllCompanies());
        return ViewUtil.render(request, model, Path.Template.INDEX);
    };
}
