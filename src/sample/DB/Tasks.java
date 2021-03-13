package sample.DB;

public class Tasks {
    private String id;
    private String project_name;
    private String task_title;
    private String date;

    public Tasks(String id, String project_name, String task_title, String date) {
        this.id = id;
        this.project_name = project_name;
        this.task_title = task_title;
        this.date = date;
    }
    public Tasks(){

    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getProject_name() {
        return project_name;
    }

    public void setProject_name(String project_name) {
        this.project_name = project_name;
    }

    public String getTask_title() {
        return task_title;
    }

    public void setTask_title(String task_title) {
        this.task_title = task_title;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }
}
