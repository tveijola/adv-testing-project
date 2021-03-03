package com.company.modelimplementations;

import com.company.Options;
import org.graphwalker.core.machine.ExecutionContext;
import org.graphwalker.java.annotation.GraphWalker;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.*;

@GraphWalker(value = "random(edge_coverage(100))")
public class OptionsTest extends ExecutionContext implements Options {

  // PAGE VERTICES ------------------------

  @Override
  public void v_Options() {
    $(By.tagName("h2")).shouldHave(text("Bye  settings"));
  }

  @Override
  public void v_TimeCalculator() {
    $(By.tagName("h1")).shouldHave(text("Time calculator"));
  }

  // --------------------------------------
  // PAGE EDGES ---------------------------

  @Override
  public void e_TimeCalculator() {
    $(By.cssSelector("a[href=\"#/timecalc\"]")).click();
  }

  @Override
  public void e_Options() {
    $(By.cssSelector("a[href=\"#/options\"]")).click();
  }

  // --------------------------------------
  // ACTION EDGES

  @Override
  public void e_SetByeSettings() {
    $(By.tagName("input")).click();
  }

  // --------------------------------------

}
