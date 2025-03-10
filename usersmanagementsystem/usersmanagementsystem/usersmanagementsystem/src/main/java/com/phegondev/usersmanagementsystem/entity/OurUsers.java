//package com.phegondev.usersmanagementsystem.entity;
//
//    import jakarta.persistence.*;
//    import lombok.Data;
//    import org.springframework.security.core.GrantedAuthority;
//    import org.springframework.security.core.authority.SimpleGrantedAuthority;
//    import org.springframework.security.core.userdetails.UserDetails;
//    import java.util.Collection;
//    import java.util.List;
//
//@Entity
//@Table(name = "ourusers")
//@Data
//public class OurUsers implements UserDetails {
//
//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    private Integer id;
//    private String email;
//    private String name;
//    private String password;
//    private String city;
//    private String role;
//
//    @Override
//    public Collection<? extends GrantedAuthority> getAuthorities() {
//
//        return List.of(new SimpleGrantedAuthority(role));
//    }
//
//    @Override
//    public String getUsername() {
//
//        return email;
//    }
//
//    @Override
//    public boolean isAccountNonExpired() {
//
//        return true;
//    }
//
//    @Override
//    public boolean isAccountNonLocked() {
//
//        return true;
//    }
//
//    @Override
//    public boolean isCredentialsNonExpired() {
//
//        return true;
//    }
//
//    @Override
//    public boolean isEnabled() {
//
//        return true;
//    }
//
//    @Override
//    public String getPassword() {  // ✅ Added this method to fix the error
//        return password;
//    }
//}


package com.phegondev.usersmanagementsystem.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import java.util.Collection;
import java.util.List;

@Entity
@Table(name = "ourusers")
@Getter
@Setter  // ✅ Explicitly adds setters to avoid issues
public class OurUsers implements UserDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String email;
    private String name;
    private String password;
    private String city;
    private String role;

    // ✅ Explicit Getters & Setters (Even though @Getter and @Setter should handle it)
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    // ✅ Implementing methods from UserDetails
    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return List.of(new SimpleGrantedAuthority(role));
    }

    @Override
    public String getUsername() {
        return email;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}
