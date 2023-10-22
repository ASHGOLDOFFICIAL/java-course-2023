package edu.hw2.task3.connection_manager;

import edu.Consts;
import edu.hw2.task3.connection.Connection;
import edu.hw2.task3.connection.FaultyConnection;
import edu.hw2.task3.connection.StableConnection;
import java.util.concurrent.ThreadLocalRandom;

public class DefaultConnectionManager extends Consts implements ConnectionManager {
    @Override
    public Connection getConnection() {
        int probability = ThreadLocalRandom.current().nextInt(MAX_PROBABILITY);
        return (probability < EVEN_PROBABILITY) ? new StableConnection() : new FaultyConnection();
    }
}
