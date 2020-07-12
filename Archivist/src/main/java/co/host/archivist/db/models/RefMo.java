package co.host.archivist.db.models;

import lombok.*;
import javax.persistence.*;
import java.math.BigDecimal;
import java.time.*;

@Entity
@NamedQuery(name = "RefMo.findByMaxVersionAndIsShown",
        query = "select m from RefMo m where m.version = (select max(version) from RefMo) and m.isShown = ?1")
@Table(name = "ref_mo", schema = "archivist")
@Data
@EqualsAndHashCode(of = "guid")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@RequiredArgsConstructor
public class RefMo {

    /**
     * фед.ОИД (код МО)
     */
    @Column(name = "oid")
    private String oid;

    /**
     * Версия
     */
    @Column(name = "version")
    private String version;

    /**
     * Полное наименование МО
     */
    @Column(name = "namefull")
    private String namefull;

    /**
     * Короткое наименование МО
     */
    @Column(name = "nameshort")
    private String nameshort;

    /**
     * Гуид(что очевидно)
     */
    @Id
    @Setter(AccessLevel.PROTECTED)
    @NonNull
    @Column(name = "guid", nullable = false)
    private BigDecimal guid;

    /**
     * Признак "Показывать в приложении"
     */
    @Column(name = "is_shown")
    private Boolean isShown;
}