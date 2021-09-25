package academy.pocu.comp2500.assignment1;

import java.util.ArrayList;

public class test {
    public static void main(String[] args) {
        User user1 = new User("Won");
        User user2 = new User("Nhien");
        User user4 = new User("Xu");

        user1.createBlog();
        user1.getBlog().createArticle(user1.getUserId(), "Won Story");
        int articleId2;
        for (Article a : user1.getBlog().getArticleListOrNull()) {
            if (a.getTitle().equals("Won Story")) {
                articleId2 = a.getArticleId();
                Blog.getBlogWithUserId(user1.getUserId()).getArticle(articleId2).addComment(user2.getUserId(), "I like it");


                for (Comment c : user1.getBlog().getArticle(articleId2).getFullCommentList()) {
                    System.out.println(c.getText());
                }
            }
        }






        /*ArrayList<Article> articles = user1.getBlog().getArticleListOrNull();
        int d = 1;
        for (Article a : articles) {

            System.out.println(String.format(" %s's blog", user1.getUserName()));
            System.out.println(String.format("article%d: %s", d++, a.getTitle()));
        }

        user2.createBlog();
        user2.getBlog().createArticle(user2.getUserId(), "Nhien Story1");
        user2.getBlog().createArticle(user2.getUserId(), "Nhien Story2");
        user2.getBlog().createArticle(user2.getUserId(), "Nhien Story3");
        user2.getBlog().createArticle(user2.getUserId(), "Nhien Story4");
        int articleId1;
        ArrayList<Article> articles2 = user2.getBlog().getArticleListOrNull(qsort.ESortingType.createdDescending);
        for (Article a : articles2) {
            if (a.getTitle().equals("Nhien Story4") || a.getTitle().equals("Nhien Story3")) {
                articleId1 = a.getArticleId();
                user2.getBlog().getArticle(articleId1).addTag(user2.getUserId(), "Nurse");
            }
        }

        ArrayList<Article> articles3 = user2.getBlog().getArticleListTagFiltered("Nurse");

        System.out.println("Filtered with tag \"Nurse\"");
        System.out.println(String.format(" %s's blog", user2.getUserName()));
        int d = 1;
        for (Article a : articles3) {

            System.out.println(String.format("article%d: %s", d++, a.getTitle()));
        }

        Blog blog2 = Blog.getBlogWithUserId(user2.getUserId());
        blog2.createArticle(user1.getUserId(), "Won's article1");
        blog2.createArticle(user1.getUserId(), "Won's article2");

        ArrayList<Article> articles3 = blog2.getArticleListArthurFiltered(user1.getUserId());

        System.out.println("user2's Blog. get articles written by user1");
        d = 1;
        for (Article a : articles3) {

            System.out.println(String.format("article%d: %s", d++, a.getTitle()));
        }

        User user3 = new User("Aegi");
        user3.createBlog();
        user3.getBlog().createArticle(user3.getUserId(), "aaabcd");
        user3.getBlog().createArticle(user3.getUserId(), "aabcd");
        user3.getBlog().createArticle(user3.getUserId(), "abcd");

        Blog blog3 = Blog.getBlogWithUserId(user3.getUserId());

        ArrayList<Article> articles4 = blog3.getArticleListOrNull(qsort.ESortingType.titleDescending);
        for (Article a : articles4) {
            int d = 1;
            System.out.println("user3's Blog. get articles titleDescending");
            System.out.println(String.format("%s", d, a.getTitle()));
        }

        articles4 = blog3.getArticleListOrNull(qsort.ESortingType.createdAscending);
        for (Article a : articles4) {
            int d = 1;
            System.out.println("user3's Blog. get articles created ascending");
            System.out.println(String.format("%s", d, a.getTitle()));
        }*/
    }
}
