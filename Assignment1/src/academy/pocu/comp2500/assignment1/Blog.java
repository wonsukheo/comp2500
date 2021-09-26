package academy.pocu.comp2500.assignment1;

import java.util.ArrayList;

public class Blog {
    private int arthurId; //blog owner's userId
    private int blogId;
    private ArrayList<Post> postList = new ArrayList<>();

    public Blog(int userId, int blogId) {
        arthurId = userId;
        this.blogId = blogId;
    }

    public int getArthurId() {
        return arthurId;
    }
    public int getBlogId() {
        return blogId;
    }

    public void createPost(int postId, String title, String text) {
        postList.add(new Post(postId, blogId, arthurId, title, text));  //가정: 블로그 주인만 글을 작성 가능
    }

    public ArrayList<Post> getSortedPostListOrNull() {
        return getSortedPostListOrNull(Sorting.SortingType.CREATED_DESCENDING);
    }

    public ArrayList<Post> getSortedPostListOrNull(Sorting.SortingType sortingType) {
        Sorting sorting = new Sorting();
        if (postList.size() < 1) {
            System.err.println("This Blog does not have any article");
            return null;
        }
        sorting.sortArticle(postList, sortingType);
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
