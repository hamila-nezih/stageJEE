<!DOCTYPE html>
<html ng-app>
<head>
    <title>Hello World, AngularJS - ViralPatel.net</title>
    <script type="text/javascript"
        src="classpath*:static/angularjs/angular.min.js"></script>
 
</head>
<body>
     
    Write some text in textbox:
    <input type="text" ng-model="sometext" />
 
    <h1 ng-show="sometext">Hello {{ sometext }}</h1>
     
</body>
</html>