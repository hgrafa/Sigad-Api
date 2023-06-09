CREATE TABLE classes (
     id BIGINT AUTO_INCREMENT PRIMARY KEY,
     codigo BIGINT,
     nome VARCHAR(255),
     prazo_corrente VARCHAR(255),
     prazo_intermediaria VARCHAR(255),
     observacao VARCHAR(255),
     indicador_ativa VARCHAR(255),
     permissao_de_uso VARCHAR(255),
     destinacao_final VARCHAR(255),
     sigilo VARCHAR(255),
     grau_sigilo VARCHAR(255)
);

CREATE TABLE subclasses (
         id BIGINT AUTO_INCREMENT PRIMARY KEY,
         nome VARCHAR(255),
         codigo BIGINT,
         permissao_de_uso VARCHAR(255),
         prazo_corrente VARCHAR(255),
         prazo_intermediaria VARCHAR(255),
         destinacao_final VARCHAR(255),
         sigilo VARCHAR(255),
         grau_sigilo VARCHAR(255),
         indicador_ativa BOOLEAN,
         observacao VARCHAR(255),
         classe_id BIGINT,
         FOREIGN KEY (classe_id) REFERENCES classes(id)
);


CREATE TABLE grupos (
        id BIGINT AUTO_INCREMENT PRIMARY KEY,
        nome VARCHAR(255),
        codigo BIGINT,
        prazo_intermediaria VARCHAR(255),
        prazo_corrente VARCHAR(255),
        indicador_ativa BOOLEAN,
        observacao VARCHAR(255),
        permissao_de_uso VARCHAR(255),
        destinacao_final VARCHAR(255),
        sigilo VARCHAR(255),
        grau_sigilo VARCHAR(255),
        subclasse_id BIGINT,
        FOREIGN KEY (subclasse_id) REFERENCES subclasses(id)
);

CREATE TABLE subgrupos (
        id BIGINT AUTO_INCREMENT PRIMARY KEY,
        codigo BIGINT,
        nome VARCHAR(255),
        prazo_corrente VARCHAR(255),
        prazo_intermediaria VARCHAR(255),
        indicador_ativa BOOLEAN,
        observacao VARCHAR(255),
        permissao_de_uso VARCHAR(255),
        destinacao_final VARCHAR(255),
        sigilo VARCHAR(255),
        grau_sigilo VARCHAR(255),
        grupo_id BIGINT,
        FOREIGN KEY (grupo_id) REFERENCES grupos(id)
);
