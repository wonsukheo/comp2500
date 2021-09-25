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
    public ArrayList<Blog> getBlogList() {
        return blogList;
    }

    public void createBlog() {
        Blog.createBlog(userId);


        for (Blog blog : Blog.blogList) {
            loop_exit:
            if (blog.getArthurId() == userId) {
                for (Blog myBlog : this.blogList) {
                    if (blog.getBlogId() == myBlog.getBlogId()) {
                        break loop_exit;
                    }
                }
                blogList.add(blog);
            }
        }
    }
    public boolean createArticleWithBlogId(int blogId, String title) {
        return Blog.blogList.get(blogId).createArticle(userId, title);
    }
    public ArrayList<Article> getArticleListOrNull(int arthurId) {
        return Blog.blogList.get(arthurId).getArticleListOrNull();
    }
}
