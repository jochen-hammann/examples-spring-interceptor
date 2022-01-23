package com.example.spring.interceptor.handlerinterceptor.interceptors;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.example.spring.interceptor.handlerinterceptor.dto.MyError;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.UUID;

@Component
public class MyHandlerInterceptor implements HandlerInterceptor
{
    // ============================== [Fields] ==============================

    // -------------------- [Private Fields] --------------------

    private static final Logger logger = LoggerFactory.getLogger(MyHandlerInterceptor.class);

    // To get the following work, we have to annotate the current class with @Component. Thus the current class is contained in Spring's
    // application context. Now, we can autowire the current class in MyWebMvcConfigurer. If we instantiate the current class with new in
    // the MyWebMvcConfigurer's registry.addInterceptor() method, the objectMapper will be null.
    @Autowired
    private ObjectMapper objectMapper;

    // ============================== [Construction / Destruction] ==============================

    // -------------------- [Public Construction / Destruction] --------------------

    // ============================== [Getter/Setter] ==============================

    // -------------------- [Private Getter/Setter] --------------------

    // -------------------- [Public Getter/Setter] --------------------

    // ============================== [Methods] ==============================

    // -------------------- [Private Methods] --------------------

    // -------------------- [Public Methods] --------------------

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception
    {
        logger.info("-------------------- [RequestInterceptor.preHandle] --------------------");

        // Simulate an error.
        boolean error = Boolean.valueOf(request.getParameter("error"));

        // Verify, if an error is occurred.
        if (error)
        {
            logger.error("An error occurred.");

            // Create an error instance.
            MyError myError = new MyError();
            myError.setId(UUID.randomUUID().toString());
            myError.setMessage("This is an error.");

            // Convert the POJO to a JSON string.
            String myErrorJson = this.objectMapper.writeValueAsString(myError);

            // Create the response.
            response.setStatus(HttpStatus.BAD_REQUEST.value());
            response.getWriter().write(myErrorJson);

            return false;
        }

        return true;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception
    {
        logger.info("-------------------- [RequestInterceptor.postHandle] --------------------");
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception
    {
        logger.info("-------------------- [RequestInterceptor.afterCompletion] --------------------");
    }
}
