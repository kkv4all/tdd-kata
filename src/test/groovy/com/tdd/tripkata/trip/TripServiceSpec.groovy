package com.tdd.tripkata.trip

import com.tdd.tripkata.exception.UserNotLoggedInException
import com.tdd.tripkata.user.User

import spock.lang.Specification

class TripServiceSpec extends Specification {
	
	private static final User GUEST = null;
	private User loggedInUser;
	
	def setup() {
		
	}
	
	def "throw Exception if user not LoggedIn" () {
		given:""
			TripService tripService = new TripServiceSeam();
			loggedInUser=GUEST;
		when:
			tripService.getTripsByUser(null);
		then: "UserNotLoggedInException is thorwn"
			thrown(UserNotLoggedInException.class)
	}
	
	class TripServiceSeam extends TripService {
		protected User getUserSession() {
			return loggedInUser;
		}
	}
}
