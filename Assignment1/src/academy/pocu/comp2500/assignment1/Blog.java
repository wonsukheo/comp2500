package academy.pocu.comp2500.assignment1;

import java.util.ArrayList;

public class Blog {
    private static int id = 0;
    static ArrayList<Blog> blogList = new ArrayList<>(); //public or private?
    private int arthurId; //blog owner's userId
    private int blogId;
    private ArrayList<Post> postList = new ArrayList<>();

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

    public void createPost(int userId, String title, String text) {
        postList.add(new Post(blogId, userId, title, text));
    }

    public ArrayList<Post> getSortedPostListOrNull() {
        return getSortedPostListOrNull(Sorting.SortingType.CREATED_DESCENDING);
    }

    public ArrayList<Post> getSortedPostListOrNull(Sorting.SortingType sortingType) {
        if (postList.size() < 1) {
            System.err.println("This Blog does not have any article");
            return null;
        }
        Sorting.quickSortArticle(postList, sortingType);
        return postList;
    }

    public ArrayList<Post> getPostListTagFilteredOrNull(String tag) {
        ArrayList<String> tagList = new ArrayList<>();
        tagList.add(tag);
        return getPostListTagListFilteredOrNull(tagList);
    }

    public ArrayList<Post> getPostListTagListFilteredOrNull(ArrayList<String> tags) {
        ArrayList<Post> filteredList = new ArrayList<>();

        for (Post a : postList) {
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

    public ArrayList<Post> getPostListArthurFiltered(int userId) {
        ArrayList<Post> filteredList = new ArrayList<>();

        for (Post a : postList) {
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
