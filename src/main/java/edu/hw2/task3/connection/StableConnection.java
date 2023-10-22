package edu.hw2.task3.connection;

import edu.Consts;

public class StableConnection extends Consts implements Connection {
    @Override
    public void close() {
        LOGGER.info("StableConnection is closed.");
    }

    @Override
    public void execute(String command) {
        LOGGER.info("StableConnection: execution is successful.");
    }
}
