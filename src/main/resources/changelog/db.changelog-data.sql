--liquibase formatted sql

-- changeset drymlj:1
--comment: insert Admin user
INSERT INTO users (username, email, role, password)
VALUES ('admin', 'admin@test.cz', 'ROLE_ADMIN', '$2a$10$qw1xEK9CrHizlecUs8r/zedWzOL4Q3f5Tpm3SwmbCX0W9Ha9LAZHm');
-- encrypted 'password'

-- changeset drymlj:2
--comment: insert regions
INSERT INTO region
    (code, name)
VALUES ('PHA', 'Hlavní město Praha'),
       ('JHC', 'Jihočeský kraj'),
       ('JHM', 'Jihomoravský kraj'),
       ('KVK', 'Karlovarský kraj'),
       ('VYS', 'Kraj Vysočina'),
       ('HKK', 'Královéhradecký kraj'),
       ('LBK', 'Liberecký kraj'),
       ('MSK', 'Moravskoslezský kraj'),
       ('OLK', 'Olomoucký kraj'),
       ('PAK', 'Pardubický kraj'),
       ('PLK', 'Plzeňský kraj'),
       ('STC', 'Středočeský kraj'),
       ('ULK', 'Ústecký kraj'),
       ('ZLK', 'Zlínský kraj');