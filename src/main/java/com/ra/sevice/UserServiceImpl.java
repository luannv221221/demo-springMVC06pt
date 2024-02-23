package com.ra.sevice;

import com.ra.model.dao.UserDAO;
import com.ra.model.entity.User;
import org.mindrot.jbcrypt.BCrypt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpSession;

@Service
public class UserServiceImpl implements UserService{
    @Autowired
    private UserDAO userDAO;
    @Autowired
    private HttpSession httpSession;
    @Override
    public boolean register(User user) {
        // ma hoa mat khau
        String passwordHash = BCrypt.hashpw(user.getPassword(),BCrypt.gensalt(12));
        user.setPassword(passwordHash);
        return userDAO.save(user);
    }

    @Override
    public boolean login(String email, String password) {
        User user = userDAO.findByEmail(email);
        if(user != null){
            // check password
            if(BCrypt.checkpw(password, user.getPassword())){
                httpSession.setAttribute("user",user);
                return true;
            }
        }
        return false;
    }
}
