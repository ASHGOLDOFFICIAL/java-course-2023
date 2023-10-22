package edu.hw2;

import edu.Consts;

public final class Task4 extends Consts {
    private Task4() {
    }

    public static CallingInfo callingInfo() {
        StackTraceElement stackTraceLastCall = new Throwable().getStackTrace()[1];
        return new CallingInfo(stackTraceLastCall.getClassName(), stackTraceLastCall.getMethodName());
    }

    public record CallingInfo(String className, String methodName) {
    }
}
