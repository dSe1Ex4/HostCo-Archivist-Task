package co.host.archivist.db.repositories;

import co.host.archivist.db.models.StoredData;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StoredDataRepository extends JpaRepository<StoredData, Integer> {
    @Override
    <S extends StoredData> S save(S s);
}