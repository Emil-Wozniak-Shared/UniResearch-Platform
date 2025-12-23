CREATE EXTENSION IF NOT EXISTS "pgcrypto";

INSERT INTO "role" (id, name, description)
VALUES ('9a1f1d6e-3c2a-4e8b-9a9f-111111111111', 'IT_ADMIN', 'System IT administrator'),
       ('9a1f1d6e-3c2a-4e8b-9a9f-222222222222', 'MINISTRY', 'Ministry-level authority'),
       ('9a1f1d6e-3c2a-4e8b-9a9f-333333333333', 'UNIVERSITY', 'University role'),
       ('9a1f1d6e-3c2a-4e8b-9a9f-444444444444', 'ACADEMY_INSTITUTE', 'Academy or research institute'),
       ('9a1f1d6e-3c2a-4e8b-9a9f-555555555555', 'DEPARTMENT_UNIT', 'Department or unit'),
       ('9a1f1d6e-3c2a-4e8b-9a9f-666666666666', 'PUBLIC_USER', 'Public system user'),
       ('9a1f1d6e-3c2a-4e8b-9a9f-777777777777', 'AUDITOR', 'Audit and compliance role'),
       ('9a1f1d6e-3c2a-4e8b-9a9f-888888888888', 'MODERATOR', 'Content moderator');

INSERT INTO "permission" (id, name, description)
VALUES ('11111111-aaaa-4aaa-8aaa-111111111111', 'READ_ALL', 'Read all records'),
       ('22222222-bbbb-4bbb-8bbb-222222222222', 'WRITE_ALL', 'Write all records'),
       ('33333333-cccc-4ccc-8ccc-333333333333', 'EDIT_OWN', 'Edit own records'),
       ('44444444-dddd-4ddd-8ddd-444444444444', 'READ_OWN', 'Read own records'),
       ('55555555-eeee-4eee-8eee-555555555555', 'GENERATE_REPORTS', 'Generate reports'),
       ('66666666-ffff-4fff-8fff-666666666666', 'AUDIT_LOGS', 'Audit logs'),
       ('77777777-aaaa-4aaa-8aaa-777777777777', 'APPROVE_CHANGES', 'Approve changes'),
       ('88888888-bbbb-4bbb-8bbb-888888888888', 'VIEW_PUBLIC_DATA', 'View public data');

-- Plain password: myPassword123
INSERT INTO "user" (id, username, email, password_hash, researcher_id)
VALUES
-- IT_ADMIN
('a1c1e111-1111-4aaa-8aaa-000000000001', 'it_admin_1', 'it_admin_1@example.com',
 '$2a$12$u8eJkT5S4FvW/1ZVf9WvMetTCAMKXiaxZx369cR8y9GRUeenXuKiK', NULL),
('a1c1e111-1111-4aaa-8aaa-000000000002', 'it_admin_2', 'it_admin_2@example.com',
 '$2a$12$u8eJkT5S4FvW/1ZVf9WvMetTCAMKXiaxZx369cR8y9GRUeenXuKiK', NULL),

-- MINISTRY
('a1c1e111-2222-4aaa-8aaa-000000000001', 'ministry_1', 'ministry_1@example.com',
 '$2a$12$u8eJkT5S4FvW/1ZVf9WvMetTCAMKXiaxZx369cR8y9GRUeenXuKiK', NULL),
('a1c1e111-2222-4aaa-8aaa-000000000002', 'ministry_2', 'ministry_2@example.com',
 '$2a$12$u8eJkT5S4FvW/1ZVf9WvMetTCAMKXiaxZx369cR8y9GRUeenXuKiK', NULL),

-- UNIVERSITY
('a1c1e111-3333-4aaa-8aaa-000000000001', 'university_1', 'university_1@example.com',
 '$2a$12$u8eJkT5S4FvW/1ZVf9WvMetTCAMKXiaxZx369cR8y9GRUeenXuKiK', NULL),
('a1c1e111-3333-4aaa-8aaa-000000000002', 'university_2', 'university_2@example.com',
 '$2a$12$u8eJkT5S4FvW/1ZVf9WvMetTCAMKXiaxZx369cR8y9GRUeenXuKiK', NULL),

-- ACADEMY_INSTITUTE
('a1c1e111-4444-4aaa-8aaa-000000000001', 'academy_1', 'academy_1@example.com',
 '$2a$12$u8eJkT5S4FvW/1ZVf9WvMetTCAMKXiaxZx369cR8y9GRUeenXuKiK', NULL),
('a1c1e111-4444-4aaa-8aaa-000000000002', 'academy_2', 'academy_2@example.com',
 '$2a$12$u8eJkT5S4FvW/1ZVf9WvMetTCAMKXiaxZx369cR8y9GRUeenXuKiK', NULL),

-- DEPARTMENT_UNIT
('a1c1e111-5555-4aaa-8aaa-000000000001', 'department_1', 'department_1@example.com',
 '$2a$12$u8eJkT5S4FvW/1ZVf9WvMetTCAMKXiaxZx369cR8y9GRUeenXuKiK', NULL),
('a1c1e111-5555-4aaa-8aaa-000000000002', 'department_2', 'department_2@example.com',
 '$2a$12$u8eJkT5S4FvW/1ZVf9WvMetTCAMKXiaxZx369cR8y9GRUeenXuKiK', NULL),

-- PUBLIC_USER
('a1c1e111-6666-4aaa-8aaa-000000000001', 'public_1', 'public_1@example.com',
 '$2a$12$u8eJkT5S4FvW/1ZVf9WvMetTCAMKXiaxZx369cR8y9GRUeenXuKiK', NULL),
('a1c1e111-6666-4aaa-8aaa-000000000002', 'public_2', 'public_2@example.com',
 '$2a$12$u8eJkT5S4FvW/1ZVf9WvMetTCAMKXiaxZx369cR8y9GRUeenXuKiK', NULL),

-- AUDITOR
('a1c1e111-7777-4aaa-8aaa-000000000001', 'auditor_1', 'auditor_1@example.com',
 '$2a$12$u8eJkT5S4FvW/1ZVf9WvMetTCAMKXiaxZx369cR8y9GRUeenXuKiK', NULL),
('a1c1e111-7777-4aaa-8aaa-000000000002', 'auditor_2', 'auditor_2@example.com',
 '$2a$12$u8eJkT5S4FvW/1ZVf9WvMetTCAMKXiaxZx369cR8y9GRUeenXuKiK', NULL),

-- MODERATOR
('a1c1e111-8888-4aaa-8aaa-000000000001', 'moderator_1', 'moderator_1@example.com',
 '$2a$12$u8eJkT5S4FvW/1ZVf9WvMetTCAMKXiaxZx369cR8y9GRUeenXuKiK', NULL),
('a1c1e111-8888-4aaa-8aaa-000000000002', 'moderator_2', 'moderator_2@example.com',
 '$2a$12$u8eJkT5S4FvW/1ZVf9WvMetTCAMKXiaxZx369cR8y9GRUeenXuKiK', NULL);

INSERT INTO "user_role" (user_id, role_id)
VALUES ('a1c1e111-1111-4aaa-8aaa-000000000001', '9a1f1d6e-3c2a-4e8b-9a9f-111111111111'),
       ('a1c1e111-1111-4aaa-8aaa-000000000002', '9a1f1d6e-3c2a-4e8b-9a9f-111111111111'),

       ('a1c1e111-2222-4aaa-8aaa-000000000001', '9a1f1d6e-3c2a-4e8b-9a9f-222222222222'),
       ('a1c1e111-2222-4aaa-8aaa-000000000002', '9a1f1d6e-3c2a-4e8b-9a9f-222222222222'),

       ('a1c1e111-3333-4aaa-8aaa-000000000001', '9a1f1d6e-3c2a-4e8b-9a9f-333333333333'),
       ('a1c1e111-3333-4aaa-8aaa-000000000002', '9a1f1d6e-3c2a-4e8b-9a9f-333333333333'),

       ('a1c1e111-4444-4aaa-8aaa-000000000001', '9a1f1d6e-3c2a-4e8b-9a9f-444444444444'),
       ('a1c1e111-4444-4aaa-8aaa-000000000002', '9a1f1d6e-3c2a-4e8b-9a9f-444444444444'),

       ('a1c1e111-5555-4aaa-8aaa-000000000001', '9a1f1d6e-3c2a-4e8b-9a9f-555555555555'),
       ('a1c1e111-5555-4aaa-8aaa-000000000002', '9a1f1d6e-3c2a-4e8b-9a9f-555555555555'),

       ('a1c1e111-6666-4aaa-8aaa-000000000001', '9a1f1d6e-3c2a-4e8b-9a9f-666666666666'),
       ('a1c1e111-6666-4aaa-8aaa-000000000002', '9a1f1d6e-3c2a-4e8b-9a9f-666666666666'),

       ('a1c1e111-7777-4aaa-8aaa-000000000001', '9a1f1d6e-3c2a-4e8b-9a9f-777777777777'),
       ('a1c1e111-7777-4aaa-8aaa-000000000002', '9a1f1d6e-3c2a-4e8b-9a9f-777777777777'),

       ('a1c1e111-8888-4aaa-8aaa-000000000001', '9a1f1d6e-3c2a-4e8b-9a9f-888888888888'),
       ('a1c1e111-8888-4aaa-8aaa-000000000002', '9a1f1d6e-3c2a-4e8b-9a9f-888888888888');

INSERT INTO "role_permission" (role_id, permission_id)
VALUES

-- IT_ADMIN (full access)
('9a1f1d6e-3c2a-4e8b-9a9f-111111111111', '11111111-aaaa-4aaa-8aaa-111111111111'),
('9a1f1d6e-3c2a-4e8b-9a9f-111111111111', '22222222-bbbb-4bbb-8bbb-222222222222'),
('9a1f1d6e-3c2a-4e8b-9a9f-111111111111', '33333333-cccc-4ccc-8ccc-333333333333'),
('9a1f1d6e-3c2a-4e8b-9a9f-111111111111', '44444444-dddd-4ddd-8ddd-444444444444'),
('9a1f1d6e-3c2a-4e8b-9a9f-111111111111', '55555555-eeee-4eee-8eee-555555555555'),
('9a1f1d6e-3c2a-4e8b-9a9f-111111111111', '66666666-ffff-4fff-8fff-666666666666'),
('9a1f1d6e-3c2a-4e8b-9a9f-111111111111', '77777777-aaaa-4aaa-8aaa-777777777777'),
('9a1f1d6e-3c2a-4e8b-9a9f-111111111111', '88888888-bbbb-4bbb-8bbb-888888888888'),

-- MINISTRY
('9a1f1d6e-3c2a-4e8b-9a9f-222222222222', '11111111-aaaa-4aaa-8aaa-111111111111'),
('9a1f1d6e-3c2a-4e8b-9a9f-222222222222', '55555555-eeee-4eee-8eee-555555555555'),
('9a1f1d6e-3c2a-4e8b-9a9f-222222222222', '77777777-aaaa-4aaa-8aaa-777777777777'),

-- UNIVERSITY
('9a1f1d6e-3c2a-4e8b-9a9f-333333333333', '11111111-aaaa-4aaa-8aaa-111111111111'),
('9a1f1d6e-3c2a-4e8b-9a9f-333333333333', '44444444-dddd-4ddd-8ddd-444444444444'),

-- ACADEMY_INSTITUTE
('9a1f1d6e-3c2a-4e8b-9a9f-444444444444', '11111111-aaaa-4aaa-8aaa-111111111111'),
('9a1f1d6e-3c2a-4e8b-9a9f-444444444444', '55555555-eeee-4eee-8eee-555555555555'),

-- DEPARTMENT_UNIT
('9a1f1d6e-3c2a-4e8b-9a9f-555555555555', '33333333-cccc-4ccc-8ccc-333333333333'),
('9a1f1d6e-3c2a-4e8b-9a9f-555555555555', '44444444-dddd-4ddd-8ddd-444444444444'),

-- PUBLIC_USER
('9a1f1d6e-3c2a-4e8b-9a9f-666666666666', '88888888-bbbb-4bbb-8bbb-888888888888'),

-- AUDITOR
('9a1f1d6e-3c2a-4e8b-9a9f-777777777777', '66666666-ffff-4fff-8fff-666666666666'),
('9a1f1d6e-3c2a-4e8b-9a9f-777777777777', '55555555-eeee-4eee-8eee-555555555555'),

-- MODERATOR
('9a1f1d6e-3c2a-4e8b-9a9f-888888888888', '33333333-cccc-4ccc-8ccc-333333333333'),
('9a1f1d6e-3c2a-4e8b-9a9f-888888888888', '77777777-aaaa-4aaa-8aaa-777777777777');

INSERT INTO location (id, name, type, parent_location_id)
VALUES
-- Countries
(gen_random_uuid(),'USA', 'Country', NULL),
(gen_random_uuid(),'UK', 'Country', NULL),
(gen_random_uuid(),'Germany', 'Country', NULL),
(gen_random_uuid(),'Switzerland', 'Country', NULL),
(gen_random_uuid(),'Japan', 'Country', NULL),

-- States
(gen_random_uuid(),'California', 'State', NULL),
(gen_random_uuid(),'Massachusetts', 'State', NULL),
(gen_random_uuid(),'New York', 'State', NULL),
(gen_random_uuid(),'England', 'State', NULL),
(gen_random_uuid(),'Bavaria', 'State', NULL),

-- Cities / Campuses
(gen_random_uuid(),'MIT Campus', 'Campus', NULL),
(gen_random_uuid(),'Stanford Campus', 'Campus', NULL),
(gen_random_uuid(),'Harvard Campus', 'Campus', NULL),
(gen_random_uuid(),'Oxford Campus', 'Campus', NULL),
(gen_random_uuid(),'Cambridge Campus', 'Campus', NULL),
(gen_random_uuid(),'LMU Munich Campus', 'Campus', NULL),
(gen_random_uuid(),'ETH Zurich Campus', 'Campus', NULL),
(gen_random_uuid(),'University of Tokyo Campus', 'Campus', NULL),
(gen_random_uuid(),'UCLA Campus', 'Campus', NULL),
(gen_random_uuid(),'Columbia Campus', 'Campus', NULL);


-- 30 rekordów dla scientific_field
INSERT INTO scientific_field (id, name, description)
VALUES (gen_random_uuid(), 'Computer Science', 'Study of computation and information'),
       (gen_random_uuid(), 'Physics', 'Study of matter and energy'),
       (gen_random_uuid(), 'Chemistry', 'Study of substances and reactions'),
       (gen_random_uuid(), 'Biology', 'Study of living organisms'),
       (gen_random_uuid(), 'Mathematics', 'Study of numbers and structures'),
       (gen_random_uuid(), 'Astronomy', 'Study of celestial objects'),
       (gen_random_uuid(), 'Geology', 'Study of Earth and rocks'),
       (gen_random_uuid(), 'Engineering', 'Application of scientific principles'),
       (gen_random_uuid(), 'Medicine', 'Study of human health'),
       (gen_random_uuid(), 'Psychology', 'Study of mind and behavior'),
       (gen_random_uuid(), 'Sociology', 'Study of society'),
       (gen_random_uuid(), 'Anthropology', 'Study of humans and cultures'),
       (gen_random_uuid(), 'Economics', 'Study of production and consumption'),
       (gen_random_uuid(), 'Political Science', 'Study of politics and governance'),
       (gen_random_uuid(), 'Environmental Science', 'Study of environment and ecology'),
       (gen_random_uuid(), 'Philosophy', 'Study of fundamental questions'),
       (gen_random_uuid(), 'Linguistics', 'Study of language'),
       (gen_random_uuid(), 'Artificial Intelligence', 'Study of intelligent machines'),
       (gen_random_uuid(), 'Robotics', 'Design and application of robots'),
       (gen_random_uuid(), 'Data Science', 'Study of data and analytics'),
       (gen_random_uuid(), 'Neuroscience', 'Study of nervous system'),
       (gen_random_uuid(), 'History', 'Study of past events'),
       (gen_random_uuid(), 'Education', 'Study of teaching and learning'),
       (gen_random_uuid(), 'Law', 'Study of legal systems'),
       (gen_random_uuid(), 'Architecture', 'Design of buildings and structures'),
       (gen_random_uuid(), 'Music', 'Study of sound and composition'),
       (gen_random_uuid(), 'Art', 'Study of visual arts'),
       (gen_random_uuid(), 'Theater', 'Study of performing arts'),
       (gen_random_uuid(), 'Journalism', 'Study of news and media'),
       (gen_random_uuid(), 'Agriculture', 'Study of farming and food production');

INSERT INTO university (id, name, type, location_id, founded_year, scientific_field_id)
SELECT
    gen_random_uuid(),
    u.name,
    u.type,
    l.id,
    u.founded_year,
    sf.id
FROM (
         VALUES
             ('MIT', 'Public', 'MIT Campus', 1861, 0),
             ('Stanford', 'Private', 'Stanford Campus', 1885, 1),
             ('Harvard', 'Private', 'Harvard Campus', 1636, 2),
             ('Oxford', 'Public', 'Oxford Campus', 1096, 3),
             ('Cambridge', 'Public', 'Cambridge Campus', 1209, 4),
             ('ETH Zurich', 'Public', 'ETH Zurich Campus', 1855, 5),
             ('UCLA', 'Public', 'UCLA Campus', 1919, 6),
             ('Columbia', 'Private', 'Columbia Campus', 1754, 7),
             ('Princeton', 'Private', 'Princeton Campus', 1746, 8),
             ('Yale', 'Private', 'Yale Campus', 1701, 9),
             ('Cornell', 'Private', 'Cornell Campus', 1865, 10),
             ('Duke', 'Private', 'Duke Campus', 1838, 11),
             ('Chicago', 'Private', 'Chicago Campus', 1890, 12),
             ('Berkeley', 'Public', 'Berkeley Campus', 1868, 13),
             ('Caltech', 'Private', 'Caltech Campus', 1891, 14),
             ('Toronto', 'Public', 'Toronto Campus', 1827, 15),
             ('Tokyo', 'Public', 'University of Tokyo Campus', 1877, 16),
             ('Melbourne', 'Public', 'Melbourne Campus', 1853, 17),
             ('Edinburgh', 'Public', 'Edinburgh Campus', 1583, 18),
             ('Munich', 'Public', 'Munich Campus', 1472, 19),
             ('Zurich', 'Public', 'Zurich Campus', 1833, 20),
             ('Seoul National', 'Public', 'Seoul Campus', 1946, 21),
             ('Tsinghua', 'Public', 'Tsinghua Campus', 1911, 22),
             ('Peking', 'Public', 'Peking Campus', 1898, 23),
             ('Sydney', 'Public', 'Sydney Campus', 1850, 24),
             ('Auckland', 'Public', 'Auckland Campus', 1883, 25),
             ('Cape Town', 'Public', 'Cape Town Campus', 1829, 26),
             ('Sao Paulo', 'Public', 'Sao Paulo Campus', 1934, 27),
             ('Delhi University', 'Public', 'Delhi Campus', 1922, 28),
             ('Warsaw University', 'Public', 'Warsaw Campus', 1816, 29)
     ) AS u(name, type, location_name, founded_year, sf_offset)
         JOIN location l ON l.name = u.location_name
         JOIN LATERAL (
    SELECT id FROM scientific_field
    ORDER BY id
    LIMIT 1 OFFSET u.sf_offset
    ) sf ON true;

INSERT INTO institution (id, name, type, location_id, university_id, founded_year, scientific_field_id)
SELECT
    gen_random_uuid(),
    i.name,
    i.type,
    l.id,
    u.id,
    i.founded_year,
    sf.id
FROM (
         VALUES
             ('Computer Science Department', 'Department', 'MIT Campus', 'MIT', 1960, 0),
             ('Physics Laboratory', 'Laboratory', 'Stanford Campus', 'Stanford', 1950, 1),
             ('Chemistry Department', 'Department', 'Harvard Campus', 'Harvard', 1920, 2),
             ('Biology Laboratory', 'Laboratory', 'Oxford Campus', 'Oxford', 1930, 3),
             ('Mathematics Department', 'Department', 'Cambridge Campus', 'Cambridge', 1910, 4),
             ('Engineering Faculty', 'Department', 'ETH Zurich Campus', 'ETH Zurich', 1965, 5),
             ('Medical School', 'Department', 'UCLA Campus', 'UCLA', 1800, 6),
             ('Economics Department', 'Department', 'Columbia Campus', 'Columbia', 1880, 7),
             ('Robotics Lab', 'Laboratory', 'Princeton Campus', 'Princeton', 2005, 8),
             ('Neuroscience Lab', 'Laboratory', 'Yale Campus', 'Yale', 1995, 9),
             ('Law School', 'Department', 'Cornell Campus', 'Cornell', 1870, 10),
             ('Business School', 'Department', 'Duke Campus', 'Duke', 1956, 11),
             ('History Department', 'Department', 'Chicago Campus', 'Chicago', 1892, 12),
             ('Data Science Institute', 'Department', 'Berkeley Campus', 'Berkeley', 2010, 13),
             ('Astronomy Observatory', 'Laboratory', 'Caltech Campus', 'Caltech', 1900, 14),
             ('AI Research Center', 'Laboratory', 'Toronto Campus', 'Toronto', 2000, 15),
             ('Philosophy Department', 'Department', 'University of Tokyo Campus', 'Tokyo', 1890, 16),
             ('Education Faculty', 'Department', 'Melbourne Campus', 'Melbourne', 1905, 17),
             ('Architecture Faculty', 'Department', 'Edinburgh Campus', 'Edinburgh', 1890, 18),
             ('Environmental Science Lab', 'Laboratory', 'Munich Campus', 'Munich', 1990, 19),
             ('Sociology Department', 'Department', 'Zurich Campus', 'Zurich', 1885, 20),
             ('Political Science Department', 'Department', 'Seoul Campus', 'Seoul National', 1910, 21),
             ('Materials Science Lab', 'Laboratory', 'Tsinghua Campus', 'Tsinghua', 2001, 22),
             ('International Relations', 'Department', 'Peking Campus', 'Peking', 1925, 23),
             ('Marine Biology Lab', 'Laboratory', 'Sydney Campus', 'Sydney', 1975, 24),
             ('Agriculture Faculty', 'Department', 'Auckland Campus', 'Auckland', 1915, 25),
             ('Public Health School', 'Department', 'Cape Town Campus', 'Cape Town', 1940, 26),
             ('Urban Studies Institute', 'Department', 'Sao Paulo Campus', 'Sao Paulo', 1980, 27),
             ('Statistics Department', 'Department', 'Delhi Campus', 'Delhi University', 1950, 28),
             ('Cybersecurity Lab', 'Laboratory', 'Warsaw Campus', 'Warsaw University', 2015, 29)
     ) AS i(name, type, location_name, university_name, founded_year, sf_offset)
         JOIN location l ON l.name = i.location_name
         JOIN university u ON u.name = i.university_name
         JOIN LATERAL (
    SELECT id FROM scientific_field
    ORDER BY id
    LIMIT 1 OFFSET i.sf_offset
    ) sf ON true;

INSERT INTO researcher (
    id,
    first_name,
    last_name,
    degree,
    university_id,
    institute_id
)
SELECT
    gen_random_uuid(),
    r.first_name,
    r.last_name,
    r.degree,
    u.id,
    i.id
FROM (
         VALUES
             ('Alice', 'Smith', 'PhD'),
             ('Bob', 'Johnson', 'MSc'),
             ('Carol', 'Williams', 'PhD'),
             ('Dave', 'Brown', 'MSc'),
             ('Eve', 'Davis', 'PhD'),
             ('Frank', 'Miller', 'PhD'),
             ('Grace', 'Wilson', 'MSc'),
             ('Hank', 'Moore', 'PhD'),
             ('Ivy', 'Taylor', 'MSc'),
             ('Jack', 'Anderson', 'PhD'),
             ('Kate', 'Thomas', 'MSc'),
             ('Leo', 'Jackson', 'PhD'),
             ('Mona', 'White', 'MSc'),
             ('Nate', 'Harris', 'PhD'),
             ('Olivia', 'Martin', 'MSc'),
             ('Paul', 'Thompson', 'PhD'),
             ('Quinn', 'Garcia', 'MSc'),
             ('Rose', 'Martinez', 'PhD'),
             ('Steve', 'Robinson', 'MSc'),
             ('Tina', 'Clark', 'PhD')
     ) AS r(first_name, last_name, degree)
         JOIN LATERAL (
    -- losowa uczelnia
    SELECT id
    FROM university
    ORDER BY random()
    LIMIT 1
    ) u ON true
         JOIN LATERAL (
    -- instytucja z tej samej uczelni
    SELECT id
    FROM institution
    WHERE university_id = u.id
    ORDER BY random()
    LIMIT 1
    ) i ON true;
