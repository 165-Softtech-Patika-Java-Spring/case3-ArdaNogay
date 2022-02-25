package softtech.softtechspringboot.Controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import softtech.softtechspringboot.Dto.UserDeleteDto;
import softtech.softtechspringboot.Dto.UserSaveRequestDto;
import softtech.softtechspringboot.Service.UserService;

import java.util.List;

@RestController
@RequestMapping("/api/v1/users")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @GetMapping
    public ResponseEntity getAll(){

        List<UserSaveRequestDto> userSaveRequestDtoList = userService.findAll();
        return ResponseEntity.ok(userSaveRequestDtoList);
    }

    @GetMapping("/{id}")
    public ResponseEntity getById(@PathVariable Long id){

       UserSaveRequestDto userSaveRequestDto =  userService.findById(id);
       return ResponseEntity.ok(userSaveRequestDto);
    }

    @GetMapping
    public ResponseEntity getByName(@RequestParam String name){

        UserSaveRequestDto userSaveRequestDto = userService.findByName(name);
        return ResponseEntity.ok(userSaveRequestDto);
    }

    @PostMapping
    public ResponseEntity save(@RequestBody UserSaveRequestDto userSaveRequestDto){

        userSaveRequestDto = userService.save(userSaveRequestDto);
        return ResponseEntity.ok(userSaveRequestDto);
    }

    @PutMapping("/{id}")
    public ResponseEntity update(@PathVariable("id") Long id,@RequestBody UserSaveRequestDto userSaveRequestDto){

        userSaveRequestDto = userService.update(id,userSaveRequestDto);
        return ResponseEntity.ok(userSaveRequestDto);
    }

    @DeleteMapping
    public ResponseEntity delete(@RequestBody UserDeleteDto userDeleteDto){

        userService.delete(userDeleteDto);
        return ResponseEntity.ok(Void.TYPE);
    }
}
