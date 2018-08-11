package com.deep.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.deep.dao.UserDao;
import com.deep.model.User;

@Service(value = "userService")
public class UserServiceImpl implements UserDetailsService, UserService  {

	@Autowired
	private UserDao userdao;
	
	@Override
	public User save(User user) {
		return userdao.save(user);
	}

	@Override
	public List<User> findAll() {
		List<User> list = new ArrayList<>();
        userdao.findAll().iterator().forEachRemaining(list::add);
        return list;
	}

	@Override
	public void delete(long id) {
		userdao.deleteById(id);
		
	}

	@Override
	public UserDetails loadUserByUsername(String userId) throws UsernameNotFoundException {
		User user = userdao.findByUsername(userId);
        if (user == null) {
            throw new UsernameNotFoundException("Invalid username or password.");
        }
        return new org.springframework.security.core.userdetails.User(String.valueOf(user.getId()), user.getPassword(), getAuthority());
	}

	private List<SimpleGrantedAuthority> getAuthority() {
        return Arrays.asList(new SimpleGrantedAuthority("ROLE_ADMIN"));
    }
}
