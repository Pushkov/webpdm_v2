package nicomed.backend.repository;

import nicomed.backend.model.Workshop;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface WorkshopRepository extends JpaRepository<Workshop,Long> {
    Optional<Workshop> findById(Long id);
    Optional<Workshop> findByName(String name);
    List<Workshop> findByCode(int code);
}
