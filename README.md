# Instructions and General Information

## Instructions
The project is based on a small java program to simulate the retail discounts which uses the following technologies:

* Java 1.8
* JUnit for Unit Tests
* Intellij to run and test the program


Since the program is created in Intellij it is recommended to also run and test it by importing it into Intellij though other IDE's can also be used. You can run the program by executing RetailStoreDiscountApplication.java file in Eclipse

Furthermore, unit tess are provided that can run by executing shopping.test.TestDiscounts and shopping.test.TestWithoutDiscounts. To get the complete test coverage just run JUnit Tests in IDE.

Comments are provided in the code and test cases for briefly describe the functionality and approach.


For building, use maven command
mvn clean build

For execution, use the jar file present in the target folder after build, following command run the application on tomcat at port 8080
java -jar RetailStore-0.0.1-SNAPSHOT.jar

endPoints is http://localhost:8080/shoppingcart
with request request body json , example as below:-

{
   "userDto":{
      "userName":"Ravi",
      "type":1
   },
   "itemGroceryDto":{
      "name":"Rice",
      "unitPrice":"20",
      "type":0,
      "quantity":4
   },
   "itemOtherDto":{
      "name":"TV",
      "unitPrice":"22",
      "type":1,
      "quantity":4
   }
}


## General Information regarding the solution

- **Items** represent goods/products that can be placed in the cart.

- A **ShoppingCart** contains a number of items, and can compute the total price of its contents.

- ShoppingCart items can either be actual **products** with a fixed unit price, or products with a **pricing policy** attached for any dicounts that are calculated based on items and not the overall discount policy of current cart.

- **DiscountPolicy** is used to calculate or apply different discounts based on overall cart value of contents.

