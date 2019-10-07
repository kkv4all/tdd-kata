package com.tdd.tripkata.trip

import static org.junit.Assert.assertEquals

import com.tdd.tripkata.exception.UserNotLoggedInException
import com.tdd.tripkata.user.User

import spock.lang.Specification

class TripServiceSpec extends Specification {
	
	private TripService tripService;

	private User loggedInUser;
	private static final User GUEST = null;
	private static final User ANOTHER_USER = new User();
	private static final User REGISTERED_USER = new User();
	
	private static final Trip UDAYPUR = new Trip();
	private static final Trip SIMLA = new Trip();

	private static final List<Trip> NO_TRIP = new ArrayList<Trip>();
	
	def setup() {
		tripService = new TripServiceSeam();
	}
	
	def "throw Exception if user not LoggedIn" () {
		given:""
			loggedInUser=GUEST;
		when:
			tripService.getTripsByUser(null);
		then: "UserNotLoggedInException is thorwn"
			thrown(UserNotLoggedInException.class)
	}
	
	def "return No Trip if User is not Friend" () {
		given:""
			User notFriend = new User();
			notFriend.addFriend(ANOTHER_USER);
			notFriend.addTrip(UDAYPUR);
			notFriend.addTrip(SIMLA);
			
			loggedInUser = REGISTERED_USER;
		when:
			def list = tripService.getTripsByUser(notFriend);
		then: "return no trip"
			NO_TRIP == list
	}
	
	class TripServiceSeam extends TripService {
		protected User getUserSession() {
			return loggedInUser;
		}
	}
}
