const { ApolloServer } = require('apollo-server-express');
const { ApolloGateway } = require('@apollo/gateway');
const express = require('express');
const cors = require('cors');

async function startGateway() {
  const gateway = new ApolloGateway({
    serviceList: [
      { name: 'node-app', url: 'http://localhost:5000/graphql' },
      { name: 'spring-app', url: 'http://localhost:8080/graphql' },
    ],
  });

  const { schema, executor } = await gateway.load();

  const server = new ApolloServer({
    schema,
    executor,
    introspection: true,
    playground: true,
  });

  const app = express();
  app.use(cors());

  server.applyMiddleware({ app });

  const port = process.env.PORT || 4000;
  app.listen(port, () => {
    console.log(`🚀 Federated Gateway running at http://localhost:${port}${server.graphqlPath}`);
  });
}

startGateway().catch((err) => console.error(err));
