 package edsautotest;

/**
 *
 * @author Solomon
 */
import java.util.ArrayList;
import java.util.List;
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
public class EDSTEST {

    static String searched_name;
    static String searched_name1;
    public static String SearchTestResult;
       WebDriver driver;
     @Test
     public String main(String fname,String lname){
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
      
       driver.findElement(By.id("username")).sendKeys(fname+result);
       
       driver.findElement(By.id("password_id")).sendKeys("123456789");
         try {
            Thread.sleep(2000);
        } catch (InterruptedException ex) {
            Logger.getLogger(EDSTEST.class.getName()).log(Level.SEVERE, null, ex);
        }
    
       
       driver.findElement(By.name("Submit")).sendKeys(Keys.ENTER);
     
           try {
            Thread.sleep(2000);
        } catch (InterruptedException ex) {
            Logger.getLogger(EDSTEST.class.getName()).log(Level.SEVERE, null, ex);
        }
    
       //go back to home
        driver.findElement(By.xpath("//a[contains(text(),'Home')]")).click();
        
      //then search the user you registered
        //click the search label
      driver.findElement(By.xpath("//label[contains(text(), 'search')]")).click();
      

       //enter the seach term and search
      driver.findElement(By.id("search-terms")).sendKeys(fname);
      
        try {
            Thread.sleep(2000);
        } catch (InterruptedException ex) {
            Logger.getLogger(EDSTEST.class.getName()).log(Level.SEVERE, null, ex);
        }
      //enter submit
       driver.findElement(By.id("search-terms")).sendKeys(Keys.ENTER);
      
         try {
            Thread.sleep(2000);
        } catch (InterruptedException ex) {
            Logger.getLogger(EDSTEST.class.getName()).log(Level.SEVERE, null, ex);
        }
         
         //if any result is retrived 
        
        List<WebElement> search_block = driver.findElements(By.id("devpart"));
         List<String> search_list;
         search_list = new ArrayList<>();
        for (WebElement webElement : search_block) {
             try {
              //  String search_link = webElement.findElement(By.cssSelector("div.fsl.fwb.fcb a")).getAttribute("href");
                 searched_name = webElement.findElement(By.id("resultName")).getText();             
                
                search_list.add(searched_name);
                
               System.out.println(search_list.get(0));
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
        //if check weather result is found or not 
        if(search_list.isEmpty()){
            System.out.println("NO RESULT IS  FOUND");
        }
         
  
        String user = fname+" "+lname;
      //  String found = driver.findElement(By.id("resultName")).getText(); 
        if(user.equals(searched_name)){
            SearchTestResult="Test Successfull!!";
        //assertEquals( user,searched_name);
}
        else{
            SearchTestResult="Test Not Successfull!!";
        }
        return SearchTestResult;
        }catch(Exception e){
        return e.toString();
        }  
        
     }
public String main1(String cpName){
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
      
      driver.findElement(By.id("email")).sendKeys(cpName+rand+"@gmail.com");
      driver.findElement(By.id("web")).sendKeys(cpName+".gov.et");
      driver.findElement(By.id("username")).sendKeys(cpName+rand);
      driver.findElement(By.id("password_id")).sendKeys("987654321");
     try {
            Thread.sleep(2000);
        } catch (InterruptedException ex) {
            Logger.getLogger(EDSTEST.class.getName()).log(Level.SEVERE, null, ex);
        }
    
       
       driver.findElement(By.name("Submit")).sendKeys(Keys.ENTER);
     
           try {
            Thread.sleep(2000);
        } catch (InterruptedException ex) {
            Logger.getLogger(EDSTEST.class.getName()).log(Level.SEVERE, null, ex);
        }
    
       //go back to home
        driver.findElement(By.xpath("//a[contains(text(),'Home')]")).click();
        
      //then search the user you registered
        //click the search label
      driver.findElement(By.xpath("//label[contains(text(), 'search')]")).click();
      

       //enter the seach term and search
      driver.findElement(By.id("search-terms")).sendKeys(cpName);
      
        try {
            Thread.sleep(2000);
        } catch (InterruptedException ex) {
            Logger.getLogger(EDSTEST.class.getName()).log(Level.SEVERE, null, ex);
        }
      //enter submit
       driver.findElement(By.id("search-terms")).sendKeys(Keys.ENTER);
      
         try {
            Thread.sleep(2000);
        } catch (InterruptedException ex) {
            Logger.getLogger(EDSTEST.class.getName()).log(Level.SEVERE, null, ex);
        }
         
         //if any result is retrived 
        
        List<WebElement> search_block = driver.findElements(By.id("devpart"));
         List<String> search_list;
         search_list = new ArrayList<>();
        for (WebElement webElement : search_block) {
             try {
              //  String search_link = webElement.findElement(By.cssSelector("div.fsl.fwb.fcb a")).getAttribute("href");
                 searched_name1 = webElement.findElement(By.id("resultName1")).getText();             
                
                search_list.add(searched_name1);
                
               System.out.println(search_list.get(0));
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
        //if check weather result is found or not 
        if(search_list.isEmpty()){
            System.out.println("NO RESULT IS  FOUND");
            SearchTestResult="Test Not Successfull!!";
        }
        
  
        String user = cpName;
      //  String found = driver.findElement(By.id("resultName")).getText(); 
        if(user.equals(searched_name1)){
            SearchTestResult="Test Successfull!!";
        //assertEquals( user,searched_name);
}
        else{
            SearchTestResult="Test Not Successfull!!";
        }
        return SearchTestResult;
        }catch(Exception e){
        return e.toString();
        }  
}       

public String main2(String Ufname){
    try{
     System.setProperty("webdriver.chrome.driver", "drivers\\chromedriver.exe");
     driver= new ChromeDriver();
       
       driver.get("http://localhost/SE_project/");
        try {
            Thread.sleep(2000);
        } catch (InterruptedException ex) {
            Logger.getLogger(EDSTEST.class.getName()).log(Level.SEVERE, null, ex);
        }
     
       //click the search label
      driver.findElement(By.xpath("//label[contains(text(), 'search')]")).click();
      

       //enter the seach term and search
      driver.findElement(By.id("search-terms")).sendKeys(Ufname);
      
        try {
            Thread.sleep(2000);
        } catch (InterruptedException ex) {
            Logger.getLogger(EDSTEST.class.getName()).log(Level.SEVERE, null, ex);
        }
      //enter submit
       driver.findElement(By.id("search-terms")).sendKeys(Keys.ENTER);
      
         try {
            Thread.sleep(2000);
        } catch (InterruptedException ex) {
            Logger.getLogger(EDSTEST.class.getName()).log(Level.SEVERE, null, ex);
        }
         
         //if any result is retrived 
        
        List<WebElement> search_block = driver.findElements(By.id("devpart"));
         List<String> search_list;
         search_list = new ArrayList<>();
        for (WebElement webElement : search_block) {
             try {
              //  String search_link = webElement.findElement(By.cssSelector("div.fsl.fwb.fcb a")).getAttribute("href");
                 searched_name = webElement.findElement(By.id("resultName1")).getText();             
                
                search_list.add(searched_name);
                
               System.out.println(search_list.get(0));
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
        //if check weather result is found or not 
        if(search_list.isEmpty()){
            System.out.println("NO RESULT IS  FOUND");
            SearchTestResult="Test Successfull i.e: no result found!!";
        }
        else{
    SearchTestResult="Test not Successfull i.e:  result found!!";
}
    return  SearchTestResult;
  
}catch(Exception e){
        return e.toString();
        }         
} 
}     
  
 
         
       
       
    
    

