package fr.tours.etu.boiteletre.Service;


import fr.tours.etu.boiteletre.Configuration.ApiException;
import fr.tours.etu.boiteletre.DTO.DtoForUser.ResponseUserDTO;
import fr.tours.etu.boiteletre.DTO.DtoForUser.UserDTO;
import fr.tours.etu.boiteletre.MappStruct.UserMapper;
import fr.tours.etu.boiteletre.Model.User;
import fr.tours.etu.boiteletre.Repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class UserService {

   private final UserRepository userRepository;
   private final UserMapper userMapper;

    public ResponseUserDTO createUser(UserDTO userDTO) {

        User user = userMapper.dtoToUser(userDTO);

        User saveUser = userRepository.save(user);

        return new ResponseUserDTO(userMapper.userToDto(saveUser));
    }

    public List<ResponseUserDTO> getAllUser() {

        List<User> userList = userRepository.findAll();
        List<ResponseUserDTO> responseUserDTOList = new ArrayList<>();

        if (!userList.isEmpty()){
            for (User u : userList){
                responseUserDTOList.add(new ResponseUserDTO(userMapper.userToDto(u)));
            }
        }

        return responseUserDTOList;
    }

    public ResponseUserDTO getUserById(int id) {

        User user = userRepository.findById(id).orElseThrow(()-> new IllegalArgumentException("User with the id : " + id + " doesn't exist!"));

        return new ResponseUserDTO(userMapper.userToDto(user));
    }

    public ResponseUserDTO UpdateUser(int id, UserDTO userDTO) {
        return userRepository.findById(id).map(user ->{
            user.setName(userDTO.getName());
            user.setSurname(userDTO.getSurname());
            user.setEmail(userDTO.getEmail());
            user.setPassword(userDTO.getPassword());
            user.setUsername(userDTO.getUsername());

            User saveUser = userRepository.save(user);

            return new ResponseUserDTO(userMapper.userToDto(saveUser));

        }).orElseThrow(() -> new ApiException("User with the id : " + id + " not found. So cannot be updated!", HttpStatus.NOT_FOUND));
    }

    public void deleteUser(int id) {
        User user = userRepository.findById(id).orElseThrow(()-> new IllegalArgumentException("User with the id : " + id + " not found. So cannot be deleted!"));
        userRepository.delete(user);
    }

}
