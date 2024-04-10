package com.example.nxtconnect.service;

import com.example.nxtconnect.model.Diary;

import java.util.List;

public interface DiaryService {


    public void saveDiary(Diary diary);

    public List<Diary> getAlldiaries() ;
}
