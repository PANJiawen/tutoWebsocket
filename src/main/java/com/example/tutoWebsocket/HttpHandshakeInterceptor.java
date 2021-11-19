package com.example.tutoWebsocket;

import org.springframework.web.socket.server.HandshakeInterceptor;

import com.example.tutoWebsocket.model.User;

import org.springframework.http.server.ServerHttpRequest;
import org.springframework.http.server.ServerHttpResponse;
import org.springframework.http.server.ServletServerHttpRequest;
import org.springframework.web.socket.WebSocketHandler;
import javax.servlet.http.HttpSession;
import java.util.Map;

public class HttpHandshakeInterceptor implements HandshakeInterceptor {

    @Override
    public boolean beforeHandshake(ServerHttpRequest request, ServerHttpResponse response,
                                   WebSocketHandler wsHandler, Map<String, Object> attributes) {
        ServletServerHttpRequest serverRequest = (ServletServerHttpRequest) request;
        HttpSession session = serverRequest.getServletRequest().getSession();
        if (session != null) {
            User user = (User) session.getAttribute("user");
            if (user != null) {
                attributes.put("user", user);
                return true;
            }
        }
        return false;
    }

    @Override
    public void afterHandshake(ServerHttpRequest request, ServerHttpResponse response,
                               WebSocketHandler wsHandler, Exception ex) {
    }

}