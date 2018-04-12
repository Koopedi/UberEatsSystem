package com.example.demo.Controller;

import com.example.demo.Model.Product;
import com.example.demo.Model.Response;
import com.example.demo.Model.Restuarant;
import com.example.demo.Service.ProductService;
import com.example.demo.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class ProductController {

    @Autowired
    ProductService productService;

    @Autowired
    UserService userServicey;

    @RequestMapping(value = "/postproduct", method = RequestMethod.POST)
    public void postProduct(@RequestBody Product product) {

        productService.postProduct(product);

    }

    @RequestMapping(value = "/findbycategory", method = RequestMethod.GET)
    public Response findByCategory(@RequestParam("category") String category) {

        Response response = productService.findByCategory(category);

        return response;
    }
    
    
      @RequestMapping(value = "/findbyrestaurant", method = RequestMethod.GET)
    public Response findByRestaurantId(@RequestParam("restuarant") String restuarant) {

        Response response = productService.findByRestuarnt(restuarant);
                

        return response;
    }
    

    @RequestMapping(value = "/findbyproductname", method = RequestMethod.GET)
    public Response findByProductName(@RequestParam("productname") String productName) {

        Response response = productService.findByProductName(productName);

        return response;

    }

    @RequestMapping(value = "/deletebyproductid", method = RequestMethod.DELETE)
    public void deleteByProductId(@RequestParam("id") int id) {

        productService.deleteByProductId(id);

    }

    public Product updateById(int id) {

        Product product = productService.updateById(id);

        return product;
    }

    @RequestMapping(value = "/updateproduct/{id}/{productQuantity}/{unitPrice}/{productName}", method = RequestMethod.POST)
    public void updateProduct(@PathVariable int id, @PathVariable int productQuantity,
            @PathVariable double unitPrice, @PathVariable String productName) {

        productService.updateProduct(id, productQuantity, unitPrice, productName);

    }

    @RequestMapping(value = "/getallproducts", method = RequestMethod.GET)
    public Response getAllProducts() {

        Response response = productService.getAllProducts();

        return response;
    }

   

}
