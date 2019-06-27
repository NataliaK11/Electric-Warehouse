package pl.Nat.magazyn.model.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import pl.Nat.magazyn.model.entity.WireEntity;

@Repository
public interface WireRepository extends CrudRepository<WireEntity, Integer> {
    @Override
    Iterable<WireEntity> findAll();
}
