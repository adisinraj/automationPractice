package tests;

import org.testng.ISuite;
import org.testng.ISuiteListener;

public class IISuiteListenerImpl implements ISuiteListener {
    @Override
    public void onStart(ISuite suite) {
        System.out.println("in IISuiteListenerImpl onStart");
        System.out.println(suite.getName());
    }

    @Override
    public void onFinish(ISuite suite) {
        System.out.println("in IISuiteListenerImpl onFinish");
        System.out.println(suite.getAllInvokedMethods().stream().toList());

    }
}
