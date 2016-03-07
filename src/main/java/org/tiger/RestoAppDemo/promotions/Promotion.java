package org.tiger.RestoAppDemo.promotions;

import org.bson.types.ObjectId;
import org.mongodb.morphia.annotations.Entity;
import org.mongodb.morphia.annotations.Id;

/**
 * Created by aniket on 3/5/16.
 */

@Entity(value="promotions", noClassnameStored = true)
public class Promotion {

   /* {
        "id": 0,
            "name": "Weekend Grand Buffet",
            "image": "images/buffet.png",
            "label": "New",
            "price": "19.99",
            "description": "Featuring mouthwatering combinations with a choice of five different salads, six enticing appetizers, six main entrees and five choicest desserts. Free flowing bubbly and soft drinks. All for just $19.99 per person "
    }*/

    @Id
    private ObjectId objectId;

    private String id;
    private String name;
    private String image;
    private String label;
    private String price;
    private String description;

    public ObjectId getObjectId() {
        return objectId;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getImage() {
        return image;
    }

    public String getLabel() {
        return label;
    }

    public String getPrice() {
        return price;
    }

    public String getDescription() {
        return description;
    }

    @Override
    public String toString() {
        return "Promotion{" +
                "objectId=" + objectId +
                ", id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", image='" + image + '\'' +
                ", label='" + label + '\'' +
                ", price='" + price + '\'' +
                ", description='" + description + '\'' +
                '}';
    }
}
