DROP TABLE IF EXISTS sign_request;

CREATE TABLE sign_request  (
    id bigint PRIMARY KEY NOT NULL,
    launch_date VARCHAR(20),
    program VARCHAR(50),
    department VARCHAR(50),
    deliverable VARCHAR,
    copy TEXT,
    edit_deliverable TEXT,
    edit_copy TEXT,
    flagged_deleted BOOLEAN,
    username VARCHAR,
    edit_date_time TIMESTAMP
);

/*
DROP TABLE IF EXISTS edit_request;

CREATE TABLE edit_request (
    id int PRIMARY KEY NOT NULL,
    TAG VARCHAR(1024) NOT NULL,
    TS TIMESTAMP NOT NULL
);*/
