INSERT INTO countries (name, continent)
VALUES ('United Kingdom', 'Europe'),
       ('United States', 'North America'),
       ('France', 'Europe'),
       ('Germany', 'Europe'),
       ('Russia', 'Europe/Asia');

INSERT INTO authors (created_at, updated_at, name, surname, country_id)
VALUES (NOW(), NOW(), 'George', 'Orwell', 1),
       (NOW(), NOW(), 'Ernest', 'Hemingway', 2),
       (NOW(), NOW(), 'Victor', 'Hugo', 3),
       (NOW(), NOW(), 'Johann', 'Goethe', 4),
       (NOW(), NOW(), 'Leo', 'Tolstoy', 5);

INSERT INTO books (created_at, updated_at, name, category, author_id, state, available_copies)
VALUES (NOW(), NOW(), '1984', 'NOVEL', 1, 'GOOD', 5),
       (NOW(), NOW(), 'Animal Farm', 'CLASSICS', 1, 'GOOD', 3),
       (NOW(), NOW(), 'The Old Man and the Sea', 'NOVEL', 2, 'GOOD', 4),
       (NOW(), NOW(), 'Les Miserables', 'DRAMA', 3, 'GOOD', 2),
       (NOW(), NOW(), 'Faust', 'CLASSICS', 4, 'BAD', 1),
       (NOW(), NOW(), 'War and Peace', 'HISTORY', 5, 'GOOD', 6);