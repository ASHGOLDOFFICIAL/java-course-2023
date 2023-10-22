package edu.hw2;

import edu.Task;
import java.util.concurrent.ThreadLocalRandom;

public final class Task3 extends Task {
    private static final int MAX_PROBABILITY = 100;
    private static final int HIGH_PROBABILITY = 80;
    private static final int EVEN_PROBABILITY = 50;
    private static final int DEFAULT_MAX_ATTEMPTS = 5;

    public interface Connection extends AutoCloseable {
        void execute(String command);
    }

    public static class StableConnection implements Connection {
        @Override
        public void close() {
            LOGGER.info("StableConnection is closed.");
        }

        @Override
        public void execute(String command) {
            LOGGER.info("StableConnection: execution is successful.");
        }
    }

    public static class FaultyConnection implements Connection {
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

    public interface ConnectionManager {
        Connection getConnection();
    }

    public static class DefaultConnectionManager implements ConnectionManager {
        @Override
        public Connection getConnection() {
            int probability = ThreadLocalRandom.current().nextInt(MAX_PROBABILITY);
            return (probability < EVEN_PROBABILITY) ? new StableConnection() : new FaultyConnection();
        }
    }

    public static class FaultyConnectionManager implements ConnectionManager {
        @Override
        public Connection getConnection() {
            return new FaultyConnection();
        }
    }

    public static class ConnectionException extends RuntimeException {
        public ConnectionException(String message) {
            super(message);
        }

        public ConnectionException(String message, Throwable cause) {
            super(message, cause);
        }
    }

    public static final class PopularCommandExecutor {

        private final ConnectionManager manager;
        private final int maxAttempts;

        public PopularCommandExecutor(ConnectionManager connectionManager, int attempts) {
            this.manager = connectionManager;
            this.maxAttempts = attempts;
        }

        public PopularCommandExecutor(ConnectionManager connectionManager) {
            this.manager = connectionManager;
            this.maxAttempts = DEFAULT_MAX_ATTEMPTS;
        }

        public PopularCommandExecutor(int attempts) {
            this.manager = new DefaultConnectionManager();
            this.maxAttempts = attempts;
        }

        public PopularCommandExecutor() {
            this.manager = new DefaultConnectionManager();
            this.maxAttempts = DEFAULT_MAX_ATTEMPTS;
        }

        public void updatePackages() {
            tryExecute("apt update && apt upgrade -y");
        }

        //        Добавил этот метод, чтобы IDEA не жаловалась на то, что command всегда равен "apt update..."
        public void removePackages() {
            tryExecute("apt autoremove");
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
}
