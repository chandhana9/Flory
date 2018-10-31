#!/bin/sh

ZIPFILE="$(ls | grep DBSK)"
echo "${ZIPFILE}"
unzip "${ZIPFILE}"
mv "${ZIPFILE}" DBSK
rm "${ZIPFILE}"
