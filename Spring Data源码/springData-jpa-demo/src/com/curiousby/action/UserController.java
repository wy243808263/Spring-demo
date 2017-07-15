package com.curiousby.action;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap; 
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping; 
import org.springframework.web.bind.annotation.RequestMethod;

import com.curiousby.entity.User;
import com.curiousby.service.UserService;
 

@Controller
public class UserController {

      @Autowired
      UserService service;

      @RequestMapping(value = "/userView.do")
      public String userView(ModelMap modelMap,String pageNo, String choice, HttpSession session){
            List<User> userList = service.allUser();
           modelMap.put("userList", userList);
           return "back/jsp/user/userView";
     }
 

      @RequestMapping(value = "/userDel{userId}.do")
      public String userDel(@PathVariable("userId")int userId ,ModelMap modelMap,String pageNo, String choice, HttpSession session){
             service.delUser(userId);
             String message1="删除成功";
             String message2="请返回……";
             String  url="userView.do";
             modelMap.put("message1", message1);
             modelMap.put("message2", message2);
             modelMap.put("url", url);
            return "infomationShow";
      }

      @RequestMapping(value ="/userGoAdd.do")
             public String userGoAdd(ModelMap modelMap,String pageNo, String choice, HttpSession session){
             return "back/jsp/user/userAdd";
      }

      @RequestMapping(value = "/userAdd.do",method=RequestMethod.POST)
      public String userAdd(User form,ModelMap modelMap,String pageNo, String choice, HttpSession session){
             service.addUser(form);
             String message1="添加成功";
             String message2="请返回……";
             String  url="userView.do";
             modelMap.put("message1", message1);
             modelMap.put("message2", message2);
            modelMap.put("url", url);
             return "infomationShow";
      }

      @RequestMapping(value = "/userGoUpdate{userId}.do")
      public String userGoUpdate(@PathVariable("userId")int userId ,ModelMap modelMap,String pageNo, String choice, HttpSession session){
            User user = service.user(userId);
           modelMap.put("user", user);
           return "back/jsp/user/userUpdate";
      }

      @RequestMapping(value = "/userUpdate.do",method=RequestMethod.POST)
      public String userUpdate(User form,ModelMap modelMap,String pageNo, String choice, HttpSession session){
             service.updateUser(form);
             String message1="修改成功";
             String message2="请返回……";
             String  url="userView.do";
             modelMap.put("message1", message1);
             modelMap.put("message2", message2);
             modelMap.put("url", url);
             return "infomationShow";
      }
      
}
