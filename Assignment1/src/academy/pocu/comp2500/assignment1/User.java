package academy.pocu.comp2500.assignment1;

import java.util.ArrayList;

public class User {
    private static int id = 0;
    private int userId;
    private String userName;
    private ArrayList<Blog> blogList = new ArrayList<>();

    public User(String name) {
        userId = id++;
        userName = name;
    }

    public int getUserId() {
        return userId;
    }

    public String getUserName() {
        return userName;
    }

    public void createBlog() {
        Blog.blogList.add(new Blog(userId));

        for (Blog blog : Blog.blogList) {
            loop_exit:
            if (blog.getArthurId() == userId) {
                for (Blog myBlog : this.blogList) {
                    if (blog.getBlogId() == myBlog.getBlogId()) {
                        break loop_exit;
                    }
                }
                this.blogList.add(blog);
            }
        }
    }

    public ArrayList<Blog> getBlogListOrNull() {
        if (blogList.size() < 1) {
            return null;
        }
        return blogList;
    }

    public void testTest() {

    };
}
