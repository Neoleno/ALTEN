#!/bin/bash
echo "Initializing MongoDB with data from JSON..."

mongoimport --host localhost --db ALTENDB --collection products --file /docker-entrypoint-initdb.d/products.json --jsonArray

echo "Data imported successfully"