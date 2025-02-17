package com.java.example.best_of_the_year.controllers;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
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
        List<String> movieTitles = getBestMovies().stream().map(Movie::getTitle).collect(Collectors.toList());
        model.addAttribute("movies", String.join(", ", movieTitles));
        return "movies";
    }

    @GetMapping("/songs")
    public String songs(Model model) {
        List<String> songsTitles = getBestSongs().stream().map(Song::getTitle).collect(Collectors.toList());
        model.addAttribute("songs", String.join(", ", songsTitles));
        return "songs";
    }

    private List<Movie> getBestMovies() {
        return Arrays.asList(
                new Movie(1, "Jurassic Park"),
                new Movie(2, "Spider Man"),
                new Movie(3, "The Dark Knight"));
    }

    private List<Song> getBestSongs() {
        return Arrays.asList(
                new Song(1, "Skyfall"),
                new Song(2, "I Wanna Be Yours"),
                new Song(3, "Just Breathe"));
    }

}
