# federated-gateway-sample
Spring boot application:
cd books
Start application: mvn --e -X spring-boot:run
H2 DB console: http://localhost:8080/h2-console
GraphQL Playground: http://localhost:8080/graphiql

GraphQL Node JS application:
cd sample-graphql-app
npm install
npm start
GraphQL Playground: http://localhost:5000/graphql

Federated Gateway Application:
cd federated-gateway
npm install
npm start

Note: Except 'Federated Gateway Application', rest of the 2 applications can be started in any order. Run 'Federated Gateway Application' always last.