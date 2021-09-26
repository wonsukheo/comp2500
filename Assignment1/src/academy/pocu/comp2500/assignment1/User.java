package academy.pocu.comp2500.assignment1;

import java.util.ArrayList;

public class User {
    private int userId;
    private String userName;
    private ArrayList<Blog> blogList = new ArrayList<>();

    public User(String userName, int userId) {
        this.userName = userName;
        this.userId = userId;
    }

    public int getUserId() {
        return userId;
    }

    public String getUserName() {
        return userName;
    }

    public void createBlog(Blog blog) {
        blogList.add(blog);
    }

    public ArrayList<Blog> getBlogList() {
        return blogList;
    }
}
