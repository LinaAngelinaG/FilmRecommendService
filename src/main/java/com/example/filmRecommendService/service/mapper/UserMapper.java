package com.example.filmRecommendService.service.mapper;

import com.example.filmRecommendService.model.dto.UserDto;
import com.example.filmRecommendService.model.entity.User;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface UserMapper {

    UserDto toDto(User user);

}
