package academy.pocu.comp2500.assignment1;

import java.util.ArrayList;

public class Comment {
    private int userId;
    private String text;
    private int upvote = 0;
    private int downvote = 0;
    private ArrayList<Comment> subCommentList = new ArrayList<>();

    public Comment(Post post, User user, String text) {
        this.userId = user.getUserId();
        this.text = text;
        post.addComment(this);
    }
    /*public Comment(Comment comment, User user, String text) {
        this.userId = user.getUserId();
        this.text = text;
        comment.addSubComment(this);
    }*/

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
