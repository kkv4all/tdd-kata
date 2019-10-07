package com.tdd.tripkata.trip;

import java.util.ArrayList;
import java.util.List;

import com.tdd.tripkata.exception.UserNotLoggedInException;
import com.tdd.tripkata.user.User;
import com.tdd.tripkata.user.UserSession;

public class TripService {

	public List<Trip> getTripsByUser(User user) throws UserNotLoggedInException {
		List<Trip> tripList = new ArrayList<Trip>();
		User loggedUser = getUserSession();
		if (loggedUser != null) {
			if (user.isFriendsWith(loggedUser)) {
				tripList = tripsBy(user);
			}
			return tripList;
		} else {
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
