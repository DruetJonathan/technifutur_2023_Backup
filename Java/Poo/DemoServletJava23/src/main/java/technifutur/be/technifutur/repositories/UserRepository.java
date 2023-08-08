package technifutur.be.technifutur.repositories;

import technifutur.be.technifutur.models.entities.User;

public interface UserRepository extends BaseRepository<User> {

    User findByLogin(String login);
}
