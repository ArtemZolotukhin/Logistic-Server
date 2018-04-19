DROP TABLE IF EXISTS users CASCADE;
DROP TABLE IF EXISTS user_tokens CASCADE;
DROP TABLE IF EXISTS storages CASCADE;

CREATE TABLE users(
    id BIGSERIAL,
    phone_number VARCHAR(16),
    email VARCHAR(256),
    role VARCHAR(32),
    password_crypted VARCHAR(64),
    first_name VARCHAR(32),
    second_name VARCHAR(32),
    country VARCHAR(32),
    city VARCHAR(32),
    CONSTRAINT pk_users PRIMARY KEY(id)
);

CREATE TABLE user_tokens(
    id BIGSERIAL,
    token VARCHAR(64),
    user_id BIGINT,
    CONSTRAINT fk_user_tokens_users FOREIGN KEY (user_id) REFERENCES users(id) ON DELETE CASCADE,
    CONSTRAINT pk_user_tokens PRIMARY KEY (user_id)
);

CREATE TABLE storages(
    id BIGSERIAL,
    name VARCHAR(64),
    address VARCHAR(256),
    dependency BIGINT,
    lat REAL,
    lon REAL,
    CONSTRAINT pk_storages PRIMARY KEY (id),
    CONSTRAINT fk_storages_storages FOREIGN KEY (dependency) REFERENCES storages(id) ON DELETE SET NULL
);

INSERT INTO users (phone_number, email, role, password_crypted, first_name, second_name, country, city) VALUES ('12345678901', 'admin@mail.com', 'ADMIN', '654de93590ab375d18afa10459c40a48', 'Ad', 'Min', 'Russia', 'Kazan');
