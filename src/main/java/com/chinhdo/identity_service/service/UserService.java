package com.chinhdo.identity_service.service;

import com.chinhdo.identity_service.dto.request.UserCreationRequest;
import com.chinhdo.identity_service.dto.request.UserUpdateRequest;
import com.chinhdo.identity_service.dto.response.UserResponse;
import com.chinhdo.identity_service.entity.User;
import com.chinhdo.identity_service.enums.Role;
import com.chinhdo.identity_service.exception.AppException;
import com.chinhdo.identity_service.exception.ErrorCode;
import com.chinhdo.identity_service.mapper.UserMapper;
import com.chinhdo.identity_service.repository.UserRepository;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor //tao constructor cho all bien define la final, ko can di bang autowired
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true) //mac dinh la private final
public class UserService {

    UserRepository userRepository;
    UserMapper userMapper;
    PasswordEncoder passwordEncoder;

    public UserResponse createUser(UserCreationRequest request){

        if(userRepository.existsByUsername(request.getUsername())){
            throw new AppException(ErrorCode.USER_EXISTED);
        }

        User user = userMapper.toUser(request); //map request voi user
        //ma hoa password
        user.setPassword(passwordEncoder.encode(request.getPassword()));//ma hoa

        HashSet<String> roles = new HashSet<>();
        roles.add(Role.USER.name());
        user.setRoles(roles);

        User savedUser = userRepository.save(user);

        // Chuyển đổi User sang UserResponse trước khi trả về
        return userMapper.toUserResponse(savedUser);
    }

    public List<UserResponse> getUsers(){
        return userRepository.findAll()
                .stream()
                .map(userMapper::toUserResponse) // Ánh xạ User -> UserResponse
                .collect(Collectors.toList());
    }

    public UserResponse getUser(String id){
        return userMapper.toUserResponse(userRepository.findById(id).orElseThrow(() -> new RuntimeException("User not found! =))")));
    }

    public UserResponse updateUser(String userId,UserUpdateRequest request){
        User user = userRepository.findById(userId).orElseThrow(() -> new RuntimeException("User not found! =))"));
        userMapper.updateUser(user,request);

        return userMapper.toUserResponse(userRepository.save(user));
    }

    public void deleteUser(String userId){
        userRepository.deleteById(userId);
    }
}
