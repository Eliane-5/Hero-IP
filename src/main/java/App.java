import spark.ModelAndView;
import spark.template.handlebars.HandlebarsTemplateEngine;

import java.util.ArrayList;
import static spark.Spark.*;
import java.util.HashMap;
import java.util.Map;

public class App {
    public static void main(String[] args){
        staticFileLocation("/public");
        get("/", (req,res)->{
            Map<String, Object> model = new HashMap<>();
            ArrayList<Post> posts = Post.getAll();
            model.put("posts", posts);
            return new ModelAndView(model, "index.hbs");
        },new HandlebarsTemplateEngine());
    }
}
