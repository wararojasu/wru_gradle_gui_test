package wru_gradle_gui_test;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import stepdefs.MySteps;

public class Hooks {
	
	@Before
    public void beforeScenario(){

        System.out.println("This will run before the Scenario");
    }	
	
	@After
    public void afterScenario(){
        System.out.println("This will run after the Scenario");
		MySteps.driver.quit();
    }
}
