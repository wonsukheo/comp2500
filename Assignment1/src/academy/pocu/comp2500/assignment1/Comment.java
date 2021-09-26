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

    public boolean upVote(User user) {
        if (!this.user.isSame(user)) {
            upvote++;
            return true;
        }
        return false;
    }

    public boolean downVote(User user) {
        if (!this.user.isSame(user)) {
            downvote++;
            return true;
        }
        return false;
    }

    public int getVote() {
        int result = upvote - downvote;
        return result;
    }

    public void addSubComment(Comment comment) {
        subCommentList.add(comment);
    }

    public ArrayList<Comment> getSubcomments() {
        ArrayList<Comment> subcomments = new ArrayList<>();

        for (Comment c : subCommentList) {
            subcomments.add(c);
        }

        return subcomments;
    }


    public ArrayList<Comment> getSubcommentsRecursive(ArrayList<Comment> comments) {
        if (this.subCommentList.size() < 1) {
            return comments;
        }
        for (Comment c : this.getSubcomments()) {
            c.getSubcommentsRecursive(comments);
        }
        return comments;
    }

    private boolean isAuth(User user) {
        if (this.user.getUserId() == user.getUserId()) {
            return true;
        } else {
            System.err.println("you are not authorized");
            return false;
        }
    }
}
