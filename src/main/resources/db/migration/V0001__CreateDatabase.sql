
CREATE TABLE application_user
(
    id       INT8 PRIMARY KEY,
    email    VARCHAR(50) NOT NULL,
    username    VARCHAR(50) NOT NULL,
    password VARCHAR(50) NOT NULL
);

CREATE TABLE degree
(
    id   INT8 PRIMARY KEY,
    name VARCHAR(50) NOT NULL
);

CREATE TABLE period
(
    id   INT8 PRIMARY KEY,
    name VARCHAR(50) NOT NULL
);

CREATE TABLE admin
(
    id                  INT8 PRIMARY KEY,
    application_user_id INT8,
    name                VARCHAR(50) NOT NULL,
    CONSTRAINT fk_admin_application_user
        FOREIGN KEY (application_user_id)
            REFERENCES application_user (id)
);

CREATE TABLE student
(
    id                  INT8 PRIMARY KEY,
    application_user_id INT8,
    name                VARCHAR(50) NOT NULL,
    CONSTRAINT fk_student_application_user
        FOREIGN KEY (application_user_id)
            REFERENCES application_user (id)
);

CREATE TABLE professor
(
    id   INT8 PRIMARY KEY,
    name VARCHAR(50) NOT NULL,
    application_user_id INT8,
    CONSTRAINT fk_professor_application_user
        FOREIGN KEY (application_user_id)
            REFERENCES application_user (id)
);

CREATE TABLE classroom
(
    id         INT8 PRIMARY KEY,
    identifier VARCHAR(10) NOT NULL,
    degree_id  INT8,
    CONSTRAINT fk_classroom_degree
        FOREIGN KEY (degree_id)
            REFERENCES degree (id)
);

CREATE TABLE subject
(
    id        INT8 PRIMARY KEY,
    name      VARCHAR(50) NOT NULL,
    degree_id INT8,
    CONSTRAINT fk_subject_degree
        FOREIGN KEY (degree_id)
            REFERENCES degree (id)
);

CREATE TABLE subject_professor
(
    subject_id   INT8,
    professor_id INT8,
    CONSTRAINT fk_professor_subject
        FOREIGN KEY (professor_id)
            REFERENCES professor (id),
    CONSTRAINT fk_subject_professor
        FOREIGN KEY (subject_id)
            REFERENCES subject (id)
);

CREATE TABLE report
(
    id         INT8 PRIMARY KEY,
    student_id INT8,
    period_id  INT8,
    CONSTRAINT fk_report_student
        FOREIGN KEY (student_id)
            REFERENCES student (id),
    CONSTRAINT fk_report_period
        FOREIGN KEY (period_id)
            REFERENCES period (id)
);

CREATE TABLE average
(
    id         INT8 PRIMARY KEY,
    value      numeric,
    subject_id INT8,
    report_id  INT8,
    CONSTRAINT fk_average_subject
        FOREIGN KEY (subject_id)
            REFERENCES subject (id),
    CONSTRAINT fk_average_report
        FOREIGN KEY (report_id)
            REFERENCES report
);

CREATE TABLE grade
(
    id         INT8 PRIMARY KEY,
    average_id INT8,
    name       VARCHAR(50) NOT NULL,
    value      numeric,
    CONSTRAINT fk_grade_average
        FOREIGN KEY (average_id)
            REFERENCES average (id)
);

-- ==============[Hibernate Sequence]==============

CREATE SEQUENCE hibernate_sequence
    INCREMENT BY 1
    MINVALUE 1
    MAXVALUE 9223372036854775807
    START 11834992
    CACHE 1
    NO CYCLE;

ALTER SEQUENCE hibernate_sequence OWNER TO postgres;
GRANT ALL ON SEQUENCE hibernate_sequence to postgres;

-- ==============[Admin Sequence]==============

CREATE SEQUENCE admin_pk_seq
    INCREMENT BY 1
    MINVALUE 1
    MAXVALUE 9223372036854775807
    CACHE 1
    NO CYCLE;

ALTER SEQUENCE admin_pk_seq OWNER TO postgres;
GRANT ALL ON SEQUENCE admin_pk_seq to postgres;

-- ==============[Application User Sequence]==============

CREATE SEQUENCE application_user_pk_seq
    INCREMENT BY 1
    MINVALUE 1
    MAXVALUE 9223372036854775807
    CACHE 1
    NO CYCLE;

ALTER SEQUENCE application_user_pk_seq OWNER TO postgres;
GRANT ALL ON SEQUENCE application_user_pk_seq to postgres;


-- ==============[Average Sequence]==============

CREATE SEQUENCE average_pk_seq
    INCREMENT BY 1
    MINVALUE 1
    MAXVALUE 9223372036854775807
    CACHE 1
    NO CYCLE;

ALTER SEQUENCE average_pk_seq OWNER TO postgres;
GRANT ALL ON SEQUENCE average_pk_seq to postgres;


-- ==============[Classroom Sequence]==============

CREATE SEQUENCE classroom_pk_seq
    INCREMENT BY 1
    MINVALUE 1
    MAXVALUE 9223372036854775807
    CACHE 1
    NO CYCLE;

ALTER SEQUENCE classroom_pk_seq OWNER TO postgres;
GRANT ALL ON SEQUENCE classroom_pk_seq to postgres;


-- ==============[Degree Sequence]==============

CREATE SEQUENCE degree_pk_seq
    INCREMENT BY 1
    MINVALUE 1
    MAXVALUE 9223372036854775807
    CACHE 1
    NO CYCLE;

ALTER SEQUENCE degree_pk_seq OWNER TO postgres;
GRANT ALL ON SEQUENCE degree_pk_seq to postgres;

-- ==============[Grade Sequence]==============

CREATE SEQUENCE grade_pk_seq
    INCREMENT BY 1
    MINVALUE 1
    MAXVALUE 9223372036854775807
    CACHE 1
    NO CYCLE;

ALTER SEQUENCE grade_pk_seq OWNER TO postgres;
GRANT ALL ON SEQUENCE grade_pk_seq to postgres;


-- ==============[Period Sequence]==============

CREATE SEQUENCE period_pk_seq
    INCREMENT BY 1
    MINVALUE 1
    MAXVALUE 9223372036854775807
    CACHE 1
    NO CYCLE;

ALTER SEQUENCE period_pk_seq OWNER TO postgres;
GRANT ALL ON SEQUENCE period_pk_seq to postgres;


-- ==============[Professor Sequence]==============

CREATE SEQUENCE professor_pk_seq
    INCREMENT BY 1
    MINVALUE 1
    MAXVALUE 9223372036854775807
    CACHE 1
    NO CYCLE;

ALTER SEQUENCE professor_pk_seq OWNER TO postgres;
GRANT ALL ON SEQUENCE professor_pk_seq to postgres;


-- ==============[Report Sequence]==============

CREATE SEQUENCE report_pk_seq
    INCREMENT BY 1
    MINVALUE 1
    MAXVALUE 9223372036854775807
    CACHE 1
    NO CYCLE;

ALTER SEQUENCE report_pk_seq OWNER TO postgres;
GRANT ALL ON SEQUENCE report_pk_seq to postgres;


-- ==============[Student Sequence]==============

CREATE SEQUENCE student_pk_seq
    INCREMENT BY 1
    MINVALUE 1
    MAXVALUE 9223372036854775807
    CACHE 1
    NO CYCLE;

ALTER SEQUENCE student_pk_seq OWNER TO postgres;
GRANT ALL ON SEQUENCE student_pk_seq to postgres;


-- ==============[Subject Sequence]==============

CREATE SEQUENCE subject_pk_seq
    INCREMENT BY 1
    MINVALUE 1
    MAXVALUE 9223372036854775807
    CACHE 1
    NO CYCLE;

ALTER SEQUENCE subject_pk_seq OWNER TO postgres;
GRANT ALL ON SEQUENCE subject_pk_seq to postgres;


