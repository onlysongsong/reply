package com.yupi.autoreply.controller;

import com.yupi.autoreply.api.openai.OpenAiApi;
import com.yupi.autoreply.api.openai.model.CreateCompletionResponse;
import com.yupi.autoreply.factory.AnswererFactory;
import com.yupi.autoreply.model.TaskListItem;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;


/**
 * 开放接口
 *
 * @author <a href="https://github.com/liyupi">程序员鱼皮</a>
 * @from <a href="https://yupi.icu">编程导航知识星球</a>
 */
@RestController
@RequestMapping("/")
@Slf4j
public class MainController {

    @GetMapping("/answer")
    public String answer(HttpServletRequest request,String message,String usercode) {
        /*if(usercode == null){
            return "用户未登录";
        }*/
        String result = null;
        try {
            //result = AnswererFactory.createAnswerer("openai").doAnswer(message);
            if(result != null){
                return result;
            } else {
                return "我不理解您的问题";
            }
        } catch (Exception e) {
            e.printStackTrace();
            return "请求超时，服务器出现问题";
        }
    }
}
