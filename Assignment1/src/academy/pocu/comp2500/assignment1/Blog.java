package academy.pocu.comp2500.assignment1;

import java.util.ArrayList;
import java.util.Collections;

public class Blog {
    public enum SortingType {
        CREATED_ASCENDING,
        CREATED_DESCENDING,
        MODIFIED_ASCENDING,
        MODIFIED_DESCENDING,
        TITLE_DESCENDING
    }
    private int blogId;
    private ArrayList<Post> postList = new ArrayList<>();

    public Blog(User user, int blogId) {
        if (!isExist(user, blogId)) {
            this.blogId = blogId;
            user.createBlog(this);
        }
    }

    public int getBlogId() {
        return blogId;
    }

    public void addPost(Post post) {
        postList.add(post);
    }

    public ArrayList<Post> getPostList() {
        return getPostListSorted(SortingType.CREATED_DESCENDING);
    }

    public ArrayList<Post> getPostListSorted(SortingType sortingType) {
        sortArticle(postList, sortingType);
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
            if (a.getUser() == user) {
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

    private void sortArticle(ArrayList<Post> posts, SortingType sortingType) {
        sortArticle(posts, 0, posts.size() - 1, sortingType);
    }
    private void sortArticle(ArrayList<Post> postList, int low, int high, SortingType sortingType) {
        if (low < high + 1) {
            int p = partitionArticle(postList, low, high, sortingType);
            sortArticle(postList, low, p - 1, sortingType);
            sortArticle(postList, p + 1, high, sortingType);
        }
    }
    private void swapArticle(ArrayList<Post> postList, int index1, int index2) {
        Collections.swap(postList, index1, index2);
    }
    private int getPivot(int low, int high) {
        return (low + high) / 2;
    }
    private int partitionArticle(ArrayList<Post> postList, int low, int high, SortingType sortingType) {
        swapArticle(postList, low, getPivot(low, high));
        int border = low + 1;

        switch (sortingType) {
            case CREATED_ASCENDING:
                for (int i = border; i <= high; i++) {
                    if (postList.get(i).getCreatedOffSetDateTime().isBefore(postList.get(low).getCreatedOffSetDateTime())) {
                        swapArticle(postList, i, border++);
                    }
                }
                break;
            case CREATED_DESCENDING:
                for (int i = border; i <= high; i++) {
                    if (postList.get(i).getCreatedOffSetDateTime().isAfter(postList.get(low).getCreatedOffSetDateTime())) {
                        swapArticle(postList, i, border++);
                    }
                }
                break;
            case MODIFIED_ASCENDING:
                for (int i = border; i <= high; i++) {
                    if (postList.get(i).getModifiedOffSetDateTime().isBefore(postList.get(low).getCreatedOffSetDateTime())) {
                        swapArticle(postList, i, border++);
                    }
                }
                break;
            case MODIFIED_DESCENDING:
                for (int i = border; i <= high; i++) {
                    if (postList.get(i).getModifiedOffSetDateTime().isAfter(postList.get(low).getCreatedOffSetDateTime())) {
                        swapArticle(postList, i, border++);
                    }
                }
                break;
            case TITLE_DESCENDING:
                for (int i = border; i <= high; i++) {
                    char[] c1 = postList.get(i).getTitle().toCharArray();
                    char[] c2 = postList.get(low).getTitle().toCharArray();

                    for (int j = 0; j < Math.min(c1.length, c2.length); j++) {
                        if (c1[j] - c2[j] == 0) {
                            continue;
                        } else if (c1[j] - c2[j] < 0) {
                            swapArticle(postList, i, border++);
                            break;
                        }
                    }
                }
                break;
            default:
                System.out.println("invalid sorting Type");
                break;
        }

        swapArticle(postList, low, border - 1);
        return border - 1;
    }
}
