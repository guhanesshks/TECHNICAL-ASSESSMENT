package com.runner;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import io.cucumber.junit.CucumberOptions.SnippetType;

@RunWith(Cucumber.class)
@CucumberOptions(tags = "@Reg", features = "src\\test\\resources\\Features", glue = "com.steps", snippets = SnippetType.CAMELCASE, dryRun = false, monochrome = true, stepNotifications = true)
public class TestRunner {

}
