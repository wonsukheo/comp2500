package academy.pocu.comp2500.assignment1;

import java.util.ArrayList;

public class Blog {
    private static int id = 0;
    static ArrayList<Blog> blogList = new ArrayList<>(); //public or private?
    private int arthurId; //blog owner's userId
    private int blogId;
    private ArrayList<Article> articleList = new ArrayList<>();

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

    public void createArticle(int userId, String title, String text) {
        articleList.add(new Article(blogId, userId, title, text));
    }

    public ArrayList<Article> getSortedArticleListOrNull() {
        return getSortedArticleListOrNull(Sorting.SortingType.CREATED_DESCENDING);
    }

    public ArrayList<Article> getSortedArticleListOrNull(Sorting.SortingType sortingType) {
        if (articleList.size() < 1) {
            System.err.println("This Blog does not have any article");
            return null;
        }
        Sorting.quickSortArticle(articleList, sortingType);
        return articleList;
    }

    public ArrayList<Article> getArticleListTagFilteredOrNull(String tag) {
        ArrayList<String> tagList = new ArrayList<>();
        tagList.add(tag);
        return getArticleListTagListFilteredOrNull(tagList);
    }

    public ArrayList<Article> getArticleListTagListFilteredOrNull(ArrayList<String> tags) {
        ArrayList<Article> filteredList = new ArrayList<>();

        for (Article a : articleList) {
            loopexit:
            for (String tagInArticle : a.getTagListOrNull()) {
                for (String tagInFilter : tags) {
                    if (tagInArticle.equals(tagInFilter)) {
                        filteredList.add(a);
                        break loopexit;
                    }
                }
            }
        }
        if (filteredList.size() < 1) {
            return null;
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

        if (filteredList.size() < 1) {
            return null;
        }
        return filteredList;
    }
}
