package org.example;

import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.RequestHandler;
import com.amazonaws.services.lambda.runtime.LambdaRuntimeInternal;


public class LambdaHandler implements RequestHandler<Object, Object> {

    @Override
    public Object handleRequest(Object o, Context context) {
        try {

            System.out.println(System.getProperty("os.name"));
            System.out.println(System.getProperty("os.version"));
            System.out.println(System.getProperty("os.arch"));
            //SeleniumTest.initializeWebDriver();
            SeleniumTest2 test2 = new SeleniumTest2();
            test2.copyLibInTmp();
            test2.copyChromeInTmp();
            test2.runSelenium();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return null;
    }



}
