package com.example.lingfeng.dopeaf1;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.IgnoreExtraProperties;

import java.sql.Time;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Queue;
import java.util.Stack;
import java.util.StringTokenizer;
import java.util.UUID;

@IgnoreExtraProperties
public class User {
    private String userID;
    private String username;
    private String email;
    //private int numTasks;
    //private String password;
   // private String createDate;
    //private String lastlogin;
   // private String UCSDEmail;
    //private String UCSDPassword;
    public List<String> enrolledCourses;
    public List<String> finishedTask;
    public List<String> inProgressTask;

    public User() {
        // Default constructor required for calls to DataSnapshot.getValue(User.class)
    }

    User(String username, String email, String userID ) {
        this.userID = userID;
        //TODO: Do we really need USERNAME? Personally, I think we'd better not to have it
        this.username = username;
        this.email = email;
        enrolledCourses = new ArrayList<String>();
        finishedTask = new ArrayList<>();
        inProgressTask = new ArrayList<String>();
    }


    public void addCourse(String courseID){
        if(enrolledCourses==null)
            enrolledCourses =new ArrayList<String>();
        enrolledCourses.add(courseID);
    }

    public boolean dropCourse(String courseID){
        if(enrolledCourses==null)
            return false;
        if(enrolledCourses.contains(courseID))
            enrolledCourses.remove(enrolledCourses.indexOf(courseID));
        else
            return false;
        return true;
    }

    public void addTask(String task){
        if( inProgressTask == null){
            inProgressTask = new ArrayList<String>();
        }

        if (!inProgressTask.contains(task)) {
            inProgressTask.add(task);
        }
    }

    public void finishTask(String task){
        if( inProgressTask == null) return;

        if( inProgressTask.contains(task)){
            inProgressTask.remove(task);

            if( finishedTask == null){
                finishedTask = new ArrayList<>();
            }
            finishedTask.add(0, task);
        }
    }

    public void deleteTask(String task) {
        if (finishedTask == null&&inProgressTask==null) return;

        if (finishedTask!=null&&finishedTask.contains(task)) {
            finishedTask.remove(task);
        }
        if(inProgressTask!=null&&inProgressTask.contains(task)){
            inProgressTask.remove(task);
        }
    }

    public void resumeTask(String task) {
        if (finishedTask == null) return;

        if (finishedTask.contains(task)) {
            finishedTask.remove(task);

            if (inProgressTask == null) {
                inProgressTask = new ArrayList<>();
            }
            inProgressTask.add(task);
        }
    }


    public String getUserID() {
        return userID;
    }

    public void setUserID(String userID) {
        this.userID = userID;
    }

    public String getUserEmail() {
        return email;
    }

    public void setUserEmail(String email) {
        this.email = email;
    }


    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public List<String> getEnrolledCourses() {
        if(this.enrolledCourses == null){
            this.enrolledCourses = new ArrayList<String>();
        }
        return this.enrolledCourses; }

    public List<String> getCurrentClassTask(String classnName) {

        List<String> courseTask = new ArrayList<>();

        //Do a search in the in progress tasks, locate all the task according
        // to the name of the task.




        //return the generated string list.
        return courseTask;
    }

}
