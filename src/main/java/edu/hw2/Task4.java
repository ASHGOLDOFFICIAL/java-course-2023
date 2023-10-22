package edu.hw2;

import edu.Task;

public final class Task4 extends Task {
    public static CallingInfo callingInfo() {
        StackTraceElement stackTrace = new Throwable().getStackTrace()[1];
        return new CallingInfo(stackTrace.getClassName(), stackTrace.getMethodName());
    }

    public record CallingInfo(String className, String methodName) {}
}
