-- 1. Usuários
CREATE TABLE tb_users (
                          id BIGINT AUTO_INCREMENT PRIMARY KEY,
                          name VARCHAR(255) NOT NULL,
                          email VARCHAR(255) NOT NULL,
                          password VARCHAR(255) NOT NULL,
                          role VARCHAR(50) NOT NULL,

                          CONSTRAINT uk_tb_users_email UNIQUE (email)
);


-- 2. Métodos
CREATE TABLE method (
                        id BIGINT AUTO_INCREMENT PRIMARY KEY,
                        name VARCHAR(255) NOT NULL
);


-- 3. Casos
CREATE TABLE cases (
                       id BIGINT AUTO_INCREMENT PRIMARY KEY,
                       name VARCHAR(255) NOT NULL,
                       state_id BIGINT NOT NULL,
                       method_id BIGINT NOT NULL,

                       CONSTRAINT fk_cases_method
                           FOREIGN KEY (method_id)
                               REFERENCES method (id)
                               ON DELETE CASCADE
);


-- 4. Algoritmos
CREATE TABLE algorithm (
                           id BIGINT AUTO_INCREMENT PRIMARY KEY,
                           user_id BIGINT NOT NULL,
                           case_id BIGINT NOT NULL,
                           moves VARCHAR(32) NOT NULL,

                           CONSTRAINT fk_algorithm_user
                               FOREIGN KEY (user_id)
                                   REFERENCES tb_users (id)
                                   ON DELETE CASCADE,

                           CONSTRAINT fk_algorithm_case
                               FOREIGN KEY (case_id)
                                   REFERENCES cases (id)
                                   ON DELETE CASCADE
);


-- 5. Índices
CREATE INDEX idx_cases_method_id
    ON cases (method_id);

CREATE INDEX idx_algorithm_user_id
    ON algorithm (user_id);

CREATE INDEX idx_algorithm_case_id
    ON algorithm (case_id);