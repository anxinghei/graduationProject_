package com.anxing.sys.session;

import org.apache.shiro.session.Session;
import org.apache.shiro.session.SessionListener;
import org.crazycake.shiro.RedisSessionDAO;

import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

//@WebListener
//public class MySessionListener implements HttpSessionListener{
//    public static Map userMap = new HashMap();
//    private MySessionContext myc=MySessionContext.getInstance();
//    public void sessionCreate(HttpSessionEvent sessionEvent) {
//        System.out.println("session注册===================================");
//        MySessionContext.addSession(sessionEvent.getSession());
//    }
//
//    public void sessionDestroy(HttpSessionEvent sessionEvent) {
//        MySessionContext.removeSession(sessionEvent.getSession());
//    }
//}

public class MySessionListener extends RedisSessionDAO implements SessionListener {
//    public  static final Map<Long,String> mapUser = Maps.newHashMap();
    public final static AtomicInteger sessionCount = new AtomicInteger(0);

    @Override
    public void onStart(Session session) {
        //会话创建，在线人数加一
        System.out.println(sessionCount+"==============" );
        sessionCount.incrementAndGet();
        MySessionContext.addSession((HttpSession) session);
        System.out.println("会话创建时的session"+session);

    }

    @Override
    public void onStop(Session session) {
        //会话退出,在线人数减一
        sessionCount.decrementAndGet();
    }

    @Override
    public void onExpiration(Session session) {
        //会话过期,在线人数减一
        sessionCount.decrementAndGet();

    }


    /**
     * 获取在线人数使用
     * @return
     */
    public AtomicInteger getSessionCount() {
        return sessionCount;
    }
}


