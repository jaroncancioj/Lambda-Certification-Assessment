package TestSelenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class SeleniumMaven {

	public static void main(String[] args) throws InterruptedException {

		WebDriver driver;
		
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\jroncancio\\eclipse-workspace\\drivers\\chromedriver.exe");
		
		driver = new ChromeDriver();	
		
		driver.get("https://www.linio.com.co");
		
		/*driver.findElement(By.xpath("/html/body/div[1]/main/div/ul/li[2]/a")).click();*/
		driver.manage().window().maximize();
		Thread.sleep(3000);
		
				
		/*
		driver.findElement(By.id("registration_firstName")).sendKeys("jennifer");
		driver.findElement(By.id("registration_lastName")).sendKeys("Roncancio");
		driver.findElement(By.id("registration_email")).sendKeys("jenniferyy@gmail.com");
		driver.findElement(By.id("registration_nationalRegistrationNumber")).sendKeys("1030254666");
		driver.findElement(By.id("registration_password")).sendKeys("Temporal153$.HUI&$");
		driver.findElement(By.cssSelector(".form-label[for='registration_subscribedToNewsletter'")).isSelected();
		driver.findElement(By.cssSelector(".form-label[for='registration_acceptTerms'")).click();
		driver.findElement(By.xpath("//button[contains(.,'Completar registro')]")).click();			
		*/
		
		Thread.sleep(3000);
		driver.navigate().refresh();
		Thread.sleep(3000);
		driver.findElement(By.id("open-left-menu")).click();
		Thread.sleep(3000);
		driver.findElement(By.cssSelector("a[title='Libros y Música']")).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath("//*[@id='catalogue-product-container']/div[6]/a[1]/div[2]/p/span")).click();
		Thread.sleep(3000);
		driver.findElement(By.cssSelector(".product-quantity-container .select-dropdown")).click();
		Thread.sleep(3000);
		driver.findElement(By.cssSelector(".select-dropdown-list-item[data-value='1']")).click();
		String SelectedQuantity = driver.findElement(By.cssSelector(".select-dropdown-list-item[data-value='1']")).getText();
		
		String price = driver.findElement(By.cssSelector(".product-price .product-price-container .price-main-md")).getText();		
		price = price.replace("$", "");
		price = price.replace(".", "");		
		int priceInt = Integer.parseInt(price);			
		System.out.println(priceInt);
		
		int quantity = Integer.parseInt(SelectedQuantity);
		System.out.println(quantity);
	
		int Total = priceInt * quantity;
		System.out.println(Total+"");
		
		driver.findElement(By.cssSelector(".product-price #buy-now")).click();
		Thread.sleep(3000);
		String Message = driver.findElement(By.cssSelector(".modal-dialog-fluid.success .alert-header .alert-text")).getText();
		System.out.println(Message);
		Thread.sleep(3000);
		String MessageQuemado = "Tu producto se agregó al carrito";
		if (Message.equals(MessageQuemado)) {
			System.out.println("Ok");
		} else System.out.println("El mensaje de producto agregado no coincide");
			
		driver.findElement(By.cssSelector(".btn-go-to-cart.added-product")).click();
		String TotalCart = driver.findElement(By.cssSelector(".price-main-sm.pull-xs-right.subtotal-price")).getText();
		
		System.out.println(TotalCart);
		
		TotalCart = TotalCart.replace("$", "");
		TotalCart = TotalCart.replace(".", "");
		int TotalCartInt = Integer.parseInt(TotalCart);
		System.out.println(TotalCartInt);
		
		String Envio = driver.findElement(By.xpath("//li//span[@class='price-base-md pull-xs-right shipping-price']")).getText();
		int TotalEnv;
		int EnvioInt;
		
		if (Envio.equals("Envío gratis"))
		{
			TotalEnv = TotalCartInt;
		}else {
			
			Envio = Envio.replace("$", "");
			Envio = Envio.replace(".", "");
			EnvioInt = Integer.parseInt(Envio);
				System.out.println("Envio= "+EnvioInt+", TotalCartInt = "+TotalCartInt);
			TotalEnv = TotalCartInt + EnvioInt;
			Total = Total + EnvioInt;
			
		}
		System.out.println("TotalEnv="+TotalEnv +"Total="+Total);
		if (TotalEnv == Total) {
			System.out.println("Ok. Total("+TotalCartInt+")+Envio("+Envio+") = $ "+TotalEnv);
			
		} else System.out.println("El Total del producto agregado no coincide /TotalEnv=$"+TotalEnv);
		
		
		
		//driver.findElement(By.cssSelector(".select-dropdown.select-dropdown-product-quantity span[id='selected-option-product-quantity']")).click();
		//Thread.sleep(6000);
				
		//driver.close();

	}

}
