package org.example;

import io.github.classgraph.ClassGraph;
import io.github.classgraph.Resource;
import io.github.classgraph.ScanResult;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.io.File;
import java.net.URISyntaxException;
import java.net.URL;

public class SeleniumTest {


    public static void initializeWebDriver() throws URISyntaxException {


        ClassGraph cg = new ClassGraph();
        ScanResult sr = cg.disableModuleScanning().scan(10);
        Resource resource = sr.getResourcesWithExtension(".deb").asMap().get("google-chrome-stable_current_amd64.deb").get(0);
        URL chromeUrl = resource.getURL();
        System.out.println(chromeUrl);
        File chromeBinary = new File(chromeUrl.toURI());
        chromeBinary.setExecutable(true, false);
        Resource chromeDriverResource = sr.getAllResources().asMap().get("chromedriver").get(0);
        File chromeDriver = new File(chromeDriverResource.getURI());
        chromeDriver.setExecutable(true,false);

    System.out.println(chromeDriver.getAbsolutePath());
        System.setProperty("webdriver.chrome.driver", chromeDriver.getAbsolutePath());
        ChromeOptions options = new ChromeOptions();
        options.setBinary(chromeBinary);
        options.setHeadless(true);
        //WebDriverManager.chromedriver().setup();
      //  WebDriverManager.chromedriver().cachePath("/tmp").setup();

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
