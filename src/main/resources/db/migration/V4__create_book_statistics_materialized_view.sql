CREATE MATERIALIZED VIEW book_statistics_mv AS
SELECT
    b.category AS category,
    COUNT(*) AS total_books,
    COALESCE(SUM(b.available_copies), 0) AS total_available_copies,
    COUNT(*) FILTER (WHERE b.state <> 'GOOD') AS books_not_in_good_condition
FROM books b
GROUP BY b.category;