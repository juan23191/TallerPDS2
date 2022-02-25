package co.com.poli.tallerpds2.servicemovie.service;

import co.com.poli.tallerpds2.servicemovie.entity.Movies;
import co.com.poli.tallerpds2.servicemovie.repository.MoviesRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class MoviesServiceImpl implements MoviesService {

    private final MoviesRepository MoviesRepository;

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void save(Movies movie) {
        MoviesRepository.save(movie);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void delete(Movies movie) {
        MoviesRepository.delete(movie);
    }

    @Override
    @Transactional(readOnly = true)
    public List<Movies> findAll() {
        return MoviesRepository.findAll();
    }

    @Override
    @Transactional(readOnly = true)
    public Movies findById(Long id) {
        return MoviesRepository.findById(id).orElse(null);
    }
}
