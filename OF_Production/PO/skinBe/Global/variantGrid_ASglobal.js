//variant list product - preview image script - apply dropdown selection to grid - ordering grid minimum quantity lockout
        marketFluxModule.directive('specFormCustomizations', function ($compile) {
            var controller = [
                '$scope', '$timeout', function ($scope, $timeout) {
                    //Call defined customization function (Per product stuff)
                    SpecFormCustomizations($scope);
    
                    if ($scope.tableBottom) {
                        $timeout(function() {
                            $('div table').insertAfter('div[ng-include*="addToCartForVariants"]');
                            $('<br />').insertAfter('div table')
                        }, 1500);
                    }
    
                    $scope.$watch('theLogo.Selected', function (val) {
    
                        console.log('the logo changed: ' + val);
    
                        updatePreview();
                        updateVariant();
    
                            
                    });

                    $scope.$watch('theSize.Selected', function (val) {
    
                        console.log('the size changed: ' + val);
    
                        updatePreview();
                        updateVariant();
    
                            
                    });

                    $scope.$watch('theModelList', function (val) {

                        console.log('The modelList changed');

                        checkTotalQuantity();

                    },true);

                    $scope.$watch('theColor.Selected', function (val) {
    
                        console.log('the color changed: ' + val);
    
                        updatePreview();
    
                            
                    });

                    function checkTotalQuantity() {
                        var totalQty = 0;

                        angular.forEach($scope.theModelList, function(value) {
                            if (parseInt(value.Product.Quantity)) {
                                totalQty += parseInt(value.Product.Quantity);

                                } else {
                                totalQty+=0;
                           }});

                        console.log('Total Qty: '+totalQty);
                        if (totalQty >= parseInt($scope.model.Product.MinimumOrderQuantity)) {
                            console.log('Minimum quantity met');
                            enableAddToCart();
                        } else {

                            disableAddToCart();

                        }
                        
                    }

                    function enableAddToCart() {

                        console.log('Add to cart enabled');
                        angular.forEach($('.buttons_bottom_block'), function(value) {
                            value.childNodes[1].disabled = false;
                        } )

                    }

                    function disableAddToCart() {

                        console.log('Add to cart disabled');
                        angular.forEach($('.buttons_bottom_block'), function(value) {
                            value.childNodes[1].disabled = true;
                        } )

                    }
    
                    // updates the preview image
                    function updatePreview() {
    
                        console.log(' in updatePreview');
    
                        console.log($scope);
    
                        var thumbImage, previewImage;
    
                        // get color spec val
                        var currentColor = $scope.theColor.Selected;
                        var currentLogo = $scope.theLogo.Selected;
    
                        if (currentColor !== '' && currentLogo !== '') {
                            // find spec - file attachment
                            var previewColorSpec = $scope.theColor.Selected;
                            var previewLogoSpec = $scope.theLogo.Selected;

                            var previewSpecCode = previewColorSpec + previewLogoSpec;
                            var previewSpec = $scope.getSpecification(previewSpecCode);

                            if (previewSpec) {
                                console.log('preview spec found: ');
                                console.log(previewSpec);
                                thumbImage = previewSpec.SelectedFile.ThumbnailUrl;
                                previewImage = previewSpec.SelectedFile.Url;
                            } else {
                                console.log('preview spec not found');
                                // set back to default
                                thumbImage = $scope.model.Product.SmallProductImage.Url;
                                previewImage = $scope.model.Product.LargeProductImage.Url;
                            }
                        } else {
                            // set back to default
                            thumbImage = $scope.model.Product.SmallProductImage.Url;
                            previewImage = $scope.model.Product.LargeProductImage.Url;
                        }
    
                        // update href on bigpic and other one
                        $('#bigpic').attr('src', thumbImage);
                        $('#productImageZoom').attr('href', thumbImage);
                        
                    }
                
                    // updates the preview image
                    function updateVariant() {
    
                        console.log(' in updateVariant');
    
                        console.log($scope);
    
                        // get color spec val
                        var currentLogo = $scope.theLogo.Selected;
                        var variantGrid = $scope.modelList; 

                        if ( currentLogo ) {

                            console.log('Updating logo variant to '+currentLogo);

                            // find spec - file attachment
                            for (var i = 0; i < variantGrid.length; i++) {
                                for (var j = 0; j < variantGrid[i].Specifications.length; j++){
                                    if (variantGrid[i].Specifications[j].Key == "Logo") {
                                        variantGrid[i].Specifications[j].Selected = currentLogo;
                                    }
                                }
                            }
                        }
                                 
                    }
                }
            ];
    
            return {
                controller: controller
            }
        });
