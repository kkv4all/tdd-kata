package com.tdd.tripkata.trip

import com.tdd.tripkata.user.User

import spock.lang.Specification

class TripServiceSpec extends Specification {
	
	private static final User GUEST = null;
	
	def setup() {
		
	}
	
	def "throw Exception if user not LoggedIn" () {
		given:""
		TripService tripService = new TripService();
		
		when:
			tripService.getTripsByUser(null);
		then: "UserNotLoggedInException is thorwn"
			thrown(UserNotLoggedInException.class)
	}
}
