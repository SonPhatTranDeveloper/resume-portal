/* Insert skill */
INSERT INTO
    my_user (id, username, password, roles, active, updated)
VALUES
    (1, 'user1', 'password1', 'USER', FALSE, TRUE),
    (2, 'user2', 'password2', 'USER', FALSE, TRUE);

/* Inset education */
INSERT INTO
    education (id, my_user_id, university, degree, details, period)
VALUES
    (1, 1, 'Australian National University', 'Master of Computing', 'Extracurricular', 'Dec 2024');

/* Insert skill */
INSERT INTO
    skill (id, my_user_id, name)
VALUES
    (1, 1, 'Web Programming'),
    (2, 1, 'Data Science');