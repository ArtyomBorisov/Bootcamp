FROM mysql:8.0
MAINTAINER Bootcamp

ENV MYSQL_ROOT_PASSWORD admin
ADD /user_service/ddl/*.sql /docker-entrypoint-initdb.d/

EXPOSE 3307