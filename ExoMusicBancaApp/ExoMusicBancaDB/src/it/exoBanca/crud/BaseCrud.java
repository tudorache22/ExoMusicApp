package it.exoBanca.crud;

import java.util.List;

public abstract class BaseCrud<T> {

	protected String entityProjectName = "ExoMusicBancaModel"; // nome del progetto in cui sono mappate le Entity

	abstract T insert(T model);

	abstract T update(T model);

	abstract void delete(T model);

	abstract T findById(Integer id);

	abstract List<T> findAll();

}
