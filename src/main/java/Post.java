import java.util.ArrayList;

public class Post {
    private String content;
    private static ArrayList<Post> instances = new ArrayList<>();
    private boolean published;
    public Post(String content){
        this.content = content;
        this.published = false;
        instances.add(this);
    }
}
