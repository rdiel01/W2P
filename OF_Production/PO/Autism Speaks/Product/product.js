function SpecFormCustomizations($scope) {

        $scope.theLogo = $scope.getSpecification('Logo');

        $scope.theColor = $scope.getSpecification('PreviewColor');

        $scope.theModelList = $scope.modelList;

        $scope.tableBottom = true;
 

  }

setTimeout(function() {
var td = document.getElementsByTagName("td");
for(var i=0;i<td.length; i++) {
    switch(td[i].innerHTML) {
        case "HG":
            td[i].innerHTML = "Heather Grey";
            break;
        case "B":
            td[i].innerHTML = "Black";
            break;
        default:
            break;
    }
}
    }, 0);
