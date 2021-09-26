package academy.pocu.comp2500.assignment1;

import java.time.OffsetDateTime;
import java.util.ArrayList;
import java.util.Collections;

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
    private User user;
    private String title;
    private String text;
    private ArrayList<String> tagList = new ArrayList<>();
    private ArrayList<Comment> commentList = new ArrayList<>();

    public Post(User user, String title, String text) {
        this.user = user;
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

    public User getUser() {
        return user;
    }

    public OffsetDateTime getCreatedOffSetDateTime() {
        return createdDateTime;
    }

    public OffsetDateTime getModifiedOffSetDateTime() {
        return modifiedDateTime;
    }

    public boolean addTag(User user, String tag) {
        /*if (!isAuth(user)) {
            System.out.println("you are not authorized to add tag");
            return false;
        }*/

        for (String t : tagList) {
            if (t.equals(tag)) {
                System.out.println("same tag already exist");
                return false;
            }
        }
        tagList.add(tag);
        return true;
    }

    public ArrayList<String> getTagList() {
        ArrayList<String> result = new ArrayList<>();
        result = (ArrayList<String>) tagList.clone();
        
        return result;
    }

    public void addComment(Comment comment) {
        commentList.add(comment);
    }

    public int getReaction(Reaction reaction) {
        switch (reaction) {
            case GREAT:
                return great;
            case SAD:
                return sad;
            case ANGRY:
                return angry;
            case FUN:
                return fun;
            case LOVE:
                return love;
            default:
                return 0;
        }
    }
    public void setReaction(Reaction reaction) {
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



    public ArrayList<Comment> getCommentList()  {
        ArrayList<Comment> comments = new ArrayList<>();

        for (Comment c : this.commentList) {
            c.getSubcommentsRecursive(comments);
        }

        return comments;
    }

    public ArrayList<Comment> getCommentListSortByVote() {
        ArrayList<Comment> temp = commentList;
        sortComment(temp);
        return temp;
    }

    private boolean isAuth(User user) {
        if (this.user.getUserId() == user.getUserId()) {
            return true;
        } else {
            System.err.println("you are not authorized");
            return false;
        }
    }
    private void sortComment(ArrayList<Comment> comments) {
        sortComment(comments, 0, comments.size() - 1);
    }
    private void sortComment(ArrayList<Comment> commentList, int low, int high) {
        if (low < high + 1) {
            int p = partitionComment(commentList, low, high);
            sortComment(commentList, low, p - 1);
            sortComment(commentList, p + 1, high);
        }
    }
    private void swapComment(ArrayList<Comment> commentList, int index1, int index2) {
        Collections.swap(commentList, index1, index2);
    }
    private int getPivot(int low, int high) {
        return (low + high) / 2;
    }
    private int partitionComment(ArrayList<Comment> commentList, int low, int high) {
        swapComment(commentList, low, getPivot(low, high));
        int border = low + 1;
        for (int i = border; i <= high; i++) {
            if (commentList.get(i).getVote() < commentList.get(low).getVote()) {
                swapComment(commentList, i, border++);
            }
        }
        swapComment(commentList, low, border - 1);
        return border - 1;
    }
}
