package edu.hw2;

import edu.hw2.task3.connection.FaultyConnection;
import edu.hw2.task3.connection.StableConnection;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import edu.hw2.task3.PopularCommandExecutor;
import edu.hw2.task3.connection_manager.FaultyConnectionManager;
import edu.hw2.task3.ConnectionException;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertThrows;


public final class Task3Test {
    @Test
    @DisplayName("StableConnection не вернёт ошибки за 100 запросов")
    void stableConnection() {
        assertDoesNotThrow(() -> {
            for (int i = 0; i < 100; i++) {
                new StableConnection().execute("some command");
            }
        });
    }

    @Test
    @DisplayName("FaultyConnection вернёт хотя бы одну ошибку за 100 запросов")
    void faultyConnection() {
        assertThrows(ConnectionException.class, () -> {
            for (int i = 0; i < 100; i++) {
                new FaultyConnection().execute("some command");
            }
        });
    }

    @Test
    @DisplayName("DefaultConnectionManager вызовет соединение без ошибок за 10 попыток")
    void defaultConnectionManager() {
        PopularCommandExecutor commandExecutor = new PopularCommandExecutor(10);
        assertDoesNotThrow(commandExecutor::updatePackages);
    }

    @Test
    @DisplayName("FaultyConnectionManager вызовет хотя бы одну ошибку за 100 запросов по одной попытке")
    void faultyConnectionManager() {
        PopularCommandExecutor commandExecutor = new PopularCommandExecutor(new FaultyConnectionManager(), 1);
        assertThrows(ConnectionException.class, () -> {
            for (int i = 0; i < 100; i++) {
                commandExecutor.updatePackages();
            }
        });
    }
}
