package app.database.dao.impl;

import app.database.dao.ICompanyDAO;
import app.database.entity.Company;
import org.hibernate.Session;

import javax.persistence.NoResultException;
import javax.persistence.TypedQuery;
import java.util.List;

public class CompanyDAO implements ICompanyDAO {

    Session session;

    public CompanyDAO(Session session) {
        this.session = session;
    }

    public List<Company> findAll(){
        try{
            TypedQuery<Company> query = session.createQuery("from Company", Company.class);
            return query.getResultList();
        } catch(NoResultException e){
            return null;
        }
    }

    public Company findByName(String companyName){
        try{
            TypedQuery<Company> query = session.createQuery("from Company where companyName=:companyName", Company.class);
            query.setParameter("companyName", companyName);
            return query.getSingleResult();
        } catch(NoResultException e){
            return null;
        }
    }
}
