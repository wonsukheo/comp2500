package academy.pocu.comp2500.assignment1;

import java.util.ArrayList;

public class Comment {
    private static int id = 0;

    private int userId;
    private int commentId;
    private String text;
    private byte upvote = 0;
    private byte downvote = 0;
    private ArrayList<Comment> subCommentList = new ArrayList<>();

    public Comment (int userId, String text) {
        this.userId = userId;
        this.text = text;
        commentId = id++;
    }

    public String getText() {
        return text;
    }
    public void setComment(String text) {
        this.text = text;
    }
    public int getCommentId() { return commentId; }
    public ArrayList<Comment> getSubcommentList() {
        return subCommentList;
    }

    public void upVote(int userId) {
        upvote++;
    }
    public void downVote(int userId) {
        downvote++;
    }
    public int getVote() {
        return upvote - downvote;
    }
    public void addSubComment(int userId, String text) {
        subCommentList.add(new Comment(userId, text));
    }
}
