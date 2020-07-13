package co.host.archivist.db.models;

import lombok.*;
import javax.persistence.*;
import java.math.BigDecimal;
import java.time.*;

@Entity
@Table(name = "stored_data", schema = "archivist")
@Data
@EqualsAndHashCode(of = "id")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@RequiredArgsConstructor
public class StoredData {

    /**
     * Id записи
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Setter(AccessLevel.PROTECTED)
    @NonNull
    @Column(name = "id", nullable = false)
    private Integer id;

    /**
     * Id пользователя
     */
    @Column(name = "userid", nullable = false)
    private BigDecimal userId;

    /**
     * Номер карты
     */
    @Column(name = "cardnumber")
    private String cardNumber;

    /**
     * Фамилия
     */
    @Column(name = "lastname")
    private String lastName;

    /**
     * Имя
     */
    @Column(name = "firstname")
    private String firstName;

    /**
     * Отчество
     */
    @Column(name = "middlename")
    private String middleName;

    /**
     * СНИЛС
     */
    @Column(name = "snils")
    private String snils;

    /**
     * Полис ОМС
     */
    @Column(name = "enp")
    private String enp;

    /**
     * Дата рождение
     */
    @Column(name = "birthdate")
    private String birthDate;

    /**
     * Результат отправки в РЭМД
     */
    @Column(name = "remdresult")
    private String remdResult;

    /**
     * Код МО
     */
    @Column(name = "codemo")
    private String codeMo;

    /**
     * Дата добавления
     */
    @Column(name = "date_insert", nullable = false)
    private OffsetDateTime dateInsert;

    /**
     * Дата обновления
     */
    @Column(name = "date_update")
    private OffsetDateTime dateUpdate;
}
