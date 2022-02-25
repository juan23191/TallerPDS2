package co.com.poli.tallerpds2.serviceshowtime.repository;

import co.com.poli.tallerpds2.serviceshowtime.entity.Showtime;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ShowtimeRepository extends JpaRepository<Showtime,Long> {
    Showtime findByNumberInvoice(String numberShowtime);
}