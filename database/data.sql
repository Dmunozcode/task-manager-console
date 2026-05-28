INSERT INTO users (name , email)
VALUES
('Daniel', 'daniel@example.com'),
('Ana', 'ana@example.com');

INSERT INTO tasks (title, description, completed, user_id)
VALUES
('Study SQL', 'Practice CREATE, INSERT and SELECT', false, 1),
('Review Java', 'Practice ArrayList and classes', true, 1),
('Practice Git', 'Create branches and commits', false, 2);