CREATE VIEW popular_authors_view AS
SELECT
    a.id AS author_id,
    CONCAT(a.name, ' ', a.surname) AS author_full_name,
    COALESCE(SUM(b.rent_count), 0) AS total_rentals
FROM authors a
         LEFT JOIN books b ON b.author_id = a.id
GROUP BY a.id, a.name, a.surname;