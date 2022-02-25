package co.com.poli.tallerpds2.servicemovie.controller;

import co.com.poli.tallerpds2.servicemovie.entity.Movies;
import co.com.poli.tallerpds2.servicemovie.helper.ResponseBuilder;
import co.com.poli.tallerpds2.servicemovie.model.Response;
import co.com.poli.tallerpds2.servicemovie.service.MoviesService;
import lombok.RequiredArgsConstructor;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/movies")
@RequiredArgsConstructor
public class MoviesController {

    private final MoviesService productService;
    private final ResponseBuilder builder;

    @PostMapping
    public Response save(@Valid @RequestBody Movies movie, BindingResult result){
        if(result.hasErrors()){
            return builder.failed(formatMessage(result));
        }
        productService.save(movie);
        return builder.success(movie);
    }

    @DeleteMapping("/{id}")
    public Response delete(@PathVariable("id") Long id){
         Movies movie = productService.findById(id);
        if(movie==null){
            return builder.failed("Not found product");
        }
        productService.delete(movie);
        return builder.success(movie);
    }

    @GetMapping
    public Response findAll(){
        List<Movies> movie = productService.findAll();
        if(movie.isEmpty()){
            return builder.failed("Products is empty");
        }
        return builder.success(movie);
    }
    @GetMapping("/{id}")
    public Response findById(@PathVariable("id") Long id){
        Movies movie = productService.findById(id);
        if(movie==null){
            return builder.failed("Not found product");
        }
        return builder.success(movie);
    }

    private  List<Map<String,String>> formatMessage(BindingResult result){
        List<Map<String,String>> errors = result.getFieldErrors().stream()
                .map(err -> {
                    Map<String,String> error = new HashMap<>();
                    error.put(err.getField(),err.getDefaultMessage());
                    return error;
                }).collect(Collectors.toList());
        return errors;
    }


}
