package org.tiger.CoffeeShop;

import org.mongojack.Id;
import org.mongojack.ObjectId;

/**
 * Created by aniket on 3/2/16.
 */
public class Order {


  /*  {
        "type": {
        "name": "Cappucino",
                "family": "coffee"
    },
        "size": "Medium",
            "drinker": "aaa"
    }

    */


    @Id
    private String id;

    private long coffeeShopId;

    private String size;
    private String drinker;
    private DrinkType type;
    private String[] selectedOptions;


    public String getId() {
        return id;
    }

    public long getCoffeeShopId() {
        return coffeeShopId;
    }

    public String getSize() {
        return size;
    }

    public String getDrinker() {
        return drinker;
    }

    public DrinkType getType() {
        return type;
    }

    public String[] getSelectedOptions() {
        return selectedOptions;
    }

    public void setCoffeeShopId(long coffeeShopId) {
        this.coffeeShopId = coffeeShopId;
    }

    public void setId(String id) {
        this.id = id;
    }
}
