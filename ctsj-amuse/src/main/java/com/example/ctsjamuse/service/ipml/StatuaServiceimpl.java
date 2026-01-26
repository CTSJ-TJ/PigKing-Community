package com.example.ctsjamuse.service.ipml;

import com.example.ctsjamuse.entity.Clickcollect;
import com.example.ctsjamuse.mapper.StatusMapper;
import com.example.ctsjamuse.service.IStatusService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class StatuaServiceimpl implements IStatusService {

    @Autowired
    StatusMapper statusMapper;

    @Override
    public Map findstatus(Clickcollect clickcollect){
         Map map=new HashMap();
         Clickcollect entity=statusMapper.findstatus(clickcollect);
         if(entity==null){
             map.put("code",0);
             int a=statusMapper.add(clickcollect);
             System.out.println("this ia a:"+a);
             return map;
         }else{
             Integer click=entity.getClickstatus();
             Integer collect=entity.getCollectstatus();
             if(click==0&&collect==0){
                 map.put("code",0);
             } else if(click==1&&collect!=1){
                 map.put("code",1);
             }else if(click!=1&&collect==1){
                 map.put("code",2);
             }else {
                 map.put("code",3);
             }
             return map;
         }
    }

    @Override
    public int modify(Clickcollect entity){
        if(entity.getCollectstatus()!=null){
             return statusMapper.modifycollect(entity);
        }else if(entity.getClickstatus()!=null){
             return statusMapper.modifyclick(entity);
        }else {
            return -1;
        }
    }

}
