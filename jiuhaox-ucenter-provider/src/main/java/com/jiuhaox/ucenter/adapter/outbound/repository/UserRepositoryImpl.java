package com.jiuhaox.ucenter.adapter.outbound.repository;

import com.jiuhaox.ucenter.adapter.outbound.repository.model.UserPO;
import com.jiuhaox.ucenter.domain.port.repository.UserRepository;
import com.jiuhaox.ucenter.domain.contexts.usercontext.user.model.User;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import org.springframework.util.Assert;

import java.time.LocalDateTime;
import java.util.Collection;
import java.util.List;
import java.util.Optional;

@Repository
@RequiredArgsConstructor
public class UserRepositoryImpl implements UserRepository {
    private final UserPORepository userPORepository;

    @Override
    public User save(final User user) {
        Assert.notNull(user, "Entity must not be null!");

        UserPO po = new UserPO();
        po.setName(user.getName());
        po.setCreatedAt(LocalDateTime.now());
        userPORepository.save(po);

        user.setId(po.getId());
        return user;
    }

    @Override
    public Optional<User> byId(final String id) {
        return userPORepository.findById(id).map(UserPO::toDomain);
    }

    @Override
    public List<User> byIds(final Collection<String> ids) {
        return userPORepository.findAllById(ids).stream().map(UserPO::toDomain).toList();
    }

    @Override
    public long count() {
        return userPORepository.count();
    }

    @Override
    public void delete(final String id) {
        userPORepository.deleteById(id);
    }

    @Override
    public void delete(final Collection<String> ids) {
        userPORepository.deleteAllById(ids);
    }

    @Override
    public void deleteAll() {
        userPORepository.deleteAll();
    }
}
