package edu.hw2.task3.connection;

import edu.Consts;
import edu.hw2.task3.ConnectionException;
import java.util.concurrent.ThreadLocalRandom;

public class FaultyConnection extends Consts implements Connection {
    @Override
    public void close() {
        LOGGER.info("FaultyConnection is closed.");
    }

    @Override
    public void execute(String command) {
        int probability = ThreadLocalRandom.current().nextInt(MAX_PROBABILITY);

        if (probability < HIGH_PROBABILITY) {
            throw new ConnectionException("FaultyConnection: execution is failed.");
        }

        LOGGER.info("FaultyConnection: execution is successful.");
    }
}
