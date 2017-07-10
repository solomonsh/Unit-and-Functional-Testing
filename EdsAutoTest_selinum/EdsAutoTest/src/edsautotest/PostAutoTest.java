
package edsautotest;

import java.util.ArrayList;
import java.util.List;
import junit.framework.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;

/**
 *
 * @author Chala
 */
public class PostAutoTest {
     WebDriver Wdname;
    ChromeOptions options;
    public static String result="";
    
    
    public PostAutoTest(){
         System.setProperty("webdriver.chrome.driver", "drivers\\chromedriver.exe");                
        options = new ChromeOptions();
        options.addArguments("--disable-notifications");
         //options.addExtensions(new File("ultraChrome.crx"));
        Wdname = new ChromeDriver(options);
    }
    public void loginToPost(String Username,String Password){
        Wdname.get("http://127.0.0.1/SE_Project/index.php");
         try{
            Thread.sleep(2000);
        }catch(Exception e){
            
        }
        WebElement blog = Wdname.findElement(By.cssSelector("#container .prmenu_container #top-menu #blog"));
        blog.click();
        try{
            Thread.sleep(2000);
        }catch(Exception e){
            
        }
        WebElement username = Wdname.findElement(By.id("username"));
        WebElement password = Wdname.findElement(By.id("password"));
        WebElement loginButton = Wdname.findElement(By.name("Submit"));
        
        username.sendKeys(Username);
        password.sendKeys(Password);
        loginButton.click();
    }
    public void loginThroughProfile(String Username,String Password){
        Wdname.get("http://127.0.0.1/SE_Project/index.php");
         try{
            Thread.sleep(2000);
        }catch(Exception e){
            
        }
        WebElement loginLink = Wdname.findElement(By.id("login"));
        loginLink.click();
        try{
            Thread.sleep(2000);
        }catch(Exception e){
            
        }
        WebElement login = Wdname.findElement(By.id("loginAsDeveloper"));
        login.click();
         try{
            Thread.sleep(2000);
        }catch(Exception e){
            
        }
        WebElement username = Wdname.findElement(By.id("username"));
        WebElement password = Wdname.findElement(By.id("password"));
        WebElement loginButton = Wdname.findElement(By.name("Submit"));
        
        username.sendKeys("chali_12");
        password.sendKeys("09CHALAgetu%");
        loginButton.click();
        
        WebElement blog = Wdname.findElement(By.className("nobrdr"));
        blog.click(); 
    }
    
    public String authomatedPost(String username,String password,String postTitle,String postContent){
        try{
        loginToPost(username,password);
        //loginThroughProfile();
        try{
            Thread.sleep(2000);
        }catch(Exception e){
            
        }
        
        WebElement eds_post = Wdname.findElement(By.id("eds_new_post"));
        eds_post.click();
        try{
            Thread.sleep(2000);
        }catch(Exception e){
            
        }
        WebElement title = Wdname.findElement(By.className("topicBox"));
        WebElement post = Wdname.findElement(By.className("contentBox"));
        title.sendKeys(postTitle);
        post.sendKeys(postContent);
        try{
            Thread.sleep(2000);
        }catch(Exception e){
            
        }
        WebElement postButton = Wdname.findElement(By.id("postButton"));
        Actions act = new Actions(Wdname);
        act.moveToElement(postButton);
        String registerPage=Wdname.getCurrentUrl();
        postButton.click();     
        
        
        try{
            Thread.sleep(2000);
        }catch(Exception e){
            
        }
        if(registerPage.equals(Wdname.getCurrentUrl())){
        return "Registeration Failed!";
        }
        List<WebElement> titles = Wdname.findElements(By.cssSelector(".content h2 a"));
         String outcome = titles.get(0).getAttribute("a");
        if (postTitle.equals(outcome)){
                 return "The Test is Successful";
        }else{
                 return "The result is failed";
        }
        }catch(Exception e){
            return e.toString();
        }
       
    }
    public String authomatedComment(String username,String password,String PostComment){
        try{
        loginToPost(username,password);
        //loginThroughProfile(username,password);
        try{
            Thread.sleep(2000);
        }catch(Exception e){
            
        }
        List<WebElement> comment = Wdname.findElements(By.cssSelector("#info a"));
        comment.get(0).click();
        try{
            Thread.sleep(2000);
        }catch(Exception e){
            
        }
        WebElement commentContent = Wdname.findElement(By.className("editComment"));
        commentContent.sendKeys(PostComment);
        
        WebElement commentButton = Wdname.findElement(By.id("postComment"));
        commentButton.click();
        
        try{
            Thread.sleep(2000);
        }catch(Exception e){
            
        }
        return "commenting successfully done";
        }catch(Exception e){
            return e.toString();
        }
    }
    public String authomatedPostEdit(String username,String password,String postTitle,String postContent){
        try{
         loginToPost(username,password);
         //loginThroughProfile();
         List<Integer> name = new ArrayList();
         List<WebElement> authors = Wdname.findElements(By.className("Author"));
         for(int i =0;i < authors.size(); i++){
             if (authors.get(i).getText().equalsIgnoreCase(username)){
                 name.add(i);
             }
         }
         if(name.isEmpty())
             return "you have no post to edit";
         
         List<WebElement> titles = Wdname.findElements(By.cssSelector(".content h2 a"));
         titles.get(name.get(0)).click();
         try{
            Thread.sleep(2000);
         }catch(Exception e){
            
         }
         
         WebElement editPost = Wdname.findElement(By.id("edit_post"));
         editPost.click();
         try{
            Thread.sleep(2000);
         }catch(Exception e){
            
         }
        WebElement title = Wdname.findElement(By.className("topicBox"));
        WebElement post = Wdname.findElement(By.className("contentBox"));
        //title.clear();
        //post.clear();
        title.sendKeys(postTitle);
        post.sendKeys( postContent);
        try{
            Thread.sleep(2000);
        }catch(Exception e){
            
        }
        WebElement postButton = Wdname.findElement(By.id("postButton"));
        Actions act = new Actions(Wdname);
        act.moveToElement(postButton);
        postButton.click();
        
        try{
            Thread.sleep(2000);
        }catch(Exception e){
            
        }
        return "Edit successful";
        }catch(Exception e){
            return e.toString();
        }
    }
    

    
}
