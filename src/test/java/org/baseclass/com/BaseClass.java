package org.baseclass.com;

	

	import java.io.BufferedWriter;
	import java.io.File;
	import java.io.FileInputStream;
	import java.io.FileNotFoundException;
	import java.io.FileOutputStream;
	import java.io.FileReader;
	import java.io.IOException;
	import java.text.SimpleDateFormat;
	import java.util.Date;
	import java.util.Properties;
	import java.util.concurrent.TimeUnit;

	import org.apache.poi.ss.usermodel.Cell;
	import org.apache.poi.ss.usermodel.DataFormatter;
	import org.apache.poi.ss.usermodel.DateUtil;
	import org.apache.poi.ss.usermodel.Row;
	import org.apache.poi.ss.usermodel.Sheet;
	import org.apache.poi.ss.usermodel.Workbook;
	import org.apache.poi.xssf.usermodel.XSSFWorkbook;
	import org.apache.poi.xssf.usermodel.XSSFWorkbookType;
	import org.openqa.selenium.By;
	import org.openqa.selenium.WebDriver;
	import org.openqa.selenium.WebElement;
	import org.openqa.selenium.chrome.ChromeDriver;
	import org.openqa.selenium.edge.EdgeDriver;
	import org.openqa.selenium.firefox.FirefoxDriver;
	import org.openqa.selenium.support.ui.Select;

	import io.github.bonigarcia.wdm.WebDriverManager;
	public class BaseClass {


		public static WebDriver driver;
		public static Select option;
		public static XSSFWorkbookType file;
		public static BufferedWriter writer;
		
		public static Properties props;
		
	public static void loadDriver(String name) {
			
			switch (name) {
			case "chrome":
				WebDriverManager.chromedriver().setup();
				driver = new ChromeDriver();
				driver.manage().window().maximize();
				break;
			case "firefox":
				WebDriverManager.firefoxdriver().setup();
				driver = new FirefoxDriver();
				driver.manage().window().maximize();
				break;
			case "edge":
				WebDriverManager.edgedriver().setup();
				driver = new EdgeDriver();
				driver.manage().window().maximize();
				break;	
			default:
				System.out.println("unable to find the browser");
				break;
			}
		}
		
		public static void setProperty(String propertykey, String propertyvalue) {

			System.setProperty(propertykey, propertyvalue);
			driver = new ChromeDriver();
		}

		public static void launch(String url) {
			driver.manage().window().maximize();
			driver.get(url);
		}
			
		public static WebElement findelementByXpath(String Xpath) {
			return driver.findElement(By.xpath(Xpath));	
			
		}
		public static String getText(WebElement element) {
			
			return element.getText();
		}
		
		public static WebElement findelementById(String id) {
			return driver.findElement(By.id(id));	
			
		}
		public static void sendKeys(WebElement element,String value) {
			
			element.sendKeys(value);
		}

		public static void clickButton (WebElement element) {
			element.click();
			
		}
		public static void clear(WebElement element) {
			element.clear();
		}
		
		public static void dropDown(WebElement element, String value) {
			Select option = new Select(element);
			option.selectByVisibleText(value);
			
		
		}
		public static void dropDownIndex(WebElement element, int value) {
			Select option = new Select(element);
			option.selectByIndex(value);
			
		
		}

		
		public static void implicitWait(int sec) {
			driver.manage().timeouts().implicitlyWait(sec, TimeUnit.SECONDS);
		}
		
		public static void fileHandling(String path) throws IOException {
			WebElement num = driver.findElement(By.xpath("//input[@name='order_no']"));
			String a = num.getAttribute("value");
			System.out.println(a);
			FileInputStream fis = new FileInputStream(path);
			Workbook wb = new XSSFWorkbook(fis);
			
			Sheet createSheet = wb.createSheet("Fareetha");
			Row createRow = createSheet.createRow(0);
			Cell createCell = createRow.createCell(0);
			createCell.setCellValue(a);
			FileOutputStream fos = new FileOutputStream(path);
			wb.write(fos);
			wb.close();

		}
		
		public static  String xcell(int row1, int cell1) throws IOException{
			String value = null;
			File f = new File("C:\\Users\\FAREETHA\\eclipse-workspace\\SampleMaven\\src\\test\\resources\\org\\excel\\Details.xlsx");
			try {
				FileInputStream fis = new FileInputStream(f);
				
				
				Workbook wb = new XSSFWorkbook(fis);
				
				Sheet sh = wb.getSheet("Sheet1");
				Row row = sh.getRow(row1);
				Cell cell = row.getCell(cell1);
				
			
				int cellType = cell.getCellType();
				if (cellType == 1) {
					value = cell.getStringCellValue();
					System.out.println(value);
				} else if (cellType == 0) {
				
					if (DateUtil.isCellDateFormatted(cell)) {
						Date dateCellValue = cell.getDateCellValue();
				
						SimpleDateFormat sc = new SimpleDateFormat("dd-MMM-yyyy");
						value = sc.format(dateCellValue);
						System.out.println(value);
					} else {
						double numericCellValue = cell.getNumericCellValue();
					
						long a = (long) numericCellValue;
						value = String.valueOf(a);
						System.out.println(value);

					}
				}
			} catch (FileNotFoundException e) {
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return value;
		}
		public static String dataProp(String key) throws IOException {
			
			FileReader read = new FileReader("C:\\Users\\FAREETHA\\eclipse-workspace\\SampleMaven\\src\\test\\resources\\Sample.properties");
			props =new Properties();
			props.load(read);
			String value = props.getProperty(key);         
				
		return value;
		
	}
		
	}



