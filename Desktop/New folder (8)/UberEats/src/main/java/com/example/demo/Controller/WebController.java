package com.example.demo.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
@Controller
public class WebController {

    @RequestMapping(value = "/")
    ModelAndView index() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("index");
        return modelAndView;
    }
    
        @RequestMapping(value = "/AllRestuarant")
    ModelAndView AllRestuarant() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("AllRestuarant");
        return modelAndView;
    }
    
            @RequestMapping(value = "/prototype")
    ModelAndView prototype() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("prototype");
        return modelAndView;
    }
    
                @RequestMapping(value = "/filterrestauarnt")
    ModelAndView FilterRestauarnt() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("FilterRestauarnt");
        return modelAndView;
    }
    
    
    
 @RequestMapping(value = "ViewOrders")
    ModelAndView ViewOrders() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("ViewOrders");
        return modelAndView;
    }

    @RequestMapping(value = "/Registration")
    ModelAndView registration() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("Registration");
        return modelAndView;
    }
    
    @RequestMapping(value = "/login")
    ModelAndView login() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("login");
        return modelAndView;
    }
    
    
      @RequestMapping(value = "/UpdateRestuarant")
    ModelAndView UpdateRestuarant() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("UpdateRestuarant");
        return modelAndView;
    }
    
    

    @RequestMapping(value = "/Pastry")
    ModelAndView Pastry() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("Pastry");
        return modelAndView;
    }
    
   @RequestMapping(value = "/Restuarant")
    ModelAndView Restuarant() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("Restuarant");
        return modelAndView;
    }

    @RequestMapping(value = "/BBQ")
    ModelAndView BBQ() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("BBQ");
        return modelAndView;
    }

    @RequestMapping(value = "/Pizza")
    ModelAndView Pizza() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("Pizza");
        return modelAndView;
    }
    
    @RequestMapping(value = "/Cart")
    ModelAndView cart() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("Cart");
        return modelAndView;
    }
    
    @RequestMapping(value = "/Administrator")
    ModelAndView administrator() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("Administrator");
        return modelAndView;
    }
    
    @RequestMapping(value = "/Driver")
    ModelAndView driver() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("Driver");
        return modelAndView;
    }
    
    @RequestMapping(value = "/Supplier")
    ModelAndView supplier() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("Supplier");
        return modelAndView;
    }
    
    @RequestMapping(value = "/ManageProducts")
    ModelAndView manageproducts() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("ManageProducts");
        return modelAndView;
    }
    @RequestMapping(value = "/Status")
    ModelAndView status() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("Status");
        return modelAndView;
    }
    
    @RequestMapping(value = "/Order")
    ModelAndView order() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("Order");
        return modelAndView;
    }
    
    @RequestMapping(value = "/Payment")
    ModelAndView payment() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("Payment");
        return modelAndView;
    }
    
    @RequestMapping(value = "/DeliveryRegister")
    ModelAndView deliveryRegister() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("DeliveryRegister");
        return modelAndView;
    }
    
    @RequestMapping(value = "/Receipt")
    ModelAndView receipt() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("Receipt");
        return modelAndView;
    }
    
    @RequestMapping(value = "/LoginTwo")
    ModelAndView loginTwo() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("LoginTwo");
        return modelAndView;
    }
    
    @RequestMapping(value = "/Contact")
    ModelAndView contact() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("Contact");
        return modelAndView;
    }
    
    @RequestMapping(value = "/RegisterCustomer")
    ModelAndView registerCustomer() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("RegisterCustomer");
        return modelAndView;
    }
    
    @RequestMapping(value = "/About")
    ModelAndView about() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("About");
        return modelAndView;
    }
     @RequestMapping(value = "/UpdateProduct")
    ModelAndView updateProduct() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("UpdateProduct");
        return modelAndView;
    }
        @RequestMapping(value = "/DeleteProduct")
    ModelAndView DeleteProduct() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("DeleteProduct");
        return modelAndView;
    }
        @RequestMapping(value = "/Burger")
    ModelAndView BurgerProduct() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("Burger");
        return modelAndView;
    }
    
    
  
                 @RequestMapping(value = "/viewrestaurant")
    ModelAndView ViewRestaurant() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("ViewRestaurant");
        return modelAndView;
    }
    
                    @RequestMapping(value = "/viewrestaurant2")
    ModelAndView ViewRestaurant2() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("ViewRestaurant2");
        return modelAndView;
    } 
    
          @RequestMapping(value = "/ManageRestuarant")
    ModelAndView ManageRestuarant() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("ManageRestuarant");
        return modelAndView;
    }
	
	
	
	
	               @RequestMapping(value = "/McDonalds")
    ModelAndView McDonaldsRestuarant() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("McDonalds");
        return modelAndView;
    }    
    
              @RequestMapping(value = "/KFC")
    ModelAndView KFCRestuarant() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("KFC");
        return modelAndView;
    }       
    @RequestMapping(value = "/RocoMamas")
    ModelAndView RocoMamasRestuarant() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("RocoMamas");
        return modelAndView;
    }     
    @RequestMapping(value = "/Nandos")
    ModelAndView NandosRestuarant() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("Nandos");
        return modelAndView;
    } 
    @RequestMapping(value = "/KungfuKitchen")
    ModelAndView KungFuKitchenRestuarant() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("KungfuKitchen");
        return modelAndView;
    }          
    
    @RequestMapping(value = "/Steers")
    ModelAndView SteersRestuarant() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("Steers");
        return modelAndView;
    }         
    @RequestMapping(value = "/Wimpy")
    ModelAndView WimpyRestuarant() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("Wimpy");
        return modelAndView;
    }
    
//       @RequestMapping(value = "/AllRestuarant")
//        ModelAndView AllRestuarant() {
//        ModelAndView modelAndView = new ModelAndView();
//        modelAndView.setViewName("AllRestuarant");
//        return modelAndView;
//    }
	
	
	
}
