package Auto.PruebaTecnica;

import static org.junit.Assert.assertEquals;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import cucumber.api.DataTable;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

/**
 * Hello world!
 *
 */
public class App 
{
	WebDriver driver;
	String sDirectorioTrabajo = System.getProperty("user.dir");
	String url = "https://www.google.com/";
	
	@Given("^Abrir google crome y ingresar la url de google$")				
    public void Abrir_google_crome_y_ingresar_la_url_de_webStore() throws Throwable							
    {				
		System.setProperty("webdriver.chrome.driver", "C:\\driver\\chromedriver.exe");
		//System.setProperty("webdriver.chrome.driver", sDirectorioTrabajo+"/src/main/java/Utilities/chromedriver");
		driver= new ChromeDriver();			
		driver.manage().window().maximize();			
		driver.get(url);				
    }		
	
	@When("^Ingresar buqueda$")					
    public void Ingresar_buqueda() throws Throwable 							
    {		
    	
    	driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS) ;
    	
    	// Ingresar Busqueda
    	driver.findElement(By.name("q")).sendKeys("Sophos solutions");    	 
    	// 
    	driver.findElement(By.name("q")).sendKeys(Keys.ENTER);   
    }			
	
	@Then("^Validar resultado$")					
    public void Validar_resultado(DataTable table) throws Throwable 							
    {		
		List<List<String>> list = table.asLists(String.class);
    	driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS) ;
    	
    	// Ingresar Busqueda
    	String resultados = driver.findElement(By.id("result-stats")).getText();    
    	String[] resul = resultados.split(" ");
    	System.out.println("1111 "+ list.get(1).get(0));
    	if(resul[2].equals(list.get(1).get(0))) {
    		System.out.println("paso");
    	}else {
    		throw new RuntimeException(list.get(1).get(0) + " - " + resul[2]);
    	}
    }	
}