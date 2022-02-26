package co.com.poli.tallerpds2.serviceshowtime.service;

import co.com.poli.tallerpds2.serviceshowtime.client.MoviesClient;
import co.com.poli.tallerpds2.serviceshowtime.entity.Showtime;
import co.com.poli.tallerpds2.serviceshowtime.entity.Movies;
import co.com.poli.tallerpds2.serviceshowtime.repository.ShowtimeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.modelmapper.ModelMapper;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ShowtimeServiceImpl implements ShowtimeService {

    private final ShowtimeRepository showtimeRepository;
    private final MoviesClient moviesClient;

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void save(Showtime showtime) {
        showtimeRepository.save(showtime);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void delete(Showtime showtime) {
        showtimeRepository.delete(showtime);
    }

    @Override
    @Transactional(readOnly = true)
    public List<Showtime> findAll() {
        return showtimeRepository.findAll();
    }

    @Override
    @Transactional(readOnly = true)
    public Showtime findById(Long id) {
        return showtimeRepository.findById(id).orElse(null);
    }

    @Override
    public Showtime findByNumberInvoice(String numberShowtime) {
        Showtime showtime = showtimeRepository.findByNumberInvoice(numberShowtime);
        ModelMapper modelMapper = new ModelMapper();
        Movies movie = modelMapper.
                map(moviesClient.findByID(showtime.getMovie().getId()).getData(),Movies.class);
        showtime.setMovie(movie);
        List<Movies> itemsList = showtime.getMovies().stream()
                .map(invoiceItem -> {
                    Movies movieItem = modelMapper.map(moviesClient.findByID(invoiceItem.getId()),Movies.class);
                    invoiceItem.setMovie(movieItem);
                    return invoiceItem;
                }).collect(Collectors.toList());
        return showtimeRepository.findByNumberInvoice(numberShowtime);
    }
}
