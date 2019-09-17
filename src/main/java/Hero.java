import java.time.LocalDateTime;
import java.util.ArrayList;

public class Hero {
    private String name;
    private int age;
    private String power;
    private String weakness;
    private static ArrayList<Hero> instances = new ArrayList<>();
    private boolean published;
    private LocalDateTime createdAt;
    private int id;
    public Hero(String name, int age, String power, String weakness){
        this.name = name;
        this.age = age;
        this.power = power;
        this.weakness = weakness;
        this.published = false;
        this.createdAt = LocalDateTime.now();
        instances.add(this);
        this.id = instances.size();
    }
    public String getName(){
        return name;
    }
    public int getAge(){
        return age;
    }
    public String getPower(){
        return power;
    }
    public String getWeakness(){
        return weakness;
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
    public void update(String newName, int newAge, String newPower, String newWeakness){
        this.name = newName;
        this.age = newAge;
        this.power = newPower;
        this.weakness = newWeakness;
    }
    public void deleteHero(){
        instances.remove(id-1);
    }
}
