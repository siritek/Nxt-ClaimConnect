package com.example.nxtconnect.service;

import java.util.List;

import com.example.nxtconnect.model.SearchNoteModel;

public interface SearchNoteService {

    public void saveSearchNote(SearchNoteModel searchNoteModel);

    public List<SearchNoteModel> getAllsearchnotes();
}
