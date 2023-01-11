package stepDefinition;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageObject.TestCase1Object;

public class TestCase1StepDef {

	
	WebDriver Driver ; 
	
	// Initialisation de la page object
	
	private TestCase1Object Patient = new TestCase1Object (Driver) ;
	
	
	// Creation d'un constructeur
	
        public TestCase1StepDef () {
		Driver = hooks.Setup.Driver; 
		PageFactory.initElements(Driver,TestCase1Object.class);
	}
	
		
	@Given("Open URL")
	public void open_url() throws InterruptedException {
	  Driver.get("https://demo.openmrs.org/openmrs/login.htm"); 
	  Thread.sleep(2000);
	}

	@And("Login and validate Login is Successful")
	public void login_and_validate_login_is_successful() {
	  Patient.SaisirUsername();
	  Patient.SaisirPassword();
	  Patient.SaisirLocation();
	  Patient.ClickLoginButton();
	  Patient.VerificationMessageLogin();
	}

	@When("Click on Register a Patient")
	public void click_on_register_a_patient() {
	  Patient.ClickRegisterPatient();
	  Patient.ValidateRegisterPage();
	}

	@And("Enter all the relevant patient details")
	public void enter_all_the_relevant_patient_details() {
	    Patient.PatientName();
	    Patient.PatientGender();
	    Patient.PatientBirthday();
	    Patient.PatientAdress();
	    Patient.PatientPhoneNumber();
	    Patient.PatientRelated();
	}

	@And("Confirm the Details and capture Patient ID")
	public void confirm_the_details_and_capture_patient_id() {
	   Patient.ConfirmSubmission();
	Patient.CapturePatientId();
	}

	@And("Click on Show Contact info and validate the patient details u entered in earlier step")
	public void click_on_show_contact_info_and_validate_the_patient_details_u_entered_in_earlier_step() {
	   Patient.ValidatePatientDetails();
	}

	@And("Go back to Home page and Click on Find Patient Record")
	public void go_back_to_home_page_and_click_on_find_patient_record() {
	    Patient.ClickFindPatient();
	}

	@And("Search By Patient ID")
	public void search_by_patient_id() {
	  
	}

	@And("validate Details are Displayed. Check name, id, age and date of birth")
	public void validate_details_are_displayed_check_name_id_age_and_date_of_birth() {
	    
	}

	@And("Search By Patient Name")
	public void search_by_patient_name() {
	    Patient.SearchByName();
	}

	@And("validate details are correctly displayed. Check name, id, age and date of birth")
	public void validate_details_are_correctly_displayed_check_name_id_age_and_date_of_birth() {
	    
	}

	@Then("Display a successful message")
	public void display_a_successful_message() {
	   System.out.println("Test case runned successfully");
	}

	
	
}
