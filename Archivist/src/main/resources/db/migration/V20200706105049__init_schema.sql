CREATE SCHEMA IF NOT EXISTS archivist;

GRANT USAGE ON SCHEMA archivist to archi;

CREATE TABLE archivist.ref_mo (
    "oid" varchar(1000) NULL,
    "version" varchar(15) NULL,
    namefull varchar(500) NULL,
    nameshort varchar(255) NULL, 
    guid numeric NOT NULL, 
    is_shown bool NULL, 
    CONSTRAINT ref_mo_pkey PRIMARY KEY (guid),
    CONSTRAINT ref_mo_version_recid_key UNIQUE (version, oid)
);

-- Column comments

COMMENT ON COLUMN archivist.ref_mo."oid" IS 'фед.ОИД';
COMMENT ON COLUMN archivist.ref_mo."version" IS 'Версия';
COMMENT ON COLUMN archivist.ref_mo.namefull IS 'Полное наименование МО';
COMMENT ON COLUMN archivist.ref_mo.nameshort IS 'Короткое наименование МО';
COMMENT ON COLUMN archivist.ref_mo.guid IS 'Гуид(что очевидно)';
COMMENT ON COLUMN archivist.ref_mo.is_shown IS 'Признак "Показывать в приложении"';

-- Permissions

GRANT SELECT ON ALL TABLES IN SCHEMA archivist TO archi;
GRANT USAGE, SELECT ON ALL SEQUENCES IN SCHEMA archivist TO archi;