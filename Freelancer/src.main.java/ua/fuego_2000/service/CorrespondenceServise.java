package ua.fuego_2000.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import ua.fuego_2000.Dao.CorrespondenceDao;
import ua.fuego_2000.model.Correspondence;

@Service
public class CorrespondenceServise {
	@Autowired
	private CorrespondenceDao correspondenceDao;

	@Transactional
	public Correspondence create(Correspondence correspondence) {
		correspondenceDao.create(correspondence);
		return correspondence;
	}

	@Transactional(readOnly = true)
	public List<Correspondence> getAll() {
		return correspondenceDao.getAll();
	}

	@Transactional(readOnly = true)
	public Correspondence getById(int id) {
		return correspondenceDao.getById(id);
	}

	@Transactional
	public void delete(int id) {

		correspondenceDao.delete(correspondenceDao.getById(id));
	}

	@Transactional
	public Correspondence update(Correspondence correspondence) {
		return correspondenceDao.update(correspondence);
	}
}
