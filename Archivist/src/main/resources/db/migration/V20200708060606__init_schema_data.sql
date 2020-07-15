CREATE SCHEMA IF NOT EXISTS archivist;

GRANT USAGE ON SCHEMA archivist to archi;

CREATE TABLE archivist.stored_data (
    id serial primary key NOT NULL,

    userId numeric NOT NULL,

    cardNumber varchar (255) null,
    lastName varchar (255) null,
    firstName varchar (255) null,
    middleName varchar (255) null,
    snils varchar (1023) null,
    enp varchar (1023) null,
    birthDate varchar (255) null,
    remdResult varchar (255) null,
    codeMo varchar (1023) null,

    date_insert timestamp (6) NOT NULL,
    date_update timestamp (6) null
);

-- Column comments
COMMENT ON COLUMN archivist.stored_data.id IS 'Id записи';
COMMENT ON COLUMN archivist.stored_data.userId IS 'Id пользователя';
COMMENT ON COLUMN archivist.stored_data.cardNumber IS 'Номер карты';
COMMENT ON COLUMN archivist.stored_data.lastName IS 'Фамилия';
COMMENT ON COLUMN archivist.stored_data.middleName IS 'Отчество';
COMMENT ON COLUMN archivist.stored_data.firstName IS 'Имя';
COMMENT ON COLUMN archivist.stored_data.snils IS 'СНИЛС';
COMMENT ON COLUMN archivist.stored_data.enp IS 'Полис ОМС';
COMMENT ON COLUMN archivist.stored_data.birthDate IS 'Дата рождение';
COMMENT ON COLUMN archivist.stored_data.remdResult IS 'Результат отправки в РЭМД';
COMMENT ON COLUMN archivist.stored_data.codeMo IS 'Код МО';
COMMENT ON COLUMN archivist.stored_data.date_insert IS 'Дата добавления';
COMMENT ON COLUMN archivist.stored_data.date_update IS 'Дата обновления';

-- Permissions
GRANT SELECT ON ALL TABLES IN SCHEMA archivist TO archi;
GRANT USAGE, SELECT ON ALL SEQUENCES IN SCHEMA archivist TO archi;

GRANT UPDATE, INSERT ON archivist.stored_data TO archi;