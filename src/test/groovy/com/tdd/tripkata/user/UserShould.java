package com.tdd.tripkata.user;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class UserShould {

	User user;
	
	private static final User ANOTHER_USER = new User();
	
	@Before
	public void setUp() throws Exception {
		user = new User();
	}

	@Test
	public void returnTrueIfUserIsFriend() {
		User friend = UserBuilder.aUser()
				.friendsWith(ANOTHER_USER,user)
				.build();
		
		assertTrue(friend.isFriendsWith(user)); 
	}
	
	@Test
	public void returnFalseIfUserIsNotFriend() {
		User notFriend = UserBuilder.aUser()
				.friendsWith(ANOTHER_USER)
				.build();
		
		assertFalse(notFriend.isFriendsWith(user)); 
	}

}
