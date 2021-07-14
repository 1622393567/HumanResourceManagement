package com.lanqiao.bean;

import java.util.List;
import java.util.Map;

public class MenuTree {
    private Map<String, List<String>> menutree;

    public Map<String, List<String>> getMenutree() {
        return menutree;
    }

    public void setMenutree(Map<String, List<String>> menutree) {
        this.menutree = menutree;
    }
}
