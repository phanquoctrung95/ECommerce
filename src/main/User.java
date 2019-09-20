package main;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class User {

    private String name;
    private String email;
    private ShoppingCart shoppingCart;

    public User(String name, String email, ShoppingCart shoppingCart) {
        this.name = name;
        this.email = email;
        this.shoppingCart = shoppingCart;
    }

    public User(String name, String email) {
        this.name = name;
        this.email = email;
        shoppingCart = new ShoppingCart();
        System.out.println("Log.info: User - success create user, name: " + this.name + " email: " + this.email);
    }

    public User() {
        shoppingCart = new ShoppingCart();
    }

    public boolean addProduct(String productName) {
        return shoppingCart.addProduct(productName, 1);
    }

    public boolean addProduct(String productName, int quantum) {
        return shoppingCart.addProduct(productName, quantum);
    }

    public boolean removeProduct(String productName) {
        return shoppingCart.removeProduct(productName, 1);
    }

    public boolean removeProduct(String productName, int quantum) {
        return shoppingCart.removeProduct(productName, quantum);
    }

    class ShoppingCart {

        private List<Product> products;

        public boolean addProduct(String productName, int quantum) {
            if (quantum <= 0) {
                System.out.println("Log.error: addProduct - quantum too small");
                return false;
            }
            if (Utils.Instance.getPriceMap().containsKey(productName)) {
                Double productPrice = Utils.Instance.getPriceMap().get(productName);
                int tmpQuantum = quantum;
                while (tmpQuantum > 0) {
                    products.add(new Product(productName, productPrice));
                    tmpQuantum--;
                }
                System.out.println("Log.info: addProduct - success add " + quantum + " product " + productName);
                return true;
            }
            System.out.println("Log.error: addProduct - Does not support this product - " + productName);
            return false;
        }

        public boolean removeProduct(String productName, int quantum) {
            if (quantum <= 0) {
                System.out.println("Log.error: removeProduct - quantum too small");
                return false;
            }
            if (Utils.Instance.getPriceMap().containsKey(productName)) {
                if (quantum > products.size()) {
                    System.out.println("Log.error: removeProduct - quantum too large");
                    return false;
                }
                int tmpQuantum = quantum;
                List<Product> deleteList = new ArrayList<>();
                while (tmpQuantum > 0) {
                    for (int i = 0; i < products.size(); i++) {
                        if (products.get(i).getName().equals(productName)) {
                            deleteList.add(products.remove(i));
                            break;
                        }
                    }
                    tmpQuantum--;
                }
                if (deleteList.size() < quantum) {
                    products.addAll(deleteList);
                    System.out.println("Log.error: removeProduct - quantum too large");
                    return false;
                } else {
                    System.out.println("Log.info: removeProduct - success remove " + quantum + " product " + productName);
                    return true;
                }
            }
            System.out.println("Log.error: removeProduct - Does not support this product - " + productName);
            return false;
        }

        public double totalPrice() {
            float sum = 0f;
            if (products != null && !products.isEmpty()) {
                for (int i = 0; i < products.size(); i++) {
                    sum += Utils.Instance.getPriceMap().get(products.get(i).getName());
                }
                return Math.round(sum * 100) / 100.0;
            }
            System.out.println("Log.info: totalPrice - ShoppingCart is empty");
            return 0f;
        }

        public ShoppingCart() {
            products = new ArrayList<>();
        }

        public ShoppingCart(List products) {
            this.products = products;
        }

        /**
         * @return the products
         */
        public List<Product> getProducts() {
            return products;
        }

    }

    /**
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * @param name the name to set
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * @return the email
     */
    public String getEmail() {
        return email;
    }

    /**
     * @param email the email to set
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * @return the cart
     */
    public ShoppingCart getCart() {
        return shoppingCart;
    }

    /**
     * @param cart the cart to set
     */
    public void setCart(ShoppingCart cart) {
        this.shoppingCart = cart;
    }

}
