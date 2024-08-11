package com._tucs212.VitalEcho.auth;



// import com._tucs212.VitalEcho.config.JwtService;
// import com._tucs212.VitalEcho.model.Token;
// import com._tucs212.VitalEcho.model.Customer;
// import com._tucs212.VitalEcho.repo.TokenRepo;
// import com._tucs212.VitalEcho.repo.CustomerRepository;
// import lombok.RequiredArgsConstructor;
// import org.springframework.security.authentication.AuthenticationManager;
// import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
// import org.springframework.security.crypto.password.PasswordEncoder;
// import org.springframework.stereotype.Service;

// @Service
// @RequiredArgsConstructor
// public class AuthenticationService {


//     private final CustomerRepository userRepo;
//     private final PasswordEncoder passwordEncoder;
//     private final JwtService jwtService;
//     private final AuthenticationManager authenticationManager;
//     private final TokenRepo tokenRepo;

//     public AuthenticationResponse register(RegisterRequest request) {
        

//         var user  = Customer.builder()
//                 .name(request.getName())
//                 .email(request.getEmail())
//                 .password(passwordEncoder.encode(request.getPassword()))
//                 .role(request.getRole())
//                 .build();
//         userRepo.save(user);
//         var jwtToken = jwtService.generateToken(user);
//         return AuthenticationResponse.builder()
//                 .token(jwtToken)
//                 .build();
//     }

//     public AuthenticationResponse authenticate(AuthenticationRequest request) {
//         authenticationManager.authenticate(
//                 new UsernamePasswordAuthenticationToken(
//                         request.getEmail(),
//                         request.getPassword()
//                 )
//         );
//         var user = userRepo.findByEmail(request.getEmail()).orElseThrow();
//         var jwtToken = jwtService.generateToken(user);
//         revokeAllUserTokens(user);
//         saveUserToken(user, jwtToken);
//         return AuthenticationResponse.builder()
//                 .token(jwtToken)
//                 .role(user.getRole())
//                 .build();

//     }

//     private void saveUserToken(Customer customer, String accessToken) {
//         var token = Token.builder().customer(customer).token(accessToken).expired(false).revoked(false).build();
//         tokenRepo.save(token);
//     }

//     private void revokeAllUserTokens(Customer customer) {
//         var validUserTokens = tokenRepo.findAllByCustomer_IdAndExpiredFalseAndRevokedFalse(customer.getId());
//         if (validUserTokens.isEmpty())
//             return;
//         validUserTokens.forEach(token -> {
//             token.setExpired(true);
//             token.setRevoked(true);
//         });
//         tokenRepo.saveAll(validUserTokens);
//     }

//     public void logout(String username) {
//         System.out.println("Logout Functionality Called");
//         var user = userRepo.findByEmail(username).orElseThrow();
//         revokeAllUserTokens(user);
//     }


// }
// AuthenticationService.java


// import com._tucs212.VitalEcho.config.JwtService;
// import com._tucs212.VitalEcho.enums.Role;
// import com._tucs212.VitalEcho.model.Token;
// import com._tucs212.VitalEcho.model.Customer;
// import com._tucs212.VitalEcho.repo.TokenRepo;
// import com._tucs212.VitalEcho.repo.CustomerRepository;
// import lombok.RequiredArgsConstructor;
// import org.springframework.security.authentication.AuthenticationManager;
// import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
// import org.springframework.security.crypto.password.PasswordEncoder;
// import org.springframework.stereotype.Service;

// import java.util.Optional;

// @Service
// @RequiredArgsConstructor

// public class AuthenticationService implements AuthService {

//     private final CustomerRepository userRepo;
//     private final PasswordEncoder passwordEncoder;
//     private final JwtService jwtService;
//     private final AuthenticationManager authenticationManager;
//     private final TokenRepo tokenRepo;

//     public AuthenticationResponse register(RegisterRequest request) {
//         // Check if the email is already registered
//         Optional<Customer> existingUser = userRepo.findByEmail(request.getEmail());
//         if (existingUser.isPresent()) {
//             throw new RuntimeException("Email already registered");
//         }
    
//         var user = Customer.builder()
//                 .name(request.getName())
//                 .email(request.getEmail())
//                 .password(passwordEncoder.encode(request.getPassword()))
//                 .role(request.getRole())
//                 .build();
//         userRepo.save(user);
    
//         var jwtToken = jwtService.generateToken(user);
//         return AuthenticationResponse.builder()
//                 .token(jwtToken)
//                 .role(user.getRole()) 
//                 .build();
//     }

//     public AuthenticationResponse authenticate(AuthenticationRequest request) {
//         authenticationManager.authenticate(
//                 new UsernamePasswordAuthenticationToken(
//                         request.getEmail(),
//                         request.getPassword()
//                 )
//         );
//         var user = userRepo.findByEmail(request.getEmail()).orElseThrow();
//         var jwtToken = jwtService.generateToken(user);
//         revokeAllUserTokens(user);
//         saveUserToken(user, jwtToken);
//         return AuthenticationResponse.builder()
//                 .token(jwtToken)
//                 .role(user.getRole()) // Include role in response
//                 .build();
//     }

//     private void saveUserToken(Customer customer, String accessToken) {
//         var token = Token.builder().customer(customer).token(accessToken).expired(false).revoked(false).build();
//         tokenRepo.save(token);
//     }

//     private void revokeAllUserTokens(Customer customer) {
//         var validUserTokens = tokenRepo.findAllByCustomer_IdAndExpiredFalseAndRevokedFalse(customer.getId());
//         if (validUserTokens.isEmpty())
//             return;
//         validUserTokens.forEach(token -> {
//             token.setExpired(true);
//             token.setRevoked(true);
//         });
//         tokenRepo.saveAll(validUserTokens);
//     }

//     public void logout(String username) {
//         System.out.println("Logout Functionality Called");
//         var user = userRepo.findByEmail(username).orElseThrow();
//         revokeAllUserTokens(user);
//     }

//     @Override
//     public String createAdmin() {
//         Optional<Customer> userExist = userRepo.findByEmail("admin@gmail.com");
//         if (userExist.isPresent()) {
//             return "User already exists with email id - admin@gmail.com";
//         }

//         var user = Customer.builder()
//                 .name("Admin")
//                 .email("admin@gmail.com")
//                 .password(passwordEncoder.encode("1811321"))
//                 .role(Role.ADMIN)
//                 .build();
//         userRepo.save(user);
//         return "Admin registered successfully.";

//     }
// }



import com._tucs212.VitalEcho.config.JwtService;
import com._tucs212.VitalEcho.enums.Role;
import com._tucs212.VitalEcho.model.Token;
import com._tucs212.VitalEcho.model.Customer;
import com._tucs212.VitalEcho.repo.TokenRepo;
import com._tucs212.VitalEcho.repo.CustomerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class AuthenticationService implements AuthService {

    private final CustomerRepository customerRepo;
    private final PasswordEncoder passwordEncoder;
    private final JwtService jwtService;
    private final AuthenticationManager authenticationManager;
    private final TokenRepo tokenRepo;

    public AuthenticationResponse register(RegisterRequest request) {
        Optional<Customer> existingUser = customerRepo.findByEmail(request.getEmail());
        if (existingUser.isPresent()) {
            throw new RuntimeException("Email already registered");
        }

        var user = Customer.builder()
                .name(request.getName())
                .email(request.getEmail())
                .password(passwordEncoder.encode(request.getPassword()))
                .role(request.getRole())
                .build();
        customerRepo.save(user);

        var jwtToken = jwtService.generateToken(user);
        return AuthenticationResponse.builder()
                .token(jwtToken)
                .role(user.getRole())
                .build();
    }

    public AuthenticationResponse authenticate(AuthenticationRequest request) {
        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        request.getEmail(),
                        request.getPassword()
                )
        );
        var user = customerRepo.findByEmail(request.getEmail()).orElseThrow();
        var jwtToken = jwtService.generateToken(user);
        revokeAllUserTokens(user);
        saveUserToken(user, jwtToken);
        return AuthenticationResponse.builder()
                .token(jwtToken)
                .role(user.getRole())
                .build();
    }

    private void saveUserToken(Customer customer, String accessToken) {
        var token = Token.builder().customer(customer).token(accessToken).expired(false).revoked(false).build();
        tokenRepo.save(token);
    }

    private void revokeAllUserTokens(Customer customer) {
        var validUserTokens = tokenRepo.findAllByCustomer_IdAndExpiredFalseAndRevokedFalse(customer.getId());
        if (validUserTokens.isEmpty())
            return;
        validUserTokens.forEach(token -> {
            token.setExpired(true);
            token.setRevoked(true);
        });
        tokenRepo.saveAll(validUserTokens);
    }

    public void logout(String username) {
        var user = customerRepo.findByEmail(username).orElseThrow();
        revokeAllUserTokens(user);
    }

    @Override
    public String createAdmin() {
        Optional<Customer> userExist = customerRepo.findByEmail("admin@gmail.com");
        if (userExist.isPresent()) {
            return "User already exists with email id - admin@gmail.com";
        }

        var user = Customer.builder()
                .name("Admin")
                .email("admin@gmail.com")
                .password(passwordEncoder.encode("1811321"))
                .role(Role.ADMIN)
                .build();
        customerRepo.save(user);
        return "Admin registered successfully.";
    }
}