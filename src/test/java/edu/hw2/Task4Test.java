package edu.hw2;

import edu.hw2.task4test.AnotherClass1;
import edu.hw2.task4test.AnotherClass2;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import edu.hw2.Task4.CallingInfo;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public final class Task4Test {
    private static final Logger LOGGER = LogManager.getLogger();
    private final String THIS_CLASS_FULL_NAME = this.getClass().getCanonicalName();

    @Test
    @DisplayName("Вызов функции из этого же теста")
    void callFromTest() {
        CallingInfo info = Task4.callingInfo();
        LOGGER.info(info);
        assertThat(info.className()).isEqualTo(THIS_CLASS_FULL_NAME);
        assertThat(info.methodName()).isEqualTo("callFromTest");
    }

    @Test
    @DisplayName("Вызов из другого класса при инициализации класса")
    void fromAnotherClassInit() {
        CallingInfo info = edu.hw2.task4test.AnotherClass1.getInitInfo();
        LOGGER.info(info);
        assertThat(info.className()).isEqualTo(AnotherClass1.class.getName());
        assertThat(info.methodName()).isEqualTo("<clinit>");
    }

    @Test
    @DisplayName("Вызов из другого класса при инициализации экземпляра")
    void fromAnotherClassConstructor() {
        CallingInfo info = new AnotherClass2().getConstructorInfo();
        LOGGER.info(info);
        assertThat(info.className()).isEqualTo(AnotherClass2.class.getName());
        assertThat(info.methodName()).isEqualTo("<init>");
    }

    @Test
    @DisplayName("Вызов из метода другого класса")
    void fromAnotherClassMethod() {
        CallingInfo info = edu.hw2.task4test.AnotherClass1.getMethodInfo();
        LOGGER.info(info);
        assertThat(info.className()).isEqualTo(AnotherClass1.class.getName());
        assertThat(info.methodName()).isEqualTo("getMethodInfo");
    }
}
