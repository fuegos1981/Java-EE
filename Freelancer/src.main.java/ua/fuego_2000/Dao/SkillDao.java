package ua.fuego_2000.Dao;

import java.util.List;

import ua.fuego_2000.model.Skill;


public interface SkillDao {
	
	Skill create(Skill skill);
	Skill getById(int id);
	boolean delete(Skill skill);
	Skill update(Skill skill);
	List<Skill> getAll();
}