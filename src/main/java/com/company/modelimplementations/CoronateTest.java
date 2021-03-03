package com.company.modelimplementations;

import com.company.Coronate;
import org.graphwalker.core.machine.ExecutionContext;
import org.graphwalker.java.annotation.BeforeExecution;
import org.graphwalker.java.annotation.GraphWalker;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Configuration.browser;
import static com.codeborne.selenide.Selenide.*;

@GraphWalker(value = "random(edge_coverage(100))", start = "e_StartBrowser")
public class CoronateTest extends ExecutionContext implements Coronate {

  
  // ENTRY POINT --------------------------

  @Override
  public void e_StartBrowser() {
    open("https://johnridesa.bike/coronate/");
  }

  // --------------------------------------
  // PAGE VERTICES ------------------------

  public @Override
  void v_Tournaments() {
    $(By.className("body-20")).shouldHave(text("Tournament list - Coronate"));
  }

  public @Override
  void v_Players() {
    $x("//table").shouldHave(text("Player roster"));
  }

  public @Override
  void v_Options() {
    $(By.tagName("h2")).shouldHave(text("Bye settings"));
  }

  public @Override
  void v_TimeCalculator() {
    $(By.tagName("h1")).shouldHave(text("Time calculator"));
  }

  @Override
  public void v_InfoPage() {
    $(By.tagName("h1")).shouldHave(text("Coronate"));
  }

  // --------------------------------------
  // PAGE EDGES ---------------------------

  public @Override
  void e_Tournaments() {
    $(By.cssSelector("a[href=\"#/tourneys\"]")).click();
  }

  public @Override
  void e_Players() {
    $(By.cssSelector("a[href=\"#/players\"]")).click();
  }

  public @Override
  void e_Options() {
    $(By.cssSelector("a[href=\"#/options\"]")).click();
  }

  public @Override
  void e_TimeCalculator() {
    $(By.cssSelector("a[href=\"#/timecalc\"]")).click();
  }

  public @Override
  void e_InfoPage() {
    $(By.cssSelector("a[href=\"#/\"]")).click();
  }

  // --------------------------------------
  // SETUP --------------------------------

  @BeforeExecution
  public void setup() {
    browser = "firefox";
  }
}
