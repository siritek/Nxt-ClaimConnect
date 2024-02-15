package com.example.withoutdb.controller;

import java.util.List;

import com.example.withoutdb.model.NewNoteModel;
import com.example.withoutdb.service.NewNoteServiceImpl;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.web.bind.annotation.*;



@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/newnotefirst")

public class NewNoteController {


    private NewNoteServiceImpl newNoteService = new NewNoteServiceImpl();

    @PostMapping("/add")
    public String add(@RequestBody NewNoteModel newnote) {
        try {
            newNoteService.saveNewNote(newnote);
            String json = new ObjectMapper().writeValueAsString(newnote);
            System.out.println("received this json from react for submit claim :- " + json);
            System.out.println("Connection reached Controller");

        } catch (Exception e) {
            System.out.println(e);
        }
        return "New note info is added";
    }

    @GetMapping("/getAll")
    public List<NewNoteModel> getAllnewnotes() {
        return newNoteService.getAllnewnotes();
    }
}

/*
import java.util.List;

       import com.NewNotepage.NewNote.Model.NewNoteModel;
       import com.NewNotepage.NewNote.Service.NewNoteServiceImpl;
        import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/newnotefirst")
@CrossOrigin
public class NewNoteController {


    private NewNoteServiceImpl newNoteService = new NewNoteServiceImpl();

    @PostMapping("/add")
    public String add(@RequestBody NewNoteModel newnote){
        newNoteService.saveNewNote(newnote);
        System.out.println("Connection reached Controller");
        return "New note info is added";
    }

    @GetMapping("/getAll")
    public List<NewNoteModel> getAllnewnotes() {
        return newNoteService.getAllnewnotes();
    }
}
*/