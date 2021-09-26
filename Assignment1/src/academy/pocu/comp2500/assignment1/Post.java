package academy.pocu.comp2500.assignment1;

import java.time.OffsetDateTime;
import java.util.ArrayList;

public class Post {
    public enum Reaction {
        GREAT,
        SAD,
        ANGRY,
        FUN,
        LOVE
    }
    private int great;
    private int sad;
    private int angry;
    private int fun;
    private int love;
    private OffsetDateTime createdDateTime;
    private OffsetDateTime modifiedDateTime;
    private int userId;
    private String title;
    private String text;
    private ArrayList<String> tagList = new ArrayList<>();
    private ArrayList<Comment> commentList = new ArrayList<>();

    public Post(Blog blog, User user, String title, String text) {
        userId = user.getUserId();
        this.title = title;
        this.text = text;
        createdDateTime = OffsetDateTime.now();
        blog.addPost(this);
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

    public int getUserId() {
        return userId;
    }

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

            for (Comment subc : c.getSubcomments()) {
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
        if (userId == user.getUserId()) {
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
