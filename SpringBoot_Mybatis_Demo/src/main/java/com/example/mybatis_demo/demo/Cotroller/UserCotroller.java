package com.example.mybatis_demo.demo.Cotroller;
import com.example.mybatis_demo.demo.model.Data;
import com.example.mybatis_demo.demo.model.User;
import com.example.mybatis_demo.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
class UserController {
        @Autowired
        private UserService userService;

        @RequestMapping("/hello")
        @ResponseBody
        public String index() {
            return"Hello World";
        }

        //通过id查询身份
        @RequestMapping(value = "/get")
        @ResponseBody
        public int get(int id) {
            User user=  new User();
            user.setId(id);
            return userService.getidentifyById(id);
        }

        //通过sex查询全部信息
    @RequestMapping(value = "/gets/{user}",method = RequestMethod.DELETE)
    @ResponseBody
    public List<User> gets(@PathVariable("user")String sex) {
        User user = new User();
        user.setSex(sex);
       List<User> u=userService.getBySex(sex);
        return u;
    }

    //输入id和newname，修改名字
    @RequestMapping(value = "/update")
    @ResponseBody
    public Boolean update(int id,String newname) {
        User user= new User();
        user.setId(id);
        user.setName(newname);
        userService.UpdateName(id,newname);
        boolean u = userService.UpdateName(id,newname);
        return u;
    }

    //增加  id,name,sex,stuid
    @RequestMapping(value = "/add")
    @ResponseBody
    public Boolean add(int id,String name,String sex, String stuid) {
        User user= new User();
        user.setId(id);
        user.setName(name);
        user.setSex(sex);
        user.setStuid(stuid);
        boolean u = userService.add(id,name,sex,stuid);
        return u;
    }

    //删
    @RequestMapping(value = "/del")
    @ResponseBody
    public Boolean del(int id) {
        User user= new User();
        user.setId(id);
        boolean u = userService.del(id);
        return u;
    }

    //查
    @RequestMapping(value = "/select")
    @ResponseBody
    public String select(int id,int user_id) {
        User user = new User();
        Data data = new Data();
        user.setId(id);
        data.setUser_id(user_id);
        if (userService.getidentifyById(id) == 2){ //2为管理员
            return userService.select(id, user_id);}
        else if (userService.getidentifyById(id) == 1) { //1为普通用户
            if (id==user_id) {
                return userService.select(id, user_id);
            } else
                return "无权限";
        }
            return "无意义id";
    }
    }