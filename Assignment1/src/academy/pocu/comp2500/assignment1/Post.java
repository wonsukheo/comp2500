package academy.pocu.comp2500.assignment1;

import java.time.OffsetDateTime;
import java.util.ArrayList;
import java.util.Collections;

public class Post {
    public enum Reaction {
        GREAT,
        SAD,
        ANGRY,
        FUN,
        LOVE
    }
    public class Sorting {
        public void sortComment(ArrayList<Comment> comments) {
            sortComment(comments, 0, comments.size() - 1);
        }
        private void sortComment(ArrayList<Comment> commentList, int low, int high) {
            if (low < high + 1) {
                int p = partitionComment(commentList, low, high);
                sortComment(commentList, low, p - 1);
                sortComment(commentList, p + 1, high);
            }
        }
        private int getPivot(int low, int high) {
            return (low + high) / 2;
        }
        private void swapComment(ArrayList<Comment> commentList, int index1, int index2) {
            Collections.swap(commentList, index1, index2);
        }
        private int partitionComment(ArrayList<Comment> commentList, int low, int high) {
            swapComment(commentList, low, getPivot(low, high));
            int border = low + 1;
            for (int i = border; i <= high; i++) {
                if (commentList.get(i).getVote() < commentList.get(low).getVote()) {
                    swapComment(commentList, i, border++);
                }
            }
            swapComment(commentList, low, border - 1);
            return border - 1;
        }
    }
    private int great;
    private int sad;
    private int angry;
    private int fun;
    private int love;
    private OffsetDateTime createdDateTime;
    private OffsetDateTime modifiedDateTime;
    private int blogId;
    //private int postId;
    private int arthurId;
    private String title;
    private String text;
    private ArrayList<String> tagList = new ArrayList<>();
    private ArrayList<Comment> commentList = new ArrayList<>();

    public Post(Blog blog, User author, String title, String text) {
        this.blogId = blog.getBlogId();
        arthurId = author.getUserId();
        //this.postId = postId;
        this.title = title;
        this.text = text;
        createdDateTime = OffsetDateTime.now();
        blog.createPost(this);

    }

    public String getTitle() {
        return title;
    }

    public String getText() {
        return text;
    }

    public boolean setTitle(User user, String title) {
        if (isAuth(user)) {
            this.title = title;
            modifiedDateTime = OffsetDateTime.now();
            return true;
        }
        return false;
    }

    public boolean setText(User user, String text) {
        if (isAuth(user)) {
            this.text = text;
            modifiedDateTime = OffsetDateTime.now();
            return true;
        }
        return false;
    }

    public int getArthurId() {
        return arthurId;
    }

    /*public int getPostId() {
        return postId;
    }*/

    public OffsetDateTime getCreatedOffSetDateTime() {
        return createdDateTime;
    }

    public OffsetDateTime getModifiedOffSetDateTime() {
        return modifiedDateTime;
    }

    public boolean addTag(User user, String tag) {
        if (!isAuth(user)) {
            System.out.println("you are not authorized to add tag");
            return false;
        }

        for (String t : tagList) {
            if (t.equals(tag)) {
                System.out.println("same tag already exist");
                return false;
            }
        }
        tagList.add(tag);
        return true;
    }

    public void addComment(Comment comment) {
        commentList.add(comment);
    }

    public void addReaction(Reaction reaction) {
        switch (reaction) {
            case GREAT:
                great++;
                break;
            case SAD:
                sad++;
                break;
            case ANGRY:
                angry++;
                break;
            case FUN:
                fun++;
                break;
            case LOVE:
                love++;
                break;
            default:
                System.out.println("invalid reactionType");
                break;
        }
    }

    public void removeReaction(Reaction reaction) {
        switch (reaction) {
            case GREAT:
                great--;
                break;
            case SAD:
                sad--;
                break;
            case ANGRY:
                angry--;
                break;
            case FUN:
                fun--;
                break;
            case LOVE:
                love--;
                break;
            default:
                System.out.println("invalid reactionType");
                break;
        }
    }

    public ArrayList<String> getTagList() {
        return tagList;
    }

    public ArrayList<Comment> getFullCommentList() {
        ArrayList<Comment> result = new ArrayList<>();

        for (Comment c : commentList) {
            result.add(c);

            for (Comment subc : c.getSubcommentList()) {
                result.add(subc);
            }
        }
        return result;
    }

    public ArrayList<Comment> getCommentListSortByVote() {
        Sorting sorting = new Sorting();
        ArrayList<Comment> commentList = getFullCommentList();
        sorting.sortComment(commentList);
        return commentList;
    }

    private boolean isAuth(User user) {
        if (arthurId == user.getUserId()) {
            return true;
        } else {
            System.err.println("you are not authorized");
            return false;
        }
    }

    /*private boolean isExist(Blog blog, User user, int postId) {
        ArrayList<Post> posts = blog.getPostListArthurFiltered(user);

        for (Post p : posts) {
            if (p.getPostId() == postId) {
                return true;
            }
        }
        return false;
    }*/
}
