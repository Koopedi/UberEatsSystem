var app = angular.module('app', []);


//Administrator
app.controller('postAdministratorController', function ($scope, $http) {
    $scope.submitAdmin = function (isValid) {

        var url = "postadministrator";

        var st = "appoved";
        var tp = "admin";

        var config = {
            headers: {
                'Content-Type': 'application/json;charset=utf-8;'
            }
        }

        var data = {
            id: $scope.id,
            firstName: $scope.firstname,
            lastName: $scope.lastname,
            email: $scope.email,
            password: $scope.password,
            phone: $scope.phone,
            status: st,
            type: tp

        };

        if (isValid) {
            $http.post(url, data, config).then(function (response) {

                function addUser() {
                    var url = "postuser";

                    var config = {
                        headers: {
                            'Content-Type': 'application/json;charset=utf-8;'
                        }
                    }

                    var data = {
                        id: $scope.id,
                        email: $scope.email,
                        password: $scope.password,
                        phone: $scope.phone,
                        status: st,
                        type: tp,
                        userName: $scope.firstname

                    };

                    $http.post(url, data, config).then(function (response) {
                     //   $scope.postResultMessage = "Sucessfully added new User!";
alert("Sucessfully added new User!");
                        $scope.id = "";
                        $scope.firstname = "";
                        $scope.lastname = "";
                        $scope.email = "";
                        $scope.password = "";
                        $scope.phone = "";

                    });
                }

                addUser();


            }, function (response) {
                $scope.postResultMessage = "Fail!";
            });
        } else {
            $scope.postResultMessage = "Enter correct user information";
        }
    }
});



//Customer
app.controller('postCustomerController', function ($scope, $http) {
    $scope.submitCustomer = function (isValid) {
        var url = "postcustomer";

        var st = "approved";
        var tp = "customer";

        var config = {
            headers: {
                'Content-Type': 'application/json;charset=utf-8;'
            }
        }

        var data = {
            id: $scope.id,
            firstName: $scope.firstname,
            lastName: $scope.lastname,
            gender: $scope.genderValue,
            email: $scope.email,
            password: $scope.password,
            phone: $scope.phone,
            status: st,
            type: tp

        };

        if (isValid) {

            $http.post(url, data, config).then(function (response) {


                //add user
                function addUser() {
                    var url = "postuser";

                    var config = {
                        headers: {
                            'Content-Type': 'application/json;charset=utf-8;'
                        }
                    }

                    var data = {
                        id: $scope.id,
                        email: $scope.email,
                        password: $scope.password,
                        phone: $scope.phone,
                        status: st,
                        type: tp,
                        userName: $scope.firstname

                    };

                    $http.post(url, data, config).then(function (response) {
                    //    $scope.postResultMessage = "Sucessfully added new User!";
                        alert("Sucessfully added new User!");
                        $scope.id = "";
                        $scope.firstname = "";
                        $scope.lastname = "";
                        $scope.genderValue = false;
                        $scope.email = "";
                        $scope.password = "";
                        $scope.phone = "";
                    });
                }

                addUser();


            }, function (response) {
                $scope.postResultMessage = "Fail!";
            });

        } else {
            $scope.postResultMessage = "Enter Correct user information";
        }
    }
});

//Driver
app.controller('postDriverController', function ($scope, $http) {
    $scope.submitDriver = function (isValid) {
        var url = "postdriver";

        var st = "appoved";
        var tp = "driver";

        var config = {
            headers: {
                'Content-Type': 'application/json;charset=utf-8;'
            }
        }

        var data = {
            id: $scope.id,
            driverName: $scope.drivername,
            streetName: $scope.streetname,
            areaName: $scope.areaname,
            city: $scope.city,
            province: $scope.province,
            email: $scope.email,
            password: $scope.password,
            phone: $scope.phone,
            status: st,
            type: tp

        };

        if (isValid) {

            $http.post(url, data, config).then(function (response) {


                //add user
                function addUser() {
                    var url = "postuser";

                    var config = {
                        headers: {
                            'Content-Type': 'application/json;charset=utf-8;'
                        }
                    }

                    var data = {
                        id: $scope.id,
                        email: $scope.email,
                        password: $scope.password,
                        phone: $scope.phone,
                        status: st,
                        type: tp,
                        userName: $scope.drivername


                    };

                    $http.post(url, data, config).then(function (response) {
                  //      $scope.postResultMessage = "Sucessfully added new User!";
alert("Sucessfully added new User!");
                    });
                }

                addUser();
                $scope.id = "";
                $scope.drivername = "";
                $scope.streetname = "";
                $scope.areaname = "";
                $scope.city = "";
                $scope.province = "";
                $scope.email = "";
                $scope.password = "";
                $scope.phone = "";

            }, function (response) {
                $scope.postResultMessage = "Fail!";
            });
        } else {
            $scope.postResultMessage = "Enter correct user information";
        }

    }
});



//Product
app.controller('postProductController', function ($scope, $http) {
    $scope.showAllRestaurant1 = false;
    $scope.getAllRestaurant1 = function ()
    {

        var url = "getallrestuarant";
        var config = {
            headers: {
                'Content-Type': 'application/json;charset=utf-8;'
            }
        }
        $http.get(url, config).then(function (response)
        {
            if (response.data.status == "Done")
            {
                $scope.AllRestData = response.data;
                $scope.showAllRestaurant1 = true;



            } else
            {
                alert("Error Reading Data");
            }
        }, function (response) {
            alert("Not Valid");
        });

    }
    $scope.submitProduct = function (isValid) {

        var file;
        var imageDest;
        var adminData;
        var retuarantData;

        var url = "postproduct";

        var config = {
            headers: {
                'Content-Type': 'application/json;charset=utf-8;'
            }
        }

        myFunction();
        function myFunction() {
           var restName = $scope.restName;
           
            //
            var url2 = "findbyrestuarantname";

            var config2 = {
                headers: {'Content-Type': 'application/json;charset=utf-8;'},

                params: {'restuarantname': restName}

            };

            $http.get(url2, config2).then(function (response) {

                if (response.data.status == "Done") {

                    retuarantData = response.data.data;

                    var id;

                    retuarantData.forEach(function (elem) {
                        id = elem.id;
                        
                        localStorage.setItem('restId',id);
                    });
                } else {

                    $scope.getResultMessage = "Could not find Administrator with email";

                }
            }, function (response) {

                $scope.postResultMessage = "Fail One";
            });

            //
            /*
             * var file;
        var imageDest;
            
            
             file = document.getElementById('fileItem').files[0];

            imageDest = "/images/" + file.name;
            
            imageFile: imageDest,
            
             */
            file = document.getElementById('fileItem').files[0];

            imageDest = "/images/" + file.name;

            var url1 = "findbyadministratoremail";

            var config1 = {
                headers: {'Content-Type': 'application/json;charset=utf-8;'},

                params: {'email': localStorage.getItem("emailAddress")}

            }

            $http.get(url1, config1).then(function (response) {

                if (response.data.status == "Done") {

                    adminData = response.data.data;

                    var id;

                    adminData.forEach(function (elem) {
                        id = elem.id;

                    });



                    var data = {

                        productName: $scope.productname,
                        productQuantity: $scope.productquantity,
                        unitPrice: $scope.unitprice,
                        category: $scope.productType,
                        imageFile: imageDest,
                        administrator: id,
                        restuarant: localStorage.getItem("restId")


                    };



                    if (isValid) {
                        $http.post(url, data, config).then(function (response) {
                            $scope.postResultMessage = "Sucessfully added new Product!";
                    alert("Sucessfully added new Product!");
                            $scope.productname = "";
                            $scope.productquantity = "";
                            $scope.unitprice = "";
                            $scope.productType = false;
                            $scope.change = false;
                            $scope.administratoremail = "";



                        }, function (response) {

                            $scope.postResultMessage = "Failed to add new product, check details!";
                          alert("Failed to add new product, check details!");  });

                    } else {alert("Enter Correct user information");
                        $scope.postResultMessage = "Enter Correct user information";
                    }
                } else {
                           alert("Could not find Administrator with email");
                    //   $scope.getResultMessage = "Could not find Administrator with email";

                }

            }, function (response) {
                alert("Fail!");
                $scope.postResultMessage = "Fail!";
            });


        }


    }
});
//Adding Restuarant
app.controller('postRestuarantController', function ($scope, $http) {

    $scope.submitRestuarant = function (isValid) {
var file;
        var imageDest;
        var url = "postrestuarant";

        var config = {
            headers: {
                'Content-Type': 'application/json;charset=utf-8;'
            }
        }
        file = document.getElementById('fileItem').files[0];

            imageDest = "/images/" + file.name;
            /*
             * var file;
        var imageDest;
            
            
             file = document.getElementById('fileItem').files[0];

            imageDest = "/images/" + file.name;
            
            imageFile: imageDest,
            
             */
        

        var data = {

            id: $scope.id,
            imageFile: imageDest,
            restuarantName: $scope.restuarantName,
            streetName: $scope.streetName,
            areaName: $scope.areaName,
            city: $scope.city,
            province: $scope.province,
            email: $scope.email,
            phone: $scope.phone

        };
        if (isValid)
        {
            $http.post(url, data, config).then(function (response) {
                alert("Restuarant Added");

                $scope.id = ""
                $scope.restuarantName = "";
                $scope.streetName = "";
                $scope.areaName = "";
                $scope.city = "";
                $scope.province = "";
                $scope.email = "";
                $scope.phone = "";
            }, function (response)
            {
                alert("Restuarant Failed to add");
            });
        } else
        {
            alert("Inputs are not valid");
        }

    }
});


//Find User by email and password
app.controller('getUserByEmailAndPasswordController', function ($scope, $http) {


    $scope.submitLogin = function () {

        localStorage.setItem("emailAddress", $scope.email);
        localStorage.setItem("password", $scope.password);

        var url = "findbyemailandpassword";

        var config = {
            headers: {'Content-Type': 'application/json;charset=utf-8;'},

            params: {'email': $scope.email, 'password': $scope.password}

        }

        $http.get(url, config).then(function (response) {

            if (response.data.status == "Done")
            {

                var sessionStatus = "logged";
                localStorage.setItem("sessionVariable", sessionStatus);

                $scope.email = "";
                $scope.password = "";

                var type;
                var status;
                var custid;

                users = response.data.data;
                users.forEach(function (elem) {
                    type = elem.type;
                    status = elem.status;
                    custid = elem.id;
                });

                if (type == "admin") {
                    window.location.assign('Administrator.html');
                } else if (type == "customer") {

                    localStorage.setItem("custid", custid);

                    //Create Order
                    var url = "postorders";

                    var config = {
                        headers: {
                            'Content-Type': 'application/json;charset=utf-8;'
                        }
                    }

                    var data = {
                        orderDate: Date(),
                        totalPrice: 0,
                        totalQuantity: 0,
                        status: "Not Done",
                        customer: custid

                    };


                    $http.post(url, data, config).then(function (response) {

                    }, function (response) {
                        $scope.postResultMessage = "Fail!";
                    });



                    window.location.assign('/');
                } else if (type == "driver") {
                    window.location.assign('Driver.html');

                } else {
                    $scope.getResultMessage = "Problem wiht the use, please contact your administrator";
                }

            } else {

                $scope.getResultMessage = "Could not find user";

            }

        }, function (response) {
            $scope.getResultMessage = "Fail!";
        });

    }
});

//Get Product by specific category
app.controller('getallproductsoneController', function ($scope, $http) {

    $scope.showAllProductOne = false;
    var cart = [];
    $scope.getAllProductsCategory = function () {

        var url = "findbycategory";

        var cat = "Burger";

        var config = {
            headers: {'Content-Type': 'application/json;charset=utf-8;'},

            params: {'category': cat}

        }

        $http.get(url, config).then(function (response) {

            if (response.data.status == "Done") {

                $scope.allproducts = response.data;
                $scope.showAllProductOne = true;
                

            } else {

                $scope.getResultMessage = "Product Category Not Found";

            }

        }, function (response) {
            $scope.getResultMessage = "Fail!";
        });

    }
    $scope.Cart = false;
    $scope.sendToCart = function (product) {

        cart.push({id: product.id, image: product.imageFile, name: product.productName, price: product.unitPrice});

        localStorage.setItem('cartProducts', JSON.stringify(cart));
        alert("Item added to Cart");
        $scope.Cart = true;

    }

    $scope.getItems = function () {
        var itemsobj = JSON.parse(localStorage.getItem('cartProducts'));

        var sessionCheck = localStorage.getItem("sessionVariable");

        var log = sessionCheck;

        if (log !== "logged") {
            window.location.assign('LoginTwo.html');
        } else {
            window.location.assign('Cart.html');
        }
    }


});
///////////////////////////////////////////////////////////////////////////////////////////////////////////










app.controller('getallRestproductsOneController', function ($scope, $http) {
    $scope.showAllRestProductOne = false;
    var cart = [];
    $scope.getAllProductsRest = function () {


        var url = "findbyrestaurant";

        var rest = "Rest1";

        var config = {
            headers: {'Content-Type': 'application/json;charset=utf-8;'},

            params: {'restuarant': rest}

        }

        $http.get(url, config).then(function (response) {

            if (response.data.status == "Done") {

                $scope.allproducts = response.data;
                $scope.showAllRestProductOne = true;

            } else {

                $scope.getResultMessage = "Product Category Not Found";

            }

        }, function (response) {
            $scope.getResultMessage = "Fail!";
        });

    }

    $scope.Cart = false;
    $scope.sendToCart = function (product) {

        cart.push({id: product.id, image: product.imageFile, name: product.productName, price: product.unitPrice});

        localStorage.setItem('cartProducts', JSON.stringify(cart));
        alert("Item added to Cart");
        $scope.Cart = true;

    }
    $scope.getItems = function () {
        var itemsobj = JSON.parse(localStorage.getItem('cartProducts'));

        var sessionCheck = localStorage.getItem("sessionVariable");

        var log = sessionCheck;

        if (log !== "logged") {
            window.location.assign('LoginTwo.html');
        } else {
            window.location.assign('Cart.html');
        }
    }
});
///////////////////////////////////////////////



app.controller('getallRestproductsTwoController', function ($scope, $http) {
    $scope.showAllRestProductTwo = false;
    var cart = [];
    $scope.getAllProductsRest = function () {


        var url = "findbyrestaurant";

        var rest = "Rest2";

        var config = {
            headers: {'Content-Type': 'application/json;charset=utf-8;'},

            params: {'restuarant': rest}

        }

        $http.get(url, config).then(function (response) {

            if (response.data.status == "Done") {

                $scope.allproducts = response.data;
                $scope.showAllRestProductTwo = true;
               
                

            } else {

                $scope.getResultMessage = "Product Category Not Found";

            }

        }, function (response) {
            $scope.getResultMessage = "Fail!";
        });

    }

    $scope.Cart = false;
    $scope.sendToCart = function (product) {

        cart.push({id: product.id, image: product.imageFile, name: product.productName, price: product.unitPrice});

        localStorage.setItem('cartProducts', JSON.stringify(cart));
        alert("Item added to Cart");
        $scope.Cart = true;

    }
    $scope.getItems = function () {
        var itemsobj = JSON.parse(localStorage.getItem('cartProducts'));

        var sessionCheck = localStorage.getItem("sessionVariable");

        var log = sessionCheck;

        if (log !== "logged") {
            window.location.assign('LoginTwo.html');
        } else {
            window.location.assign('Cart.html');
        }
    }
});
                


//////////////////////////////////////////////////////////////
app.controller('getallRestproductsThreeController', function ($scope, $http) {
    $scope.showAllRestProductThree = false;
    var cart = [];
    $scope.getAllProductsRest = function () {


        var url = "findbyrestaurant";

        var rest = "Rest3";

        var config = {
            headers: {'Content-Type': 'application/json;charset=utf-8;'},

            params: {'restuarant': rest}

        }

        $http.get(url, config).then(function (response) {

            if (response.data.status == "Done") {

                $scope.allproducts = response.data;
                $scope.showAllRestProductThree = true;
               
                

            } else {

                $scope.getResultMessage = "Product Category Not Found";

            }

        }, function (response) {
            $scope.getResultMessage = "Fail!";
        });

    }

    $scope.Cart = false;
    $scope.sendToCart = function (product) {

        cart.push({id: product.id, image: product.imageFile, name: product.productName, price: product.unitPrice});

        localStorage.setItem('cartProducts', JSON.stringify(cart));
        alert("Item added to Cart");
        $scope.Cart = true;

    }
    $scope.getItems = function () {
        var itemsobj = JSON.parse(localStorage.getItem('cartProducts'));

        var sessionCheck = localStorage.getItem("sessionVariable");

        var log = sessionCheck;

        if (log !== "logged") {
            window.location.assign('LoginTwo.html');
        } else {
            window.location.assign('Cart.html');
        }
    }
});
                
///////////////////////////////////////////////////////////////////////////////////
app.controller('getallRestproductsFourController', function ($scope, $http) {
    $scope.showAllRestProductFour = false;
    var cart = [];
    $scope.getAllProductsRest = function () {


        var url = "findbyrestaurant";

        var rest = "Rest4";

        var config = {
            headers: {'Content-Type': 'application/json;charset=utf-8;'},

            params: {'restuarant': rest}

        }

        $http.get(url, config).then(function (response) {

            if (response.data.status == "Done") {

                $scope.allproducts = response.data;
                $scope.showAllRestProductFour = true;
               
                

            } else {

                $scope.getResultMessage = "Product Category Not Found";

            }

        }, function (response) {
            $scope.getResultMessage = "Fail!";
        });

    }

    $scope.Cart = false;
    $scope.sendToCart = function (product) {

        cart.push({id: product.id, image: product.imageFile, name: product.productName, price: product.unitPrice});

        localStorage.setItem('cartProducts', JSON.stringify(cart));
        alert("Item added to Cart");
        $scope.Cart = true;

    }
    $scope.getItems = function () {
        var itemsobj = JSON.parse(localStorage.getItem('cartProducts'));

        var sessionCheck = localStorage.getItem("sessionVariable");

        var log = sessionCheck;

        if (log !== "logged") {
            window.location.assign('LoginTwo.html');
        } else {
            window.location.assign('Cart.html');
        }
    }
});
                
//////////////////////////////////////////////////////////////////////////
app.controller('getallRestproductsFiveController', function ($scope, $http) {
    $scope.showAllRestProductFive = false;
    var cart = [];
    $scope.getAllProductsRest = function () {


        var url = "findbyrestaurant";

        var rest = "Rest5";

        var config = {
            headers: {'Content-Type': 'application/json;charset=utf-8;'},

            params: {'restuarant': rest}

        }

        $http.get(url, config).then(function (response) {

            if (response.data.status == "Done") {

                $scope.allproducts = response.data;
                $scope.showAllRestProductFive = true;
               
                

            } else {

                $scope.getResultMessage = "Product Category Not Found";

            }

        }, function (response) {
            $scope.getResultMessage = "Fail!";
        });

    }

    $scope.Cart = false;
    $scope.sendToCart = function (product) {

        cart.push({id: product.id, image: product.imageFile, name: product.productName, price: product.unitPrice});

        localStorage.setItem('cartProducts', JSON.stringify(cart));
        alert("Item added to Cart");
        $scope.Cart = true;

    }
    $scope.getItems = function () {
        var itemsobj = JSON.parse(localStorage.getItem('cartProducts'));

        var sessionCheck = localStorage.getItem("sessionVariable");

        var log = sessionCheck;

        if (log !== "logged") {
            window.location.assign('LoginTwo.html');
        } else {
            window.location.assign('Cart.html');
        }
    }
});
                
//////////////////////////////////////////////////////////////////////////////////////
app.controller('getallRestproductsSixController', function ($scope, $http) {
    $scope.showAllRestProductSix = false;
    var cart = [];
    $scope.getAllProductsRest = function () {


        var url = "findbyrestaurant";

        var rest = "Rest6";

        var config = {
            headers: {'Content-Type': 'application/json;charset=utf-8;'},

            params: {'restuarant': rest}

        }

        $http.get(url, config).then(function (response) {

            if (response.data.status == "Done") {

                $scope.allproducts = response.data;
                $scope.showAllRestProductSix = true;
               
                

            } else {

                $scope.getResultMessage = "Product Category Not Found";

            }

        }, function (response) {
            $scope.getResultMessage = "Fail!";
        });

    }

    $scope.Cart = false;
    $scope.sendToCart = function (product) {

        cart.push({id: product.id, image: product.imageFile, name: product.productName, price: product.unitPrice});

        localStorage.setItem('cartProducts', JSON.stringify(cart));
        alert("Item added to Cart");
        $scope.Cart = true;

    }
    $scope.getItems = function () {
        var itemsobj = JSON.parse(localStorage.getItem('cartProducts'));

        var sessionCheck = localStorage.getItem("sessionVariable");

        var log = sessionCheck;

        if (log !== "logged") {
            window.location.assign('LoginTwo.html');
        } else {
            window.location.assign('Cart.html');
        }
    }
});
                
//////////////////////////////////////////////////////////////////////////////////////












































































/////////////////////////////////////////////////////////////////////////////////////




//Get Product by specific product
app.controller('getallproductstwoController', function ($scope, $http) {
    $scope.showAllProductTwo = false;
    var cart = [];
    $scope.getAllProductsCategory = function () {


        var url = "findbycategory";

        var cat = "BBQ";

        var config = {
            headers: {'Content-Type': 'application/json;charset=utf-8;'},

            params: {'category': cat}

        }

        $http.get(url, config).then(function (response) {

            if (response.data.status == "Done") {

                $scope.allproducts = response.data;
                $scope.showAllProductTwo = true;

            } else {

                $scope.getResultMessage = "Product Category Not Found";

            }

        }, function (response) {
            $scope.getResultMessage = "Fail!";
        });

    }

    $scope.Cart = false;
    $scope.sendToCart = function (product) {

        cart.push({id: product.id, image: product.imageFile, name: product.productName, price: product.unitPrice});

        localStorage.setItem('cartProducts', JSON.stringify(cart));
        alert("Item added to Cart");
        $scope.Cart = true;

    }
    $scope.getItems = function () {
        var itemsobj = JSON.parse(localStorage.getItem('cartProducts'));

        var sessionCheck = localStorage.getItem("sessionVariable");

        var log = sessionCheck;

        if (log !== "logged") {
            window.location.assign('LoginTwo.html');
        } else {
            window.location.assign('Cart.html');
        }
    }
});

//Get Product by specific product
app.controller('getallproductsthreeController', function ($scope, $http) {

    $scope.showAllProductThree = false;
    var cart = [];
    $scope.getAllProductsCategory = function () {

        var url = "findbycategory";

        var cat = "Pastry";

        var config = {
            headers: {'Content-Type': 'application/json;charset=utf-8;'},

            params: {'category': cat}

        }

        $http.get(url, config).then(function (response) {

            if (response.data.status == "Done") {

                $scope.allproducts = response.data;
                $scope.showAllProductThree = true;

            } else {

                $scope.getResultMessage = "Product Category Not Found";

            }

        }, function (response) {
            $scope.getResultMessage = "Fail!";
        });

    }
    $scope.Cart = false;
    $scope.sendToCart = function (product) {

        cart.push({id: product.id, image: product.imageFile, name: product.productName, price: product.unitPrice});

        localStorage.setItem('cartProducts', JSON.stringify(cart));
        alert("Item added to Cart");
        $scope.Cart = true;

    }

    $scope.getItems = function () {
        var itemsobj = JSON.parse(localStorage.getItem('cartProducts'));

        var sessionCheck = localStorage.getItem("sessionVariable");

        var log = sessionCheck;

        if (log !== "logged") {
            window.location.assign('LoginTwo.html');
        } else {
            window.location.assign('Cart.html');
        }
    }
});
///////////////////////////////

app.controller('getProductsByRestController',function ($scope,$http)
{
    $scope.showAllProductsRest = false;
    $scope.getAllProductsRest=function ()
    {
        var url="findbyrestaurant";
        var rest =3333;
        
         var config = {
            headers: {'Content-Type': 'application/json;charset=utf-8;'},

            params: {'restuarantid': rest}

        }
        $http.get(url,config).then(function (response){
            if(response.data.status=="Done")
            {
             $scope.allproducts = response.data;
             $scope.showAllProductsRest=true;
            }else{
                alert("Products Not Found");
            }
        },function (response)
        {
            alert("Failed");
        });
    }
        $scope.Cart = false;
    $scope.sendToCart = function (product) {

        cart.push({id: product.id, image: product.imageFile, name: product.productName, price: product.unitPrice});

        localStorage.setItem('cartProducts', JSON.stringify(cart));
        alert("Item added to Cart");
        $scope.Cart = true;

    }

    $scope.getItems = function () {
        var itemsobj = JSON.parse(localStorage.getItem('cartProducts'));

        var sessionCheck = localStorage.getItem("sessionVariable");

        var log = sessionCheck;

        if (log !== "logged") {
            window.location.assign('LoginTwo.html');
        } else {
            window.location.assign('Cart.html');
        }
    }
});

//Get Product by specific product
app.controller('getallproductsfourController', function ($scope, $http) {

    $scope.showAllProductFour = false;
    var cart = [];
    $scope.getAllProductsCategory = function () {

        var url = "findbycategory";

        var cat = "Pizza";

        var config = {
            headers: {'Content-Type': 'application/json;charset=utf-8;'},

            params: {'category': cat}

        }

        $http.get(url, config).then(function (response) {

            if (response.data.status == "Done") {

                $scope.allproducts = response.data;
                $scope.showAllProductFour = true;

            } else {

                $scope.getResultMessage = "Product Category Not Found";

            }

        }, function (response) {
            $scope.getResultMessage = "Fail!";
        });

    }

    $scope.Cart = false;
    $scope.sendToCart = function (product) {

        cart.push({id: product.id, image: product.imageFile, name: product.productName, price: product.unitPrice});

        localStorage.setItem('cartProducts', JSON.stringify(cart));
        alert("Item added to Cart");
        $scope.Cart = true;

    }

    $scope.getItems = function () {
        var itemsobj = JSON.parse(localStorage.getItem('cartProducts'));

        var sessionCheck = localStorage.getItem("sessionVariable");

        var log = sessionCheck;

        if (log !== "logged") {
            window.location.assign('LoginTwo.html');
        } else {
            window.location.assign('Cart.html');
        }
    }
});
//View All Orders
app.controller('getallordersController', function ($scope, $http) {

    $scope.showAllorders = false;


    $scope.getAllorders = function () {
        var url = "getallorders";

        var config = {
            headers: {
                'Content-Type': 'application/json;charset=utf-8;'
            }
        }

        $http.get(url, config).then(function (response) {

            if (response.data.status == "Done") {
                $scope.allorders = response.data;
                $scope.showAllorders = true;


            } else {
                $scope.getResultMessage = "Returning All Products Data Error!";
            }
        }, function (response) {
            $scope.getResultMessage = "Fail!";
        });
    }
});
app.controller('getAllRestaurantController', function ($scope, $http)
{
    $scope.showAllRestaurant = false;
    $scope.getAllRestaurant = function ()
    {

        var url = "getallrestuarant";
        var config = {
            headers: {
                'Content-Type': 'application/json;charset=utf-8;'
            }
        }
        $http.get(url, config).then(function (response)
        {
            if (response.data.status == "Done")
            {
                $scope.AllRestData = response.data;
                $scope.showAllRestaurant = true;
                
            } else
            {
                alert("Error Reading Data");
            }
        }, function (response) {
            alert("Not Valid");
        });

    }
});
//Load Products
app.controller('getallproductsController', function ($scope, $http) {

    $scope.showAllProduct = false;
    var cart = [];
    

            
    $scope.showAllRestaurant1 = false;
    $scope.getAllRestaurant1 = function ()
    {

        var url = "getallrestuarant";
        var config = {
            headers: {
                'Content-Type': 'application/json;charset=utf-8;'
            }
        }
        $http.get(url, config).then(function (response)
        {
            if (response.data.status == "Done")
            {
                $scope.AllRestData = response.data;
                
 
            } else
            {
                alert("Error Reading Data");
            }
        }, function (response) {
            alert("Not Valid");
        });

    }

$scope.getSeletedRestarant = function()
{
     //   alert("$scope.""");
}

    $scope.getAllProducts = function () {
        var url = "getallproducts";

        var config = {
            headers: {
                'Content-Type': 'application/json;charset=utf-8;'
            }
        }

        $http.get(url, config).then(function (response) {

            if (response.data.status == "Done") {
              
                $scope.allproducts = response.data;
                $scope.showAllProduct = true;


            } else {
                $scope.getResultMessage = "Returning All Products Data Error!";
            }

        }, function (response) {
            $scope.getResultMessage = "Fail!";
        });

    }

    $scope.Cart = false;
    $scope.sendToCart = function (product) {

        cart.push({id: product.id, image: product.imageFile, name: product.productName, price: product.unitPrice});
        localStorage.setItem('cartProducts', JSON.stringify(cart));
        alert("Item added to Cart");
        $scope.Cart = true;
    }
    $scope.getItems = function () {
        var itemsobj = JSON.parse(localStorage.getItem('cartProducts'));
        var sessionCheck = localStorage.getItem("sessionVariable");
        var log = sessionCheck;
        if (log !== "logged") {
            window.location.assign('LoginTwo.html');
        } else {
            window.location.assign('Cart.html');
        }
    }
});
//


//Get Product by name  to delete
app.controller('getProductByNameDeleteController', function ($scope, $http) {
    $scope.showProductByName = false;
    $scope.getProductByName = function () {

        var url = "findbyproductname";
        var config = {
            headers: {'Content-Type': 'application/json;charset=utf-8;'},
            params: {'productname': $scope.productnames}

        }

        $http.get(url, config).then(function (response) {

            if (response.data.status == "Done") {

                $scope.allproductsbyname = response.data;
                $scope.showProductByName = true;
            } else {

                $scope.getResultMessage = "Product Not Found";
            }

        }, function (response) {
            $scope.getResultMessage = "Fail!";
        });
    }
    $scope.deleteProduct = function (product) {

        var id = product.id;
        var url = "deletebyproductid";
        var config = {
            headers: {
                'Content-Type': 'application/json;charset=utf-8;'
            },
            params: {id: id}
        }

        $http.delete(url, config).then(function (response) {

            alert("Product Successfully deleted");
            $scope.productnames = "";
            product.id = "";
            product.productQuantitys = "";
            product.productName = "";
            product.unitPrice = "";
            product.productQuantity = "";
        }, function (response) {
            alert("Error Deleting Product");
        });
    }
});

//Update Restuarant by name
app.controller('getRestuarantByNameToController', function ($scope, $http)
{
    $scope.showRestaurant = false;
    $scope.getRestaurant = function ()
    {
        var url = "findbyrestuarantname";
        var config = {
            headers: {'Content-Type': 'application/json;charset=utf-8;'},
            params: {'restuarantname': $scope.restuarantname}
        }
        $http.get(url, config).then(function (response)
        {
            if (response.data.status == "Done")
            {
                $scope.allRestuarantByName = response.data;
                $scope.showRestaurant = true;

                var users = response.data.data;
                users.forEach(function (elem) {

                });
            } else {
                alert("No Restauarant Found");
            }
        }, function (response) {
            alert("Failled");
        });

    }
    $scope.updateRestaurant = function (restaurant) {
        var id = restaurant.id;
        var restuarantName = restaurant.restuarantName;
        var streetName = restaurant.streetName;
        var areaName = restaurant.areaName;
        var city = restaurant.city;
        var province = restaurant.province;
        var email = restaurant.email;
        var phone = restaurant.phone;

        var url = "updaterestuarant/" + id + "/" + restuarantname + "/" + streetname + "/" + areaname + "/" + city + "/" + province + "/" + email + "/" + phone;

        var config = {
            headers: {
                'Content-Type': 'application/json;charset=utf-8;'
            }
        }
        $http.post(url, config).then(function (response)
        {
            alert("Restuarant Successfully updated");
            restaurant.id = "";
            restaurant.restuarantName = "";
            restaurant.streetName = "";
            restaurant.areaName = "";
            restaurant.city = "";
            restaurant.province = "";
            restaurant.email = "";
            restaurant.phone = "";
        }, function (response)
        {
            alert("Failed to Update");
        });
    }

});

//Get Product by name Update
app.controller('getProductByNameUpdateController', function ($scope, $http) {

    $scope.showProductByName = false;
    $scope.getProductByName = function () {

        var url = "findbyproductname";

        var config = {
            headers: {'Content-Type': 'application/json;charset=utf-8;'},

            params: {'productname': $scope.productnames}

        }

        $http.get(url, config).then(function (response) {

            if (response.data.status == "Done") {

                $scope.allproductsbyname = response.data;
                $scope.showProductByName = true;

                var users = response.data.data;
                users.forEach(function (elem) {

                });


            } else {

                $scope.getResultMessage = "Product Not Found";

            }

        }, function (response) {
            $scope.getResultMessage = "Fail!";
        });

    }
    $scope.updateProduct = function (product) {

        var id = product.id;
        var qty = product.productQuantitys;
        var price = product.unitPrices;
        var name = product.productNames;

        var url = "updateproduct/" + id + "/" + qty + "/" + price + "/" + name;

        var config = {
            headers: {
                'Content-Type': 'application/json;charset=utf-8;'
            }

        }

        $http.post(url, config).then(function (response) {

            alert("Product Successfully updated");

            $scope.productnames = "";
            product.id = "";
            product.productNames = "";
            product.unitPrices = "";
            product.productQuantitys = "";
            product.productName = "";
            product.unitPrice = "";
            product.productQuantity = "";

        }, function (response) {
            alert("Error updating Product");
        });

    }
});
//Get Delivery details in driver city
app.controller('getdeliverydriverController', function ($scope, $http) {

    $scope.showAllDelivery = false;
    $scope.getAllDelivery = function () {

        var url = "findbydrivercity";

        var email = localStorage.getItem("emailAddress");
        var password = localStorage.getItem("password");

        var config = {
            headers: {'Content-Type': 'application/json;charset=utf-8;'},

            params: {'email': email, 'password': password}

        }


        $http.get(url, config).then(function (response) {


            if (response.data.status == "Done") {

                $scope.alldeliveryregisters = response.data;
                $scope.showAllDelivery = true;

            } else {

                $scope.getResultMessage = "No new Deliveries";

            }

        }, function (response) {
            $scope.getResultMessage = "Fail!";
        });

    }
    $scope.CommitDelivery = function (deliveryregister) {

        var id = deliveryregister.id;
        var status = "delivering";
        var email = localStorage.getItem("emailAddress");
        var password = localStorage.getItem("password");

        var url = "updatedeliveryregister/" + id + "/" + status + "/" + email + "/" + password;

        var config = {
            headers: {
                'Content-Type': 'application/json;charset=utf-8;'
            }

        }

        $http.post(url, config).then(function (response) {

            $scope.getResultMessage = "Delivery Successfully updated";


        }, function (response) {
            $scope.getResultMessage = "Error updating Delivery";
        });
    }
});

//Update Delivery Status
app.controller('updateStatusController', function ($scope, $http) {

    $scope.showAllDelivery = false;
    $scope.getAllDelivery = function () {

        var url = "updatedeliverystatus";

        var email = localStorage.getItem("emailAddress");
        var password = localStorage.getItem("password");

        var config = {
            headers: {'Content-Type': 'application/json;charset=utf-8;'},

            params: {'email': email, 'password': password}

        }


        $http.get(url, config).then(function (response) {


            if (response.data.status == "Done") {

                $scope.alldeliveryregisters = response.data;
                $scope.showAllDelivery = true;

            } else {

                $scope.getResultMessage = "No Commited Deliveries";

            }

        }, function (response) {
            $scope.getResultMessage = "Fail!";
        });

    }
    $scope.UpdateStatus = function (deliveryregister) {

        var id = deliveryregister.id;
        var status = "Done";
        var email = localStorage.getItem("emailAddress");
        var password = localStorage.getItem("password");

        var url = "updatedeliveryregister/" + id + "/" + status + "/" + email + "/" + password;

        var config = {
            headers: {
                'Content-Type': 'application/json;charset=utf-8;'
            }

        }

        $http.post(url, config).then(function (response) {

            $scope.getResultMessage = "Delivery Status Successfully updated";


        }, function (response) {
            $scope.getResultMessage = "Error updating Delivery Status";
        });
    }
});



//Get Cart Products
app.controller('getCartproductsController', function ($scope, $http) {
    $scope.Cart = false;
    var cart = JSON.parse(localStorage.getItem('cartProducts'));

    $scope.getAllProducts = function () {

        $scope.allcartproducts = cart;
        $scope.Cart = true;

    }
    var orderproducts = [];

    $scope.checkQuantity = function (product) {
        var qty = product.quantity;

        product.unitTotal = qty * product.price;

    }

    //Remove Products
    $scope.removeProduct = function (product) {

        var indexOfProduct = cart.findIndex(i => i.name === product.name);
        var total = $scope.total;
        var qty = product.quantity;

        if (qty > 1) {
            qty = qty - 1;
            product.quantity = qty;
            total = total - product.price;
            $scope.total = total;
            product.unitTotal = product.unitTotal - product.price;
        } else {

            delete cart[indexOfProduct];
            total = total - product.price;
            $scope.total = total;
            localStorage.setItem('cartProductss', JSON.stringify(cart));

        }
    }

    $scope.checkOut = function (product) {

        localStorage.setItem('orderProducts', JSON.stringify(product));


        //Read Order
        var url2 = "findbystatuscustomer";

        var status = "Not Done";
        var customer = localStorage.getItem("custid");

        var config2 = {
            headers: {'Content-Type': 'application/json;charset=utf-8;'},

            params: {'status': status, customer: customer}

        }

        $http.get(url2, config2).then(function (response) {

            if (response.data.status == "Done") {

                var orderid;

                users = response.data.data;
                users.forEach(function (elem) {
                    orderid = elem.id;

                });
                localStorage.setItem("orid", orderid);

                //post orderLine
                for (var i = 0; i < product.length; i++) {


                    var id;
                    var price;

                    var obj = [];
                    obj = product[i];

                    id = obj.id;
                    price = obj.price;


                    var url1 = "postorderline";

                    var config1 = {
                        headers: {
                            'Content-Type': 'application/json;charset=utf-8;'
                        }
                    }

                    var data1 = {

                        subTotal: price,
                        quantity: 0,
                        order: orderid,
                        product: id

                    };

                    $http.post(url1, data1, config1).then(function (response) {

                        obj = [];

                    }, function (response) {

                    });
                }


            } else {

                alert("Could Not Get Customer with Order id");

            }

        }, function (response) {
            $scope.getResultMessage = "Fail!";
        });



        window.location.assign('Order.html');
    }

    $scope.logOut = function () {

        var log = "logged Out";

        localStorage.setItem("sessionVariable", log);
        localStorage.setItem('cartProducts', "");


        window.location.assign('/');

    }

//User Closing tab during order
    window.onbeforeunload = closingCode;

    function closingCode() {

        var log = "logged Out";

        localStorage.setItem("sessionVariable", log);


        return null;
    }
});

//Get Order Products
app.controller('getOrderproductsController', function ($scope) {

    $scope.Order = false;
    var order = JSON.parse(localStorage.getItem('orderProducts'));
    $scope.getOrderProducts = function () {

        var total = 0;
        var qty = 0;
        var i;


        for (i = 0; i < order.length; i++) {
            total = total + order[i].unitTotal;
            qty = qty + order[i].quantity;
        }

        $scope.totalPrice = total;

        localStorage.setItem('totalPrice', total);
        localStorage.setItem('quantity', qty);

        $scope.allorderproducts = order;
        $scope.Order = true;

    }

    $scope.payment = function (allorderproducts) {
        localStorage.setItem('order', JSON.stringify(allorderproducts));
        window.location.assign('Payment.html');
    }

    $scope.logOut = function () {

        var log = "logged Out";

        localStorage.setItem("sessionVariable", log);


        window.location.assign('/');

    }

    //User Closing tab during order
    window.onbeforeunload = closingCode;

    function closingCode() {

        var log = "logged Out";

        localStorage.setItem("sessionVariable", log);


        return null;
    }

});

//Payment
app.controller('postPaymentController', function ($scope, $http) {
    $scope.submitPayment = function (isValid) {

        var customers = JSON.parse(localStorage.getItem("custid"));
        var orderStatuss = "Not Done";

        var url = "postpayment";

        var config = {
            headers: {
                'Content-Type': 'application/json;charset=utf-8;'
            }
        }

        var data = {
            cardNumber: $scope.cardnumber,
            cardHolderName: $scope.holdername,
            expiryDate: $scope.expirydate,
            cvvNumber: $scope.cvv,
            orderStatus: orderStatuss,
            customer: customers


        };

        if (isValid) {

            $http.post(url, data, config).then(function (response) {

                $scope.cardnumber = "";
                $scope.holdername = "";
                $scope.expirydate = "";
                $scope.cvv = "";

                window.location.assign('DeliveryRegister.html');

            }, function (response) {
                $scope.postResultMessage = "Fail!";
            });
        } else {
            $scope.postResultMessage = "Payment cannot be processed";
        }

    }

    $scope.logOut = function () {

        var log = "logged Out";

        localStorage.setItem("sessionVariable", log);


        window.location.assign('/');

    }

    //User Closing tab during order
    window.onbeforeunload = closingCode;

    function closingCode() {

        var log = "logged Out";

        localStorage.setItem("sessionVariable", log);


        return null;
    }
});

//Delivery Register
app.controller('postDeliveryController', function ($scope, $http) {
    $scope.submitDelivery = function (isValid) {

        var customers = JSON.parse(localStorage.getItem("custid"));
        var orderStatuss = "Not Done";

        $scope.receipt = false;

        var status = "pending";

        var url = "postdeliveryregisters";

        var config = {
            headers: {
                'Content-Type': 'application/json;charset=utf-8;'
            }
        }

        var data = {
            deliveryDate: $scope.deliverydate,
            recipientName: $scope.recipientname,
            recipientSurname: $scope.recipientsurname,
            recipientPhone: $scope.recipientphone,
            streetName: $scope.streetname,
            areaName: $scope.areaname,
            city: $scope.city,
            province: $scope.province,
            additionalInformation: $scope.additionalinformation,
            status: status,
            orderStatus: orderStatuss,
            customer: customers

        };

        if (isValid) {

            $http.post(url, data, config).then(function (response) {

                $scope.receipt = true;
                $scope.postResultMessage = "Delivery Details successfully saved, thank you for shopping with us";

                $scope.deliverydate = "";
                $scope.recipientname = "";
                $scope.recipientsurname = "";
                $scope.recipientphone = "";
                $scope.streetname = "";
                $scope.areaname = "";
                $scope.city = "";
                $scope.province = "";
                $scope.additionalinformation = "";


                window.location.assign('Receipt.html');

            }, function (response) {
                $scope.postResultMessage = "Fail!";
            });
        } else {
            $scope.postResultMessage = "Could not save Delivery details, please check your details";
        }

        //Read payment
        var paymentid;
        var url1 = "findbyorderstatuscustomerpayment";

        var customers1 = localStorage.getItem("custid");
        var orderStatuspayment = "Not Done";

        var config1 = {
            headers: {'Content-Type': 'application/json;charset=utf-8;'},

            params: {'orderstatus': orderStatuspayment, customer: customers1}

        }

        $http.get(url1, config1).then(function (response) {

            if (response.data.status == "Done") {

                users = response.data.data;
                users.forEach(function (elem) {
                    paymentid = elem.id;
                });
                localStorage.setItem("pid", paymentid);
            } else {

                alert("Payment Information Not Found");

            }

        }, function (response) {
            alert("Fail!");
        });

    }

    $scope.getReceipt = function () {


        //Read Order Delivery
        var deliveryid;
        var deliveryDate;

        var url2 = "findbyorderstatuscustomerdelivery";

        var customers = localStorage.getItem("custid");
        var orderStatuss = "Not Done";

        var config2 = {
            headers: {'Content-Type': 'application/json;charset=utf-8;'},

            params: {'orderstatus': orderStatuss, customer: customers}

        }

        $http.get(url2, config2).then(function (response) {

            if (response.data.status == "Done") {

                users = response.data.data;
                users.forEach(function (elem) {
                    deliveryid = elem.id;
                    deliveryDate = elem.deliveryDate;
                });
                localStorage.setItem("did", deliveryid);
                localStorage.setItem("ddate", deliveryDate);
            } else {

                alert("Delivery Information Not Found");

            }

        }, function (response) {

        });

        window.location.assign('Receipt.html');
    }

    $scope.logOut = function () {

        var log = "logged Out";

        localStorage.setItem("sessionVariable", log);


        window.location.assign('/');

    }

    //User Closing tab during order
    window.onbeforeunload = closingCode;

    function closingCode() {

        var log = "logged Out";

        localStorage.setItem("sessionVariable", log);


        return null;
    }
});

//Load Receipt And Print
app.controller('getReceiptController', function ($scope, $http) {

    $scope.showReceipt = false;
    var cart = JSON.parse(localStorage.getItem("order"));
    var custname = localStorage.getItem("custname");
    var date = localStorage.getItem("ddate");
    var num = localStorage.getItem("did");

    $scope.getReceipt = function () {

        var total = 0;
        var i;


        for (i = 0; i < cart.length; i++) {
            total = total + cart[i].unitTotal;
        }

        $scope.totalPrice = total;

        $scope.customername = custname;
        $scope.date = date;
        $scope.num = num;

        $scope.allreceiptproducts = cart;
        $scope.showReceipt = true;


        //Update Order
        var id = localStorage.getItem("orid");

        var paymentid = localStorage.getItem("pid");
        var deliveryid = localStorage.getItem("did");
        var totalprice = localStorage.getItem('totalPrice');
        var totalquantity = localStorage.getItem('quantity');

        var url3 = "updateorder/" + id + "/" + paymentid + "/" + deliveryid + "/" + totalprice + "/" + totalquantity;

        var config3 = {
            headers: {
                'Content-Type': 'application/json;charset=utf-8;'
            }

        }

        $http.post(url3, config3).then(function (response) {



        }, function (response) {

        });
        //End Update
    }


    $scope.PrintPreview = function () {

        var toPrint = document.getElementById('printarea');

        var popupWin = window.open('', '_blank', 'width=850,height=850,location=no,left=200px');

        popupWin.document.open();

        popupWin.document.write('<html><title>::Preview::</title></head><body onload="window.print()">')

        popupWin.document.write(toPrint.innerHTML);

        popupWin.document.write('</html>');

        popupWin.document.close();

        //Update Payment
        var id1 = localStorage.getItem("pid");
        var orderstatus1 = "Done";


        var url1 = "updatepaymentorder/" + id1 + "/" + orderstatus1;

        var config1 = {
            headers: {
                'Content-Type': 'application/json;charset=utf-8;'
            }

        }

        $http.post(url1, config1).then(function (response) {

        }, function (response) {

        });
        //End payment

        //Update Delivery
        var id2 = localStorage.getItem("did");
        var orderstatus2 = "Done";


        var url2 = "updatedeliveryregisterorder/" + id2 + "/" + orderstatus2;

        var config2 = {
            headers: {
                'Content-Type': 'application/json;charset=utf-8;'
            }

        }

        $http.post(url2, config2).then(function (response) {

        }, function (response) {

        });
        //End Delivery

        //Update Order
        var id3 = localStorage.getItem("orid");
        var status3 = "Done";

        var url3 = "updateorderstatus/" + id3 + "/" + status3;

        var config3 = {
            headers: {
                'Content-Type': 'application/json;charset=utf-8;'
            }

        }

        $http.post(url3, config3).then(function (response) {



        }, function (response) {

        });
        //End update

    }

    $scope.logOut = function () {

        var log = "logged Out";

        localStorage.setItem("sessionVariable", log);


        window.location.assign('/');

    }

    //User Closing tab during order
    window.onbeforeunload = closingCode;

    function closingCode() {

        var log = "logged Out";

        localStorage.setItem("sessionVariable", log);


        return null;
    }
});

//Find User by email and password to cart
app.controller('getUserByEmailAndPasswordTwoController', function ($scope, $http) {


    $scope.submitLogin = function () {

        localStorage.setItem("emailAddress", $scope.email);
        localStorage.setItem("password", $scope.password);

        var url = "findbyemailandpassword";

        var config = {
            headers: {'Content-Type': 'application/json;charset=utf-8;'},

            params: {'email': $scope.email, 'password': $scope.password}

        }

        $http.get(url, config).then(function (response) {

            var custid;
            var custname;

            users = response.data.data;
            users.forEach(function (elem) {

                custid = elem.id;
                custname = elem.userName;
            });

            localStorage.setItem("custid", custid);
            localStorage.setItem("custname", custname);

            if (response.data.status == "Done") {

                //Create Order
                var url = "postorders";

                var config = {
                    headers: {
                        'Content-Type': 'application/json;charset=utf-8;'
                    }
                }

                var data = {
                    orderDate: Date(),
                    totalPrice: 0,
                    totalQuantity: 0,
                    status: "Not Done",
                    customer: custid

                };


                $http.post(url, data, config).then(function (response) {

                }, function (response) {
                    $scope.postResultMessage = "Fail!";
                });
                //Done Order

                var sessionStatus = "logged";

                localStorage.setItem("sessionVariable", sessionStatus);

                window.location.assign('Cart.html');

                $scope.email = "";
                $scope.password = "";

            } else {

                $scope.getResultMessage = "Could not find user";

            }

        }
        , function (response) {
            $scope.getResultMessage = "Fail!";
        });

    }
});

//Customer Two
app.controller('postCustomerTwoController', function ($scope, $http) {
    $scope.submitCustomer = function (isValid) {
        var url2 = "postcustomer";

        var st = "approved";
        var tp = "customer";

        var config2 = {
            headers: {
                'Content-Type': 'application/json;charset=utf-8;'
            }
        }

        var data2 = {
            id: $scope.id,
            firstName: $scope.firstname,
            lastName: $scope.lastname,
            gender: $scope.genderValue,
            email: $scope.email,
            password: $scope.password,
            phone: $scope.phone,
            status: st,
            type: tp

        };

        if (isValid) {

            $http.post(url2, data2, config2).then(function (response) {

                //add user
                function addUser() {
                    var url = "postuser";

                    var config = {
                        headers: {
                            'Content-Type': 'application/json;charset=utf-8;'
                        }
                    }

                    var data = {
                        id: $scope.id,
                        email: $scope.email,
                        password: $scope.password,
                        phone: $scope.phone,
                        status: st,
                        type: tp,
                        userName: $scope.firstname

                    };

                    $http.post(url, data, config).then(function (response) {
                        $scope.postResultMessage = "Sucessfully added new User!";

                    });
                }

                addUser();

                window.location.assign('LoginTwo.html');

            }, function (response) {
                $scope.postResultMessage = "Fail!";
            });

        } else {
            $scope.postResultMessage = "Enter Correct user information";
        }
    }
});



 
    
     app.controller("ListController", ["$scope", function ($scope) {
             
           
             
        $scope.Members = members;

        // custom filter function
        $scope.FilterFunction = function (item) {
            return (item.pin.indexOf('BY') >= 0);
        };

    }]);


