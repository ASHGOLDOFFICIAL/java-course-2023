package edu.hw2;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import edu.hw2.task3.PopularCommandExecutor;
import edu.hw2.task3.connection_manager.FaultyConnectionManager;
import edu.hw2.task3.ConnectionException;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertThrows;


public final class Task3Test {
    @Test
    @DisplayName("FaultyConnection вернёт хотя бы одну ошибку за 100 запросов")
    void faultyConnection() {
        FaultyConnectionManager manager = new FaultyConnectionManager();
        assertThrows(ConnectionException.class, () -> {
            for (int i = 0; i < 100; i++) {
                manager.getConnection().execute("some command");
            }
        });
    }

    @Test
    @DisplayName("DefaultConnectionManager не вызовет ошибок за 100 запросов")
    void defaultConnectionManager() {
        PopularCommandExecutor commandExecutor = new PopularCommandExecutor(100);
        assertDoesNotThrow(commandExecutor::updatePackages);
    }
}
