package com.jiuhaox.ucenter.adapter.outbound.repository;

import com.jiuhaox.ucenter.adapter.outbound.repository.converter.UserDomainConverter;
import com.jiuhaox.ucenter.adapter.outbound.repository.model.UserPO;
import com.jiuhaox.ucenter.domain.aggregates.user.model.User;
import com.jiuhaox.ucenter.domain.port.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.List;
import java.util.Optional;

@Repository
@RequiredArgsConstructor
public class UserRepositoryImpl implements UserRepository {
    private final UserPORepository userPORepository;

    @Override
    public User save(final User user) {
        final UserPO userPO = UserDomainConverter.INSTANCE.toPersistenceObject(user);
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
