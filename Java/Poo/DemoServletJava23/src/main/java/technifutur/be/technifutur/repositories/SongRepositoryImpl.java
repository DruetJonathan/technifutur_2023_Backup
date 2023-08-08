package technifutur.be.technifutur.repositories;

import technifutur.be.technifutur.models.entities.Song;
import technifutur.be.technifutur.models.entities.User;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

public class SongRepositoryImpl extends BaseRepositoryImpl<Song> implements SongRepository {
    public SongRepositoryImpl() {
        super("SONG", "SONG_ID");
    }
    @Override
    protected Song buildEntity(ResultSet rs) {
        try {
            return Song.builder()
                    .id(rs.getInt("SONG_ID"))
                    .libele(rs.getString("LIBELE"))
                    .emplacement_link(rs.getString("EMPLACEMENT_LINK"))
                    .build();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public Song add(Song song, Connection conn) {
        return null;
    }

    @Override
    public Song add(Song song) {
        return null;
    }

    @Override
    public boolean update(Integer id, Song song) {
        return false;
    }
}
