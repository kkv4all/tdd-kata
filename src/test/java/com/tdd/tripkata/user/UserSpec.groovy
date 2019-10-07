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
			User friend = new User();
			friend.addFriend(ANOTHER_USER);
			friend.addFriend(user);
		when:
			def result = friend.isFriendsWith(user);
		then: "return TRUE"
			result == true
	}
	
	def "return FALSE if User is not Friend" () {
		given:""
			User notFriend = new User();
			notFriend.addFriend(ANOTHER_USER);
		when:
			def result = notFriend.isFriendsWith(user);
		then: "return FALSE"
			result == false
	}
}
