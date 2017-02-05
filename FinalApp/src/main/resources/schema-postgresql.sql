DROP TABLE IF EXISTS sign_request;

CREATE TABLE sign_request  (
    id Bigserial PRIMARY KEY NOT NULL,
    launch_date VARCHAR(20),
    program VARCHAR(50),
    department VARCHAR(50),
    deliverable VARCHAR,
    copy TEXT
);