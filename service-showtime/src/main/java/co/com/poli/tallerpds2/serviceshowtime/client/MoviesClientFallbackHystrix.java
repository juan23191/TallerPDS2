package co.com.poli.tallerpds2.serviceshowtime.client;

import co.com.poli.tallerpds2.serviceshowtime.helper.ResponseBuilder;
import co.com.poli.tallerpds2.serviceshowtime.model.Movies;
import co.com.poli.tallerpds2.serviceshowtime.model.Response;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class MoviesClientFallbackHystrix implements  MoviesClient{

    private final ResponseBuilder builder;

    @Override
    public Response findByID(Long id) { return builder.success(new Movies());}
}
