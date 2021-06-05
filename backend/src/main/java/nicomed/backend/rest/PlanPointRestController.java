package nicomed.backend.rest;

import nicomed.backend.model.PlanPoint;
import nicomed.backend.service.PlanPointService;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;

@RestController
@RequestMapping("/pdm/api")
public class PlanPointRestController {

    private final
    PlanPointService service;

    public PlanPointRestController(PlanPointService service) {
        this.service = service;
    }

    @GetMapping("/planpoints")
    public List<PlanPoint> getAllPlanpoints() {
        return service.findAll(Sort.by("planDate"));
    }


    @GetMapping("/plans/{buro_id}/{year}/{month}")
    public List<PlanPoint> getPlanpointsByMonth(
            @PathVariable("buro_id") Long buro_id,
            @PathVariable("year") Integer year,
            @PathVariable("month") Integer month
    ) {
        Calendar date = new GregorianCalendar(year, month, 15);

        return service.findAllByPlanDate(buro_id, date);
    }


//    @GetMapping("/{id}")
//    public List<PlanPoint> getAllPlanPointByBuro(@PathVariable ("id") Long id){
//        return service.findAllByPlanmonthBuroId(id);
//    }
//
//    @GetMapping("/{id}/{plan}")
//    public List<PlanPoint> getAllPlanPointByBuro(
//            @PathVariable ("id") Long id,
//            @PathVariable ("plan") Long plan
//            ){
//        return service.findAllByPlanmonthBuroIdAndPlanmonthId(id, plan);
//    }


}
