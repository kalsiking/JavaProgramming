package com.gurpreet;

import java.util.*;

public class CollectionsSet {
    public static void main(String[] args) {

        System.out.println("Welcome to Gurpreet's Java Programming.");
        mapOperation();
    }
    static Map<Integer, String> obj = new LinkedHashMap<>();


    static void mapOperation(){
        obj.put(3,"ok");
        obj.put(5,"yes");
        obj.put(7, "no");


        Iterator it = obj.entrySet().iterator();
        while(it.hasNext()){
            Map.Entry ok = (Map.Entry) it.next();
            ok.getKey();
            ok.getValue();
        }

        for(Map.Entry entry : obj.entrySet()){
            entry.getKey();
            entry.getValue();
        }

        final String[] i = {"0"};
        obj.forEach((k,v) -> i[0] += k+v);

        for(String ii : i)
        System.out.println(ii);


    }

}
class Product{
    String ItemName;
    String category;
}
class Pricing extends Product{
    String Item;
    Double price;
    Integer count;

    Double getPrice(String Item){
        return this.price;
    }
}
class Basket{
    List<Pricing> pricing;
    Map<Pricing, Integer> m = new HashMap<>();
    Billing bill;

    void addItem(Pricing item){
        pricing.add(item);
    }
    void removeItem(Pricing item){
        pricing.remove(item);
    }
}
class Billing{
    void generateBill(Basket bb){
        List<Pricing> ls = bb.pricing;

        for(Pricing p : ls){
           System.out.print(p.count * p.price);
        }

    }

}