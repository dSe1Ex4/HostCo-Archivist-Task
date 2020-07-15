package co.host.archivist.db.repositories;

import co.host.archivist.db.models.StoredData;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.lang.NonNull;

/**
 * Репозиторий для сохранения данных из РЭМК
 * Имеет переопределенный метод save, который сохраняет дату добавления/изменения записи
 */
public interface StoredDataRepository extends JpaRepository<StoredData, Integer> {
    @Override
    @NonNull
    <S extends StoredData> S save(S s);
}