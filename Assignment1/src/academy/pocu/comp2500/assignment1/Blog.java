package academy.pocu.comp2500.assignment1;

import java.util.ArrayList;

public class Blog {
    private static int id = 0;
    static ArrayList<Blog> blogList = new ArrayList<>();   //public or private?

    private int arthurId;
    private int blogId;
    private ArrayList<Article> articleList = new ArrayList<>(); // articleId = articleList index

    public Blog(int userId) {
        arthurId = userId;
        blogId = id++;
    }

    public int getArthurId() {
        return arthurId;
    }
    public int getBlogId() {
        return blogId;
    }

    static void createBlog(int userId) {
            Blog.blogList.add(new Blog(userId));
    }
    /*static boolean isExistSameUserId(int userId) {
        for (Blog blog : Blog.blogList) {
            if (blog.getArthurId() == userId) {
                return true;
            }
        }
        System.err.println("Blog with userId doesn't exist");
        return false;
    }*/
    static Blog getBlogWithUserId(int userId) {
        return blogList.get(userId);
    }

    public boolean createArticle(int userId, String title) {
        articleList.add(new Article(userId, title));
        return true;
    }
    public Article getArticle(int articleId) {
        for (Article a : articleList) {
            if (a.getArticleId() == articleId) {
                return a;
            }
        }
        return null;
    }
    public ArrayList<Article> getArticleListOrNull() {
        return getArticleListOrNull(Qsort.ESortingType.CREATED_DESCENDING);
    }
    public ArrayList<Article> getArticleListOrNull(Qsort.ESortingType sortingType) {
        if (articleList.size() < 1) {
            System.err.println("This Blog does not have any article");
            return null;
        }
        Qsort.quickSortArticle(articleList, sortingType);
        return articleList;
    }
    public ArrayList<Article> getArticleListTagFiltered(String tag) {
        ArrayList<Article> filteredList = new ArrayList<>();

        for (Article a : articleList) {
            for (String t : a.getTagList()) {
                if (t.equals(tag)) {
                    filteredList.add(a);
                    break;
                }
            }
        }
        return filteredList;
    }
    public ArrayList<Article> getArticleListArthurFiltered(int userId) {
        ArrayList<Article> filteredList = new ArrayList<>();

        for (Article a : articleList) {
            if (a.getArthurId() == userId) {
                filteredList.add(a);
            }
        }
        return filteredList;
    }
}
