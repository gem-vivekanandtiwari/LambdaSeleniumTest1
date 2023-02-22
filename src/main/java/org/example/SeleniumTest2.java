package org.example;

import io.github.classgraph.ClassGraph;
import io.github.classgraph.Resource;
import io.github.classgraph.ScanResult;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.io.File;
import java.io.IOException;
import java.net.URISyntaxException;
import java.net.URL;
import java.time.Duration;

public class SeleniumTest2 {
    private String chromeBrowserTmpPath;
    private String ChromeDriverTmpPath;

    public void copyLibInTmp() throws IOException {
        File libFile = new File("/lib");
        if(libFile.exists()){
            System.out.println("libfile Exists");
            File tempLib = new File("/tmp/lib");
            tempLib.mkdir();
            FileUtils.copyDirectoryToDirectory(libFile,tempLib);

        }
        File lib64File = new File("/lib64");
        if(lib64File.exists()){
            System.out.println("lib 64 Exists");
            File temLib64 = new File ("/tmp/lib64");
            temLib64.mkdir();
            FileUtils.copyDirectoryToDirectory(lib64File,temLib64);
            System.out.println("Copy Complete lib 64");
        }else{
            System.out.println("lib 64 doesnot exist ");
        }
    }

    public void copyChromeInTmp() throws URISyntaxException, IOException {
        ClassGraph cg = new ClassGraph();
        ScanResult sr = cg.disableModuleScanning().scan(10);
        Resource resource = sr.getResourcesWithExtension(".deb").asMap().get("google-chrome-stable_current_amd64.deb").get(0);
        URL chromeUrl = resource.getURL();
        File chromeBinary = new File(chromeUrl.toURI());
        File tempChromeBinary = new File("/tmp/" + chromeBinary.getName());
        tempChromeBinary.createNewFile();
        FileUtils.copyFile(chromeBinary, tempChromeBinary);
        System.out.println(tempChromeBinary.getAbsolutePath());
        tempChromeBinary.setExecutable(true);
        this.chromeBrowserTmpPath = tempChromeBinary.getAbsolutePath();

        Resource chromeDriverResource = sr.getAllResources().asMap().get("chromedriver").get(0);
        File chromeDriver = new File(chromeDriverResource.getURI());
        File tempChromeDriverBinary = new File("/tmp/" + chromeDriver.getName());
        tempChromeDriverBinary.createNewFile();
        FileUtils.copyFile(chromeDriver, tempChromeDriverBinary);
        tempChromeDriverBinary.setExecutable(true);
        System.out.println(tempChromeDriverBinary.getAbsolutePath());
        System.setProperty("webdriver.chrome.driver", tempChromeDriverBinary.getAbsolutePath());
        this.ChromeDriverTmpPath = tempChromeDriverBinary.getAbsolutePath();
    }


    public void runSelenium(){
        ChromeOptions options = new ChromeOptions();
        options.setHeadless(true);
        options.setBinary(new File(this.chromeBrowserTmpPath));
        WebDriver driver = new ChromeDriver(options);
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(20));
        driver.manage().window().maximize();
        driver.get("https://www.google.com/chrome/");
        System.out.println(driver.getTitle());
        driver.close();
    }
}
