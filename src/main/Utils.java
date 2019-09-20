/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main;

import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author VipPro
 */
public class Utils {

    public static final Utils Instance = new Utils();
    private Map<String, Double> priceMap = new HashMap<>();

    private Utils() {
        priceMap.put("Apple", 4.95d);
        priceMap.put("Orange", 3.99d);
    }

    public Map<String, Double> getPriceMap() {
        return priceMap;
    }

    public boolean addListProduct(String productName, Double price) {
        if (!priceMap.containsKey(productName)) {
            return (priceMap.put(productName, price) == null);
        }
        System.out.println("Log.error: product existed");
        return false;
    }

    public boolean editListProduct(String productName, Double price) {
        if (priceMap.containsKey(productName)) {
            return (priceMap.put(productName, price) != null);
        }
        System.out.println("Log.error: product not exist");
        return false;
    }
    
}
