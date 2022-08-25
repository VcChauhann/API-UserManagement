package com.credManager.Controller;

import com.credManager.Repository.TextAreaRepo;
import com.credManager.model.WritersContent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
@CrossOrigin(origins = "*")
public class SaveWrittenContent {

    @Autowired
    private TextAreaRepo repo;

    @RequestMapping(value = "/saveToDB", method = RequestMethod.POST)
    public void saveTodb(@RequestBody HashMap textContent) {

        WritersContent content = new WritersContent();
        content.setId(repo.findAll().size());
        content.setText((String) textContent.get("text"));
        content.setEmail((String) textContent.get("email"));
        Date date = new Date();

        content.setCreatedOn(date.toString().substring(0, 19));
        content.setLastEditedOn(date.toString().substring(0, 19));

        repo.save(content);
    }

    @RequestMapping(value = "/getDbData", method = RequestMethod.POST)
    public List<WritersContent> getDbData(@RequestBody HashMap textContent) {


        List<WritersContent> contentList = new ArrayList<>();
        repo.findAll().forEach(content -> {
            if (content.getEmail().equals(textContent.get("email"))) {
                contentList.add(content);
            }
        });

        return contentList;
    }


    @RequestMapping(value = "/deleteSelectedData", method = RequestMethod.POST)
    public boolean deleteData(@RequestBody HashMap map) {

        if (repo.existsById((Integer) map.get("id")))
            repo.deleteById((Integer) map.get("id"));

        if (!repo.existsById((Integer) map.get("id")))
            return true;
        return false;
    }


    @RequestMapping(value = "/getDataOfId", method = RequestMethod.POST)
    public WritersContent getEditingData(@RequestBody HashMap map) {

        if(repo.findById((Integer) map.get("id")).isPresent()){
            return repo.findById((Integer) map.get("id")).get();
        }
        return null;
    }

    @RequestMapping(value = "/saveEditing", method = RequestMethod.POST)
    public void saveEditing(@RequestBody WritersContent content) {


        System.out.println(content);
        if(repo.existsById(content.getId())){
            Date date = new Date();
            content.setLastEditedOn(date.toString().substring(0, 19));
            repo.deleteById(content.getId());
            repo.save(content);
        }
    }
}
