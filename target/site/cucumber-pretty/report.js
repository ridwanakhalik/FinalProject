$(document).ready(function() {var formatter = new CucumberHTML.DOMFormatter($('.cucumber-report'));formatter.uri("Dskay.feature");
formatter.feature({
  "line": 2,
  "name": "DarkSky Register Error Message",
  "description": "",
  "id": "darksky-register-error-message",
  "keyword": "Feature",
  "tags": [
    {
      "line": 1,
      "name": "@web"
    },
    {
      "line": 1,
      "name": "@regression"
    },
    {
      "line": 1,
      "name": "@sprint"
    }
  ]
});
formatter.before({
  "duration": 5125724123,
  "status": "passed"
});
formatter.background({
  "line": 3,
  "name": "",
  "description": "",
  "type": "background",
  "keyword": "Background"
});
formatter.scenario({
  "line": 15,
  "name": "Verify Current Temperature should not be greater or less than the temperature from daily timeline",
  "description": "",
  "id": "darksky-register-error-message;verify-current-temperature-should-not-be-greater-or-less-than-the-temperature-from-daily-timeline",
  "type": "scenario",
  "keyword": "Scenario",
  "tags": [
    {
      "line": 14,
      "name": "@sprint_2"
    }
  ]
});
formatter.step({
  "line": 16,
  "name": "I am on darksky",
  "keyword": "Given "
});
formatter.step({
  "line": 17,
  "name": "I verify current temp is not greater or less than temps from daily timeline",
  "keyword": "Then "
});
formatter.match({
  "location": "CurrentTempSD.IAmOnDarkShy()"
});
formatter.result({
  "duration": 1017742353,
  "status": "passed"
});
formatter.match({
  "location": "CurrentTempSD.verifyCurrentTempBoundary()"
});
formatter.result({
  "duration": 917367471,
  "status": "passed"
});
formatter.after({
  "duration": 175764905,
  "status": "passed"
});
});