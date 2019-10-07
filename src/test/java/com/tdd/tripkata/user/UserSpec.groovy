package com.tdd.tripkata.user

import spock.lang.Specification

class UserSpec extends Specification {
	
	User user;
	
	private static final User ANOTHER_USER = new User();
	
	def setup() {
		user = new User();
	}
	def "return TRUE if User is Friend" () {
		given:""
			User friend = UserBuilder.aUser()
				.friendsWith(ANOTHER_USER,user)
				.build()
		when:
			def result = friend.isFriendsWith(user);
		then: "return TRUE"
			result == true
	}
	
	def "return FALSE if User is not Friend" () {
		given:""
			User notFriend = UserBuilder.aUser()
				.friendsWith(ANOTHER_USER)
				.build()
		when:
			def result = notFriend.isFriendsWith(user);
		then: "return FALSE"
			result == false
	}
}
