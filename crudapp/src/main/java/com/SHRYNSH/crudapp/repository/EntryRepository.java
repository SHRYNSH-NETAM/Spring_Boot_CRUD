package com.SHRYNSH.crudapp.repository;

import com.SHRYNSH.crudapp.entry.Entry;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface EntryRepository extends MongoRepository<Entry, String> {

}






