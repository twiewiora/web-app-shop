package app.controllers;

import app.database.dataProvider.CompanyDataProvider;
import app.database.entity.Company;
import org.mindrot.jbcrypt.BCrypt;

public class CompanyController {

    private static CompanyDataProvider companyDataProvider = new CompanyDataProvider();

    // Authenticate the user by hashing the inputted password using the stored salt,
    // then comparing the generated hashed password to the stored hashed password
    public static boolean authenticate(String username, String password) {
        if (username.isEmpty() || password.isEmpty()) {
            return false;
        }
        Company company = companyDataProvider.getCompanyByName(username);
        if (company == null) {
            return false;
        }
        String hashedPassword = BCrypt.hashpw(password, company.getSalt());
        return hashedPassword.equals(company.getHashedPassword());
    }
}
