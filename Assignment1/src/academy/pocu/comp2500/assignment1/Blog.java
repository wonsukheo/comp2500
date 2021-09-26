package academy.pocu.comp2500.assignment1;

import java.util.ArrayList;

public class Blog {
    private int arthurId; //blog owner's userId
    private int blogId;
    private ArrayList<Post> postList = new ArrayList<>();

    public Blog(User author, int blogId) {
        if (!isExist(author, blogId)) {
            arthurId = author.getUserId();
            this.blogId = blogId;
            author.createBlog(this);
        }
    }

    public int getArthurId() {
        return arthurId;
    }
    public int getBlogId() {
        return blogId;
    }

    public void createPost(Post post) {
        postList.add(post);  //가정: 블로그 주인만 글을 작성 가능
    }

    public ArrayList<Post> getSortedPostList() {
        return getSortedPostList(Sorting.SortingType.CREATED_DESCENDING);
    }

    public ArrayList<Post> getSortedPostList(Sorting.SortingType sortingType) {
        Sorting sorting = new Sorting();
        sorting.sortArticle(postList, sortingType);
        return postList;
    }

    public ArrayList<Post> getPostListTagFiltered(String tag) {
        ArrayList<String> tagList = new ArrayList<>();
        tagList.add(tag);
        return getPostListTagListFiltered(tagList);
    }

    public ArrayList<Post> getPostListTagListFiltered(ArrayList<String> tags) {
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

    public ArrayList<Post> getPostListArthurFiltered(int userId) {
        ArrayList<Post> filteredList = new ArrayList<>();

        for (Post a : postList) {
            if (a.getArthurId() == userId) {
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
