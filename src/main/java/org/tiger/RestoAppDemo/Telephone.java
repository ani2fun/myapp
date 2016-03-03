package org.tiger.RestoAppDemo;

/**
 * Created by aniket on 3/2/16.
 */
public class Telephone {

  /*  "tel": {
        "areaCode": "12",
         "number": "12"
    },*/


    private String areaCode;
    private int number;

    public String getAreaCode() {
        return areaCode;
    }

    public int getNumber() {
        return number;
    }


    @Override
    public String toString() {
        return "Telephone{" +
                "areaCode='" + areaCode + '\'' +
                ", number=" + number +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Telephone telephone = (Telephone) o;

        if (number != telephone.number) return false;
        return areaCode.equals(telephone.areaCode);

    }

    @Override
    public int hashCode() {
        int result = areaCode.hashCode();
        result = 31 * result + number;
        return result;
    }
}
