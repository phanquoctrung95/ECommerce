package main;

public class ECommerce {

    public static void main(String[] args) {
        System.out.println("====CASE 1====");
        User doeUser_case1 = new User("John Doe", "john.doe@example.com");
        doeUser_case1.addProduct("Apple", 2);
        doeUser_case1.addProduct("Orange", 1);
        System.out.println("ShoppingCart total price: " + doeUser_case1.getCart().totalPrice());

        System.out.println("====CASE 2====");
        User doeUser_case2 = new User("John Doe", "john.doe@example.com");
        doeUser_case2.addProduct("Apple", 3);
        doeUser_case2.removeProduct("Apple", 1);
        System.out.println("ShoppingCart total price: " + doeUser_case2.getCart().totalPrice());

    }

}
