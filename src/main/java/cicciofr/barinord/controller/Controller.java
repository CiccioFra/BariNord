package cicciofr.barinord.controller;

import cicciofr.barinord.model.Fermate;
import cicciofr.barinord.model.repository.FermataRepo;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.List;

@RestControllerAdvice
public class Controller {

    @GetMapping("/fermate")
    public List<Fermate> fermate() {
        return FermataRepo.getFermate();
    }

}
