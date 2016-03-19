package com.web.mvc;

import com.google.common.net.HttpHeaders;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 */

@Controller
public class LoginController {
    private static final org.slf4j.Logger log = LoggerFactory.getLogger(LoginController.class);

    @RequestMapping(value = "/mvc/login", method = RequestMethod.POST,
            headers = "content-type=application/x-www-form-urlencoded")
    public String welcome(HttpServletRequest request, HttpServletResponse response) {

       log.info(request.getParameter("username"));
        //call oauth/token
        //set response in cookie

        // set ApiKeyToken
        Cookie cookie = new Cookie("CAN-RefreshToken", "3fe15644-fa02-4bb6-8047-3242e5b161f7");
        cookie.setPath("/rest");
        cookie.setHttpOnly(true);
        cookie.setSecure(true);
        // A negative value means that the cookie is not stored persistently and will be deleted when the Web browser exits.
        cookie.setMaxAge( -1);
        cookie.setDomain("localhost");
        response.addCookie(cookie);
        response.setHeader(HttpHeaders.AUTHORIZATION, "Bearer 3fe15644-fa02-4bb6-8047-3242e5b161f7");
        return "hello";
    }
}
