package co.com.poli.tallerpds2.servicebooking.client;


import co.com.poli.tallerpds2.servicebooking.helper.ResponseBuilder;
import co.com.poli.tallerpds2.servicebooking.model.Movies;
import co.com.poli.tallerpds2.servicebooking.model.Response;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class MoviesClientFallbackHystrix implements  MoviesClient{

    private final ResponseBuilder builder;

    @Override
    public Response findByID(Long id) {
        return builder.success(new Movies());
    }
}
