/*
 *  UCF COP3330 Fall 2021 Assignment 4 Solutions
 *  Copyright 2021 Mohit Ballikar
 */
package baseline;
public class Products {
    //initialize the strings for the different attributes/parameters of the json file
    String name = "";
    String price = "";
    String quantity = "";

    //provides name
    public String getName() {
        return name;
    }
    //sets name as it is variable across doodad, thing, etc.
    public void setName(String name) {
        this.name = name;
    }

    //provides price
    public String getPrice() {
        return price;
    }
    //sets 'price' in a similar manner to 'name' above
    public void setPrice(String price) {
        this.price = price;
    }
    //provides quantity
    public String getQuantity() {
        return quantity;
    }
    //similar framework to above methods
    public void setQuantity(String quantity) {
        this.quantity = quantity;
    }

}