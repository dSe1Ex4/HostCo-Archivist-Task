package co.host.archivist.db.repositories;

import co.host.archivist.db.models.RefMo;
import org.springframework.data.jpa.repository.JpaRepository;

import java.math.BigDecimal;
import java.util.List;

public interface RefMoRepository extends JpaRepository<RefMo, BigDecimal>{
    List<RefMo> findByMaxVersionAndIsShown(boolean isShown);
}