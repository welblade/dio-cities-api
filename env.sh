#!/bin/bash
URL=$(echo ${DATABASE_URL} | cut -d'@' -f 2)
USERANDPASS=$(echo ${DATABASE_URL} | cut -d'@' -f 1 | cut -d'/' -f 3)
export SPRING_DATASOURCE_URL="jdbc:postgresql://${URL}"
export SPRING_DATASOURCE_USERNAME="$(echo ${USERANDPASS} | cut -d':' -f 1)"
export SPRING_DATASOURCE_PASSWORD="$(echo ${USERANDPASS} | cut -d':' -f 2)"

unset URL
unset USERANDPASS