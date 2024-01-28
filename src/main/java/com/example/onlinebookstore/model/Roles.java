package com.example.onlinebookstore.model;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

import java.util.Collection;
import java.util.Collections;

public enum Roles {
   ADMIN,
   CUSTOMER;

   public Collection<? extends GrantedAuthority> authorities(){
      return Collections.singleton(new SimpleGrantedAuthority(this.name()));
   }
}
