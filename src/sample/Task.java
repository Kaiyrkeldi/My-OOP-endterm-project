package sample;

import java.io.Serializable;
import java.time.DateTimeException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;


public class Task implements Serializable {
    private String title;
    private String project;
    private String dueDate;



    public Task(String title, String project, String dueDate) {
        this.setTitle(title);
        this.setProject(project);
        this.setDueDate(dueDate);
    }


    public String getTitle() {
        return this.title;
    }


    public void setTitle(String title) throws NullPointerException {
        this.title = title.trim();
    }


    public String getProject() {
        return this.project;
    }

    public void setProject(String project) {
        this.project = project.trim();
    }

    public String getDueDate() {
        return dueDate;
    }

    public void setDueDate(String dueDate) throws DateTimeException {
        this.dueDate = dueDate.trim();
    }
}
