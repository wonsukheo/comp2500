package academy.pocu.comp2500.assignment1;

import java.util.ArrayList;

public class Blog {
    private int userId;
    private int blogId;
    private ArrayList<Post> postList = new ArrayList<>();

    public Blog(User user, int blogId) {
        if (!isExist(user, blogId)) {
            userId = user.getUserId();
            this.blogId = blogId;
            user.createBlog(this);
        }
    }

    public int getUserId() {
        return userId;
    }
    public int getBlogId() {
        return blogId;
    }

    public void addPost(Post post) {
        postList.add(post);
    }

    public ArrayList<Post> getPostsSorted() {
        return getPostsSorted(Sorting.SortingType.CREATED_DESCENDING);
    }

    public ArrayList<Post> getPostsSorted(Sorting.SortingType sortingType) {
        Sorting sorting = new Sorting();
        sorting.sortArticle(postList, sortingType);
        return postList;
    }

    public ArrayList<Post> getPostsFilteredTags(String tag) {
        ArrayList<String> tagList = new ArrayList<>();
        tagList.add(tag);
        return getPostsFilteredTags(tagList);
    }

    public ArrayList<Post> getPostsFilteredTags(ArrayList<String> tags) {
        ArrayList<Post> filteredList = new ArrayList<>();

        for (Post a : postList) {
            loopexit:
            for (String tagInArticle : a.getTagList()) {
                for (String tagInFilter : tags) {
                    if (tagInArticle.equals(tagInFilter)) {
                        filteredList.add(a);
                        break loopexit;
                    }
                }
            }
        }

        return filteredList;
    }

    public ArrayList<Post> getPostsFilteredUser(User user) {
        ArrayList<Post> filteredList = new ArrayList<>();

        for (Post a : postList) {
            if (a.getUserId() == user.getUserId()) {
                filteredList.add(a);
            }
        }

        return filteredList;
    }

    private boolean isExist(User author, int blogId) {
        ArrayList<Blog> b = author.getBlogList();

        for (Blog blog : b) {
            if (blog.getBlogId() == blogId) {
                return true;
            }
        }
        return false;
    }
}
