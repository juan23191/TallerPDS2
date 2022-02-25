package co.com.poli.tallerpds2.servicemovie.repository;

import co.com.poli.tallerpds2.servicemovie.entity.Movies;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MoviesRepository extends JpaRepository<Movies,Long> {

}
