<!DOCTYPE html>
<html ng-app="clock">

<head>
  <meta charset="utf-8" />
  <title>Digital clock</title>
  <script src="https://ajax.googleapis.com/ajax/libs/angularjs/1.2.23/angular.min.js"></script>
  <script>
      var app = angular.module('clock', []);

app.directive("digitalClock", function($timeout, dateFilter) {
  return {
    restrict: 'E',
    link: function(scope, iElement) {
      (function updateClock() {
        iElement.text(dateFilter(new Date(), 'yyyy-MM-dd HH:mm:ss EEEE'));
        $timeout(updateClock, 1000);
      })();
    }
  };
});
  </script>
</head>

<body>
    <h1 style="color: blue">
        <digital-clock></digital-clock>
    </h1>
</body>

</html>