$(document).ready(function() {var formatter = new CucumberHTML.DOMFormatter($('.cucumber-report'));formatter.uri("E:/TMS OPEN SOURCE PROJECT/FreeCrmBDDFramework/src/main/java/Feature/login.feature");
formatter.feature({
  "comments": [
    {
      "line": 1,
      "value": "#username and password hardcoded"
    },
    {
      "line": 2,
      "value": "#Feature: Free CRM Login feature"
    },
    {
      "line": 3,
      "value": "#Scenario: Free CRM login Test Scenario"
    },
    {
      "line": 4,
      "value": "#Given User is already on login Page"
    },
    {
      "line": 5,
      "value": "#When Title of the login page is Free CRM"
    },
    {
      "line": 6,
      "value": "#Then User enters Username and Password"
    },
    {
      "line": 7,
      "value": "#Then User clicks on Login Button"
    },
    {
      "line": 8,
      "value": "#And User is on Home Page"
    },
    {
      "line": 9,
      "value": "#Then close the browser"
    },
    {
      "line": 11,
      "value": "#Data driven testing without using Examples keywords"
    },
    {
      "line": 12,
      "value": "#Feature: Free CRM Login feature"
    },
    {
      "line": 13,
      "value": "#Scenario: Free CRM login Test Scenario"
    },
    {
      "line": 14,
      "value": "#Given User is already on login Page"
    },
    {
      "line": 15,
      "value": "#When Title of the login page is Free CRM"
    },
    {
      "line": 16,
      "value": "#Then User enters \"rakeshit0913@gmail.com\" and \"Qualix2019\""
    },
    {
      "line": 17,
      "value": "#Then User clicks on Login Button"
    },
    {
      "line": 18,
      "value": "#And User is on Home Page"
    },
    {
      "line": 19,
      "value": "#Then close the browser"
    },
    {
      "line": 22,
      "value": "#Data driven testing with using Examples keywords"
    }
  ],
  "line": 23,
  "name": "Free CRM Login feature",
  "description": "",
  "id": "free-crm-login-feature",
  "keyword": "Feature"
});
formatter.scenarioOutline({
  "line": 24,
  "name": "Free CRM login Test Scenario",
  "description": "",
  "id": "free-crm-login-feature;free-crm-login-test-scenario",
  "type": "scenario_outline",
  "keyword": "Scenario Outline"
});
formatter.step({
  "line": 25,
  "name": "User is already on login Page",
  "keyword": "Given "
});
formatter.step({
  "line": 26,
  "name": "Title of the login page is Free CRM",
  "keyword": "When "
});
formatter.step({
  "line": 27,
  "name": "User enters \"\u003cusername\u003e\" and \"\u003cpassword\u003e\"",
  "keyword": "Then "
});
formatter.step({
  "line": 28,
  "name": "User clicks on Login Button",
  "keyword": "Then "
});
formatter.step({
  "line": 29,
  "name": "User is on Home Page",
  "keyword": "And "
});
formatter.step({
  "line": 30,
  "name": "close the browser",
  "keyword": "Then "
});
formatter.examples({
  "line": 32,
  "name": "",
  "description": "",
  "id": "free-crm-login-feature;free-crm-login-test-scenario;",
  "rows": [
    {
      "cells": [
        "username",
        "",
        "password"
      ],
      "line": 33,
      "id": "free-crm-login-feature;free-crm-login-test-scenario;;1"
    },
    {
      "cells": [
        "rakeshit0913@gmail.com",
        "",
        "Qualix2019"
      ],
      "line": 35,
      "id": "free-crm-login-feature;free-crm-login-test-scenario;;2"
    }
  ],
  "keyword": "Examples"
});
formatter.scenario({
  "line": 35,
  "name": "Free CRM login Test Scenario",
  "description": "",
  "id": "free-crm-login-feature;free-crm-login-test-scenario;;2",
  "type": "scenario",
  "keyword": "Scenario Outline"
});
formatter.step({
  "line": 25,
  "name": "User is already on login Page",
  "keyword": "Given "
});
formatter.step({
  "line": 26,
  "name": "Title of the login page is Free CRM",
  "keyword": "When "
});
formatter.step({
  "line": 27,
  "name": "User enters \"rakeshit0913@gmail.com\" and \"Qualix2019\"",
  "matchedColumns": [
    0,
    2
  ],
  "keyword": "Then "
});
formatter.step({
  "line": 28,
  "name": "User clicks on Login Button",
  "keyword": "Then "
});
formatter.step({
  "line": 29,
  "name": "User is on Home Page",
  "keyword": "And "
});
formatter.step({
  "line": 30,
  "name": "close the browser",
  "keyword": "Then "
});
formatter.match({
  "location": "LoginStepDefinition.user_is_already_on_login_Page()"
});
formatter.result({
  "duration": 21019209219,
  "status": "passed"
});
formatter.match({
  "location": "LoginStepDefinition.title_of_the_login_page_is_Free_CRM()"
});
formatter.result({
  "duration": 569622622,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "rakeshit0913@gmail.com",
      "offset": 13
    },
    {
      "val": "Qualix2019",
      "offset": 42
    }
  ],
  "location": "LoginStepDefinition.user_enters_Username_and_Password(String,String)"
});
formatter.result({
  "duration": 24066792234,
  "status": "passed"
});
formatter.match({
  "location": "LoginStepDefinition.user_clicks_on_Login_Button()"
});
formatter.result({
  "duration": 741769975,
  "status": "passed"
});
formatter.match({
  "location": "LoginStepDefinition.user_is_on_Home_Page()"
});
formatter.result({
  "duration": 13702144,
  "status": "passed"
});
formatter.match({
  "location": "LoginStepDefinition.close_the_browser()"
});
formatter.result({
  "duration": 1311252773,
  "status": "passed"
});
});