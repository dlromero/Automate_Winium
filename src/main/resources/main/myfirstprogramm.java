import java.io.File;
import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.winium.DesktopOptions;
import org.openqa.selenium.winium.WiniumDriver;
import org.openqa.selenium.winium.WiniumDriverService;

public class myfirstprogramm {


	public static void main(String[] args) throws InterruptedException, IOException {

		WebDriver driver = null;
		String notepadApplicationPath = "C:\\Windows\\System32\\notepad.exe";
		String winiumDriverPath = "C:\\Users\\daromero\\Documents\\SeleniumDrivers\\Winium.Desktop.Driver.exe";
		// before start another session
		Process process = Runtime.getRuntime().exec("taskkill /F /IM Winium.Desktop.Driver.exe");
		process.waitFor();
		process.destroy();
		DesktopOptions options = new DesktopOptions(); // Initiate Winium Desktop Options
		options.setApplicationPath(notepadApplicationPath); // Set notepad application path
		WiniumDriverService service = new WiniumDriverService.Builder()
				.usingDriverExecutable(new File(winiumDriverPath)).usingPort(9999).withVerbose(true).withSilent(false)
				.buildDesktopService();
		service.start(); // Build and Start a Winium Driver service
		Thread.sleep(5000);
		driver = new WiniumDriver(service, options); // Start a winium driver
		// Thread.sleep(10000);

		// Thread.sleep(5000);
		driver.findElement(By.name("Format")).click();
		// Thread.sleep(1000);
		driver.findElement(By.name("Font...")).click();
		// Thread.sleep(1000);
		driver.findElement(By.name("Bold")).click();
		// Thread.sleep(1000);
		driver.findElement(By.name("OK")).click();
		// Thread.sleep(1000);
		driver.findElement(By.className("Edit")).sendKeys("Welcome to Belltech");
		// Thread.sleep(1000);
		driver.findElement(By.name("File")).click();
		// Thread.sleep(1000);
		driver.findElement(By.name("Save")).click();
		Thread.sleep(1000);
		driver.findElement(By.name("File name:")).sendKeys("belltech");
		Thread.sleep(1000);
		driver.findElement(By.name("Save")).click();
		Thread.sleep(1000);
		driver.findElement(By.name("Close")).click();

	}

}
