package com.dsaProject.DSAproject.config;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;
import com.dsaProject.DSAproject.entity.Person;
import com.dsaProject.DSAproject.entity.Roles;
import com.dsaProject.DSAproject.service.PersonService;


@Component
public class UserNamePasswordAuth implements AuthenticationProvider{
	@Autowired
	private PersonService personService;
	
	@Autowired
	private PasswordEncoder passwordEncoder;
 
	@Override
	public Authentication authenticate(Authentication authentication) throws AuthenticationException {
		// TODO Auto-generated method stub
		System.out.println("1----> "+" "+authentication.getName());
		Person person = personService.findByPersonEmail(authentication.getName());
		String pwd = authentication.getCredentials().toString();
		
		if(person!=null && passwordEncoder.matches(pwd, person.getPersonPassword()))
			return new UsernamePasswordAuthenticationToken(person.getPersonEmail(), null,getGrantedAuthorities(person.getRole()));
		return null;
	}
	
	private Collection<? extends GrantedAuthority> getGrantedAuthorities(Roles role) {
		// TODO Auto-generated method stub
		List<GrantedAuthority> grantedAuthorities = new ArrayList<>();
		grantedAuthorities.add(new SimpleGrantedAuthority(role.getRole()));
		System.out.println(grantedAuthorities);
		return grantedAuthorities;
	}

	@Override
	public boolean supports(Class<?> authentication) {
		// TODO Auto-generated method stub
		return authentication.equals(UsernamePasswordAuthenticationToken.class);
	}
	

}
