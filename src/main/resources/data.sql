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
    (1, 1, 'Australian National University', 'Master of Computing', 'First Class Honors. Vice Chancellor Scholarship', 'Dec 2024'),
    (2, 1, 'RMIT', 'Bachelor of IT', 'First Class Honors. Won competitions.', 'Dec 2024');

/* Insert skill */
INSERT INTO
    skill (id, my_user_id, name)
VALUES
    (1, 1, 'Web Programming'),
    (2, 1, 'Data Science');

/* Insert experience */
INSERT INTO
    experience (id, my_user_id, company, title, description, period)
VALUES
    (1, 1, 'Asia Commercial Bank', 'AI Engineer', 'Lead AI development', 'Feb 2022 - Dec 2022');