package cz.edu.upce.fei.nnpro.security.service

import cz.edu.upce.fei.nnpro.repository.UserRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.security.core.userdetails.UserDetails
import org.springframework.security.core.userdetails.UserDetailsService
import org.springframework.security.core.userdetails.UsernameNotFoundException
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional


@Service
class UserDetailsServiceImpl : UserDetailsService {
	@Autowired
	private lateinit var userRepository: UserRepository

	@Transactional
	override fun loadUserByUsername(username: String): UserDetails {
		return UserDetailsImpl.build(
			(userRepository.findByUsername(username)
				?: throw  UsernameNotFoundException("User Not Found with username: $username"))
		)
	}
}
