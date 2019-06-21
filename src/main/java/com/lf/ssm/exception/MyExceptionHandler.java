package com.lf.ssm.exception;

import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class MyExceptionHandler implements HandlerExceptionResolver {
    @Override
    public ModelAndView resolveException(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, Exception e) {
        httpServletResponse.setContentType("application/json; charset=utf-8");
        try {
            httpServletResponse.getWriter().write("{\n" +
                    "    \"code\": \"400\",\n" +
                    "    \"msg\": \""+e.getMessage()+"\"\n" +
                    "}");
        } catch (IOException e1) {
            e1.printStackTrace();
        }

        return null;
    }
}
