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
('a1c1e111-1111-4aaa-8aaa-000000000001', 'it_admin_1', 'it_admin_1@example.com', '$2a$12$u8eJkT5S4FvW/1ZVf9WvMetTCAMKXiaxZx369cR8y9GRUeenXuKiK', NULL),
('a1c1e111-1111-4aaa-8aaa-000000000002', 'it_admin_2', 'it_admin_2@example.com', '$2a$12$u8eJkT5S4FvW/1ZVf9WvMetTCAMKXiaxZx369cR8y9GRUeenXuKiK', NULL),

-- MINISTRY
('a1c1e111-2222-4aaa-8aaa-000000000001', 'ministry_1', 'ministry_1@example.com', '$2a$12$u8eJkT5S4FvW/1ZVf9WvMetTCAMKXiaxZx369cR8y9GRUeenXuKiK', NULL),
('a1c1e111-2222-4aaa-8aaa-000000000002', 'ministry_2', 'ministry_2@example.com', '$2a$12$u8eJkT5S4FvW/1ZVf9WvMetTCAMKXiaxZx369cR8y9GRUeenXuKiK', NULL),

-- UNIVERSITY
('a1c1e111-3333-4aaa-8aaa-000000000001', 'university_1', 'university_1@example.com', '$2a$12$u8eJkT5S4FvW/1ZVf9WvMetTCAMKXiaxZx369cR8y9GRUeenXuKiK', NULL),
('a1c1e111-3333-4aaa-8aaa-000000000002', 'university_2', 'university_2@example.com', '$2a$12$u8eJkT5S4FvW/1ZVf9WvMetTCAMKXiaxZx369cR8y9GRUeenXuKiK', NULL),

-- ACADEMY_INSTITUTE
('a1c1e111-4444-4aaa-8aaa-000000000001', 'academy_1', 'academy_1@example.com', '$2a$12$u8eJkT5S4FvW/1ZVf9WvMetTCAMKXiaxZx369cR8y9GRUeenXuKiK', NULL),
('a1c1e111-4444-4aaa-8aaa-000000000002', 'academy_2', 'academy_2@example.com', '$2a$12$u8eJkT5S4FvW/1ZVf9WvMetTCAMKXiaxZx369cR8y9GRUeenXuKiK', NULL),

-- DEPARTMENT_UNIT
('a1c1e111-5555-4aaa-8aaa-000000000001', 'department_1', 'department_1@example.com', '$2a$12$u8eJkT5S4FvW/1ZVf9WvMetTCAMKXiaxZx369cR8y9GRUeenXuKiK', NULL),
('a1c1e111-5555-4aaa-8aaa-000000000002', 'department_2', 'department_2@example.com', '$2a$12$u8eJkT5S4FvW/1ZVf9WvMetTCAMKXiaxZx369cR8y9GRUeenXuKiK', NULL),

-- PUBLIC_USER
('a1c1e111-6666-4aaa-8aaa-000000000001', 'public_1', 'public_1@example.com', '$2a$12$u8eJkT5S4FvW/1ZVf9WvMetTCAMKXiaxZx369cR8y9GRUeenXuKiK', NULL),
('a1c1e111-6666-4aaa-8aaa-000000000002', 'public_2', 'public_2@example.com', '$2a$12$u8eJkT5S4FvW/1ZVf9WvMetTCAMKXiaxZx369cR8y9GRUeenXuKiK', NULL),

-- AUDITOR
('a1c1e111-7777-4aaa-8aaa-000000000001', 'auditor_1', 'auditor_1@example.com', '$2a$12$u8eJkT5S4FvW/1ZVf9WvMetTCAMKXiaxZx369cR8y9GRUeenXuKiK', NULL),
('a1c1e111-7777-4aaa-8aaa-000000000002', 'auditor_2', 'auditor_2@example.com', '$2a$12$u8eJkT5S4FvW/1ZVf9WvMetTCAMKXiaxZx369cR8y9GRUeenXuKiK', NULL),

-- MODERATOR
('a1c1e111-8888-4aaa-8aaa-000000000001', 'moderator_1', 'moderator_1@example.com', '$2a$12$u8eJkT5S4FvW/1ZVf9WvMetTCAMKXiaxZx369cR8y9GRUeenXuKiK', NULL),
('a1c1e111-8888-4aaa-8aaa-000000000002', 'moderator_2', 'moderator_2@example.com', '$2a$12$u8eJkT5S4FvW/1ZVf9WvMetTCAMKXiaxZx369cR8y9GRUeenXuKiK', NULL);

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

INSERT INTO "role_permission" (role_id, permission_id) VALUES

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
