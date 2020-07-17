--liquibase formatted sql

--changeset dmytro.timchenko:ticket_seq-creation
CREATE SEQUENCE ticket_seq;

--changeset dmytro.timchenko:user_seq-creation
CREATE SEQUENCE user_seq;

--changeset dmytro.timchenko:tickets-creation
create table if not exists users(
    id bigint PRIMARY KEY,
    name text NOT NULL
)

--changeset dmytro.timchenko:users-creation
create table if not exists tickets(
    id bigint PRIMARY KEY,
    title text NOT NULL,
    description text,
    status text,
    loggedTime int,
    creator_id_fk bigint NOT NULL,
    assignee_id_fk bigint,
    creation_time time without time zone,
    last_update_time time without time zone,
    FOREIGN KEY (creator_id_fk) REFERENCES users(id),
    FOREIGN KEY (assignee_id_fk) REFERENCES users(id)
)