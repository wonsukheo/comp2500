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
    private int blogId;
    private int postId;
    private int arthurId;
    private String title;
    private String text;
    private ArrayList<String> tagList = new ArrayList<>();
    private ArrayList<Comment> commentList = new ArrayList<>();

    public Post(int blogId, int userId, int postId, String title, String text) {
        this.blogId = blogId;
        arthurId = userId;
        this.postId = postId;
        this.title = title;
        this.text = text;
        createdDateTime = OffsetDateTime.now();
        modifiedDateTime = createdDateTime;
    }

    public String getTitle() {
        return title;
    }

    public String getText() {
        return text;
    }

    public boolean setTitle(int userId, String title) {
        if (isAuth(userId)) {
            this.title = title;
            modifiedDateTime = OffsetDateTime.now();
            return true;
        }
        return false;
    }

    public boolean setText(int userId, String text) {
        if (isAuth(userId)) {
            this.text = text;
            modifiedDateTime = OffsetDateTime.now();
            return true;
        }
        return false;
    }

    public int getArthurId() {
        return arthurId;
    }

    public int getPostId() {
        return postId;
    }

    public OffsetDateTime getCreatedOffSetDateTime() {
        return createdDateTime;
    }

    public OffsetDateTime getModifiedOffSetDateTime() {
        return modifiedDateTime;
    }

    public boolean addTag(int userId, String tag) {
        if (!isAuth(userId)) {
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

    public void addComment(int userId, int commentId, String text) {
        commentList.add(new Comment(userId, commentId, text));
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

    public ArrayList<String> getTagListOrNull() {
        if (tagList.size() < 1) {
            return null;
        }
        return tagList;
    }

    public ArrayList<Comment> getFullCommentListOrNull() {
        ArrayList<Comment> result = new ArrayList<>();

        for (Comment c : commentList) {
            result.add(c);

            for (Comment subc : c.getSubcommentListOrNull()) {
                result.add(subc);
            }
        }
        if (result.size() < 1) {
            return null;
        }
        return result;
    }

    public ArrayList<Comment> getCommentListSortByVoteOrNull() {
        Sorting sorting = new Sorting();
        ArrayList<Comment> commentList = getFullCommentListOrNull();
        sorting.sortComment(commentList);
        return commentList;
    }

    private boolean isAuth(int userId) {
        if (arthurId == userId) {
            return true;
        } else {
            System.err.println("you are not authorized");
            return false;
        }
    }
}
