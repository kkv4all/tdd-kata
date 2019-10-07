package com.tdd.tripkata.trip;

import java.util.ArrayList;
import java.util.List;

import com.tdd.tripkata.exception.UserNotLoggedInException;
import com.tdd.tripkata.user.User;
import com.tdd.tripkata.user.UserSession;

public class TripService {

	public List<Trip> getTripsByUser(User user, User loggedUser) throws UserNotLoggedInException {
		List<Trip> tripList = new ArrayList<Trip>();
		validateUser(loggedUser);

		if (user.isFriendsWith(loggedUser)) {
			tripList = tripsBy(user);
		}
		return tripList;
	}

	protected void validateUser(User loggedUser) {
		if (loggedUser == null) {
			throw new UserNotLoggedInException();
		}
	}

	protected List<Trip> tripsBy(User user) {
		return TripDAO.findTripsByUser(user);
	}

	protected User getUserSession() {
		return UserSession.getInstance().getLoggedUser();
	}
	
}
