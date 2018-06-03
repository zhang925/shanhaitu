package com.sht.restcontroller.util;

import javax.servlet.http.HttpSession;
import java.util.HashMap;

public class SessionLoginContext {
    private static HashMap mymap = new HashMap();
    private static SessionLoginContext singObj = null;

    private SessionLoginContext(){

    }

    public static synchronized SessionLoginContext getSingleInstance(){//单例 线程安全
        if(null == singObj )
            singObj = new SessionLoginContext();
        return singObj;
    }

    public static synchronized void AddSession(HttpSession session) {
        if (session != null) {
            mymap.put(session.getId(), session);
        }
    }
    public static synchronized void DelSession(HttpSession session) {
        if (session != null) {
            mymap.remove(session.getId());
        }
    }
    public static synchronized HttpSession getSession(String session_id) {
        if (session_id == null)
            return null;
        return (HttpSession) mymap.get(session_id);
    }
}