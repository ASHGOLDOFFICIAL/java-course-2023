package edu.hw2.task3;

import edu.Consts;
import edu.hw2.task3.connection.Connection;
import edu.hw2.task3.connection_manager.ConnectionManager;
import edu.hw2.task3.connection_manager.DefaultConnectionManager;

public final class PopularCommandExecutor extends Consts {
    private static final int DEFAULT_MAX_ATTEMPTS = 5;

    private final ConnectionManager manager;
    private final int maxAttempts;

    public PopularCommandExecutor(ConnectionManager connectionManager, int attempts) {
        this.manager = connectionManager;
        this.maxAttempts = attempts;
    }

    public PopularCommandExecutor(ConnectionManager connectionManager) {
        this(connectionManager, DEFAULT_MAX_ATTEMPTS);
    }

    public PopularCommandExecutor(int attempts) {
        this(new DefaultConnectionManager(), attempts);
    }

    public void updatePackages() {
        tryExecute("apt update && apt upgrade -y");
    }

    void tryExecute(String command) {
        for (int attempt = 1; attempt <= maxAttempts; attempt++) {
            try (Connection connection = manager.getConnection()) {
                connection.execute(command);
                LOGGER.info(String.format("`%s$` is successfully executed.", command));
                break;
            } catch (ConnectionException e) {
                LOGGER.info("ConnectionException on attempt " + attempt);

                if (attempt == maxAttempts) {
                    throw new ConnectionException("Couldn't connect after " + attempt + " attempts", e);
                }
            } catch (Exception e) {
                LOGGER.info("Couldn't close the connection.");
            }
        }
    }
}
