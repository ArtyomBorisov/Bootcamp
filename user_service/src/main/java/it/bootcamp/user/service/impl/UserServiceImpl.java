package it.bootcamp.user.service.impl;

import it.bootcamp.user.dao.UserRepository;
import it.bootcamp.user.dao.entity.UserEntity;
import it.bootcamp.user.dto.UserRequestDto;
import it.bootcamp.user.dto.UserResponseDto;
import it.bootcamp.user.exception.ConversionException;
import it.bootcamp.user.service.UserService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.convert.ConversionService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional(readOnly = true)
public class UserServiceImpl implements UserService {

    private final UserRepository repository;
    private final ConversionService conversionService;
    private final int pageSize;
    private final Logger logger = LogManager.getLogger(UserServiceImpl.class);

    public UserServiceImpl(UserRepository repository,
                           ConversionService conversionService,
                           @Value("${pageable.size}") int pageSize) {
        this.repository = repository;
        this.conversionService = conversionService;
        this.pageSize = pageSize;
    }

    @Transactional
    @Override
    public long save(UserRequestDto dto) {
        UserEntity entityForSaving = conversionService.convert(dto, UserEntity.class);
        if (entityForSaving == null) {
            throw new ConversionException();
        }
        UserEntity savedEntity = repository.save(entityForSaving);
        long id = savedEntity.getId();
        logger.info("user with id {} has been created", id);
        return id;
    }

    @Override
    public Page<UserResponseDto> get(int page) {
        Pageable pageable = Pageable.ofSize(pageSize).withPage(page);
        return repository.findAllByOrderByEmailAsc(pageable)
                .map(this::convert);
    }

    @Override
    public List<UserResponseDto> getAll() {
        return repository.findAllByOrderByEmailAsc()
                .stream()
                .map(this::convert)
                .collect(Collectors.toList());
    }

    private UserResponseDto convert(UserEntity entity) {
        return conversionService.convert(entity, UserResponseDto.class);
    }
}
