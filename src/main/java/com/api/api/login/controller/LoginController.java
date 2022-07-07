package com.api.api.login.controller;

import com.api.api.login.service.LoginService;
import com.api.api.login.vo.LoginVO;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.codec.digest.DigestUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.*;

import javax.mail.*;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.*;

@RestController
@RequestMapping("login")
@RequiredArgsConstructor
@Slf4j
public class LoginController {

    @Qualifier("LoginService")
    @Autowired
    private LoginService loginService;

    @GetMapping
    @ResponseBody
    @CrossOrigin("*")
    public LoginVO LoginCheck(LoginVO vo) throws Exception {

        vo.setPassword(DigestUtils.sha256Hex(vo.getPassword()));
        LoginVO id = loginService.getLoginIdchack(vo);
        if (null ==  id) {
            vo.setMessage("등록된 아이디가 없습니다");
            return vo;
        }
        LoginVO login = loginService.getLoginInfo(vo);
        if (null == login) {
            vo.setMessage("비밀번호가틀렷습니다");
            return vo;
        }
        login.setMessage("로그인성공");
        return login;
    }

    @GetMapping("SignUpIdCheck")
    @ResponseBody
    @CrossOrigin("*")
    public LoginVO SignUpCheck(LoginVO vo) throws Exception {

        LoginVO id = loginService.getLoginIdchack(vo);
        if(id == null){
            vo.setMessage("사용가능한 아이디 입니다");
            return vo;
        }
        id.setMessage("해당 아이디는 사용중입니다");
        return id;
    }

    @GetMapping("getFindId")
    @ResponseBody
    @CrossOrigin("*")
    public LoginVO FindId(LoginVO vo) throws Exception {
        LoginVO id = loginService.getFindId(vo);
        if (id ==null) {
            vo.setMessage("가입된 아이디가 없습니다");
            return vo;
        }
        id.setMessage(id.getLoginId());
        return id;
    }

    @GetMapping("getFindPassword")
    @ResponseBody
    @CrossOrigin("*")
    public LoginVO FindPassword(LoginVO vo) throws Exception {

        LoginVO id = loginService.getLoginIdchack(vo);
        LoginVO phone = loginService.getFindPasswordPhone(vo);

        Random rnd = new Random();
        StringBuffer buf = new StringBuffer();
        if (id ==null) {
            vo.setMessage("가입된 아이디가 없습니다");
            return vo;
        } else if (phone==null) {
            vo.setMessage("핸드폰 번호가 잘못 되었습니다");
            return vo;
        }
        else {
            for (int i = 0; i < 10; i++) {
                if (rnd.nextBoolean()) {
                    buf.append((char) ((int) (rnd.nextInt(26)) + 97));
                } else {
                    buf.append((rnd.nextInt(10)));
                }
            }
            String email =phone.getEmail();
            sendMail(String.valueOf(buf), email);
            vo.setMessage("회원정보");
            vo.setPassword(DigestUtils.sha256Hex(String.valueOf(buf)));
            loginService.putPasswordUpdate(vo);
        }
        return vo;
    }

    public void sendMail(String passwd, String email) {

        String user = "yj90061@gmail.com";
        String password = "vqnpykuxqpicuvzk";

        Properties prop = new Properties();
        prop.put("mail.smtp.host", "smtp.gmail.com");
        prop.put("mail.smtp.port", 465);
        prop.put("mail.smtp.auth", "true");
        prop.put("mail.smtp.ssl.enable", "true");
        prop.put("mail.smtp.ssl.trust", "smtp.gmail.com");

        Session session = Session.getDefaultInstance(prop, new javax.mail.Authenticator() {
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(user, password);
            }
        });

        try {
            MimeMessage message = new MimeMessage(session);
            message.setFrom(new InternetAddress(user));
            message.addRecipient(Message.RecipientType.TO, new InternetAddress(email));
            message.setSubject("회원님의 임시번호 발급입니다.");
            message.setText("임시 비밀번호는 " + passwd);
            Transport.send(message);
        } catch (AddressException e) {
            e.printStackTrace();
        } catch (MessagingException e) {
            e.printStackTrace();
        }
    }
}
