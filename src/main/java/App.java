import spark.ModelAndView;
import spark.template.handlebars.HandlebarsTemplateEngine;

import java.util.ArrayList;
import static spark.Spark.*;
import java.util.HashMap;
import java.util.Map;

public class App {
    public static void main(String[] args){
        staticFileLocation("/public");
        //get: show new Hero form
        get("/heroes/new", (req,res)->{
            Map<String, Object> model = new HashMap<>();
            return new ModelAndView(model, "post-form.hbs");
        }, new HandlebarsTemplateEngine());
        //post: process new Hero form
        post("/heroes/new", (request, response) -> { //URL to make new hero on POST route
            Map<String, Object> model = new HashMap<>();
            String name = request.queryParams("name");
            int age = Integer.parseInt(request.queryParams("age"));
            String power = request.queryParams("power");
            String weakness = request.queryParams("weakness");
            Hero newHero = new Hero(name,age,power,weakness);
            model.put("hero", newHero);
            return new ModelAndView(model, "success.hbs");
        }, new HandlebarsTemplateEngine());

        //get: show all Heroes
        get("/", (req, res) -> {
            Map<String, Object> model = new HashMap<>();
            ArrayList<Hero> heroes = Hero.getAll();
            model.put("heroes", heroes);

            return new ModelAndView(model, "index.hbs");
        }, new HandlebarsTemplateEngine());

        //get: show an individual Hero
        get("/heroes/:id", (req, res) -> {
            Map<String, Object> model = new HashMap<>();
            int idOfPostToFind = Integer.parseInt(req.params(":id")); //pull id - must match route segment
            Hero foundHero = Hero.findById(idOfPostToFind); //use it to find post
            model.put("hero", foundHero); //add it to model for template to display
            return new ModelAndView(model, "post-detail.hbs"); //individual post page.
        }, new HandlebarsTemplateEngine());
        //get: show a form to update a Hero
        get("/heroes/:id/update", (req, res) -> {
            Map<String, Object> model = new HashMap<>();
            int idOfHeroToEdit = Integer.parseInt(req.params("id"));
            Hero editHero = Hero.findById(idOfHeroToEdit);
            model.put("editHero", editHero);
            return new ModelAndView(model, "post-form.hbs");
        }, new HandlebarsTemplateEngine());
        //post: process a form to update a Hero
        post("/heroes/:id/update", (req, res) -> {
            Map<String, Object> model = new HashMap<>();
            String newName = req.queryParams("name");
            int newAge = Integer.parseInt(req.queryParams("age"));
            String newPower = req.queryParams("power");
            String newWeakness = req.queryParams("weakness");
            int idOfHeroToEdit = Integer.parseInt(req.params("id"));
            Hero editHero = Hero.findById(idOfHeroToEdit);
            editHero.update(newName,newAge,newPower,newWeakness); //don’t forget me
            return new ModelAndView(model, "success.hbs");
        }, new HandlebarsTemplateEngine());
        //get: delete an individual Hero
        get("/heroes/:id/delete", (req, res) -> {
            Map<String, Object> model = new HashMap<>();
            int idOfHeroToDelete = Integer.parseInt(req.params("id")); //pull id - must match route segment
            Hero deleteHero = Hero.findById(idOfHeroToDelete); //use it to find post
            deleteHero.deleteHero();
            return new ModelAndView(model, "success.hbs");
        }, new HandlebarsTemplateEngine());

//        Squad details in app



        //get: show new Hero form
        get("/squads/new", (req,res)->{
            Map<String, Object> model = new HashMap<>();
            return new ModelAndView(model, "squad-form.hbs");
        }, new HandlebarsTemplateEngine());
        //post: process new Hero form
        post("/squads/new", (request, response) -> { //URL to make new hero on POST route
            Map<String, Object> model = new HashMap<>();
            String squadName = request.queryParams("squadName");
            int maxSize = Integer.parseInt(request.queryParams("maxSize"));
            String cause = request.queryParams("cause");
            Squad newSquad = new Squad(squadName,maxSize,cause);
            model.put("squad", newSquad);
            return new ModelAndView(model, "successSquad.hbs");
        }, new HandlebarsTemplateEngine());

        //get: show all Heroes
        get("/list", (req, res) -> {
            Map<String, Object> model = new HashMap<>();
            ArrayList<Squad> squads = Squad.getAll();
            model.put("squads", squads);

            return new ModelAndView(model, "index2.hbs");
        }, new HandlebarsTemplateEngine());

        //get: show an individual Hero
        get("/squads/:id", (req, res) -> {
            Map<String, Object> model = new HashMap<>();
            int idOfSquadToFind = Integer.parseInt(req.params(":id")); //pull id - must match route segment
            Squad foundSquad = Squad.findById(idOfSquadToFind); //use it to find post
            model.put("squad", foundSquad); //add it to model for template to display
            return new ModelAndView(model, "squad-detail.hbs"); //individual post page.
        }, new HandlebarsTemplateEngine());
        //get: show a form to update a Hero
        get("/squads/:id/update", (req, res) -> {
            Map<String, Object> model = new HashMap<>();
            int idOfSquadToEdit = Integer.parseInt(req.params("id"));
            Squad editSquad = Squad.findById(idOfSquadToEdit);
            model.put("editSquad", editSquad);
            return new ModelAndView(model, "squad-form.hbs");
        }, new HandlebarsTemplateEngine());
        //post: process a form to update a Hero
        post("/squads/:id/update", (req, res) -> {
            Map<String, Object> model = new HashMap<>();
            String newSquadName = req.queryParams("squadName");
            int newMaxSize = Integer.parseInt(req.queryParams("maxSize"));
            String newCause = req.queryParams("cause");
            int idOfSquadToEdit = Integer.parseInt(req.params("id"));
            Squad editSquad= Squad.findById(idOfSquadToEdit);
            editSquad.update(newSquadName,newMaxSize,newCause); //don’t forget me
            return new ModelAndView(model, "successSquad.hbs");
        }, new HandlebarsTemplateEngine());
        //get: delete an individual Hero
        get("/squads/:id/delete", (req, res) -> {
            Map<String, Object> model = new HashMap<>();
            int idOfSquadToDelete = Integer.parseInt(req.params("id")); //pull id - must match route segment
            Squad deleteSquad = Squad.findById(idOfSquadToDelete); //use it to find post
            deleteSquad.deleteSquad();
            return new ModelAndView(model, "successSquad.hbs");
        }, new HandlebarsTemplateEngine());
    }
}
