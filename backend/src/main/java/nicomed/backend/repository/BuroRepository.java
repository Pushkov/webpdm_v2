package nicomed.backend.repository;

import nicomed.backend.model.Buro;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface BuroRepository extends JpaRepository<Buro,Long> {
    Optional<Buro> findById(Long id);
    Optional<Buro> findByName(String name);
}
