package MiniAssignment4;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;

import org.testng.annotations.Test;

import java.io.FileInputStream;

public class LoginTest extends BaseClass {

    @Test
    public static void loginValidation() throws Exception{
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
        System.out.println("Working till here");
        for(int i = 1; i < sheet.getLastRowNum() + 1; i++)
        {
            row = sheet.getRow(i);
            for(int j = 0; j < row.getLastCellNum(); j++){
                cell = row.getCell(j);
                if (j == 0){
                    username = cell.getStringCellValue();
                }
                if (j == 1){
                    password = cell.getStringCellValue();
                }
            }
        Thread.sleep(2000);
        driver.findElement(By.xpath("//*[@id='user-name']")).sendKeys(username);
        Thread.sleep(1000);
        driver.findElement(By.xpath("//*[@id='password']")).sendKeys(password);
        Thread.sleep(2000);
        driver.findElement(By.xpath("//*[@id='login-button']")).click();
        Thread.sleep(2000);
        String result = null;
        String actualUrl = driver.getCurrentUrl();
        Boolean isLoggedIn = actualUrl.equals("https://www.saucedemo.com/inventory.html");
            System.out.println("working here too");
            if (isLoggedIn){
                result = "Login Successful";
                System.out.println("Username : "+username+"\nPassword : "+password+"\n"+result+"\n\n");
                driver.findElement(By.xpath("//*[text()='Open Menu']")).click();
                Thread.sleep(2000);
                driver.findElement(By.xpath("//*[text()='Logout']")).click();
                Thread.sleep(2000);
            }
            else {
                result = "login failed";
                System.out.println("Username : "+username+"\nPassword : "+password+"\n"+result+"\n\n");
                driver.navigate().refresh();
            }
        }
    }
}
