package MiniAssignment4;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import java.io.FileInputStream;
import java.util.List;

public class AddToCartTest extends BaseClass{
    @Test
    public static void addToCart() throws Exception{
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
        System.out.println("working");
        List<WebElement> prices = driver.findElements(By.xpath("//*[@class='inventory_item_price']"));
        int num;
        for(int i = 0; i< prices.size(); i++){
            Float price = Float.parseFloat(prices.get(i).getText().substring(1));
            if(price > maxPrice){
                maxPrice = price;
                num = i;
            }
        }
//        (//div[@class='inventory_item_price'])[6]
//         (//button[text()='Add to cart'])[1]
        driver.findElement(By.xpath("(//div[@class='inventory_item_price'])['']"));
    }
}
