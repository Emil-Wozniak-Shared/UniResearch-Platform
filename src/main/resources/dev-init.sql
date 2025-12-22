
INSERT INTO location (id, name, type, parent_location_id)
VALUES ('7a6f3e4c-2b1d-4f6e-8c5d-9a1b2c3d4e5f', 'USA', 'Country', NULL),
       ('1b2c3d4e-5f6a-7b8c-9d0e-1f2a3b4c5d6e', 'California', 'State', '7a6f3e4c-2b1d-4f6e-8c5d-9a1b2c3d4e5f'),
       ('2c3d4e5f-6a7b-8c9d-0e1f-2a3b4c5d6e7f', 'MIT Campus', 'Campus', '1b2c3d4e-5f6a-7b8c-9d0e-1f2a3b4c5d6e');

INSERT INTO scientific_field (id, name, description)
VALUES ('a1b2c3d4-e5f6-4a7b-8c9d-0e1f2a3b4c5d', 'Computer Science', 'Study of computation and information'),
       ('b1c2d3e4-f5a6-4b7c-9d0e-1f2a3b4c5d6e', 'Physics', 'Study of matter and energy');

INSERT INTO university (id, name, type, location_id, founded_year, scientific_field_id)
VALUES ('c1d2e3f4-a5b6-4c7d-8e9f-0a1b2c3d4e5f', 'MIT', 'Public', '2c3d4e5f-6a7b-8c9d-0e1f-2a3b4c5d6e7f', 1861,
        'a1b2c3d4-e5f6-4a7b-8c9d-0e1f2a3b4c5d'),
       ('d1e2f3a4-b5c6-4d7e-8f9a-0b1c2d3e4f5a', 'Stanford', 'Private', '1b2c3d4e-5f6a-7b8c-9d0e-1f2a3b4c5d6e', 1885,
        'b1c2d3e4-f5a6-4b7c-9d0e-1f2a3b4c5d6e');

INSERT INTO institution (id, name, type, location_id, university_id, founded_year, scientific_field_id)
VALUES ('e1f2a3b4-c5d6-4e7f-8a9b-0c1d2e3f4a5b', 'CS Department', 'Department', '2c3d4e5f-6a7b-8c9d-0e1f-2a3b4c5d6e7f',
        'c1d2e3f4-a5b6-4c7d-8e9f-0a1b2c3d4e5f', 1960, 'a1b2c3d4-e5f6-4a7b-8c9d-0e1f2a3b4c5d'),
       ('f1a2b3c4-d5e6-4f7a-8b9c-0d1e2f3a4b5c', 'Physics Lab', 'Laboratory', '2c3d4e5f-6a7b-8c9d-0e1f-2a3b4c5d6e7f',
        'd1e2f3a4-b5c6-4d7e-8f9a-0b1c2d3e4f5a', 1950, 'b1c2d3e4-f5a6-4b7c-9d0e-1f2a3b4c5d6e');

INSERT INTO researcher (id, first_name, last_name, degree, university_id, institute_id)
VALUES ('7e4f6c8a-1b2d-4e3f-9a6c-0b1d2e3f4a5c', 'Alice', 'Smith', 'PhD', 'c1d2e3f4-a5b6-4c7d-8e9f-0a1b2c3d4e5f',
        'e1f2a3b4-c5d6-4e7f-8a9b-0c1d2e3f4a5b'),
       ('8f5a7d9b-2c3e-5f4a-0b7d-1c2e3f4a5b6d', 'Bob', 'Johnson', 'MSc', 'd1e2f3a4-b5c6-4d7e-8f9a-0b1c2d3e4f5a',
        'f1a2b3c4-d5e6-4f7a-8b9c-0d1e2f3a4b5c'),
       ('9a6b8e0c-3d4f-6a5b-1c8e-2d3f4a5b6c7e', 'Carol', 'Williams', 'PhD', 'c1d2e3f4-a5b6-4c7d-8e9f-0a1b2c3d4e5f',
        'e1f2a3b4-c5d6-4e7f-8a9b-0c1d2e3f4a5b'),
       ('ab7c9f1d-4e5f-7b6c-2d9f-3e4a5b6c7d8f', 'Dave', 'Brown', 'MSc', 'd1e2f3a4-b5c6-4d7e-8f9a-0b1c2d3e4f5a',
        'f1a2b3c4-d5e6-4f7a-8b9c-0d1e2f3a4b5c'),
       ('bc8d0a2e-5f6a-8c7d-3e0a-4f5b6c7d8e9f', 'Eve', 'Davis', 'PhD', 'c1d2e3f4-a5b6-4c7d-8e9f-0a1b2c3d4e5f',
        'e1f2a3b4-c5d6-4e7f-8a9b-0c1d2e3f4a5b');

INSERT INTO "user" (id, username, email, password_hash, researcher_id)
VALUES
    ('9f3e1d4a-1c4e-4f2b-8f2b-0a5f8c9d1a11', 'alice', 'alice@example.com', 'hash1', '7e4f6c8a-1b2d-4e3f-9a6c-0b1d2e3f4a5c'),
    ('2d7f6b3e-7c4a-4d8c-9b0d-2f3e5a6c7b88', 'bob', 'bob@example.com', 'hash2', '8f5a7d9b-2c3e-5f4a-0b7d-1c2e3f4a5b6d'),
    ('5b1a8c9d-3d6f-4b2e-8e1f-1c2d3e4f5a66', 'carol', 'carol@example.com', 'hash3', '9a6b8e0c-3d4f-6a5b-1c8e-2d3f4a5b6c7e'),
    ('8c2e1d4f-6b3a-4c9e-8f1a-3b4d5e6f7a77', 'dave', 'dave@example.com', 'hash4', 'ab7c9f1d-4e5f-7b6c-2d9f-3e4a5b6c7d8f'),
    ('1a3b5c7d-2e4f-4d6a-8c1b-5f2e3d4a6b88', 'eve', 'eve@example.com', 'hash5', 'bc8d0a2e-5f6a-8c7d-3e0a-4f5b6c7d8e9f'),
    ('4d5e6f7a-1b2c-4e3f-8d5b-6c7e8f9a0b11', 'frank', 'frank@example.com', 'hash6', '7e4f6c8a-1b2d-4e3f-9a6c-0b1d2e3f4a5c'),
    ('7b8c9d0e-3f4a-4b5c-9e2f-7d8a9b0c1d22', 'grace', 'grace@example.com', 'hash7', '8f5a7d9b-2c3e-5f4a-0b7d-1c2e3f4a5b6d'),
    ('0e1f2d3c-4b5a-4c6d-8f3e-8a9b0c1d2e33', 'heidi', 'heidi@example.com', 'hash8', '9a6b8e0c-3d4f-6a5b-1c8e-2d3f4a5b6c7e'),
    ('3a4b5c6d-7e8f-4a1b-9c2d-9b0c1d2e3f44', 'ivan', 'ivan@example.com', 'hash9', 'ab7c9f1d-4e5f-7b6c-2d9f-3e4a5b6c7d8f'),
    ('6c7d8e9f-0a1b-4c2d-8e3f-0d1a2b3c4f55', 'judy', 'judy@example.com', 'hash10', 'bc8d0a2e-5f6a-8c7d-3e0a-4f5b6c7d8e9f');

INSERT INTO "role" (id, name, description)
VALUES ('a1b2c3d4-e5f6-4a7b-8c9d-0e1f2a3b4c5d', 'Admin', 'Administrator role'),
       ('b2c3d4e5-f6a7-4b8c-9d0e-1f2a3b4c5d6e', 'Editor', 'Editor role'),
       ('c3d4e5f6-a7b8-4c9d-0e1f-2a3b4c5d6e7f', 'Viewer', 'Viewer role'),
       ('d4e5f6a7-b8c9-4d0e-1f2a-3b4c5d6e7f8a', 'Manager', 'Manager role'),
       ('e5f6a7b8-c9d0-4e1f-2a3b-4c5d6e7f8a9b', 'Contributor', 'Contributor role');

INSERT INTO "permission" (id, name, description)
VALUES ('11111111-aaaa-1111-aaaa-111111111111', 'READ', 'Permission to read'),
       ('22222222-bbbb-2222-bbbb-222222222222', 'CREATE', 'Permission to create'),
       ('33333333-cccc-3333-cccc-333333333333', 'UPDATE', 'Permission to update'),
       ('44444444-dddd-4444-dddd-444444444444', 'DELETE', 'Permission to delete'),
       ('55555555-eeee-5555-eeee-555555555555', 'MANAGE_USERS', 'Permission to manage users'),
       ('66666666-ffff-6666-ffff-666666666666', 'MANAGE_ROLES', 'Permission to manage roles');

INSERT INTO "user_role" (user_id, role_id)
VALUES ('9f3e1d4a-1c4e-4f2b-8f2b-0a5f8c9d1a11', 'a1b2c3d4-e5f6-4a7b-8c9d-0e1f2a3b4c5d'), -- Alice -> Admin
       ('2d7f6b3e-7c4a-4d8c-9b0d-2f3e5a6c7b88', 'b2c3d4e5-f6a7-4b8c-9d0e-1f2a3b4c5d6e'), -- Bob -> Editor
       ('5b1a8c9d-3d6f-4b2e-8e1f-1c2d3e4f5a66', 'c3d4e5f6-a7b8-4c9d-0e1f-2a3b4c5d6e7f'), -- Carol -> Viewer
       ('8c2e1d4f-6b3a-4c9e-8f1a-3b4d5e6f7a77', 'd4e5f6a7-b8c9-4d0e-1f2a-3b4c5d6e7f8a'), -- Dave -> Manager
       ('1a3b5c7d-2e4f-4d6a-8c1b-5f2e3d4a6b88', 'e5f6a7b8-c9d0-4e1f-2a3b-4c5d6e7f8a9b'), -- Eve -> Contributor
       ('4d5e6f7a-1b2c-4e3f-8d5b-6c7e8f9a0b11', 'b2c3d4e5-f6a7-4b8c-9d0e-1f2a3b4c5d6e'), -- Frank -> Editor
       ('7b8c9d0e-3f4a-4b5c-9e2f-7d8a9b0c1d22', 'c3d4e5f6-a7b8-4c9d-0e1f-2a3b4c5d6e7f'), -- Grace -> Viewer
       ('0e1f2d3c-4b5a-4c6d-8f3e-8a9b0c1d2e33', 'd4e5f6a7-b8c9-4d0e-1f2a-3b4c5d6e7f8a'), -- Heidi -> Manager
       ('3a4b5c6d-7e8f-4a1b-9c2d-9b0c1d2e3f44', 'e5f6a7b8-c9d0-4e1f-2a3b-4c5d6e7f8a9b'), -- Ivan -> Contributor
       ('6c7d8e9f-0a1b-4c2d-8e3f-0d1a2b3c4f55', 'a1b2c3d4-e5f6-4a7b-8c9d-0e1f2a3b4c5d');

INSERT INTO "role_permission" (role_id, permission_id)
VALUES
-- Admin: all permissions
('a1b2c3d4-e5f6-4a7b-8c9d-0e1f2a3b4c5d', '11111111-aaaa-1111-aaaa-111111111111'),
('a1b2c3d4-e5f6-4a7b-8c9d-0e1f2a3b4c5d', '22222222-bbbb-2222-bbbb-222222222222'),
('a1b2c3d4-e5f6-4a7b-8c9d-0e1f2a3b4c5d', '33333333-cccc-3333-cccc-333333333333'),
('a1b2c3d4-e5f6-4a7b-8c9d-0e1f2a3b4c5d', '44444444-dddd-4444-dddd-444444444444'),
('a1b2c3d4-e5f6-4a7b-8c9d-0e1f2a3b4c5d', '55555555-eeee-5555-eeee-555555555555'),
('a1b2c3d4-e5f6-4a7b-8c9d-0e1f2a3b4c5d', '66666666-ffff-6666-ffff-666666666666'),

-- Editor: READ, CREATE, UPDATE
('b2c3d4e5-f6a7-4b8c-9d0e-1f2a3b4c5d6e', '11111111-aaaa-1111-aaaa-111111111111'),
('b2c3d4e5-f6a7-4b8c-9d0e-1f2a3b4c5d6e', '22222222-bbbb-2222-bbbb-222222222222'),
('b2c3d4e5-f6a7-4b8c-9d0e-1f2a3b4c5d6e', '33333333-cccc-3333-cccc-333333333333'),

-- Viewer: READ only
('c3d4e5f6-a7b8-4c9d-0e1f-2a3b4c5d6e7f', '11111111-aaaa-1111-aaaa-111111111111'),

-- Manager: READ, UPDATE, MANAGE_USERS
('d4e5f6a7-b8c9-4d0e-1f2a-3b4c5d6e7f8a', '11111111-aaaa-1111-aaaa-111111111111'),
('d4e5f6a7-b8c9-4d0e-1f2a-3b4c5d6e7f8a', '33333333-cccc-3333-cccc-333333333333'),
('d4e5f6a7-b8c9-4d0e-1f2a-3b4c5d6e7f8a', '55555555-eeee-5555-eeee-555555555555'),

-- Contributor: READ, CREATE
('e5f6a7b8-c9d0-4e1f-2a3b-4c5d6e7f8a9b', '11111111-aaaa-1111-aaaa-111111111111'),
('e5f6a7b8-c9d0-4e1f-2a3b-4c5d6e7f8a9b', '22222222-bbbb-2222-bbbb-222222222222');
