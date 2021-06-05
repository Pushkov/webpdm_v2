package nicomed.backend.service;

import nicomed.backend.model.PlanPoint;
import org.springframework.data.domain.Sort;

import java.util.Calendar;
import java.util.List;

public interface PlanPointService {

    PlanPoint findById(Long id);
    List<PlanPoint> findAll(Sort sort);

    List<PlanPoint> findAllByPlanDate( Long buroId, Calendar planDate);

//    List<PlanPoint> findAllByPlanmonthBuroId(Long buro);
//    List<PlanPoint> findAllByPlanmonthBuroIdAndPlanmonthId(Long buro, Long plan);

}
