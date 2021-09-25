package academy.pocu.comp2500.assignment1;

import java.util.ArrayList;

public class User {
    private static int id = 0;

    private int userId;
    private String userName;
    private Blog blog;

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
    public Blog getBlog() {
        return blog;
    }

    public boolean createBlog() {
        if (Blog.createBlog(userId)) {
            for (Blog blog : Blog.blogList) {
                if (blog.getArthurId() == userId) {
                    this.blog = blog;
                    return true;
                }
            }
        }
        return false;
    }
    public boolean createArticle(int blogId, String title) {
        if (Blog.isExistSameUserId(blogId)) {
            return Blog.blogList.get(blogId).createArticle(userId, title);
        } else {
            return false;
        }
    }
    public ArrayList<Article> getArticleListOrNull(int arthurId) {
        return Blog.blogList.get(arthurId).getArticleListOrNull();
    }
}
