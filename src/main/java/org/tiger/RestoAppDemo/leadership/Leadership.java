package org.tiger.RestoAppDemo.leadership;

import org.bson.types.ObjectId;
import org.mongodb.morphia.annotations.Entity;
import org.mongodb.morphia.annotations.Id;

/**
 * Created by aniket on 3/5/16.
 */

@Entity(value = "leadership",noClassnameStored = true)
public class Leadership {

    /*{
        "id": 0,
            "name": "Peter Pan",
            "image": "images/alberto.png",
            "designation": "Chief Epicurious Officer",
            "abbr": "CEO",
            "description": "Our CEO, Peter, credits his hardworking East Asian immigrant parents who undertook the arduous journey to the shores of America with the intention of giving their children the best future. His mother's wizardy in the kitchen whipping up the tastiest dishes with whatever is available inexpensively at the supermarket, was his first inspiration to create the fusion cuisines for which The Frying Pan became well known. He brings his zeal for fusion cuisines to this restaurant, pioneering cross-cultural culinary connections."
    }*/

    @Id
    private ObjectId objectId;

    private String id;
    private String name;
    private String image;
    private String designation;
    private String abbr;
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

    public String getDesignation() {
        return designation;
    }

    public String getAbbr() {
        return abbr;
    }

    public String getDescription() {
        return description;
    }

    @Override
    public String toString() {
        return "Leadership{" +
                "objectId=" + objectId +
                ", id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", image='" + image + '\'' +
                ", designation='" + designation + '\'' +
                ", abbr='" + abbr + '\'' +
                ", description='" + description + '\'' +
                '}';
    }
}
