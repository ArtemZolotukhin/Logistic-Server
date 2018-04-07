DROP TABLE IF EXISTS users CASCADE;
DROP TABLE IF EXISTS user_tokens CASCADE;

GRANT SELECT ON ALL TABLES IN SCHEMA public TO logistic_admin;

CREATE TABLE users(
    id BIGSERIAL,
    phone_number VARCHAR(16),
    email VARCHAR(256),
    role VARCHAR(32),
    password_crypted VARCHAR(64),
    first_name VARCHAR(32),
    second_name VARCHAR(32),
    CONSTRAINT pk_users PRIMARY KEY (id)
);

CREATE TABLE user_tokens(
    id BIGSERIAL,
    token VARCHAR(64),
    user_id BIGINT,
    CONSTRAINT fk_user_tokens_users FOREIGN KEY (user_id) REFERENCES users(id) ON DELETE CASCADE,
    CONSTRAINT pk_user_tokens PRIMARY KEY (user_id)
);
