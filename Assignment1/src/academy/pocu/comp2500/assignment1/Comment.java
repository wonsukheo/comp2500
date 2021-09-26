package academy.pocu.comp2500.assignment1;

import java.util.ArrayList;

public class Comment {
    private static int id = 0;

    private int arthurId;
    private int commentId;
    private String text;
    private int upvote = 0;
    private int downvote = 0;
    private ArrayList<Comment> subCommentList = new ArrayList<>();

    public Comment(int userId, String text) {
        this.arthurId = userId;
        this.text = text;
        commentId = id++;
    }

    public String getText() {
        return text;
    }

    public boolean setText(int userId, String text) {
        if (isAuth(userId)) {
            this.text = text;
            return true;
        }
        return false;
    }

    public int getCommentId() {
        return commentId;
    }

    public void upVote() {
        upvote++;
    }

    public void downVote() {
        downvote++;
    }

    public int getVote() {
        return upvote - downvote;
    }

    public void addSubComment(int userId, String text) {
        subCommentList.add(new Comment(userId, text));
    }

    public ArrayList<Comment> getSubcommentListOrNull() {
        if (subCommentList.size() < 1) {
            return null;
        }
        return subCommentList;
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
