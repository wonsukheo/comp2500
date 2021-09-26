package academy.pocu.comp2500.assignment1;

import java.util.ArrayList;

public class Comment {
    private User user;
    private String text;
    private int upvote;
    private int downvote;
    private ArrayList<Comment> subCommentList = new ArrayList<>();

    public Comment(User user, String text) {
        this.user = user;
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

    public User getUser() {
        return user;
    }

    public void upVote(User user) {
        if (!isAuth(user)) {
            upvote++;
        }
    }

    public void downVote(User user) {
        if (!isAuth(user)) {
            downvote++;
        }
    }

    public void subCommentUpVote(Comment comment, User user) {
        comment.upVote(user);
    }
    public void subCommentDownVote(Comment comment, User user) {
        comment.downVote(user);
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
        if (this.user == user) {
            return true;
        } else {
            System.err.println("you are not authorized");
            return false;
        }
    }
}
