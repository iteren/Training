\connect mywallet

SET search_path TO mywallet;

CREATE
EXTENSION IF NOT EXISTS "uuid-ossp";

CREATE TABLE expense_plan
(
    plan_id varchar(50) NOT NULL,
    PRIMARY KEY (plan_id)
);

CREATE TABLE expense_item
(
    item_id uuid DEFAULT uuid_generate_v4(),
    plan_id varchar(50)   NOT NULL,
    name    varchar(50)   NOT NULL,
    "limit" decimal(8, 2) NOT NULL,
    PRIMARY KEY (item_id),
    CONSTRAINT fk_plan
        FOREIGN KEY (plan_id)
            REFERENCES expense_plan (plan_id)
);

CREATE TABLE expense_record
(
    record_id    uuid DEFAULT uuid_generate_v4(),
    item_id      uuid          NOT NULL,
    name         varchar(50)   NOT NULL,
    currency     varchar(3)    NOT NULL,
    amount       decimal(8, 2) NOT NULL,
    expense_time timestamp     NOT NULL,
    PRIMARY KEY (record_id),
    CONSTRAINT fk_item
        FOREIGN KEY (item_id)
            REFERENCES expense_item (item_id)
);

CREATE TABLE income_source
(
    income_source_id uuid DEFAULT uuid_generate_v4(),
    plan_id          varchar(50)   NOT NULL,
    name             varchar(50)   NOT NULL,
    currency         varchar(3)    NOT NULL,
    amount           decimal(12, 2) NOT NULL,
    balance          decimal(12, 2) NOT NULL,
    PRIMARY KEY (income_source_id),
    CONSTRAINT fk_plan
        FOREIGN KEY (plan_id)
            REFERENCES expense_plan (plan_id)
);


