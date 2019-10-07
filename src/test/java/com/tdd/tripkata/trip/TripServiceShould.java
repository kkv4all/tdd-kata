package com.tdd.tripkata.trip;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import com.tdd.tripkata.exception.UserNotLoggedInException;
import com.tdd.tripkata.user.User;

public class TripServiceShould {

	private static final User GUEST = null;
	private User loggedInUser;

	@Before
	public void setUp() throws Exception {
	}

	@Test(expected = UserNotLoggedInException.class)
	public void throwExceptionifNotLoggedIn() {
		TripService tripService = new TripServiceSeam();
		loggedInUser=GUEST;
		
		tripService.getTripsByUser(null);
	}

	class TripServiceSeam extends TripService {
		protected User getUserSession() {
			return loggedInUser;
		}
	}
}
