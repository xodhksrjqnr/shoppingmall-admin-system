package taewan.shoppingmall_admin.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import taewan.shoppingmall_admin.entity.Administrator;
import taewan.shoppingmall_admin.repository.administrator.AdministratorRepository;

@Service
@Transactional
public class AdministratorDetailsServiceImpl implements UserDetailsService {

    private AdministratorRepository administratorRepository;

    @Autowired
    public AdministratorDetailsServiceImpl(AdministratorRepository administratorRepository) {
        this.administratorRepository = administratorRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String userId) throws UsernameNotFoundException {
        Administrator administrator = administratorRepository.findByUserId(userId)
                .orElseThrow(() -> new UsernameNotFoundException(userId));

        return User.builder()
                .username(administrator.getUserId())
                .password(administrator.getPassword())
                .build();
    }
}
