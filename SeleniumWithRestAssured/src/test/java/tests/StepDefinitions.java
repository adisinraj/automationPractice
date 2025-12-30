package tests;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;

public class StepDefinitions {

    @Given("URL is set")
    public void url_is_set(){
        System.out.println("URL is set");
    }

    @When("driver is initialized")
    public void driver_is_initialized(){
        System.out.println("driver is initialized");
    }

    @Then("i am {string}")
    public void i_am(String param){
        System.out.println("i am "+param);
        Assert.assertEquals(param,"relieved");
    }
}
