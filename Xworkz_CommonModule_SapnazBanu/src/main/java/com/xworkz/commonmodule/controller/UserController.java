package com.xworkz.commonmodule.controller;


import com.xworkz.commonmodule.constants.LocationConstants;
import com.xworkz.commonmodule.dto.UserDTO;
import com.xworkz.commonmodule.entity.UserEntity;
import com.xworkz.commonmodule.repository.UserRepository;
import com.xworkz.commonmodule.service.UserService;
import org.apache.commons.io.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;


import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import java.io.*;
import java.nio.file.Path;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


@RequestMapping("/")
@Controller
public class UserController {
    @Autowired
    UserService userService;
    @Autowired
    UserRepository userRepo;

    List<LocationConstants> locationList=new ArrayList<>(Arrays.asList(LocationConstants.values()));

    UserController() {
        System.out.println("no arg const of controller");
    }

    @PostMapping("/signUp")
    public String signUp(Model model, @Valid UserDTO userDto, BindingResult bindingResult) {
        if (!bindingResult.hasErrors()) {
            boolean isSaved = userService.validAndSave(userDto);
            if (isSaved) {
                model.addAttribute("message", "SignUp Successful!");
                return "Signin";
            }
        }
        model.addAttribute("error", bindingResult.getAllErrors());
        model.addAttribute("user", userDto);
        return "Signup";
    }


    @GetMapping(value = "/signUpAgain")
    public String signUpAgain(Model model) {
        List<LocationConstants> locationList = new ArrayList<>(Arrays.asList(LocationConstants.values()));
        locationList.forEach(n -> System.out.println(n));
        model.addAttribute("locationListSend", locationList);
        return "Signup";
    }

    @GetMapping(value = "/updateAgain")
    public String updateAgain(Model model) {
        List<LocationConstants> locationList = new ArrayList<>(Arrays.asList(LocationConstants.values()));
        locationList.forEach(n -> System.out.println(n));
        model.addAttribute("locationListSend", locationList);
        return "UpdateProfile";
    }


    @PostMapping(value = "/updateProfile")
    public String updateProfile(@RequestParam String email,
                                @RequestParam String name,
                                @RequestParam String location,
                                @RequestParam Long altPhone,
                                @RequestParam Long phone,
                                @RequestParam String altEmail,
                                @RequestParam("pic") MultipartFile multipartFile1,
                                Model model) throws IOException {

        // Update user entity
        UserEntity updatedUser = userService.updateUserEntity(email, name, location, altPhone, phone, altEmail);

        if (updatedUser == null) {
            model.addAttribute("errorIs", "Profile update failed");
            model.addAttribute("locationListSend", locationList);
            model.addAttribute("user", updatedUser);
            return "UpdateProfile";
        }

        // Handle image upload if present
        if (!multipartFile1.isEmpty()) {
            String filePath = saveImage(multipartFile1);  // Save the image and get the file name
            updatedUser.setImagePath(filePath);
            userRepo.save(updatedUser);

            // Pass the file name to the view for the image display
            model.addAttribute("fileName", filePath); // Set the image filename in the model

            model.addAttribute("message", "Profile updated successfully with image.");
            return "FinalSuccess";  // This will forward to the success page
        }

        model.addAttribute("errorIsIn", "Image upload failed.");
        model.addAttribute("locationListSend", locationList);
        model.addAttribute("user", updatedUser);
        return "UpdateProfile";  // Return to update profile page if upload failed
    }




    private String saveImage(MultipartFile multipartFile) throws IOException {
        // Get the current time to make the file name unique
        Path path = Paths.get("D:\\commons\\" + System.currentTimeMillis() + ".jpg");
        byte[] bytes = multipartFile.getBytes();

        // Write the file to the path
        Files.write(path, bytes);

        // Get the file name as a string
        String filePath = path.getFileName().toString();
        System.out.println("filepath: " + filePath);

        return filePath;
    }




    @PostMapping(value = "/SigninServlet")
    public String signIn(@RequestParam String email, @RequestParam String password, Model model) {
        UserEntity userEntity = userService.getUserByEmail(email);
        if (userEntity == null) {
            System.out.println("user is found null");
            model.addAttribute("locationListSend", locationList);
            return "Signup";
        }
        if (userEntity.getCount() == -1) {
            return "ResetPassword";
        }
        if (userEntity.getLocked()== true && userEntity.getLockTime() != null) {

            long hoursLocked = ChronoUnit.MINUTES.between(userEntity.getLockTime(), LocalDateTime.now());
            if (hoursLocked >= 5) {
                userEntity.setLocked(false);
                userEntity.setFailedAttempts(0);
                userEntity.setLockTime(null);
                userRepo.save(userEntity);
            } else {
                model.addAttribute("lock", "Your account is locked due to too many failed login attempts. Please try again later.");
                return "Signin";
            }
        }
//        if (userEntity.getFailedAttempts() > 3) {
//             model.addAttribute("lock", "Your account is locked due to too many failed login attempts. Please try again later.");
//            return "SignUp";
//        }

        String storedPassword = userEntity.getPassword();
        if (!storedPassword.equals(password)) {
            userEntity.setFailedAttempts(userEntity.getFailedAttempts() + 1);

            if (userEntity.getFailedAttempts() > 3){
                userEntity.setLocked(true);
                userEntity.setLockTime(LocalDateTime.now());
                userRepo.save(userEntity);
                model.addAttribute("say", "Your Account has locked try again after 24 hours");
                return "Signin";
            } else {
                userRepo.save(userEntity);
                int remainingAttempts = 3 - userEntity.getFailedAttempts();
                model.addAttribute("error", "Incorrect password. You have " + remainingAttempts + " attempts remaining.");
                return "Signin";
            }
        } else {
            userEntity.setFailedAttempts(0);
            userRepo.save(userEntity);
        }
        //model.addAttribute("name", userEntity.getName());
        return "Success";
    }


    @PostMapping("/resetPassword")
    public String resetPassword(@RequestParam String email, @RequestParam String newPassword, Model model, String oldPassword) {
        UserEntity userEntity = userService.getUserByEmail(email);

        if (userEntity != null) {
            if (userEntity.getCount() == -1) {
                if (userEntity.getPassword().equals(oldPassword)) {
                    userEntity.setPassword(String.valueOf(newPassword));
                    userEntity.setCount(1);
                    userRepo.save(userEntity);
                    return "Success";
                } else {
                    return "ResetPassword";

                }
            } else {

                return "Signin";
            }
        } else {

            return "Signup";
        }
    }

    @PostMapping("/forgotPassword")
    public String forgotPassword(@RequestParam String newPassword, @RequestParam String email, Model model ,String confirmPassword) {
        String updatePassword = userService.forgotPassword(email, newPassword);

        if (updatePassword != null && newPassword.equals(confirmPassword)) {
            model.addAttribute("forgotPasswordSuccess", "You Have Successfully changed Your Password");
            model.addAttribute("email", email);
            return "ForgotPasswordSuccess";  // Success view
        }

        model.addAttribute("ForgotError", "Something went wrong, try again!");
        return "ForgotPassword";  // Failure view
    }



    @GetMapping("/download")
    public void display(HttpServletResponse response, @RequestParam String fileName) throws Exception {
        System.out.println("File name is: " + fileName);

        // Set content type to image (you can change this if you want to serve other formats)
        response.setContentType("image/jpeg"); // Or use a generic image type if you support multiple formats

        // Define the file path where images are stored (make sure it's correct)
        File file = new File("D:\\commons\\" + fileName);

        // Check if file exists
        if (!file.exists()) {
            response.sendError(HttpServletResponse.SC_NOT_FOUND);  // Send 404 if file not found
            return;
        }

        // Open the file input stream and output stream
        InputStream in = new BufferedInputStream(new FileInputStream(file));
        ServletOutputStream out = response.getOutputStream();


        // Copy the file contents to the response output stream
        IOUtils.copy(in, out);
        response.flushBuffer();  // Ensure the response is sent to the client

        // Close resources
        in.close();
        out.close();
    }



//    @GetMapping("/download")
//    public String display(Model model, String email){
//        SignupEntity entity = signUpService.getData(email);
//        String fileName = entity.getFilename();
//        model.addAttribute("fileName", fileName);
//        return "ViewImage";
//    }



}