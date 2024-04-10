package com.example.nxtconnect.service;

import com.example.nxtconnect.model.Injuries;
import java.util.List;

public interface InjuriesService
{
    public void saveInjuries(Injuries injuries);

    public List<Injuries> getAllInjuries();
}
