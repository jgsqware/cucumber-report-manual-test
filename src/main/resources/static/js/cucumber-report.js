angular.module('cucumber-service', [])
    .controller('cucumber-report', function($scope, $http) {
        $http.get('/resource/').success(function(data) {
            $scope.report = data;
        });
        $scope.store = function(){
            console.log("I'm storing...")
            $http.post('/resource/', $scope.report).then(function(data){
                console.log("OK")
            }, function(data){
                console.log("Not OK" + data)
            });
        };
    });