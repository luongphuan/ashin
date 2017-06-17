package com.ashin.controller;

/**
 * Created by anluo on 6/3/2017.
 */

import com.ashin.DAO.*;
import com.ashin.model.*;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class Service {
    NotifDAO nd = new NotifDAO();
    ScoreDAO sd = new ScoreDAO();
    ParentDAO pd = new ParentDAO();
    StudentDAO std = new StudentDAO();
    TeacherDAO td = new TeacherDAO();
    @RequestMapping(value = "notifs/{id}",method = RequestMethod.GET,headers ="Accept=application/json")
    public Notification loadNotifById(@PathVariable int id) {
        return nd.view(id);
}
    @RequestMapping(value = "post",method = RequestMethod.POST)
    public void postNo(@RequestBody Notification input){
        nd.insert(input);
        System.out.println("succeed");
    }
    @RequestMapping(value = "put/{id}",method = RequestMethod.PUT)
    public void updateNo(@PathVariable int id,@RequestBody Notification newnotif){
        nd.update(id, newnotif);
        System.out.println("succeed");
    }
    @RequestMapping(value = "users/{idscore}&{idsemester}",method = RequestMethod.GET,headers ="Accept=application/json")
    public ScoreBoard showScore(@PathVariable int idscore,@PathVariable int idsemester) {
        return sd.showScore(idscore,idsemester);
    }
    @RequestMapping(value = "parents/{idparent}",method = RequestMethod.GET,headers ="Accept=application/json")
    public Parent showParentInfor(@PathVariable int idparent) {
        return pd.showInformationParent(idparent);
    }
    @RequestMapping(value = "students/{idstudent}",method = RequestMethod.GET,headers ="Accept=application/json")
    public Student showStudentInfor(@PathVariable int idstudent) {
        return std.showInformationStudent(idstudent);
    }
    @RequestMapping(value = "teachers/{idteacher}",method = RequestMethod.GET,headers ="Accept=application/json")
    public Teacher showTeacherInfor(@PathVariable int idteacher) {
        return td.showInformationTeacher(idteacher);
    }
    @RequestMapping(value = "notifsloadbypage/{page}",method = RequestMethod.GET,headers ="Accept=application/json")
    public List<Notification> loadNotifByPage(@PathVariable int page) {
        return nd.loadNotifPerPage(page);
    }
}
