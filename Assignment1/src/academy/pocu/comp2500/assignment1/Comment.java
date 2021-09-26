package academy.pocu.comp2500.assignment1;

import java.util.ArrayList;

public class Comment {
    private int arthurId;
    private String text;
    private int upvote = 0;
    private int downvote = 0;
    private ArrayList<Comment> subCommentList = new ArrayList<>();

    public Comment(Post post, User user, String text) {
        this.arthurId = user.getUserId();
        this.text = text;
        post.addComment(this);
    }
    public Comment(Comment comment, User user, String text) {
        this.arthurId = user.getUserId();
        this.text = text;
        comment.addSubComment(this);
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

    public int getVote() {
        return upvote - downvote;
    }

    private void addSubComment(Comment comment) {
        subCommentList.add(comment);
    }

    public ArrayList<Comment> getSubcommentList() {
        return subCommentList;
    }

    private boolean isAuth(User user) {
        if (arthurId == user.getUserId()) {
            return true;
        } else {
            System.err.println("you are not authorized");
            return false;
        }
    }
}
