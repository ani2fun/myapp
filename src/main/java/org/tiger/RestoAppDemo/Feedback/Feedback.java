package org.tiger.RestoAppDemo.Feedback;


import org.bson.types.ObjectId;
import org.mongodb.morphia.annotations.Embedded;
import org.mongodb.morphia.annotations.Entity;
import org.mongodb.morphia.annotations.Id;

/**
 * Created by aniket on 3/2/16.
 */

@Entity(value = "feedback", noClassnameStored = true)
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
    }*/



    @Id
    private String id;

    private String mychannel;
    private String firstName;
    private String lastName;
    private Boolean agree;
    private String email;
    private String comments;

    private Telephone tel;

    public String getId() {
        return id;
    }

    public String getMychannel() {
        return mychannel;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public Boolean getAgree() {
        return agree;
    }

    public String getEmail() {
        return email;
    }

    public String getComments() {
        return comments;
    }

    public Telephone getTel() {
        return tel;
    }
}
