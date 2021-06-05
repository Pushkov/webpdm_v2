package nicomed.backend.service;

import nicomed.backend.model.PlanPoint;
import nicomed.backend.repository.PlanPointRepository;
import nicomed.backend.utils.Utils;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.NoSuchElementException;

@Service
public class PlanPointServiceImpl implements PlanPointService {

    private final
    PlanPointRepository repo;

    public PlanPointServiceImpl(PlanPointRepository repo) {
        this.repo = repo;
    }

    @Override
    public PlanPoint findById(Long id) {
        return repo.findById(id)
                .orElseThrow(() -> new NoSuchElementException(""));
    }

    @Override
    public List<PlanPoint> findAll(Sort sort) {
        return repo.findAll(sort);
    }

    @Override
    public List<PlanPoint> findAllByPlanDate(Long buroId, Calendar planDate) {
        Calendar date1 = Utils.getBeforeMonth(planDate);
        Calendar date2 = Utils.getAfterMonth(planDate);
        return repo.findAllByBuroIdAndPlanDateBetween( buroId, date1, date2);
    }

    //    @Override
//    public List<PlanPoint> findAllByPlanmonthBuroId(Long buroId) {
//        return repo.findAllByPlanmonthBuroId(buroId);
//    }
//
//    @Override
//    public List<PlanPoint> findAllByPlanmonthBuroIdAndPlanmonthId(Long buro, Long plan) {
//        return repo.findAllByPlanmonthBuroIdAndPlanmonthId(buro,plan);
//    }
}
