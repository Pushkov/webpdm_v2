package nicomed.backend.rest;

import nicomed.backend.model.Buro;
import nicomed.backend.service.BuroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/pdm/api/buros")
public class BuroRestController {

    private final BuroService service;

    @Autowired
    public BuroRestController(BuroService service) {
        this.service = service;
    }

    @GetMapping("")
    public List<Buro> getAllBuros(){
        return service.findAll();
    }

}
