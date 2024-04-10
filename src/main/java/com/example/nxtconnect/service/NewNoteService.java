package com.example.nxtconnect.service;

import java.util.List;

import com.example.nxtconnect.model.NewNoteModel;

public interface NewNoteService {




        public void saveNewNote(NewNoteModel newnote);

        public List<NewNoteModel> getAllnewnotes() ;

}
