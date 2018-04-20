DROP TABLE IF EXISTS users CASCADE;
DROP TABLE IF EXISTS user_tokens CASCADE;
DROP TABLE IF EXISTS storages CASCADE;
DROP TABLE IF EXISTS packages CASCADE;
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
    country VARCHAR(32),
    city VARCHAR(32),
    CONSTRAINT pk_storages PRIMARY KEY (id),
    CONSTRAINT fk_storages_storages FOREIGN KEY (dependency) REFERENCES storages(id) ON DELETE SET NULL
);

CREATE TABLE packages(
    id BIGSERIAL,
    volume REAL,
    consumer_phone VARCHAR(16),
    status VARCHAR(32),
    date_unix BIGINT,
    location BIGINT,
    destination BIGINT,
    source BIGINT,
    CONSTRAINT pk_packages PRIMARY KEY (id),
    CONSTRAINT fk_packages_storages_location FOREIGN KEY (location) REFERENCES storages(id) ON DELETE SET NULL,
    CONSTRAINT fk_packages_storages_destination FOREIGN KEY (destination) REFERENCES storages(id) ON DELETE SET NULL,
    CONSTRAINT fk_packages_storages_source FOREIGN KEY (source) REFERENCES storages(id) ON DELETE SET NULL
);

CREATE TABLE acceptor_info(
    id BIGSERIAL,
    user_id BIGINT,
    storage_id BIGINT,
    CONSTRAINT pk_acceptor_info PRIMARY KEY(id),
    CONSTRAINT fk_acceptor_info_users FOREIGN KEY (user_id) REFERENCES users(id) ON DELETE CASCADE,
    CONSTRAINT fk_acceptor_info_storages FOREIGN KEY(storage_id) REFERENCES storages(id) ON DELETE CASCADE
);

INSERT INTO users (phone_number, email, role, password_crypted, first_name, second_name, country, city) VALUES ('12345678901', 'admin@mail.com', 'ADMIN', '654de93590ab375d18afa10459c40a48', 'Ad', 'Min', 'Russia', 'Kazan');
INSERT INTO storages (name, address, lat, lon, country, city) VALUES ('Test point', 'Kakaya-to ylitsa', 55.788, 49.122, 'Russia', 'Kazan');
INSERT INTO storages (name, address, lat, lon, country, city) VALUES ('Test point2', 'Kakayacwcwwcwto ylitsa', 55.766, 49.144, 'Russia', 'Kazan');
INSERT INTO users (phone_number, email, role, password_crypted, first_name, second_name, country, city) VALUES ('12312312311', 'acceptor@mail.com', 'ACCEPTOR', '654de93590ab375d18afa10459c40a48', 'Ivan', 'ivanov', 'Russia', 'Kazan' );
INSERT INTO acceptor_info(user_id, storage_id) VALUES ((SELECT id FROM users WHERE first_name='Ivan'), (SELECT id FROM storages WHERE name='Test point'));

