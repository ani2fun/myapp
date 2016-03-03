package org.tiger.PhoneBookDemo.dao.mappers;

import org.tiger.PhoneBookDemo.representations.Contact;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.skife.jdbi.v2.StatementContext;
import org.skife.jdbi.v2.tweak.ResultSetMapper;

/**
 * Created by aniket on 3/2/16.
 */

public class ContactMapper implements ResultSetMapper<Contact> {
    public Contact map(int index, ResultSet r, StatementContext ctx) throws SQLException {
        return new Contact(r.getInt("id"), r.getString("firstName"), r.getString("lastName"), r.getString("phone"));
    }
}
