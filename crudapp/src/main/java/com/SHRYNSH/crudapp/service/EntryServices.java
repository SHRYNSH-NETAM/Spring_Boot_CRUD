package com.SHRYNSH.crudapp.service;

import com.SHRYNSH.crudapp.entry.Entry;
import com.SHRYNSH.crudapp.repository.EntryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class EntryServices {
    @Autowired
    public EntryRepository entryRepository;

    public void saveEntry(Entry entry) {
        entryRepository.save(entry);
    }
}
