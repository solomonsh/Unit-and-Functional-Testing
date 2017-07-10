/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edsautotest;

import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

/**
 *
 * @author 
 */
public class authAutoTest {
    
    static String searched_name;
    public static String SearchTestResult;
       WebDriver driver;
     @Test
     public String registerDeveloper(String fname,String lname){
         try{
     System.setProperty("webdriver.chrome.driver", "drivers\\chromedriver.exe");
     driver= new ChromeDriver();
       
       driver.get("http://localhost/SE_project/");
         //WebElement register_link= driver.findElement(By.id("register_link"));
         //register_link.click(); ul#top-menu li:nth-child(5)
       //click the register link
      driver.findElement(By.xpath("//a[contains(text(),'Register')]")).click();
        try {
            Thread.sleep(1000);
        } catch (InterruptedException ex) {
            Logger.getLogger(EDSTEST.class.getName()).log(Level.SEVERE, null, ex);
        }
        //click the sign up as developer sublink
      driver.findElement(By.xpath("//a[contains(text(),'Sign up as developer')]")).click();
     
    
    //select the first name input and fill the inputs
      driver.findElement(By.id("fname")).sendKeys(fname);
      driver.findElement(By.id("lname")).sendKeys(lname);
      
      Select dropdown1=new Select(driver.findElement(By.name("gender")));
      dropdown1.selectByVisibleText("Female");
      Random r = new Random();
      int Low = 10;
      int High = 1000;
      int Result = r.nextInt(High-Low) + Low;
      String result=Integer.toString(Result);
       driver.findElement(By.id("dateofbirth")).sendKeys("06/09/2017");
       driver.findElement(By.id("email")).sendKeys(fname+result+"@gmail.com");
       
        
      Select dropdown2=new Select(driver.findElement(By.name("status")));
      dropdown2.selectByVisibleText("Amateur");
      String username=fname+result;
      String password="123456789";
       driver.findElement(By.id("username")).sendKeys(username);
       
       driver.findElement(By.id("password_id")).sendKeys(password);
         try {
            Thread.sleep(2000);
        } catch (InterruptedException ex) {
            Logger.getLogger(EDSTEST.class.getName()).log(Level.SEVERE, null, ex);
        }
    
       String registerPage=driver.getCurrentUrl();
       driver.findElement(By.name("Submit")).sendKeys(Keys.ENTER);
     
           try {
            Thread.sleep(2000);
        } catch (InterruptedException ex) {
            Logger.getLogger(EDSTEST.class.getName()).log(Level.SEVERE, null, ex);
        }
        if(registerPage.equals(driver.getCurrentUrl())){
        return "Registeration Failed!";
        }
        return "Registeration Successfull!\nusing: username = "+username+" , password = "+password;
        
        }catch(Exception e){
            return e.toString();
        }
}
     
     public String registerCompany(String cpName){
         try{
     System.setProperty("webdriver.chrome.driver", "drivers\\chromedriver.exe");
     driver= new ChromeDriver();
       
       driver.get("http://localhost/SE_project/");
          
      driver.findElement(By.xpath("//a[contains(text(),'Register')]")).click();
        try {
            Thread.sleep(1000);
        } catch (InterruptedException ex) {
            Logger.getLogger(EDSTEST.class.getName()).log(Level.SEVERE, null, ex);
        }
      //click the sign up as developer sublink
      driver.findElement(By.xpath("//a[contains(text(),'Sign up as company')]")).click();
     //register company
      driver.findElement(By.id("name")).sendKeys(cpName);
       Random r = new Random();
      int Low = 10;
      int High = 1000;
      int Randint = r.nextInt(High-Low) + Low;
      String rand=Integer.toString(Randint);
      String name=cpName+rand;
      String password="987654321";
      driver.findElement(By.id("email")).sendKeys(cpName+rand+"@gmail.com");
      driver.findElement(By.id("web")).sendKeys(cpName+".gov.et");
      driver.findElement(By.id("username")).sendKeys(name);
      driver.findElement(By.id("password_id")).sendKeys(password);
     try {
            Thread.sleep(2000);
        } catch (InterruptedException ex) {
            Logger.getLogger(EDSTEST.class.getName()).log(Level.SEVERE, null, ex);
        }
    
       String registerPage=driver.getCurrentUrl();
       driver.findElement(By.name("Submit")).sendKeys(Keys.ENTER);
     
           try {
            Thread.sleep(2000);
        } catch (InterruptedException ex) {
            Logger.getLogger(EDSTEST.class.getName()).log(Level.SEVERE, null, ex);
        }
           if(registerPage.equals(driver.getCurrentUrl())){
        return "Registeration Failed!";
        }
        return "Registration Successfull!\nusing: username = "+name+", password = "+password;
        
        }catch(Exception e){
            return e.toString();
        }
           
     }
     
     public String loginTest(String user,String pass){
    try{
     System.setProperty("webdriver.chrome.driver", "drivers\\chromedriver.exe");
     driver= new ChromeDriver();
       
       driver.get("http://localhost/SE_project/");
         //WebElement register_link= driver.findElement(By.id("register_link"));
         //register_link.click(); ul#top-menu li:nth-child(5)
       //click the register link
      driver.findElement(By.xpath("//a[contains(text(),'Login')]")).click();
        try {
            Thread.sleep(2000);
        } catch (InterruptedException ex) {
            Logger.getLogger(EDSTEST.class.getName()).log(Level.SEVERE, null, ex);
        }
        //click the sign up as developer sublink
      driver.findElement(By.id("loginAsDeveloper")).click();
      
       WebElement email= driver.findElement(By.name("username"));
        WebElement password= driver.findElement(By.name("password"));
        WebElement btn= driver.findElement(By.name("Submit"));
        email.sendKeys(user);
        password.sendKeys(pass);
       String registerPage=driver.getCurrentUrl();
        btn.click();   
      
      
       
     
           try {
            Thread.sleep(6000);
        } catch (InterruptedException ex) {
            Logger.getLogger(EDSTEST.class.getName()).log(Level.SEVERE, null, ex);
        }

           driver.findElement(By.xpath("//a[contains(text(),'Logout')]")).click();
           if(registerPage.equals(driver.getCurrentUrl())){
        return "Login Failed!";
        }
        return "Login Successfull!";
        }catch(Exception e){
            return e.toString();
        }
       
}

}
