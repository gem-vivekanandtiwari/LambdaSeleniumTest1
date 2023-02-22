/*
package org.example;

import io.github.classgraph.ClassGraph;
import io.github.classgraph.Resource;
import io.github.classgraph.ScanResult;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.io.File;
import java.io.IOException;
import java.net.URISyntaxException;
import java.net.URL;

public class SeleniumTest {


    public static void initializeWebDriver() throws URISyntaxException, IOException {


        ClassGraph cg = new ClassGraph();
        ScanResult sr = cg.disableModuleScanning().scan(10);
        Resource resource2 = sr.getResourcesWithExtension(".deb").asMap().get("libglib2.0-0_2.56.1-2ubuntu1_arm64.deb").get(0);
        File libgLigResource = new File(resource2.getURI());
        File libgLigTemp = new File("/tmp/"+libgLigResource.getName());
        libgLigTemp.createNewFile();

        FileUtils.copyFile(libgLigResource,libgLigTemp);
        Runtime runtime = Runtime.getRuntime();
        System.out.println(runtime.exec("install "+libgLigTemp.getAbsolutePath()));
        System.out.println("istalled "+ libgLigTemp.getName());


        Resource resource = sr.getResourcesWithExtension(".deb").asMap().get("google-chrome-stable_current_amd64.deb").get(0);
        URL chromeUrl = resource.getURL();
        File chromeBinary = new File(chromeUrl.toURI());
        File tempChromeBinary = new File("/tmp/" + chromeBinary.getName());
        tempChromeBinary.createNewFile();
        FileUtils.copyFile(chromeBinary, tempChromeBinary);
        System.out.println(tempChromeBinary.getAbsolutePath());
        tempChromeBinary.setExecutable(true,false);
        chromeBinary.setExecutable(true, false);

        Resource chromeDriverResource = sr.getAllResources().asMap().get("chromedriver").get(0);
        File chromeDriver = new File(chromeDriverResource.getURI());
        File tempChromeDriverBinary = new File("/tmp/" + chromeDriver.getName());
        tempChromeDriverBinary.createNewFile();
        FileUtils.copyFile(chromeDriver, tempChromeDriverBinary);
        tempChromeDriverBinary.setExecutable(true,false);
        chromeDriver.setExecutable(true, false);
        System.out.println(tempChromeDriverBinary.getAbsolutePath());
        System.setProperty("webdriver.chrome.driver", tempChromeDriverBinary.getAbsolutePath());

        ChromeOptions options = new ChromeOptions();
        options.setBinary(tempChromeBinary);
        options.setHeadless(true);

        System.out.println("Going to initialize driver");
       WebDriver driver = new ChromeDriver(options);
        //WebDriverManager driverManager = WebDriverManager.getInstance(driver.getClass());
        driver.get("https://www.google.com/chrome/");
        try {
            // wdm.startRecording("test recording");
            Thread.sleep(5000);
            driver.findElement(By.xpath("(//button[contains(text(),'Download Chrome')])[1]")).click();

            Thread.sleep(5000);
            System.out.println("Chrome started");
            driver.close();
            System.out.println("Closed Chrome");
        } catch (Exception e) {

        }
        // wdm.stopRecording();

    }


}
*/
