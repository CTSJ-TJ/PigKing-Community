package com.example.ctsjamuse.mapper;

import com.example.ctsjamuse.entity.Clickcollect;

public interface StatusMapper {
    Clickcollect findstatus(Clickcollect clickcollect);
    int add(Clickcollect clickcollect);

    int modifyclick(Clickcollect clickcollect);
    int modifycollect(Clickcollect clickcollect);
}
