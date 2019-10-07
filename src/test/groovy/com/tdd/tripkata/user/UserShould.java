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
		User friend = new User();
		friend.addFriend(ANOTHER_USER);
		friend.addFriend(user);
		
		assertTrue(friend.isFriendsWith(user)); 
	}
	
	@Test
	public void returnFalseIfUserIsNotFriend() {
		User notFriend = new User();
		notFriend.addFriend(ANOTHER_USER);
		
		assertFalse(notFriend.isFriendsWith(user)); 
	}

}
