package com.example.movie_cl_23_11_06.Service;

import com.example.movie_cl_23_11_06.Constant.Role;
import com.example.movie_cl_23_11_06.DTO.MemberDTO;
import com.example.movie_cl_23_11_06.Entity.MemberEntity;
import com.example.movie_cl_23_11_06.Repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
@RequiredArgsConstructor

public class MemberService implements UserDetailsService {
    private final MemberRepository memberRepository;
    private final ModelMapper modelMapper = new ModelMapper();
    private final PasswordEncoder passwordEncoder;

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException{
        MemberEntity memberEntity = memberRepository.findByEmail(email);

        if (memberEntity==null){
            throw new UsernameNotFoundException(email);
        }

        return User.builder()
                .username(memberEntity.getEmail())
                .password(memberEntity.getPassword())
                .roles(memberEntity.getRole().toString())
                .build();
    }

    public void saveMember(MemberDTO memberDTO){
        String password = passwordEncoder.encode(memberDTO.getPassword());

        MemberEntity memberEntity = new MemberEntity();
        memberEntity.setEmail(memberDTO.getEmail());
        memberEntity.setName(memberDTO.getName());
        memberEntity.setPassword(password);
        memberEntity.setRole(Role.USER);

        validateDuplicateMember(memberEntity);
        memberRepository.save(memberEntity);
    }

    //이메일의 중복체크
    private void validateDuplicateMember(MemberEntity memberEntity){

        MemberEntity findMember = memberRepository.findByEmail(memberEntity.getEmail());
        if(findMember != null){
            throw new IllegalStateException("이미 가입된 회원입니다.");
        }
    }
}
