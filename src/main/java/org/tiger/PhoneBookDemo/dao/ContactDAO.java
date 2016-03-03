package org.tiger.PhoneBookDemo.dao;

import org.skife.jdbi.v2.sqlobject.Bind;
import org.skife.jdbi.v2.sqlobject.SqlQuery;
import org.skife.jdbi.v2.sqlobject.customizers.Mapper;
import org.tiger.PhoneBookDemo.dao.mappers.ContactMapper;
import org.tiger.PhoneBookDemo.representations.Contact;

/**
 * Created by aniket on 3/2/16.
 */
public interface ContactDAO {

    @Mapper(ContactMapper.class)
    @SqlQuery("select * from contact where id = :id")
    Contact getContactById(@Bind("id") int id);



}
