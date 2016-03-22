package ua.fuego_2000.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import ua.fuego_2000.Dao.SkillDao;
import ua.fuego_2000.model.Skill;

@Service
public class SkillService {
	@Autowired
	private SkillDao skillDao;

	public SkillService() {
		super();
	}

	@Transactional
	public Skill create(Skill skill) {
		skillDao.create(skill);
		return skill;
	}

	@Transactional(readOnly = true)
	public Skill getById(int id) {
		return skillDao.getById(id);
	}

	@Transactional(readOnly = true)
	public List<Skill> getAll() {
		return skillDao.getAll();
	}

	@Transactional
	public void delete(int id) {

		skillDao.delete(skillDao.getById(id));
	}

	@Transactional
	public Skill update(Skill skill) {
		return skillDao.update(skill);
	}

}
