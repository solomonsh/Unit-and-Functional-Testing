/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edsautotest;

import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;

/**
 *
 * @author Fra
 */
public class chatAutoTest {
    ChromeOptions options;
    DesiredCapabilities capabilities;
    WebDriver driver;
    public chatAutoTest(){
        System.setProperty("webdriver.chrome.driver", "drivers\\chromedriver.exe");                
        
    }
    
    public void login(String user,String pass ){
        driver = new ChromeDriver();
        
        driver.navigate().to("http://localhost/SE_Project//Login/logind.php");
        
        WebElement email= driver.findElement(By.name("username"));
        WebElement password= driver.findElement(By.name("password"));
        WebElement btn= driver.findElement(By.name("Submit"));
        email.sendKeys(user);
        password.sendKeys(pass);
        btn.click();   
    }
    
    public String sendMsg(String msgTxt, String recipient) throws InterruptedException{
        try{
    WebElement chathead= driver.findElement(By.id("chat_head"));
    chathead.click();
    Thread.sleep(3000);
    List<WebElement> friends = driver.findElements(By.cssSelector("#friend_list p"));
    for(WebElement friend:friends){
        System.out.println(friend.toString());
        String txt=friend.getText();
        System.out.println(txt);
        if(txt.contains(recipient))
            friend.findElement(By.cssSelector("a")).click();
        
    }
    Thread.sleep(4000);
    WebElement msg= driver.findElement(By.id("chat_message"));
    msg.sendKeys(msgTxt); 
    driver.findElement(By.id("send_btn")).click();
    Thread.sleep(4000);
    WebElement msgs = driver.findElement(By.cssSelector("#priv_chat p:nth-last-child(1)"));
    String temp="Message sent\n"+msgs.getText();
        return temp;
        }catch(Exception e){
        return e.toString();
        }   
    }
    

    
    public String getNewMsgs(){
        try{
    WebElement chathead= driver.findElement(By.id("chat_head"));
    chathead.click();
        try {
            Thread.sleep(3000);
        } catch (InterruptedException ex) {
            Logger.getLogger(chatAutoTest.class.getName()).log(Level.SEVERE, null, ex);
        }
    List<WebElement> friends = driver.findElements(By.cssSelector("#friend_list p a"));
    String numStr="0";
    for(WebElement friend:friends){
        System.out.println(friend.toString());
        String txt=friend.getText();
        int a,b;
        
        if(txt.contains("(")){
            a=txt.indexOf("(");
            b=txt.indexOf(")");
            numStr=txt.substring(a+1, b);
            b=Integer.parseInt(numStr);
            friend.click();
        }
        //if(txt.contains("("))
        //friend.click();
    }
    
    
    int count=Integer.parseInt(numStr);
    String rtrnMsg="you have "+numStr+" new message(s).\n";
    String temp;
    Thread.sleep(3000);
    for(int i=count;i>=1;i--){
     //WebElement msgs = driver.findElement(By.cssSelector("#priv_chat p:last-child"));
     WebElement msgs = driver.findElement(By.cssSelector("#priv_chat p:nth-last-child("+i+")"));
     temp=msgs.getText();
     rtrnMsg+=temp+"\n";
     
    }
//    String message=msgs.getText().toString();
//    if(message!=null)
//        return message;
    
    System.out.println("done");
        return rtrnMsg;
        
        }catch(Exception e){
        return e.toString();
        }   
    }
    
    
}
