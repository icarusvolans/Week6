DROP TABLE IF EXISTS signrequest;

CREATE TABLE signrequest  (
    id Bigserial PRIMARY KEY NOT NULL,
    launch_date VARCHAR(20),
    program VARCHAR(50),
    department VARCHAR(20),
    deliverable VARCHAR(50),
    copy TEXT
);