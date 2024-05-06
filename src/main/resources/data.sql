INSERT INTO
    my_user (id, username, password, roles, active, updated)
VALUES
    (1, 'user1', 'password1', 'USER', FALSE, TRUE),
    (2, 'user2', 'password2', 'USER', FALSE, TRUE);

INSERT INTO
    education (id, my_user_id, university, degree, details, period)
VALUES
    (1, 1, 'Australian National University', 'Master of Computing', 'Extracurricular', 'Dec 2024');