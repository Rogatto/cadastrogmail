package com.cadastrogmail;


/*
 * 
 *  Author@: Guilherme Rogatto - Dev Java
 * 
 * 
 */


import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

  
  public class CadastroLogin {
	  
	  
   public static void main(String[] args) throws IOException, InterruptedException {
	

	   String baseUrl;
	   String senha1;
	   String senha2;

   
  //private Selenium selenium;
  //private boolean acceptNextAlert = true;
  //private StringBuffer verificationErrors = new StringBuffer();
 
	  
	
     //Setando todos os valores para realizar o teste automatizado
	  
	  //Temos primeiro que baixar o chromedriver, no qual sem ele nao ira executar 
	  File file =  new File("chromedriver"); 
	  System.setProperty("webdriver.chrome.driver",file.getAbsolutePath());
	
	 //LINK do site para começar
	 baseUrl = "https://accounts.google.com/ServiceLogin?continue=http%3A%2F%2Fmail.google.com%2Fmail%2F%3Fpc%3Dtopnav-about-pt-BR&service=mail&dsh=-5583318099686428580";
	 senha1 = "fsdfdsfdsfd";
	 senha2 = "fsdfdsfdsfd";
  


	  
	 JFrame frame = new JFrame(); 
	 
	 FileWriter arq = new FileWriter("Cenarios/status_reports2.txt",true);
	 
	 
	 PrintWriter gravar = new PrintWriter(arq);
	  
	 System.out.println("Iniciando Teste");
	 
	 
	 gravar.write("\nCadastro 2: \n");
	 
	 
	 WebDriver driver = new ChromeDriver();
	 
	 
	
	 
		driver.get(baseUrl);
		driver.findElement(By.linkText("Criar uma conta")).click();
		driver.findElement(By.id("FirstName")).click();
	    driver.findElement(By.id("FirstName")).sendKeys("Guilherme");
	  
	    //Retira Evidência
	    File scrnsht = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
	    FileUtils.copyFile(scrnsht, new File("Evidencias/google_page1.png"));
	    
	    driver.findElement(By.id("LastName")).clear();
	    driver.findElement(By.id("LastName")).sendKeys("rogatto");
	  
	    //Retira Evidência
	    File scrnsht2 = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
	    FileUtils.copyFile(scrnsht2, new File("Evidencias/google_page2.png"));
	    
	    driver.findElement(By.id("GmailAddress")).click();
	    driver.findElement(By.id("GmailAddress")).clear();
	    driver.findElement(By.id("GmailAddress")).sendKeys("guilherme.rogattomachado");
	  
	     //Retira Evidência
	     File scrnsht3 = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
	     FileUtils.copyFile(scrnsht3, new File("Evidencias/google_page3.png"));
	     
	    driver.findElement(By.id("Passwd")).click();
	    driver.findElement(By.id("Passwd")).clear();
	    driver.findElement(By.id("Passwd")).sendKeys(senha1);
	  
	    driver.findElement(By.id("PasswdAgain")).clear();
	    driver.findElement(By.id("PasswdAgain")).sendKeys(senha2);
	   
	    if (senha1 == senha2){
	    	
	    	
		    driver.findElement(By.id("BirthDay")).clear();
		    driver.findElement(By.id("BirthDay")).sendKeys("06");
		    driver.findElement(By.id("BirthMonth")).click();
		    driver.findElement(By.id(":2")).click();
		    driver.findElement(By.id("BirthYear")).clear();
		    driver.findElement(By.id("BirthYear")).sendKeys("1994");
		    driver.findElement(By.id("Gender")).click();
		    driver.findElement(By.id(":f")).click();
		    driver.findElement(By.id("RecoveryPhoneNumber")).click();
		    driver.findElement(By.id("RecoveryPhoneNumber")).clear();
		    driver.findElement(By.id("RecoveryPhoneNumber")).sendKeys("+5519993703939");
		    driver.findElement(By.id("RecoveryEmailAddress")).click();
		    driver.findElement(By.id("RecoveryEmailAddress")).clear();
		    driver.findElement(By.id("RecoveryEmailAddress")).sendKeys("testeeee1010@hotmail.com");
		    
		     //Retira Evidência
	         File scrnsht4 = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		     FileUtils.copyFile(scrnsht4, new File("Evidencias/google_page4.png"));
		   
		    //driver.findElement(By.id("submitbutton")).click();
		    //driver.findElement(By.id("iagreebutton")).click();
		    
		    //Aguarda 5 segundos para fechar
		    Thread.sleep(5000);
		    
		    //fecha navegador
		    driver.close();
		    
		    //Abre Janela Informando Teste Automatizado Realizado com Sucesso
		      
			JOptionPane.showMessageDialog(frame,"Teste Automatizado Realizado com Sucesso");
			
		
		    
			gravar.write("Cadastro 2 do Gmail Efetuado com SUCESSO \n");
			
		  
	  }
	    
	    else {
	    
	    	//Abre Janela Informando Senha Inválida
	    	
	    	JOptionPane.showMessageDialog(frame, "Senha Informada Inválida", "Error", JOptionPane.ERROR_MESSAGE);
	    	
	    	gravar.write("Cadastro 2 do Gmail Efetuado com ERRO \n");
	
	    }	   
	    
	    gravar.close();
	    
   }

	    
  
    
}

