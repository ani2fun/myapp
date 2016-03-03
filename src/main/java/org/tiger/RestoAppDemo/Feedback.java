package org.tiger.RestoAppDemo;


import org.bson.types.ObjectId;
import org.mongodb.morphia.annotations.Entity;
import org.mongodb.morphia.annotations.Id;

/**
 * Created by aniket on 3/2/16.
 */

@Entity("feedback")

public class Feedback {

   /* "feedback": [
    {
        "mychannel": "",
            "firstName": "Aniket",
            "lastName": "K",
            "agree": false,
            "email": "ak@gm.com",
            "tel": {
        "areaCode": "12",
                "number": "12"
    },
        "comments": "Hello",
            "id": 1
    },*/



    @Id
    private ObjectId id;
    private String name;





}
