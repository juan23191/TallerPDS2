package co.com.poli.tallerpds2.servicemovie.service;

import co.com.poli.tallerpds2.servicemovie.entity.Movies;

import java.util.List;

public interface MoviesService {

    void save(Movies movie);
    void delete(Movies movie);
    List<Movies> findAll();
    Movies findById(Long id);

}
