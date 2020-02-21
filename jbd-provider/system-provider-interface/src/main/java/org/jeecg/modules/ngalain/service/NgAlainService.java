package org.jeecg.modules.ngalain.service;

import com.alibaba.fastjson.JSONArray;
import org.jeecg.modules.system.entity.SysPermission;

import java.util.List;
import java.util.Map;

public interface NgAlainService {
    public JSONArray getMenu(String id,List<SysPermission> metaList) throws Exception;
    public JSONArray getJeecgMenu(String id,List<SysPermission> metaList) throws Exception;
    public List<Map<String, String>> getDictByTable(String table, String key, String value);
}
