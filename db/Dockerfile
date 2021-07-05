# syntax=docker/dockerfile:1

FROM postgres

ENV POSTGRES_USER postgres
ENV POSTGRES_PASSWORD postgres
ENV POSTGRES_DB postgres

ADD db/init/create_db.sql /docker-entrypoint-initdb.d
ADD db/init/create_tables.sql /docker-entrypoint-initdb.d
ADD db/init/insert_data.sql /docker-entrypoint-initdb.d
