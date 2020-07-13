package co.host.archivist.db.repositories;

import co.host.archivist.db.models.StoredData;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.support.SimpleJpaRepository;

import javax.persistence.EntityManager;
import java.time.OffsetDateTime;
import java.util.Objects;

public class StoredDataRepositoryImpl extends SimpleJpaRepository<StoredData, Integer> implements StoredDataRepository{

    public StoredDataRepositoryImpl(EntityManager em) {
        super(StoredData.class, em);
    }

    @Override
    public <S extends StoredData> S save(S s){
        if (Objects.nonNull(s.getId()) && this.existsById(s.getId())){
            s.setDateInsert(this.getOne(s.getId()).getDateInsert());
            s.setDateUpdate(OffsetDateTime.now());
        } else {
            s.setDateInsert(OffsetDateTime.now());
        }

        return super.save(s);
    }
}
