package pageObject;

import org.junit.Assert;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class TestCase1Object {

	
	//Identification des WebElements
	
	@FindBy (how = How.ID , using = "username" ) 
	public static WebElement  User ;
	
	@FindBy (how = How.ID , using = "password" ) 
	public static WebElement Mdp ; 
	
	@FindBy (how = How.ID , using = "Inpatient Ward" )
	public static WebElement Location ;
	
	@FindBy (how = How.ID , using = "loginButton" )
	public static WebElement LoginButton ;
	
	@FindBy (how = How.XPATH , using = "//div[@class='col-12 col-sm-12 col-md-12 col-lg-12']")
	public static WebElement ValidateLogin ;
	
	@FindBy (how =How.XPATH , using = "//a[@id='referenceapplication-registrationapp-registerPatient-homepageLink-referenceapplication-registrationapp-registerPatient-homepageLink-extension']")
	public static WebElement RegisterPatientButton ; 
	
	@FindBy (how = How.ID , using = "//h2[normalize-space()='Register a patient']")
	public static WebElement ValidateRegisterPage ; 
	
	@FindBy (how = How.NAME , using = "givenName")  
	public static WebElement Given ;
	
	@FindBy (how = How.NAME , using = "middleName")
	public static WebElement Middle ;
	
	@FindBy (how = How.NAME , using = "familyName")
	public static WebElement Family ;
	
	@FindBy (how = How.ID , using = "next-button")
	public static WebElement NextButton;
	
	@FindBy (how = How.ID , using = "gender-field")
	public static WebElement Gender ;
	
	@FindBy (how = How.ID , using = "birthdateDay-field")
	public static WebElement Day ;
	
	@FindBy (how = How.ID , using = "birthdateMonth-field")
	public static WebElement Month ;
	
	@FindBy (how = How.ID , using = "birthdateYear-field")
	public static WebElement Year;
	
	@FindBy (how = How.ID , using = "address1")
	public static WebElement Adress;
	
	@FindBy (how = How.NAME , using = "phoneNumber")
	public static WebElement PhoneNumber;
	
	@FindBy (how = How.ID , using = "relationship_type")
	public static WebElement RelationType;
	
	@FindBy (how = How.XPATH , using = "//input[@placeholder='Person Name']")
	public static WebElement RelatedPersonName;
	
	@FindBy (how = How.XPATH , using = "//input[@id='submit']")
	public static WebElement ConfirmButton;
	
	@FindBy (how = How.XPATH , using = "//div[@class='float-sm-right']")
	public static WebElement PatientId;
	
	@FindBy (how = How.ID , using = "coreapps-showContactInfo")
	public static WebElement ContactInfoButton;
	
	@FindBy (how = How.ID , using = "coreapps-telephoneNumber")
	public static WebElement InfoNumber;
	
	@FindBy (how = How.XPATH , using ="//i[@class='icon-home small']")
	public static WebElement Home; 
	
	@FindBy (how = How.ID , using ="coreapps-activeVisitsHomepageLink-coreapps-activeVisitsHomepageLink-extension")
	public static WebElement FindPatientButton; 
	
	@FindBy (how = How.XPATH , using = "//h2[normalize-space()='Find Patient Record']")
	public static WebElement ValidateFindPatientPage ; 
	
	@FindBy (how = How.ID , using = "patient-search")
	public static WebElement PatientSearch ;
	
	
	
	
	
	//Creation d'un constructeur
	
		public WebDriver Driver; 
		
		public TestCase1Object (WebDriver Driver) {
		
			this.Driver = Driver; 
			
			PageFactory.initElements(Driver, this);
				
		}
	
	
		
	//Creation des methodes	
		
		public void SaisirUsername () {
			User.sendKeys("admin");
		}
		
		public void SaisirPassword () {
			Mdp.sendKeys("Admin123");
		}
		
		public void SaisirLocation () {
			Location.click();
		}
		
		public void ClickLoginButton () {
			LoginButton.click();
		}	
		
		public void VerificationMessageLogin () {
			String VerificationLogin = ValidateLogin.getText() ;
			Assert.assertEquals("Logged in as Super User (admin) at Inpatient Ward.", VerificationLogin);
			System.out.println("validate Login is Successful"); 
			
		}
		
		public void ClickRegisterPatient () {
		    RegisterPatientButton.click();
		}
		
		public void ValidateRegisterPage () {
			String VerificationRegisterPage = ValidateRegisterPage.getText(); 
			Assert.assertEquals( "Register a patient" , VerificationRegisterPage);
			System.out.println("Register Page Done");
		}
		
		public void PatientName () {
			Given.sendKeys("Patient2");
			Middle.sendKeys("Chakroun");
			Family.sendKeys("Chakroun");
			NextButton.click();
		}
		
		public void PatientGender () {
			Select SelectGender = new Select (Gender); 
			SelectGender.selectByValue("F"); 
			NextButton.click();
		}
		
		public void PatientBirthday () {
		    Day.sendKeys("01");
		    Select SelectMonth = new Select (Month); 
		    SelectMonth.selectByValue("1");
		    Year.sendKeys("1980");
		    NextButton.click();
		}
		
		public void PatientAdress () {
		    Adress.sendKeys("adresse du patient");
		    NextButton.click();
		}
		
		public void PatientPhoneNumber () {
		    PhoneNumber.sendKeys("586222");
		    NextButton.click();
		}
		
		public void PatientRelated () {
			Select SelectRelationType = new Select (RelationType); 
			SelectRelationType.selectByValue("8d919b58-c2cc-11de-8d13-0010c6dffd0f-B");
			RelatedPersonName.sendKeys("Arwa");
		    NextButton.click();
		}
		
		public void ConfirmSubmission () {
		    ConfirmButton.click();
		}
		
		public void CapturePatientId () {
			
			String ID = PatientId.getText();
			System.out.println(ID);
			
		    // Actions action = new Actions (Driver) ;
		    // action.keyDown(PatientId, Keys.CONTROL).sendKeys("a").keyUp(Keys.CONTROL).perform();
		    // action.keyDown(Keys.CONTROL).sendKeys("c").keyUp(Keys.CONTROL).perform();
		}
		
		public void ValidatePatientDetails() {
		    ContactInfoButton.click();
			String ValidatePhoneNumber = InfoNumber.getText(); 
			Assert.assertEquals("586222", ValidatePhoneNumber);
			System.out.println("Patient details are valid");
		}
		
		public void ClickFindPatient() {
			Home.click();
			FindPatientButton.click();
			String VerificationFindPatientPage = ValidateFindPatientPage.getText(); 
			Assert.assertEquals( "Find Patient Record" , VerificationFindPatientPage);
			System.out.println("Find Patient Page Done");
		}
		
		public void SearchByName () {
			PatientSearch.sendKeys("Patient2");
			System.out.println("Patient is found");
		}
		
                                   
    
		
}
