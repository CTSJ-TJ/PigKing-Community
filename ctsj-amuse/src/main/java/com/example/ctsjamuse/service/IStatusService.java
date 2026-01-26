package com.example.ctsjamuse.service;

import com.example.ctsjamuse.entity.Clickcollect;
import org.springframework.stereotype.Service;

import java.util.Map;


public interface IStatusService {
   Map findstatus(Clickcollect clickcollect);
   int modify(Clickcollect clickcollect);
}
