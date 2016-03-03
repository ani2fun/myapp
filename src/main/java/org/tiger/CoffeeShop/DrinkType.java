package org.tiger.CoffeeShop;

/**
 * Created by aniket on 3/2/16.
 */
public class DrinkType {

   /* "type": {
        "name": "Cappucino",
                "family": "coffee"
    }*/

    private String name;
    private String family;

    @Override
    public String toString() {
        return "DrinkType{" +
                "name='" + name + '\'' +
                ", family='" + family + '\'' +
                '}';
    }

    public String getName() {
        return name;
    }

    public String getFamily() {
        return family;
    }

    @Override
    public boolean equals(Object o) {

        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        DrinkType drinkType = (DrinkType) o;

        if (name != null ? !name.equals(drinkType.name) : drinkType.name != null) return false;
        return family != null ? family.equals(drinkType.family) : drinkType.family == null;

    }

    @Override
    public int hashCode() {
        int result = name != null ? name.hashCode() : 0;
        result = 31 * result + (family != null ? family.hashCode() : 0);
        return result;
    }
}
