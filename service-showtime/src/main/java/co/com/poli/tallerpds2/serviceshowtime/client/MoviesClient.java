package co.com.poli.tallerpds2.serviceshowtime.client;

import co.com.poli.tallerpds2.serviceshowtime.model.Response;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "service-movie", fallback = MoviesClientFallbackHystrix.class)
public interface MoviesClient {

    @GetMapping("/movies/v1/movies/{id}")
    Response findByID(@PathVariable("id") Long id);

}
