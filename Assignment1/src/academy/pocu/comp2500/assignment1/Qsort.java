package academy.pocu.comp2500.assignment1;

import java.util.ArrayList;
import java.util.Collections;

public class Qsort {
    static enum ESortingType {
        CREATED_ASCENDING,
        CREATED_DESCENDING,
        MODIFIED_ASCENDING,
        MODIFIED_DESCENDING,
        TITLE_DESCENDING
    }
    public static void quickSortComment(ArrayList<Comment> commentList) {
        quickSortComment(commentList, 0, commentList.size() - 1);
    }
    public static void quickSortArticle(ArrayList<Article> articleList, Qsort.ESortingType sortingType) {
        quickSortArticle(articleList, 0, articleList.size() - 1, sortingType);
    }

    private static void quickSortComment(ArrayList<Comment> commentList, int low, int high) {
        if (low < high + 1) {
            int p = partitionComment(commentList, low, high);
            quickSortComment(commentList, low, p - 1);
            quickSortComment(commentList, p + 1, high);
        }
    }
    private static void quickSortArticle(ArrayList<Article> articleList, int low, int high, Qsort.ESortingType sortingType) {
        if (low < high + 1) {
            int p = partitionArticle(articleList, low, high, sortingType);
            quickSortArticle(articleList, low, p - 1, sortingType);
            quickSortArticle(articleList, p + 1, high, sortingType);
        }
    }

    private static void swapComment(ArrayList<Comment> commentList, int index1, int index2) {
        Collections.swap(commentList, index1, index2);
    }
    private static void swapArticle(ArrayList<Article> articleList, int index1, int index2) {
        Collections.swap(articleList, index1, index2);
    }

    private static int getPivot(int low, int high) {
        return (low + high) / 2;
    }

    private static int partitionComment(ArrayList<Comment> commentList, int low, int high) {
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
    private static int partitionArticle(ArrayList<Article> articleList, int low, int high, Qsort.ESortingType sortingType) {
        swapArticle(articleList, low, getPivot(low, high));
        int border = low + 1;

        switch (sortingType) {
            case CREATED_ASCENDING:
                for (int i = border; i <= high; i++) {
                    if (articleList.get(i).getCreatedOffSetDateTime().isBefore(articleList.get(low).getCreatedOffSetDateTime())) {
                        swapArticle(articleList, i, border++);
                    }
                }
                break;
            case CREATED_DESCENDING:
                for (int i = border; i <= high; i++) {
                    if (articleList.get(i).getCreatedOffSetDateTime().isAfter(articleList.get(low).getCreatedOffSetDateTime())) {
                        swapArticle(articleList, i, border++);
                    }
                }
                break;
            case MODIFIED_ASCENDING:
                for (int i = border; i <= high; i++) {
                    if (articleList.get(i).getModifiedOffSetDateTime().isBefore(articleList.get(low).getCreatedOffSetDateTime())) {
                        swapArticle(articleList, i, border++);
                    }
                }
                break;
            case MODIFIED_DESCENDING:
                for (int i = border; i <= high; i++) {
                    if (articleList.get(i).getModifiedOffSetDateTime().isAfter(articleList.get(low).getCreatedOffSetDateTime())) {
                        swapArticle(articleList, i, border++);
                    }
                }
                break;
            case TITLE_DESCENDING:
                for (int i = border; i <= high; i++) {
                    char[] c1 = articleList.get(i).getTitle().toCharArray();
                    char[] c2 = articleList.get(low).getTitle().toCharArray();

                    for (int j = 0; j < Math.min(c1.length, c2.length); j++) {
                        if (c1[j] - c2[j] == 0) {
                            continue;
                        } else if (c1[j] - c2[j] < 0) {
                            swapArticle(articleList, i, border++);
                            break;
                        }
                    }
                }
                break;
            default:
                System.out.println("invalid sorting Type");
                break;
        }

        swapArticle(articleList, low, border - 1);
        return border - 1;
    }
}
