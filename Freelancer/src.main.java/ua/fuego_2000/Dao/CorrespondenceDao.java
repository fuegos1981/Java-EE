package ua.fuego_2000.Dao;

import java.util.List;

import ua.fuego_2000.model.Correspondence;


public interface CorrespondenceDao {
	
	Correspondence create(Correspondence corresp);
	Correspondence getById(int id);
	boolean delete(Correspondence corresp);
	Correspondence update(Correspondence corresp);
	List<Correspondence> getAll();
}
