CREATE TABLE countries
(
    id        BIGSERIAL PRIMARY KEY,
    name      VARCHAR(100) NOT NULL,
    continent VARCHAR(100) NOT NULL
);

CREATE TABLE authors
(
    id         BIGSERIAL PRIMARY KEY,
    created_at TIMESTAMP    NOT NULL,
    updated_at TIMESTAMP    NOT NULL,
    name       VARCHAR(100) NOT NULL,
    surname    VARCHAR(100) NOT NULL,
    country_id BIGINT       NOT NULL,
    CONSTRAINT fk_authors_country
        FOREIGN KEY (country_id)
            REFERENCES countries (id)
);

CREATE TABLE books
(
    id               BIGSERIAL PRIMARY KEY,
    created_at       TIMESTAMP    NOT NULL,
    updated_at       TIMESTAMP    NOT NULL,
    name             VARCHAR(255) NOT NULL,
    category         VARCHAR(50)  NOT NULL,
    author_id        BIGINT       NOT NULL,
    state            VARCHAR(50)  NOT NULL,
    available_copies INTEGER      NOT NULL CHECK (available_copies >= 0),
    CONSTRAINT fk_books_author
        FOREIGN KEY (author_id)
            REFERENCES authors (id)
);