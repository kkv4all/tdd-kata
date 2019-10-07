package com.tdd.tripkata.trip;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;

import com.tdd.tripkata.exception.UserNotLoggedInException;
import com.tdd.tripkata.user.User;
import com.tdd.tripkata.user.UserBuilder;

@RunWith(MockitoJUnitRunner.class)
public class TripServiceShould {

	private TripService tripService;

	private User loggedInUser;

	private static final User GUEST = null;
	private static final User ANOTHER_USER = new User();
	private static final User REGISTERED_USER = new User();
	
	private static final Trip UDAYPUR = new Trip();
	private static final Trip SIMLA = new Trip();
	
	private static final List<Trip> NO_TRIP = new ArrayList<Trip>();
	@Mock
	private TripDAO tripDAO;

	@Before
	public void setUp() throws Exception {
		tripService = new TripService(tripDAO);
		loggedInUser = REGISTERED_USER;
	}

	@Test(expected = UserNotLoggedInException.class)
	public void throwExceptionifNotLoggedIn() {
		loggedInUser=GUEST;
		
		tripService.getTripsByUser(null,loggedInUser);
	}
	
	@Test
	public void returnNoTripIfUserIsNotFriend() throws Exception {
		User notFriend = UserBuilder.aUser()
				.friendsWith(ANOTHER_USER)
				.hasTripsTo(UDAYPUR,SIMLA)
				.build();

		List<Trip> list = tripService.getTripsByUser(notFriend,loggedInUser);
		
		assertEquals(NO_TRIP, list);
	}
	
	@Test
	public void returnTripsIfUserIsFriend() throws Exception {
		User friend = UserBuilder.aUser()
				.friendsWith(ANOTHER_USER,loggedInUser)
				.hasTripsTo(UDAYPUR,SIMLA)
				.build();
		Mockito.when(tripDAO.tripsBy(friend)).thenReturn(friend.trips());
		
		List<Trip> list = tripService.getTripsByUser(friend,loggedInUser);
		
		assertEquals(friend.trips(), list);
	}

}
