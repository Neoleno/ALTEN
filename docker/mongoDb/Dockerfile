FROM mongo

ENV MONGO_INITDB_ROOT_USERNAME docker
ENV MONGO_INITDB_ROOT_PASSWORD docker
ENV MONGO_INITDB_DATABASE ALTENDB

COPY ./init/products.json /docker-entrypoint-initdb.d/products.json
COPY ./init/init-mongo.sh /docker-entrypoint-initdb.d/init-mongo.sh

RUN chmod +x /docker-entrypoint-initdb.d/init-mongo.sh

EXPOSE 27017

CMD ["mongod"]