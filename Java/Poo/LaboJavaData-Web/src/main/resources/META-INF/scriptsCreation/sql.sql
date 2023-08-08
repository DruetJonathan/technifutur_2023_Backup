CREATE TABLE utilisateur
(
    id           SERIAL PRIMARY KEY,
    nom          VARCHAR(50)  NOT NULL,
    mot_de_passe VARCHAR(255) NOT NULL,
    email        VARCHAR(255) NOT NULL
);
CREATE TABLE moto
(
    id            SERIAL PRIMARY KEY,
    nom           VARCHAR(50)                                  NOT NULL,
    description   VARCHAR(1500)                                NOT NULL,
    apercu_rapide VARCHAR(1500)                                NOT NULL,
    prix          INTEGER CHECK (prix >= 0 AND prix <= 999999) NOT NULL
);
CREATE TABLE achat
(
    id             SERIAL PRIMARY KEY,
    utilisateur_id INTEGER REFERENCES utilisateur (id),
    moto_id        INTEGER REFERENCES moto (id),
    date_achat     DATE
);
ALTER TABLE achat
    ADD CONSTRAINT fk_utilisateur FOREIGN KEY (utilisateur_id) REFERENCES utilisateur (id);
ALTER TABLE achat
    ADD CONSTRAINT fk_moto FOREIGN KEY (moto_id) REFERENCES moto (id);
alter table public.utilisateur
    add second_nom varchar(50) not null;
ALTER TABLE Utilisateur ADD CONSTRAINT UK_email UNIQUE (email);
