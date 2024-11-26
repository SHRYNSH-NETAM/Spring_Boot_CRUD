package com.SHRYNSH.crudapp.controller;

import com.SHRYNSH.crudapp.entry.Entry;
import com.SHRYNSH.crudapp.service.EntryServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/entry")
public class EntryController {

    @Autowired
    private EntryServices entryServices;
    @GetMapping("/all")
    public List<Entry> getAllEntries() {
        return entryServices.entryRepository.findAll();
    }

    @GetMapping("/id/{myid}")
    public Entry getEntry(@PathVariable String myid) {
        return entryServices.entryRepository.findById(myid).orElse(null);
    }

    @PostMapping("/add")
    public Entry addEntry(@RequestBody Entry entry) {
        entryServices.saveEntry(entry);
        return entry;
    }

    @DeleteMapping("/delete/{myid}")
    public boolean deleteEntry(@PathVariable String myid) {
        entryServices.entryRepository.deleteById(myid);
        return true;
    }

    @PutMapping("/update/{myid}")
    public Entry updateEntry(@PathVariable String myid,@RequestBody Entry entry) {
        Entry myEntry = entryServices.entryRepository.findById(myid).orElse(null);
        if (myEntry != null) {
            myEntry.setTitle(entry.getTitle() != null && !entry.getTitle().isEmpty() ? entry.getTitle() : myEntry.getTitle());
            myEntry.setContent(entry.getContent() != null && !entry.getContent().isEmpty() ? entry.getContent() : myEntry.getContent());
        }
        entryServices.saveEntry(myEntry);
        return myEntry;
    }
}
