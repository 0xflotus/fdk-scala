FROM owainlewis/sbt:latest

WORKDIR /function

ADD . /function/

RUN ["sbt", "run"]