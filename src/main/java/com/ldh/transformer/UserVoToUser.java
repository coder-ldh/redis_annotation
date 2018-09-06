package com.ldh.transformer;

import com.ldh.entity.User;
import com.ldh.vo.UserVo;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.factory.Mappers;

/**
 * @Author: ldh
 */
@Mapper(componentModel = "spring")
public interface UserVoToUser {

  UserVoToUser INSTANTCE = Mappers.getMapper(UserVoToUser.class);

  @Mappings({
      @Mapping(target = "userId", source = "userId"),
  })
  User mapping(UserVo userVo);
}