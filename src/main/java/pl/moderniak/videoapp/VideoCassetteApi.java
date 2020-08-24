package pl.moderniak.videoapp;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/cassetts/")
public class VideoCassetteApi {

    private List<VideoCassette> videoCassettes;

    public VideoCassetteApi() {
        videoCassettes = new ArrayList<>();
        videoCassettes.add(new VideoCassette(1L, "Star Wars VI - Return of Jedi", LocalDate.of(1983, 5, 25)));
        videoCassettes.add(new VideoCassette(2L, "Seven Pounds", LocalDate.of(2009, 3, 13)));
    }

    @GetMapping("/all")
    public List<VideoCassette> getAll() {
        return videoCassettes;
    }

    @GetMapping
    public VideoCassette getById(@RequestParam int index) {
        Optional<VideoCassette> first = videoCassettes.stream()
                .filter(e -> e.getId() == index)
                .findFirst();
        return first.get();
    }
}
