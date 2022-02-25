package co.com.poli.tallerpds2.serviceshowtime.controller;

import co.com.poli.tallerpds2.serviceshowtime.entity.Showtime;
import co.com.poli.tallerpds2.serviceshowtime.helper.ResponseBuilder;
import co.com.poli.tallerpds2.serviceshowtime.model.Response;
import co.com.poli.tallerpds2.serviceshowtime.service.ShowtimeService;
import lombok.RequiredArgsConstructor;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;


import javax.validation.Valid;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/showtimes")
@RequiredArgsConstructor

public class ShowtimeController {

    private final ShowtimeService showtimeService;
    private final ResponseBuilder builder;

    @PostMapping()
    public Response save(@Valid @RequestBody Showtime showtime, BindingResult result){
        if(result.hasErrors()){
            return builder.failed(formatMessage(result));
        }
        showtimeService.save(showtime);
        return builder.success(showtime);
    }

    @DeleteMapping("/{id}")
    public Response delete(@PathVariable("id") Long id) {
        Showtime showtime = showtimeService.findById(id);
        if(showtime==null){
            return builder.failed(showtime);
        }
        return builder.success(showtime);
    }

    @GetMapping("/{id}")
    public Response getByNumberInvoice(@PathVariable("id") Long id){
        Showtime showtime = showtimeService.findById(id);
        if(showtime==null){
            return builder.success();
        }
        return builder.success(showtime);
    }

    private List<Map<String,String>> formatMessage(BindingResult result){
        List<Map<String,String>> errors = result.getFieldErrors().stream()
                .map(err -> {
                    Map<String,String> error = new HashMap<>();
                    error.put(err.getField(),err.getDefaultMessage());
                    return error;
                }).collect(Collectors.toList());
        return errors;
    }

}
