package udemy.scrapper.api.client.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@JsonIgnoreProperties(ignoreUnknown = true)
public class CourseList {
    int count;
    String next;
    String previous;
    List<Map<String, Object>> results;

    public int getCount() {
        return count;
    }
    public void setCount(int count) {
        this.count = count;
    }

    public String getNext() {
        return next;
    }
    public void setNext(String next) {
        this.next = next;
    }

    public String getPrevious() {
        return previous;
    }
    public void setPrevious(String previous) {
        this.previous = previous;
    }

    public List<Map<String, Object>> getResults() {
        return results;
    }
    public void setResults(List<Map<String, Object>> results) {
        this.results = results;
    }

    public List<Course> getCourses() {
        List<Course> result = new ArrayList<Course>(results.size());
        for(Map map : results) {
            result.add(new Course(Integer.parseInt(map.get("id").toString()), String.valueOf(map.get("title")), String.valueOf(map.get("url")), String.valueOf(map.get("price"))));
        }
        return result;
    }
}
