package com.java.example.best_of_the_year.controllers;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.java.example.best_of_the_year.models.Movie;
import com.java.example.best_of_the_year.models.Song;

@Controller
@RequestMapping("/")
public class HomeController {

    @GetMapping("")
    public String home(Model model) {
        model.addAttribute("name", "Lucrezia");
        return "home";
    }

    @GetMapping("/movies")
    public String movies(Model model) {
        List<Movie> movieList = getBestMovies();
        model.addAttribute("movies", movieList);
        return "movies";
    }

    @GetMapping("/songs")
    public String songs(Model model) {
        List<Song> songsList = getBestSongs();
        model.addAttribute("songs", songsList);
        return "songs";
    }

    @GetMapping("/movies/{id}")
    public String movieDetail(@PathVariable int id, Model model) {
        Movie movie = getBestMovies().stream().filter(m -> m.getId() == id).findFirst().orElse(null);
        model.addAttribute("movie", movie);
        return "movie-detail";
    }

    @GetMapping("/songs/{id}")
    public String songDetail(@PathVariable int id, Model model) {
        Song song = getBestSongs().stream().filter(m -> m.getId() == id).findFirst().orElse(null);
        model.addAttribute("song", song);
        return "song-detail";
    }

    private List<Movie> getBestMovies() {
        return List.of(
                new Movie(1, "Jurassic Park"),
                new Movie(2, "Spider Man"),
                new Movie(3, "The Dark Knight"),
                new Movie(4, "Pulp Fiction"));
    }

    private List<Song> getBestSongs() {
        return List.of(
                new Song(1, "Skyfall"),
                new Song(2, "I Wanna Be Yours"),
                new Song(3, "Just Breathe"),
                new Song(4, "Back to Black"));
    }

}
