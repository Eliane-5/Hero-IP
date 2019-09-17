import java.time.LocalDateTime;
import java.util.ArrayList;

public class Squad {
        private String squadName;
        private int maxSize;
        private String cause;
        private static ArrayList<Squad> instances = new ArrayList<Squad>();
        private boolean published;
        private LocalDateTime createdAt;
        private int id;
        public Squad(String squadName, int maxSize, String cause){
            this.squadName = squadName;
            this.maxSize = maxSize;
            this.cause = cause;
            this.published = false;
            this.createdAt = LocalDateTime.now();
            instances.add(this);
            this.id = instances.size();
        }
        public String getSquadName(){
            return squadName;
        }
        public int getMaxSize(){
            return maxSize;
        }
        public String getCause(){
            return cause;
        }
        public static ArrayList<Squad> getAll(){
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
        public static Squad findById(int id){
            return instances.get(id-1);
        }
        public void update(String newSquadName, int newMaxSize, String newCause){
            this.squadName = newSquadName;
            this.maxSize = newMaxSize;
            this.cause = newCause;
        }
        public void deleteSquad(){
            instances.remove(id-1);
        }
    }

