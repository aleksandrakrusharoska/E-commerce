CREATE TABLE IF NOT EXISTS users (
                                     username VARCHAR(255) PRIMARY KEY,
    password VARCHAR(255) NOT NULL,
    name VARCHAR(255),
    surname VARCHAR(255),
    role VARCHAR(50) NOT NULL
    );

-- admin / admin123 (BCrypt)
INSERT INTO users (username, password, name, surname, role) VALUES
    ('admin', '$2b$10$PP8WsD8p0S.WL.uU0rxg1ePqzRKq9Z.UdVxFazLiXxQxYj8SPNG7K', 'Admin', 'User', 'ROLE_ADMIN')
    ON CONFLICT (username) DO NOTHING;