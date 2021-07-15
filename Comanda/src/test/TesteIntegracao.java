package test;

import org.junit.runner.JUnitCore;
import org.junit.runner.notification.Failure;

import org.junit.runner.Result;

public class TesteIntegracao {
    public static void main(String[] args) {
        Result result = JUnitCore.runClasses(TesteSuite.class);

        for (Failure failure:result.getFailures()){
            System.out.println(failure.toString());
        }
        System.out.println(result.wasSuccessful());
    }
}
