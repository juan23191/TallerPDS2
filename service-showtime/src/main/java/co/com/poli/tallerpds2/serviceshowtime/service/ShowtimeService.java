package co.com.poli.tallerpds2.serviceshowtime.service;

import co.com.poli.tallerpds2.serviceshowtime.entity.Showtime;

import java.util.List;

public interface ShowtimeService {

    void save(Showtime showtime);
    void delete(Showtime showtime);
    List<Showtime> findAll();
    Showtime findById(Long id);
    Showtime findByNumberInvoice(String numberShowtime);

}
