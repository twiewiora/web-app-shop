package app.utils;

public class Path {

    public static class Web {
        public static final String INDEX = "/app/index/";
        public static final String LOGIN = "/login/";
        public static final String LOGOUT = "/logout/";
        public static final String PRODUCTS = "/books/";
        public static final String PRODUCT = "/books/:productName/";
        public static final String SUPPLIERS = "/suppliers/";
        public static final String SUPPLIER = "/suppliers/:supplierName";

        public static String getINDEX() {
            return INDEX;
        }

        public static String getLOGIN() {
            return LOGIN;
        }

        public static String getLOGOUT() {
            return LOGOUT;
        }

        public static String getProducts() {
            return PRODUCTS;
        }

        public static String getProduct() {
            return PRODUCT;
        }

        public static String getSuppliers() {
            return SUPPLIERS;
        }

        public static String getSupplier() {
            return SUPPLIER;
        }
    }

    public static class Template {
        public final static String INDEX = "/velocity/index/index.vm";
        public final static String LOGIN = "/velocity/login/login.vm";
        public final static String PRODUCTS = "/velocity/product/all.vm";
        public static final String PRODUCT = "/velocity/product/one.vm";
        public static final String SUPPLIERS = "/velocity/supplier/all.vm";
        public static final String SUPPLIER = "/velocity/supplier/one.vm";
        public static final String NOT_FOUND = "/velocity/notFound.vm";
    }

}
