package technifutur.be.technifutur.services;

import technifutur.be.technifutur.models.entities.Product;
import technifutur.be.technifutur.models.entities.Song;
import technifutur.be.technifutur.repositories.SongRepository;
import technifutur.be.technifutur.repositories.SongRepositoryImpl;

import java.util.List;

public class SongServiceImpl {
    SongRepository songRepository;

    public SongServiceImpl() {
        songRepository = new SongRepositoryImpl();
    }
    public List<Song> getMany() {
        return songRepository.getMany();
    }
}
