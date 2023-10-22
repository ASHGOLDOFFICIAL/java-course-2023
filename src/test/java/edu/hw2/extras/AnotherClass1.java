package edu.hw2.extras;

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
