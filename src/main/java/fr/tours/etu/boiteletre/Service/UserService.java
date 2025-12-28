package fr.tours.etu.boiteletre.Service;


import fr.tours.etu.boiteletre.Exception.ApiException;
import fr.tours.etu.boiteletre.DTO.DtoForUser.ResponseUserDTO;
import fr.tours.etu.boiteletre.DTO.DtoForUser.UserDTO;
import fr.tours.etu.boiteletre.MappStruct.UserMapper;
import fr.tours.etu.boiteletre.Model.Reservation;
import fr.tours.etu.boiteletre.Model.ReservationId;
import fr.tours.etu.boiteletre.Model.User;
import fr.tours.etu.boiteletre.Repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import fr.tours.etu.boiteletre.Model.Role;
import java.util.ArrayList;
import java.util.List;

/**
 *  A service class for the user entity
 * @author Mamadou COULIBALY & Radia MERABTENE
 * @version 1.0
 */
@Service
@RequiredArgsConstructor
public class UserService {
    /**
     * a userRepository
     */
   private final UserRepository userRepository;

    /**
     * Reservation service to manage action related to reservation.
     */
   private final ReservationService reservationService;

    /**
     * a userMapper
     */
   private final UserMapper userMapper;
   private final PasswordEncoder passwordEncoder;

    /**
     * create a new user by default the role is set to user
     * @param userDTO
     * @return ResponseUserDTO ( hide the password)
     */
    public ResponseUserDTO createUser(UserDTO userDTO) {
        String hashedPassword = passwordEncoder.encode(userDTO.getPassword());
        userDTO.setPassword(hashedPassword);
        User user = userMapper.dtoToUser(userDTO);
        if (userDTO.getRole() != null) {
            user.setRole(userDTO.getRole());
        } else {
            user.setRole(Role.ROLE_USER);
        }
        User saveUser = userRepository.save(user);

        return new ResponseUserDTO(userMapper.userToDto(saveUser));
    }

    /**
     * read the list of the users found in the database
     * @return a list of users (ResponseUserDTO)
     */
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

    /**
     * read a user corresponding  the given id
     * @param id int the id of the user to read
     * @return ResponseUserDTO ( hiding the password)
     */
    public ResponseUserDTO getUserById(int id) {

        User user = userRepository.findById(id).orElseThrow(()-> new IllegalArgumentException("User with the id : " + id + " doesn't exist!"));

        return new ResponseUserDTO(userMapper.userToDto(user));
    }

    /**
     * update a user corresponding to the given id
     * @param id int the id of the user to update
     * @param userDTO the user object containing the new information of the user
     * @return ResponseUserDTO (hiding the password)
     */
    public ResponseUserDTO UpdateUser(int id, UserDTO userDTO) {
        return userRepository.findById(id).map(user ->{
            user.setName(userDTO.getName());
            user.setSurname(userDTO.getSurname());
            user.setEmail(userDTO.getEmail());
            user.setUsername(userDTO.getUsername());

            if (userDTO.getPassword() != null && !userDTO.getPassword().isBlank()) {
                user.setPassword(passwordEncoder.encode(userDTO.getPassword()));
            }
            User saveUser = userRepository.save(user);

            return new ResponseUserDTO(userMapper.userToDto(saveUser));

        }).orElseThrow(() -> new ApiException("User with the id : " + id + " not found. So cannot be updated!", HttpStatus.NOT_FOUND));
    }

    /**
     * delete the user corresponding the given id
     * @param id int the id of the user to update
     */
    public void deleteUser(int id) {
        User user = userRepository.findById(id).orElseThrow(()-> new IllegalArgumentException("User with the id : " + id + " not found. So cannot be deleted!"));

        List<Reservation> reservationList = this.reservationService.getAllReservations();

        for (Reservation reservation : reservationList){
            if (reservation.getBox().getBoxId() == user.getUserId()){
                ReservationId reservationId = new ReservationId(reservation.getBox().getBoxId(), reservation.getUser().getUserId());
                this.reservationService.deleteReservation(reservationId);
            }
        }

        userRepository.delete(user);
    }

}
