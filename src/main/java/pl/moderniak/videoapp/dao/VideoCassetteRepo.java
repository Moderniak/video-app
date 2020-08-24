package pl.moderniak.videoapp.dao;


import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import pl.moderniak.videoapp.dao.entity.VideoCassette;

@Repository
public interface VideoCassetteRepo extends CrudRepository<VideoCassette, Long> {
}
