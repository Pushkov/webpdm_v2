package nicomed.backend.rest;

import nicomed.backend.exeption.ElementNotFoundException;
import nicomed.backend.forms.WorkshopForm;
import nicomed.backend.model.Workshop;
import nicomed.backend.service.WorkshopService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/pdm/api/workshops")
public class WorkshopRestController {

    private final
    WorkshopService service;

    @Autowired
    public WorkshopRestController(WorkshopService service) {
        this.service = service;
    }

    @GetMapping("")
    public List<WorkshopForm> getAllWorkshops(){
        return service.findAll()
                .stream()
                .map(WorkshopForm::from)
                .collect(Collectors.toList());
    }

    @GetMapping("/{id}")
    public WorkshopForm getWorkshopById(@PathVariable ("id") Long id){
        try{
            return WorkshopForm.from(service.findById(id));
        }catch (NoSuchElementException e){
            throw new ElementNotFoundException("Workshop with id= " + id + " not found.");
        }
    }

    @PostMapping("")
    public WorkshopForm create(@ModelAttribute WorkshopForm wsForm){
        service.save(wsForm.create());
        return wsForm;
    }

    @PutMapping("{id}")
    public WorkshopForm editWorkshop(@PathVariable ("id")Long id, @ModelAttribute WorkshopForm wsForm){
        try{
            Workshop ws = service.findById(id);
            ws = wsForm.edit(ws);
            service.save(ws);
            return WorkshopForm.from(ws);
        } catch (NoSuchElementException e) {
            throw new ElementNotFoundException("Workshop with id= " + id + " not present.");
        }
        catch (RuntimeException у){
            throw new ElementNotFoundException("Incorrect value in WORKSHOP.");
        }
    }

    @DeleteMapping("{id}")
    public WorkshopForm deleteWorkshop(@PathVariable ("id")Long id){
        try{
            Workshop ws = service.findById(id);
            service.delete(ws);
            return WorkshopForm.from(ws);
        }catch (NoSuchElementException e){
            throw new ElementNotFoundException("Unable delete workshop with id= " + id + ". Workshop may not exist.");
        }
    }

}
