import java.time.LocalDateTime;
import java.util.ArrayList;

public class Hero {
    private String name;
    private static ArrayList<Hero> instances = new ArrayList<>();
    private boolean published;
    private LocalDateTime createdAt;
    private int id;
    public Hero(String name){
        this.name = name;
        this.published = false;
        this.createdAt = LocalDateTime.now();
        instances.add(this);
        this.id = instances.size();
    }
    public String getName(){
        return name;
    }
    public static ArrayList<Hero> getAll(){
        return instances;
    }
    public static void clearAllHeroes(){
        instances.clear();
    }
    public boolean getPublished(){
        return this.published;
    }
    public LocalDateTime getCreatedAt(){
        return createdAt;
    }
    public int getId(){
        return id;
    }
    public static Hero findById(int id){
        return instances.get(id-1);
    }
    public void update(String content){
        this.name = content;
    }
    public void deleteHero(){
        instances.remove(id-1);
    }
}
