package org.example;

import java.io.IOException;
import java.net.URISyntaxException;

public class Main {
    public static void main(String[] args) throws IOException, URISyntaxException {
        /*Runtime runtime = Runtime.getRuntime();
        runtime.exec(new String[]{"sudo apt update", "sudo apt upgrade", "sudo apt install wget"});
        runtime.exec(new String[]{"wget https://dl.google.com/linux/direct/google-chrome-stable_current_amd64.deb"});
        runtime.exec(new String[]{"sudo dpkg -i google-chrome-stable_current_amd64.deb"});*/

        SeleniumTest.initializeWebDriver();
    }
}