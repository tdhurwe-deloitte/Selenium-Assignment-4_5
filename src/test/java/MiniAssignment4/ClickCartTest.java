package MiniAssignment4;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.testng.annotations.Test;

import java.io.FileInputStream;

public class ClickCartTest extends BaseClass{
    @Test
    public void clickCart() throws Exception{
        driver.get("https://www.saucedemo.com/");
        Thread.sleep(1000);
        String path = "C:\\Users\\tdhurwe\\Documents\\maven project\\src\\Book1.xlsx";
        FileInputStream file = new FileInputStream(path);
        XSSFWorkbook workbook = new XSSFWorkbook(file);
        XSSFSheet sheet = workbook.getSheetAt(0);
        XSSFRow row = null;
        XSSFCell cell = null;
        String username = null;
        String password = null;
        String subString = null;
        row = sheet.getRow(1);
        Float maxPrice = 0.0f;
        username = row.getCell(0).getStringCellValue();
        password = row.getCell(1).getStringCellValue();
        Thread.sleep(1000);
        driver.findElement(By.xpath("//*[@id='user-name']")).sendKeys(username);
        Thread.sleep(1000);
        driver.findElement(By.xpath("//*[@id='password']")).sendKeys(password);
        Thread.sleep(1000);
        driver.findElement(By.xpath("//*[@id='login-button']")).click();
        Thread.sleep(4000);
        driver.findElement(By.xpath("//a[@class='shopping_cart_link']")).click();
        Thread.sleep(2000);
        String actualUrl = driver.getCurrentUrl();
        String originalUrl = "https://www.saucedemo.com/cart.html";
        if (actualUrl.equals(originalUrl)){
            System.out.println("Successful");
        }
        else{
            System.out.println("Unsuccessful");
        }
//        continue shopping
        Thread.sleep(2000);
        driver.findElement(By.xpath("//*[@id='continue-shopping']")).click();
        Thread.sleep(2000);
        String homeUrl = "https://www.saucedemo.com/inventory.html";
        String urlReceived = driver.getCurrentUrl();
        if (homeUrl.equals(urlReceived)){
            System.out.println("Successfully returned to home page");
        }
        else {
            System.out.println("Unsuccessful");
        }
    }
}
