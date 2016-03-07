package org.tiger.RestoAppDemo.Feedback;

import org.bson.types.ObjectId;
import org.mongodb.morphia.annotations.Id;

/**
 * Created by aniket on 3/2/16.
 */
public class Telephone {

  /*  "tel": {
        "areaCode": "12",
         "number": "12"
    },*/


    @Id
    private ObjectId id;

    public ObjectId getId() {
        return id;
    }

    private String areaCode;
    private int number;

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
        return areaCode != null ? areaCode.equals(telephone.areaCode) : telephone.areaCode == null;

    }

    @Override
    public int hashCode() {
        int result = areaCode != null ? areaCode.hashCode() : 0;
        result = 31 * result + number;
        return result;
    }

    public String getAreaCode() {

        return areaCode;
    }

    public int getNumber() {
        return number;
    }
}
