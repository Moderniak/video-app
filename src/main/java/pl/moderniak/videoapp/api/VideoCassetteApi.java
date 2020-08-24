package pl.moderniak.videoapp.api;

import org.springframework.web.bind.annotation.*;
import pl.moderniak.videoapp.dao.entity.VideoCassette;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/cassetts")
public class VideoCassetteApi {

    private List<VideoCassette> videoCassettes;

    public VideoCassetteApi() {
        videoCassettes = new ArrayList<>();
        videoCassettes.add(new VideoCassette(1L, "Star Wars VI - Return of Jedi", LocalDate.of(1983, 5, 25)));
        videoCassettes.add(new VideoCassette(2L, "Seven Pounds", LocalDate.of(2009, 3, 13)));
        videoCassettes.add(new VideoCassette(3L, "Pulp Fiction", LocalDate.of(1111, 1, 1)));
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

    @PostMapping
    public boolean addVideo(@RequestBody VideoCassette videoCassette) {
        return videoCassettes.add(videoCassette);
    }

    @PutMapping
    public boolean updateVideo(@RequestBody VideoCassette videoCassette) {
        return videoCassettes.add(videoCassette);
    }

    @DeleteMapping
    public boolean deleteVideo(@RequestParam int index) {
        return videoCassettes.removeIf(e -> e.getId() == index);
    }
}
