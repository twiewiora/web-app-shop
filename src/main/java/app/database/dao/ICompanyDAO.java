package app.database.dao;

import app.database.entity.Company;

import java.util.List;

public interface ICompanyDAO {

    List<Company> findAll();

    Company findByName(String companyName);
}
