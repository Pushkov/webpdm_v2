package nicomed.backend.service;

import nicomed.backend.model.Buro;
import nicomed.backend.repository.BuroRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;

@Service
public class BuroServiceImpl implements BuroService {

    private final
    BuroRepository repository;

    public BuroServiceImpl(BuroRepository repository) {
        this.repository = repository;
    }

    @Override
    public Buro findById(Long id) {
        return repository.findById(id)
                .orElseThrow(()-> new NoSuchElementException(""));
    }

    @Override
    public List<Buro> findAll() {
        return repository.findAll();
    }

    @Override
    public void save(Buro buro) {
        repository.save(buro);
    }
}
