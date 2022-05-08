package gamemania;

import java.util.concurrent.TimeUnit;

import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class TesteLoginGameMania {
	private WebDriver driver;

	@Before
	public void abrirNavegador() {
		System.setProperty("webdriver.chrome.driver", "C:\\Arquivos de Programas\\chromedriver\\chromedriver.exe");
		driver = new ChromeDriver();
	}

	@Test
	public void testeNavegador() {
		driver.get("http://localhost:4200/login");
		driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
		
		WebElement inputEmail = driver.findElement(By.id("email"));
		WebElement inputSenha = driver.findElement(By.id("password"));
		WebElement botaoLogin = driver.findElement(By.id("submit"));
		
		
		
		String[] listaSenhas = {"senhaum", "outrasenha", "senhaerrada", "abelhinha123"};
		for(int tentativas = 0; tentativas < listaSenhas.length; tentativas++) {
			try {
				inputEmail.clear();
				inputSenha.clear();
				
				inputEmail.sendKeys("heleninha@email.com");
				inputSenha.sendKeys(listaSenhas[tentativas]);
				botaoLogin.click();
				
				Thread.sleep(3000);
				
			}catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}
