package org.tiger.RestoAppDemo.Menu;

import org.mongodb.morphia.annotations.Entity;

import java.util.Date;

/**
 * Created by aniket on 3/4/16.
 */

public class DishComment {

   /* {
            "rating": 5,
            "comment": "Imagine all the eatables, living in conFusion!",
            "author": "John Lemon",
            "date": "2012-10-16T17:57:28.556094Z"
    }*/


    private int rating;
    private String comment;
    private String author;
    private String date;


    public int getRating() {
        return rating;
    }

    public String getComment() {
        return comment;
    }

    public String getAuthor() {
        return author;
    }

    public String getDate() {
        return date;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        DishComment that = (DishComment) o;

        if (rating != that.rating) return false;
        if (comment != null ? !comment.equals(that.comment) : that.comment != null) return false;
        if (author != null ? !author.equals(that.author) : that.author != null) return false;
        return date != null ? date.equals(that.date) : that.date == null;

    }

    @Override
    public int hashCode() {
        int result = rating;
        result = 31 * result + (comment != null ? comment.hashCode() : 0);
        result = 31 * result + (author != null ? author.hashCode() : 0);
        result = 31 * result + (date != null ? date.hashCode() : 0);
        return result;
    }
}
