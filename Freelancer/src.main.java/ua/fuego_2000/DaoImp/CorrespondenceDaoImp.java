package ua.fuego_2000.DaoImp;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import ua.fuego_2000.Dao.CorrespondenceDao;
import ua.fuego_2000.model.Correspondence;

@Repository
public class CorrespondenceDaoImp implements CorrespondenceDao {

	public static final String queryStrAllCor = "from Correspondence";
	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public Correspondence create(Correspondence corresp) {
		Session session = sessionFactory.getCurrentSession();
		session.save(corresp);
		return corresp;
	}

	@Override
	public Correspondence getById(int id) {

		Session session = sessionFactory.getCurrentSession();
		Correspondence corresp = (Correspondence) session.get(Correspondence.class, id);
		return corresp;

	}

	@Override
	public boolean delete(Correspondence corresp) {
		Session session = sessionFactory.getCurrentSession();
		session.delete(corresp);
		return true;
	}

	@Override
	public Correspondence update(Correspondence corresp) {
		Session session = sessionFactory.getCurrentSession();
		session.update(corresp);
		return corresp;
	}

	@Override
	public List<Correspondence> getAll() {
		List<Correspondence> corespList = null;
		Session session = sessionFactory.getCurrentSession();
		Query q = session.createQuery(queryStrAllCor);
		corespList = (List<Correspondence>) q.list();
		return corespList;
	}

}
