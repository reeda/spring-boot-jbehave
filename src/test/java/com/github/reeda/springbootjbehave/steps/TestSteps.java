package com.github.reeda.springbootjbehave.steps;

import com.github.reeda.springbootjbehave.IntegrationTestSession;
import org.jbehave.core.annotations.Given;
import org.jbehave.core.annotations.Named;
import org.jbehave.core.annotations.Then;
import org.jbehave.core.annotations.When;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;

/**
 * Created by andrew on 11/18/15.
 */
@Component
public class TestSteps {

    @Autowired
    private ApplicationContext applicationContext;

    private IntegrationTestSession testSession;
    private int result;

    @Given("a variable x with value $value")
    public void givenXValue(@Named("value") int value) {
        testSession = applicationContext.getBean(IntegrationTestSession.class);
        testSession.setX(value);
    }

    @When("I multiply x by $value")
    public void whenImultiplyXBy(@Named("value") int value) {
        result = testSession.multiply(value);
    }

    @Then("result should equal $value")
    public void thenXshouldBe(@Named("value") int value) {
        if (value != result)
            throw new RuntimeException("result is " + result + ", but should be " + value);
    }
}
