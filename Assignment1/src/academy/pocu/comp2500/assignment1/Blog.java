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
    private User userFilter;
    private ArrayList<String> tagFilter = new ArrayList<>();
    private boolean tagFilterOn = false;
    private boolean userFilterOn = false;
    private boolean sortFilterOn = false;

    private int blogId;
    private ArrayList<Post> postList = new ArrayList<>();

    public Blog(User user, int blogId) {
        if (!isExist(user, blogId)) {
            this.blogId = blogId;
            userFilter = user;
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
        ArrayList<Post> filteredList = new ArrayList<>();

        if (userFilterOn) {
            for (Post a : postList) {
                if (a.getUser().equals(userFilter)) {
                    filteredList.add(a);
                }
            }
        }
        if (tagFilterOn) {
            for (Post post : postList) {
                loop_exit:
                for (String tagPosted : post.getTags()) {
                    for (String tagFiltered : tagFilter) {
                        if (tagPosted.equals(tagFiltered)) {
                            if (!filteredList.contains(post)) {
                                filteredList.add(post);
                            }
                            break loop_exit;
                        }
                    }
                }
            }
        }

        if (userFilterOn == false && tagFilterOn == false) {
            for (Post p : postList) {
                filteredList.add(p);
            }
        }
        if (!sortFilterOn) {
            sortArticle(filteredList, SortingType.CREATED_DESCENDING);
        }
        return filteredList;
    }

    public void setSortFilter(SortingType sortingType) {
        sortArticle(postList, sortingType);
        sortFilterOn = true;
    }

    public void setTagFilter(String tag) {
        ArrayList<String> tagList = new ArrayList<>();
        tagList.add(tag);
        setTagsFilter(tagList);
    }

    public void setTagsFilter(ArrayList<String> tags) {
        tagFilter.clear();
        for (String tag : tags) {
            tagFilter.add(tag);
        }

        if (tagFilterOn) {
            tagFilterOn = false;
        } else {
            tagFilterOn = true;
        }
    }

    public void setUserFilter(User user) {
        userFilter = user;

        if (userFilterOn) {
            userFilterOn = false;
        } else {
            userFilterOn = true;
        }
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
