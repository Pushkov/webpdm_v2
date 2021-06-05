package nicomed.backend.repository;

import nicomed.backend.model.PlanPoint;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Calendar;
import java.util.List;
import java.util.Optional;

@Repository
public interface PlanPointRepository extends JpaRepository<PlanPoint, Long> {

    Optional<PlanPoint> findById(Long id);

    //    List<PlanPoint> findAllByName(String name);
//    List<PlanPoint> findAllByDesignation(String designation);
    List<PlanPoint> findAll(Sort sort);

    List<PlanPoint> findAllByBuroIdAndPlanDateBetween(Long buroId, Calendar date1, Calendar date2);

//    List<PlanPoint> findAllByPlanmonthBuroId(Long buro);
//    List<PlanPoint> findAllByPlanmonthBuroIdAndPlanmonthId(Long buro, Long plan);
//    List<PlanPoint> findAllByPlanmonthBuroIdAndPlanmonthCalendarBetween(Long buro_id, Calendar date1,Calendar date2 );
//    List<PlanPoint> findAllByPlanmonthCalendarBetween(Calendar date1,Calendar date2 );
//    List<PlanPoint> findAllByPlanmonthCalendarBetweenOrderByPositionInPlan(Calendar date1,Calendar date2 );

}
