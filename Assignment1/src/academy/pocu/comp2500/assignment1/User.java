package academy.pocu.comp2500.assignment1;

import java.util.ArrayList;

public class User {
    private int userId;
    private String userName;
    private ArrayList<Blog> blogList = new ArrayList<>();

    public User(String Username, int userId) {
        this.userName = userName;
        this.userId = userId;
    }

    public int getUserId() {
        return userId;
    }

    public String getUserName() {
        return userName;
    }

    public void createBlog(int blogId) {
        blogList.add(new Blog(userId, blogId));
    }

    public ArrayList<Blog> getBlogListOrNull() {
        if (blogList.size() < 1) {
            return null;
        }
        return blogList;
    }
}
