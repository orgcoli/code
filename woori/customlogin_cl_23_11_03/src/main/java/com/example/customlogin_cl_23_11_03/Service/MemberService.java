package com.example.customlogin_cl_23_11_03.Service;

import com.example.customlogin_cl_23_11_03.Constant.Role;
import com.example.customlogin_cl_23_11_03.DTO.MemberDTO;
import com.example.customlogin_cl_23_11_03.Entity.MemberEntity;
import com.example.customlogin_cl_23_11_03.Repository.MemberRepository;
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
@RequiredArgsConstructor    //사용안하면  @Autowired(개별) 사용
//보안인증에 사용자 정보(UserDetailsService)
public class MemberService implements UserDetailsService {
    private final MemberRepository memberRepository;    //데이터베이스 처리
    private final ModelMapper modelMapper = new ModelMapper();  //데이터 변환
    private final PasswordEncoder passwordEncoder;  //암호를 암호화하기 위해

    //로그인 처리(커스텀 보안인증시 반드시 처리할 부분)
    @Override
    public UserDetails loadUserByUsername(String email)throws UsernameNotFoundException{
        //이메일로 회원을 조회
        MemberEntity memberEntity = memberRepository.findByEmail(email);

        if(memberEntity==null){
            throw new UsernameNotFoundException(email);
        }

        //보안 인증에서 해당데이터로 로그인처리
        return User.builder()
                .username(memberEntity.getEmail())
                .password(memberEntity.getPassword())
                .roles(memberEntity.getRole().toString())
                .build();
    }
    //회원가입처리(수동작업) - 기존 Service 프로그램 작성과 동일
    public void saveMember(MemberDTO memberDTO){
        String password = passwordEncoder.encode(memberDTO.getPassword());  //암호를 암호화처리
        //MemberEntity 에 생성자가 없으므로 수동으로 저장
        MemberEntity memberEntity = new MemberEntity();
        memberEntity.setEmail(memberDTO.getEmail());    //이메일은 중복사용이 불가능
        memberEntity.setName(memberDTO.getName()); //암호화한 내용으로 반드시 저장
        memberEntity.setPassword(password);
        memberEntity.setAddress(memberDTO.getAddress());
        memberEntity.setRole(Role.USER);    //기본 가입시 일반회원으로 등록

        validateDuplicateMember(memberEntity);  //저장할 데이터를 중복체크(신규회원 등록시에만 필요)
        memberRepository.save(memberEntity);
    }
    //이메일의 중복 체크
    private void validateDuplicateMember(MemberEntity memberEntity){
        //조회
        MemberEntity findMember = memberRepository.findByEmail(memberEntity.getEmail());
        if(findMember != null) {//이미 이메일이 존재하면
            throw new IllegalStateException("이미 가입된 회원입니다.");
        }
    }
}
