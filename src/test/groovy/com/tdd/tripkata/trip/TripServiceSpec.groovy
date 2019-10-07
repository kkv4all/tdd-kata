package com.tdd.tripkata.trip

import static org.junit.Assert.assertEquals

import org.omg.CORBA.FREE_MEM

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
	
	private TripDAO tripDAO = Mock();
	
	def setup() {
		tripService = new TripService(tripDAO);
		loggedInUser = REGISTERED_USER;
	}
	
	def "throw Exception if user not LoggedIn" () {
		given:""
			loggedInUser=GUEST;
		when:
			tripService.getTripsByUser(null,loggedInUser);
		then: "UserNotLoggedInException is thorwn"
			thrown(UserNotLoggedInException.class)
	}
	
	def "return No Trip if User is not Friend" () {
		given:""
			User notFriend = new User();
			notFriend.addFriend(ANOTHER_USER);
			notFriend.addTrip(UDAYPUR);
			notFriend.addTrip(SIMLA);
		when:
			def list = tripService.getTripsByUser(notFriend,loggedInUser);
		then: "return no trip"
			NO_TRIP == list
	}
	
	def "return Trips if User is Friend" () {
		given:""
			User friend = new User();
			friend.addFriend(ANOTHER_USER);
			friend.addFriend(loggedInUser);
			friend.addTrip(UDAYPUR);
			friend.addTrip(SIMLA);
			tripDAO.tripsBy(friend) >> friend.trips()
		when:
			def list = tripService.getTripsByUser(friend,loggedInUser);
		then: "return friend's trip"
			friend.trips() == list
	}
}
