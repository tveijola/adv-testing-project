package com.company.modelimplementations;

import com.company.Players;
import com.github.javafaker.Faker;

import org.graphwalker.core.machine.ExecutionContext;
import org.graphwalker.java.annotation.GraphWalker;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.*;

@GraphWalker(value = "random(edge_coverage(100))")
public class PlayersTest extends ExecutionContext implements Players {

  // PAGE VERTICES ------------------------

  @Override
  public void v_Players() {
    $x("//table").shouldHave(text("Player roster"));
  }

  @Override
  public void v_Options() {
    $(By.tagName("h2")).shouldHave(text("Bye settings"));
  }

  @Override
  public void v_TimeCalculator() {
    $(By.tagName("h1")).shouldHave(text("Time calculator"));
  }

  // ---------------------------------------
  // PAGE EDGES ----------------------------

  @Override
  public void e_Players() {
    $(By.cssSelector("a[href=\"#/players\"]")).click();

  }

  @Override
  public void e_Options() {
    $(By.cssSelector("a[href=\"#/options\"]")).click();
  }

  @Override
  public void e_TimeCalculator() {
    $(By.cssSelector("a[href=\"#/timecalc\"]")).click();
  }

  // ---------------------------------------
  // ACTION VERTICES -----------------------

  @Override
  public void v_AddNewPlayer() {
    // $(By.className("button-micro")).shouldHave(text("Close"));
    $(By.xpath("//fieldset/legend")).shouldHave(text("Register a new player"));
  } 

  @Override
  public void v_DeletePlayer() {
    System.out.println("Delete text: " + switchTo().alert().getText());
  }

  // ---------------------------------------
  // ACTION EDGES --------------------------

  @Override
  public void e_AddNewPlayer() {
    $(By.xpath("//button[text()=\" Add a new player\"]")).click();
  }

  @Override
  public void e_AddPlayerSuccess() {
    $(By.name("firstName")).clear();
    $(By.name("firstName")).sendKeys(new Faker().name().firstName());
    $(By.name("lastName")).clear();
    $(By.name("lastName")).sendKeys(new Faker().name().lastName());
    // $(By.id("form-newplayer-rating")).clear();
    // $(By.id("form-newplayer-rating")).sendKeys("1000");
    $(By.xpath("//button[text()=\"Add\"]")).click();
  }

  @Override
  public void e_Close() {
    $(By.xpath("//button[text()=\"Close\"]")).click();
  }

  @Override
  public void e_DeletePlayer() {
    $(By.xpath("//tbody/tr")).hover().$(By.className("button-ghost")).click();
  }

  @Override
  public void e_ConfirmDelete() {
    switchTo().alert().accept();
  }

  @Override
  public void e_CancelDelete() {
    switchTo().alert().dismiss();
  }

  // ---------------------------------------

}
