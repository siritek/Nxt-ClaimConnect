package com.example.nxtconnect.controller;

import java.util.List;

import com.example.nxtconnect.model.SearchNoteModel;
import com.example.nxtconnect.service.SearchNoteServiceImpl;
import org.springframework.web.bind.annotation.*;

//@CrossOrigin(origins = {"http://localhost:3000", "https://gfnurnjftf.us-east-1.awsapprunner.com"})
@RestController
@RequestMapping("/searchnotefirst")
public class SearchNoteController
{
    private SearchNoteServiceImpl SearchNoteService = new SearchNoteServiceImpl();

    @PostMapping("/add")
    public String add(@RequestBody SearchNoteModel searchNoteModel) {
        SearchNoteService.saveSearchNote(searchNoteModel);
        System.out.println("Connection reached Controller");
        return "Search note info is added";
        }
        @GetMapping("/getAll")
        public List<SearchNoteModel> getAllsearchnotes(){
        return SearchNoteService.getAllsearchnotes();
        }

    }

