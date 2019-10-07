package com.tdd.tripkata.trip;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import com.tdd.tripkata.exception.UserNotLoggedInException;
import com.tdd.tripkata.user.User;

public class TripServiceShould {

	private TripService tripService;

	private User loggedInUser;
	private static final User GUEST = null;
	private static final User ANOTHER_USER = new User();
	private static final User REGISTERED_USER = new User();
	
	private static final Trip UDAYPUR = new Trip();
	private static final Trip SIMLA = new Trip();
	
	private static final List<Trip> NO_TRIP = new ArrayList<Trip>();


	@Before
	public void setUp() throws Exception {
		tripService = new TripServiceSeam();
	}

	@Test(expected = UserNotLoggedInException.class)
	public void throwExceptionifNotLoggedIn() {
		loggedInUser=GUEST;
		
		tripService.getTripsByUser(null);
	}
	
	@Test
	public void returnNoTripIfUserIsNotFriend() throws Exception {
		User notFriend = new User();
		notFriend.addFriend(ANOTHER_USER);
		notFriend.addTrip(UDAYPUR);
		notFriend.addTrip(SIMLA);
		
		loggedInUser = REGISTERED_USER;
		
		List<Trip> list = tripService.getTripsByUser(notFriend);
		
		assertEquals(NO_TRIP, list);
	}
	

	class TripServiceSeam extends TripService {
		protected User getUserSession() {
			return loggedInUser;
		}
	}
}
