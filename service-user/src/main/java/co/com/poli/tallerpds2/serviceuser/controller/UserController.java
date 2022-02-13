package co.com.poli.tallerpds2.serviceuser.controller;

import co.com.poli.tallerpds2.serviceuser.entity.User;
import co.com.poli.tallerpds2.serviceuser.model.Response;
import co.com.poli.tallerpds2.serviceuser.helper.ResponseBuilder;
import co.com.poli.tallerpds2.serviceuser.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/users")
@RequiredArgsConstructor
public class UserController {

    private final UserService productService;
    private final ResponseBuilder builder;

    @PostMapping
    public Response save(@Valid @RequestBody User user, BindingResult result){
        if(result.hasErrors()){
            return builder.failed(formatMessage(result));
        }
        productService.save(user);
        return builder.success(user);
    }

    @DeleteMapping("/{id}")
    public Response delete(@PathVariable("id") Long id){
         User user = productService.findById(id);
        if(user==null){
            return builder.failed("Not found product");
        }
        productService.delete(user);
        return builder.success(user);
    }

    @GetMapping
    public Response findAll(){
        List<User> user = productService.findAll();
        if(user.isEmpty()){
            return builder.failed("Products is empty");
        }
        return builder.success(user);
    }
    @GetMapping("/{id}")
    public Response findById(@PathVariable("id") Long id){
        User user = productService.findById(id);
        if(user==null){
            return builder.failed("Not found product");
        }
        return builder.success(user);
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
