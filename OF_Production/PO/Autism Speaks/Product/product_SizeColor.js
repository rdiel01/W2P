function SpecFormCustomizations($scope) {

        $scope.theSize.getSpecification('Logo');

        $scope.theColor = $scope.getSpecification('Color');

        $scope.theModelList = $scope.modelList;

        $scope.tableBottom = true;
 

  }

setTimeout(function() {
var td = document.getElementsByTagName("td");
for(var i=0;i<td.length; i++) {
    switch(td[i].innerHTML) {
        case "SGW":
            td[i].innerHTML = "Steel Grey/White";
            break;
        case "BSG":
            td[i].innerHTML = "Black/Steel Grey";
            break;
        default:
            break;
    }
}
    }, 0);
