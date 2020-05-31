package org.buaa.ichat.video;

import org.springframework.web.socket.WebSocketSession;

import java.util.concurrent.ConcurrentHashMap;

/**
 * Map of users registered in the system. This class has a concurrent hash map to store users, using
 * its name as key in the map.
 * 
 * @author Boni Garcia (bgarcia@gsyc.es)
 * @author Micael Gallego (micael.gallego@gmail.com)
 * @since 4.3.1
 */
public class UserRegistry {

  // ConcurrentHashMap: 相当于线程安全的HashMap.
  private ConcurrentHashMap<String, org.kurento.tutorial.one2onecall.UserSession> usersByName = new ConcurrentHashMap<>();
  private ConcurrentHashMap<String, org.kurento.tutorial.one2onecall.UserSession> usersBySessionId = new ConcurrentHashMap<>();

  public void register(org.kurento.tutorial.one2onecall.UserSession user) {
    usersByName.put(user.getName(), user);
    usersBySessionId.put(user.getSession().getId(), user);
  }

  public org.kurento.tutorial.one2onecall.UserSession getByName(String name) {
    return usersByName.get(name);
  }

  public org.kurento.tutorial.one2onecall.UserSession getBySession(WebSocketSession session) {
    return usersBySessionId.get(session.getId());
  }

  public boolean exists(String name) {
    return usersByName.keySet().contains(name);
  }

  public org.kurento.tutorial.one2onecall.UserSession removeBySession(WebSocketSession session) {
    final org.kurento.tutorial.one2onecall.UserSession user = getBySession(session);
    if (user != null) {
      usersByName.remove(user.getName());
      usersBySessionId.remove(session.getId());
    }
    return user;
  }

}
