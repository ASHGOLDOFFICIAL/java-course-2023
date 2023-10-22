package edu.hw2.extras;

import edu.hw2.Task4;

public final class AnotherClass2 {
    private final Task4.CallingInfo constructorInfo;

    public AnotherClass2() {
        this.constructorInfo = Task4.callingInfo();
    }

    public Task4.CallingInfo getConstructorInfo() {
        return this.constructorInfo;
    }
}
