package com.jiuhaox.ucenter.adapter.outbound.repository;

import com.jiuhaox.ucenter.adapter.outbound.repository.converter.UserConverter;
import com.jiuhaox.ucenter.adapter.outbound.repository.model.UserPO;
import com.jiuhaox.ucenter.domain.aggregates.user.model.User;
import com.jiuhaox.ucenter.domain.port.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.time.Instant;
import java.util.Collection;
import java.util.List;
import java.util.Optional;

@Repository
@RequiredArgsConstructor
public class UserRepositoryImpl implements UserRepository {
    private final UserPORepository userPORepository;

    @Override
    public User save(final User user) {
        Instant now = Instant.now();
        final UserPO userPO = UserConverter.INSTANCE.toPersistenceObject(user);
        //TODO 自动填充
        userPO.setCreatedAt(now).setCreatedBy("1").setUpdatedAt(now).setUpdatedBy("1");
        return userPORepository.save(userPO).toAggregate();
    }

    @Override
    public Optional<User> byId(final String id) {
        return userPORepository.findById(id).map(UserPO::toAggregate);
    }

    @Override
    public List<User> byIds(final Collection<String> ids) {
        return userPORepository.findAllById(ids).stream().map(UserPO::toAggregate).toList();
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
