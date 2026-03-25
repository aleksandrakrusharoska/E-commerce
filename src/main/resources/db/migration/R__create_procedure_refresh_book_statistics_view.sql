CREATE OR REPLACE PROCEDURE refresh_book_statistics_view()
LANGUAGE SQL
AS $$
    REFRESH MATERIALIZED VIEW book_statistics_view;
$$;