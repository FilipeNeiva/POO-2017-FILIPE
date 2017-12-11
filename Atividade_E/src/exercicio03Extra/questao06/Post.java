package exercicio03Extra.questao06;

public class Post {
    int countLikes;
    Post(int initialLikes) {
        countLikes = initialLikes;
    }
    void addLike(){
        countLikes += 1;
    }
}