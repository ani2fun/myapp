package org.tiger.RestoAppDemo.Menu;

import org.bson.types.ObjectId;
import org.mongodb.morphia.annotations.Embedded;
import org.mongodb.morphia.annotations.Entity;
import org.mongodb.morphia.annotations.Id;
import org.mongodb.morphia.annotations.Transient;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by aniket on 3/4/16.
 */

@Entity(value="dishes",noClassnameStored = true)
public class Dish {


    /*

    {
            "id": 0,
            "name": "Uthapizza",
            "image": "images/uthapizza.png",
            "category": "mains",
            "label": "Hot",
            "price": 4.99,
            "description": "A unique combination of Indian Uthappam (pancake) and Italian pizza, topped with Cerignola olives, ripe vine cherry tomatoes, Vidalia onion, Guntur chillies and Buffalo Paneer.",
            "comments": [
        {
                "rating": 5,
                "comment": "Imagine all the eatables, living in conFusion!",
                "author": "John Lemon",
                "date": "2012-10-16T17:57:28.556094Z"
        },
         {
                "rating": 3,
                "comment": "Imagine all the eatables, living in conFusion!",
                "author": "John Lemon",
                "date": "2012-10-16T17:57:28.556094Z"
        }

        ]
    }

    */

    @Id
    private ObjectId objectId;

    private String id;
    private String name;
    private String image;
    private String category;

    private String label;
    private int price;
    private String description;
    @Embedded
    private List<DishComment> comments = new ArrayList<DishComment>();

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

    public String getCategory() {
        return category;
    }

    public String getLabel() {
        return label;
    }

    public int getPrice() {
        return price;
    }

    public String getDescription() {
        return description;
    }

    public List<DishComment> getComments() {
        return comments;
    }


    @Override
    public String toString() {
        return "Dish{" +
                "objectId=" + objectId +
                ", id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", image='" + image + '\'' +
                ", category='" + category + '\'' +
                ", label='" + label + '\'' +
                ", price=" + price +
                ", description='" + description + '\'' +
                ", comments=" + comments +
                '}';
    }
}
