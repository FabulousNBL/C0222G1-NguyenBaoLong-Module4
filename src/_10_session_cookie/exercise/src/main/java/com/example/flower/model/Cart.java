package com.example.flower.model;

import java.util.HashMap;
import java.util.Map;

public class Cart {
    private Map<Flower, Integer> flowerIntegerMap = new HashMap<>();

    public Cart() {
    }

    public Map<Flower, Integer> getFlower() {
        return flowerIntegerMap;
    }

    private boolean checkItemInCart(Flower flower) {
        for (Map.Entry<Flower, Integer> entry : flowerIntegerMap.entrySet()) {
            if (entry.getKey().getId() == flower.getId()) {
                return true;
            }
        }
        return false;
    }

    private Map.Entry<Flower, Integer> selectItemInCart(Flower flower) {
        for (Map.Entry<Flower, Integer> flowers : flowerIntegerMap.entrySet()) {
            if (flowers.getKey().getId() == flower.getId()) {
                return flowers;
            }
        }
        return null;
    }

    public void addToCart(Flower flower) {
        if (!checkItemInCart(flower)) {
            flowerIntegerMap.put(flower, 1);
        } else {

            Map.Entry<Flower, Integer> maps = selectItemInCart(flower);
            Integer amount = maps.getValue() + 1;
            flowerIntegerMap.replace(maps.getKey(), amount);

        }
    }

    public void addProduct(Flower flower) {
        if (!checkItemInCart(flower)) {
            flowerIntegerMap.put(flower, 1);
        } else {
            Map.Entry<Flower, Integer> itemEntry = selectItemInCart(flower);
            Integer newQuantity = itemEntry.getValue() + 1;
            flowerIntegerMap.replace(itemEntry.getKey(), newQuantity);
        }
    }
    public Integer countProductQuantity(){
        Integer productQuantity = 0;
        for (Map.Entry<Flower, Integer> entry : flowerIntegerMap.entrySet()) {
            productQuantity += entry.getValue();
        }
        return productQuantity;
    }

    public Integer countItemQuantity(){
        return flowerIntegerMap.size();
    }

    public void clearCart(){
        flowerIntegerMap.clear();
    }

    public Float countTotalPayment(){
        float payment = 0;
        for (Map.Entry<Flower, Integer> entry : flowerIntegerMap.entrySet()) {
            payment += entry.getKey().getPrice() * (float) entry.getValue();
        }
        return payment;
    }
    public void decreaseProduct(Flower flower){
        Map.Entry<Flower, Integer> itemEntry = selectItemInCart(flower);
        if (itemEntry.getValue() == 1){
            flowerIntegerMap.remove(itemEntry.getKey());
        } else {
            Integer newQuantity = itemEntry.getValue() - 1;
            flowerIntegerMap.replace(itemEntry.getKey(),newQuantity);
        }
    }
}
