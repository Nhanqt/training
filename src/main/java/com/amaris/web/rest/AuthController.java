package com.amaris.web.rest;


import com.amaris.dto.request.LoginDto;
import com.amaris.dto.response.AuthResponse;
import com.amaris.entity.AccountEntity;
import com.amaris.utils.filter.JwtTokenUtil;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import javax.validation.Valid;
import javax.validation.Valid;

@RestController
@RequestMapping("api/auth")
public class AuthController {

    final AuthenticationManager authenticationManager;
    final JwtTokenUtil jwtTokenUtil;
    public AuthController(AuthenticationManager authenticationManager, JwtTokenUtil jwtTokenUtil) {
        this.authenticationManager = authenticationManager;
        this.jwtTokenUtil = jwtTokenUtil;
    }


    @PostMapping
    public ResponseEntity<?> login(@RequestBody @Valid LoginDto authRequest){
        try{
            Authentication authentication = authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(authRequest.getEmail(),authRequest.getPassword())
            );
            AccountEntity account = (AccountEntity) authentication.getPrincipal();
            String accessToken = jwtTokenUtil.generateAccessToken(account);
            AuthResponse authResponse = new AuthResponse(account.getEmail(),accessToken);
            return ResponseEntity.ok(authResponse);
        }catch (BadCredentialsException ex){
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
        }
    }
}
