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

    static boolean createBlog(int userId) {
        if (isExist(userId)) {
            System.out.println("blog with same userId already exist");
            return false;
        } else {
            blogList.add(new Blog(userId));
            return true;
        }
        /*blogList.add(new Blog(userId));
        return true;*/
    }
    static boolean isExist(int blogId) {
        for (Blog blog : blogList) {
            if (blog.arthurId == blogId) {
                return true;
            }
        }
        System.err.println("Blog with userId doesn't exist");
        return false;
    }
    static Blog getBlogWithUserId(int userId) {
        return blogList.get(userId);
    }

    public boolean createArticle(int userId, String title) {
        /*for (Article article : articleList) {
            if (article.getTitle().equals(title)) {
                System.out.println("article with same title already exist");
                return false;
            }
        }*/
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
    public ArrayList<Article> getArticleListArthurFiltered(int arthurId) {
        ArrayList<Article> filteredList = new ArrayList<>();

        for (Article a : articleList) {
            if (a.getArthurId() == arthurId) {
                filteredList.add(a);
            }
        }
        return filteredList;
    }
}
