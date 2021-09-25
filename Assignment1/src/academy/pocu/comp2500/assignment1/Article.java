package academy.pocu.comp2500.assignment1;

import java.time.OffsetDateTime;
import java.util.ArrayList;

public class Article {
    private static int id = 0;
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
    private OffsetDateTime modifiedDateTime = createdDateTime;
    private int articleId;
    private int arthurId;
    private String title;
    private String text;
    private ArrayList<String> tagList = new ArrayList<>();
    private ArrayList<Comment> commentList = new ArrayList<>();

    public Article(int userId, String title) {
        arthurId = userId;
        articleId = id++;
        this.title = title;
        createdDateTime = OffsetDateTime.now();
    }

    public String getTitle() {
        return title;
    }
    public void setTitle(int userId, String title) {
        isAuth(userId);
        this.title = title;
        modifiedDateTime = OffsetDateTime.now();
    }
    public void setText(int userId, String text) {
        isAuth(userId);
        this.text = text;
        modifiedDateTime = OffsetDateTime.now();
    }
    public int getArthurId() {
        return arthurId;
    }
    public int getArticleId() {
        return articleId;
    }
    public void setReaction(Reaction reaction, boolean type) {
        switch (reaction) {
            case GREAT:
                if (type) {
                    great++;
                } else {
                    great--;
                }
                break;
            case SAD:
                if (type) {
                    sad++;
                } else {
                    sad--;
                }
                break;
            case ANGRY:
                if (type) {
                    angry++;
                } else {
                    angry--;
                }
                break;
            case FUN:
                if (type) {
                    fun++;
                } else {
                    fun--;
                }
                break;
            case LOVE:
                if (type) {
                    love++;
                } else {
                    love--;
                }
                break;
            default:
                System.out.println("invalid reactionType");
                break;
        }
    }
    public ArrayList<String> getTagList() {
        return tagList;
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
    public void addComment(int userId, String text) {
        commentList.add(new Comment(userId, text));
    }
    public Comment getCommentWithCommentId(int commentId) {
        ArrayList<Comment> fullCommentList = getFullCommentList();

        for (Comment c : fullCommentList) {
            if (c.getCommentId() == commentId) {
                return c;
            }
        }

        return null;
    }
    public ArrayList<Comment> getCommentList() {
        return commentList;
    }
    public ArrayList<Comment> getFullCommentList() {
        ArrayList<Comment> commentList = new ArrayList<>();

        for (Comment c : commentList) {
            commentList.add(c);

            for (Comment subc : c.getSubcommentList()) {
                commentList.add(subc);
            }
        }
        Qsort.quickSortComment(commentList);

        return commentList;
    }
    public ArrayList<Comment> getCommentListSortByVote() {
        Qsort.quickSortComment(commentList);

        return commentList;
    }
    public boolean isAuth(int userId) {
        if (arthurId == userId) {
            return true;
        } else {
            System.err.println("you are not authorized");
            return false;
        }
    }
}
