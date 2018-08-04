# Blockchain Explorer
A small utility that grab data from blockchain.info and visualize a graph of transactions starting from a list of wallets.

# Results
In these section will be shown some results produced by this utilites starting from sadly known WannaCry wallets.

This is Neo4J result
![This is Neo4J result](https://github.com/Abyssi/blockchain_explorer/raw/master/screenshots/blockchain_explorer_neo4j.png)

This is Processing result
![This is Processing result](https://github.com/Abyssi/blockchain_explorer/raw/master/screenshots/blockchain_explorer_processing.png)

# How
This project grab data at runtime and caches them for future reuse and optimization during the deep search and uses Processing core to draw objects inside the view and simultaneously optionally saves the graph structure inside neo4j instance for better analysis. 
