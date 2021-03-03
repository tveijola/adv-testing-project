package com.company.modelimplementations;

import com.company.Tournaments;
import com.github.javafaker.Faker;

import org.graphwalker.core.machine.ExecutionContext;
import org.graphwalker.java.annotation.GraphWalker;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.*;

@GraphWalker(value = "random(edge_coverage(100))")
public class TournamentsTest extends ExecutionContext implements Tournaments {

  // PAGE VERTICES ------------------------

  @Override
  public void v_Tournaments() {
    $(By.className("body-20")).shouldHave(text("Tournament list - Coronate"));
  }

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

  // --------------------------------------
  // PAGE EDGES ---------------------------

  public @Override void e_Tournaments() {
    $(By.cssSelector("a[href=\"#/tourneys\"]")).click();
  }

  public @Override void e_Players() {
    $(By.cssSelector("a[href=\"#/players\"]")).click();
  }

  public @Override void e_Options() {
    $(By.cssSelector("a[href=\"#/options\"]")).click();
  }

  public @Override void e_TimeCalculator() {
    $(By.cssSelector("a[href=\"#/timecalc\"]")).click();
  }

  // --------------------------------------
  // ACTION VERTICES ----------------------

  @Override
  public void v_NewTournament() {
    $(By.xpath("//fieldset/legend")).shouldHave(text("Make a new tournament"));
  }

  @Override
  public void v_DeleteTournament() {
    System.out.println("Delete text: " + switchTo().alert().getText());
  }

  // --------------------------------------
  // ACTION EDGES -------------------------

  @Override
  public void e_AddTournament() {
    $(By.xpath("//button[text()=\" Add tournament\"]")).click();
  }

  @Override
  public void e_Close() {
    $(By.xpath("//button[text()=\"Close\"]")).click();
  }

  @Override
  public void e_AddTournamentSuccess() {
    $(By.id("tourney-name")).clear();
    $(By.id("tourney-name")).sendKeys(new Faker().funnyName().name());
    $(By.className("button-primary")).click();
  }

  @Override
  public void e_DeleteTournament() {
    $(By.xpath("//tbody/tr")).hover().$(By.className("button-ghost")).click();
  }

  @Override
  public void e_CancelDelete() {
    switchTo().alert().dismiss();
  }

  @Override
  public void e_ConfirmDelete() {
    switchTo().alert().accept();
  }

  // --------------------------------------
}
