package udemy.scrapper;

import udemy.scrapper.api.client.UdemyApiClient;
import udemy.scrapper.api.client.model.Course;
import udemy.scrapper.api.client.model.CourseList;

import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
        try (FileWriter fileWriter = new FileWriter("courses.csv")) {
            System.out.println("UDEMY SCRAPPER v1");
            UdemyApiClient api = new UdemyApiClient();
            CourseList list = api.getCourses(UdemyApiClient.URL);
            List<Course> courses = list.getCourses();
            for (Course course : courses) {
                fileWriter.write(course.toString());
                fileWriter.write(System.lineSeparator());
            }
            if(list.getNext() != null && list.getNext().length() > 0) {
                getNextPages(api, list.getNext(), fileWriter);
            }
        }
    }

    private static void getNextPages(UdemyApiClient api, String next, FileWriter fileWriter) throws IOException {
        CourseList list = api.getCourses(next);
        System.out.println("Called " + next);
        List<Course> courses = list.getCourses();
        for (Course course : courses) {
            fileWriter.write(course.toString());
            fileWriter.write(System.lineSeparator());
        }
        if(list.getNext() != null && list.getNext().length() > 0) {
            getNextPages(api, list.getNext(), fileWriter);
        }
    }
}
