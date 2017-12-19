package app.database.dataProvider;

import app.database.dao.ICompanyDAO;
import app.database.dao.impl.CompanyDAO;
import app.database.entity.Company;
import app.database.session.HibernateSession;

import java.util.List;

public class CompanyDataProvider {

    ICompanyDAO companyDAO = new CompanyDAO(HibernateSession.getSession());

    public List<Company> getAllCompanies() {
        return companyDAO.findAll();
    }

    public Company getCompanyByName(String companyName) {
        return companyDAO.findByName(companyName);
    }
}
