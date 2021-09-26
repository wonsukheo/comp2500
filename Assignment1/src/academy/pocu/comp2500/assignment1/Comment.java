package academy.pocu.comp2500.assignment1;

import java.util.ArrayList;
import java.util.Collections;

public class Comment {
    private int userId;
    private String text;
    private int upvote;
    private int downvote;
    private ArrayList<Comment> subCommentList = new ArrayList<>();

    public Comment(User user, String text) {
        this.userId = user.getUserId();
        this.text = text;
    }

    public String getText() {
        return text;
    }

    public boolean setText(User user, String text) {
        if (isAuth(user)) {
            this.text = text;
            return true;
        }
        return false;
    }

    public void upVote() {
        upvote++;
    }

    public void downVote() {
        downvote++;
    }

    public void subCommentUpVote(Comment comment) {
        comment.upVote();
    }
    public void subCommentDownVote(Comment comment) {
        comment.downVote();
    }
    public void subCommentSetText(Comment comment, User user, String text) {
        comment.setText(user, text);
    }

    public int getVote() {
        return upvote - downvote;
    }

    private void addSubComment(Comment comment) {
        subCommentList.add(comment);
    }

    public ArrayList<Comment> getSubcomments() {
        return subCommentList;
    }

    private boolean isAuth(User user) {
        if (userId == user.getUserId()) {
            return true;
        } else {
            System.err.println("you are not authorized");
            return false;
        }
    }


}
