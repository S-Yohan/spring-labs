package com.revature.L2_notebook.Service;

import com.revature.L2_notebook.NotebookApplication;
import com.revature.L2_notebook.Model.Entry;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.ArrayList;
import java.util.List;

/**
 * This class is a component, which makes it a potential Bean. When Spring undergoes its initial Component Scan,
 * this class will be turned into a bean which may be injected into other classes, such as the NotebookController.
 *
 * TODO: TimeService hasn't been labelled a Component yet, so it can't be injected into the Constructor as a Bean!
 * You will need to add the @Component annotation to TimeService.
 */


@Component
public class NotebookService {
    List<Entry> entries;
    TimeService timeService = new TimeService();

    /**
     * Using the @Autowired annotation and Constructor Injection, the most appropriate bean will be injected into this
     * class from the Spring IOC container, which contains all the beans. IOC stands for inversion-of-control -
     * Spring is controlling the instantiation of Objects, rather than the developer.
     * @param timeService
     */
    @Autowired
    public NotebookService(TimeService timeService){
        this.timeService = timeService;
        entries = new ArrayList<>();
        NotebookApplication.log.info("NotebookService: Just instantiated a new NotebookService! Dependency injection for the win");
    }

    /**
     * @return all entries from the list of notebook entries
     */
    public List<Entry> getEntries(){
        NotebookApplication.log.info("NotebookService: Getting all entries: "+entries);
        return entries;
    }

    /**
     * Add a new entry, but also leverage the TimeService to obtain the current time and date.
     * @param entry an Entry object
     * @return the added entry
     */
    public Entry addEntry(Entry entry){
        entry.setTime(timeService.getCurrentTime());
        entries.add(entry);
        NotebookApplication.log.info("NotebookService: Added a new entry: "+entry);
        return entry;
    }

    /**
     * Get an entry by its entryNumber
     * @param entryNumber the index of the entry in the entrylist
     * @return entry of id entryNumber
     */
    public Entry getEntriesById(int entryNumber) {
        Entry entry = entries.get(entryNumber);
        NotebookApplication.log.info("NotebookService: Getting an entry by id: "+entryNumber+" which is "+entry);
        return entry;
    }

    /**
     * TODO: add the service method necessary for the deletion of a notebook entry by its entryNumber.
     */
    public Entry deleteEntry(int id) {
        Entry entry = entries.get(id);
        entries.remove(entry);
        return entry;
    }


}
