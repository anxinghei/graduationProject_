package com.anxing.sys.session;

import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.Map;

public class MySessionContext {
    private static MySessionContext instance;
    private static Map<String, HttpSession> myMap ;
    private MySessionContext() {
        myMap = new HashMap();
    }
    public static MySessionContext getInstance() {
        if (instance == null) {
            instance = new MySessionContext();
        }
        return instance;
    }
    public static synchronized void addSession(HttpSession session) {
        if (session != null) {
            myMap.put(session.getId(), session);
        }
    }

    public static synchronized void removeSession(HttpSession session) {
        if (session != null) {
            myMap.remove(session.getId());
        }
    }

    public static synchronized HttpSession getSession(String sessionId) {
        if (sessionId == null)
            return null;
        return myMap.get(sessionId);
    }


    @Override
    public String toString() {
        System.out.println("============="+myMap);
        return myMap.toString();
    }
}


