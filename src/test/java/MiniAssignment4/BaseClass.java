package MiniAssignment4;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import java.io.FileInputStream;
import java.time.Duration;

public class BaseClass {
    public static WebDriver driver;
    @BeforeTest
    public static WebDriver initialSetup(){
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\tdhurwe\\Downloads\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
        return driver;
    }
    public static XSSFSheet loadSheet() throws Exception{
        String path = "C:\\Users\\tdhurwe\\Documents\\maven project\\src\\Book1.xlsx";
        FileInputStream file = new FileInputStream(path);
        XSSFWorkbook workbook = new XSSFWorkbook(file);
        XSSFSheet sheet = workbook.getSheetAt(0);
        return sheet;
    }
    @AfterTest
    public static void closeBrowser(){
        driver.close();
    }
}
