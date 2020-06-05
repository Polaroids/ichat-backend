package org.buaa.ichat.video;

import javax.websocket.Session;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class OnlineUser {

  // ConcurrentHashMap: 相当于线程安全的HashMap.
  // 这里存储 useruserID-UserSession
  private ConcurrentHashMap<String, UserSession> usersByUserID = new ConcurrentHashMap<>();
  // 这里则是 Session.id-UserSession
  private ConcurrentHashMap<String, UserSession> usersBySessionId = new ConcurrentHashMap<>();

  //用户上线
  public void online(UserSession user) throws NullPointerException {
    System.out.println("online.");
    try {
      usersByUserID.put(user.getuserID(), user);
    } catch (NullPointerException e) {
      System.out.println("1111111end.");
      return;
    }

    try {
      usersBySessionId.put(user.getSession().getId(), user);
    } catch (NullPointerException e) {
      System.out.println("2222222222end.");
      return;
    }

//    usersByUserID.put(user.getuserID(), user);
//    usersBySessionId.put(user.getSession().getId(), user);
  }

  public UserSession getByuserID(String userID) {
    return usersByUserID.get(userID);
  }

  public UserSession getBySession(Session session) {
    System.out.println(session);
    if(session.getId() == null) {
      System.out.println("???");
      return null;
    }
    return usersBySessionId.get(session.getId());
  }

  public boolean exists(String userID) {
    return usersByUserID.keySet().contains(userID);
  }

  public UserSession removeBySession(Session session) {
    final UserSession user = getBySession(session);
    if (user != null) {
      usersByUserID.remove(user.getuserID());
      usersBySessionId.remove(session.getId());
    }
    return user;
  }

  public void printOnlineUserID() {
      Iterator iter = usersByUserID.entrySet().iterator();
      while(iter.hasNext()) {
          Map.Entry entry = (Map.Entry) iter.next();
          Object key = entry.getKey();
          Object value = entry.getValue();
          System.out.println(key + ":" + value);
      }
  }

}
