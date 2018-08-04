package Sketch;

import Sketch.Core.Graph.Edge;
import Sketch.Core.Graph.OrientedGraph;
import Sketch.Core.GraphicableWalletNode;
import org.neo4j.graphdb.*;
import org.neo4j.graphdb.factory.GraphDatabaseFactory;

import java.io.File;
import java.util.Arrays;
import java.util.List;

public class Neo4J {
    private static Neo4J sharedInstance;

    private GraphDatabaseService db;

    public enum WalletKind implements Label {
        INITIAL,
        PRIVATE,
        PUBLIC
    }
    public enum TransactionRelationships implements RelationshipType{
        IN,
        OUT
    }

    public Neo4J() {
        GraphDatabaseFactory graphDbFactory = new GraphDatabaseFactory();
        this.db = graphDbFactory.newEmbeddedDatabase(new File("data/databases/graph.db"));
    }

    public static Neo4J sharedInstance() {
        return sharedInstance == null ? sharedInstance = new Neo4J() : sharedInstance;
    }

    public void write(OrientedGraph<GraphicableWalletNode> graphicableWalletNodeOrientedGraph, String[] addresses) {
        try (Transaction tx = db.beginTx()) {
            List<String> initialAddresses = Arrays.asList(addresses);
            for (GraphicableWalletNode graphicableWalletNode: graphicableWalletNodeOrientedGraph.getNodes()) {
                Node node = db.createNode(initialAddresses.contains(graphicableWalletNode.getId()) ? WalletKind.INITIAL : WalletKind.PRIVATE);
                node.setProperty("id", graphicableWalletNode.getId());
                node.setProperty("total_received", graphicableWalletNode.getTotalReceived());
            }

            for (Edge edge: graphicableWalletNodeOrientedGraph.getEdges()) {
                Node a = db.findNode(initialAddresses.contains(edge.getA().getId()) ? WalletKind.INITIAL : WalletKind.PRIVATE, "id", edge.getA().getId());
                Node b = db.findNode(initialAddresses.contains(edge.getB().getId()) ? WalletKind.INITIAL : WalletKind.PRIVATE, "id", edge.getB().getId());
                Relationship relationship = a.createRelationshipTo(b,TransactionRelationships.OUT);
            }
            tx.success();
        }
    }
}
