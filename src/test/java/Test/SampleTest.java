package Test;

import org.testng.annotations.Test;

public class SampleTest extends BaseClass{
    @Test(groups = "Smoke")
    private static void launchYoutube(){
        driver.get("https://www.youtube.com/");
    }
    @Test(groups = "Regression")
    private static void launchGmail(){
        driver.get("https://accounts.google.com/signin/v2/identifier?service=mail&passive=true&rm=false&continue=https%3A%2F%2Fmail.google.com%2Fmail%2F&ss=1&scc=1&ltmpl=default&ltmplcache=2&emr=1&osid=1&flowName=GlifWebSignIn&flowEntry=ServiceLogin");
    }
}
