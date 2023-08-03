const express = require('express');
const { ApolloServer, gql } = require('apollo-server-express');
const cors = require('cors');
const { products } = require('./mockData');

// Read the schema from the schema.graphql file
const schemaString = require('fs').readFileSync('./schema.graphql', 'utf8');
const typeDefs = gql(schemaString);

// Define resolvers
const resolvers = {
  Query: {
    getAllProducts: () => products,
    getProductById: (_, { id }) => products.find((product) => product.id === id),
  },
};

async function startApolloServer() {
  const server = new ApolloServer({
    typeDefs,
    resolvers,
    introspection: true, // Enable introspection for querying the schema
    playground: true,
  });

  await server.start();

  const app = express();

   // Enable CORS for allowing cross-origin requests
  app.use(cors());

  server.applyMiddleware({ app });

  const port = process.env.PORT || 5000;
  app.listen(port, () => {
    console.log(`🚀 Server running on http://localhost:${port}/graphql`);
  });
}

startApolloServer().catch((err) => console.error(err));
