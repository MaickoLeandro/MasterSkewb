package br.edu.ufersa.masterSkewb.features.auth;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
class UserDetailImpl implements UserDetailsService {
    private final  UserRepository userRepository;

    public UserDetailImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return userRepository.findByEmailEmail(username).orElseThrow(
                () -> new UsernameNotFoundException("Usuário não encontrado" + username)
        );
    }
}
