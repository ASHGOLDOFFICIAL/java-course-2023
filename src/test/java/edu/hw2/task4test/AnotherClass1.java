package edu.hw2.task4test;

import edu.hw2.Task4;

public final class AnotherClass1 {
    private static final Task4.CallingInfo initInfo = Task4.callingInfo();

    public static Task4.CallingInfo getInitInfo() {
        return initInfo;
    }

    public static Task4.CallingInfo getMethodInfo() {
        return Task4.callingInfo();
    }
}
