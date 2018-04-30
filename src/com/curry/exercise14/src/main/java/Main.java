/**
 * Created by 114512 on 4/24/2018.
 */
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Array;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

// a class reprenting a task in a to do list
class Task {
    private String body;
    private String done;
    private String id;
    private String priority;
    private String title;

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public String isDone() {
        return done;
    }

    public void setDone(String done) {
        this.done = done;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getPriority() {
        return priority;
    }

    public void setPriority(String priority) {
        this.priority = priority;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String toString() {
        String information = String.join(", ", body, done, id, priority);
        return String.format("The information for the task %s is as follows; %s", title, information);
    }
}

class ToDoList extends ArrayList<Task> {}


public class Main {
    public static void main(String[] args) {
        String jsonData = "[{\"body\": \"Walk the dog\", \"done\": \"false\", \"id\": \"0\", \"priority\": \"3\", \"title\": \"dog\"},"
                + "{\"body\": \"Pay the bills\", \"done\": \"false\", \"id\": \"1\", \"priority\": \"1\", \"title\": \"bills\"}]";

        Gson gson = new Gson();

        ToDoList tasks = gson.fromJson(jsonData, ToDoList.class);

        for (Task task: tasks) {
            System.out.println(task);
        }

        // create a string with JSON data
        System.out.println(gson.toJson(tasks));
    }
}
